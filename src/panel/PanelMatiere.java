package panel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
import image.LoadImage;
import loading.Main;
import loading.Methode;
import table.TableModel;

@SuppressWarnings("serial")
public class PanelMatiere extends JPanel{
	 JComboBox<String> typeUe;
	
	 JLabel ueTitre=new JLabel("Unité d'Enseignement");
	 JLabel ecTitre=new JLabel("Eléments Constitutifs");
	
	 JLabel ue=new JLabel("U.E :");
	 JLabel ue1=new JLabel("U.E :");
	 JLabel ec=new JLabel("E.C :");
	 JLabel ensei=new JLabel("Enseignant :");
	
	 JLabel credit=new JLabel("Credit :");
	 JLabel poids=new JLabel("Poids  :");
	 JLabel poidsTp=new JLabel("Poids TP:");
	
	 JLabel tableMat[];
	
	 JScrollPane scrollPane;
	 JPanel panelMat= new JPanel();
	 JPanel panelTable=new JPanel();
	 JPanel ligne1=new JPanel();
	 JPanel ligne2=new JPanel();
	 JPanel ligne3=new JPanel();
	 JPanel ligne0=new JPanel();
	
	 JPanel panUe=new JPanel();
	 JPanel panEc=new JPanel();
	
	 JPanel panTable[];
	 JPanel panTableUe=new JPanel();
	
	 JButton add1= new JButton(LoadImage.transformeb(100, 25, "/save.jpg"));
	 JButton add2= new JButton(LoadImage.transformeb(100, 25, "/save.jpg"));
	 JButton annule =new JButton(LoadImage.transformeb(100, 25, "/annul.jpg"));
	 JButton annule2 =new JButton(LoadImage.transformeb(100, 25, "/annul.jpg"));
	 JButton enregmod =new JButton( LoadImage.transformeb(100, 25, "/Ok.jpg"));
	 JButton enregmod2 =new JButton( LoadImage.transformeb(100, 25, "/Ok.jpg"));
	 
	 JButton modEc =new JButton(LoadImage.transformeb(100, 25, "/Modif.jpg"));
	 JButton modUe =new JButton(LoadImage.transformeb(100, 25, "/Modif.jpg"));
	 JButton suppEc =new JButton( LoadImage.transformeb(100, 25, "/Supprimer.jpg"));
	 JButton suppUe =new JButton( LoadImage.transformeb(100, 25, "/Supprimer.jpg"));
	
	
	 JTextField ueTxt= new JTextField();
	 JTextField ecTxt= new JTextField();
	
	 JTextField crdtTxt= new JTextField();
	 JTextField poidsTxt= new JTextField();
	 JTextField poidsTpTxt= new JTextField();
	
	 JTextField enseiTxt= new JTextField();
	
	 String sems[];
	 ButtonGroup typ= new ButtonGroup();
	 ButtonGroup typ2= new ButtonGroup();
	
	 Font police= new Font("arial",Font.BOLD,20);
	 JComboBox<String> semestre;

	 JPanel pan1= new  JPanel();
	JPanel pan2= new  JPanel();
	 JPanel pane =new  JPanel();;
	 JPanel ligne =new  JPanel();;
	
	JCheckBox tp=new JCheckBox("Composante TP");
	
