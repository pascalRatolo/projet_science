package impression;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import data_base.DataBase;
import image.ImageBonneQualite;
import loading.Methode;
import login.LoginPrincipale;
import resultat.ModelResultat1;
import resultat.ModelResultat2;
import resultat.ModelResultat3;
import resultat.ModelResultat4;
import resultat.ModelResultat5;
import resultat.RecuperInfo1;
import resultat.RecuperInfo2;
import resultat.RecuperInfo3;
import resultat.RecuperInfo4;
import resultat.RecuperInfo5;

    /**  * Demo of the basic features of {@code JTable} printing.  
         * Allows the user to configure a couple of options and print  
         * a table of student grades.  * <p>  
         * Requires the following other files:  * <ul>  
         
         *     <li>images/passed.png  *     <li>images/failed.png  * </ul>  *  
         * @author Shannon Hickey  */ 

  @SuppressWarnings("serial")
public class FenetreImpressionPresenceAuExam extends JDialog {
	  
    
       /* Check mark and x mark items to render the "Passed" column */     
       //private static final ImageIcon passedIcon= new ImageIcon(TablePrintDemo1.class.getResource("images/passed.png"));     
      //private static final ImageIcon failedIcon = new ImageIcon(TablePrintDemo1.class.getResource("images/failed.png"));
    
      /* UI Components */     
      private JPanel contentPane;     
      private JLabel gradesLabel;     
      private JTable gradesTable;     
      private JScrollPane scroll;     
      private JCheckBox showPrintDialogBox;     
      private JCheckBox interactiveBox;     
      private JCheckBox fitWidthBox;     
      private JButton printButton;
    
