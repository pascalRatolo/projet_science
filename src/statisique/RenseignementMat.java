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
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import data_base.DataBase;
import image.ImageBonneQualite;
import image.LoadImage;
import impression.FenetreImpressionStatistiqueAge;
import loading.Main;
import login.LoginPrincipale;
import table.TableModel;

@SuppressWarnings("serial")
public class RenseignementMat extends JPanel{
	 
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
	 
	 JButton print=new JButton( LoadImage.transformeb(100, 25, "/imprimer.jpg"));
	 JPanel panValidation;
	 JLabel masc;
	 JLabel fem;
	 JLabel ens;
	 JTable tableDelib;
	 JTable tablePanDelib;
	 JLabel niv;
	 
	 
	 JButton histFil=new JButton();
	 JButton ajout=new JButton("Ajouter droit d'inscription :");
	 JLabel droit;
	 JTextField droitTxt;
	
	 JLabel vide1;
	 JLabel vid;
	 JLabel vide;
	 JLabel logo1=new JLabel();
	 JLabel logo2=new JLabel();
	 String titreComb[]= {"L1","L2","L3","M1","M2"};
	 JComboBox<String> combo= new JComboBox<String>(titreComb);
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
	public  RenseignementMat(String mention,DefaultTableModel modellDelib,String [] titreDelib){
		
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
			masc=new JLabel("Admission en L1");
			fem=new JLabel(" ");
			ens=new JLabel("ENSEMBLE");
			niv=new JLabel("Niveau ");
			
			droit=new JLabel("Droit : ");
			
			droitTxt = new JTextField();
			vide=new JLabel("");
			vide1=new JLabel("");
			vid=new JLabel("");
			
			masc.setBorder(line);
			fem.setBorder(line);
			ens.setBorder(line);
			
			vide.setBorder(line);
			vide1.setBorder(line);
			vid.setBorder(line);
			
			niv.setHorizontalAlignment(JLabel.CENTER);
			
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
	                 + "</font>"
	                 + " </div></html>");
     		
     		 titre1.setPreferredSize(new Dimension(400,90));
     		
     		JLabel ment=new JLabel("<html> <div id='bloc_page'><u>MENTION</u>&nbsp;:&nbsp;"+mention+"&nbsp;</div></html>");
     		parc=new JLabel("<html> <div id='bloc_page'>Année&nbsp;d'étude : "+niveau.getText()+" Mathématiques&nbsp;et&nbsp;Applications</div></html>");
     		
     		JLabel loc=new JLabel("<html> <div id='bloc_page'><u>Localisation</u>:&nbsp;ANDRAINJATO&nbsp;"
     				+ "FIANARANTSOA&nbsp;</div></html>");
     		JLabel anner=new JLabel("<html> <div id='bloc_page'><font face= 'arial' size='4'>"
     				+ "Renseignement&nbsp;sur&nbsp;le&nbsp;filiere&nbsp;et&nbsp;"
     				+ "option&nbsp;au&nbsp;titre&nbsp;de&nbsp;l'année "+LoginPrincipale.anneField.getText()+"</font></div></html>");
     		// titre1.setBorder(line);
     		ment.setPreferredSize(new Dimension(290,15));
     		parc.setPreferredSize(new Dimension(290,15));
     		anner.setPreferredSize(new Dimension(500,30));
     		//parc2.setPreferredSize(new Dimension(500,50));
     		loc.setPreferredSize(new Dimension(290,15));
     		anner.setHorizontalAlignment(JLabel.CENTER);
     		//parc.setHorizontalAlignment(JLabel.CENTER);
     		//parc2.setPreferredSize(new Dimension(120,70));
     		//parc3.setPreferredSize(new Dimension(120,70));
     		
     		
     		JPanel pan2=new JPanel();
     		JPanel pan3=new JPanel();
     		pan2.setPreferredSize(new Dimension(300,35));
     		pan3.setPreferredSize(new Dimension(600,35));
     		
     		pan2.setOpaque(false);
     		pan3.setOpaque(false);
     	
     		JPanel pan1=new JPanel();
     		panInfDelib.add(logo1);
     		panInfDelib.add(titre1);
     		panInfDelib.add(logo2);
     		pan1.add(loc);
     		pan1.add(ment);
     		pan1.add(parc);
     		pan3.add(anner);
     		
