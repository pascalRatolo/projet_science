package login;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import data_base.DataBase;
import gest_note.GestNoteMathsFinales;
import gest_note.GestNoteMathsNormal;
import gest_note.GestNoteMathsRattrapage;
import inscription.FieldFormat;
import loading.Main;
import loading.Methode;
import panel.Panneau;
import panel.Panneau2;
import panel.Panneau3;
import panel.Panneau4;
import panel.Panneau5;
import panel.Panneau6;
import panel.Panneau7;
import statisique.FenetreEffectif;

public class LoginPrincipale{
	public static Border line= new LineBorder(Color.white);
	
	public static Border  tite1= new TitledBorder(line,"MATHEMATIQUES ET APPLICATIONS",TitledBorder.DEFAULT_POSITION,
    		TitledBorder.DEFAULT_POSITION,new Font("arial",Font.BOLD,16),Color.white);
	public static Border  tite2= new TitledBorder(line,"MENTION PHYSIQUE CHIMIE ",TitledBorder.DEFAULT_POSITION,
    		TitledBorder.DEFAULT_POSITION,new Font("arial",Font.BOLD,16),Color.white);
	public static Border  tite3= new TitledBorder(line,"MENTION GSEEH ",TitledBorder.DEFAULT_POSITION,
    		TitledBorder.DEFAULT_POSITION,new Font("arial",Font.BOLD,16),Color.white);
	public static Border  tite4= new TitledBorder(line,"___",TitledBorder.DEFAULT_POSITION,
    		TitledBorder.DEFAULT_POSITION,new Font("arial",Font.BOLD,16),Color.white);
	
	public static Border  tite11= new TitledBorder(line,"S'INSCRIRE",TitledBorder.DEFAULT_POSITION,
    		TitledBorder.DEFAULT_POSITION,new Font("arial",Font.BOLD,16),Color.white);
	public static Border  tite21= new TitledBorder(line,"LISTE et SCOLARITE ",TitledBorder.DEFAULT_POSITION,
    		TitledBorder.DEFAULT_POSITION,new Font("arial",Font.BOLD,16),Color.white);
	public static Border  tite31= new TitledBorder(line,"NOTES ",TitledBorder.DEFAULT_POSITION,
    		TitledBorder.DEFAULT_POSITION,new Font("arial",Font.BOLD,16),Color.white);
	public static Border  tite41= new TitledBorder(line,"PERSONNEL ",TitledBorder.DEFAULT_POSITION,
    		TitledBorder.DEFAULT_POSITION,new Font("arial",Font.BOLD,16),Color.white);
	public static Border  tite5= new TitledBorder(line,"MATIERE",TitledBorder.DEFAULT_POSITION,
    		TitledBorder.DEFAULT_POSITION,new Font("arial",Font.BOLD,16),Color.white);
	public static Border  tite6= new TitledBorder(line,"CARTE",TitledBorder.DEFAULT_POSITION,
    		TitledBorder.DEFAULT_POSITION,new Font("arial",Font.BOLD,16),Color.white);
	
	
	
	public static JButton mentPA = new  JButton("Ouvrir la fenêtre");
	public static JButton mentPC= new  JButton("Ouvrir la fenêtre");
	public static JButton mentGH = new  JButton("Ouvrir la fenêtre");
	//public static JButton adss= new  JButton("CERTIFICAT/ATTESTATION");
	
