package carte;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableCellRenderer;

import data_base.DataBase;
import image.ImageBonneQualite;

public class FaceCarte implements TableCellRenderer{ 
	
	public static JPanel paneTab;
	public static JPanel paneTete;
	public static JPanel paneCentre;
	public static JPanel paneBas;
	public static JPanel paneSigne; 
	public static JPanel paneSigneChef; 
	public static JPanel pane;
	public static JPanel paneVide;
	public static JPanel paneVidel;
	public static JPanel paneParc;
	
	public static Border line= new LineBorder(Color.white);
	public static Border  tite1= new TitledBorder(line,"Signature",TitledBorder.DEFAULT_POSITION,
    		TitledBorder.DEFAULT_POSITION,new Font("arial",Font.BOLD,8),Color.black);
	
	
	public static Border  tite= new TitledBorder(new LineBorder(new Color(0,0,0,0))," Le chef de service de scolarité",
    		TitledBorder.ABOVE_TOP,TitledBorder.DEFAULT_JUSTIFICATION,new Font("arial",Font.BOLD,8),Color.black);
	
	public static Border  carte= new TitledBorder(new LineBorder(Color.black),"",
    		TitledBorder.ABOVE_TOP,TitledBorder.DEFAULT_JUSTIFICATION,new Font("arial",Font.BOLD,8),Color.black);
	
	public static Border  pic= new TitledBorder(new LineBorder(Color.black),"",
    		TitledBorder.ABOVE_TOP,TitledBorder.DEFAULT_JUSTIFICATION,new Font("arial",Font.BOLD,8),Color.black);
   
	
	public static JTextArea entete;
	
	public static JLabel photo;
	public static JLabel logoFac;
	public static JLabel logoUniv;
	
	public static JLabel nom;
	public static JLabel prenom;
	public static JLabel cin;
	public static JLabel dateNaiss;
	public static JLabel lieuNaiss;
	public static JLabel du;
	public static JLabel a;
	public static JLabel numCarte;
	
	public static JLabel nomTxt;
	public static JLabel prenomTxt;
	public static JLabel cinTxt;
	public static JLabel dateNaissTxt;
	public static JLabel lieuNaissTxt;
	public static JLabel duTxt;
	public static JLabel aTxt;
	public static JLabel numCarteTxt;
	public static JLabel nomSco;
	public static JLabel nomChefSco;
	
	
	public static Font police=new Font("arial",Font.BOLD,7);
	public static Font police1=new Font("arial",Font.BOLD,7);
	
	public static JButton imp=new JButton("IMPRIMER");
	public static JFrame main= new JFrame();
	
	public static JScrollPane scrollPane ;
	public static String clas;
	public String mention;
	public FaceCarte(String mention,String clas) {
		FaceCarte.clas=clas;
		this.mention=mention;
		
	}
	
