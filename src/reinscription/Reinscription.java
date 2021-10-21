package reinscription;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import data_base.DataBase;
import image.ImageBonneQualite;
import image.LoadImage;
import inscription.FieldFormat;
import loading.Main;
import loading.Methode;
import login.LoginPrincipale;
import table.TableModel;

@SuppressWarnings("serial")
public class Reinscription extends JSplitPane implements KeyListener{
	
	
	
	 JCheckBox S1 = new JCheckBox("S1");
	 JCheckBox S2 = new JCheckBox("S2");
	 JCheckBox S3 = new JCheckBox("S3");
	 JCheckBox S4 = new JCheckBox("S4");
	 JCheckBox S5 = new JCheckBox("S5");
	 JCheckBox S6 = new JCheckBox("S6");
	 JCheckBox S7 = new JCheckBox("S7");
	 JCheckBox S8 = new JCheckBox("S8");
	 JCheckBox S9 = new JCheckBox("S9");
	 JCheckBox S10 = new JCheckBox("S10");
	 
	 JCheckBox pass = new JCheckBox("Passant");
	 JCheckBox red = new JCheckBox("Redoublant");
	 JCheckBox tri = new JCheckBox("Triplant");
	 JCheckBox etat[] = {pass,red,tri};
	 
	 JCheckBox [] S= {S1,S2,S3,S4,S5,S6,S7,S8,S9,S10};
	 JCheckBox [] SLice= {S1,S2,S3,S4,S5,S6};
	 JCheckBox [] SMas1= {S7,S8};
	 JCheckBox [] SMas2= {S9,S10};
	
	
	public  JScrollPane scrollPane;
	public  JTabbedPane panelPrincipale= new JTabbedPane();
	public  JSplitPane split;
	
	public  JPanel panelInscription=new JPanel();
	public  JPanel panParcours=new JPanel();
	public  JPanel panelImage=new JPanel();
	public  JPanel panel=new JPanel();
	public  JPanel panelInscrire=new JPanel();
	public  JPanel paneTable[];
	public  JPanel panelVerific;
	
	public  JPanel ligne1=new JPanel();
	public  JPanel ligne2=new JPanel();
	public  JPanel ligne3=new JPanel();
	public  JPanel ligne4=new JPanel();
	
	public  JPanel ligne5=new JPanel();
	public  JPanel ligne6=new JPanel();
	
	
	public  JTabbedPane pan2 = new  JTabbedPane();
	

	public  JTextField num=new JTextField();

	public  Font police2= new Font("arial",Font.BOLD,16);
	public  Font police3= new Font("arial",Font.BOLD,15);

	 JLabel titre;
	 JLabel bas= new JLabel("INSCRITPION ADMINISTRATIVE");

	public  JLabel numCarte= new JLabel("N°CARTE :");
	public  JLabel parcours= new JLabel("PARCOURS :");
	public  JLabel image= new JLabel();



	private  JLabel nom= new JLabel("Nom :");
	private  JLabel prenom= new JLabel("Prénom :");
	private  JLabel adresse= new JLabel("Adresse :");

	private  JLabel numCin= new JLabel("CIN :");
	private  JLabel dateCin= new JLabel("du :");
	private  JLabel lieuCin= new JLabel("à :");

	private  JLabel dateNais= new JLabel("Né(e) le:");
	private  JLabel lieuNaiss= new JLabel("à :");

	private  JLabel montant= new JLabel("MONTANT (AR) :");
	private  JLabel numQuit= new JLabel("NUMERO QUIT :");
	private  JLabel dateQuit= new JLabel("DATE QUIT:");

	private  JLabel vide1= new JLabel("0");
	
	private  JLabel semsP= new JLabel("S.Grand :");
	private  JLabel semsI= new JLabel("S.Paire:");
	private  JLabel moy= new JLabel(" Moyenne:");
	private  JTextField semsPTxt= new JTextField ();
	private  JTextField semsITxt= new JTextField ();


	private  JCheckBox checkInsc = new JCheckBox("voir dépuis l'nscription");
	private  JLabel ins= new JLabel("N°Inscription: ");
	private  JTextField numInscTxt= new JTextField ();
	private  JButton ok =new JButton("OK");

	private  JLabel tabLab []= {nom,prenom,dateNais,lieuNaiss,vide1,adresse,numCin,dateCin,
										lieuCin,montant,numQuit,dateQuit};

	public  JTextField numCinTxt= new FieldFormat("cin");
	public  JTextField dateCinTxt= new FieldFormat("date");;
	public  JTextField lieuCinTxt= new JTextField();
	public  JTextField dateNaisTxt= new FieldFormat("date");;
	public  JTextField lieuNaissTxt= new JTextField();

	public  JTextField nomTxt= new JTextField();
	public  JTextField prenomTxt= new JTextField();
	public  JTextField adresseTxt= new JTextField();
	public  JTextField montantTxt= new JTextField();
	public  JTextField numQuitTxt= new JTextField();
	public  JTextField dateQuitTxt= new FieldFormat("date");

	public  JTextField vide1Txt= new JTextField();

