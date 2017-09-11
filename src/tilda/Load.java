/* ===========================================================================
 * Copyright (C) 2017 CapsicoHealth Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tilda;

import java.awt.Dialog.ModalExclusionType;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.loader.csv.ImportProcessor;
import tilda.loader.parser.Config;
import tilda.loader.parser.DataObject;
import tilda.loader.ui.ConnectionsTableModel;
import tilda.loader.ui.DataImportTableModel;
import tilda.utils.TextUtil;
import tilda.db.Connection;
import tilda.db.ConnectionPool;

public class Load
  {
    protected static final Logger LOG               = LogManager.getLogger(Load.class.getName());
    Load                          app               = null;
    
    private static Object[][]     data              = null;
    private static Object[][]     connections       = null;
    private static Config         Conf              = null;
    
    private JFrame                frmDataImport;

    // UI
    JLabel                        statusLabel       = new JLabel("");
    JButton                       btnRun            = new JButton("Run Import");
    JButton                       btnCancel         = new JButton("Cancel");
    
    // Main
    public static void main(String[] argsArray)
    throws Exception
      {
        List<String> arguments = new ArrayList<>(Arrays.asList(argsArray));
        
        if ( !isValidArguments(arguments) ) 
          {
            PrintUsageHint();
            System.exit(-1);
          }
        
        LOG.info("\n*************************************************************************************************************************************");
        ConnectionPool.autoInit();
        LOG.info("\n*************************************************************************************************************************************\n");

        String[] silentModePair = arguments.get(0).split("=");
        arguments.remove(0);
        boolean isSilentMode = Integer.parseInt(silentModePair[1]) == 1;
       
        if (isSilentMode)
          {
            
            LOG.debug("Starting the utility in silent mode.");
            
            for(int i = 0; i < arguments.size() ; i += 6)
              {
                String ConfigFileName = arguments.get(i+1);
                Conf = Config.fromFile(ConfigFileName);

                LOG.debug("Processing file " + ConfigFileName);
                List<String> selectedObjectsList = new ArrayList<>(Arrays.asList(arguments.get(i+3).split(",")));
                List<String> connectionIdsList = new ArrayList<>(Arrays.asList(arguments.get(i+5).split(",")));
                StartImportProcessor(selectedObjectsList, connectionIdsList, Conf, Conf._CmsData);
              }
            LOG.debug("Import Tables completed.");
          }
        else
          {
            String ConfigFileName = arguments.get(1);
            Conf = Config.fromFile(ConfigFileName);
            
            List<DataObject> list = Conf._CmsData;
            data = new Object[list.size()][2];
            for (int i = 0; i < list.size(); ++i)
              {
                DataObject DO = list.get(i);
                if (DO == null)
                  continue;
                String schemaName = DO._SchemaName;
                String tableName = DO._TableName;
                String schemaPlusTable = schemaName + "." + tableName;
                data[i][0] = schemaPlusTable; // .toUpperCase();
                data[i][1] = new Boolean(false);
              }
            
            // Multi-Tenancy Logic
            Map<String, String> allConnections = ConnectionPool.getAllDataSourceIds();
            Iterator<String> iterator = allConnections.keySet().iterator();
            connections = new Object[allConnections.size()][3];
            int i = 0;
            while(iterator.hasNext())
              {
                String id = iterator.next();
                String url = allConnections.get(id);
                connections[i][0] = id;
                connections[i][1] = url;
                connections[i][2] = new Boolean(false);
              }              
            
            EventQueue.invokeLater(new Runnable()
              {
                public void run()
                  {
                    try
                      {
                        Load window = new Load();
                        window.frmDataImport.setVisible(true);
                      }
                    catch (Exception e)
                      {
                        e.printStackTrace();
                      }
                  }
              });
          }
      }

    private static void StartImportProcessor(List<String> selectedObjectNames, List<String> connectionIdsList, Config conf, List<DataObject> _CmsData) 
    throws Exception
      {
        List<DataObject> filteredObjects = FilterObjects(selectedObjectNames, _CmsData);
        if (connectionIdsList.size() > 0 && filteredObjects.size() > 0)
          RunImportProcessor(connectionIdsList, conf, filteredObjects);
      }

    private static List<DataObject> FilterObjects(List<String> selectedObjects, List<DataObject> AllDataObjects)
      {
        List<DataObject> filteredList = new ArrayList<>();
        
        Iterator<DataObject> iterator = AllDataObjects.iterator();
        while(iterator.hasNext())
          {
            DataObject dataObject = iterator.next();
            String tempObjectName = dataObject._SchemaName + "." + dataObject._TableName;
            if(selectedObjects.contains(tempObjectName) == true)
              filteredList.add(dataObject);
          }
        return filteredList;
      }

    private static void RunImportProcessor(List<String> connectionIdsList, Config Conf, List<DataObject> dataObjects)
    throws Exception
      {
        Connection C = null;
        Iterator<String> connectionIterator = connectionIdsList.iterator();
        if ( "ALL".equals(connectionIdsList.get(0)) )
          {
            connectionIterator = ConnectionPool.getAllDataSourceIds().keySet().iterator();
          }                      
        else if ( "ALL_TENANTS".equals(connectionIdsList.get(0)) )
          {
            connectionIterator = ConnectionPool.getAllTenantDataSourceIds().keySet().iterator(); 
          }
        while(connectionIterator.hasNext())
          {
            C = ConnectionPool.get(connectionIterator.next());
            LOG.debug("Running ImportProcessor");
            ImportProcessor.process(C, Conf, dataObjects);
            C = null;
          }
      }

    private static boolean isValidArguments(List<String> arguments)
      {
        if (arguments.size() < 3)
            return false;

        String[] silentModePair = arguments.get(0).split("=");
        
        if (silentModePair != null && silentModePair.length != 2)
          return false;

        if (silentModePair[0].equalsIgnoreCase("-silentMode") == false)
          return false;

        int mode = -1;
        try {
          mode = Integer.parseInt(silentModePair[1]);
        } catch (Exception E) {
          return false;
        }
        
        if (mode == 1)
          { // CLI Mode
            if ( (arguments.size() % 6) != 1 )
              return false;
            
            for ( int i = 1; i < arguments.size(); i += 6)
              {
                if ( !"-f".equals(arguments.get(i)) || TextUtil.isNullOrEmpty(arguments.get(i+1))
                  || !"-o".equals(arguments.get(i+2)) || TextUtil.isNullOrEmpty(arguments.get(i+3))
                  || !"-c".equals(arguments.get(i+4)) || TextUtil.isNullOrEmpty(arguments.get(i+5)) )
                  return false;
              }
          }
        else if ( !"-f".equals(arguments.get(1)) || TextUtil.isNullOrEmpty(arguments.get(2)) ) 
          {
            return false;
          }
          

        return true;
      }

    private static void PrintUsageHint()
      {
        LOG.error("");
        LOG.error("Load utility *must* be called with following parameters :");
        LOG.error("*** UI Mode");
        LOG.error("    -silentMode=0 -f <filepath>");
        LOG.error("ex: -silentMode=0 -f com/c/c/data/config.C.json");
        LOG.error("");
        LOG.error("*** CLI Mode");
        LOG.error("    -silentMode=1 -f <filepath>                 -o <object_name>,<object_name>,..   -c <connection_id>,... ");
        LOG.error("ex: -silentMode=1 -f com/c/c/data/config.C.json -o cms.HCPCS_CODES,cms.CPT_CODES    -c MAIN,KEYS");
        LOG.error("");        
        LOG.error("*** for Multi Tenant System.");
        LOG.error("    ALL           = All Connection Ids. Except 'KEYS'");
        LOG.error("    ALL_TENANTS   = All Connection Ids. Except 'MAIN' & 'KEYS'");
        LOG.error("");        
      }

    // Constructor
    public Load()
      {
        initialize();
        this.app = this;
      }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize()
      {

        try
          {
            UIManager.setLookAndFeel(
              UIManager.getSystemLookAndFeelClassName());
          }
        catch (Exception e)
          {
            e.printStackTrace();
          }

        
        JScrollPane           scroller1, scroller2;
        JTable                table1,    table2;

        
        frmDataImport = new JFrame();
        frmDataImport.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
        frmDataImport.setTitle("CapsicoHealth Data Import");
        frmDataImport.setType(Type.POPUP);
        frmDataImport.setBounds(100, 100, 938, 828);
        frmDataImport.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmDataImport.getContentPane().setLayout(null);
        frmDataImport.setResizable(false);


        btnRun.addActionListener(new ActionListener()
          {
            public void actionPerformed(ActionEvent e)
              {
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to run the data import?", "Warning", dialogButton);
                if (dialogResult == 0)
                  {
                    // List<String> truncateTables = new ArrayList<String>();
                    List<String> ImportTables = new ArrayList<String>();
                    List<String> ConnectionIds = new ArrayList<String>();

                    EventQueue.invokeLater(new Runnable()
                      {
                        public void run()
                          {
                            try
                              {
                                frmDataImport.setVisible(false);
                                for (int i = 0; i < data.length; ++i)
                                  {
                                    Boolean ImportValue = (Boolean) data[i][1];
                                    if (ImportValue == true)
                                      ImportTables.add((String) data[i][0]);
                                  }

                                for (int i = 0; i < connections.length ; i++)
                                  {
                                    Boolean connection = (Boolean) connections[i][2];
                                    if(connection == true)
                                      ConnectionIds.add((String) connections[i][0]);
                                  }                                
                                
                                StartImportProcessor(ImportTables, ConnectionIds, Conf,  Conf._CmsData);
                                LOG.debug("Import Tables completed.");
                              }
                            catch (Exception e)
                              {
                                LOG.error(e);
                              }
                            System.exit(1);
                          }
                      });

                  }
              }
          });
        btnRun.setBounds(351, 724, 97, 25);
        frmDataImport.getContentPane().add(btnRun);

        btnCancel.addActionListener(new ActionListener()
          {
            public void actionPerformed(ActionEvent e)
              {

                int dialogButton = JOptionPane.YES_NO_OPTION;

                int dialogResult = JOptionPane.showConfirmDialog(null, "Close the dialog", "Warning", dialogButton);
                if (dialogResult == 0)
                  {
                    System.exit(1);
                  }
              }
          });
        btnCancel.setBounds(465, 724, 97, 25);
        frmDataImport.getContentPane().add(btnCancel);

        // Scroller1 setup
        scroller1 = new JScrollPane();
        scroller1.setBounds(34, 31, 852, 400);
        scroller1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        frmDataImport.getContentPane().add(scroller1);

        // Table1 Setup
        table1 = new JTable(new DataImportTableModel(data));
        table1.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 14));
        table1.getTableHeader().setReorderingAllowed(false);
        table1.setRowHeight(25);
        table1.getColumnModel().getColumn(0).setPreferredWidth(550);
        table1.getColumnModel().getColumn(1).setPreferredWidth(80);
        table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);        
        table1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
                
        
        // Scroller2 Setup
        scroller2 = new JScrollPane();
        scroller2.setBounds(34, 460, 852, 242);
        scroller2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        frmDataImport.getContentPane().add(scroller2);
        
        // Table2 Setup
        table2 = new JTable(new ConnectionsTableModel(connections));
        table2.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 14));
        table2.getTableHeader().setReorderingAllowed(false);
        table2.setRowHeight(25);
        table2.getColumnModel().getColumn(0).setPreferredWidth(200);
        table2.getColumnModel().getColumn(1).setPreferredWidth(350);
        table2.getColumnModel().getColumn(2).setPreferredWidth(80);
        table2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);        
        table2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        
        scroller1.setViewportView(table1);
        scroller2.setViewportView(table2);        
        
        statusLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        statusLabel.setBounds(44, 686, 852, 31);
        frmDataImport.getContentPane().add(statusLabel);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frmDataImport.setLocation(dim.width / 2 - frmDataImport.getSize().width / 2, dim.height / 2 - frmDataImport.getSize().height / 2);
      }

    public void setStatus(String text)
      {
        statusLabel.setText(text);
      }
  }