		public Component getTableCellRendererComponent(JTable table, Object value,
		boolean isSelected, boolean hasFocus, int row, int column) {  
			
		     RecuperInfo feed = (RecuperInfo)value;
		    JButton showButton = new JButton("View Articles"); 
		    
		    entete = new  JTextArea("             UNIVERSITE DE FIANARANTSOA \n"
					+ "                   FACULTE DES SCIENCES  "
		    		+ "\n         "+mention.toUpperCase()+" ");
		    
			photo=new JLabel();
			logoFac=new JLabel();
			logoUniv=new JLabel();
		    
		    numCarte=new JLabel("Carte d'étudiant N° :");
			nom=new JLabel("Nom :");
			prenom=new JLabel("Prénom :");
			dateNaiss=new JLabel("Date de Naissance :");
			lieuNaiss=new JLabel("Lieu de Naissance :");
			cin=new JLabel("CIN :");
			du=new JLabel("du :");
		    a=new JLabel("à ");
		    nomSco=new JLabel("");
			nomChefSco=new JLabel(feed.sco);
			
			numCarteTxt=new JLabel(feed.nume+" "+feed.h+""+DataBase.database.substring(12,14));
			nomTxt=new JLabel(feed.nom);
			prenomTxt=new JLabel(feed.prenom);
			dateNaissTxt=new JLabel(feed.dat_naiss);
			lieuNaissTxt=new JLabel(feed.lieu_naiss);
			cinTxt=new JLabel(feed.cin);
			duTxt=new JLabel(feed.date_cin);
			aTxt=new JLabel(feed.lieu_cin);
			
			switch(clas) {
			case "L1":
				paneTab=new PanneauL1("C:/Program Files (x86)/JDev/DataSciences/carteMaths/cmathl1.jpg");
				break;
			case "L2":
				paneTab=new PanneauL2("C:/Program Files (x86)/JDev/DataSciences/carteMaths/cmathl2.jpg");
				break;
			case "L3":
				paneTab=new PanneauL3("C:/Program Files (x86)/JDev/DataSciences/carteMaths/cmathl3.jpg");
				break;
			case "M1":
				paneTab=new PanneauM1("C:/Program Files (x86)/JDev/DataSciences/carteMaths/cmathm1.jpg");
				break;
			case "M2":
				paneTab=new PanneauM2("C:/Program Files (x86)/JDev/DataSciences/carteMaths/cmathm2.jpg");
				break;
			}
			paneTete=new JPanel();
			paneCentre=new JPanel();
			paneBas=new JPanel();
			paneSigne=new JPanel();
			paneSigneChef=new JPanel();
			paneVide=new JPanel();
			paneVidel=new JPanel();
			paneParc=new VerticalLabel(feed.l);
			
			paneVide.setPreferredSize(new Dimension(1,175));
			paneVide.setBackground(Color.BLACK);;
			paneVidel.setPreferredSize(new Dimension(520,1));
			paneVidel.setBackground(Color.BLACK);;
			
			
			numCarte.setFont(police1);
			nom.setFont(police1);
			prenom.setFont(police1);
			dateNaiss.setFont(police1);
			lieuNaiss.setFont(police1);
			cin.setFont(police1);
			du.setFont(police1);
			
			nomSco.setFont(police);
			nomChefSco.setFont(police);
			nomChefSco.setForeground(Color.white);
			
			numCarteTxt.setFont(police1);
			nomTxt.setFont(police1);
			prenomTxt.setFont(police1);
			dateNaissTxt.setFont(police1);
			lieuNaissTxt.setFont(police1);
			cinTxt.setFont(police1);
			duTxt.setFont(police1);
			aTxt.setFont(police1);
			a.setFont(police1);
			
			//logoUniv=new JLabel("<html> <img src="+Main.class.getResource("/logoUniv.png")+" height='30',width='30'> ");
			logoUniv=new JLabel();
			logoFac=new JLabel();
			logoUniv.setIcon(ImageBonneQualite.imageLogo("C:/Program Files (x86)/JDev/DataSciences/logo/logoUniv.png",30));
			logoFac.setIcon(ImageBonneQualite.imageLogo("C:/Program Files (x86)/JDev/DataSciences/logo/logoFac.png",30));
			entete.setOpaque(false);
			entete.setEditable(false);
			entete.setFont(police);
			
			numCarte.setPreferredSize(new Dimension(66,5));
			nom.setPreferredSize(new Dimension(20,5));
			prenom.setPreferredSize(new Dimension(30,5));
			dateNaiss.setPreferredSize(new Dimension(68,5));
			lieuNaiss.setPreferredSize(new Dimension(68,5));
			cin.setPreferredSize(new Dimension(20,5));
			du.setPreferredSize(new Dimension(15,5));
			a.setPreferredSize(new Dimension(8,5));
			
			numCarteTxt.setPreferredSize(new Dimension(50,7));
			nomTxt.setPreferredSize(new Dimension(97,7));
			prenomTxt.setPreferredSize(new Dimension(87,7));
			dateNaissTxt.setPreferredSize(new Dimension(48,7));
			lieuNaissTxt.setPreferredSize(new Dimension(48,7));
			cinTxt.setPreferredSize(new Dimension(98,7));
			duTxt.setPreferredSize(new Dimension(40,7));
			aTxt.setPreferredSize(new Dimension(46,7));
			
			entete.setPreferredSize(new Dimension(160,30));
			paneTab.setPreferredSize(new Dimension(255,175));
			
			paneCentre.setPreferredSize(new Dimension(140,90));
			paneTete.setPreferredSize(new Dimension(245,38));
			paneBas.setPreferredSize(new Dimension(160,33));
			//paneParc[i].setPreferredSize(new Dimension(300,90));
			paneSigne.setPreferredSize(new Dimension(80,28));
			paneSigneChef.setPreferredSize(new Dimension(160,0));
			nomChefSco.setPreferredSize(new Dimension(140,10));
			
			paneTete.setBackground(new Color(0,0,0,15));
			paneCentre.setBackground(new Color(0,0,0,35));
			paneBas.setBackground(new Color(0,0,0,35));
			paneParc.setBackground(new Color(0,0,0,35));
			
			paneSigne.setBorder(tite1);
			paneBas.setBorder(tite);
			paneSigneChef.setOpaque(false);
			paneSigne.setOpaque(true);
			nomChefSco.setHorizontalAlignment(JLabel.LEFT);
			paneTab.setBorder(carte);
			photo.setBorder(pic);
			
			paneTete.add(logoUniv);
			paneTete.add(entete);
			paneTete.add(logoFac);
			
			photo.setPreferredSize(new Dimension(80,90));
			
			photo=new JLabel();
			photo.setIcon(ImageBonneQualite.image(feed.pic,75));
			//photo=new JLabel("<html> <img src="+new ImageIcon(feed.pic)+" height='90',width='80'> ");
			
			paneCentre.add(numCarte);
			paneCentre.add(numCarteTxt);
			paneCentre.add(nom);
			paneCentre.add(nomTxt);
			paneCentre.add(prenom);
			paneCentre.add(prenomTxt);
			paneCentre.add(dateNaiss);
			paneCentre.add(dateNaissTxt);
			paneCentre.add(lieuNaiss);
			paneCentre.add(lieuNaissTxt);
			paneCentre.add(cin);
			paneCentre.add(cinTxt);
			paneCentre.add(du);
			paneCentre.add(duTxt);
			paneCentre.add(a);
			paneCentre.add(aTxt);
			
			//paneBas[i].add(nomSco[i]);
			paneBas.add(paneSigneChef);
			paneBas.add(nomChefSco);
			
			
		    paneTab.add(paneTete);
		    paneTab.add(photo);
		    paneTab.add(paneCentre);
		    paneTab.add(paneParc);
		    paneTab.add(paneSigne);
		    paneTab.add(paneBas);
		    paneTab.setLayout(new FlowLayout(FlowLayout.LEFT));
		    
		    
		    
		    showButton.addActionListener(new ActionListener() {       
		      public void actionPerformed(ActionEvent arg0) {         
		      JOptionPane.showMessageDialog(null, "HA-HA!"); } }) ;
		      // panel.setBackground(Color.cyan);  
		       //panel.add(new JLabel(" " + feed.name+ " " + feed.url + "Articles " + feed.articles.length + ""));     
		      //panel.add(showButton);   
		   return paneTab;   
		} 
		}