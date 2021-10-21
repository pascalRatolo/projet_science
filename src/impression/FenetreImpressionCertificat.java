package impression;

import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PageFormat;
import java.awt.print.Pageable;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

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
import javax.swing.RepaintManager;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import certificat.AttestationScola;
import certificat.CertificatScola;
import data_base.DataBase;

    /**  * Demo of the basic features of {@code JTable} printing.  
         * Allows the user to configure a couple of options and print  
         * a table of student grades.  * <p>  
         * Requires the following other files:  * <ul>  
         
         *     <li>images/passed.png  *     <li>images/failed.png  * </ul>  *  
         * @author Shannon Hickey  */ 

  @SuppressWarnings("serial")
public class FenetreImpressionCertificat extends JDialog implements Printable , Pageable {
	  
		private PageFormat format;
		private int numPages;
       /* Check mark and x mark items to render the "Passed" column */     
       //private static final ImageIcon passedIcon= new ImageIcon(TablePrintDemo1.class.getResource("images/passed.png"));     
      //private static final ImageIcon failedIcon = new ImageIcon(TablePrintDemo1.class.getResource("images/failed.png"));
    
      /* UI Components */     
      private JPanel contentPane;     
      private JLabel gradesLabel;     
      private JPanel gradesTable;     
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
      public static String clas1;
      public static String clas2;
      public static int k;
      