	public static JButton inscription = new  JButton("INSCRIPTION");
	public static JButton reinscription= new  JButton("RE-INSCRIPTION");
	public static JButton stat= new  JButton("STATISTIQUE");
	public static JButton gestEt = new  JButton("GESTION ETUDIANT");
	public static JButton cert= new  JButton("CERTIFICAT/ATTESTATION");
	public static JButton gestEtBoursP = new  JButton(" BOURSE PASSANT");
	public static JButton gestEtBoursR = new  JButton(" BOURSE REDOUBLANT");
	public static JButton gestNoteNorm= new  JButton("SESSION NORMAL");
	public static JButton gestNoteRat= new  JButton("SESSION RATTRAPAGE");
	public static JButton gestNoteFin= new  JButton("NOTE FINALE");
	public static JButton valide= new  JButton("VALIDE");
	public static JButton gestMat= new  JButton("GESTION MATIERE ");
	public static JButton gestPers= new  JButton("GESTION PERSONNEL ");
	public static JButton param= new  JButton("PARAMETRE ");
	public static JButton gestCartf= new  JButton("FACE CARTE  ");
	public static JButton gestCartd= new  JButton("ARRIERE CARTE ");
	
	
	public static JPanel  panAnne=new JPanel();
	public static JPanel  panAnne1=new JPanel();
	
	public static JPanel  ligne1=new JPanel();
	public static JPanel  ligne2=new JPanel();
	public static JPanel  ligne3=new JPanel();
	public static JPanel  pan1=new JPanel();
	
	public static JPanel  pan11=new JPanel();
	
	public static JPanel  pan[];
	public static JPanel  pan2[];

	public static JLabel lab=new JLabel();
	public static JLabel anne=new JLabel("ANNEE UNIVERSITAIRE : ");
	public static JLabel anneField=new JLabel("2020-2021");
	public static JLabel nouv=new JLabel("Nouvelle Année");
	public static JLabel ou=new JLabel("    ou   ");
	public static JLabel change=new JLabel("Changer l'Année");
	public static JTextField anneTxt=new FieldFormat("anne");
	
	public static JComboBox<String> typeAn=new JComboBox<String>();
	public static Panneau  panelPrincipale=new Panneau("/fac3.jpg");
	public static JScrollPane scrollPane;
	public static JScrollPane scrollPane1;
	
	public static Font poilice=new Font("arial",Font.BOLD,60);
	public static Font poilice1=new Font("arial",Font.BOLD,20);
	public static Font poilice2=new Font("arial",Font.BOLD,10);
	public static Font poilice3=new Font("arial",Font.BOLD,8);
	
	public static   JPopupMenu jpmF = new  JPopupMenu();
	public static   JMenu licF = new  JMenu("Licence");
	public static   JMenuItem l1F = new  JMenuItem("Première année");
	public static   JMenuItem l2F = new  JMenuItem("Deuxième année");
	public static   JMenuItem l3F = new  JMenuItem("Troisième année");
	public static   JMenuItem mast1F = new  JMenuItem("Master One");
	public static   JMenuItem mast2F = new  JMenuItem("Master Two");
	
	public static   JPopupMenu jpmD = new  JPopupMenu();
	public static   JMenu licD = new  JMenu("Licence");
	public static   JMenuItem l1D = new  JMenuItem("Première année");
	public static   JMenuItem l2D = new  JMenuItem("Deuxième année");
	public static   JMenuItem l3D = new  JMenuItem("Troisième année");
	public static   JMenuItem mast1D = new  JMenuItem("Master One");
	public static   JMenuItem mast2D = new  JMenuItem("Master Two");
	
