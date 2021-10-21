package panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;

import data_base.DataBase;
import loading.Main;
import table.TableModel;
import zdialog.OuvrirNote;

@SuppressWarnings("serial")
public class FenetreNote extends JDialog{
	 
	 String username = "postgres";     
	 String password = "postgres";     
	 String url = "jdbc:postgresql://localhost:5432/";     
	 Connection connection = null;     
	 Statement statement = null;  
	 Connection connection2 = null;     
	 ResultSet rset = null; 
	
	 JTabbedPane pan=new JTabbedPane();
	 JPanel panPrincipale[];
	 JPanel panNote[];
	 JPanel panTableNote[];
	 JPanel panRecNote[];
	
	 JPanel panMatiere[];
	 JLabel titre[];
	
	 DefaultTableModel modelEc[];
	 DefaultTableModel modelUe[];
	 DefaultTableModel modelNote[];
	 DefaultTableModel modelRecNote[];
	
	
	 JButton creer[];
	 JButton val[];
	 JButton sup[];
	
	
	 String titleEc[]= {"E.C","Poids"};
	 String titleUe[]= {"U.E","Credit"};
	 String title[][];
	
	 String semestre[];
	 String mention;
	 String parcour;
	 String type;
	 String post;
	 int nbrSems, debutSems;
	 int k=0;
	 
	 JLayeredPane layeredPane = new JLayeredPane();
	@SuppressWarnings("rawtypes")
	 JComboBox combo[];
	
	 JScrollPane scrol=new JScrollPane();
	 Font font=new Font("arial",Font.BOLD,16);
	