       /* Protected so that they can be modified/disabled by subclasses */     
      protected JCheckBox headerBox;     
      protected JCheckBox footerBox;     
      protected JTextField headerField;     
      protected JTextField footerField;
      public  String clas;
      public  String mention;
      public static String clas1;
      public static String clas2;
      public int k;
      public int nbr=0;
           /**      * Constructs an instance of the demo.      */     
      DefaultTableModel model;
      DefaultTableModel model2;
      JPanel pan;
      int x,y;
      String parcour,session,sems,ue;
		@SuppressWarnings("unchecked")
		public FenetreImpressionPresenceAuExam(DefaultTableModel model2,String mention,String parcour,
				String session,String sems,int k,String ue,int nbr,int x,int y) {
        	  super();
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
  		this.addWindowListener(new WindowAdapter() {
  			public void windowClosing(WindowEvent e){
  				int option = JOptionPane.showConfirmDialog(contentPane,"Voulez-vous Terminer l'impression ?","ATTENTION!",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
					if(option == JOptionPane.OK_OPTION){
							dispose();
						}
  				}
  			});
  		 setSize(720, 700);
         setResizable(false);
         setLocationRelativeTo(null); 
  		     this.model2=model2;
  		     this.mention=mention;
  		     this.parcour=parcour;
  		   	 this.session=session;
  		 	 this.sems=sems;
  		 	 this.k=k;
  		 	 this.x=x;
  		 	 this.y=y;
  		 	 this.ue=ue;
  		 	 this.nbr=nbr;
        	  //super("Imperssion des Cartes des étudinats ");
            
            // JTable table = new JTable(new RssFeedTableModel(feeds)); 
  		   model= new DefaultTableModel(){
				public Class <?>getColumnClass(int Column) {
					if(Column == 4) 
						return Boolean.class;
					else
						return String.class;
					
				}
				public boolean isCellEditable(int row, int col){
					if(col!=4)
						return false;
					else
						return true;
				}
			};
			
			 @SuppressWarnings("rawtypes")
			 List feeds = new ArrayList(); 
			 switch(nbr) {
			 case 5:
				feeds.add(new RecuperInfo1("","","","","",""));
				feeds.add(new RecuperInfo1("","","","","",""));
			    feeds.add(new RecuperInfo1(model2.getColumnName(0),model2.getColumnName(1),model2.getColumnName(2),
					  model2.getColumnName(3),model2.getColumnName(4),""));
			 for(int i=0;i<model2.getRowCount();i++) {
				 feeds.add(new RecuperInfo1(String.valueOf(model2.getValueAt(i, 0)), String.valueOf(model2.getValueAt(i, 1))
						 	, String.valueOf(model2.getValueAt(i, 2)),String.valueOf(model2.getValueAt(i, 3)),
						 	"",""));
			 }
			 gradesTable=new JTable(new ModelResultat1(feeds));
			 gradesTable.setDefaultRenderer(Object.class, new Multirender());
             gradesTable.setRowHeight(0,220);
			 for(int i=1;i<feeds.size();i++)
	             gradesTable.setRowHeight(i,28);
	             gradesTable.setFillsViewportHeight(true);
	             gradesTable.setShowGrid(true);
	             gradesTable.setPreferredScrollableViewportSize(new Dimension(700,500));
			 break;
			 case 7:
				  feeds.add(new RecuperInfo2("","","","","","","",""));
				  feeds.add(new RecuperInfo2("","","","","","","",""));
				  feeds.add(new RecuperInfo2(model2.getColumnName(0),model2.getColumnName(1),model2.getColumnName(2),
						  model2.getColumnName(3),"",model2.getColumnName(5),
						 "",""));
				 for(int i=0;i<model2.getRowCount();i++) {
					 feeds.add(new RecuperInfo2(String.valueOf(model2.getValueAt(i, 0)), String.valueOf(model2.getValueAt(i, 1))
							 	, String.valueOf(model2.getValueAt(i, 2)),String.valueOf(model2.getValueAt(i, 3)),
							 	"",String.valueOf(model2.getValueAt(i, 5)),"",""));
				 }
				 gradesTable=new JTable(new ModelResultat2(feeds));
				 gradesTable.setDefaultRenderer(Object.class, new Multirender());
	             gradesTable.setRowHeight(0,220);
				 for(int i=1;i<feeds.size();i++)
		             gradesTable.setRowHeight(i,30);
				 gradesTable.setFillsViewportHeight(true);
		             gradesTable.setShowGrid(true);
		             gradesTable.setPreferredScrollableViewportSize(new Dimension(700,500));
				 break;
				 
			 case 9:
				  feeds.add(new RecuperInfo3("","","","","","","","","",""));
				  feeds.add(new RecuperInfo3("","","","","","","","","",""));
				  feeds.add(new RecuperInfo3(model2.getColumnName(0),model2.getColumnName(1),model2.getColumnName(2),
						  model2.getColumnName(3),"",model2.getColumnName(5),"",model2.getColumnName(7),"",""));
				 for(int i=0;i<model2.getRowCount();i++) {
					 feeds.add(new RecuperInfo3(String.valueOf(model2.getValueAt(i, 0)), String.valueOf(model2.getValueAt(i, 1))
							 	, String.valueOf(model2.getValueAt(i, 2)),String.valueOf(model2.getValueAt(i, 3)),
							 	"",String.valueOf(model2.getValueAt(i, 5)),"",String.valueOf(model2.getValueAt(i, 7)),
							 	"",""));
				 }
				 gradesTable=new JTable(new ModelResultat3(feeds));
				 gradesTable.setDefaultRenderer(Object.class, new Multirender());
	             gradesTable.setRowHeight(0,220);
				 for(int i=1;i<feeds.size();i++)
		             gradesTable.setRowHeight(i,30);
				 gradesTable.setFillsViewportHeight(true);
		             gradesTable.setShowGrid(true);
		             gradesTable.setPreferredScrollableViewportSize(new Dimension(810,500));
		             setSize(830, 700);
				 break;
			 case 11:
				  feeds.add(new RecuperInfo4("","","","","","","","","","","",""));
				  feeds.add(new RecuperInfo4("","","","","","","","","","","",""));
				  feeds.add(new RecuperInfo4(model2.getColumnName(0),model2.getColumnName(1),model2.getColumnName(2),
						  model2.getColumnName(3),"",model2.getColumnName(5),
						  "",model2.getColumnName(7), "",model2.getColumnName(9),
						  "",""));
				 for(int i=0;i<model2.getRowCount();i++) {
					 feeds.add(new RecuperInfo4(String.valueOf(model2.getValueAt(i, 0)), String.valueOf(model2.getValueAt(i, 1))
							 	, String.valueOf(model2.getValueAt(i, 2)),String.valueOf(model2.getValueAt(i, 3)),
							 	"",String.valueOf(model2.getValueAt(i, 5)),"",String.valueOf(model2.getValueAt(i, 7)),
							 	"",String.valueOf(model2.getValueAt(i, 9)),"",""));
				 }
				 gradesTable=new JTable(new ModelResultat4(feeds));
				 gradesTable.setDefaultRenderer(Object.class, new Multirender());
	             gradesTable.setRowHeight(0,220);
				 for(int i=1;i<feeds.size();i++)
		             gradesTable.setRowHeight(i,30);
				 	 gradesTable.setFillsViewportHeight(true);
		             gradesTable.setShowGrid(true);
		             gradesTable.setPreferredScrollableViewportSize(new Dimension(1000,500));
		             setSize(1020, 700);
				 break;
			 case 13:
				 feeds.add(new RecuperInfo5("","","","","","","","","","","","","",""));
				 feeds.add(new RecuperInfo5("","","","","","","","","","","","","",""));
				 feeds.add(new RecuperInfo5(model2.getColumnName(0),model2.getColumnName(1),model2.getColumnName(2),
						  model2.getColumnName(3),"",model2.getColumnName(5),
						 "",model2.getColumnName(7), "",model2.getColumnName(9),
						 "",model2.getColumnName(11),
						  "",""));
				 for(int i=0;i<model2.getRowCount();i++) {
					 feeds.add(new RecuperInfo5(String.valueOf(model2.getValueAt(i, 0)), 
							 String.valueOf(model2.getValueAt(i, 1)), String.valueOf(model2.getValueAt(i, 2)),
							 String.valueOf(model2.getValueAt(i, 3)),
							 	"",String.valueOf(model2.getValueAt(i, 5)),
							 	"",String.valueOf(model2.getValueAt(i, 7)),
							 	"",String.valueOf(model2.getValueAt(i, 9)),
							 	"",String.valueOf(model2.getValueAt(i,11)),
							 	"",""));
				 }
				 gradesTable=new JTable(new ModelResultat5(feeds));
				 gradesTable.setDefaultRenderer(Object.class, new Multirender());
	             gradesTable.setRowHeight(0,235);
				 for(int i=1;i<feeds.size();i++)
		             gradesTable.setRowHeight(i,30);
				 	 gradesTable.setFillsViewportHeight(true);
		             gradesTable.setShowGrid(true);
		             gradesTable.setPreferredScrollableViewportSize(new Dimension(1200,500));
		             setSize(1120, 700);
				 break;
			
				 
			 }
             gradesLabel = new JLabel();         
             gradesLabel.setFont(new Font("Dialog", Font.BOLD, 12));
             
            
             
            
             //gradesTable.setPreferredScrollableViewportSize(new Dimension(510,500));
        

        /* Set a custom renderer on the "Passed" column */         
            //gradesTable.getColumn("Passed").setCellRenderer(createPassedColumnRenderer());
        
            scroll = new JScrollPane(gradesTable);
        
            String tooltipText;
        
            tooltipText = "Include a page header";         
            headerBox = new JCheckBox("", true);
            headerBox.setEnabled(false);
            headerBox.addActionListener(new ActionListener() {             
                public void actionPerformed(ActionEvent ae) {                 
                  headerField.setEnabled(headerBox.isSelected());             
              }         
            });         
           headerBox.setToolTipText(tooltipText);         
           tooltipText = "Page Header (Use {0} to include page number)";         
           headerField = new JTextField();         
           headerField.setToolTipText(tooltipText);
        
           tooltipText = "Include a page footer";         
           footerBox = new JCheckBox("Footer:", true); 
           footerBox.setEnabled(false);
           footerBox.addActionListener(new ActionListener() {             
                public void actionPerformed(ActionEvent ae) {                 
                 footerField.setEnabled(footerBox.isSelected());             
              }         
            });         

           footerBox.setToolTipText(tooltipText);         
           tooltipText = "Page Footer (Use {0} to Include Page Number)";         
           footerField = new JTextField("");         
           footerField.setToolTipText(tooltipText);
        
           tooltipText = "Show the Print Dialog Before Printing";         
           showPrintDialogBox = new JCheckBox("", true); 
           showPrintDialogBox.setEnabled(false);
           showPrintDialogBox.setToolTipText(tooltipText);         
           showPrintDialogBox.addActionListener(new ActionListener() {             
            public void actionPerformed(ActionEvent ae) {                 
                 if (!showPrintDialogBox.isSelected()) {                     
                 JOptionPane.showMessageDialog(FenetreImpressionPresenceAuExam.this,"If the Print Dialog is not shown,"+ " the default printer is used.", 
                        "Printing Message",JOptionPane.INFORMATION_MESSAGE);
                }
              }         
           });         
           tooltipText = "Keep the GUI Responsive and Show a Status Dialog During Printing";         
           interactiveBox = new JCheckBox("", true);  
           interactiveBox.setEnabled(false);
           interactiveBox.setToolTipText(tooltipText);         
           interactiveBox.addActionListener(new ActionListener() {             
              public void actionPerformed(ActionEvent ae) {                 
                    if (!interactiveBox.isSelected()) {                     
                        JOptionPane.showMessageDialog(FenetreImpressionPresenceAuExam.this,"If non-interactive, the GUI is fully blocked"
                             + " during printing.","Printing Message",JOptionPane.INFORMATION_MESSAGE);
                  }             
                }         
            });
        

            tooltipText = "Shrink the Table to Fit the Entire Width on a Page";         
            fitWidthBox = new JCheckBox("", true);  
            fitWidthBox.setEnabled(false);
            fitWidthBox.setToolTipText(tooltipText);
        
            tooltipText = "Print the Table";         
            printButton = new JButton("Print");         
            printButton.setToolTipText(tooltipText);         
            printButton.addActionListener(new ActionListener() {             
                 public void actionPerformed(ActionEvent ae) {                 
                    printGradesTable();  
                    DataBase.impr=true;
              }         
            });
        

            contentPane = new JPanel();         
            addComponentsToContentPane();  
          //  contentPane.setPreferredSize(new Dimension(300,600));
            setContentPane(contentPane);
        
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            
               
          }
    

         /**      
           * Adds to and lays out all GUI components on the {@code contentPane} panel.      
           * <p>      
           * It is recommended that you <b>NOT</b> try to understand this code. It was      
           * automatically generated by the NetBeans GUI builder.      
           **/     

         private void addComponentsToContentPane() {         
          JPanel bottomPanel = new JPanel();         
          bottomPanel.setBorder(BorderFactory.createTitledBorder("Printing"));
        
          GroupLayout bottomPanelLayout = new GroupLayout(bottomPanel);         
          bottomPanel.setLayout(bottomPanelLayout);         
          bottomPanelLayout.setHorizontalGroup(bottomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(bottomPanelLayout.createSequentialGroup()                 
                .addContainerGap()                 
                .addGroup(bottomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)                     
                .addComponent(headerBox)                     
                .addComponent(footerBox))                 
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)                 
                .addGroup(bottomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)                     
                .addComponent(footerField)                     
                .addComponent(headerField, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE) )                 
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)                 
                .addGroup(bottomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)                     
                .addGroup(bottomPanelLayout.createSequentialGroup()                         
                .addComponent(fitWidthBox)                         
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)                         
                .addComponent(printButton))                     
                .addGroup(bottomPanelLayout.createSequentialGroup()                         
                 .addComponent(showPrintDialogBox)                         
                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)                         
                 .addComponent(interactiveBox)))                 
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))         
              );         

              bottomPanelLayout.setVerticalGroup(bottomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)      
                 .addGroup(bottomPanelLayout.createSequentialGroup()                 
                 .addGroup(bottomPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)                     
                 .addComponent(headerBox)                     
                 .addComponent(headerField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)                     
                 .addComponent(interactiveBox)                     
                 .addComponent(showPrintDialogBox))                 
                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)                 
                 .addGroup(bottomPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)                     
                 .addComponent(footerBox)                     
                 .addComponent(footerField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)                     
                 .addComponent(fitWidthBox)                     
                 .addComponent(printButton))                 
                 .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))         
              );
        

              GroupLayout layout = new GroupLayout(contentPane);         
              contentPane.setLayout(layout);         
              layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)             
                    .addGroup(layout.createSequentialGroup()                 
                    .addContainerGap()                 
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)                     
                    .addComponent(scroll, GroupLayout.DEFAULT_SIZE, 8, Short.MAX_VALUE)                     
                    .addComponent(gradesLabel)                     
                    .addComponent(bottomPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))                 
                    .addContainerGap())         
                );         

              layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)             
                   .addGroup(layout.createSequentialGroup()                 
                   .addContainerGap()                 
                   .addComponent(gradesLabel)                 
                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)                 
                   .addComponent(scroll, GroupLayout.DEFAULT_SIZE, 10, Short.MAX_VALUE)                 
                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)                 
                   .addComponent(bottomPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)                 
                   .addContainerGap())         
                );     
             }
    

                 /**      
                   * Create and return a table for the given model.      
                   * <p>      
                   * This is protected so that a subclass can return an instance      
                   * of a different {@code JTable} subclass. This is interesting      
                   * only for {@code TablePrintDemo3} where we want to return a      
                   * subclass that overrides {@code getPrintable} to return a      
                   * custom {@code Printable} implementation.      
                 */     

                   protected JTable createTable(TableModel model) {         
                         return new JTable(model);     
                     }
    

                   /**      
                     * Create and return a cell renderer for rendering the pass/fail column.      
                     * This is protected so that a subclass can further customize it.      
                    */     

                   protected TableCellRenderer createPassedColumnRenderer() {         
                       return new PassedColumnRenderer();     
                       }
   

                    /**      
                      * Print the grades table.      
                      */     

               private void printGradesTable() {        
              /* Fetch printing properties from the GUI components */
       

               /* if we should print a header */         
               if (headerBox.isSelected()) {             
               new MessageFormat(headerField.getText());         
               }
        
                MessageFormat footer = null;         
                 /* if we should print a footer */         
                   if (footerBox.isSelected()) {             
                /* create a MessageFormat around the footer text */             
                  footer = new MessageFormat(footerField.getText());         
                  }
        
                 boolean fitWidth = fitWidthBox.isSelected();         
                 boolean showPrintDialog = showPrintDialogBox.isSelected();         
                 boolean interactive = interactiveBox.isSelected();
        
                  /* determine the print mode */         
              JTable.PrintMode mode = fitWidth ? JTable.PrintMode.FIT_WIDTH: JTable.PrintMode.NORMAL;
        
                  try {             
                    /* print the table */            
                       boolean complete = gradesTable.print(mode, null, footer,showPrintDialog, null,interactive, null);
            
                   /* if printing completes */             
                  if (complete) {                 
                      /* show a success message */                 
                   JOptionPane.showMessageDialog(this,"Printing Complete","Printing Result",JOptionPane.INFORMATION_MESSAGE);             
                 } else {                 
                      /* show a message indicating that printing was cancelled */                 
                   JOptionPane.showMessageDialog(this,"Printing Cancelled","Printing Result",JOptionPane.INFORMATION_MESSAGE);             
                 }         
                } catch (PrinterException pe) {             
                   /* Printing failed, report to the user */            
                  JOptionPane.showMessageDialog(this,"Printing Failed: " + pe.getMessage(),"Printing Result",JOptionPane.ERROR_MESSAGE);         
                  }     
                }
    
                 /**      
                   * Start the application.      
                   */     

                public static void main(final String[] args) {         
                /* Schedule for the GUI to be created and shown on the EDT */         
                    SwingUtilities.invokeLater(new Runnable() {             
                    public void run() {                 
                       /* Don't want bold fonts if we end up using metal */                 
                       UIManager.put("swing.boldMetal", false);                 
                         try {                     
                              UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());                 
                             } catch (Exception e) {                 
                       }                 
                      //  new FenetreImpression().setVisible(true);             
                    }         
                   });  
                    
                }
    

                 /**      
                                   * A custom cell renderer for rendering the "Passed" column.      
                                   */     

       protected static class PassedColumnRenderer extends DefaultTableCellRenderer {             
          public Component getTableCellRendererComponent(JTable table,Object value,boolean isSelected,boolean hasFocus,int row,int column) {
            super.getTableCellRendererComponent(table, value, isSelected,hasFocus, row, column);
            setText("");             
            setHorizontalAlignment(SwingConstants.CENTER);
            return this;         
				}     
		} 
              public class Multirender implements TableCellRenderer{
                 JPanel pan=new JPanel();
                 Border line= new LineBorder(new Color(150,150,150));
                 JLabel titre=new JLabel("<html> <div id='bloc_page'> FICHE&nbsp;DE&nbsp;PRESENCE&nbsp;DE&nbsp;"
             	  		+ "L'UNITE&nbsp;D'ENSEIGNEMENT&nbsp;&nbsp;"+Methode.finit(ue,k)+"&nbsp;</div></html>");
                 JLabel date[];
                 Font font=new Font("arial",Font.ITALIC,9);
                 
                 public Multirender() {
                 }
              public Component getTableCellRendererComponent(JTable table, Object value,
                       boolean isSelected, boolean hasFocus, int row, int column) {

             	// titre.setBorder(line);
            	titre.setFont(font);
            	  if(row==0) {
            		  pan=new JPanel();
                	  JLabel logo1=new JLabel();
                	  JLabel logo2=new JLabel();
                	  JLabel ment=new JLabel("<html> <div id='bloc_page'>MENTION&nbsp;:&nbsp;"+mention+"&nbsp;</div></html>");
                	  JLabel parc=new JLabel("<html> <div id='bloc_page'>PARCOURS&nbsp;:&nbsp;"+parcour+"&nbsp;</div></html>");
                	  JLabel sems=new JLabel("<html> <div id='bloc_page'>SEMESTRE&nbsp;:&nbsp;S"+k+"&nbsp;</div></html>");
                	  JLabel sesion=new JLabel("<html> <div id='bloc_page'>SESSION&nbsp;:&nbsp;"+session+"&nbsp;</div></html>");
                	  JLabel anne=new JLabel("<html> <div id='bloc_page'>ANNE&nbsp;UNIVERSITAIRE&nbsp;:&nbsp;"
                	  +LoginPrincipale.anneField.getText()+"&nbsp;</div></html>");
                	  JLabel salle=new JLabel("<html> <div id='bloc_page'>Salle&nbsp;:&nbsp;________&nbsp;N°&nbsp;"
                	  		+ " "+x+"&nbsp;à&nbsp;"+y+"</div></html>");
                 	 
                	  logo1.setPreferredSize(new Dimension(90,90));
                	  logo2.setPreferredSize(new Dimension(90,90));
                	  logo1.setIcon(ImageBonneQualite.image("C:/Program Files (x86)/JDev/DataSciences/image/logoUniv.png",70));
              		  logo2.setIcon(ImageBonneQualite.image("C:/Program Files (x86)/JDev/DataSciences/image/logoFac.png",80));
              		  JLabel titre1=new JLabel("<html> <div id='bloc_page'>"
       			     	 + " <p STYLE='padding: 0 0 0 18px;'> <font size='6'><b>UNIVERSITE&nbsp;DE&nbsp;FIANARANTSOA</b> "
       			     	 + " </font> "
       			     	 + " </p> "
       	                 + "  <p STYLE='padding: 0 0 0 80px;'><i>"
       	                 + " <font face= 'arial' size='5'> <b>FACULTE&nbsp;DES&nbsp;SCIENCES</b> </font></i></p>"
       	                 + "</font>"
       	                 + "  <p STYLE='padding: 0 0 0 150px;'><i>"
       	                 /*+ " <font face= 'arial' size='2'> <b>N°010/"+an+"/UF/FAC.S/SCO </b> </font></i></p>"
       	                 + "</font>"*/
       	                 + " </div></html>");
              		 titre1.setPreferredSize(new Dimension(450,90));
              		 ment.setPreferredSize(new Dimension(650,15));
              		 parc.setPreferredSize(new Dimension(650,15));
              		 sems.setPreferredSize(new Dimension(650,15));
              		 sesion.setPreferredSize(new Dimension(650,15));
              		 anne.setPreferredSize(new Dimension(650,15));
              		 salle.setPreferredSize(new Dimension(650,15));
              		
              		 pan.add(logo1);
              		 pan.add(titre1);
              		 pan.add(logo2);
              		 pan.add(ment);
              		 pan.add(parc);
              		 pan.add(sems);
              		 pan.add(anne);
              		 pan.add(sesion);
              		 pan.add(salle);
              		
              		 pan.setBackground(Color.white);
              		
            	  } 
            	  else {
            		  pan=new JPanel();
            	  switch(nbr) {
            	  case 5: 
                  pan.setBackground(Color.white);
                  RecuperInfo1 feed1 = (RecuperInfo1)value;
                  JLabel numE1= new JLabel("<html> <div id='bloc_page'>"+feed1.numExam+"</div></html>");
            	  JLabel numC1= new JLabel("<html> <div id='bloc_page'>"+feed1.numCart+"</div></html>");
            	  JLabel ec1= new JLabel("<html> <div id='bloc_page'>"+Methode.finitTextLab(feed1.ec1)+"</div></html>");
            	  JLabel poidsec1= new JLabel("<html> <div id='bloc_page'>"+feed1.poidsEc1+"</div></html>");
            	  JLabel note1= new JLabel("<html> <div id='bloc_page'>"+feed1.note+"</div></html>");
            	  date=new JLabel[1];
            	  date[0]=new JLabel("le ____/____/_______");
            	  titre.setPreferredSize(new Dimension(510,20));
           		  titre.setHorizontalAlignment(JLabel.CENTER);
	                 numE1.setPreferredSize(new Dimension(40,20));
	                 numC1.setPreferredSize(new Dimension(80,20));
	                 ec1.setPreferredSize(new Dimension(380,20));
	                 poidsec1.setPreferredSize(new Dimension(145,20));
	                 date[0].setPreferredSize(new Dimension(145,20));
	                 note1.setPreferredSize(new Dimension(70,20));
	                
	                	 numE1.setHorizontalAlignment(JLabel.CENTER);
	                	 numC1.setHorizontalAlignment(JLabel.CENTER);
	                	 ec1.setHorizontalAlignment(JLabel.LEFT);
	                	 poidsec1.setHorizontalAlignment(JLabel.CENTER);
	                	 
	                	 numE1.setBorder(line);
	                	 numC1.setBorder(line);
	                	 ec1.setBorder(line);
	                	 poidsec1.setBorder(line);
	                	 date[0].setBorder(line);
	                	 note1.setBorder(line);
	                if(row==1) {
	                pan.add(titre);
	                pan.add(date[0]);
	                }else	
	                 if(row==2) {
	                	 ec1.setHorizontalAlignment(JLabel.CENTER);
	                	 poidsec1.setFont(font);
	                	 pan.add(numE1);
		                 pan.add(numC1);
		                 pan.add(ec1);
		                 pan.add(poidsec1);
	                 }else {
	                	 pan.add(numE1);
		                 pan.add(numC1);
		                 pan.add(ec1);
	                	 poidsec1.setPreferredSize(new Dimension(70,20));
		                 pan.add(poidsec1);
		                 pan.add(note1);
	                 }
	                 
            	 break;
            	  case 7: 
            		  pan.setBackground(Color.white);
                      RecuperInfo2 feed2 = (RecuperInfo2)value;
                      JLabel numE2= new JLabel("<html> <div id='bloc_page'>"+feed2.numExam+"</div></html>");
                	  JLabel numC2= new JLabel("<html> <div id='bloc_page'>"+feed2.numCart+"</div></html>");
                	  JLabel ec2= new JLabel("<html> <div id='bloc_page'>"+Methode.finitTextLab(feed2.ec1)+"</div></html>");
                	  JLabel poidsec2= new JLabel("<html> <div id='bloc_page'>"+feed2.poidsEc1+"</div></html>");
                	  JLabel ec21= new JLabel("<html> <div id='bloc_page'>"+feed2.ec2+"</div></html>");
                	  JLabel poidsec21= new JLabel("<html> <div id='bloc_page'>"+feed2.poidsEc2+"</div></html>");
                	  JLabel note2= new JLabel("<html> <div id='bloc_page'>"+feed2.poidsEc2+"</div></html>");
                	  JLabel note21= new JLabel();
                	  date=new JLabel[2];
                	  date[0]=new JLabel("le ___/___/______");
                	  date[1]=new JLabel("le ___/___/______");
                	  titre.setPreferredSize(new Dimension(410,20));
    	                 numE2.setPreferredSize(new Dimension(30,20));
    	                 numC2.setPreferredSize(new Dimension(70,20));
    	                 ec2.setPreferredSize(new Dimension(300,20));
    	                 poidsec2.setPreferredSize(new Dimension(120,20));
    	                 ec21.setPreferredSize(new Dimension(150,20));
    	                 poidsec21.setPreferredSize(new Dimension(120,20));
    	                 date[0].setPreferredSize(new Dimension(120,20));
    	                 date[1].setPreferredSize(new Dimension(120,20));
    	                	 numE2.setHorizontalAlignment(JLabel.CENTER);
    	                	 numC2.setHorizontalAlignment(JLabel.CENTER);
    	                	 ec2.setHorizontalAlignment(JLabel.LEFT);
    	                	 poidsec2.setHorizontalAlignment(JLabel.CENTER);
    	                	 ec21.setHorizontalAlignment(JLabel.CENTER);
    	                	 poidsec21.setHorizontalAlignment(JLabel.CENTER);
    	                	 
    	                	 numE2.setBorder(line);
    	                	 numC2.setBorder(line);
    	                	 ec2.setBorder(line);
    	                	 poidsec2.setBorder(line);
    	                	 ec21.setBorder(line);
    	                	 poidsec21.setBorder(line);
    	                	 note21.setBorder(line);
    	                	 note2.setBorder(line);
    	                	 date[0].setBorder(line);
    	                	 date[1].setBorder(line);
    	                 
    	                
    	                 
    	                 if(row==1) {
    	 	                pan.add(titre);
    	 	                pan.add(date[0]);
    	 	                pan.add(date[1]);
    	 	                }else	
    	 	                 if(row==2) {
    	 	                	 ec2.setHorizontalAlignment(JLabel.CENTER);
    	 	                	 poidsec2.setFont(font);
    	 	               	     poidsec21.setFont(font);
    	 	                	 pan.add(numE2);
    	 		                 pan.add(numC2);
    	 		                 pan.add(ec2);
    	 		                 pan.add(poidsec2);
    	 		                pan.add(poidsec21);
    	 	                 }else {
    	 	                	 pan.add(numE2);
    	 		                 pan.add(numC2);
    	 		                 pan.add(ec2);
    	 		                 pan.add(poidsec2);
    	 	                	 poidsec2.setPreferredSize(new Dimension(57,20));
    	 	                	 poidsec21.setPreferredSize(new Dimension(58,20));
    	 	                	 note2.setPreferredSize(new Dimension(57,20));
   	 	                	     note21.setPreferredSize(new Dimension(58,20));
    	 		                 pan.add(poidsec21);
    	 		                 pan.add(note2);
    	 		                 pan.add(note21);
    	 	                 }
        		  break;
            	  case 9: 
            		  pan.setBackground(Color.white);
                      RecuperInfo3 feed3 = (RecuperInfo3)value;
                      JLabel numE3= new JLabel("<html> <div id='bloc_page'>"+feed3.numExam+"</div></html>");
                	  JLabel numC3= new JLabel("<html> <div id='bloc_page'>"+feed3.numCart+"</div></html>");
                	  JLabel ec3= new JLabel("<html> <div id='bloc_page'>"+Methode.finitTextLab(feed3.ec1)+"</div></html>");
                	  JLabel poidsec3= new JLabel("<html> <div id='bloc_page'>"+feed3.poidsEc1+"</div></html>");
                	  JLabel ec31= new JLabel("<html> <div id='bloc_page'>"+feed3.ec2+"</div></html>");
                	  JLabel poidsec31= new JLabel("<html> <div id='bloc_page'>"+feed3.poidsEc2+"</div></html>");
                	  JLabel ec32= new JLabel("<html> <div id='bloc_page'>"+feed3.ec3+"</div></html>");
                	  JLabel poidsec32= new JLabel("<html> <div id='bloc_page'>"+feed3.poidsEc3+"</div></html>");
                	  JLabel note3= new JLabel("<html> <div id='bloc_page'>"+feed3.note+"</div></html>");
                	  JLabel note31= new JLabel("<html> <div id='bloc_page'>"+feed3.credit+"</div></html>");

                	  JLabel note32= new JLabel("<html> <div id='bloc_page'>"+feed3.credit+"</div></html>");
                	  date=new JLabel[3];
                	  date[0]=new JLabel("le ___/___/______");
                	  date[1]=new JLabel("le ___/___/______");
                	  date[2]=new JLabel("le ___/___/______");
                	  titre.setPreferredSize(new Dimension(360,20));
    	                 numE3.setPreferredSize(new Dimension(60,20));
    	                 numC3.setPreferredSize(new Dimension(60,20));
    	                 ec3.setPreferredSize(new Dimension(230,20));
    	                 poidsec3.setPreferredSize(new Dimension(130,20));
    	                 ec31.setPreferredSize(new Dimension(10,20));
    	                 poidsec31.setPreferredSize(new Dimension(130,20));
    	                 ec32.setPreferredSize(new Dimension(10,20));
    	                 poidsec32.setPreferredSize(new Dimension(130,20));
    	                 note3.setPreferredSize(new Dimension(40,20));
    	                 note31.setPreferredSize(new Dimension(40,20));
    	                 note32.setPreferredSize(new Dimension(40,20));
    	                 date[0].setPreferredSize(new Dimension(130,20));
    	                 date[1].setPreferredSize(new Dimension(130,20));
    	                 date[2].setPreferredSize(new Dimension(130,20));
    	                
    	                	 numE3.setHorizontalAlignment(JLabel.CENTER);
    	                	 numC3.setHorizontalAlignment(JLabel.CENTER);
    	                	 ec3.setHorizontalAlignment(JLabel.LEFT);
    	                	 poidsec3.setHorizontalAlignment(JLabel.CENTER);
    	                	 ec31.setHorizontalAlignment(JLabel.CENTER);
    	                	 poidsec31.setHorizontalAlignment(JLabel.CENTER);
    	                	 ec32.setHorizontalAlignment(JLabel.CENTER);
    	                	 poidsec32.setHorizontalAlignment(JLabel.CENTER);
    	                	 note3.setHorizontalAlignment(JLabel.CENTER);
    	                	 note31.setHorizontalAlignment(JLabel.CENTER);
    	                	 
    	                	 numE3.setBorder(line);
    	                	 numC3.setBorder(line);
    	                	 ec3.setBorder(line);
    	                	 poidsec3.setBorder(line);
    	                	 ec31.setBorder(line);
    	                	 poidsec31.setBorder(line);
    	                	 ec32.setBorder(line);
    	                	 poidsec32.setBorder(line);
    	                	 note3.setBorder(line);
    	                	 note31.setBorder(line);
    	                	 note32.setBorder(line);
    	                	 date[0].setBorder(line);
    	                	 date[01].setBorder(line);
    	                	 date[02].setBorder(line);
    	                 
    	                 
    	                	 if(row==1) {
    	    	 	                pan.add(titre);
    	    	 	                pan.add(date[0]);
    	    	 	                pan.add(date[1]);
    	    	 	                pan.add(date[2]);
    	    	 	                }else	
    	    	 	                 if(row==2) {
    	    	 	                	 ec3.setHorizontalAlignment(JLabel.CENTER);
    	    	 	                	 poidsec3.setFont(font);
    	    	 	               	     poidsec31.setFont(font);
    	    	 	               	     poidsec32.setFont(font);
    	    	 	                	 pan.add(numE3);
    	    	 		                 pan.add(numC3);
    	    	 		                 pan.add(ec3);
    	    	 		                 pan.add(poidsec3);
    	    	 		                 pan.add(poidsec31);
    	    	 		                 pan.add(poidsec32);
    	    	 	                 }else {
    	    	 	                	 pan.add(numE3);
    	    	 		                 pan.add(numC3);
    	    	 		                 pan.add(ec3);
    	    	 		                 pan.add(poidsec3);
    	    	 	                	 poidsec3.setPreferredSize(new Dimension(62,20));
    	    	 	                	 poidsec31.setPreferredSize(new Dimension(62,20));
    	    	 	                	 poidsec32.setPreferredSize(new Dimension(63,20));
    	    	 	                	 note3.setPreferredSize(new Dimension(62,20));
    	   	 	                	     note31.setPreferredSize(new Dimension(63,20));
    	   	 	                	     note32.setPreferredSize(new Dimension(63,20));
    	    	 		                 pan.add(poidsec31);
    	    	 		                 pan.add(poidsec32);
    	    	 		                 pan.add(note3);
    	    	 		                 pan.add(note31);
    	    	 		                 pan.add(note32);
    	    	 	                 }
        		  break;
            	  case 11: 
            		  pan.setBackground(Color.white);
                      RecuperInfo4 feed4 = (RecuperInfo4)value;
                      JLabel numE4= new JLabel("<html> <div id='bloc_page'>"+feed4.numExam+"</div></html>");
                	  JLabel numC4= new JLabel("<html> <div id='bloc_page'>"+feed4.numCart+"</div></html>");
                	  JLabel ec4= new JLabel("<html> <div id='bloc_page'>"+Methode.finitTextLab(feed4.ec1)+"</div></html>");
                	  JLabel poidsec4= new JLabel("<html> <div id='bloc_page'>"+feed4.poidsEc1+"</div></html>");
                	  JLabel ec41= new JLabel("<html> <div id='bloc_page'>"+feed4.ec2+"</div></html>");
                	  JLabel poidsec41= new JLabel("<html> <div id='bloc_page'>"+feed4.poidsEc2+"</div></html>");
                	  JLabel ec42= new JLabel("<html> <div id='bloc_page'>"+feed4.ec3+"</div></html>");
                	  JLabel poidsec42= new JLabel("<html> <div id='bloc_page'>"+feed4.poidsEc3+"</div></html>");
                	  JLabel ec43= new JLabel("<html> <div id='bloc_page'>"+feed4.ec4+"</div></html>");
                	  JLabel poidsec43= new JLabel("<html> <div id='bloc_page'>"+feed4.poidsEc4+"</div></html>");
                	  JLabel note4= new JLabel("<html> <div id='bloc_page'>"+feed4.note+"</div></html>");
                	  JLabel credt4= new JLabel("<html> <div id='bloc_page'>"+feed4.credit+"</div></html>");
                	  JLabel note41= new JLabel("<html> <div id='bloc_page'>"+feed4.credit+"</div></html>");
                	  JLabel note42= new JLabel("<html> <div id='bloc_page'>"+feed4.credit+"</div></html>");
                	  JLabel note43= new JLabel("<html> <div id='bloc_page'>"+feed4.credit+"</div></html>");
                	  JLabel note44= new JLabel("<html> <div id='bloc_page'>"+feed4.credit+"</div></html>");
                	  date=new JLabel[4];
                	  date[0]=new JLabel("le ___/___/______");
                	  date[1]=new JLabel("le ___/___/______");
                	  date[2]=new JLabel("le ___/___/______");
                	  date[3]=new JLabel("le ___/___/______");
                	  titre.setPreferredSize(new Dimension(410,20));
                	  date[0].setPreferredSize(new Dimension(130,20));
 	                  date[1].setPreferredSize(new Dimension(130,20));
 	                  date[2].setPreferredSize(new Dimension(130,20));
 	                  date[3].setPreferredSize(new Dimension(130,20));
	                	 numE4.setPreferredSize(new Dimension(60,20));
	 	                 numC4.setPreferredSize(new Dimension(60,20));
	 	                 ec4.setPreferredSize(new Dimension(280,20));
	 	                 poidsec4.setPreferredSize(new Dimension(130,20));
	 	                 ec41.setPreferredSize(new Dimension(130,20));
	 	                 poidsec41.setPreferredSize(new Dimension(130,20));
	 	                 ec42.setPreferredSize(new Dimension(130,20));
	 	                 poidsec42.setPreferredSize(new Dimension(130,20));
	 	                 ec43.setPreferredSize(new Dimension(130,20));
	 	                 poidsec43.setPreferredSize(new Dimension(130,20));
	 	                 note4.setPreferredSize(new Dimension(40,20));
	 	                 credt4.setPreferredSize(new Dimension(40,20));
                	  
                	  	 numE4.setHorizontalAlignment(JLabel.CENTER);
	                	 numC4.setHorizontalAlignment(JLabel.CENTER);
	                	 ec4.setHorizontalAlignment(JLabel.LEFT);
	                	 poidsec4.setHorizontalAlignment(JLabel.CENTER);
	                	 ec41.setHorizontalAlignment(JLabel.CENTER);
	                	 poidsec41.setHorizontalAlignment(JLabel.CENTER);
	                	 ec42.setHorizontalAlignment(JLabel.CENTER);
	                	 poidsec42.setHorizontalAlignment(JLabel.CENTER);
	                	 ec43.setHorizontalAlignment(JLabel.CENTER);
	                	 poidsec43.setHorizontalAlignment(JLabel.CENTER);
	                	 note4.setHorizontalAlignment(JLabel.CENTER);
	                	 
	                	 numE4.setBorder(line);
	                	 numC4.setBorder(line);
	                	 ec4.setBorder(line);
	                	 poidsec4.setBorder(line);
	                	 ec41.setBorder(line);
	                	 poidsec41.setBorder(line);
	                	 ec42.setBorder(line);
	                	 poidsec42.setBorder(line);
	                	 ec43.setBorder(line);
	                	 poidsec43.setBorder(line);
	                	 note4.setBorder(line);
	                	 credt4.setBorder(line);
	                	 note41.setBorder(line);
	                	 note42.setBorder(line);
	                	 note43.setBorder(line);
	                	 note44.setBorder(line);
	                	 date[0].setBorder(line);
	                	 date[01].setBorder(line);
	                	 date[02].setBorder(line);
	                	 date[03].setBorder(line);
	                 
	                 
	                	 if(row==1) {
	    	 	                pan.add(titre);
	    	 	                pan.add(date[0]);
	    	 	                pan.add(date[1]);
	    	 	                pan.add(date[2]);
	    	 	                pan.add(date[3]);
	    	 	                }else	
	    	 	                 if(row==2) {
	    		                	ec4.setHorizontalAlignment(JLabel.CENTER);
	    	 	                	 poidsec4.setFont(font);
	    	 	               	     poidsec41.setFont(font);
	    	 	               	     poidsec42.setFont(font);
	    	 	               	     poidsec43.setFont(font);
	    	 	                	 pan.add(numE4);
	    	 		                 pan.add(numC4);
	    	 		                 pan.add(ec4);
	    	 		                 pan.add(poidsec4);
	    	 		                 pan.add(poidsec41);
	    	 		                 pan.add(poidsec42);
	    	 		                 pan.add(poidsec43);
	    	 	                 }else {
	    	 	                	 pan.add(numE4);
	    	 		                 pan.add(numC4);
	    	 		                 pan.add(ec4);
	    	 		                 pan.add(poidsec4);
	    	 	                	 poidsec4.setPreferredSize(new Dimension(62,20));
	    	 	                	 poidsec41.setPreferredSize(new Dimension(62,20));
	    	 	                	 poidsec42.setPreferredSize(new Dimension(63,20));
	    	 	                	 poidsec43.setPreferredSize(new Dimension(63,20));
	    	 	                	 note4.setPreferredSize(new Dimension(62,20));
	   	 	                	     note41.setPreferredSize(new Dimension(63,20));
	   	 	                	     note42.setPreferredSize(new Dimension(63,20));
	   	 	                	     note43.setPreferredSize(new Dimension(63,20));
	   	 	                	     note44.setPreferredSize(new Dimension(63,20));
	    	 		                 pan.add(poidsec41);
	    	 		                 pan.add(poidsec42);
	    	 		                 pan.add(poidsec43);
	    	 		                 pan.add(note4);
	    	 		                 pan.add(note41);
	    	 		                 pan.add(note42);
	    	 		                 pan.add(note43);
	    	 		                 pan.add(note44);
	    	 	                 }
        		  break;
        		  
            	  case 13: 
            		  pan.setBackground(Color.white);
                      RecuperInfo5 feed5 = (RecuperInfo5)value;
                      JLabel numE5= new JLabel("<html> <div id='bloc_page'>"+feed5.numExam+"</div></html>");
                	  JLabel numC5= new JLabel("<html> <div id='bloc_page'>"+feed5.numCart+"</div></html>");
                	  JLabel ec5= new JLabel("<html> <div id='bloc_page'>"+Methode.finitTextLab(feed5.ec1)+"</div></html>");
                	  JLabel poidsec5= new JLabel("<html> <div id='bloc_page'>"+feed5.poidsEc1+"</div></html>");
                	  JLabel ec51= new JLabel("<html> <div id='bloc_page'>"+feed5.ec2+"</div></html>");
                	  JLabel poidsec51= new JLabel("<html> <div id='bloc_page'>"+feed5.poidsEc2+"</div></html>");
                	  JLabel ec52= new JLabel("<html> <div id='bloc_page'>"+feed5.ec3+"</div></html>");
                	  JLabel poidsec52= new JLabel("<html> <div id='bloc_page'>"+feed5.poidsEc3+"</div></html>");
                	  JLabel ec53= new JLabel("<html> <div id='bloc_page'>"+feed5.ec4+"</div></html>");
                	  JLabel poidsec53= new JLabel("<html> <div id='bloc_page'>"+feed5.poidsEc4+"</div></html>");
                	  JLabel ec54= new JLabel("<html> <div id='bloc_page'>"+feed5.ec5+"</div></html>");
                	  JLabel poidsec54= new JLabel("<html> <div id='bloc_page'>"+feed5.poidsEc5+"</div></html>");
                	  JLabel note5= new JLabel("<html> <div id='bloc_page'>"+feed5.note+"</div></html>");
                	  JLabel credt5= new JLabel("<html> <div id='bloc_page'>"+feed5.credit+"</div></html>");

                	  JLabel note51= new JLabel("<html> <div id='bloc_page'>"+feed5.credit+"</div></html>");
                	  JLabel note52= new JLabel("<html> <div id='bloc_page'>"+feed5.credit+"</div></html>");
                	  JLabel note53= new JLabel("<html> <div id='bloc_page'>"+feed5.credit+"</div></html>");
                	  JLabel note54= new JLabel("<html> <div id='bloc_page'>"+feed5.credit+"</div></html>");
                	  JLabel note55= new JLabel("<html> <div id='bloc_page'>"+feed5.credit+"</div></html>");
                	  date=new JLabel[5];
                	  date[0]=new JLabel("le ___/___/______");
                	  date[1]=new JLabel("le ___/___/______");
                	  date[2]=new JLabel("le ___/___/______");
                	  date[3]=new JLabel("le ___/___/______");
                	  date[4]=new JLabel("le ___/___/______");
                	  titre.setPreferredSize(new Dimension(380,20));
                	  date[0].setPreferredSize(new Dimension(130,20));
 	                  date[1].setPreferredSize(new Dimension(130,20));
 	                  date[2].setPreferredSize(new Dimension(130,20));
 	                  date[3].setPreferredSize(new Dimension(130,20));
 	                  date[4].setPreferredSize(new Dimension(130,20));
	                	 numE5.setPreferredSize(new Dimension(30,20));
	 	                 numC5.setPreferredSize(new Dimension(60,20));
	 	                 ec5.setPreferredSize(new Dimension(280,20));
	 	                 poidsec5.setPreferredSize(new Dimension(130,20));
	 	                 ec51.setPreferredSize(new Dimension(130,20));
	 	                 poidsec51.setPreferredSize(new Dimension(130,20));
	 	                 ec52.setPreferredSize(new Dimension(130,20));
	 	                 poidsec52.setPreferredSize(new Dimension(130,20));
	 	                 ec53.setPreferredSize(new Dimension(130,20));
	 	                 poidsec53.setPreferredSize(new Dimension(130,20));
	 	                 ec54.setPreferredSize(new Dimension(130,20));
	 	                 poidsec54.setPreferredSize(new Dimension(130,20));
	 	                 note5.setPreferredSize(new Dimension(40,20));
                	  
                	  	 numE5.setHorizontalAlignment(JLabel.CENTER);
	                	 numC5.setHorizontalAlignment(JLabel.CENTER);
	                	 ec5.setHorizontalAlignment(JLabel.LEFT);
	                	 poidsec5.setHorizontalAlignment(JLabel.CENTER);
	                	 ec51.setHorizontalAlignment(JLabel.CENTER);
	                	 poidsec51.setHorizontalAlignment(JLabel.CENTER);
	                	 ec52.setHorizontalAlignment(JLabel.CENTER);
	                	 poidsec52.setHorizontalAlignment(JLabel.CENTER);
	                	 ec53.setHorizontalAlignment(JLabel.CENTER);
	                	 poidsec53.setHorizontalAlignment(JLabel.CENTER);
	                	 ec54.setHorizontalAlignment(JLabel.CENTER);
	                	 poidsec54.setHorizontalAlignment(JLabel.CENTER);
	                	 note5.setHorizontalAlignment(JLabel.CENTER);
	                	 credt5.setHorizontalAlignment(JLabel.CENTER);
	                	 

	                	 numE5.setBorder(line);
	                	 numC5.setBorder(line);
	                	 ec5.setBorder(line);
	                	 poidsec5.setBorder(line);
	                	 ec51.setBorder(line);
	                	 poidsec51.setBorder(line);
	                	 ec52.setBorder(line);
	                	 poidsec52.setBorder(line);
	                	 ec53.setBorder(line);
	                	 poidsec53.setBorder(line);
	                	 poidsec54.setBorder(line);
	                	 note5.setBorder(line);
	                	 credt5.setBorder(line);
	                	 note51.setBorder(line);
	                	 note52.setBorder(line);
	                	 note53.setBorder(line);
	                	 note54.setBorder(line);
	                	 note55.setBorder(line);
	                	 date[0].setBorder(line);
	                	 date[01].setBorder(line);
	                	 date[02].setBorder(line);
	                	 date[03].setBorder(line);
	                	 date[04].setBorder(line);
	                 
	                 
	                	 if(row==1) {
	    	 	                pan.add(titre);
	    	 	                pan.add(date[0]);
	    	 	                pan.add(date[1]);
	    	 	                pan.add(date[2]);
	    	 	                pan.add(date[3]);
	    	 	                pan.add(date[4]);
	    	 	                }else	
	    	 	                 if(row==2) {
	    		                	 ec5.setHorizontalAlignment(JLabel.CENTER);
	    	 	                	 poidsec5.setFont(font);
	    	 	               	     poidsec51.setFont(font);
	    	 	               	     poidsec52.setFont(font);
	    	 	               	     poidsec53.setFont(font);
	    	 	               	     poidsec54.setFont(font);
	    	 	                	 pan.add(numE5);
	    	 		                 pan.add(numC5);
	    	 		                 pan.add(ec5);
	    	 		                 pan.add(poidsec5);
	    	 		                 pan.add(poidsec51);
	    	 		                 pan.add(poidsec52);
	    	 		                 pan.add(poidsec53);
	    	 		                 pan.add(poidsec54);
	    	 	                 }else {
	    	 	                	 pan.add(numE5);
	    	 		                 pan.add(numC5);
	    	 		                 pan.add(ec5);
	    	 		                 pan.add(poidsec5);
	    	 	                	 poidsec5.setPreferredSize(new Dimension(62,20));
	    	 	                	 poidsec51.setPreferredSize(new Dimension(62,20));
	    	 	                	 poidsec52.setPreferredSize(new Dimension(63,20));
	    	 	                	 poidsec53.setPreferredSize(new Dimension(63,20));
	    	 	                	 poidsec54.setPreferredSize(new Dimension(63,20));
	    	 	                	 note5.setPreferredSize(new Dimension(62,20));
	   	 	                	     note51.setPreferredSize(new Dimension(63,20));
	   	 	                	     note52.setPreferredSize(new Dimension(63,20));
	   	 	                	     note53.setPreferredSize(new Dimension(63,20));
	   	 	                	     note54.setPreferredSize(new Dimension(63,20));
	   	 	                	     note55.setPreferredSize(new Dimension(63,20));
	    	 		                 pan.add(poidsec51);
	    	 		                 pan.add(poidsec52);
	    	 		                 pan.add(poidsec53);
	    	 		                 pan.add(note5);
	    	 		                 pan.add(note51);
	    	 		                 pan.add(note52);
	    	 		                 pan.add(note53);
	    	 		                 pan.add(note54);
	    	 		                 pan.add(note55);
	    	 	                 }
        		  break;
            	  }
            }
            	  pan.setLayout(new FlowLayout(FlowLayout.LEFT));
                return pan;
                 }
              }
		}
  
  