	public  JTextField  tabField []= {nomTxt,prenomTxt,dateNaisTxt,lieuNaissTxt,vide1Txt,adresseTxt,numCinTxt,
									dateCinTxt,lieuCinTxt,montantTxt,numQuitTxt,dateQuitTxt};
	public JTextField tabField1 []= {num,nomTxt,prenomTxt,
			dateNaisTxt,lieuNaissTxt,adresseTxt,numCinTxt,
			dateCinTxt,lieuCinTxt,montantTxt,numQuitTxt,
			dateQuitTxt};

	
	public  JButton enreg  =new JButton( LoadImage.transformeb(100, 25, "/save.jpg"));
	public  JButton annule =new JButton( LoadImage.transformeb(100, 25, "/annul.jpg"));
	public  JButton enregmod =new JButton( LoadImage.transformeb(100, 25, "/Ok.jpg"));
	public  JButton enregmodAdmin =new JButton( LoadImage.transformeb(100, 25, "/Ok.jpg"));
	
	public  JButton recherche=new JButton( LoadImage.transformeb(100, 25, "/recherche.jpg"));
	public  JButton insAd=new JButton( LoadImage.transformeb(100, 25, "/inspedag.jpg"));
	public  JButton recuper=new JButton( LoadImage.transformeb(100, 25, "/recuperer.jpg"));

	public  JButton mod=new JButton ( LoadImage.transformeb(100, 25, "/Modif.jpg"));
	public  JButton supp=new JButton( LoadImage.transformeb(100, 25, "/Supprimer.jpg"));
	public  JButton actual=new JButton( LoadImage.transformeb(100, 25, "/actualiser.jpg"));
	public  JButton print=new JButton( LoadImage.transformeb(100, 25, "/imprimer.jpg"));
	
	public  JButton tabBoutt[]= {annule,enreg,enregmod,mod,supp,actual};
	public JButton reset=new JButton();
	
	public  String type[];
	public  JComboBox<String> typeEt;
	
	private  JLabel nationLab= new JLabel("Nationalité:");
	private  JLabel sexeLab= new JLabel("Sexe :");
	private  String sexe[]= {" ","Masculin","Feminin"};
	
	public  String nation[]=  {"","Malagasy","Africaine","Asiatique","Comorienne","Europeenne","Autres"};
	public  JComboBox<String> typeNation=new JComboBox<String>(nation);
	
	public  JComboBox<String> typeSexe=new JComboBox<String>(sexe);

	public  String typefilMaths[]= {"T.C.M","M.I.S.S","M.E","M.F"};
	public  JComboBox<String> typefilCombMaths=new JComboBox<String>(typefilMaths);

	public  JButton retour= new JButton("Retour");
	public  JPanel tPan[]= {};

	private  JScrollPane scrollPane1;
	
	public    JMenuBar menuBar = new  JMenuBar();
	private   JMenu test1 = new  JMenu("Fichier");
	private   JMenu test2 = new  JMenu("Edition");
	
	public  JTable table [];
	public  DefaultTableModel model[];
	public  String title[]= {"N°","N°Carte"," Nom et Prénom ","Parcours"};
	public  JLabel tit[];
	public DefaultTableModel modelSems=new DefaultTableModel();
	public  JTable tableSems;
	
	
	 int k=0;
	 int r=0;
	 int f=0;
	String mention;
	
