package inscription;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import data_base.DataBase;
import image.ImageBonneQualite;
import image.LoadImage;
import impression.FenetreImpressionListe;
import loading.Main;
import loading.Methode;
import login.LoginPrincipale;
import table.TableModel;

@SuppressWarnings("serial")
public class Inscription<tabcombo> extends JScrollPane{   
	
	public  String tite[]= {"Du","à","à l'E.E.S","Mention","Dipl.obtenu",
								  "Du","à","à l'E.E.S","Mention","Dipl.obtenu",
								  };
	
	public  String anneTab[]= {" ","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009",
								  "2010","2011","2012","2013","2014","2015","2016","2017","2018","2019",
								  "2020","2021","2022","2023","2024","2025","2026","2027","2028","2029",
								  "2030"};
	
	
	
	public  JLabel montant= new JLabel("MONTANT (AR) :");
	public  JLabel numQuit= new JLabel("N°QUIT :");
	public  JLabel dateQuit= new JLabel("DATE QUIT:");
	
	public  String serieTab[]= {"A1","A2","C","D","Tech.Génie civile",
			                     "téchnique","Tech.Tertiaire","Tech.Agricole",
			                      "Technique","Autre"};
	public  String nationaliteTab[]= {"","Malagasy","Africaine","Asiatique","Comorienne","Europeenne","Autres"};
	public String situationTab[]= {" ","Célibataire","Marié(e)","Divorcé(e)","Veuf(ve)"};
	public  String sexeTab[]= {" ","Masculin","Feminin"};
	
	public  JLabel num=new JLabel("N°d'inscription : ");
	public  JLabel nom=new JLabel("NOM: ");
	public  JLabel prenom=new JLabel("Prénom: ");
	public  JLabel naiss=new JLabel("Né(é) le : ");
	public  JLabel a1=new JLabel("à: ");
	public  JLabel nation=new JLabel("Nationalité: ");
	public  JLabel sexe=new JLabel("Sexe: ");
	public  JLabel situation=new JLabel("Situation familiale: ");
	public  JLabel numTel=new JLabel("N°Tel: ");
	public  JLabel cin=new JLabel("CIN: ");
	public  JLabel delivre=new JLabel("Delivré le : ");
	public  JLabel a2=new JLabel("à: ");
	public  JLabel serieBacc=new JLabel("Série BACC : ");
	public  JLabel anneBacc=new JLabel("Année d'obtention : ");
	public  JLabel numBacc=new JLabel("N°du BACC : ");
	public  JLabel centreBacc=new JLabel("Centre: ");
	public  JLabel adresseEt=new JLabel("Adresse de l'étudiant : ");
	public  JLabel professionEt=new JLabel("Profession : ");
	public  JLabel nomPere=new JLabel("Nom du père : ");
	public  JLabel professionPere=new JLabel("Profession : ");
	public  JLabel nomMere=new JLabel("Nom de la mère: ");
	public  JLabel professionMere=new JLabel("Profession : ");
	public  JLabel adressePa=new JLabel("Adresse des parents : ");
	
	public  JLabel tabLab []= {nom,prenom,naiss,a1,nation,sexe,situation,numTel,
									cin,delivre,a2,serieBacc,anneBacc,numBacc,centreBacc,
									adresseEt,professionEt,nomPere,professionPere,nomMere,
									professionMere,adressePa};
	
	public   JLabel lab[];
	
	public  JComboBox<?>   serieBox=new JComboBox<Object>  (serieTab);
	public  JComboBox<?>   situationBox=new JComboBox<Object>  (situationTab);
	public  JComboBox<?>   sexeBox=new JComboBox<Object>  (sexeTab);
	public  JComboBox<?>   nationBox=new JComboBox<Object>  (nationaliteTab);
	public  JComboBox<?>   anneBox=new JComboBox<Object> (anneTab);
	
	public  JTextField  numTxt=new JTextField();
	public  JTextField  numTelTxt=new FieldFormat ("phone");
	public  JTextField  numCinTxt=new FieldFormat ("cin");
	public  JTextField  dateCinTxt=new FieldFormat ("date");
	public  JTextField  lieuCinTxt=new JTextField ();
	public  JTextField  numBaccTxt=new FieldFormat ("bacc");
	public  JTextField  centreBaccTxt=new JTextField ();
	public  JTextField  adresseEtTxt=new JTextField ();
	public  JTextField  professionEtTxt=new JTextField ();
	public  JTextField  nomPereTxt=new JTextField ();
	public  JTextField  professionPereTxt=new JTextField ();
	public  JTextField  nomMereTxt=new JTextField ();
	public  JTextField  professionMereTxt=new JTextField ();
	public  JTextField  adressePaTxt=new JTextField ();
	public  JTextField  nomEtTxt=new JTextField ();
	public  JTextField  prenomEtTxt=new JTextField ();
	public  JTextField  dateNaisTxt=new FieldFormat ("date");
	public  JTextField  lieuNaissTxt=new JTextField ();
	public  JTextField montantTxt= new JTextField();
	public  JTextField numQuitTxt= new JTextField();
	public  JTextField dateQuitTxt= new FieldFormat ("date");
	
