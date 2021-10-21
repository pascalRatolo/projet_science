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
import resultat.RecuperInfo1;

    /**  * Demo of the basic features of {@code JTable} printing.  
         * Allows the user to configure a couple of options and print  
         * a table of student grades.  * <p>  
         * Requires the following other files:  * <ul>  
         
         *     <li>images/passed.png  *     <li>images/failed.png  * </ul>  *  
         * @author Shannon Hickey  */ 

  @SuppressWarnings("serial")
public class FenetreImpressionListeAuExamen extends JDialog {
	  
    
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
		public FenetreImpressionListeAuExamen(DefaultTableModel model2,String mention,String parcour,
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
  		 setSize(700, 700);
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
                 JOptionPane.showMessageDialog(FenetreImpressionListeAuExamen.this,"If the Print Dialog is not shown,"+ " the default printer is used.", 
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
                        JOptionPane.showMessageDialog(FenetreImpressionListeAuExamen.this,"If non-interactive, the GUI is fully blocked"
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
                 JLabel titre=new JLabel("<html> <div id='bloc_page'> LISTE&nbsp;DES&nbsp;ETUDIANTS&nbsp;AUX&nbsp;EXAMEN&nbsp;</div></html>");
                
                 Font font=new Font("arial",Font.BOLD,14);
                 
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
            	  titre.setPreferredSize(new Dimension(700,20));
           		  titre.setHorizontalAlignment(JLabel.CENTER);
	                 numE1.setPreferredSize(new Dimension(60,20));
	                 numC1.setPreferredSize(new Dimension(80,20));
	                 ec1.setPreferredSize(new Dimension(480,20));
	                
	                	 numE1.setHorizontalAlignment(JLabel.CENTER);
	                	 numC1.setHorizontalAlignment(JLabel.CENTER);
	                	 ec1.setHorizontalAlignment(JLabel.LEFT);
	                	 
	                	 numE1.setBorder(line);
	                	 numC1.setBorder(line);
	                	 ec1.setBorder(line);
	                if(row==1) {
	                pan.add(titre);
	                }else {
	                	if(row==2)
	                		 ec1.setHorizontalAlignment(JLabel.CENTER);
	                	 pan.add(numE1);
		                 pan.add(numC1);
		                 pan.add(ec1);
	                 }
	                 
            	 break;
            	  }
            }
            	  pan.setLayout(new FlowLayout(FlowLayout.LEFT));
                return pan;
                 }
              }
		}
  
  