	@SuppressWarnings("static-access")
	public  Reinscription(String mention) {
		
		
		this.mention=mention;
		
		DefaultTableCellRenderer centerRenderer= new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		switch(mention) {
			case "MATHEMATIQUES ET APPLICATIONS":
			paneTable=new JPanel[10];
			table=new JTable[10];
			tit=new JLabel[10];
			model=new DefaultTableModel[10];
				for(int i=0;i<10;i++) {
					table[i]=new JTable();
					tit[i]=new JLabel("Liste des étudiants inscrits en S"+(i+1));
					tit[i].setFont(police2);
					model[i]=new DefaultTableModel();
					paneTable[i]=new JPanel();
					model[i]=new DefaultTableModel();
					paneTable[i].add(tit[i]);
					paneTable[i].setPreferredSize(new Dimension(820,580));
					model[i]=new TableModel(title);
					model[i]=new  DataBase().importDonne(model[i],mention,"S"+(i+1));
					table[i] = new JTable(model[i]);
										
					for (int c=0; c<4;c++) 
						if(c!=2)
						table[i].getColumnModel().getColumn(c).setCellRenderer(centerRenderer);
						table[i].setPreferredScrollableViewportSize(new Dimension(800,550));
						table[i].setFillsViewportHeight(true);
						table[i].getColumnModel().getColumn(0).setPreferredWidth(10);
						table[i].getColumnModel().getColumn(1).setPreferredWidth(90);
						table[i].getColumnModel().getColumn(2).setPreferredWidth(250);
						table[i].getColumnModel().getColumn(3).setPreferredWidth(50);
						paneTable[i].add(new JScrollPane(table[i]));
										
					}
				typeEt=typefilCombMaths;
				tPan=paneTable;
				String semsetre="Semestr";
			
					int u = 0;
					for(JPanel paneau : tPan){
				//Méthode d'ajout d'onglet
				pan2.add(semsetre+" "+(++u), paneau);
				}
					k=1;
				break;
								
		}
		titre= new JLabel("RE-INSCRIPTION EN "+mention);
		menuBar.add(test1);
		menuBar.add(test2);
		
		JPanel pane = new  JPanel();
		
		
		enreg.setPreferredSize(new Dimension(100,25));
		annule.setPreferredSize(new Dimension(100,25));
		enregmod.setPreferredSize(new Dimension(100,25));
		
		mod.setPreferredSize(new Dimension(100,25));
		supp.setPreferredSize(new Dimension(100,25));
		actual.setPreferredSize(new Dimension(100,25));
		enregmodAdmin.setPreferredSize(new Dimension(100,25));
		recherche.setPreferredSize(new Dimension(100,25));
		recuper.setPreferredSize(new Dimension(100,25));
		insAd.setPreferredSize(new Dimension(100,25));
		
		vide1.setPreferredSize(new Dimension(120,20));
		vide1Txt.setVisible(false);
		
		nom.setPreferredSize(new Dimension(60,30));	
		prenom.setPreferredSize(new Dimension(60,30));	
		adresse.setPreferredSize(new Dimension(60,30));	
		
		nomTxt.setPreferredSize(new Dimension(380,20));	
		prenomTxt.setPreferredSize(new Dimension(380,20));	
		adresseTxt.setPreferredSize(new Dimension(380,20));
		
		montant.setPreferredSize(new Dimension(100,30));	
		numQuit.setPreferredSize(new Dimension(90,30));	
		dateQuit.setPreferredSize(new Dimension(70,30));
		
		montantTxt.setPreferredSize(new Dimension(120,20));	
		numQuitTxt.setPreferredSize(new Dimension(120,20));	
		dateQuitTxt.setPreferredSize(new Dimension(80,20));
		
		semsPTxt.setPreferredSize(new Dimension(50,20));
		semsITxt.setPreferredSize(new Dimension(50,20));
		

		num.setPreferredSize(new Dimension(80,20));	
		
		image.setPreferredSize(new Dimension(120,120));
		panelInscrire.setPreferredSize(new Dimension(490,320));
		
		
		numCin.setPreferredSize(new Dimension(55,20));	
		dateCin.setPreferredSize(new Dimension(20,20));	
		lieuCin.setPreferredSize(new Dimension(15,20));
		
		numCinTxt.setPreferredSize(new Dimension(100,20));	
		dateCinTxt.setPreferredSize(new Dimension(80,20));	
		lieuCinTxt.setPreferredSize(new Dimension(115,20));
		
		dateNais.setPreferredSize(new Dimension(60,30));	
		
		dateNaisTxt.setPreferredSize(new Dimension(80,20));	
		lieuNaissTxt.setPreferredSize(new Dimension(150,20));
		reset.setPreferredSize(new Dimension(30,20));
		
		image.setOpaque(true);
		image=new JLabel(new ImageIcon((Image)ImageBonneQualite.scaleImage(120,120,"/profil.png")));
		image.setBackground(Color.gray);
		ligne1.setBackground(Color.BLACK);
		ligne2.setBackground(Color.BLACK);
		ligne4.setBackground(Color.BLACK);
		
		ligne1.setPreferredSize(new Dimension(490,1));
		ligne2.setPreferredSize(new Dimension(490,1));
		ligne3.setPreferredSize(new Dimension(490,1));
		ligne4.setPreferredSize(new Dimension(490,1));
		
		panelImage.setPreferredSize(new Dimension(140,140));
		panelImage.setOpaque(false);
		
		panel.setPreferredSize(new Dimension(340,140));
		panel.setOpaque(false);
		
		ligne5.setPreferredSize(new Dimension(340,1));
		ligne6.setPreferredSize(new Dimension(340,1));
		
		panelPrincipale.setBackground(Color.blue);
		

		for(int i=0;i<tabLab.length;i++) {
			panelInscrire.add(tabLab[i]);
			panelInscrire.add(tabField[i]);
			if(i==8)
				panelInscrire.add(reset);
		}
		panelInscrire.add(moy);
		panelInscrire.add(semsP);
		panelInscrire.add(semsPTxt);
		
		panelInscrire.add(ligne3);
		panelInscrire.add(annule);
		panelInscrire.add(enreg);
		panelInscrire.add(mod);
		panelInscrire.add(enregmod);
		panelInscrire.add(enregmodAdmin);
		panelInscrire.add(supp);
		panelInscrire.add(actual);
		
		panelInscrire.add(recherche);
		panelInscrire.add(insAd);
		panelInscrire.add(recuper);
		
		moy.setVisible(false);
		semsP.setVisible(false);
		semsPTxt.setVisible(false);
		semsI.setVisible(false);
		semsITxt.setVisible(false);
		
		
		
		modelSems=Verification.model(modelSems, num.getText(), true);
		tableSems=new JTable(modelSems);
		tableSems.setRowHeight(30);
		tableSems.setPreferredScrollableViewportSize(new Dimension(380,30));
		
		
		enregmodAdmin.setVisible(false);
		enregmod.setVisible(false);
		mod.setVisible(false);
		supp.setVisible(false);
		
		
		titre.setFont(police2);
		bas.setFont(police3);
		panelImage.add(image);
		//panelImage.add(ouvre);
		
		panelInscription.add(titre);
		//panelInscrireTable.add(bas);
		
		panelInscription.add(ligne1);
		
		panelInscription.add(panelImage);
		panel.add(numCarte);
		panel.add(num);

		panel.add(parcours);
		panel.add(typeEt);
		panel.add(pass);
		panel.add(red);
		panel.add(tri);
		panel.add(ligne5);
		
		numInscTxt.setPreferredSize(new Dimension(80,20));
		typeNation.setPreferredSize(new Dimension(100,20));
		typeSexe.setPreferredSize(new Dimension(100,20));
		
		panel.add(sexeLab);
		panel.add(typeSexe);
		panel.add(nationLab);
		panel.add(typeNation);
		panel.add(checkInsc);
		panel.add(ligne6);
		panel.add(ins);
		panel.add(numInscTxt);
		panel.add(ok);
		checkInsc.setOpaque(false);
		
		ligne6.setVisible(false);
		ins.setVisible(false);
		numInscTxt.setVisible(false);
		ok.setVisible(false);
		
		panelInscription.add(panel);
		panelInscription.add(ligne2);
		
		pass.setOpaque(false);
		red.setOpaque(false);
		tri.setOpaque(false);
		
		
		
		for (int i=0; i<S.length; i++) {
			S[i].setOpaque(false);
			panelInscription.add(S[i]);
			}
		
		/*for(int i=0;i<tabBoutt.length;i++) {
			panelInscrire.add(tabBoutt[i]);
		}*/
		panelInscription.add(panelInscrire);
		panelInscription.add(ligne4);
		JLabel tet= new JLabel("Semestre validé:");
		tet.setFont(new Font("arial",Font.BOLD,14));
		panelInscription.add(tet);
		panelInscription.add(new JScrollPane(tableSems));
		panelInscription.setBackground(Color.white);
		panelInscription.setPreferredSize(new Dimension(500,650));
		//panelTable.add(listeEtudiant);
		
		pane.add(panelInscription);
		
		pan2.setBackground(Color.white);
		pane.setLayout(new FlowLayout(FlowLayout.LEFT));
		pane.setBackground(Color.white);
		//pan2.setSelectedIndex(5);
		scrollPane = new JScrollPane(pan2);
		scrollPane1 = new JScrollPane(pane);
		split =new JSplitPane(JSplitPane.HORIZONTAL_SPLIT , scrollPane1, scrollPane);
		//On place le premier séparateur
		split.setDividerLocation(520);
		split.setDividerSize(1);
		//this.add(split);
		for(int l=0;l<S.length;l++) {
			S[l].setEnabled(false);
		}
		
		typeEt.addActionListener(new combo(S,typeEt,k));
		action();
		checkInsc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(checkInsc.isSelected()) {
					ligne6.setVisible(true);
					ins.setVisible(true);
					numInscTxt.setVisible(true);
					ok.setVisible(true);
					sexeLab.setVisible(false);
					nationLab.setVisible(false);
					typeSexe.setVisible(false);
					typeNation.setVisible(false);
				}else {
					ligne6.setVisible(false);
					ins.setVisible(false);
					numInscTxt.setVisible(false);
					ok.setVisible(false);
					sexeLab.setVisible(true);
					nationLab.setVisible(true);
					typeSexe.setVisible(true);
					typeNation.setVisible(true);
				}
					
				
			}
		});
		/*
		num.addKeyListener(this);
		typeEt.addKeyListener(this);
		pai.addKeyListener(this);
		imp.addKeyListener(this);
		nomTxt.addKeyListener(this);
		prenomTxt.addKeyListener(this);
		dateNaisTxt.addKeyListener(this);
		lieuNaissTxt.addKeyListener(this);
		numCinTxt.addKeyListener(this);
		dateCinTxt.addKeyListener(this);
		lieuCinTxt.addKeyListener(this);
		adresseTxt.addKeyListener(this);
		montantTxt.addKeyListener(this);
		numQuitTxt.addKeyListener(this);
		dateQuitTxt.addKeyListener(this);
		*/
	}
	
	public void action() {
		for (int i=0; i<SMas2.length;i++) {
			SMas2[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
						if(SMas2[0].isSelected() ||SMas2[1].isSelected()) {
					for(int i=0; i<SLice.length;i++)
						SLice[i].setEnabled(false);
					for(int i=0; i<SMas2.length;i++)
						SMas1[i].setEnabled(false);
						}else{
						for(int i=0; i<SMas2.length;i++)
							SMas1[i].setEnabled(true);
						for(int i=0; i<SLice.length;i++)
							SLice[i].setEnabled(true);
						
				}}
			});
			}
		
		for (int i=0; i<SMas1.length;i++) {
			SMas1[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
			
						if(SMas1[0].isSelected() ||SMas1[1].isSelected() ){
					for(int i=0; i<SLice.length;i++)
						SLice[i].setEnabled(false);
					for(int i=0; i<SMas2.length;i++)
						SMas2[i].setEnabled(false);
						}else{
						for(int i=0; i<SMas2.length;i++)
							SMas2[i].setEnabled(true);
						for(int i=0; i<SLice.length;i++)
							SLice[i].setEnabled(true);
				}}
			});
			}
		
		for (int i=0; i<SLice.length;i++) {
			SLice[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(!typefilCombMaths.getSelectedItem().equals("T.C.M")) {
					if(SLice[0].isSelected() ||SLice[1].isSelected() || SLice[2].isSelected() || SLice[3].isSelected()
							|| SLice[4].isSelected() || SLice[5].isSelected()){
						for(int i=0; i<SMas1.length;i++)
							SMas1[i].setEnabled(false);
						for(int i=0; i<SMas2.length;i++)
							SMas2[i].setEnabled(false);
							}else{
							for(int i=0; i<SMas2.length;i++)
								SMas2[i].setEnabled(true);
							for(int i=0; i<SMas1.length;i++)
								SMas1[i].setEnabled(true);
						}
					int k=0;
					for (int i=0; i<SLice.length;i++) {
					if(SLice[i].isSelected()) {
						k++;
					}else
						k--;
					}
					if(k==-2) {
						for(int j=0;j<SLice.length; j++) {
							if(!SLice[j].isSelected())
								SLice[j].setEnabled(false);
							}
					}else {
				for(int i=0;i<SLice.length; i++) {
					SLice[i].setEnabled(true);
				}
			}
					}		
		}
			});	
		}
		for(int t=0;t<etat.length;t++)
			etat[t].addActionListener(new test(t,etat));
		
		
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				numCinTxt.setText("");
				dateCinTxt.setText("");
				lieuCinTxt.setText("");
			}
		});
		
		enreg.addActionListener(new Enreg());
		
		enregmod.addActionListener(new enregmod() );
		
		annule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				r=0;
				f=0;
				for(int t=0;t<etat.length;t++)
					etat[t].setSelected(false);
				actual.setVisible(true);
				enregmodAdmin.setVisible(false);
				tableSems.setEnabled(true);
				modelSems.setRowCount(0);
				modelSems.addRow(new Object[] {false,false,false,false,false,false,false,false,false,false});
				Methode.renitial1(tabField, num, typeEt, mod, supp, enregmod, enreg, table, S, image,etat,typeSexe,typeNation, vide1);
				Methode.enable(tabField, num, typeEt);
				numInscTxt.setText("");
			}
		});
		
		actual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			switch(mention) {
			case "MATHEMATIQUES ET APPLICATIONS":
				for(int i=0;i<10;i++)
				model[i]=DataBase.importDonne(model[i],mention,"S"+(i+1));
				break;
			}
			}
		});
		
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int t=0;t<etat.length;t++)
					etat[t].setSelected(false);
				actual.setVisible(true);
				enregmodAdmin.setVisible(false);
				tableSems.setEnabled(true);
				modelSems.setRowCount(0);
				modelSems.addRow(new Object[] {false,false,false,false,false,false,false,false,false,false});
				Methode.renitial1(tabField, num, typeEt, mod, supp, enregmod, enreg, table, S, image,etat,typeSexe,typeNation,vide1);
				Methode.enable(tabField, num, typeEt);
				if(DataBase.verificNumNouv(numInscTxt.getText())) {
				DataBase.recuperInformation1(numInscTxt.getText(), tabField, typefilCombMaths,S,typeSexe,typeNation,vide1);	
				Methode.desable(tabField1, num, typeEt);
				num.setEditable(true);
				for(int i=0;i<S.length;i++)
					 S[i].setEnabled(false);
				}
				checkInsc.setSelected(false);
				numInscTxt.setText("");
				ins.setVisible(false);
				numInscTxt.setVisible(false);
				ok.setVisible(false);
				sexeLab.setVisible(true);
				nationLab.setVisible(true);
				typeSexe.setVisible(true);
				typeNation.setVisible(true);
				
				
				
			}
		});
		
		mod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Methode.enable(tabField, num, typeEt);
				for(int i=0;i<S.length;i++) {
					S[i].setEnabled(false);
				}
				r=1;
				f=1;
				num.setEditable(false);
				mod.setVisible(false);
				supp.setVisible(false);
				enregmod.setVisible(true);
				actual.setVisible(true);
				
			}
		});
		recherche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 if(num.getText().length()==0) {
					 JOptionPane.showMessageDialog(panelInscription, " Inserer le numero carte ", "ERREUR",
								JOptionPane.ERROR_MESSAGE);
				 }else {
				 if(DataBase.recherche(num.getText())) {
				DataBase.recuperInformation(num.getText(), 
						tabField1,typeEt, etat,image,typeSexe,typeNation);
				DataBase.recuperClasse(num.getText(),S);
				supp.setVisible(true);
				mod.setVisible(true);
				enreg.setVisible(false);
				actual.setVisible(false);
				Methode.desable(tabField1, num, typeEt);
				 modelSems=DataBase.importSemsetre(modelSems, num.getText());
				 tableSems.setEnabled(false);
			}else {
				JOptionPane.showMessageDialog(panelInscription, num.getText()+" n'a pas trouvé ", "ERREUR",
						JOptionPane.ERROR_MESSAGE);
			}
				 }
			}
		});
		
		insAd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 if(num.getText().length()==0) {
					 JOptionPane.showMessageDialog(panelInscription, " Inserer le numero carte ", "ERREUR",
								JOptionPane.ERROR_MESSAGE);
				 }else {
			 if(DataBase.recherche(num.getText())) {
				 DataBase.recuperInformation(num.getText(), 
							tabField1,typeEt, etat,image,typeSexe,typeNation);
				DataBase.recuperClasse(num.getText(),S);
				supp.setVisible(false);
				enregmodAdmin.setVisible(true);
				enreg.setVisible(false);
				enregmod.setVisible(false);
				mod.setVisible(false);
				actual.setVisible(true);
				Methode.desable(tabField1, num, typeEt);
				for(int i=0;i<SLice.length;i++)
					SLice[i].setEnabled(true);
				 modelSems.setRowCount(0);
				 modelSems=DataBase.importSemsetre(modelSems, num.getText());
				// modelSems=Verification.model(modelSems,num.getText(), false);
				 tableSems.setEnabled(false);
			}else {
				JOptionPane.showMessageDialog(panelInscription, num.getText()+" n'est pas trouvé ", "ERREUR",
						JOptionPane.ERROR_MESSAGE);
			}
			}
			}
		});
		
		enregmodAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean test=false;
				for (int i=0; i<S.length;i++) {
					if(S[i].isSelected())
						test=true;
				}
				if(test) {
					DataBase.modif_etudiant_math_parcours(num.getText(), 
							Methode.SemsPetit(S), Methode.SemsGrand(S));
					for(int t=0;t<etat.length;t++)
						etat[t].setSelected(false);
					
					enregmodAdmin.setVisible(false);
					enreg.setVisible(true);
					for (int i=0; i<S.length;i++) {
							switch (mention) {
							case "MATHEMATIQUES ET APPLICATIONS":
								model[i]=DataBase.importDonne(model[i],mention,"S"+(i+1));
								break;
							}
						
					}
					tableSems.setEnabled(true);
					modelSems.setRowCount(0);
					modelSems.addRow(new Object[] {false,false,false,false,false,false,false,false,false,false});
					Methode.renitial1(tabField, num, typeEt, mod, supp, enregmod, enreg, table, S, image,etat,typeSexe,typeNation,vide1);
					Methode.enable(tabField, num, typeEt);
					JOptionPane.showMessageDialog(panelInscription, "Opération terminé avec succée  ", "",
							JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});

		
		recuper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String anne=Methode.last_anne(LoginPrincipale.anneField.getText());
				if(DataBase.test_anne_univ(anne)) {
					DataBase.database="anne_"+anne.substring(0, 4)+"_"+anne.substring(5, 9)+"_maths";
					 if(DataBase.recherche(num.getText())) {
						
						 DataBase.recuperInformation(num.getText(), 
									tabField1,typeEt, etat,image,typeSexe,typeNation);
							for(int i=0;i<S.length;i++) {
								S[i].setEnabled(true);
								S[i].setSelected(false);
							}
							 modelSems.setRowCount(0);
							 modelSems=DataBase.importSemsetre(modelSems, num.getText());
							// modelSems=Verification.model(modelSems,num.getText(), false);
							 tableSems.setEnabled(false);
							 nomTxt.setEditable(false);
							 prenomTxt.setEditable(false);
							 dateNaisTxt.setEditable(false);
							 lieuNaissTxt.setEditable(false);
							 dateCinTxt.setEditable(false);
							 lieuCinTxt.setEditable(false);
							 numCinTxt.setEditable(false);
							 montantTxt.setText("");
							 numQuitTxt.setText("");
							 dateQuitTxt.setText("");
							 vide1.setText("");
							 if(typeEt.getSelectedItem()=="T.C.M") {
								 typeEt.setEnabled(false);
								 for(int i=0;i<S.length;i++) {
										S[i].setEnabled(false);
								 }
										S[0].setSelected(true);
										S[1].setSelected(true);
									
							 }
						}else {
							JOptionPane.showMessageDialog(panelInscription, num.getText()+" n'est pas trouvé dans l'année"+anne, "ERREUR",
									JOptionPane.ERROR_MESSAGE);
						}
					
				}else {
					JOptionPane.showMessageDialog(panelInscription, "la base de donnée "+anne+" n'existe pas ", "ERREUR",
							JOptionPane.ERROR_MESSAGE);
				}
				DataBase.database="anne_"+LoginPrincipale.anneField.getText().substring(0, 4)+"_"
							+LoginPrincipale.anneField.getText().substring(5, 9)+"_maths";
				}
		});
		
		//ACTION DE SUPRRESSION
		
		supp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int option = JOptionPane.showConfirmDialog(null,"Voulez-vous Supprimer "
						+num.getText()+" "
								+ "?","ATTENTION!",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);
				if(option == JOptionPane.OK_OPTION){
					DataBase.supprimer(num.getText());
					f=0;
					for (int i=0; i<S.length;i++) {
						if(S[i].isSelected()) {
							switch (mention) {
							case "MATHEMATIQUES ET APPLICATIONS":
								model[i]=DataBase.importDonne(model[i],mention,"S"+(i+1));
								break;
							}
						  }
						}
					 }
				for(int t=0;t<etat.length;t++)
					etat[t].setSelected(false);
					tableSems.setEnabled(true);
					modelSems.setRowCount(0);
					modelSems.addRow(new Object[] {false,false,false,false,false,false,false,false,false,false});
					actual.setVisible(true);
					Methode.renitial1(tabField, num, typeEt, mod, supp, enregmod, enreg, table, S, image,etat,typeSexe,typeNation,vide1);
					Methode.enable(tabField, num, typeEt);
				
				
				
			}
		});
		
		for(int i=0;i<table.length;i++) {
			table[i].addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e) {
					 
					for(int i=0;i<table.length;i++) {
					if(table[i].getRowCount()>0 && table[i].getSelectedRow()!=-1) {
					if(e.getClickCount()==1) { 
						r=0;
						f=0;
					mod.setVisible(false);
					supp.setVisible(false);
					enregmod.setVisible(false);
					enregmodAdmin.setVisible(false);
					enreg.setVisible(true);
					for(int t=0;t<etat.length;t++)
						etat[t].setSelected(false);
					actual.setVisible(true);
						Methode.renitial1(tabField1, num, typeEt, mod, supp, enregmod, enreg, table, S, image,etat,
								typeSexe,typeNation,vide1);
						Methode.enable(tabField1, adresseTxt, typeEt);
						tableSems.setEnabled(true);
						modelSems.setRowCount(0);
						modelSems.addRow(new Object[] {false,false,false,false,false,false,false,false,false,false});
					}
					if(e.getClickCount()==2) {
						r=1;
						DataBase.recuperInformation(String.valueOf(Methode.getNomEt(table[i])), 
								tabField1,typeEt, etat,image,typeSexe,typeNation);
						S[i].setVisible(true);
						DataBase.recuperClasse(Methode.getNomEt(table[i]),S);
						supp.setVisible(true);
						mod.setVisible(true);
						supp.setVisible(true);
						enreg.setVisible(false);
						actual.setVisible(false);
						Methode.desable(tabField1, num, typeEt);
						modelSems=DataBase.importSemsetre(modelSems, num.getText());
						tableSems.setEnabled(false);
					}
				   }
				}
				}
				
			});
		}
		
		
		
	}
	public class test implements ActionListener{
		JCheckBox etat[];
		int t;
	
		test(int t,JCheckBox etat[]){
			this.etat=etat;
			this.t=t;
			
		}
		public void actionPerformed(ActionEvent arg0) {
			if(etat[t].isSelected()) { 
				if(t==1) {
					moy.setVisible(true);
					semsP.setVisible(true);
					semsPTxt.setVisible(true);
					semsI.setVisible(false);
					semsITxt.setVisible(false);
				}else {
					moy.setVisible(false);
					semsP.setVisible(false);
					semsPTxt.setVisible(false);
					semsI.setVisible(false);
					semsITxt.setVisible(false);
				}
			for(int h=0;h<etat.length;h++) {
				if(h!=t) {
				etat[h].setEnabled(false);
				etat[h].setSelected(false);
				}
			}
			}else {
				for(int h=0;h<etat.length;h++) 
					etat[h].setEnabled(true);
				moy.setVisible(false);
				semsP.setVisible(false);
				semsPTxt.setVisible(false);
				semsI.setVisible(false);
				semsITxt.setVisible(false);
			
			}				
		}
	}
	
	public class combo implements ActionListener{
		JCheckBox S[];
		int k;
		@SuppressWarnings("rawtypes")
		JComboBox typeEt;
	
		@SuppressWarnings("rawtypes")
		combo(JCheckBox S[],JComboBox typeEt,int k){
			this.S=S;
			this.typeEt=typeEt;
			this.k=k;
			
		}
		public void actionPerformed(ActionEvent arg0) {
				int  l= typeEt.getSelectedIndex();
		 if(f!=1) {
			switch(l) {
			case 0:
				for(int k=0;k<S.length;k++) {
					if(k<2)
					S[k].setEnabled(true);
					else
					S[k].setEnabled(false);
				}
				break;
			default :
				for(int k=0;k<10;k++) {
					S[k].setEnabled(true);
				}

			}
			}
	     }
		}
	public class enregmod implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			String typ="";
			double re=0;
			
			for(int t=0;t<etat.length;t++) {
				if(etat[t].isSelected())
				   typ=etat[t].getText();
			}
							int option = JOptionPane.showConfirmDialog(null,
										"Voulez-vous appliquer la modification de "
										+num.getText()+" "
												+ "?","ATTENTION!",
								JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE);
							if(option == JOptionPane.OK_OPTION){
								r=0;
								if(Methode.valide1(mention,(num.getText()),typeEt, nomTxt, dateNaisTxt, lieuNaissTxt,
										adresseTxt ,numCinTxt, dateCinTxt,lieuCinTxt, montantTxt ,numQuitTxt,
										dateQuitTxt)&& test1()){
									if(etat[1].isSelected())
										re=Double.parseDouble(semsPTxt.getText());
									
							
							DataBase.modifier_etudiant_math( 
							num.getText(), 
							nomTxt.getText().toUpperCase(), 
							Methode.finitText(prenomTxt.getText()), 
							Methode.dateText(dateNaisTxt.getText()), 
							Methode.finitText(lieuNaissTxt.getText()), 
							adresseTxt.getText(),numCinTxt.getText(), 
							Methode.dateText(dateCinTxt.getText()), 
							Methode.finitText(lieuCinTxt.getText()), 
							montantTxt.getText(), numQuitTxt.getText(), 
							Methode.dateText(dateQuitTxt.getText()),typ,
							(String) typeEt.getSelectedItem(),
							(String)typeSexe.getSelectedItem(),
							(String)typeNation.getSelectedItem(),
							re);
	
							for (int i=0; i<S.length;i++) {
								if(S[i].isSelected()) {
									switch (mention) {
									case "MATHEMATIQUES ET APPLICATIONS":
										model[i]=DataBase.importDonne(model[i],mention,"S"+(i+1));
										break;
									}
								}
							}
							for(int t=0;t<etat.length;t++)
								etat[t].setSelected(false);
							//typ.clearSelection();
							Methode.renitial1(tabField, num, typeEt, mod, supp, enregmod, enreg, table, S, image,
									etat,typeSexe,typeNation,vide1);
							Methode.enable(tabField, num, typeEt);
							numInscTxt.setText("");
							modelSems.setRowCount(0);
							semsPTxt.setText("");
							modelSems.addRow(new Object[] {false,false,false,false,false,false,false,false,false,false});
							
							}
							}	
						}
	           }
	public class Enreg implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			double re=0;
			vide1.setText("0");
				;
			double bacc=Double.parseDouble(vide1.getText());
			boolean test=false;
				if(Methode.valide(mention,(num.getText()),typeEt,typeSexe,typeNation, 
						nomTxt, dateNaisTxt, lieuNaissTxt, adresseTxt
						,numCinTxt, dateCinTxt,lieuCinTxt, montantTxt ,numQuitTxt, dateQuitTxt) && test1() ){
			for (int i=0; i<S.length;i++) {
				if(S[i].isSelected())
					test=true;
			}
			
			if(test) {
				String typ="";
				for(int t=0;t<etat.length;t++) {
					if(etat[t].isSelected())
					typ=etat[t].getText();
				}
				if(etat[1].isSelected())
					re=Double.parseDouble(semsPTxt.getText());
				String sems[]=new String[modelSems.getColumnCount()];       
				for(int i=0;i<modelSems.getColumnCount();i++) {
					sems[i]=String.valueOf(tableSems.getValueAt(0, i));
					
				}
				if(etat[0].isSelected()) {
					if(S[0].isSelected() && S[1].isSelected()) {
						re=bacc;
				 }
				}	
				DataBase.ajout_Semsetre(num.getText(), sems);
				DataBase.ajout_etudiant_math(Main.main,num.getText(), 
						nomTxt.getText().toUpperCase(),
						Methode.finitText(prenomTxt.getText()), 
						Methode.dateText(dateNaisTxt.getText()),
						Methode.finitText(lieuNaissTxt.getText()), 
						adresseTxt.getText(), numCinTxt.getText(), 
						Methode.dateText(dateCinTxt.getText()),
						Methode.finitText(lieuCinTxt.getText()), 
						montantTxt.getText(), numQuitTxt.getText(), 
						Methode.dateText(dateQuitTxt.getText()),typ, 
						(String) typeEt.getSelectedItem(),
						num.getText(),(String)typeSexe.getSelectedItem(),
						(String)typeNation.getSelectedItem(),
						re);
						
						 			DataBase.ajout_etudiant_math_parcours(num.getText(), 
									Methode.SemsPetit(S), Methode.SemsGrand(S),mention);
									for (int i=0; i<S.length;i++) {
									if(S[i].isSelected()) {
										switch (mention) {
										case "MATHEMATIQUES ET APPLICATIONS":
											model[i]=DataBase.importDonne(model[i],mention,"S"+(i+1));
											break;
										}
								}	
								}
							}
			for(int t=0;t<etat.length;t++)
				etat[t].setSelected(false);

			Methode.renitial1(tabField, num, typeEt, mod, supp, enregmod, enreg, table, S, image,etat,typeSexe,typeNation,vide1);
			Methode.enable(tabField, num, typeEt);
			Main.main.setVisible(true);
			modelSems.setRowCount(0);
			semsPTxt.setText("");
			modelSems.addRow(new Object[] {false,false,false,false,false,false,false,false,false,false});
							}
				
						}
	           }
	public boolean test1() {
		boolean rep = false;
		if(etat[1].isSelected()) {
			try {
		    Double.parseDouble(semsPTxt.getText());
			rep=true;
			}catch(Exception e) {
				JOptionPane.showMessageDialog(Main.main, "Entrer la moyenne valide ", 
						 "ERREUR",JOptionPane.ERROR_MESSAGE);
			}
		}else {
			rep=true;
		}
		return rep;
		}
	
	public void keyPressed(KeyEvent arg0) {
		if(r==0) {
		if(arg0.getKeyCode()==KeyEvent.VK_ENTER) {
		
			new Enreg().actionPerformed(null);;
		}
		}else {
			System.out.println(r);
			if(arg0.getKeyCode()==KeyEvent.VK_ENTER) {
				new enregmod().actionPerformed(null);
		 }
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
      }