	public static   JPopupMenu jpmC = new  JPopupMenu();
	public static   JMenu certif= new  JMenu("CERTIFICAT");
	public static   JMenu attest= new  JMenu("ATTESTATION");
	public static   JMenuItem sco = new  JMenuItem("SCOLARITE");
	public static   JMenuItem assi = new  JMenuItem("ASSIDUITE");
	public static   JMenuItem insc = new  JMenuItem("INSCRIPTION");
	public static   JMenuItem valCred = new  JMenuItem("VALIDATION DE CREDIT ");
	
	
	public static void ajouter() {
		
		licF.add(l1F);
		licF.add(l2F);
		licF.add(l3F);
		
		jpmF.add(licF);
		jpmF.add(mast1F);
		jpmF.add(mast2F);
		
		jpmF.setPreferredSize(new Dimension(100,100));
		
		licD.add(l1D);
		licD.add(l2D);
		licD.add(l3D);
		
		jpmD.add(licD);
		jpmD.add(mast1D);
		jpmD.add(mast2D);
		
		jpmD.setPreferredSize(new Dimension(100,100));
		
		certif.add(sco);
		certif.add(assi);
		attest.add(insc);
		attest.add(valCred);
		
		jpmC.add(certif);
		jpmC.add(attest);
		
		
		jpmC.setPreferredSize(new Dimension(100,60));
		
		pan=new JPanel[6];
		pan2=new JPanel[6];
		gestCartf.setFont(poilice2);
		gestCartd.setFont(poilice2);
		
		inscription.setFont(poilice2);
		reinscription.setFont(poilice2);
		stat.setFont(poilice2);
		gestNoteNorm.setFont(poilice2);
		gestNoteRat.setFont(poilice2);
		gestNoteFin.setFont(poilice2);
		gestMat.setFont(poilice2);
		valide.setFont(poilice2);
		gestPers.setFont(poilice2);
		param.setFont(poilice2);
		gestEt.setFont(poilice2);
		gestEtBoursP.setFont(poilice2);
		gestEtBoursR.setFont(poilice2);
		cert.setFont(poilice2);
		
		mentPA.setFont(poilice2);
		mentPC.setFont(poilice2);
		mentGH.setFont(poilice2);
		
		gestCartf.setForeground(Color.black);
		gestCartd.setForeground(Color.black);
		mentPA.setForeground(Color.black);
		mentPC.setForeground(Color.black);
		mentGH.setForeground(Color.black);
		gestNoteNorm.setForeground(Color.black);
		gestNoteRat.setForeground(Color.black);
		gestNoteFin.setForeground(Color.black);
		gestMat.setForeground(Color.black);
		valide.setForeground(Color.black);
		gestPers.setForeground(Color.black);
		param.setForeground(Color.black);
		gestEt.setForeground(Color.black);
		gestEtBoursP.setForeground(Color.black);
		gestEtBoursR.setForeground(Color.black);
		cert.setForeground(Color.black);
		
		
		mentPC.setPreferredSize(new Dimension(120,30));
		mentPA.setPreferredSize(new Dimension(120,30));
		mentGH.setPreferredSize(new Dimension(120,30));
		
		inscription.setPreferredSize(new Dimension(120,30));
		reinscription.setPreferredSize(new Dimension(120,30));
		stat.setPreferredSize(new Dimension(120,30));
		
		change.setFont(poilice1);
		nouv.setFont(poilice1);
		ou.setFont(poilice1);
		
		Font font=nouv.getFont();
		Map<TextAttribute, Object> attributes=new HashMap<>(font.getAttributes());
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		
		nouv.setFont(font.deriveFont(attributes));
		change.setFont(font.deriveFont(attributes));
		
		nouv.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		change.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		mentPA.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mentPC.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mentGH.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		gestEt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		gestEtBoursP.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		gestEtBoursR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		gestMat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		gestNoteNorm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		gestNoteRat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		gestNoteFin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		gestPers.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		param.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		gestCartf.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		gestCartd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		gestMat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cert.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		gestEt.setPreferredSize(new Dimension(160,30));
		gestEtBoursP.setPreferredSize(new Dimension(160,30));
		gestEtBoursR.setPreferredSize(new Dimension(160,30));
		cert.setPreferredSize(new Dimension(160,30));
		gestNoteNorm.setPreferredSize(new Dimension(150,30));
		gestNoteRat.setPreferredSize(new Dimension(150,30));
		gestNoteFin.setPreferredSize(new Dimension(150,30));
		valide.setPreferredSize(new Dimension(120,30));
		gestMat.setPreferredSize(new Dimension(130,30));
		gestPers.setPreferredSize(new Dimension(150,30));
		param.setPreferredSize(new Dimension(150,30));
		gestCartf.setPreferredSize(new Dimension(120,30));
		gestCartd.setPreferredSize(new Dimension(120,30));
		
		
		
		anne.setFont(poilice);
		anneField.setFont(poilice);
		
		panAnne1.add(anneTxt);
		panAnne1.add(valide);
		
		
		valide.setPreferredSize(new Dimension(80,20));
		panAnne1.setPreferredSize(new Dimension(170,30));
		panelPrincipale.setPreferredSize(new Dimension(1000,660));
		pan1.setPreferredSize(new Dimension(680,460));
		pan11.setPreferredSize(new Dimension(680,460));
		
		ligne1.setPreferredSize(new Dimension(1500,1));
		ligne2.setPreferredSize(new Dimension(1500,1));
		ligne3.setPreferredSize(new Dimension(1500,1));
		
		
		
		panelPrincipale.add(anne);
		panelPrincipale.add(anneField);
		panelPrincipale.add(lab);
		lab.setVisible(false);
		panelPrincipale.add(ligne1);
		panelPrincipale.add(change);
		panelPrincipale.add(panAnne);
		panAnne.setVisible(false);
		panelPrincipale.add(ou);
		panelPrincipale.add(nouv);
		panelPrincipale.add(panAnne1);
		panAnne1.setVisible(false);
		panelPrincipale.add(ligne2);
		
		GridLayout gl = new  GridLayout(2, 2);
		gl.setHgap(5); //Cinq pixels d'espace entre les colonnes (H comme Horizontal)
		gl.setVgap(5);
		pan1.setLayout(gl);
		pan1.setOpaque(false);
		
		GridLayout gl1 = new  GridLayout(2, 3);
		gl.setHgap(5); //Cinq pixels d'espace entre les colonnes (H comme Horizontal)
		gl.setVgap(5);
		pan11.setLayout(gl1);
		pan11.setOpaque(false);
		
		
	
		for(int i=0;i<pan.length;i++) {
			switch(i) {
			case 0:
				pan[i]=new JPanel();
				pan[i].setBorder(tite1);
				pan[i].setBackground(Color.cyan);
				pan[i].setPreferredSize(new Dimension(220,220));
				pan[i].add(mentPA);
				
				pan1.add(pan[i]);
				pan[i].setOpaque(false);
				break;
		/*	case 1:
				pan[i]=new JPanel();
				pan[i].setBorder(tite2);
				pan[i].setBackground(Color.cyan);
				pan[i].setPreferredSize(new Dimension(220,220));
				pan[i].add(mentPC);
				pan1.add(pan[i]);
				pan[i].setOpaque(false);
				break;
			case 2:
				pan[i]=new JPanel();
				pan[i].setBorder(tite3);
				pan[i].setBackground(Color.cyan);
				pan[i].setPreferredSize(new Dimension(220,220));
				pan[i].add(mentGH);
				pan1.add(pan[i]);
				pan[i].setOpaque(false);
				break;
			case 3:
				pan[i]=new JPanel();
				pan[i].setBorder(tite4);
				pan[i].setBackground(Color.cyan);
				pan[i].setPreferredSize(new Dimension(220,220));
				pan[i].add(gestNote);
				pan1.add(pan[i]);
				pan[i].setOpaque(false);
				break;*/
			}
		}
		
		for(int i=0;i<pan2.length;i++) {
			switch(i) {
			case 0:
				pan2[i]=new Panneau2("/inscri.png");
				pan2[i].setBorder(tite11);
				pan2[i].setBackground(Color.cyan);
				pan2[i].setPreferredSize(new Dimension(220,220));
				pan2[i].add(inscription);
				pan2[i].add(reinscription);
				pan2[i].add(stat);
				pan11.add(pan2[i]);
				break;
			case 1:
				pan2[i]=new Panneau3("/diplome.png");
				pan2[i].setBorder(tite21);
				pan2[i].setBackground(Color.cyan);
				pan2[i].setPreferredSize(new Dimension(220,220));
				pan2[i].add(gestEt);
				pan2[i].add(gestEtBoursP);
				pan2[i].add(gestEtBoursR);
				pan2[i].add(cert);
				pan11.add(pan2[i]);
				break;
			case 2:
				pan2[i]=new Panneau4("/note.png");
				pan2[i].setBorder(tite31);
				pan2[i].setBackground(Color.cyan);
				pan2[i].setPreferredSize(new Dimension(220,220));
				pan2[i].add(gestNoteNorm);
				pan2[i].add(gestNoteRat);
				pan2[i].add(gestNoteFin);
				pan11.add(pan2[i]);
				break;
			case 3:
				pan2[i]=new Panneau5("/pers.png");
				pan2[i].setBorder(tite41);
				pan2[i].setBackground(Color.cyan);
				pan2[i].setPreferredSize(new Dimension(220,220));
				pan2[i].add(gestPers);
				pan2[i].add(param);
				pan11.add(pan2[i]);
				break;
			case 4:
				pan2[i]=new Panneau6("/matier.png");
				pan2[i].setBorder(tite5);
				pan2[i].setBackground(Color.cyan);
				pan2[i].setPreferredSize(new Dimension(220,220));
				pan2[i].add(gestMat);
				pan11.add(pan2[i]);
				break;
			case 5:
				pan2[i]=new Panneau7("/carte.png");
				pan2[i].setBorder(tite6);
				pan2[i].setBackground(Color.cyan);
				pan2[i].setPreferredSize(new Dimension(220,220));
				pan2[i].add(gestCartf);
				pan2[i].add(gestCartd);
				pan11.add(pan2[i]);
				break;
			
			}
		}
		
		pan11.setVisible(true);
		//panelPrincipale.add(pan1);
		panelPrincipale.add(pan11);
		/*panelPrincipale.add(inscription, BorderLayout.CENTER);
		panelPrincipale.add(reinscription, BorderLayout.CENTER);
		
		panelPrincipale.add(gestMat, BorderLayout.CENTER);
		panelPrincipale.add(gestNote, BorderLayout.CENTER);
		//panelPrincipale.add(panAnne);*/
		scrollPane = new JScrollPane(panelPrincipale);
		//ajoutAu();
	}
	
