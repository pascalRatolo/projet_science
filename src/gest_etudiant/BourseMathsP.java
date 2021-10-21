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
import panel.PanelBourse;
import table.TableModel;

public class BourseMathsP {

	public static JPanel panelPrincipale1[];
	public static JPanel panel[];
	public static JPanel panelList[];
	public static JLabel titre[];
	public static JLabel titre1[];
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
	
	
	public static String semestre[]= {"L1","L2","L3","M1","M2"};
	
	public static DefaultTableModel modeltcm[]= new DefaultTableModel[1];
	public static DefaultTableModel modelmiss[]= new DefaultTableModel[10];
	public static DefaultTableModel modelme[]= new DefaultTableModel[10];
	public static DefaultTableModel modelmf[]= new DefaultTableModel[10];
	
	public static Font font=new Font("arial",Font.BOLD,16);
	public static JTabbedPane panelPrincipale= new JTabbedPane();
	public static JScrollPane scrollPane;
	
	public static String titreTable[]= {"N°","N°Carte","Nom et Prenom "};
		
	public static void ajouter() {
			tcm=new JButton[5];
			miss=new JButton[5];
			me=new JButton[5];
			mf=new JButton[5];
			
			acttcm=new JButton[1];
			actmiss=new JButton[5];
			actme=new JButton[5];
			actmf=new JButton[5];
			
			tabletcm=new JTable[1];
			tablemiss=new JTable[5];
			tableme=new JTable[5];
			tablemf=new JTable[5];
			
			panelPrincipale1=new JPanel[5];
			panel=new JPanel[5];
			
			panelTabletcm=new JPanel[1];
			panelTablemiss=new JPanel[5];
			panelTableme=new JPanel[5];
			panelTablemf=new JPanel[5];
			
			panelList=new JPanel[5];
			titre=new JLabel[5];
			titre1=new JLabel[5];
			
		for(int i=0;i<5;i++) {
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
			titre[i]=new JLabel("LISTE L"+(i+1)+" ");
			titre1[i]=new JLabel("LISTE M"+(i-2)+" ");
			
			if(i<1) {
				acttcm[i]=new JButton( LoadImage.transformeb(100, 25, "/actualiser.jpg"));
				modeltcm[i]=new TableModel(titreTable);
				modeltcm[i]=DataBase.importDonneBourse(modeltcm[i], "MATHEMATIQUES ET APPLICATIONS", semestre[i],"T.C.M"); //ligne 468 data base
				tabletcm[i]=new JTable(modeltcm[i]);
				panelTabletcm[i]= new PanelBourse(semestre[i]+" T.C.M",tabletcm[i],acttcm[i],modeltcm[i]);
				tcm[i].addActionListener(new Visible(i,panelTabletcm[i]));
				acttcm[i].addActionListener(new Actualiser(modeltcm[i],semestre[i],"T.C.M"));
				panelList[i].add(panelTabletcm[i]);
				acttcm[i].setPreferredSize(new Dimension(100,25));
				
				miss[i].setEnabled(false);
				me[i].setEnabled(false);
				mf[i].setEnabled(false);
				tcm[i].setEnabled(true);
				panel[i].add(titre[i]);
				
			}else {
				if(i<3) {
				actmiss[i]=new JButton( LoadImage.transformeb(100, 25, "/actualiser.jpg"));	
				modelmiss[i]=new TableModel(titreTable);
				modelmiss[i]=DataBase.importDonneBourse(modelmiss[i], "MATHEMATIQUES ET APPLICATIONS", semestre[i],"M.I.S.S");
			    tablemiss[i]=new JTable(modelmiss[i]);
			    actmiss[i].setPreferredSize(new Dimension(100,25));
			    
				panelTablemiss[i]= new PanelBourse(semestre[i]+" M.I.S.S ",tablemiss[i],actmiss[i],modelmiss[i]);
				miss[i].addActionListener(new Visible(i,panelTablemiss[i]));
				actmiss[i].addActionListener(new Actualiser(modelmiss[i],semestre[i],"M.I.S.S"));
			    panelList[i].add(panelTablemiss[i]); 
			    
			    actme[i]=new JButton( LoadImage.transformeb(100, 25, "/actualiser.jpg"));
				modelme[i]=new TableModel(titreTable);
				modelme[i]=DataBase.importDonneBourse(modelme[i], "MATHEMATIQUES ET APPLICATIONS", semestre[i],"M.E");
			    tableme[i]=new JTable(modelme[i]);
			    actme[i].setPreferredSize(new Dimension(100,25));
				
				panelTableme[i]= new PanelBourse(semestre[i]+" M.E ",tableme[i],actme[i],modelme[i]);
				me[i].addActionListener(new Visible(i,panelTableme[i]));
				actme[i].addActionListener(new Actualiser(modelme[i],semestre[i],"M.E"));
			    panelList[i].add(panelTableme[i]); 
			    
			    actmf[i]=new JButton( LoadImage.transformeb(100, 25, "/actualiser.jpg"));
				modelmf[i]=new TableModel(titreTable);
				modelmf[i]=DataBase.importDonneBourse(modelmf[i], "MATHEMATIQUES ET APPLICATIONS",semestre[i],"M.F");
			    tablemf[i]=new JTable(modelmf[i]);
			    actmf[i].setPreferredSize(new Dimension(100,25));
				
				panelTablemf[i]= new PanelBourse(semestre[i]+" M.F ",tablemf[i],actmf[i],modelmf[i]);
				mf[i].addActionListener(new Visible(i,panelTablemf[i]));
				actmf[i].addActionListener(new Actualiser(modelmf[i],semestre[i],"M.F"));
			    panelList[i].add(panelTablemf[i]); 
				
			
				tcm[i].setEnabled(false);
				miss[i].setEnabled(true);
				me[i].setEnabled(true);
				mf[i].setEnabled(true);
				panel[i].add(titre[i]);
				
				}else {
					actmiss[i]=new JButton( LoadImage.transformeb(100, 25, "/actualiser.jpg"));	
					modelmiss[i]=new TableModel(titreTable);
					modelmiss[i]=DataBase.importDonneBourse(modelmiss[i], "MATHEMATIQUES ET APPLICATIONS", semestre[i],"M.I.S.S");
				    tablemiss[i]=new JTable(modelmiss[i]);
				    actmiss[i].setPreferredSize(new Dimension(100,25));
				    
					panelTablemiss[i]= new PanelBourse(semestre[i]+" M.I.S.S ",tablemiss[i],actmiss[i],modelmiss[i]);
					miss[i].addActionListener(new Visible(i,panelTablemiss[i]));
					actmiss[i].addActionListener(new Actualiser(modelmiss[i],semestre[i],"M.I.S.S"));
				    panelList[i].add(panelTablemiss[i]); 
				    
				    actme[i]=new JButton( LoadImage.transformeb(100, 25, "/actualiser.jpg"));
					modelme[i]=new TableModel(titreTable);
					modelme[i]=DataBase.importDonneBourse(modelme[i], "MATHEMATIQUES ET APPLICATIONS", semestre[i],"M.E");
				    tableme[i]=new JTable(modelme[i]);
				    actme[i].setPreferredSize(new Dimension(100,25));
					
					panelTableme[i]= new PanelBourse(semestre[i]+" M.E ",tableme[i],actme[i],modelme[i]);
					me[i].addActionListener(new Visible(i,panelTableme[i]));
					actme[i].addActionListener(new Actualiser(modelme[i],semestre[i],"M.E"));
				    panelList[i].add(panelTableme[i]); 
				    
				    actmf[i]=new JButton( LoadImage.transformeb(100, 25, "/actualiser.jpg"));
					modelmf[i]=new TableModel(titreTable);
					modelmf[i]=DataBase.importDonneBourse(modelmf[i], "MATHEMATIQUES ET APPLICATIONS",semestre[i],"M.F");
				    tablemf[i]=new JTable(modelmf[i]);
				    actmf[i].setPreferredSize(new Dimension(100,25));
					
					panelTablemf[i]= new PanelBourse(semestre[i]+" M.F ",tablemf[i],actmf[i],modelmf[i]);
					mf[i].addActionListener(new Visible(i,panelTablemf[i]));
					actmf[i].addActionListener(new Actualiser(modelmf[i],semestre[i],"M.F"));
				    panelList[i].add(panelTablemf[i]); 
					
				
					tcm[i].setEnabled(false);
					miss[i].setEnabled(true);
					me[i].setEnabled(true);
					mf[i].setEnabled(true);
					panel[i].add(titre1[i]);
				}
			}
			
			
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
		
		JPanel tPan[]= panelPrincipale1;
		scrollPane = new JScrollPane(panelPrincipale);
		int i = 0;
		for(JPanel pan : tPan){
			if(i<3)
		        panelPrincipale.add("Niveau L"+(++i), pan);
			else
				panelPrincipale.add("Niveau M"+((++i)-3), pan);
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
			model=DataBase.importDonneBourse(model, "MATHEMATIQUES ET APPLICATIONS", sems, parc);
		}
		
	}
	
}