	public  JTextField txtTab1[]= {nomEtTxt,prenomEtTxt,adresseEtTxt,professionEtTxt,adressePaTxt};
	public  JTextField txtTab3[]= {professionPereTxt,professionMereTxt};
	public  JTextField txtTab2[]= {lieuNaissTxt,dateCinTxt,lieuCinTxt,centreBaccTxt,nomPereTxt,nomMereTxt};
	
	public  JTextField tabField11 []= {numTxt,nomEtTxt,prenomEtTxt,
			dateNaisTxt,lieuNaissTxt,numTelTxt,
			numCinTxt,dateCinTxt,lieuCinTxt,numBaccTxt,
			centreBaccTxt,adresseEtTxt,professionEtTxt,
			nomPereTxt,professionPereTxt,nomMereTxt,professionMereTxt,
			adressePaTxt,montantTxt,numQuitTxt,dateQuitTxt};
	
	public  JTextField field[];
	

	
	public  JPanel panelPrincipale=new JPanel();
	public  JPanel panelInscription=new JPanel();
	public  JPanel panelTable=new JPanel();
	public  JPanel ligne1=new JPanel();
	public  JPanel ligne2=new JPanel();
	public  JPanel ligne3=new JPanel();
	public  JPanel ligne4=new JPanel();
	public  JPanel ligne5=new JPanel();
	public  JPanel ligne6=new JPanel();
	public  JPanel ligne7=new JPanel();
	public  JPanel ligne8=new JPanel();
	public  JPanel ligne9=new JPanel();
	public  JPanel ligne10=new JPanel();
	public  JPanel panTete=new JPanel();
	
	public  JLabel entete=new JLabel(" UNIVERSITE DE FIANARANTSOA ");
	public  JLabel entete1=new JLabel(" FACULTE DES SCIENCES ");
	public  JLabel entete2=new JLabel("CONNAISSANCE-EXCELLENCE-RIGUEUR ");
	
	public  JLabel enBas=new JLabel("Autre Université fréquanté dépuis l'obtention du Baccalauréat ");
	public  JLabel logo1= new JLabel();
	public  JLabel logo2= new JLabel();
	public  JLabel image= new JLabel();
	
	public  JLabel titreInscription= new JLabel("INSCRIPTION");
	public  JLabel titreTable= new JLabel(" LISTE DES ETUDIANTS INSCRITS ");
	
	public  Font police1= new Font("arial",Font.BOLD,23);
	public  Font police2= new Font("arial",Font.BOLD,18);
	public  Font police3= new Font("arial",Font.BOLD,12);
	public  Font police4= new Font("arial",Font.BOLD,14);
	
	public  JButton enreg  =new JButton( LoadImage.transformeb(100, 25, "/save.jpg"));
	public  JButton annule =new JButton( LoadImage.transformeb(100, 25, "/annul.jpg"));
	public  JButton enregmod =new JButton( LoadImage.transformeb(100, 25, "/Ok.jpg"));

	public  JButton mod=new JButton (LoadImage.transformeb(100, 25, "/Modif.jpg"));
	public  JButton supp=new JButton(LoadImage.transformeb(100, 25, "/Supprimer.jpg"));
	public  JButton home=new JButton( LoadImage.transformeb(100, 25, "/home.jpg"));
	public  JButton print=new JButton( LoadImage.transformeb(100, 25, "/imprimer.jpg"));
	public  JButton actual=new JButton( LoadImage.transformeb(100, 25, "/actualiser.jpg"));
	public  JButton term=new JButton( LoadImage.transformeb(100, 25, "/ok.jpg"));
	public  JButton reset=new JButton(LoadImage.transformeb(100, 25, "/croi.jpg"));
	
	
	
	
	public  JLabel niv=new JLabel("Niveau: ");
	
	public  String typeMaths[]= {" ","T.C.M","Master one","Master two"};
	public  JComboBox<String> typeEtMaths=new JComboBox<String>(typeMaths);
	public  JLabel fil=new JLabel("Parcours: ");

	public  String typefilMaths[]= {" ","M.I.S.S","M.E","M.F"};
	public  JComboBox<String> typefilCombMaths=new JComboBox<String>(typefilMaths);
	
	public  JComboBox<String> typeEt;
	public  JComboBox<String> typefilComb;
	public  JComboBox<String> typefilComb1;
	
	public  JComboBox<?> tabcombo[]= {nationBox,sexeBox,situationBox,
		serieBox,anneBox,typeEt,typefilComb};
	
	public  JScrollPane scrollPane;
	public  int k=0;

	public  JButton retour=new JButton("Retour");
	public  DefaultTableModel model =new DefaultTableModel();
	public  String title[]= {"N°Inscription","N°Carte"," Nom et Prenom "," Niveau "};
	public  String mention;
	public JTable table;
	