	public static void ajoutAu() {	
	new DataBase();
	typeAn=DataBase.recuperAU();
	typeAn.setPreferredSize(new Dimension(90,20));
	panAnne.setPreferredSize(new Dimension(100,30));
	anneField.setText((String)typeAn.getSelectedItem());
	panAnne.add(typeAn);
	
 typeAn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Main.main.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			 
			 DataBase.database="anne_"+String.valueOf(LoginPrincipale.typeAn.getSelectedItem()).substring(0,4)+"_"+
						String.valueOf(LoginPrincipale.typeAn.getSelectedItem()).substring(5,9)+"_maths";
			anneField.setText((String)LoginPrincipale.typeAn.getSelectedItem());
			 
			 DataBase.databaseNoteMaths="note_"+String.valueOf(LoginPrincipale.typeAn.getSelectedItem()).substring(0,4)+"_"+
						String.valueOf(LoginPrincipale.typeAn.getSelectedItem()).substring(5,9)+"_maths";
		
			 DataBase.connexion();
			 DataBase.creationBD();
			
			 GestNoteMathsNormal.ajouter();
			 GestNoteMathsRattrapage.ajouter();
			 GestNoteMathsFinales.ajouter();
			 
			 FenetreEffectif.panelPrincipale.removeAll();
			 FenetreEffectif.ajouter();
			panAnne.setVisible(false);
			Methode.creerReprrtoire();
			Toolkit.getDefaultToolkit().beep();
			Main.main.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			Main.main.setVisible(true);
		}
	});
	
 }
}
