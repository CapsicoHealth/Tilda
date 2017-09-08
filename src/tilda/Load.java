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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EtchedBorder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.loader.csv.ImportProcessor;
import tilda.loader.parser.Config;
import tilda.loader.parser.DataObject;
import tilda.loader.ui.DataImportTableModel;
import tilda.db.Connection;
import tilda.db.ConnectionPool;

public class Load
  {

    private JFrame                frmDataImport;
    private static Object[][]     data        = null;
    private JTable                table;
    private JScrollPane           scrollPane;
    protected static final Logger LOG         = LogManager.getLogger(Load.class.getName());
    static Connection             C           = null;
    static Config                 Conf        = null;

    Load                          app         = null;
    JLabel                        statusLabel = new JLabel("");
    JButton                       btnRun      = new JButton("Run Import");
    JButton                       btnCancel   = new JButton("Cancel");

    /**
     * Launch the application.
     */
    public static void main(String[] argsArray)
    throws Exception
      {

        List<String> arguments = new ArrayList<>(Arrays.asList(argsArray));
        String[] silentModePair = arguments.get(0).split("=");
        arguments.remove(0);
        
        ValidateArguments(silentModePair, arguments);

        LOG.info("\n*************************************************************************************************************************************");
        ConnectionPool.autoInit();
        LOG.info("\n*************************************************************************************************************************************\n");

        C = ConnectionPool.get("MAIN");
        
        boolean isSilentMode = Integer.parseInt(silentModePair[1]) == 1;
       
        if (isSilentMode)
          {
            for(int i = 0; i < arguments.size() ; i += 6)
              {
                String ConfigFileName = arguments.get(i+1);
                Conf = Config.fromFile(ConfigFileName);
                
                LOG.debug("Starting the utility in silent mode and processing " + ConfigFileName);
                
                List<String> objectNamesList = new ArrayList<>(Arrays.asList(arguments.get(i+3).split(",")));
                FilterObjects(objectNamesList);
                
                List<String> connectionIdsList = new ArrayList<>(Arrays.asList(arguments.get(i+5).split(",")));
                RunImportProcessor(connectionIdsList);
              }
          }
        else
          {
            String ConfigFileName = arguments.get(0);
            Conf = Config.fromFile(ConfigFileName);
            
            List<DataObject> list = Conf._CmsData;
            data = new Object[list.size()][3];
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
                data[i][2] = new Boolean(false);
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

    private static void RunImportProcessor(List<String> connectionIdsList)
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
        try
          {
            while(connectionIterator.hasNext())
              {
                C = ConnectionPool.get(connectionIterator.next());
                // TODO: LOG that import processor is running
                ImportProcessor.process(C, Conf, Conf._CmsData);
                C.commit();
                C.close();
                C = null;                        
              }
          }
        catch (Exception E)
          {
            // TODO rollback and finally close connection
            throw E;
          }
      }

    /*
     * Removes unnecessary objects from Conf._CmsData
     * Keeping only those objects which are passed using -o argument
     */
    private static void FilterObjects(List<String> objectNamesList)
      {
        String tempObjectName = null;
        Iterator<DataObject> cmsDataIterator = Conf._CmsData.iterator();
        while(cmsDataIterator.hasNext())
          {
            DataObject dataObject = cmsDataIterator.next();
            tempObjectName = dataObject._SchemaName + "." + dataObject._TableName;
            if(objectNamesList.contains(tempObjectName) == false)
              Conf._CmsData.remove(dataObject);
          }
      }

    private static void ValidateArguments(String[] silentModePair, List<String> args)
      {
        /* ********** TODO Validations *********** */
        if (args.size() < 2)
          {
            PrintUsageHint();
            System.exit(-1);
          }

        // Validate if silentModePair[1] must be an integer
        if (silentModePair != null && silentModePair.length != 2)
          {
            LOG.debug("Usage DataImportApp -silentMode=0/1 dataImport.json ");
            System.exit(-1);
          }

        if (silentModePair[0].equalsIgnoreCase("-silentMode") == false)
          {
            LOG.debug("Usage DataImportApp -silentMode=0/1 dataImport.json ");
            System.exit(-1);
          }
      }

    private static void PrintUsageHint()
      {
        
      }

    /**
     * Create the application.
     */
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
        catch (ClassNotFoundException e1)
          {
            e1.printStackTrace();
          }
        catch (InstantiationException e1)
          {
            e1.printStackTrace();
          }
        catch (IllegalAccessException e1)
          {
            e1.printStackTrace();
          }
        catch (UnsupportedLookAndFeelException e1)
          {
            e1.printStackTrace();
          }

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
                    List<String> truncateTables = new ArrayList<String>();
                    List<String> ImportTables = new ArrayList<String>();

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
                                    Boolean TruncateValue = (Boolean) data[i][2];

                                    if (TruncateValue == true)
                                      truncateTables.add((String) data[i][0]);

                                    if (ImportValue == true)
                                      ImportTables.add((String) data[i][0]);
                                  }
                                // Call Import code.
                                List<DataObject> FilterImportTablesList = new ArrayList<DataObject>();
                                List<DataObject> list = Conf._CmsData;
                                for (DataObject D : list)
                                  {
                                    String fullTableName = D._SchemaName + "." + D._TableName;
                                    fullTableName = fullTableName.toUpperCase();
                                    if (ImportTables.contains(fullTableName) == true)
                                      FilterImportTablesList.add(D);
                                  }
                                ImportProcessor.process(C, Conf, FilterImportTablesList);
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

        scrollPane = new JScrollPane();
        scrollPane.setBounds(34, 31, 852, 642);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        frmDataImport.getContentPane().add(scrollPane);

        table = new JTable(new DataImportTableModel(data));

        table.getColumnModel().getColumn(0).setPreferredWidth(560);
        table.getColumnModel().getColumn(1).setPreferredWidth(80);
        table.getColumnModel().getColumn(2).setPreferredWidth(80);

        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // TableColumn tc = table.getColumnModel().getColumn(2);
        // tc.setCellRenderer(new TableCellRenderer());

        table.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 14));
        table.setRowHeight(25);
        table.getTableHeader().setReorderingAllowed(false);

        scrollPane.setViewportView(table);
        table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));


        statusLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        statusLabel.setBounds(44, 686, 852, 31);
        frmDataImport.getContentPane().add(statusLabel);

        // ImageIcon icon = new ImageIcon(this.getClass().getResource("/images/capsico.png"));
        // frmDataImport.setIconImage(icon.getImage());
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frmDataImport.setLocation(dim.width / 2 - frmDataImport.getSize().width / 2, dim.height / 2 - frmDataImport.getSize().height / 2);
      }

    public void setStatus(String text)
      {
        statusLabel.setText(text);
      }
  }

