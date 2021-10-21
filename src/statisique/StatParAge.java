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
import histgramme.HistParAge;
import image.ImageBonneQualite;
import image.LoadImage;
import impression.FenetreImpressionStatistiqueAge;
import loading.Main;
import login.LoginPrincipale;
import table.TableModel;

@SuppressWarnings("serial")
public class StatParAge extends JPanel{
	 
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
	 JButton histFil=new JButton();
	 JButton print=new JButton( LoadImage.transformeb(100, 25, "/imprimer.jpg"));
	 JPanel panValidation;
	 JLabel masc;
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
	 String titreComb[]= {"L1","L2","L3","M1","M2"};
	 String titreFil[]= {"T.C.M","M.I.S.S","M.E","M.F"};
	 
	 JComboBox<String> combo= new JComboBox<String>(titreComb);
	 JComboBox<String> Filiere= new JComboBox<String>(titreFil);
	 
	 DefaultTableModel modelDelib;
	 DefaultTableModel modelPanDelib;
	 
	 JLabel niveau=new JLabel("L1");
	 JLabel parc;
	 JButton actual=new JButton( LoadImage.transformeb(100, 25, "/actualiser.jpg"));
	 JLayeredPane layeredPane = new JLayeredPane();
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
		String anne=LoginPrincipale.anneField.getText();
	public  StatParAge(String mention,DefaultTableModel modellDelib,String [] titreDelib){
		
		this.mention=mention;
		this.modelDelib=modellDelib;
		this.titreDelib=titreDelib;
		
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
			masc=new JLabel("MASCULIN");
			fem=new JLabel("FEMININ");
			ens=new JLabel("ENSEMBLE");
			niv=new JLabel("Niveau ");
			
			aff=new JLabel("Africaine");
			azi=new JLabel("Aziatique");
			comor=new JLabel("Comorienne");
			euro=new JLabel("Européene ");
			autre=new JLabel("<html>Autre&nbsp;à&nbsp;préciser</html>");
			
			l1=new JLabel("L1 ");
			l2=new JLabel("L2 ");
			l3=new JLabel("L3 ");
			m1=new JLabel("M1 ");
			m2=new JLabel("M2 ");
			
			vide=new JLabel("");
			vide1=new JLabel("");
			vide3=new JLabel("");
			
			masc.setBorder(line);
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
			
			masc.setHorizontalAlignment(JLabel.CENTER);
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
	                 + "  <p STYLE='padding: 0 0 0 30px;'><i>"
	                 + " <font face= 'arial' size='5'> <b> ANNEE&nbsp;UNIVERSITAIRE "+LoginPrincipale.anneField.getText()+" </b> </font></i></p>"
	                 + "</font>"
	                 + " </div></html>");
     		 JLabel bas=new JLabel("<html> <div id='bloc_page'>"
			     	 + " <p STYLE='padding: 0 0 0 0px;'> <font  size='3'><i><b>*la&nbsp;plupart&nbsp;des&nbsp;filières&nbsp;sont&nbsp;des&nbsp;"
			     	 + "types&nbsp;de&nbsp;formation;&nbsp;initiale&nbsp;pour&nbsp;les&nbsp;étudiants&nbsp;à&nbsp;plein&nbsp;temps&nbsp;&nbsp;"
			     	 + " </font> "
			     	 + " </p> "
			     	 + " <p STYLE='padding: 0 0 0 0px;'> <font face= 'arial' size='3'><i><b>On&nbsp;attend&nbsp;par&nbsp;formation&nbsp;continue&nbsp;celle&nbsp;"
			     	 + "qui&nbsp;est&nbsp;donnée&nbsp;aux&nbsp;travailleurs&nbsp;à&nbsp;temps&nbsp;partiels&nbsp;&nbsp;"
			     	 + " </font> "
			     	 + " </p> "
	                 + "  <p STYLE='padding: 0 0 0 0px;'><i>"
	                 + " <font size='4'> <b>N.B:&nbsp;Veuillez&nbsp;remplir&nbsp;séparement&nbsp;le&nbsp;canevas&nbsp;par&nbsp;"
	                 + "filière,&nbsp;type&nbsp;de&nbsp;formation&nbsp;et&nbsp;année&nbsp;d'&nbsp;études</b> </font></i></p>"
	                 + "</font>"
	                 + " </div></html>");
     		 titre1.setPreferredSize(new Dimension(400,90));
     		
