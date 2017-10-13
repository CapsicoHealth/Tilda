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
import tilda.utils.DurationUtil;
import tilda.utils.TextUtil;
import tilda.db.Connection;
import tilda.db.ConnectionPool;
import tilda.db.metadata.IndexMeta;
import tilda.db.metadata.TableMeta;

public class Load
  {
    protected static final Logger LOG               = LogManager.getLogger(Load.class.getName());
    Load                          app               = null;
    
    private static int            threadsCount      = 1;
    private static Object[][]     data              = null;
    private static Object[][]     connections       = null;
    private static Config         Conf              = null;
    
    private JFrame                frmDataImport;

    // UI
    JLabel                        statusLabel       = new JLabel("");
    JButton                       btnRun            = new JButton("Run Import");
    JButton                       btnCancel         = new JButton("Cancel");
    JButton                       btnAllTables      = new JButton("Select All Tables");
    JButton                       btnAllConnections = new JButton("Select All Connections");
    
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
        String[] threadsPair = arguments.get(1).split("=");
        
        threadsCount = Integer.parseInt(threadsPair[1]);
        boolean isSilentMode = Integer.parseInt(silentModePair[1]) == 1;
        
        arguments.remove(0);
        arguments.remove(0);
       
        if (isSilentMode)
          {
            LOG.debug("Starting the utility in silent mode.");
            
            // Validate Table indices
            for(int i = 0; i < arguments.size() ; i += 6)
              {
                String ConfigFileName = arguments.get(i+1);
                Conf = Config.fromFile(ConfigFileName);
                LOG.debug("Validating file " + ConfigFileName);
                List<String> selectedObjectsList = new ArrayList<>(Arrays.asList(arguments.get(i+3).split(",")));
                List<String> connectionIdsList = new ArrayList<>(Arrays.asList(arguments.get(i+5).split(",")));
                List<DataObject> filteredObjects = FilterObjects(selectedObjectsList, Conf._CmsData);
                List<String> errors = ValidateDataObjects(connectionIdsList, filteredObjects);
                if ( errors.size() > 0 )
                  {
                    for(String error: errors)
                      LOG.error(error);
                    LOG.error("File "+ ConfigFileName + " failed validation. Aborting !!");
                    System.exit(1);
                  }
              }
            LOG.debug("Validation Successful.");
            
            // Processing
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
                data[i][0] = schemaPlusTable.toUpperCase();
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
                i++;
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
    
    private static List<String> ValidateDataObjects(List<String> connectionIdsList, List<DataObject> selectedDO)
      {
        List<String> errorMessages = new ArrayList<>();
        Connection C = null;
        try
          {
            for (String connectionId : connectionIdsList)
              {
                C = ConnectionPool.get(connectionId);
                for(DataObject DO : selectedDO )
                  {
                    if ( DO.isUpserts() == DO.isInserts())
                      {
                        errorMessages.add("Both 'inserts' and 'upserts' keys cannot be of same value. Table: "+DO.getTableFullName());
                        continue;
                      }
                      
                    if(DO.isUpserts() == false)
                      continue; // Skip uniqueColumns validation if not Upserts
                    
                    String[] uniqueColumns = DO.getUniqueColumnsList();
                    if (uniqueColumns.length < 1)
                      {
                        errorMessages.add("'uniqueColumns' is not defined in JSON file for Table: "+DO.getTableFullName());
                        continue;
                      }
                      
                    TableMeta tableMeta = new TableMeta(DO._SchemaName, DO._TableName, "");
                    tableMeta.load(C);
                    boolean hasIndex = hasUniqueIndex(tableMeta, uniqueColumns);
                    if( hasIndex == false )
                      {
                        errorMessages.add("Unique Index is not defined for Table: "+ DO.getTableFullName() + " in DB: "+ connectionId);
                      }
                  }            
              }
          }
        catch (Throwable T)
          {
            LOG.error("Exception while validation.", T);
            errorMessages.add("Exception in validation. "+T.getMessage());
          }
        finally
          {
            try 
              {
                if (C != null)
                  C.close();
              } 
            catch (Throwable T)
              {
                LOG.error("Exception while closing DB Connection. ", T);
                errorMessages.add("Failed to close DB Connection. "+T.getMessage());
              }
          }
        return errorMessages;
      }
    
    private static boolean hasUniqueIndex(TableMeta TM, String[] uniqueColumns)
      {
        List<IndexMeta> indices = new ArrayList<>(TM._Indices.values());
        for(IndexMeta index : indices)
          {
            List<String> indexColumns = index.getColumnNames();
            if ( (index._Unique == true) 
              && (index._Columns.size() == uniqueColumns.length)
              && (indexColumns.containsAll(Arrays.asList(uniqueColumns))) )
              {
                return true;
              }
          }
        return false;
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
            tempObjectName = tempObjectName.toUpperCase();
            if(selectedObjects.contains(tempObjectName) == true)
              filteredList.add(dataObject);
          }
        return filteredList;
      }

    private static void RunImportProcessor(List<String> connectionIdsList, Config Conf, List<DataObject> dataObjects)
    throws Exception
      {
        if ( "ALL".equals(connectionIdsList.get(0)) )
          {
            connectionIdsList = new ArrayList<>(ConnectionPool.getAllDataSourceIds().keySet());
          }                      
        else if ( "ALL_TENANTS".equals(connectionIdsList.get(0)) )
          {
            connectionIdsList = new ArrayList<>(ConnectionPool.getAllTenantDataSourceIds().keySet());
          }
        
        LOG.debug("Running ImportProcessor");
        long timeTaken = System.nanoTime();
        ImportProcessor.parallelProcess(connectionIdsList, Conf._RootFolder, threadsCount, dataObjects);
        timeTaken = System.nanoTime() - timeTaken;        
        LOG.debug("Time taken for ImportProcessor.process() = "+ DurationUtil.PrintDuration(timeTaken));
      }

    private static boolean isValidArguments(List<String> arguments)
      {
        if (arguments.size() < 4)
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
        
        String[] threadsPair = arguments.get(1).split("=");
        if (threadsPair != null && threadsPair.length != 2)
          return false;
        if (threadsPair[0].equalsIgnoreCase("-threads") == false)
          return false;

        try {
          int threads = Integer.parseInt(threadsPair[1]);
          if (threads < 1)
            throw new Exception();
        } catch (Exception E) {
          return false;
        }
        
        if (mode == 1)
          { // CLI Mode
            if ( (arguments.size() % 6) != 2 )
              return false;
            
            for ( int i = 2; i < arguments.size(); i += 6)
              {
                if ( !"-f".equalsIgnoreCase(arguments.get(i)) || TextUtil.isNullOrEmpty(arguments.get(i+1))
                  || !"-o".equalsIgnoreCase(arguments.get(i+2)) || TextUtil.isNullOrEmpty(arguments.get(i+3))
                  || !"-c".equalsIgnoreCase(arguments.get(i+4)) || TextUtil.isNullOrEmpty(arguments.get(i+5)) )
                  return false;
              }
          }
        else // UI Mode 
          if ( !"-f".equalsIgnoreCase(arguments.get(2)) || TextUtil.isNullOrEmpty(arguments.get(3)) )
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
        LOG.error("    -silentMode=0 -threads=<No.of Threads> -f <filepath>");
        LOG.error("ex: -silentMode=0 -threads=2               -f com/c/c/data/config.C.json");
        LOG.error("");
        LOG.error("*** CLI Mode");
        LOG.error("    -silentMode=1 -threads=<No.of Threads> -f <filepath>                 -o <object_name>,<object_name>,..   -c <connection_id>,... ");
        LOG.error("ex: -silentMode=1 -threads=2               -f com/c/c/data/config.C.json -o CMS.HCPCS_CODES,CMS.CPT_CODES    -c MAIN,KEYS");
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
     * @wbp.parser.entryPoint
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
        
        JScrollPane                   scroller1, scroller2;
        JTable                        table1,    table2;
        DataImportTableModel          tableDataModel;
        ConnectionsTableModel         connectionDataModel;

        frmDataImport = new JFrame();
        frmDataImport.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
        frmDataImport.setTitle("CapsicoHealth Data Import");
        frmDataImport.setType(Type.POPUP);
        frmDataImport.setBounds(100, 100, 938, 828);
        frmDataImport.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmDataImport.getContentPane().setLayout(null);
        // frmDataImport.setResizable(false);
        
        btnRun.addActionListener(new ActionListener()
          {
            public void actionPerformed(ActionEvent e)
              {
                int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to run the data import?", "Warning", JOptionPane.YES_NO_OPTION);
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

                                // Validate Table indices
                                List<DataObject> selectedDO = FilterObjects(ImportTables, Conf._CmsData);
                                LOG.debug("Validating Selected Table Indices..");
                                List<String> errors = ValidateDataObjects(ConnectionIds, selectedDO);
                                if ( errors.size() > 0 )
                                  {
                                    String error = TextUtil.JoinTrim(errors.toArray(new String[errors.size()]), ", \n");
                                    JOptionPane.showMessageDialog(null, error, "Validation Failed. Aborting !!", JOptionPane.ERROR_MESSAGE);
                                    LOG.error("Validation Failed. Aborting !!");
                                    System.exit(1);
                                  }
                                LOG.debug("Validation Successful.");
                                
                                // Processing
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
        btnRun.setBounds(351, 736, 97, 25);
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
        btnCancel.setBounds(458, 736, 97, 25);
        frmDataImport.getContentPane().add(btnCancel);

        // Scroller1 setup
        scroller1 = new JScrollPane();
        scroller1.setBounds(34, 44, 852, 387);
        scroller1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        frmDataImport.getContentPane().add(scroller1);

        // Table1 Setup
        tableDataModel = new DataImportTableModel(data); 
        table1 = new JTable(tableDataModel);
        table1.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 14));
        table1.getTableHeader().setReorderingAllowed(false);
        table1.setRowHeight(25);
        table1.getColumnModel().getColumn(0).setPreferredWidth(550);
        table1.getColumnModel().getColumn(1).setPreferredWidth(80);
        table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);        
        table1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
                
        
        // Scroller2 Setup
        scroller2 = new JScrollPane();
        scroller2.setBounds(34, 476, 852, 242);
        scroller2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        frmDataImport.getContentPane().add(scroller2);
        
        // Table2 Setup
        connectionDataModel = new ConnectionsTableModel(connections);
        table2 = new JTable(connectionDataModel);
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
        
        btnAllTables.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            for(int i=0; i < data.length; i++)
                data[i][1] = true;
            tableDataModel.fireTableDataChanged();
          }
        });
        btnAllTables.setBounds(733, 21, 153, 23);
        frmDataImport.getContentPane().add(btnAllTables);
        
        btnAllConnections.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            for(int i=0; i < connections.length; i++)
                connections[i][2] = true;
            connectionDataModel.fireTableDataChanged();
          }
        });
        btnAllConnections.setBounds(695, 453, 191, 23);
        frmDataImport.getContentPane().add(btnAllConnections);
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frmDataImport.setLocation(dim.width / 2 - frmDataImport.getSize().width / 2, dim.height / 2 - frmDataImport.getSize().height / 2);
      }

    public void setStatus(String text)
      {
        statusLabel.setText(text);
      }
  }
