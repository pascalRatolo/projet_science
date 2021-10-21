package statisique;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import data_base.DataBase;
import image.ImageBonneQualite;
import image.LoadImage;
import impression.FenetreImpressionStatistique;
import loading.Main;
import login.LoginPrincipale;
import table.TableModel;

@SuppressWarnings("serial")
public class StatDiplome extends JPanel{
	 
	 JTabbedPane pan=new JTabbedPane();
	 JPanel panPrincipale;
	 JPanel panNote;
	 JPanel panTableNote;
	 JPanel panRecNote;
	
	 JPanel panMatier;
	 JLabel panDecis;
	 JLabel panSigne;
	 
	 JLabel titre;
	
	
	 String semestre[];
	 String mention;
	 String parcour;
	 String type;
	 String post;
	 int nbrSems, debutSems;
	 int k=0;
	 int j=0;
	 int taille=576;
	 String titrePanDelib[]= {""};
	 JLayeredPane panDelib;
	 JPanel panInfDelib;
	 JPanel panTete;
	 JPanel panPanDelib;
	 
	 JButton print=new JButton (LoadImage.transformeb(100, 25, "/imprimer.jpg"));
	 JPanel panValidation;
	 JLabel dipl;
	 JLabel fem;
	 JLabel ens;
	 JTable tableDelib;
	 JTable tablePanDelib;
	 JLabel niv;
	 
	 JLabel aff;
	 JLabel azi;
	 JLabel comor;
	 JLabel euro;
	 JLabel autre;
	 
	 JButton histFil=new JButton();
	 JButton histSexe=new JButton();
	 
	 JLabel l1;
	 JLabel l2;
	 JLabel l3;
	 JLabel m1;
	 JLabel m2;
	 JLabel vide1;
	 JLabel vide3;
	 JLabel vide;
	 JLabel logo1=new JLabel();
	 JLabel logo2=new JLabel();
	 
	 DefaultTableModel modelDelib;
	 DefaultTableModel modelPanDelib;
	 
	 JButton actual=new JButton( LoadImage.transformeb(100, 25, "/actualiser.jpg"));;
	 JLayeredPane layeredPane = new JLayeredPane();
	@SuppressWarnings("rawtypes")
	 JComboBox combo[];
	 JLabel titre1[];
	 JLabel titre2[];
	 JLabel titre3[];
	 JLabel titre4[];
	 JScrollPane scrol=new JScrollPane();
	 String [] titreDelib;
	 DefaultTableCellRenderer centerRenderer;
	 Font font=new Font("Aparajita",Font.HANGING_BASELINE,15);
	 public  Border line= new LineBorder(new Color(150,150,150));
	 JLabel numRe;
	 int val;
		String anne=LoginPrincipale.anneField.getText();
		
		String parc[]= {"BM","BT"};
		String niveau[]= {"L1","L2","L3","M1","M2"};
		String typeEt[]= {"Passant","Redoublant","Triplant"};
		String sexe[]= {"MASCULIN","FEMININ"};
		
