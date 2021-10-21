package gest_note;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

import image.LoadImage;
import loading.Main;
import panel.PanelNote;

public class GestNoteMathsRattrapage {
	
	public static String username = "postgres";     
	public static String password = "postgres";     
	public static String url = "jdbc:postgresql://localhost:5432/";     
	public static Connection connection = null;     
	public static Statement statement = null;     
	public static ResultSet rset = null;


	public static JPanel panelPrincipale1[];
	public static JPanel panel[];
	public static JLabel titreMiss[];
	public static JLabel titreMe[];
	public static JLabel titreMf[];
	
	public static JScrollPane scrollPane1;
	
	
	public static JButton tcm=new JButton( LoadImage.transformeb(100, 25, "/tcm.jpg"));
	public static JButton miss=new JButton( LoadImage.transformeb(100, 25, "/miss.jpg"));
	public static JButton me=new JButton( LoadImage.transformeb(100, 25, "/me.jpg"));
	public static JButton mf=new JButton( LoadImage.transformeb(100, 25, "/mf.jpg"));
	
	
	public static String sems1[]= {"Semestre1"};
	public static String sems2[]= {"Semestre2","Semestre3","Semestre4","Semestre5",
									"Semestre6","Semestre7","Semestre8","Semestre9","Semestre10"};
	
	public static String parcours[]= {"T.C.M","M.I.S.S","M.E","M.F"};
	public static String sems[];
	public static JTabbedPane panelPrincipale[];
	public static JPanel panBout=new JPanel();
	public static JPanel panTitre=new JPanel();
	public static JLabel titre=new JLabel("NOTES SESSION RATTRAPAGE DES ETUDIANTS T.C.M");
	
	public static Font font=new Font("arial",Font.BOLD,32);
	public static int nbrSems[]= {1,9,9,9};
	public static int debutSems[]= {0,1,1,1};
	
	public static JButton bout[]= {tcm,miss,me,mf};
	
	public static JScrollPane scrollPane;
	public static JSplitPane split ;
	public static JSplitPane split2 ;
		
	public static void ajouter() {
		
		panelPrincipale=new JTabbedPane[4];
		for(int i=0;i<panelPrincipale.length;i++) {
			if(i<1)
				sems=sems1;
			else 
				sems=sems2;
			
			panelPrincipale[i]=new PanelNote("MATHEMATIQUES ET APPLICATIONS", nbrSems[i], i, debutSems[i],"rattrapage",sems,
					parcours[i],"MATHEMATIQUES_ET_APPLICATIONS");
			panBout.add(bout[i]);
			bout[i].addActionListener(new Visible(scrollPane,panelPrincipale[i],i));
		}
		titre.setFont(font);
		panTitre.add(titre);
		scrollPane=new JScrollPane(panelPrincipale[0]);
		//panBout.setPreferredSize(new Dimension(100,490));
		split2=new  JSplitPane(JSplitPane.VERTICAL_SPLIT ,panTitre , scrollPane);
		split = new  JSplitPane(JSplitPane.VERTICAL_SPLIT  , split2,panBout );
		split2.setDividerLocation(50);
		split2.setDividerSize(1);
		split.setFocusable(false);
		split.setDividerLocation(600);
		split.setDividerSize(1);
		
		tcm.setPreferredSize(new Dimension(100,25));
		miss.setPreferredSize(new Dimension(100,25));
		me.setPreferredSize(new Dimension(100,25));
		mf.setPreferredSize(new Dimension(100,25));
	}
	
	public static class Visible implements ActionListener {
		JScrollPane pan;
		int i;
		JTabbedPane tab;
		Visible(JScrollPane pan,JTabbedPane tab,int i){
			this.pan=pan;
			this.tab=tab;
			this.i=i;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			//pan.remove(tab);
			pan=new JScrollPane(tab);
			titre.setText("NOTES SESSION RATTRAPAGES DES ETUDIANTS "+bout[i].getText());
			split2=new  JSplitPane(JSplitPane.VERTICAL_SPLIT , panTitre, pan);
			split = new  JSplitPane(JSplitPane.VERTICAL_SPLIT  , split2,panBout );
			split2.setDividerLocation(50);
			split2.setDividerSize(1);
			split.setFocusable(false);
			split.setDividerLocation(600);
			split.setDividerSize(1);
			tab.setVisible(true);
			Main.main.setContentPane(split);
			Main.main.setVisible(true);
			
		}
		
	}
	
}
