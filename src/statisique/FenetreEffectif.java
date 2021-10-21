package statisique;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class FenetreEffectif {
	public static JScrollPane scrollpane;
public static JPanel panelPrincipale=new JPanel();
public static JPanel panelbout=new JPanel();
public static JPanel panelmatiere=new JPanel();
public static JPanel panMatiere[];


public static JButton tcm=new JButton("effectif total");
public static JButton miss=new JButton("effectif par nationalité");
public static JButton me=new JButton("effectif par age");
public static JButton nouveau=new JButton("Nouveau bachelier");
public static JButton dipl=new JButton("Etudiant diplomé");
public static JButton rens=new JButton("Renseignement");
public static DefaultTableModel modelDelib;

static String titreDelib[]= {"Parcours","N","R","T+","N","R","T+","M","F","Total"};
static String titreDelib2[]= {"Parcours","N","R","T+","N","R","T+","M","F","Total",""};
static String titreDelib3[]= {"Age","N","R","T+","S/tot","N","R","T+","S/tot","N","R","T+","Total"};
static String titreDelib4[]= {"Filière","Serie A1","Serie A2","Serie C","Serie D","Tech.Génie civile","Tech.Industrielle",
		"Tech.Tertiaire","Tech.Agricole","Technologique","Autre","Ensemble"};
static String titreDelib5[]= {"","","",""};
static String titreDelib6[]= {"","","","",""};
public static JButton boutPc[]= {tcm,miss,me,nouveau,dipl,rens};

public static void ajouter() {
	panMatiere=new JPanel[6];
	
	panMatiere[0]=new StatTotal("MATHEMATIQUES ET APPLICATIONS",modelDelib,titreDelib,1);
	panelmatiere.add(panMatiere[0]);
	
	panMatiere[1]=new StatTotal("MATHEMATIQUES ET APPLICATIONS",modelDelib,titreDelib2,2);
	panelmatiere.add(panMatiere[1]);
	
	panMatiere[2]=new StatParAge("MATHEMATIQUES ET APPLICATIONS",modelDelib,titreDelib3);
	panelmatiere.add(panMatiere[2]);
	
	panMatiere[3]=new StatBach("MATHEMATIQUES ET APPLICATIONS",modelDelib,titreDelib4);
	panelmatiere.add(panMatiere[3]);
	
	panMatiere[4]=new StatDiplome("MATHEMATIQUES ET APPLICATIONS", modelDelib,titreDelib5,1);
	panelmatiere.add(panMatiere[4]);
	
	panMatiere[5]=new RenseignementMat("MATHEMATIQUES ET APPLICATIONS", modelDelib,titreDelib6);
	panelmatiere.add(panMatiere[5]);
	
	for(int i=0;i<panMatiere.length;i++) {
		boutPc[i].setPreferredSize(new Dimension(180,20));
		panelbout.add(boutPc[i]);
	}
	
	for(int i=1;i<panMatiere.length;i++) {
		panMatiere[i].setVisible(false);
	}
	
	for(int i=0;i<panMatiere.length;i++) {
		boutPc[i].addActionListener(new Visible(panMatiere,i));;
	}
	
	panelPrincipale.setBackground(Color.CYAN);
	panelmatiere.setPreferredSize(new Dimension(920,700));
	panelbout.setPreferredSize(new Dimension(200,600));
	panelbout.setBackground(Color.cyan);
	panelmatiere.setBackground(Color.cyan);
	panelPrincipale.add(panelbout);
	panelPrincipale.add(panelmatiere);
	panelPrincipale.setLayout(new FlowLayout(FlowLayout.LEFT));
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