     		//pan2.add(parc2);
     		//pan2.add(parc3);
     		panInfDelib.add(pan1);
     		panInfDelib.add(pan2);
     		panInfDelib.add(pan3);
     		
     		
     		pan1.setPreferredSize(new Dimension(300,70));
			actual.setPreferredSize(new Dimension(100,25));
			print.setPreferredSize(new Dimension(100,25));
			
			masc.setBounds(297,245,289,37);
			fem.setBounds(10,245,288,37);
			ens.setBounds(501,181,229,30);
			
			vide1.setBounds(585,245,145,135);
			vid.setBounds(10,245,144,135);
			//bas.setBounds(10,520,600,60);
			
			
			panInfDelib.setBounds(80,0,610,210);
			panDelib.add(masc,new Integer(1),1);
			panDelib.add(fem,new Integer(2),2);
			/*panDelib.add(ens,new Integer(3),3);
			panDelib.add(niv,new Integer(3),3);*/
			
			panDelib.add(vide,new Integer(3),3);
			panDelib.add(vide1,new Integer(3),3);
			panDelib.add(vid,new Integer(3),3);
			modelDelib=new TableModel(titreDelib);
			modelDelib.addRow(new Object[] {"Filière","Année d'etude","Nbr de demande reçue","Nbr d'étudiants admis","Droit d'inscription (Ariary)"});
			modelDelib.addRow(new Object[] {"","","",""});
		    tableDelib=new JTable(modelDelib);
			tableDelib.setRowHeight(50);
			tableDelib.setShowGrid(false);
			tableDelib.setPreferredScrollableViewportSize(new Dimension(740,200));

			tableDelib.setShowGrid(true);
			for(int h=0;h<modelDelib.getColumnCount();h++)
			tableDelib.getColumnModel().getColumn(h).setCellRenderer(centerRenderer);
			tableDelib.getTableHeader().setVisible(true);
			tableDelib.setFillsViewportHeight(true);
			tableDelib.getColumnModel().getColumn(0).setPreferredWidth(148);
			tableDelib.getColumnModel().getColumn(1).setPreferredWidth(148);
			tableDelib.getColumnModel().getColumn(2).setPreferredWidth(148);
			tableDelib.getColumnModel().getColumn(3).setPreferredWidth(148);
			tableDelib.getColumnModel().getColumn(4).setPreferredWidth(148);
			
			
			tableDelib.setBounds(10,280,720,320);

			panDelib.add(panInfDelib,new Integer(0), 0);
			panDelib.add(tableDelib,new Integer(1),1);
     	
			DataBase.statRenseignement(modelDelib,mention);
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
			
			droitTxt.setPreferredSize(new Dimension(80,25));
			droit.setPreferredSize(new Dimension(40,25));
			
			panNote.setLayout(new FlowLayout(FlowLayout.LEFT));
			panTete.setLayout(new FlowLayout(FlowLayout.LEFT));
			//panInfDelib.setLayout(new FlowLayout(FlowLayout.LEFT));
			panNote.setPreferredSize(new Dimension(800,650));
			panNote.add(panPanDelib);
			panNote.add(print);
			panNote.add(actual);
			panNote.add(ajout);
			panNote.add(droit);
			panNote.add(droitTxt);
			//panNote.add(combo);
			this.add(panNote);
			
			droitTxt.setEditable(false);
			//tableDelib.setPreferredScrollableViewportSize(new Dimension(530,modelDelib[i].getRowCount()*30));
			panDelib.setPreferredSize(new Dimension(800,600));
			panDelib.setBackground(Color.white);
			modelPanDelib.addRow(new Object[] {panDelib});
			tablePanDelib.setDefaultRenderer(Object.class, new Multirender(panDelib));
			tablePanDelib.setRowHeight(590);
			
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
			new FenetreImpressionStatistiqueAge(modelPanDelib,modelDelib,panDelib).setVisible(true);
		}
	}
	
	public  class actual implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			Main.main.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			tablePanDelib.setVisible(false);
			DataBase.statRenseignement(modelDelib,mention);
			tablePanDelib.setVisible(true);
			if(droitTxt.getText().length()!=0) {
			modelDelib.setValueAt(droitTxt.getText(), 1, 4);
			}
			droitTxt.setEditable(false);
			Toolkit.getDefaultToolkit().beep();
			Main.main.setVisible(true);
			Main.main.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}
	}
	
	
	

	
}

