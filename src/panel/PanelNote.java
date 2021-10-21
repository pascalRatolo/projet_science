package panel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import data_base.DataBase;
import image.LoadImage;
import loading.Main;
import resultat.FenetreResultat;

@SuppressWarnings("serial")
public class PanelNote extends JTabbedPane {
	DefaultTableCellRenderer centerRenderer= new DefaultTableCellRenderer();
	String mention;
	String type;
	String sems[];
	String parcours;
	int nbrSems;
	int t;
	int debutSems;
	JTabbedPane panelPrincipale;
	JPanel panelSemestre[];
	JPanel panelFerme[];
	JTable table[];
	DefaultTableModel model[];
	JButton ferme[];
	JButton act[];
	JButton fen[];
	JButton res[];
	JButton releve[];
	JButton liste[];
	JDialog dial;
	String post;
	public PanelNote(String mention,int nbrSems,int t,int debutSems,String type,String sems[],
			String parcours,String post) {
		this.mention=mention;
		this.nbrSems=nbrSems;
		this.t=t;
		this.debutSems=debutSems;
		this.type=type;
		this.sems=sems;
		this.parcours=parcours;
		this.post=post;
		
		
		panelSemestre=new JPanel[nbrSems];
		table=new JTable[nbrSems];
		model=new DefaultTableModel[nbrSems];
		panelFerme=new JPanel[nbrSems];
		ferme=new JButton[nbrSems];
		act=new JButton[nbrSems];
		fen=new JButton[nbrSems];
		res=new JButton[nbrSems];
		releve=new JButton[nbrSems];
		liste=new JButton[nbrSems];
		
		
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		
		for(int i=0;i<nbrSems;i++) {
			ferme[i]=new JButton( LoadImage.transformeb(30, 25, "/croi1.jpg"));
			act[i]=new JButton( LoadImage.transformeb(100, 25, "/actualiser.jpg"));
			fen[i]=new JButton( LoadImage.transformeb(130, 25, "/fen.jpg"));
			res[i]=new JButton( LoadImage.transformeb(130, 25, "/voir.jpg"));
			releve[i]=new JButton( LoadImage.transformeb(130, 25, "/creer.jpg"));
			
			act[i].setPreferredSize(new Dimension(100,25));
			fen[i].setPreferredSize(new Dimension(130,25));
			res[i].setPreferredSize(new Dimension(130,25));
			releve[i].setPreferredSize(new Dimension(130,25));
			
			liste[i]=new JButton("List.Examen");
			ferme[i].setPreferredSize(new Dimension(30,25));
			panelFerme[i]=new JPanel();
			panelFerme[i].setBackground(Color.cyan);
			panelFerme[i].setPreferredSize(new Dimension(150,490));
			panelFerme[i].add(ferme[i]);
			panelFerme[i].add(act[i]);
			panelFerme[i].add(fen[i]);
			panelFerme[i].add(res[i]);
			panelFerme[i].add(releve[i]);
			panelFerme[i].add(liste[i]);
			model[i]=new DefaultTableModel();
			model[i]=DataBase.crerTable(mention,model[i],(i+debutSems+1), t,type);
			act[i].setPreferredSize(new Dimension(100,25));
			table[i] = new JTable(model[i]);
			
			if(type=="normal" || type=="rattrapage") {
				releve[i].setVisible(false);
				fen[i].setVisible(true);
				res[i].setVisible(true);
				liste[i].setVisible(true);
			}else {
				releve[i].setVisible(true);
				fen[i].setVisible(false);
				res[i].setVisible(true);
				liste[i].setVisible(false);
			}
			
			table[i].setPreferredScrollableViewportSize(new Dimension(100*model[i].getColumnCount(),480));
			table[i].setFillsViewportHeight(true);
			
			
			panelFerme[i].setLayout(new FlowLayout(FlowLayout.LEADING));
			panelSemestre[i]=new JPanel();
			panelSemestre[i].add(panelFerme[i]);
			
			for (int h=0; h<model[i].getColumnCount();h++)
				table[i].getColumnModel().getColumn(h).setCellRenderer(centerRenderer);
			
			panelSemestre[i].add(new JScrollPane(table[i]));
			panelSemestre[i].setLayout(new FlowLayout(FlowLayout.LEADING));
		}
		
		int i = debutSems;
		for(JPanel pan : panelSemestre){
		//Méthode d'ajout d'onglet
		this.add("SEMESTRE "+(++i), pan);
		}
		
		for(int j=0;j<nbrSems;j++) {
		ferme[j].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		act[j].addActionListener(new Actualiser(j,model[j],table[j],panelSemestre[j],panelFerme[j]));
		fen[j].addActionListener(new Saisie());
		res[j].addActionListener(new Result());
		releve[j].addActionListener(new Releve());
		liste[j].addActionListener(new Liste());
	}
		}
	
	public class Actualiser implements ActionListener{
        int i;
        DefaultTableModel model;
        JTable table;
        JPanel pan;
        JPanel pan1;
       Actualiser(int i,DefaultTableModel model,JTable table,JPanel pan,JPanel pan1 ){
        	this.i=i;
        	this.model=model;
        	this.table=table;
        	this.pan=pan;
        	this.pan1=pan1;
        }
		@Override
		public void actionPerformed(ActionEvent arg0) {
			pan.removeAll();
			model=DataBase.actualiser(mention,model, (i+debutSems+1), t, type);
			table=new JTable(model);
			table.setPreferredScrollableViewportSize(new Dimension(100*model.getColumnCount(),480));
			table.setFillsViewportHeight(true);
			pan.add(pan1);
			for (int h=0; h<model.getColumnCount();h++)
				table.getColumnModel().getColumn(h).setCellRenderer(centerRenderer);
			pan.add(new JScrollPane(table));
			Main.main.setVisible(true);
		}
		
	}
	
	public class Saisie implements ActionListener{ 
		public void actionPerformed(ActionEvent arg0) {
			Main.main.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			new FenetreNote(Main.main," NOTE ", true,mention,t,type,parcours,nbrSems,debutSems,sems,post).setVisible(true);
			Main.main.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}
		
	}
	
	public class Result implements ActionListener{ 
		public void actionPerformed(ActionEvent arg0) {
			Main.main.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			new FenetreResultat(Main.main," RESULTAT ", true,mention,t,type,parcours,nbrSems,debutSems,sems,post).setVisible(true);
			Main.main.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}
		
	}
	public class Releve implements ActionListener{ 
		public void actionPerformed(ActionEvent arg0) {
			Main.main.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			new FenetreRelever(Main.main," RESULTAT ", true,mention,t,type,parcours,nbrSems,debutSems,sems,post).setVisible(true);
			Main.main.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}
		
	}
	public class Liste implements ActionListener{ 
		public void actionPerformed(ActionEvent arg0) {
			Main.main.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			new FenetreListeAuExamen(Main.main," RESULTAT ", true,mention,t,type,parcours,nbrSems,debutSems,sems,post).setVisible(true);
			Main.main.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}
		
	}

}
