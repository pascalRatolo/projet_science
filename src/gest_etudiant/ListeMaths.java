package gest_etudiant;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import data_base.DataBase;
import image.LoadImage;
import panel.PanelList;
import table.TableModel;

public class ListeMaths {

	public static JPanel panelPrincipale1[];
	public static JPanel panel[];
	public static JPanel panelList[];
	public static JLabel titre[];
	public static JPanel panelTabletcm[];
	public static JPanel panelTablemiss[];
	public static JPanel panelTableme[];
	public static JPanel panelTablemf[];
	
	public static JScrollPane scrollPane1;
	
	
	public static JButton tcm[];
	public static JButton miss[];
	public static JButton me[];
	public static JButton mf[];
	
	public static JButton acttcm[];
	public static JButton actmiss[];
	public static JButton actme[];
	public static JButton actmf[];
	
	
	public static JTable tabletcm[];
	public static JTable tablemiss[];
	public static JTable tableme[];
	public static JTable tablemf[];
	
	
	public static String semestre[]= {"Semestre1","Semestre2","Semestre3","Semestre4","Semestre5",
									"Semestre6","Semestre7","Semestre8","Semestre9","Semestre10"};
	
	public static DefaultTableModel modeltcm[]= new DefaultTableModel[1];
	public static DefaultTableModel modelmiss[]= new DefaultTableModel[10];
	public static DefaultTableModel modelme[]= new DefaultTableModel[10];
	public static DefaultTableModel modelmf[]= new DefaultTableModel[10];
	
	public static Font font=new Font("arial",Font.BOLD,16);
	public static JTabbedPane panelPrincipale= new JTabbedPane();
	public static JScrollPane scrollPane;
	
	public static String titreTable[]= {"N°","N°Carte","Nom et Prenom "};
		