    public static JScrollPane scrollPane ;
  	public  String an;
  	public  String nom;
  	public  String prenom;
  	public  String dateNaiss;
  	public  String lieuNaiss;
  	public  String num;
  	public  String numAt;
  	public  String mention;
  	public  String parcours;
  	public  int j;
           /**      * Constructs an instance of the demo.      */     
          @SuppressWarnings({ })
		public FenetreImpressionCertificat(String mention,int j,String an,String nom,String prenom,String dateNaiss,String lieuNaiss,String num,
				String parcours,String clas,String numAt) {
        	  this.clas=clas;
        	  this.an=an;
        	  this.nom=nom;
        	  this.prenom=prenom;
        	  this.dateNaiss=dateNaiss;
        	  this.lieuNaiss=lieuNaiss;
        	  this.num=num;
        	  this.parcours=parcours;
        	  this.clas=clas;
        	  this.j=j;
        	  this.mention=mention;
        	  this.numAt=numAt;
        	  //super("Imperssion des Cartes des étudinats ");
        	  setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        	  this.setModalityType(DEFAULT_MODALITY_TYPE);
        	  this.addWindowListener(new WindowAdapter() {
      			public void windowClosing(WindowEvent e){
      				int option = JOptionPane.showConfirmDialog(contentPane,"Voulez-vous Terminer l'impression ?","ATTENTION!",
    						JOptionPane.YES_NO_OPTION,
    						JOptionPane.QUESTION_MESSAGE);
    					if(option == JOptionPane.OK_OPTION){
    							dispose();
    							DataBase.impr=true;
    						}
      				}
      			});
        	  
     	   	
            // JTable table = new JTable(new RssFeedTableModel(feeds)); 
             
        
             gradesLabel = new JLabel(" CERTIFICAT DE SCOLARITE ");         
             gradesLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        switch(j) {
        case 1:
        	 gradesTable = new CertificatScola(mention,j,an,nom,prenom,dateNaiss,lieuNaiss,num,parcours,clas,numAt);
        	break;
        case 2:
       	 	 gradesTable = new CertificatScola(mention,j,an,nom,prenom,dateNaiss,lieuNaiss,num,parcours,clas,numAt);
       	break;
        case 3:
        	 gradesTable = new AttestationScola(mention,j,an,nom,prenom,dateNaiss,lieuNaiss,num,parcours,clas,numAt);
       	break;
        case 4:
        	 gradesTable = new AttestationScola(mention,j,an,nom,prenom,dateNaiss,lieuNaiss,num,parcours,clas,numAt);
       	break;
        }
            
            
            
             //gradesTable.setPreferredScrollableViewportSize(new Dimension(510,500));
        

        /* Set a custom renderer on the "Passed" column */         
            //gradesTable.getColumn("Passed").setCellRenderer(createPassedColumnRenderer());
        
            scroll = new JScrollPane(gradesTable);
        
            String tooltipText;
        
            tooltipText = "Include a page header";         
            headerBox = new JCheckBox("Header:", false);
            headerBox.setEnabled(false);
            headerBox.addActionListener(new ActionListener() {             
                public void actionPerformed(ActionEvent ae) {                 
                  headerField.setEnabled(headerBox.isSelected());             
              }         
            });         
           headerBox.setToolTipText(tooltipText);         
           tooltipText = "Page Header (Use {0} to include page number)";         
           headerField = new JTextField("");         
           headerField.setToolTipText(tooltipText);
        
           tooltipText = "Include a page footer";         
           footerBox = new JCheckBox("Footer:", false); 
           footerBox.setEnabled(false);
           footerBox.addActionListener(new ActionListener() {             
                public void actionPerformed(ActionEvent ae) {                 
                 footerField.setEnabled(footerBox.isSelected());             
              }         
            });         

           footerBox.setToolTipText(tooltipText);         
           tooltipText = "Page Footer (Use {0} to Include Page Number)";         
           footerField = new JTextField("Page {0}");         
           footerField.setToolTipText(tooltipText);
        
           tooltipText = "Show the Print Dialog Before Printing";         
           showPrintDialogBox = new JCheckBox("Show print dialog", true); 
           showPrintDialogBox.setEnabled(false);
           showPrintDialogBox.setToolTipText(tooltipText);         
           showPrintDialogBox.addActionListener(new ActionListener() {             
            public void actionPerformed(ActionEvent ae) {                 
                 if (!showPrintDialogBox.isSelected()) {                     
                 JOptionPane.showMessageDialog(FenetreImpressionCertificat.this,"If the Print Dialog is not shown,"+ " the default printer is used.", 
                        "Printing Message",JOptionPane.INFORMATION_MESSAGE);
                }
              }         
           });         
           tooltipText = "Keep the GUI Responsive and Show a Status Dialog During Printing";         
           interactiveBox = new JCheckBox("Interactive (Show status dialog)", true);  
           interactiveBox.setEnabled(false);
           interactiveBox.setToolTipText(tooltipText);         
           interactiveBox.addActionListener(new ActionListener() {             
              public void actionPerformed(ActionEvent ae) {                 
                    if (!interactiveBox.isSelected()) {                     
                        JOptionPane.showMessageDialog(FenetreImpressionCertificat.this,"If non-interactive, the GUI is fully blocked"
                             + " during printing.","Printing Message",JOptionPane.INFORMATION_MESSAGE);
                  }             
                }         
            });
        

            tooltipText = "Shrink the Table to Fit the Entire Width on a Page";         
            fitWidthBox = new JCheckBox("Fit width to printed page", true);  
            fitWidthBox.setEnabled(false);
            fitWidthBox.setToolTipText(tooltipText);
        
            tooltipText = "Print the Table";         
            printButton = new JButton("Print");         
            printButton.setToolTipText(tooltipText);         
            printButton.addActionListener(new ActionListener() {             
                 public void actionPerformed(ActionEvent ae) {                 
                    printGradesTable();
                	// new PrintMultiPageUtil(gradesTable);
              }         
            });
        

            contentPane = new JPanel();         
            addComponentsToContentPane();         
            setContentPane(contentPane);
        
            setSize(560, 600);
            setResizable(false);
            setLocationRelativeTo(null);     
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
                .addComponent(headerField, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))                 
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
                    .addComponent(scroll, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)                     
                    .addComponent(gradesLabel)                     
                    .addComponent(bottomPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))                 
                    .addContainerGap())         
                );         

          layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)             
                   .addGroup(layout.createSequentialGroup()                 
                   .addContainerGap()                 
                   .addComponent(gradesLabel)                 
                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)                 
                   .addComponent(scroll, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)                 
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
            	     format = PrinterJob.getPrinterJob().defaultPage();
            	        numPages = 1;
            	        print();
            	        
            	    }
            	public void print() {
            	PrinterJob printJob = PrinterJob .getPrinterJob();
            	// show page-dialog with default DIN A4
            	        format = printJob.pageDialog(printJob.defaultPage());
            	        printJob.setPrintable( this);
            	        printJob.setPageable( this);
            	if (printJob.printDialog())
            	try {
            	                printJob.print(null);
            	            } catch ( PrinterException pe) {
            	System .out.println( "Error printing: " + pe);
            	            }
            	    }
            	public int print( Graphics g, PageFormat pageFormat, int pageIndex) {
            	if ((pageIndex < 0 ) | (pageIndex >= numPages)) {
            	return (NO_SUCH_PAGE);
            	        } else {
            	        	Graphics2D g2d = ( Graphics2D )g;
            	            g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY()-
            	            		pageIndex*gradesTable.getPreferredSize().height);
            	            disableDoubleBuffering(gradesTable);
            	            gradesTable.paint(g2d);
            	            enableDoubleBuffering(gradesTable);
            	return (PAGE_EXISTS);
            	        }
            	    }
            	   
            	public static void disableDoubleBuffering( Component c) {
            		RepaintManager currentManager = RepaintManager .currentManager(c);
            		        currentManager.setDoubleBufferingEnabled( false );
            		    }
            		public static void enableDoubleBuffering( Component c) {
            		RepaintManager currentManager = RepaintManager .currentManager(c);
            		        currentManager.setDoubleBufferingEnabled( true);
            		    }
            		@Override
            		public int getNumberOfPages() {
            		return numPages;
            		    }
            		@Override
            		public PageFormat getPageFormat( int arg0) throws IndexOutOfBoundsException{
            		return format;
            		    }
            		@Override
            		public Printable getPrintable( int arg0) throws IndexOutOfBoundsException{
            		return this;
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
				}