	public  Inscription(String mention) {
		this.mention=mention;
		titreTable= new JLabel(" LISTE DES ETUDIANTS INSCRITS EN "+mention);
		panelTable.add(titreTable);
		DefaultTableCellRenderer centerRenderer= new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		
		model=new TableModel(title);
		switch(mention) {
		case "MATHEMATIQUES ET APPLICATIONS":
			typeEt=typeEtMaths;
			typefilComb=typefilCombMaths;
			break;
		}
		model=new DataBase().importDonneIns(model,mention);
		table =new JTable(model);
		for (int c=0; c<4;c++) {
			if(c!=2)
			table.getColumnModel().getColumn(c).setCellRenderer(centerRenderer);
		}
		table.setPreferredScrollableViewportSize(new Dimension(670,580));
		table.setFillsViewportHeight(true);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(30);
		table.getColumnModel().getColumn(2).setPreferredWidth(320);
		table.getColumnModel().getColumn(3).setPreferredWidth(120);
		panelTable.add(new JScrollPane(table));
		panelTable.add(term);
		panelTable.add(print);
		print.setPreferredSize(new Dimension(100,25));
		term.setPreferredSize(new Dimension(100,25));
		
		annule.setPreferredSize(new Dimension(100,25));
		actual.setPreferredSize(new Dimension(100,25));
		reset.setPreferredSize(new Dimension(30,20));
		mod.setPreferredSize(new Dimension(100,25));
		supp.setPreferredSize(new Dimension(100,25));
		enreg.setPreferredSize(new Dimension(100,25));
		enregmod.setPreferredSize(new Dimension(100,25));
		image=new JLabel(new ImageIcon((Image)ImageBonneQualite.scaleImage(120,120,"/profil.png")));
		//logo2=new JLabel(new ImageIcon((Image)ImageBonneQualite.scaleImage(80,80,"/logo_fac.jpg")));
		//logo1=new JLabel(new ImageIcon((Image)ImageBonneQualite.scaleImage(80,80,"/logoUniv.png")));
		logo1.setIcon(ImageBonneQualite.image("C:/Program Files (x86)/JDev/DataSciences/image/logoUniv.png",80));
		logo2.setIcon(ImageBonneQualite.image("C:/Program Files (x86)/JDev/DataSciences/image/logoFac.png",90));
		logo1.setPreferredSize(new Dimension(80,100));
		//logo1.setOpaque(true);
		logo2.setPreferredSize(new Dimension(80,80));
		image.setPreferredSize(new Dimension(120,120));
		
		panTete.setPreferredSize(new Dimension(500,140));
		ligne1.setPreferredSize(new Dimension(300,80));
		ligne2.setPreferredSize(new Dimension(620,1));
		ligne3.setPreferredSize(new Dimension(100,2));
		ligne4.setPreferredSize(new Dimension(122,2));
		ligne5.setPreferredSize(new Dimension(72,2));

		ligne6.setPreferredSize(new Dimension(620,1));
		ligne7.setPreferredSize(new Dimension(630,1));
		ligne8.setPreferredSize(new Dimension(620,5));
		ligne9.setPreferredSize(new Dimension(120,120));
		ligne10.setPreferredSize(new Dimension(490,1));
		
		
		image.setOpaque(true);
		entete.setPreferredSize(new Dimension(400,15));
		entete1.setPreferredSize(new Dimension(400,28));
		entete2.setPreferredSize(new Dimension(400,10));
		
		entete.setHorizontalAlignment(JLabel.CENTER);
		entete1.setHorizontalAlignment(JLabel.CENTER);
		entete2.setHorizontalAlignment(JLabel.CENTER);
		
		montant.setPreferredSize(new Dimension(100,30));	
		numQuit.setPreferredSize(new Dimension(50,30));	
		dateQuit.setPreferredSize(new Dimension(70,30));
		
		montantTxt.setPreferredSize(new Dimension(80,20));	
		numQuitTxt.setPreferredSize(new Dimension(80,20));	
		dateQuitTxt.setPreferredSize(new Dimension(80,20));
		
		entete.setFont(police4);
		entete1.setFont(police1);
		entete2.setFont(police4);
		
		logo1.setOpaque(true);
		logo2.setOpaque(true);
		
		entete.setForeground(Color.green);
		entete2.setForeground(Color.green);
		
		panelPrincipale.setBackground(Color.gray);
		panelInscription.setBackground(Color.white);
		
		ligne1.setBackground(Color.white);
		ligne2.setBackground(Color.black);
		ligne6.setBackground(Color.black);
		panTete.setBackground(Color.white);
		ligne9.setOpaque(false);
		//panelInscription.setBackground(Color.white);
		
		titreInscription.setFont(police2);
		titreTable.setFont(police2);
		
		
		panelInscription.setPreferredSize(new Dimension(650,675));
		panelTable.setPreferredSize(new Dimension(680,675));
		
		for(int i=0;i<txtTab1.length;i++)
			txtTab1[i].setPreferredSize(new Dimension(550,20));
		
		for(int i=0;i<txtTab2.length;i++)
			txtTab2[i].setPreferredSize(new Dimension(130,20));
		
		for(int i=0;i<txtTab3.length;i++)
			txtTab3[i].setPreferredSize(new Dimension(380,20));
		for(int i=0;i<tabLab.length;i++)
			tabLab[i].setFont(police3);
		
		lab=new JLabel[tite.length];
		field=new JTextField[tite.length];
		
		for(int i=0;i<tite.length;i++) {
			lab[i]=new JLabel(tite[i]);
			field[i]=new JTextField();
			field[i].setPreferredSize(new Dimension(85,20));
		}
		
		enBas.setFont(police3);
		//panelInscription.add(titreInscription);
		
		
		
		panelInscription.add(ligne9);
		
		panTete.add(logo1);
		panTete.add(ligne1);
		ligne9.add(image);
		
		
		ligne1.add(entete);
		ligne1.add(entete1);
		ligne1.add(entete2);
		
		panTete.add(logo2);
		num.setFont(police3);
		
		numTxt.setPreferredSize(new Dimension(80,20));
	
		//panelInscription.add(ligne10);
		panTete.add(num);
		panTete.add(numTxt);
		panTete.add(niv);
		panTete.add(typeEt);
		
		panTete.add(fil);
		panTete.add(typefilComb);
		typefilComb.setVisible(false);
		fil.setVisible(false);
		panelInscription.add(panTete);
		panelInscription.add(ligne2);
		for(int i=0;i<tabLab.length;i++) {
			switch(i) {
			
			case 0:
				tabLab[i].setPreferredSize(new Dimension(60,30));
				panelInscription.add(tabLab[i]);
				panelInscription.add(txtTab1[i]);
			break;
			
			case 1:
				tabLab[i].setPreferredSize(new Dimension(60,30));
				panelInscription.add(tabLab[i]);
				panelInscription.add(txtTab1[i]);
			break;
			
			case 2:

				tabLab[i].setPreferredSize(new Dimension(60,30));
				dateNaisTxt.setPreferredSize(new Dimension(80,20));
				panelInscription.add(tabLab[i]);
				panelInscription.add(dateNaisTxt);
			break;
			
			case 3:
				txtTab2[0].setPreferredSize(new Dimension(185,20));
				panelInscription.add(tabLab[i]);
				panelInscription.add(txtTab2[0]);
			break;
			
			case 4:
				nationBox.setPreferredSize(new Dimension(80,20));
				panelInscription.add(tabLab[i]);
				panelInscription.add(nationBox);
				panelInscription.add(ligne3);
				
			break;
			
			case 5:
				tabLab[i].setPreferredSize(new Dimension(60,30));
				sexeBox.setPreferredSize(new Dimension(80,20));
				panelInscription.add(tabLab[i]);
				panelInscription.add(sexeBox);
			break;
			
			case 6:
				situationBox.setPreferredSize(new Dimension(90,20));
				panelInscription.add(tabLab[i]);
				panelInscription.add(situationBox);
			break;
			
			case 7:
				numTelTxt.setPreferredSize(new Dimension(90,20));
				panelInscription.add(tabLab[i]);
				panelInscription.add(numTelTxt);
				panelInscription.add(ligne4);
				
			break;
			
			case 8:
				tabLab[i].setPreferredSize(new Dimension(60,20));
				numCinTxt.setPreferredSize(new Dimension(110,20));
				panelInscription.add(tabLab[i]);
				panelInscription.add(numCinTxt);
				
				
			break;
			
			case 9:
				tabLab[i].setPreferredSize(new Dimension(70,30));
				txtTab2[1].setPreferredSize(new Dimension(90,20));
				panelInscription.add(tabLab[i]);
				panelInscription.add(txtTab2[1]);
				//panelInscription.add(ligne4);
				
			break;
			
			case 10:
				//tabLab[i].setPreferredSize(new Dimension(70,20));
				txtTab2[2].setPreferredSize(new Dimension(140,20));
				panelInscription.add(tabLab[i]);
				panelInscription.add(txtTab2[2]);
				panelInscription.add(reset);
				panelInscription.add(ligne5);
				
			break;
			
			case 11:
				tabLab[i].setPreferredSize(new Dimension(80,30));
				serieBox.setPreferredSize(new Dimension(90,20));
				panelInscription.add(tabLab[i]);
				panelInscription.add(serieBox);
			break;
			
			case 12:
				//tabLab[i].setPreferredSize(new Dimension(110,20));
				anneBox.setPreferredSize(new Dimension(60,20));
				panelInscription.add(tabLab[i]);
				panelInscription.add(anneBox);
				//panelInscription.add(ligne6);
			break;
			
			case 13:
				tabLab[i].setPreferredSize(new Dimension(75,30));
				numBaccTxt.setPreferredSize(new Dimension(60,20));
				panelInscription.add(tabLab[i]);
				panelInscription.add(numBaccTxt);
			break;
			
			case 14:
				//tabLab[i].setPreferredSize(new Dimension(50,20));
				txtTab2[3].setPreferredSize(new Dimension(65,20));
				panelInscription.add(tabLab[i]);
				panelInscription.add(txtTab2[3]);
			break;
			
			case 15:
				tabLab[i].setPreferredSize(new Dimension(130,30));
				txtTab1[2].setPreferredSize(new Dimension(480,20));
				panelInscription.add(tabLab[i]);
				panelInscription.add(txtTab1[2]);
			break;
			
			
			
			case 16:
				tabLab[i].setPreferredSize(new Dimension(130,30));
				txtTab1[3].setPreferredSize(new Dimension(480,20));
				panelInscription.add(tabLab[i]);
				panelInscription.add(txtTab1[3]);
			break;
			
			case 17:
				tabLab[i].setPreferredSize(new Dimension(95,30));
				txtTab2[4].setPreferredSize(new Dimension(310,20));
				panelInscription.add(tabLab[i]);
				panelInscription.add(txtTab2[4]);
			break;
			
			case 18:
				tabLab[i].setPreferredSize(new Dimension(75,30));
				txtTab3[0].setPreferredSize(new Dimension(120,20));
				panelInscription.add(tabLab[i]);
				panelInscription.add(txtTab3[0]);
			break;
			
			case 19:
				tabLab[i].setPreferredSize(new Dimension(95,30));
				txtTab2[5].setPreferredSize(new Dimension(310,20));
				panelInscription.add(tabLab[i]);
				panelInscription.add(txtTab2[5]);
			break;
			
			case 20:
				tabLab[i].setPreferredSize(new Dimension(75,30));
				txtTab3[1].setPreferredSize(new Dimension(120,20));
				panelInscription.add(tabLab[i]);
				panelInscription.add(txtTab3[1]);
			break;
			
			case 21:
				tabLab[i].setPreferredSize(new Dimension(130,30));
				txtTab1[4].setPreferredSize(new Dimension(480,20));
				panelInscription.add(tabLab[i]);
				panelInscription.add(txtTab1[4]);
			break;
			
			
			
			}
		}
		
		panelInscription.add(montant);
		panelInscription.add(montantTxt);
		panelInscription.add(numQuit);
		panelInscription.add(numQuitTxt);
		panelInscription.add(dateQuit);
		panelInscription.add(dateQuitTxt);
		
		panelInscription.add(ligne6);
		//panelInscription.add(enBas);
		//panelInscription.add(ligne7);
		for(int i=0;i<tite.length;i++) {
		//	panelInscription.add(lab[i]);
		//	panelInscription.add(field[i]);
			//field[i].setPreferredSize(new Dimension(80,20));
		}
		
		
		
		panelInscription.add(ligne8);
		panelInscription.add(annule);
		panelInscription.add(annule);
		panelInscription.add(enreg);
		panelInscription.add(mod);
		panelInscription.add(supp);
		panelInscription.add(enregmod);
		panelInscription.add(actual);
		
		enregmod.setVisible(false);
		mod.setVisible(false);
		supp.setVisible(false);
		
		panelPrincipale.add(panelInscription);
		panelPrincipale.add(panelTable);
		
		scrollPane = new JScrollPane(panelPrincipale);
		scrollPane.setBounds( 00 , 00, 1250 , 650);
		
		typeEt.addActionListener(new combo());
		action();
	}
	