	public static void ajouter() {
			tcm=new JButton[10];
			miss=new JButton[10];
			me=new JButton[10];
			mf=new JButton[10];
			
			acttcm=new JButton[1];
			actmiss=new JButton[10];
			actme=new JButton[10];
			actmf=new JButton[10];
			
			tabletcm=new JTable[1];
			tablemiss=new JTable[10];
			tableme=new JTable[10];
			tablemf=new JTable[10];
			
			panelPrincipale1=new JPanel[10];
			panel=new JPanel[10];
			
			panelTabletcm=new JPanel[1];
			panelTablemiss=new JPanel[10];
			panelTableme=new JPanel[10];
			panelTablemf=new JPanel[10];
			
			panelList=new JPanel[10];
			titre=new JLabel[10];
			
		for(int i=0;i<10;i++) {
			tcm[i]=new JButton (LoadImage.transformeb(150, 25, "/tcm.jpg"));
			miss[i]=new JButton (LoadImage.transformeb(150, 25, "/miss.jpg"));
			me[i]=new JButton (LoadImage.transformeb(150, 25, "/me.jpg"));
			mf[i]=new JButton (LoadImage.transformeb(150, 25, "/mf.jpg"));
			
			tcm[i].setPreferredSize(new Dimension(100,25));
			miss[i].setPreferredSize(new Dimension(100,25));
			me[i].setPreferredSize(new Dimension(100,25));
			mf[i].setPreferredSize(new Dimension(100,25));
			
			panelPrincipale1[i]=new JPanel();
			panel[i]=new JPanel();
			panelList[i]=new JPanel();
			
			
		
			
			tcm[i].setPreferredSize(new Dimension(130,25));
			miss[i].setPreferredSize(new Dimension(130,25));
			me[i].setPreferredSize(new Dimension(130,25));
			mf[i].setPreferredSize(new Dimension(130,25));
			
			tcm[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			miss[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			me[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			mf[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			
			panel[i].setPreferredSize(new Dimension(150,630));
			panelList[i].setPreferredSize(new Dimension(990,630));
			titre[i]=new JLabel("LISTE S"+(i+1)+" ");
			
			if(i<1) {
				acttcm[i]=new JButton( LoadImage.transformeb(100, 25, "/actualiser.jpg"));
				modeltcm[i]=new TableModel(titreTable);
				modeltcm[i]=DataBase.importDonneTable(modeltcm[i], "MATHEMATIQUES ET APPLICATIONS", "S"+(i+1),"T.C.M"); //ligne 468 data base
				tabletcm[i]=new JTable(modeltcm[i]);
				panelTabletcm[i]= new PanelList("S"+(i+1)+" T.C.M",tabletcm[i],acttcm[i],modeltcm[i]);
				tcm[i].addActionListener(new Visible(i,panelTabletcm[i]));
				acttcm[i].addActionListener(new Actualiser(modeltcm[i],"S"+(i+1),"T.C.M"));
				panelList[i].add(panelTabletcm[i]);
				acttcm[i].setPreferredSize(new Dimension(100,25));
				
				miss[i].setEnabled(false);
				me[i].setEnabled(false);
				mf[i].setEnabled(false);
				tcm[i].setEnabled(true);
				
			}else {
				actmiss[i]=new JButton( LoadImage.transformeb(100, 25, "/actualiser.jpg"));	
				modelmiss[i]=new TableModel(titreTable);
				modelmiss[i]=DataBase.importDonneTable(modelmiss[i], "MATHEMATIQUES ET APPLICATIONS", "S"+(i+1),"M.I.S.S");
			    tablemiss[i]=new JTable(modelmiss[i]);
			    actmiss[i].setPreferredSize(new Dimension(100,25));
			    
				panelTablemiss[i]= new PanelList("S"+(i+1)+" M.I.S.S ",tablemiss[i],actmiss[i],modelmiss[i]);
				miss[i].addActionListener(new Visible(i,panelTablemiss[i]));
				actmiss[i].addActionListener(new Actualiser(modelmiss[i],"S"+(i+1),"M.I.S.S"));
			    panelList[i].add(panelTablemiss[i]); 
			    
			    actme[i]=new JButton( LoadImage.transformeb(100, 25, "/actualiser.jpg"));
				modelme[i]=new TableModel(titreTable);
				modelme[i]=DataBase.importDonneTable(modelme[i], "MATHEMATIQUES ET APPLICATIONS", "S"+(i+1),"M.E");
			    tableme[i]=new JTable(modelme[i]);
			    actme[i].setPreferredSize(new Dimension(100,25));
				
				panelTableme[i]= new PanelList("S"+(i+1)+" M.E ",tableme[i],actme[i],modelme[i]);
				me[i].addActionListener(new Visible(i,panelTableme[i]));
				actme[i].addActionListener(new Actualiser(modelme[i],"S"+(i+1),"M.E"));
			    panelList[i].add(panelTableme[i]); 
			    
			    actmf[i]=new JButton( LoadImage.transformeb(100, 25, "/actualiser.jpg"));
				modelmf[i]=new TableModel(titreTable);
				modelmf[i]=DataBase.importDonneTable(modelmf[i], "MATHEMATIQUES ET APPLICATIONS", "S"+(i+1),"M.F");
			    tablemf[i]=new JTable(modelmf[i]);
			    actmf[i].setPreferredSize(new Dimension(100,25));
				
				panelTablemf[i]= new PanelList("S"+(i+1)+" M.F ",tablemf[i],actmf[i],modelmf[i]);
				mf[i].addActionListener(new Visible(i,panelTablemf[i]));
				actmf[i].addActionListener(new Actualiser(modelmf[i],"S"+(i+1),"M.F"));
			    panelList[i].add(panelTablemf[i]); 
				
			
				tcm[i].setEnabled(false);
				miss[i].setEnabled(true);
				me[i].setEnabled(true);
				mf[i].setEnabled(true);
				
			}
			
			panel[i].add(titre[i]);
			panel[i].add(tcm[i]);
			panel[i].add(miss[i]);
			
			panel[i].add(me[i]);
			panel[i].add(mf[i]);
			
			panelList[i].setLayout(new FlowLayout(FlowLayout.LEFT));
			panelPrincipale1[i].setBackground(Color.cyan);
			//model[i]=DataBase.crerTable(i+1,semestre[i], "",1, panelPrincipale1[i],panel[i],table,"Normal");
			panelPrincipale1[i].add(panel[i]);
			panelPrincipale1[i].add(panelList[i]);
			panelPrincipale1[i].setLayout(new FlowLayout(FlowLayout.LEFT));
			
			
		
		}
		
		
		
		//model[0]=DataBase.crerTable(1,semestre[0], "",0, panelPrincipale1[0],panel[0],table,"Normal");
		
		JPanel tPan[]= panelPrincipale1;
		scrollPane = new JScrollPane(panelPrincipale);
		//scrollPane.setBounds( 00 , 00, 1250 , 650);
		int i = 0;
		for(JPanel pan : tPan){
		//Méthode d'ajout d'onglet
		panelPrincipale.add("SEMESTRE "+(++i), pan);
	}
	}
	
	public static class Visible implements ActionListener {
		int i;
		JPanel pan;
		Visible(int i,JPanel pan){
			this.pan=pan;
			this.i=i;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			pan.setVisible(true);
		}
		
	}
	
	public static class Actualiser implements ActionListener {
		int i;
		DefaultTableModel model;
		String sems;
		String parc;
		Actualiser(DefaultTableModel model,String sems,String parc){
			this.model=model;
			this.sems=sems;
			this.parc=parc;
		}
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			model=DataBase.importDonneTable(model, "MATHEMATIQUES ET APPLICATIONS", sems, parc);
		}
		
	}
	
}