     		JLabel ment=new JLabel("<html> <div id='bloc_page'><u>MENTION</u>&nbsp;:&nbsp;"+mention+"&nbsp;</div></html>");
     		parc=new JLabel("<html> <div id='bloc_page'>Année&nbsp;d'étude : "+niveau.getText()+" "+(String)Filiere.getSelectedItem()+"</div></html>");
     		JLabel parc2=new JLabel("<html> <div id='bloc_page'>"
     				+ "<p>Type&nbsp;de&nbsp;formation*:&nbsp;</p> "
     				+ "<p>(veuillez&nbsp;cocher)&nbsp;</p> </font></div></html>");
     		JLabel parc3=new JLabel("<html> <div id='bloc_page'>"
     				+ "<p> <font face= 'arial' size='3'>Formation&nbsp;initiale&nbsp;</p>"
     				+ "<p>Formation&nbsp;continue&nbsp;</p> </font></div></html>");
     		JLabel loc=new JLabel("<html> <div id='bloc_page'><u>Localisation</u>:&nbsp;ANDRAINJATO&nbsp;"
     				+ "FIANARANTSOA&nbsp;</div></html>");
     		// titre1.setBorder(line);
     		ment.setPreferredSize(new Dimension(290,15));
     		parc.setPreferredSize(new Dimension(290,15));
     		parc2.setPreferredSize(new Dimension(500,50));
     		loc.setPreferredSize(new Dimension(290,15));
     		//parc.setHorizontalAlignment(JLabel.CENTER);
     		parc2.setPreferredSize(new Dimension(120,70));
     		parc3.setPreferredSize(new Dimension(120,70));
     		
     		JPanel lab1=new JPanel();
     		JPanel lab2=new JPanel();
     		JPanel pan3=new JPanel();
     		
     		lab1.setPreferredSize(new Dimension(30,12));
     		lab2.setPreferredSize(new Dimension(30,12));
     		pan3.setPreferredSize(new Dimension(40,35));
     		
     		lab1.setBorder(line);
     		lab2.setBorder(line);
     	
     		JPanel pan1=new JPanel();
     		JPanel pan2=new JPanel();
     		pan2.setLayout(new FlowLayout(FlowLayout.LEFT));
     		panInfDelib.add(logo1);
     		panInfDelib.add(titre1);
     		panInfDelib.add(logo2);
     		pan1.add(loc);
     		pan1.add(ment);
     		pan1.add(parc);
     		pan2.add(parc2);
     		pan2.add(parc3);
     		pan3.add(lab1);
     		pan3.add(lab2);
     		pan2.add(pan3);
     		panInfDelib.add(pan1);
     		panInfDelib.add(pan2);
     		
     		pan1.setPreferredSize(new Dimension(300,70));
     		pan2.setPreferredSize(new Dimension(300,70));
			actual.setPreferredSize(new Dimension(100,25));
			print.setPreferredSize(new Dimension(100,25));
			
			masc.setBounds(117,181,193,30);
			fem.setBounds(309,181,193,30);
			ens.setBounds(501,181,229,30);
			
			vide1.setBounds(10,181,108,335);
			bas.setBounds(10,520,620,60);
			
			
			panInfDelib.setBounds(80,0,610,200);
			panDelib.add(masc,new Integer(1),1);
			panDelib.add(fem,new Integer(2),2);
			panDelib.add(ens,new Integer(3),3);
			panDelib.add(niv,new Integer(3),3);
			panDelib.add(l1,new Integer(3),3);
			panDelib.add(l2,new Integer(3),3);
			panDelib.add(l3,new Integer(3),3);
			panDelib.add(m1,new Integer(3),3);
			panDelib.add(m2,new Integer(3),3);
			panDelib.add(vide,new Integer(3),3);
			panDelib.add(vide1,new Integer(3),3);
			panDelib.add(bas,new Integer(3),3);
			modelDelib=new TableModel(titreDelib);
			modelDelib.addRow(new Object[] {"Age","N","R","T+","S/tot","N","R","T+","S/tot","N","R","T+","Total"});
			modelDelib.addRow(new Object[] {"Moins de 16 ans","","","","","","","","","","","",""});
			for(int s=0;s<13;s++) {
				modelDelib.addRow(new Object[] {(s+16),"","","","","","","","","","","",""});
				if(s==12)
				modelDelib.addRow(new Object[] {(s+17)+"+","","","","","","","","","","","",""});
			}
			modelDelib.addRow(new Object[] {"Total","","","","","","","","","","","",""});
		    tableDelib=new JTable(modelDelib);
			tableDelib.setRowHeight(18);
			tableDelib.setShowGrid(false);
			tableDelib.setPreferredScrollableViewportSize(new Dimension(740,300));
		//	tableDelib[i].setDefaultRenderer(Object.class,new ColorCell(i));