	@SuppressWarnings("unchecked")
	public  FenetreNote(JFrame parent, String title, boolean modal,String mention
			,int k,String type,String parcour,int nbrSems,int debutSems,String semestre[],String  post){
		
		this.mention=mention;
		this.type=type;
		this.k=k;
		this.parcour=parcour;
		this.nbrSems=nbrSems;
		this.debutSems=debutSems;
		this.semestre=semestre;
		this.post=post;
		
		this.setTitle( title );
		this.setResizable(false);
		this.setSize(1000,700);
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(parent);
	
		
	
		panPrincipale=new JPanel[nbrSems];
		panMatiere=new JPanel[nbrSems];
		panNote=new JPanel[nbrSems];
		panRecNote=new JPanel[nbrSems];
		panTableNote=new JPanel[nbrSems];
		modelEc= new DefaultTableModel[nbrSems];
		modelUe= new DefaultTableModel[nbrSems];
		modelNote= new DefaultTableModel[nbrSems];
		modelRecNote= new DefaultTableModel[nbrSems];
		titre=new JLabel[nbrSems];
		
		creer=new JButton[nbrSems];
		val=new JButton[nbrSems];
		sup=new JButton[nbrSems];
		combo=new JComboBox[nbrSems];
		
		for(int i=0;i<nbrSems;i++) {
			panPrincipale[i]=new JPanel();
			panMatiere[i]=new JPanel();
			panNote[i]=new JPanel();
			panRecNote[i]=new JPanel();
			panTableNote[i]=new JPanel();
			titre[i]=new JLabel("NOTE SESSION "+type.toUpperCase()+" S"+(i+debutSems+1)+" "+parcour);
			titre[i].setFont(font);
			panNote[i].add(titre[i]);
			
			modelUe[i]=new TableModel(titleUe,panMatiere[i],230,200);
			modelEc[i]=new TableModel(titleEc,panMatiere[i],230,200);
			//modelNote[i]=new TableModel(titleEc,panTableNote[i]);
			
			creer[i]=new JButton("Créer table note");
			val[i]=new JButton("Ajouter");
			sup[i]=new JButton("Supprimer la table ");
			
			panPrincipale[i].setBackground(Color.cyan);
			panMatiere[i].setBackground(Color.cyan);
			panNote[i].setBackground(Color.cyan);
			
			panRecNote[i].setLayout(new FlowLayout(FlowLayout.LEFT));
			
			combo[i]= DataBase.recuperUe(mention,semestre[i],k);
			modelNote[i]=DataBase.crerTable(mention,(i+debutSems+1),semestre[i], (String)combo[i].getSelectedItem(), 
					k, panTableNote[i],panRecNote[i],type);
			combo[i].addActionListener(new NouvTable(i));
			modelRecNote[i]=DataBase.crerTable(mention,semestre[i], (String)combo[i].getSelectedItem(), k, panRecNote[i]);
			
			
			//panPrincipale[i].setPreferredSize(new Dimension(800,680));
			panMatiere[i].setPreferredSize(new Dimension(250,630));
			panNote[i].setPreferredSize(new Dimension(720,630));
			panTableNote[i].setPreferredSize(new Dimension(710,520));
			panRecNote[i].setPreferredSize(new Dimension(710,60));
			
			val[i].addActionListener(new ajoutNote(i));
			creer[i].addActionListener(new creerTable(i));
			sup[i].addActionListener(new Supprime(i,k));
			creer[i].setEnabled(false);
			sup[i].setEnabled(false);
			combo[i].setEnabled(false);
			 String databaMatiere="";
			 String parc[]= {};
			 switch(mention) {
			 case "MATHEMATIQUES ET APPLICATIONS":
				 databaMatiere=DataBase.databaseMatiereMaths;
				 parc=DataBase.parcMaths;
				 break;
			 }
			DataBase.mess.setText("Importation de la table de saisie note s"+(i+debutSems+1)+"_"+parc[k]+"_"+type+"");
			try {
				String url = "jdbc:postgresql://"+DataBase.port+":5432/"+databaMatiere;
	        	connection = DriverManager.getConnection(url, username, password);      
	        	statement = connection.createStatement(); 
	        	rset = statement.executeQuery(" SELECT * FROM uni_enseign_"+parc[k]+" WHERE semestre='"+semestre[i]+"'ORDER BY nom_ue");
	        	while(rset.next()) {
	        		modelUe[i].addRow(new Object[] {rset.getString(1),rset.getString(2)});
	        		}
	        	rset.close();
	        	statement.close();
	        	connection.close();
	        	}catch(Exception e) {
	        		System.out.println(e.getMessage());
	        	}
			
			try {
				String url = "jdbc:postgresql://"+DataBase.port+":5432/"+databaMatiere;
	        	connection = DriverManager.getConnection(url, username, password);      
	        	statement = connection.createStatement(); 
	        	rset = statement.executeQuery(" SELECT * FROM el_cons_"+parc[k]+" WHERE semestre='"+semestre[i]+"'ORDER BY nom_ue");
	        	while(rset.next()) {
	        		modelEc[i].addRow(new Object[] {rset.getString(1),rset.getString("poids")});
	        		}
	        	rset.close();
	        	statement.close();
	        	connection.close();
	        	}catch(Exception e) {
	        		System.out.println(e.getMessage());
	        	}
			
		}
		
		for(int i=0;i<nbrSems;i++) {
			panMatiere[i].add(creer[i]);
			panMatiere[i].add(sup[i]);
			panNote[i].add(combo[i]);
			panNote[i].add(panTableNote[i]);
			panNote[i].add(panRecNote[i]);
			panPrincipale[i].add(panMatiere[i]);
			panPrincipale[i].add(panNote[i]);
			if(type=="normal") {
				creer[i].setVisible(true);
				sup[i].setVisible(true);
			}else {
				creer[i].setVisible(false);
				sup[i].setVisible(false);
			}
		}
		
		
		int i = debutSems;
		for(JPanel paneau : panPrincipale){
		pan.add("Semestre "+(++i), paneau);
		}JPanel paneau=new OuvrirNote(this, "", post,creer,sup,combo,nbrSems).pane;
		paneau.setBounds(2, 2,990,668);
		pan.setBounds(0, 0, 1000, 700);
		paneau.setBackground(new Color(249,0,0,80));
		
		layeredPane.add(pan,new Integer(0), 0);
		layeredPane.add(paneau,new Integer(1), 0);
		this.addWindowListener(new WindowAdapter() {
  			public void windowClosing(WindowEvent e){
  				int option = JOptionPane.showConfirmDialog(null,"Voulez-vous Terminer ?","ATTENTION!",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
					if(option == JOptionPane.OK_OPTION){
						dispose();
						}
  				}
  			});
		this.getContentPane().add(layeredPane, BorderLayout.CENTER);
		this.setVisible(false);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	
	public   class NouvTable implements ActionListener{
		int i;
		NouvTable(int i){
			this.i=i;
		}
		public void actionPerformed(ActionEvent e) {
			String l=(String) combo[i].getSelectedItem();
			modelNote[i]=DataBase.crerTable(mention,(i+debutSems+1),semestre[i], l, k, panTableNote[i],panRecNote[i],type);
			DataBase.modifTable(mention,modelRecNote[i], semestre[i], l, k);
			panRecNote[i].add(val[i]);
			//val[i].setVisible(false);
			setVisible(true);
			}
		}
	
	
	public  class ajoutNote implements ActionListener{
		int i;
		ajoutNote(int i){
			this.i=i;
		}
		public void actionPerformed(ActionEvent arg0) {
			boolean ok=true;
			for(int t=0;t<modelRecNote[i].getColumnCount();t++) {
				if(String.valueOf(modelRecNote[i].getValueAt(0,t)).equals("null"))
					ok=false;
			}
			if(ok) {
				if(DataBase.verificNum(mention,(i+debutSems+1),(String)modelRecNote[i].getValueAt(0,1)
						, parcour)) {
			Main.main.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			String l=(String) combo[i].getSelectedItem();
			if(type.equals("normal"))
				DataBase.ajoutNoteNorm(mention,modelRecNote[i],(i+debutSems+1), k, semestre[i],l,panNote[i]);
			if(type.equals("rattrapage")) {
				DataBase.ajoutNoteRat(mention,modelRecNote[i],(i+debutSems+1), k, semestre[i],l,panNote[i]);
				DataBase.ajoutNoteFinal(mention,modelRecNote[i],(i+debutSems+1), k, semestre[i],l);
			}
			modelNote[i]=DataBase.crerTable(mention,(i+debutSems+1),semestre[i], l, k, panTableNote[i],panRecNote[i],type);
			DataBase.modifTable(mention,modelRecNote[i], semestre[i], l, k);
			setVisible(true);
			Main.main.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			Toolkit.getDefaultToolkit().beep();
			
				}
			}else {
				JOptionPane.showMessageDialog(panPrincipale[i], "Invalide valeur du Tableau ", "ERREUR",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	public  class creerTable implements ActionListener{
		int i;
		creerTable(int i){
			this.i=i;
		}
		public void actionPerformed(ActionEvent arg0) {
			Main.main.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			DataBase.creation_table_note(panPrincipale[i],mention,(i+debutSems+1), semestre[i], k);
			Main.main.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		}
	
	public  class Supprime implements ActionListener{
		int i;
		int k;
		Supprime(int i,int k){
			this.i=i;
			this.k=k;
		}
		public void actionPerformed(ActionEvent arg0) {
			Main.main.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			DataBase.supprimerTable(panPrincipale[i],mention,(i+debutSems+1),k);
			Main.main.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		}
	
	}