	String mention;
	String titre;
	String titreEc[]= {"Nom E.C","Poids","Enseignant"};
	String titreUe[]= {"Nom U.C","Credit"};
	JButton ferme=new JButton( LoadImage.transformeb(30, 25, "/croi1.jpg"));
	JPanel   tete= new JPanel();
	JPanel   corp= new JPanel();
	JLabel title;
	JTable tableEc;
	JTable tableUe;
	JButton bout;
	JButton bout1;
	String filier;
	int t;
	Font font=new Font("arial",Font.BOLD,16);
	DefaultTableModel modelEc=new DefaultTableModel();
	DefaultTableModel modelUe=new DefaultTableModel();
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PanelMatiere(String titre,String mention,JComboBox semestre,int t,String filier) {
		this.titre=titre;
		this.semestre=semestre;
		this.filier=filier;
		this.t=t;
		
		 add1.setIcon(LoadImage.transformeb(120, 25, "/save.jpg"));
		 add2.setIcon(LoadImage.transformeb(120, 25, "/save.jpg"));
		 annule =new JButton(LoadImage.transformeb(100, 25, "/annul.jpg"));
		 annule2 =new JButton(LoadImage.transformeb(100, 25, "/annul.jpg"));
		 enregmod =new JButton( LoadImage.transformeb(100, 25, "/Ok.jpg"));
		 enregmod2 =new JButton( LoadImage.transformeb(100, 25, "/Ok.jpg"));
		
		
		add1.setPreferredSize(new Dimension(100,25));
		annule.setPreferredSize(new Dimension(100,25));
		annule2.setPreferredSize(new Dimension(100,25));
		enregmod.setPreferredSize(new Dimension(100,25));
		enregmod2.setPreferredSize(new Dimension(100,25));
		
		modEc.setPreferredSize(new Dimension(100,25));
		modUe.setPreferredSize(new Dimension(100,25));
		suppEc.setPreferredSize(new Dimension(100,25));
		suppUe.setPreferredSize(new Dimension(100,25));
		
		add2.setPreferredSize(new Dimension(100,25));
		ue.setPreferredSize(new Dimension(30,20));
		ue1.setPreferredSize(new Dimension(30,20));
		credit.setPreferredSize(new Dimension(50,20));
		
		panUe.setPreferredSize(new Dimension(220,350));
		panEc.setPreferredSize(new Dimension(220,350));
		ligne.setPreferredSize(new Dimension(200,1));
		
		
		ec.setPreferredSize(new Dimension(30,20));
		poids.setPreferredSize(new Dimension(50,20));
		
		ligne0.setPreferredSize(new Dimension(830,1));
		ligne1.setPreferredSize(new Dimension(830,1));
		ligne2.setPreferredSize(new Dimension(830,1));
		ligne3.setPreferredSize(new Dimension(830,1));

		ueTxt.setPreferredSize(new Dimension(130,20));
		crdtTxt.setPreferredSize(new Dimension(110,20));
		ecTxt.setPreferredSize(new Dimension(130,20));
		poidsTxt.setPreferredSize(new Dimension(110,20));
		poidsTpTxt.setPreferredSize(new Dimension(110,20));
		enseiTxt.setPreferredSize(new Dimension(90,20));
		
		ecTxt.setEditable(false);
		poidsTxt.setEditable(false);
		enseiTxt.setEditable(false);
		add2.setEnabled(false);
		annule.setEnabled(false);
		enregmod.setVisible(false);
		ueTitre.setFont(police);
		ecTitre.setFont(police);
		title=new JLabel ("TABLE DES UNITES D'ENSEIGNEMENTS ET SES ELEMENTS CONSITUTIFS EN "+titre);
		title.setHorizontalAlignment(JLabel.CENTER);
		
		GridLayout gl = new  GridLayout(1,3);
		gl.setHgap(2); //Cinq pixels d'espace entre les colonnes (H comme Horizontal)
		gl.setVgap(2);
		//panelMat.setLayout(gl);
		//panelMat.setOpaque(false);
		
		String l=(String)semestre.getSelectedItem();
		ajoutEc(mention,l,t);
		
		tp.setEnabled(false);
		tp.setOpaque(false);
		poidsTp.setVisible(false);
		poidsTpTxt.setVisible(false);
		panUe.add(ueTitre);
	
		panUe.add(ue);
		panUe.add(ueTxt);
		panUe.add(credit);
		panUe.add(crdtTxt);
		panUe.add(add1);
		panUe.add(enregmod2);
		enregmod2.setVisible(false);
		panUe.add(annule2);
		
		panUe.setLayout(new FlowLayout(FlowLayout.LEADING));
		panEc.setLayout(new FlowLayout(FlowLayout.LEADING));
		
		//ajoutEc();
		panTableUe.setPreferredSize(new Dimension(320,350));
		panelTable.add(title);
		panelTable.add(semestre);
		panelTable.add(ferme);
		panelTable.add(ligne1);
		panelMat.add(panUe);
		//panelMat.add(ligne2);
		panelMat.add(panEc);
		panelMat.add(panTableUe);
		panelMat.setBackground(Color.cyan);
		
		panelTable.add(panelMat);
		panUe.setOpaque(false);
		panEc.setOpaque(false);
		panTableUe.setOpaque(false);
		
		panelMat.setPreferredSize(new Dimension(800,370));
		panelTable.setPreferredSize(new Dimension(850,600));
		//pan2.add(pan1);
		panelTable.setBackground(Color.gray);
		//panelMat.setLayout(new FlowLayout(FlowLayout.LEFT));
		modelEc=new TableModel(titreEc);
		modelUe=new TableModel(titreUe);
		
		ferme.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		annule.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		annule2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		enregmod.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		enregmod2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		
		DefaultTableCellRenderer centerRenderer= new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		modelEc=DataBase.importDonneEC(modelEc, mention, (String)semestre.getSelectedItem(), filier, t);
		tableEc=new JTable(modelEc);
		for (int c=0; c<3;c++) 
			tableEc.getColumnModel().getColumn(c).setCellRenderer(centerRenderer);
		
			tableEc.setPreferredScrollableViewportSize(new Dimension(300,270));
			tableEc.setFillsViewportHeight(true);
			tableEc.getColumnModel().getColumn(0).setPreferredWidth(120);
			tableEc.getColumnModel().getColumn(1).setPreferredWidth(30);
			tableEc.getColumnModel().getColumn(2).setPreferredWidth(120);
			panTableUe.add(new JScrollPane(tableEc));
			panTableUe.add(modEc);
			panTableUe.add(suppEc);
			modEc.setVisible(false);
			suppEc.setVisible(false);
			
			
			modelUe=DataBase.importDonneUe(modelUe, mention, (String)semestre.getSelectedItem(), filier, t);
			tableUe=new JTable(modelUe);
			for (int c=0; c<2;c++) 
				tableUe.getColumnModel().getColumn(c).setCellRenderer(centerRenderer);
			
			tableUe.setPreferredScrollableViewportSize(new Dimension(200,160));
			tableUe.setFillsViewportHeight(true);
			tableUe.getColumnModel().getColumn(0).setPreferredWidth(150);
			tableUe.getColumnModel().getColumn(1).setPreferredWidth(40);
			panUe.add(new JScrollPane(tableUe));
			panUe.add(modUe);
			panUe.add(suppUe);
			modUe.setVisible(false);
			suppUe.setVisible(false);
		//bout.setPreferredSize(new Dimension(130,25));
		//bout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		title.setFont(font);
		title.setPreferredSize(new Dimension(690,25));
		//this.setPreferredSize(new Dimension(800,620));
		ferme.setPreferredSize(new Dimension(30,25));
		
		this.add(panelTable);
		//this.add(bout1);
		//this.add(bout);
		this.setBackground(Color.gray);
		act();
		ferme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		
		semestre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panEc.removeAll();
				ajoutEc(mention,(String)semestre.getSelectedItem(),t);
				act();
				Main.main.setVisible(true);
			}
		});
		
		semestre.addActionListener(new Actualiser(modelEc,modelUe,mention,semestre,t,filier));
		
		tp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tp.isSelected()) {
					poidsTp.setVisible(true);
					poidsTpTxt.setVisible(true);
				}else {
					poidsTp.setVisible(false);
					poidsTpTxt.setVisible(false);
				}
			}
		});
		
		add1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!ueTxt.getText().equals("") && !crdtTxt.getText().equals("")) {
				String l=(String)semestre.getSelectedItem();
				String clas="";
				switch(l) {
				case "Semestre1":
					clas="_tc";
					break;
				case "Semestre2":
					clas="_12";
					break;
				case "Semestre3":
					clas="_23";
					break;
				case "Semestre4":
					clas="_24";
					break;
				case "Semestre5":
					clas="_35";
					break;
				case "Semestre6":
					clas="_36";
					break;
				case "Semestre7":
					clas="_47";
					break;
				case "Semestre8":
					clas="_48";
					break;
				case "Semestre9":
					clas="_59";
					break;
				case "Semestre10":
					clas="_510";
					break;
				}
				DataBase.ajout_ue(mention,Methode.finitBack(ueTxt.getText()+clas), Integer.parseInt(crdtTxt.getText()),
						(String) semestre.getSelectedItem(),t );
				modelUe=DataBase.importDonneUe(modelUe, mention, (String)semestre.getSelectedItem(), filier, t);
				panEc.removeAll();
				
				ajoutEc(mention,(String)semestre.getSelectedItem(),t);
				act();
				ueTxt.setText("");
				crdtTxt.setText("");
				Main.main.setVisible(true);
				JOptionPane.showMessageDialog(Main.main, " U.E bien ajouté ", "",
						JOptionPane.INFORMATION_MESSAGE); 
				}else {
					JOptionPane.showMessageDialog(Main.main, " CHAMPS VIDE ", "",
							JOptionPane.ERROR_MESSAGE); 
			}
			}
		});
		
		add2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String l=(String)semestre.getSelectedItem();
				String clas="";
				switch(l) {
				case "Semestre1":
					clas="_tc";
					break;
				case "Semestre2":
					clas="_12";
					break;
				case "Semestre3":
					clas="_23";
					break;
				case "Semestre4":
					clas="_24";
					break;
				case "Semestre5":
					clas="_35";
					break;
				case "Semestre6":
					clas="_36";
					break;
				case "Semestre7":
					clas="_47";
					break;
				case "Semestre8":
					clas="_48";
					break;
				case "Semestre9":
					clas="_59";
					break;
				case "Semestre10":
					clas="_510";
					break;
				}
				if(tp.isSelected()) {
				if(!poidsTpTxt.getText().equals("") && !ecTxt.getText().equals("")
						&& !poidsTxt.getText().equals("")) {
				
				DataBase.ajout_ec(mention,Methode.finitBack(ecTxt.getText()+clas),(String)typeUe.getSelectedItem(),
						(String)semestre.getSelectedItem(),Double.parseDouble(poidsTxt.getText()),t
						,Methode.finitText(enseiTxt.getText()) );
				
				DataBase.ajout_ec(mention,"Tp_"+Methode.finitBack(ecTxt.getText()+clas),(String)typeUe.getSelectedItem(),
							(String)semestre.getSelectedItem(),Double.parseDouble(poidsTxt.getText()),t
							,Methode.finitText(enseiTxt.getText()) );
				
				modelEc=DataBase.importDonneEC(modelEc, mention, (String)semestre.getSelectedItem(), filier, t);
				
					panEc.removeAll();
					poidsTpTxt.setText("");
					ecTxt.setText("");
					poidsTxt.setText("");
					enseiTxt.setText("");
					tp.setSelected(false);
					ajoutEc(mention,(String)semestre.getSelectedItem(),t);
					act();
					ecTxt.setEditable(false);
					poidsTxt.setEditable(false);
					enseiTxt.setEditable(false);
					tp.setEnabled(false);
					add2.setEnabled(false);
					annule.setEnabled(false);
					Main.main.setVisible(true);
					JOptionPane.showMessageDialog(Main.main, " E.C bien ajouté ", "",
							JOptionPane.INFORMATION_MESSAGE); 
				}else
						JOptionPane.showMessageDialog(Main.main, " champs vide ", "",
							JOptionPane.ERROR_MESSAGE); 
					
				}else {
					if(!ecTxt.getText().equals("")&& !poidsTxt.getText().equals("")) {
					
					DataBase.ajout_ec(mention,Methode.finitBack(ecTxt.getText()+clas),(String)typeUe.getSelectedItem(),
							(String)semestre.getSelectedItem(),Double.parseDouble(poidsTxt.getText()),t
							,Methode.finitText(enseiTxt.getText()) );
					modelEc=DataBase.importDonneEC(modelEc, mention, (String)semestre.getSelectedItem(), filier, t);
					
						panEc.removeAll();
						poidsTpTxt.setText("");
						ecTxt.setText("");
						poidsTxt.setText("");
						enseiTxt.setText("");
						ajoutEc(mention,(String)semestre.getSelectedItem(),t);
						act();
						ecTxt.setEditable(false);
						poidsTxt.setEditable(false);
						enseiTxt.setEditable(false);
						tp.setEnabled(false);
						add2.setEnabled(false);
						annule.setEnabled(false);
						Main.main.setVisible(true);
						JOptionPane.showMessageDialog(Main.main, " E.C bien ajouté ", "",
								JOptionPane.INFORMATION_MESSAGE); 
					}else
						JOptionPane.showMessageDialog(Main.main, " champs vide ", "",
							JOptionPane.ERROR_MESSAGE); 
					
			}
				
				
			}
		});
		
		tableEc.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				if(tableEc.getRowCount()>0 && tableEc.getSelectedRow()!=-1) {
				if(e.getClickCount()==1) { 
					modEc.setVisible(false);
					suppEc.setVisible(false);
					tableEc.clearSelection();
				}
				if(e.getClickCount()==2) {
					modEc.setVisible(true);
					suppEc.setVisible(true);
				}
			   }
			}
		});
		
		tableUe.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				if(tableUe.getRowCount()>0 && tableUe.getSelectedRow()!=-1) {
				if(e.getClickCount()==1) { 
					modUe.setVisible(false);
					suppUe.setVisible(false);
					tableUe.clearSelection();
				}
				if(e.getClickCount()==2) {
					modUe.setVisible(true);
					suppUe.setVisible(true);
				}
			   }
			}
		});
		
		modEc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				add2.setVisible(false);
				
				typeUe.setEnabled(false);
				ecTxt.setEnabled(false);
				enregmod.setVisible(true);
				DataBase.recuperInformationEc(mention, t, Methode.getNom(tableEc), ecTxt, poidsTxt, enseiTxt, typeUe);
			}
		});
		
		annule2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ueTxt.setText("");
				crdtTxt.setText("");
				add1.setVisible(true);
				enregmod2.setVisible(false);
				modUe.setVisible(false);
				suppUe.setVisible(false);
				tableUe.clearSelection();
				ueTxt.setEditable(true);
			}
		});
		
		annule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ecTxt.setText("");
				poidsTxt.setText("");
				enseiTxt.setText("");
				add2.setVisible(true);
				enregmod.setVisible(false);
				modEc.setVisible(false);
				suppEc.setVisible(false);
				tableEc.clearSelection();
				ecTxt.setEditable(true);
				typeUe.setEnabled(true);
			}
		});
		
		modUe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				add1.setVisible(false);
				ueTxt.setEditable(false);
				enregmod2.setVisible(true);
				DataBase.recuperInformationUe(mention, t, Methode.getNom(tableUe), ueTxt, crdtTxt);
				
			}
		});
		
		suppEc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int option = JOptionPane.showConfirmDialog(null,"Voulez-vous Supprimer "
						+Methode.getNom(tableEc)+" "
								+ "?","ATTENTION!",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);
				if(option == JOptionPane.OK_OPTION){
				DataBase.supprimerEc(mention, t,  Methode.getNom(tableEc));
				modelEc=DataBase.importDonneEC(modelEc, mention, (String)semestre.getSelectedItem(), filier, t);
				suppEc.setVisible(false);
				modEc.setVisible(false);
				JOptionPane.showMessageDialog(Main.main, " E.C bien Supprimé ", "",
						JOptionPane.INFORMATION_MESSAGE); 
				}
					}
		});
		
		suppUe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int option = JOptionPane.showConfirmDialog(null,"Voulez-vous Supprimer "
						+Methode.getNom(tableUe)+" "
								+ "?","ATTENTION!",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);
				if(option == JOptionPane.OK_OPTION){
					DataBase.supprimerUe(mention, t,  Methode.getNom(tableUe));
					DataBase.supprimerEc_Ue(mention, t,  Methode.getNom(tableUe));
					modelUe=DataBase.importDonneUe(modelUe, mention, (String)semestre.getSelectedItem(), filier, t);
					modelEc=DataBase.importDonneEC(modelEc, mention, (String)semestre.getSelectedItem(), filier, t);
					panEc.removeAll();
					ajoutEc(mention,(String)semestre.getSelectedItem(),t);
					act();
					suppUe.setVisible(false);
					modUe.setVisible(false);
					JOptionPane.showMessageDialog(Main.main, " U.E bien Supprimé ", "",
							JOptionPane.INFORMATION_MESSAGE); 
				}
			}
		});
		
		enregmod2.addActionListener(new ActionListener() {//UE
			public void actionPerformed(ActionEvent arg0) {
				int option = JOptionPane.showConfirmDialog(null,"Voulez-vous modifier "
						+Methode.getNom(tableUe)+" "
								+ "?","ATTENTION!",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);
				if(option == JOptionPane.OK_OPTION){
				DataBase.modifierUe(mention, t,  ueTxt.getText(),Integer.parseInt( crdtTxt.getText()));
				modelUe=DataBase.importDonneUe(modelUe, mention, (String)semestre.getSelectedItem(), filier, t);
				ueTxt.setEditable(true);
				ueTxt.setText("");
				crdtTxt.setText("");
				add1.setVisible(true);
				enregmod2.setVisible(false);
				modUe.setVisible(false);
				suppUe.setVisible(false);
				tableUe.clearSelection();
				ueTxt.setEditable(true);
				}
			}
		});
		
		enregmod.addActionListener(new ActionListener() {//EC
			public void actionPerformed(ActionEvent arg0) {
				int option = JOptionPane.showConfirmDialog(null,"Voulez-vous modifier "
						+Methode.getNom(tableEc)+" "
								+ "?","ATTENTION!",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);
				if(option == JOptionPane.OK_OPTION){
				DataBase.modifierEc(mention, t,  ecTxt.getText(),Double.parseDouble( poidsTxt.getText()),
						enseiTxt.getText());
				modelEc=DataBase.importDonneEC(modelEc, mention, (String)semestre.getSelectedItem(), filier, t);
				ecTxt.setText("");
				ecTxt.setEnabled(true);
				poidsTxt.setText("");
				enseiTxt.setText("");
				add2.setVisible(true);
				enregmod.setVisible(false);
				modEc.setVisible(false);
				suppEc.setVisible(false);
				tableEc.clearSelection();
				ecTxt.setEditable(true);
				typeUe.setEnabled(true);
				typeUe.setSelectedIndex(0);
				}
			}
		});
		
		
		
		
	}
	
	public  void act() {
		//ACTION SUR LA JCOMBOBOX
		typeUe.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
			if(typeUe.getSelectedIndex()==-1 || typeUe.getSelectedIndex()==0 ) {
				ecTxt.setEditable(false);
				poidsTxt.setEditable(false);
				enseiTxt.setEditable(false);
				tp.setEnabled(false);
				add2.setEnabled(false);
				annule.setEnabled(false);
			}else{
				ecTxt.setEditable(true);
				poidsTxt.setEditable(true);
				enseiTxt.setEditable(true);
				add2.setEnabled(true);
				tp.setEnabled(true);
				annule.setEnabled(true);
		}
	}
	});
	}
	
	public   void ajoutEc(String mention,String l,int t) {
		typeUe= DataBase.recuperUe(mention,l,t );
		typeUe.setPreferredSize(new Dimension(130,20));
		
		panEc.add(ecTitre);
		panEc.add(ue1);
		panEc.add(typeUe);
		panEc.add(ligne3);
		panEc.add(ec);
		panEc.add(ecTxt);
		panEc.add(poids);
		panEc.add(poidsTxt);
		panEc.add(ensei);
		panEc.add(enseiTxt);
		panEc.add(tp);
		panEc.add(ligne);
		panEc.add(poidsTp);
		panEc.add(poidsTpTxt);
		panEc.add(add2);
		panEc.add(enregmod);
		panEc.add(annule);
	}
	
	@SuppressWarnings("rawtypes")
	public static class Actualiser implements ActionListener {
		int i;
		DefaultTableModel modelEc;
		DefaultTableModel modelUe;
		JComboBox semestre;
		String mention;
		String filier;
		int t;
		Actualiser(DefaultTableModel modelEc,DefaultTableModel modelUe,String mention,
					JComboBox semestre,int t,String filier){
			this.modelUe=modelUe;
			this.modelEc=modelEc;
			this.semestre=semestre;
			this.mention=mention;
			this.filier=filier;
			this.t=t;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			modelUe=DataBase.importDonneUe(modelUe, mention, (String)semestre.getSelectedItem(), filier, t);
			modelEc=DataBase.importDonneEC(modelEc, mention, (String)semestre.getSelectedItem(), filier, t);
		}
	}
}