	public  StatDiplome(String mention,DefaultTableModel modellDelib,String [] titreDelib,int val){
		
		this.mention=mention;
		this.modelDelib=modellDelib;
		this.titreDelib=titreDelib;
		this.val=val;
		
		centerRenderer= new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		
		
		
			panPrincipale=new JPanel();
			panDecis=new JLabel();
			panSigne=new JLabel("Fianarantsoa, le ");
			panNote=new JPanel();
			panRecNote=new JPanel();
			panTableNote=new JPanel();
			
			panDelib=new JLayeredPane();
			panInfDelib=new JPanel();
			panTete=new JPanel();
			panPanDelib=new JPanel();
			dipl=new JLabel("DIPLOME");
			fem=new JLabel();
			ens=new JLabel();
			niv=new JLabel("Mention ");
			
			aff=new JLabel("DIPLOME");
			azi=new JLabel("Asiatique");
			comor=new JLabel("Comorienne");
			euro=new JLabel("Européene ");
			autre=new JLabel("<html>Autre&nbsp;à&nbsp;préciser</html>");
			
			l1=new JLabel("<html><div id='bloc_page'>"
					+ "<p>Mathématiques</p>"
					+ "</div></html> ");
			l2=new JLabel("L2 ");
			l3=new JLabel("L3 ");
			m1=new JLabel("M1 ");
			m2=new JLabel("M2 ");
			
			vide=new JLabel("");
			vide1=new JLabel("");
			vide3=new JLabel("");
			
			dipl.setBorder(line);
			fem.setBorder(line);
			ens.setBorder(line);
			
			niv.setBorder(line);
			l1.setBorder(line);
			l2.setBorder(line);
			l3.setBorder(line);
			m1.setBorder(line);
			m2.setBorder(line);
			
			aff.setBorder(line);
			azi.setBorder(line);
			comor.setBorder(line);
			euro.setBorder(line);
			autre.setBorder(line);
			
			vide.setBorder(line);
			vide1.setBorder(line);
			vide3.setBorder(line);
			
			niv.setHorizontalAlignment(JLabel.CENTER);
			l1.setHorizontalAlignment(JLabel.CENTER);
			l2.setHorizontalAlignment(JLabel.CENTER);
			l3.setHorizontalAlignment(JLabel.CENTER);
			m1.setHorizontalAlignment(JLabel.CENTER);
			m2.setHorizontalAlignment(JLabel.CENTER);
			
			aff.setHorizontalAlignment(JLabel.CENTER);
			azi.setHorizontalAlignment(JLabel.CENTER);
			comor.setHorizontalAlignment(JLabel.CENTER);
			euro.setHorizontalAlignment(JLabel.CENTER);
			autre.setHorizontalAlignment(JLabel.CENTER);
			
			
			
			dipl.setHorizontalAlignment(JLabel.CENTER);
			ens.setHorizontalAlignment(JLabel.CENTER);
			fem.setHorizontalAlignment(JLabel.CENTER);
			
		  logo1.setPreferredSize(new Dimension(90,90));
       	  logo2.setPreferredSize(new Dimension(90,90));
       	  logo1.setIcon(ImageBonneQualite.image("C:/Program Files (x86)/JDev/DataSciences/image/logoUniv.png",70));
     	  logo2.setIcon(ImageBonneQualite.image("C:/Program Files (x86)/JDev/DataSciences/image/logoFac.png",80));
     		 JLabel titre1=new JLabel("<html> <div id='bloc_page'>"
			     	 + " <p STYLE='padding: 0 0 0 0px;'> <font size='6'><b>UNIVERSITE&nbsp;DE&nbsp;FIANARANTSOA</b> "
			     	 + " </font> "
			     	 + " </p> "
	                 + "  <p STYLE='padding: 0 0 0 70px;'><i>"
	                 + " <font face= 'arial' size='5'> <b>FACULTE&nbsp;DES&nbsp;SCIENCES</b> </font></i></p>"
	                 + "</font>"
	                 + "  <p STYLE='padding: 0 0 0 150px;'><i>"
	                 /*+ " <font face= 'arial' size='2'> <b>N°010/"+an+"/UF/FAC.S/SCO </b> </font></i></p>"
	                 + "</font>"*/
	                 + " </div></html>");
     		 JLabel bas=new JLabel("<html> <div id='bloc_page'>"
			     	 + " <p STYLE='padding: 0 0 0 0px;'> <font face= 'arial' size='3'><i><b>N:Nouveau,&nbsp;R:Redoublant,&nbsp;"
			     	 + "T+:Triplant&nbsp;"
			     	 + "et&nbsp;plus</b></i> "
			     	 + " </font> "
			     	 + " </p> "
	                 + "  <p STYLE='padding: 0 0 0 0px;'><i>"
	                 + " <font face= 'arial' size='3'> <b>Veuillez&nbsp;remplir&nbsp;séparement&nbsp;le&nbsp;canevas&nbsp;par&nbsp;"
	                 + "filière,&nbsp;type&nbsp;de&nbsp;formation&nbsp;et&nbsp;année&nbsp;des&nbsp;études</b> </font></i></p>"
	                 + "</font>"
	                 + " </div></html>");
     		new JLabel("<html> <div id='bloc_page'>M:&nbsp;Masculin,&nbsp;F:&nbsp;Feminin&nbsp;&nbsp;</div></html>");
     		 titre1.setPreferredSize(new Dimension(400,90));
     		
     		JLabel ment=new JLabel("<html> <div id='bloc_page'><u>MENTION</u>&nbsp;:&nbsp;"+mention+"&nbsp;</div></html>");
     		JLabel parc=new JLabel("<html> <div id='bloc_page'><font face= 'arial' size='4'>"
     				+ "Etudiant&nbsp;inscrit&nbsp;par&nbsp;filiere&nbsp;et&nbsp;"
     				+ "option&nbsp;au&nbsp;titre&nbsp;de&nbsp;l'année "+LoginPrincipale.anneField.getText()+"</font></div></html>");
     		JLabel parc2=new JLabel("<html> <div id='bloc_page'><font face= 'arial' size='4'>"
     				+ "<p>Etudiant&nbsp;obtenue&nbsp;de&nbsp;diplome</p> "
     				+ "<p STYLE='padding: 0 0 0 50px;'>au&nbsp;titre&nbsp;de&nbsp;l'année "
     				+ ""+LoginPrincipale.anneField.getText()+" </p> </font></div></html>");
     		JLabel loc=new JLabel("<html> <div id='bloc_page'><u>Localisation</u>:&nbsp;ANDRAINJATO&nbsp;"
     				+ "FIANARANTSOA&nbsp;</div></html>");
     		// titre1.setBorder(line);
     		ment.setPreferredSize(new Dimension(400,15));
     		parc.setPreferredSize(new Dimension(500,30));
     		parc2.setPreferredSize(new Dimension(500,50));
     		loc.setPreferredSize(new Dimension(400,15));
     		parc.setHorizontalAlignment(JLabel.CENTER);
     		parc2.setHorizontalAlignment(JLabel.CENTER);
     		
     		panInfDelib.add(logo1);
     		panInfDelib.add(titre1);
     		panInfDelib.add(logo2);
     		panInfDelib.add(loc);
     		panInfDelib.add(ment);
			//panInfDelib.setBorder(line);
			dipl.setBounds(259,180,241,31);
			fem.setBounds(120,180,159,1);
			ens.setBounds(499,180,121,60);
			
			niv.setBounds(10,180,120,60);
			vide.setBounds(79,209,120,31);
			
			l1.setBounds(10,239,120,91);
			bas.setBounds(10,640,600,30);
			//panInfDelib.add(parc);
			
			panInfDelib.setBounds(10,0,610,200);
			panDelib.add(fem,new Integer(1), 1);
			panDelib.add(dipl,new Integer(3), 3);
			panDelib.add(ens,new Integer(3), 3);
			panDelib.add(niv,new Integer(3), 3);
			panDelib.add(l1,new Integer(3), 3);
			//panDelib.add(bas,new Integer(3), 3);
			modelDelib=new TableModel(titreDelib);
			modelDelib.addRow(new Object[] {"Sexe","LICENCE","MASTER","Total"});
			modelDelib.addRow(new Object[] {"MASCULIN","","",""});
			modelDelib.addRow(new Object[] {"FEMININ","","",""});
		    modelDelib.addRow(new Object[] {"Total","","",""});
		    
		    tableDelib=new JTable(modelDelib);
			tableDelib.setRowHeight(30);
			tableDelib.setShowGrid(false);
			tableDelib.setPreferredScrollableViewportSize(new Dimension(500,300));
		//	tableDelib[i].setDefaultRenderer(Object.class,new ColorCell(i));
			

			tableDelib.setShowGrid(true);
			for(int h=0;h<modelDelib.getColumnCount();h++)
			tableDelib.getColumnModel().getColumn(h).setCellRenderer(centerRenderer);
			tableDelib.getTableHeader().setVisible(true);
			tableDelib.setFillsViewportHeight(true);
			tableDelib.getColumnModel().getColumn(0).setPreferredWidth(70);
			tableDelib.getColumnModel().getColumn(1).setPreferredWidth(60);
			tableDelib.getColumnModel().getColumn(2).setPreferredWidth(60);
			tableDelib.getColumnModel().getColumn(3).setPreferredWidth(60);
			

			tableDelib.setBounds(130,210,490,17*30);

			panDelib.add(panInfDelib,new Integer(0), 0);
			panDelib.add(tableDelib,new Integer(1),1);
			DataBase.statDiplome(mention, modelDelib);
     	
     	
			
     	 	actual.setPreferredSize(new Dimension(100,25));
     	 	print.setPreferredSize(new Dimension(100,25));
			
			
			modelPanDelib=new DefaultTableModel() {
				public boolean isCellEditable(int row, int col){
					return false;
				}
			};
			
			modelPanDelib.addColumn(titrePanDelib[0]);
			tablePanDelib=new JTable(modelPanDelib);
			tablePanDelib.setPreferredScrollableViewportSize(new Dimension(630,500));
			panPanDelib.add(new JScrollPane(tablePanDelib));
			
			panPrincipale.setBackground(Color.cyan);
			panNote.setBackground(Color.cyan);
			
			panTete.setBackground(Color.white);
			panInfDelib.setBackground(Color.white);
			panRecNote.setBackground(Color.white);
			
			panNote.setLayout(new FlowLayout(FlowLayout.LEFT));
			panTete.setLayout(new FlowLayout(FlowLayout.LEFT));
			//panInfDelib.setLayout(new FlowLayout(FlowLayout.LEFT));
			panNote.setPreferredSize(new Dimension(680,650));
			//panMatiere[i].add(numRel[i]);
			//panMatiere[i].add(numRelT[i]);
			panNote.add(panPanDelib);
			panNote.add(print);
			panNote.add(actual);
			this.add(panNote);
			histFil.setPreferredSize(new Dimension(100,25));
			histSexe.setPreferredSize(new Dimension(100,25));
			//tableDelib.setPreferredScrollableViewportSize(new Dimension(530,modelDelib[i].getRowCount()*30));
			panDelib.setPreferredSize(new Dimension(550,600));
			panDelib.setBackground(Color.white);
			modelPanDelib.addRow(new Object[] {panDelib});
			tablePanDelib.setDefaultRenderer(Object.class, new Multirender(panDelib));
			tablePanDelib.setRowHeight(500);
			
			//panPrincipale[i].setPreferredSize(new Dimension(800,680));
			
		
			print.addActionListener(new Imprimer());
			actual.addActionListener(new actual());
	}
	
	public static void main(String[] args) {
	//	new StatTotal("MATHEMATIQUES ET APPLICATIONS",modelDelib).setVisible(true);
	}
	
	public class Multirender implements TableCellRenderer{
		JLayeredPane pan;
		public Multirender(JLayeredPane pan) {
			this.pan=pan;
		}
		public Component getTableCellRendererComponent(JTable table, Object value,
				boolean isSelected, boolean hasFocus, int row, int column) { 
			return pan;
		}
	}
	
	
	public  class Imprimer implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			new FenetreImpressionStatistique(modelPanDelib,modelDelib,panDelib).setVisible(true);
		}
	}
	
	public  class actual implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			Main.main.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			tablePanDelib.setVisible(false);
			switch(val) {
	     	case 1:
	     		DataBase.statDiplome(mention, modelDelib);
			break;
			}
			tablePanDelib.setVisible(true);
			Toolkit.getDefaultToolkit().beep();
			Main.main.setVisible(true);
			Main.main.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}
	}
	

	
}
	  
	





