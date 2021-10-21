package gest_matiere;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import image.LoadImage;
import panel.PanelMatiere;

public class MatiereMaths {
	public static JScrollPane scrollpane;
public static JPanel panelPrincipale=new JPanel();
public static JPanel panelbout=new JPanel();
public static JPanel panelmatiere=new JPanel();
public static JPanel panMatiere[];


public static JButton tcm=new JButton( LoadImage.transformeb(100, 25, "/tcm.jpg"));
public static JButton miss=new JButton( LoadImage.transformeb(100, 25, "/miss.jpg"));
public static JButton me=new JButton( LoadImage.transformeb(100, 25, "/me.jpg"));
public static JButton mf=new JButton( LoadImage.transformeb(100, 25, "/mf.jpg"));


public static JButton boutPc[]= {tcm,miss,me,mf};


public static String sems1[]= {"Semestre1"};
public static String sems2[]= {"Semestre2","Semestre3","Semestre4","Semestre5",
								"Semestre6","Semestre7","Semestre8","Semestre9","Semestre10"};

public static JComboBox <String> combtcm=new JComboBox<String>(sems1);
public static JComboBox <String> combmiss=new JComboBox<String>(sems2);
public static JComboBox <String> combme=new JComboBox<String>(sems2);
public static JComboBox <String> combmf=new JComboBox<String>(sems2);


public static void ajouter() {
	panMatiere=new JPanel[4];
	
	
	panMatiere[0]=new PanelMatiere("T.C.M", "MATHEMATIQUES ET APPLICATIONS", combtcm, 0,"T.C.M");
	panelmatiere.add(panMatiere[0]);
	panMatiere[1]=new PanelMatiere("M.I.S.S", "MATHEMATIQUES ET APPLICATIONS",combmiss, 1,"M.I.S.S");
	panelmatiere.add(panMatiere[1]);
	panMatiere[2]=new PanelMatiere("M.E", "MATHEMATIQUES ET APPLICATIONS",combme, 2,"M.E");
	panelmatiere.add(panMatiere[2]);
	panMatiere[3]=new PanelMatiere("M.F", "MATHEMATIQUES ET APPLICATIONS", combmf, 3,"M.F");
	panelmatiere.add(panMatiere[3]);
	for(int i=0;i<panMatiere.length;i++) {
		panelbout.add(boutPc[i]);
	}
	
	for(int i=1;i<panMatiere.length;i++) {
		panMatiere[i].setVisible(false);
	}
	for(int i=0;i<panMatiere.length;i++) {
		boutPc[i].addActionListener(new Visible(panMatiere,i));;
	}
	
	tcm.setPreferredSize(new Dimension(100,25));
	miss.setPreferredSize(new Dimension(100,25));
	me.setPreferredSize(new Dimension(100,25));
	mf.setPreferredSize(new Dimension(100,25));
	
	panelPrincipale.setBackground(Color.CYAN);
	
	panelmatiere.setPreferredSize(new Dimension(850,460));
	panelPrincipale.setPreferredSize(new Dimension(900,600));
	panelbout.setPreferredSize(new Dimension(850,40));
	panelbout.setBackground(Color.GRAY);
	panelmatiere.setBackground(Color.GRAY);
	panelPrincipale.add(panelmatiere);
	panelPrincipale.add(panelbout);
	scrollpane=new JScrollPane(panelPrincipale);
}

public static class Visible implements ActionListener {
	JPanel pan[];
	int i;
	Visible(JPanel pan[],int i){
		this.pan=pan;
		this.i=i;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		pan[i].setVisible(true);
		for(int j=0;j<pan.length;j++) {
			if(j!=i)
				pan[j].setVisible(false);
		}
	}
	
}
}