	public void action() {
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				numCinTxt.setText("");
				dateCinTxt.setText("");
				lieuCinTxt.setText("");
			}
		});
		
		print.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FenetreImpressionListe(model, "Mathematiques et Applications").setVisible(true);
			}
		});
		
		term.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DataBase.modif_carte(Methode.next_anne(LoginPrincipale.anneField.getText()), model.getRowCount()+1);
			}
		});
		
		actual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model=new DataBase().importDonneIns(model,mention);
			}
		});
		
		annule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mod.setVisible(false);
				supp.setVisible(false);
				enregmod.setVisible(false);
				enreg.setVisible(true);
				Methode.renitial( txtTab1, numBaccTxt, numTelTxt, dateNaisTxt
						 ,numTxt, numCinTxt, montantTxt, numQuitTxt,dateQuitTxt, serieBox
						 ,situationBox, nationBox, anneBox, sexeBox, typeEt
						 , typefilComb,fil, table,txtTab2,txtTab3, image);
				Methode.enable1(txtTab1, numBaccTxt, numTelTxt, dateNaisTxt
						 , numTxt, numCinTxt, montantTxt, numQuitTxt, dateQuitTxt, serieBox
						 , situationBox, nationBox,anneBox, sexeBox,typeEt
						 ,typefilComb, txtTab2, txtTab3);
				
			}
		});
		 //ACTION DE MODIFICATION
		mod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Methode.enable1(txtTab1, numBaccTxt, numTelTxt, dateNaisTxt
						 , numTxt, numCinTxt, montantTxt, numQuitTxt, dateQuitTxt, serieBox
						 , situationBox, nationBox,anneBox, sexeBox,typeEt
						 ,typefilComb, txtTab2, txtTab3);
				numTxt.setEditable(false);
				mod.setVisible(false);
				supp.setVisible(false);
				enregmod.setVisible(true);
				
			}
		});
		
		//ACTION D'ENREGISTREMENT APRES MODIFICATION
		enregmod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int option = JOptionPane.showConfirmDialog(Main.main,
						"Voulez-vous appliquer la modification de "
						+numTxt.getText()+" "
								+ "?","ATTENTION!",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);
			if(option == JOptionPane.OK_OPTION){
				String h=(String)typeEt.getSelectedItem();
				String l=(String)typefilComb.getSelectedItem();
				if(h=="T.C.M")
					l="";
				if(Methode.valideIns1(mention, numTxt.getText(), typeEt,
						  nomEtTxt, dateNaisTxt, lieuNaissTxt, adresseEtTxt
						 , numCinTxt,dateCinTxt, lieuCinTxt, montantTxt
						 , numQuitTxt, dateQuitTxt)){
						DataBase.modifier_etudiant_fac(numTxt.getText(), 
						nomEtTxt.getText().toUpperCase(),
						Methode.finitText(prenomEtTxt.getText()), 
						Methode.dateText(dateNaisTxt.getText()), 
						Methode.finitText(lieuNaissTxt.getText()),
						(String)nationBox.getSelectedItem(),
						(String)sexeBox.getSelectedItem(),
						(String)situationBox.getSelectedItem(),
						numTelTxt.getText(),
						numCinTxt.getText(), 
						Methode.dateText(dateCinTxt.getText()), 
						Methode.finitText(lieuCinTxt.getText()),
						(String)serieBox.getSelectedItem(),
						(String)anneBox.getSelectedItem(),numBaccTxt.getText(),
						Methode.finitText(centreBaccTxt.getText()), adresseEtTxt.getText(), 
						professionEtTxt.getText(), nomPereTxt.getText(), 
						professionPereTxt.getText(), nomMereTxt.getText(),
						professionMereTxt.getText(), adressePaTxt.getText(), 
						numTxt.getText(),montantTxt.getText(),
						numQuitTxt.getText(),
						Methode.dateText(dateQuitTxt.getText()),h,l
						);
				
						mod.setVisible(false);
						supp.setVisible(false);
						enregmod.setVisible(false);
						enreg.setVisible(true);
						Methode.renitial( txtTab1, numBaccTxt, numTelTxt, dateNaisTxt
								 ,numTxt, numCinTxt, montantTxt, numQuitTxt,dateQuitTxt, serieBox
								 ,situationBox, nationBox, anneBox, sexeBox, typeEt
								 , typefilComb,fil, table,txtTab2,txtTab3, image);
						Methode.enable1(txtTab1, numBaccTxt, numTelTxt, dateNaisTxt
								 , numTxt, numCinTxt, montantTxt, numQuitTxt, dateQuitTxt, serieBox
								 , situationBox, nationBox,anneBox, sexeBox,typeEt
								 ,typefilComb, txtTab2, txtTab3);
						model=new DataBase().importDonneIns(model,mention);
						
					}
				}
			}
		});
		
		 //ACTION D'ENREGISTREMENT 
		enreg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					if(Methode.valideIns( mention, numTxt.getText(), typeEt,
							  nomEtTxt, dateNaisTxt, lieuNaissTxt, adresseEtTxt
							 , numCinTxt,dateCinTxt, lieuCinTxt, montantTxt
							 , numQuitTxt, dateQuitTxt)){
						int i=typeEt.getSelectedIndex();
						if(i==0){
						
							JOptionPane.showMessageDialog(Main.main, " AUCUN NIVEAU CHOISIR  ", "ERREUR",
									JOptionPane.ERROR_MESSAGE); 
						}
						if(i==1){
							/*DataBase.ajout_etudiant_math_parcours(Integer.parseInt(numTxt.getText()),"S1", "S2",mention);
							DataBase.ajout_etudiant_math( Main.main,Integer.parseInt(
									numTxt.getText()), 
									nomEtTxt.getText().toUpperCase(),
									Methode.finitText(prenomEtTxt.getText()), 
									Methode.dateText(dateNaisTxt.getText()), 
									Methode.finitText(lieuNaissTxt.getText()), 
									adresseEtTxt.getText(), 
									numCinTxt.getText(), 
									Methode.dateText(dateCinTxt.getText()), 
									Methode.finitText(lieuCinTxt.getText()), 
									montantTxt.getText(), 
									numQuitTxt.getText(), 
									Methode.dateText(dateQuitTxt.getText()),"Passant","T.C.M", 
									numTxt.getText());
							*/
									DataBase.ajout_etudiant_fac(
									numTxt.getText(), 
									nomEtTxt.getText().toUpperCase(),
								    Methode.finitText(prenomEtTxt.getText()), 
								    Methode.dateText(dateNaisTxt.getText()), 
									Methode.finitText(lieuNaissTxt.getText()),
									(String)nationBox.getSelectedItem(),
									(String)sexeBox.getSelectedItem(),
									(String)situationBox.getSelectedItem(),
									numTelTxt.getText(),
									numCinTxt.getText(), 
									Methode.dateText(dateCinTxt.getText()), 
									Methode.finitText(lieuCinTxt.getText()),
									(String)serieBox.getSelectedItem(),
									(String)anneBox.getSelectedItem(),
									numBaccTxt.getText(),
									centreBaccTxt.getText(), 
									adresseEtTxt.getText(), 
									professionEtTxt.getText(), 
									nomPereTxt.getText(), 
									professionPereTxt.getText(), 
									nomMereTxt.getText(),
									professionMereTxt.getText(),
									adressePaTxt.getText(), 
									numTxt.getText(),montantTxt.getText(),
									numQuitTxt.getText(),
									Methode.dateText(dateQuitTxt.getText()),
									(String)typeEt.getSelectedItem(),"T.C.M",mention);
									model=new DataBase().importDonneIns(model,mention);
									
									JOptionPane.showMessageDialog(Main.main, " ETUDIANT BIEN AJOUTER  ", "",
											JOptionPane.INFORMATION_MESSAGE); 
									Methode.renitial( txtTab1, numBaccTxt, numTelTxt, dateNaisTxt
											 ,numTxt, numCinTxt, montantTxt, numQuitTxt,dateQuitTxt, serieBox
											 ,situationBox, nationBox, anneBox, sexeBox, typeEt
											 , typefilComb,fil, table,txtTab2,txtTab3, image);
									Methode.enable1(txtTab1, numBaccTxt, numTelTxt, dateNaisTxt
											 , numTxt, numCinTxt, montantTxt, numQuitTxt, dateQuitTxt, serieBox
											 , situationBox, nationBox,anneBox, sexeBox,typeEt
											 ,typefilComb, txtTab2, txtTab3);
									numTxt.setEnabled(true);
						}else {
							if(typefilComb.getSelectedIndex()!=0) {
							/*switch(i) {
							case 1:
								DataBase.ajout_etudiant_math_parcours(Integer.parseInt(numTxt.getText()),"S1", "S2",mention);
								break;
							case 2:
								DataBase.ajout_etudiant_math_parcours(Integer.parseInt(numTxt.getText()),"S7", "S8",mention);
								break;
							case 3:
								DataBase.ajout_etudiant_math_parcours(Integer.parseInt(numTxt.getText()),"S9", "S10",mention);
								break;
							}
						
						DataBase.ajout_etudiant_math( Main.main,Integer.parseInt(
									numTxt.getText()), 
									nomEtTxt.getText().toUpperCase(),
									Methode.finitText(prenomEtTxt.getText()), 
									Methode.dateText(dateNaisTxt.getText()), 
									Methode.finitText(lieuNaissTxt.getText()), 
									adresseEtTxt.getText(), 
									numCinTxt.getText(), 
									Methode.dateText(dateCinTxt.getText()), 
									Methode.finitText(lieuCinTxt.getText()), 
									montantTxt.getText(), 
									numQuitTxt.getText(), 
									Methode.dateText(dateQuitTxt.getText()),"Passant",(String)typefilComb.getSelectedItem(), 
									numTxt.getText());*/
							
									DataBase.ajout_etudiant_fac(
									numTxt.getText(), 
									nomEtTxt.getText().toUpperCase(),
								    Methode.finitText(prenomEtTxt.getText()), 
								    Methode.dateText(dateNaisTxt.getText()), 
									Methode.finitText(lieuNaissTxt.getText()),
									(String)nationBox.getSelectedItem(),
									(String)sexeBox.getSelectedItem(),
									(String)situationBox.getSelectedItem(),
									numTelTxt.getText(),
									numCinTxt.getText(), 
									Methode.dateText(dateCinTxt.getText()), 
									Methode.finitText(lieuCinTxt.getText()),
									(String)serieBox.getSelectedItem(),
									(String)anneBox.getSelectedItem(),
									numBaccTxt.getText(),
									centreBaccTxt.getText(), 
									adresseEtTxt.getText(), 
									professionEtTxt.getText(), 
									nomPereTxt.getText(), 
									professionPereTxt.getText(), 
									nomMereTxt.getText(),
									professionMereTxt.getText(),
									adressePaTxt.getText(), 
									numTxt.getText(),montantTxt.getText(),
									numQuitTxt.getText(),
									Methode.dateText(dateQuitTxt.getText()),
									(String)typeEt.getSelectedItem(),
									(String)typefilComb.getSelectedItem(),mention);
									model=new DataBase().importDonneIns(model,mention);
									JOptionPane.showMessageDialog(Main.main, " ETUDIANT BIEN AJOUTER  ", "",
											JOptionPane.INFORMATION_MESSAGE); 
									Methode.renitial( txtTab1, numBaccTxt, numTelTxt, dateNaisTxt
											 ,numTxt, numCinTxt, montantTxt, numQuitTxt,dateQuitTxt, serieBox
											 ,situationBox, nationBox, anneBox, sexeBox, typeEt
											 , typefilComb,fil, table,txtTab2,txtTab3, image);
									Methode.enable1(txtTab1, numBaccTxt, numTelTxt, dateNaisTxt
											 , numTxt, numCinTxt, montantTxt, numQuitTxt, dateQuitTxt, serieBox
											 , situationBox, nationBox,anneBox, sexeBox,typeEt
											 ,typefilComb, txtTab2, txtTab3);
									}else 
										JOptionPane.showMessageDialog(Main.main, " AUCUN FILIERE CHOISIR  ", "ERREUR",
											JOptionPane.ERROR_MESSAGE); 
						}	
						
					}	
							
					}
				});

	
		//ACTION DE SUPPRESSION
	supp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int option = JOptionPane.showConfirmDialog(Main.main,"Voulez-vous Supprimer "
						+numTxt.getText()+" "
								+ "?","ATTENTION!",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);
				if(option == JOptionPane.OK_OPTION){
					mod.setVisible(false);
					supp.setVisible(false);
					enregmod.setVisible(false);
					enreg.setVisible(true);
					DataBase.supprimer1(Methode.getNomIns(table));
					Methode.renitial( txtTab1, numBaccTxt, numTelTxt, dateNaisTxt
							 ,numTxt, numCinTxt, montantTxt, numQuitTxt,dateQuitTxt, serieBox
							 ,situationBox, nationBox, anneBox, sexeBox, typeEt
							 , typefilComb,fil, table,txtTab2,txtTab3, image);
					Methode.enable1(txtTab1, numBaccTxt, numTelTxt, dateNaisTxt
							 , numTxt, numCinTxt, montantTxt, numQuitTxt, dateQuitTxt, serieBox
							 , situationBox, nationBox,anneBox, sexeBox,typeEt
							 ,typefilComb, txtTab2, txtTab3);
					model=new DataBase().importDonneIns(model,mention);
				}
			}
		});
	
	table.addMouseListener(new MouseAdapter(){
		@SuppressWarnings("rawtypes")
		public void mouseClicked(MouseEvent e) {
		JComboBox tabcombo[]= {nationBox,sexeBox,situationBox,
					serieBox,anneBox,typeEt,typefilComb};
			if(table.getRowCount()>0 && table.getSelectedRow()!=-1) {
			if(e.getClickCount()==1) { 
				mod.setVisible(false);
				supp.setVisible(false);
				enregmod.setVisible(false);
				enreg.setVisible(true);
				Methode.renitial( txtTab1, numBaccTxt, numTelTxt, dateNaisTxt
						 ,numTxt, numCinTxt, montantTxt, numQuitTxt,dateQuitTxt, serieBox
						 ,situationBox, nationBox, anneBox, sexeBox, typeEt
						 , typefilComb,fil, table,txtTab2,txtTab3, image);
				Methode.enable1(txtTab1, numBaccTxt, numTelTxt, dateNaisTxt
						 , numTxt, numCinTxt, montantTxt, numQuitTxt, dateQuitTxt, serieBox
						 , situationBox, nationBox,anneBox, sexeBox,typeEt
						 ,typefilComb, txtTab2, txtTab3);
			}
			if(e.getClickCount()==2) {
				DataBase.recuperInformationNouveau(Methode.getNomIns(table),
						tabField11,tabcombo, image);
				annule.setVisible(true);
				supp.setVisible(true);
				mod.setVisible(true);
				enreg.setVisible(false);
				Methode.desable1( txtTab1, numBaccTxt, numTelTxt,dateNaisTxt
						 ,numTxt,numCinTxt, montantTxt, numQuitTxt,dateQuitTxt,serieBox
						 , situationBox, nationBox, anneBox,sexeBox, typeEt
						 ,typefilComb, txtTab2, txtTab3);
			}
		   }
		}
	});
	
	}
	
	
	
public class combo implements ActionListener{
	public void actionPerformed(ActionEvent arg0) {
		if(k!=1) {
			int  l= typeEt.getSelectedIndex();
		switch(l) {
		case 0:
			montantTxt.setText("");
			fil.setVisible(false);
			typefilComb.setVisible(false);
			break;
		case 1:
			montantTxt.setText("105 000");
			typefilComb.setVisible(false);
			fil.setVisible(false);
			break;
		case 2:
			montantTxt.setText("125 000");
			typefilComb.setVisible(true);
			fil.setVisible(true);
			break;
		case 3:
			montantTxt.setText("125 000");
			typefilComb.setVisible(true);
			fil.setVisible(true);
			break;
		}
			
		}else {
			int  l= typeEt.getSelectedIndex();
			switch(l) {
			
			case 0:
				typefilComb.setVisible(false);
				typefilComb1.setVisible(false);
				break;
			case 1:
				typefilComb.setVisible(true);
				typefilComb1.setVisible(false);
				break;
			case 2:
				
				typefilComb1.setVisible(true);
				typefilComb.setVisible(false);
				break;
			}
		}
	}
}


	
}