			tableDelib.setShowGrid(true);
			for(int h=0;h<modelDelib.getColumnCount();h++)
			tableDelib.getColumnModel().getColumn(h).setCellRenderer(centerRenderer);
			tableDelib.getTableHeader().setVisible(true);
			tableDelib.setFillsViewportHeight(true);
			tableDelib.getColumnModel().getColumn(0).setPreferredWidth(100);
			tableDelib.getColumnModel().getColumn(1).setPreferredWidth(40);
			tableDelib.getColumnModel().getColumn(2).setPreferredWidth(40);
			tableDelib.getColumnModel().getColumn(3).setPreferredWidth(40);
			tableDelib.getColumnModel().getColumn(4).setPreferredWidth(40);
			tableDelib.getColumnModel().getColumn(5).setPreferredWidth(40);
			tableDelib.getColumnModel().getColumn(6).setPreferredWidth(40);
			tableDelib.getColumnModel().getColumn(7).setPreferredWidth(40);
			tableDelib.getColumnModel().getColumn(8).setPreferredWidth(40);
			tableDelib.getColumnModel().getColumn(9).setPreferredWidth(40);
			tableDelib.getColumnModel().getColumn(10).setPreferredWidth(40);
			tableDelib.getColumnModel().getColumn(11).setPreferredWidth(40);
			tableDelib.setBounds(10,210,720,320);

			panDelib.add(panInfDelib,new Integer(0), 0);
			panDelib.add(tableDelib,new Integer(1),1);
     	
			DataBase.statDate(mention,Integer.parseInt(LoginPrincipale.anneField.getText().substring(5, 9)),
					(String)combo.getSelectedItem(),(String)Filiere.getSelectedItem(), modelDelib);
			modelPanDelib=new DefaultTableModel() {
				public boolean isCellEditable(int row, int col){
					return false;
				}
			};
			
			modelPanDelib.addColumn(titrePanDelib[0]);
			tablePanDelib=new JTable(modelPanDelib);
			tablePanDelib.setPreferredScrollableViewportSize(new Dimension(750,580));
			panPanDelib.add(new JScrollPane(tablePanDelib));
			
			panPrincipale.setBackground(Color.cyan);
			panNote.setBackground(Color.cyan);
			
			panTete.setBackground(Color.white);
			panInfDelib.setBackground(Color.white);
			panRecNote.setBackground(Color.white);
			
			pan1.setBackground(Color.white);
			pan2.setBackground(Color.white);
			pan3.setBackground(Color.white);
			
			panNote.setLayout(new FlowLayout(FlowLayout.LEFT));
			panTete.setLayout(new FlowLayout(FlowLayout.LEFT));
			//panInfDelib.setLayout(new FlowLayout(FlowLayout.LEFT));
			panNote.setPreferredSize(new Dimension(800,650));
			panNote.add(panPanDelib);
			panNote.add(print);
			panNote.add(actual);
			panNote.add(combo);
			panNote.add(Filiere);
			panNote.add(histFil);
			this.add(panNote);
			
			histFil.setPreferredSize(new Dimension(100,25));
			//tableDelib.setPreferredScrollableViewportSize(new Dimension(530,modelDelib[i].getRowCount()*30));
			panDelib.setPreferredSize(new Dimension(800,600));
			panDelib.setBackground(Color.white);
			modelPanDelib.addRow(new Object[] {panDelib});
			tablePanDelib.setDefaultRenderer(Object.class, new Multirender(panDelib));
			tablePanDelib.setRowHeight(590);
			
			//panPrincipale[i].setPreferredSize(new Dimension(800,680));
			
			histFil.addActionListener(new histAge());
			print.addActionListener(new Imprimer());
			actual.addActionListener(new actual());
			combo.addActionListener(new combo());
			Filiere.addActionListener(new combo());	
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
	
	public  class histAge implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			HistParAge demo=new HistParAge ( "Histogramme" ,modelDelib );
			demo.pack();
			demo.setVisible(true);
		}
	}
	
	
	public  class Imprimer implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			new FenetreImpressionStatistiqueAge(modelPanDelib,modelDelib,panDelib).setVisible(true);
		}
	}
	
	public  class actual implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			Main.main.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			tablePanDelib.setVisible(false);
			DataBase.statDate(mention,Integer.parseInt(LoginPrincipale.anneField.getText().substring(5, 9)),
					(String)combo.getSelectedItem(),(String)Filiere.getSelectedItem(), modelDelib);
			tablePanDelib.setVisible(true);
			Toolkit.getDefaultToolkit().beep();
			Main.main.setVisible(true);
			Main.main.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}
	}
	
	public  class combo implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			Main.main.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			tablePanDelib.setVisible(false);
			parc.setText("<html> <div id='bloc_page'>Année&nbsp;d'étude : "+(String)combo.getSelectedItem()+" "
					+ (String)Filiere.getSelectedItem()+"</div></html>");
			DataBase.statDate(mention,Integer.parseInt(LoginPrincipale.anneField.getText().substring(5, 9)),
					(String)combo.getSelectedItem(),(String)Filiere.getSelectedItem(), modelDelib);
			tablePanDelib.setVisible(true);
			Toolkit.getDefaultToolkit().beep();
			Main.main.setVisible(true);
			Main.main.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}
	}
	

	
}
	  
	





