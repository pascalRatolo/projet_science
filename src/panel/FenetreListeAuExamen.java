package panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import data_base.DataBase;
import image.ImageBonneQualite;
import image.LoadImage;
import impression.FenetreImpressionListeAuExamen;
import impression.FenetreImpressionPresenceAuExam;
import loading.Main;
import loading.Methode;
import login.LoginPrincipale;
import table.TableModel;
import zdialog.OuvrirNote;

@SuppressWarnings("serial")
public class FenetreListeAuExamen extends JFrame{
	 
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
	 JLabel panDecis[];
	 JLabel panSigne[];
	 
	 JLabel titre[];
	 JLabel num[];
	 JLabel a[];
	
	 DefaultTableModel modelEc[];
	 DefaultTableModel modelUe[];
	 DefaultTableModel modelNote[];
	 DefaultTableModel modelRecNote[];
	
	 JTable tableUe[];
	
	 JTextField num1[];
	 JTextField num2[];
	 String combo2[]= {"Normal","Rattrapage"};
	 JLabel semsF[];
	 JLabel semsT[];
	 JButton valUe[];
	 JButton sup1[];
	 
	 JButton print[];
	
	
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
	 int j=0;
	 int taille=576;
	 String titreDelib[]= {"LES UNITES D'ENSEIGNEMENTS","Notes (/20) ","Coefficient","Crédits","Statue de l'UE"};
	 String titrePanDelib[]= {""};
	 JPanel panDelib[];
	 JPanel panInfDelib[];
	 JPanel panTete[];
	 JPanel panPanDelib[];
	 
	 JPanel panValidation[];
	 
	
	 
	 JTable tableDelib[];
	 JTable tablePanDelib[];
	 DefaultTableModel modelDelib[];
	 DefaultTableModel modelPanDelib[];
	 
	 JLayeredPane layeredPane = new JLayeredPane();
	@SuppressWarnings("rawtypes")
	 JComboBox combo[];
	 JLabel titre1[];
	 JLabel titre2[];
	 JLabel titre3[];
	 JLabel titre4[];

	 JLabel logo1[];
	 JLabel logo2[];
	 
	 JLabel ment[];
	 JScrollPane scrol=new JScrollPane();
	 DefaultTableCellRenderer centerRenderer;
	 Font font=new Font("Aparajita",Font.HANGING_BASELINE,15);
	 public  Border line= new LineBorder(Color.black);
	 JLabel numRe;
	String anne=LoginPrincipale.anneField.getText();
	public  FenetreListeAuExamen(JFrame parent, String title, boolean modal,String mention
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
		//this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(parent);
	
		
	
		panPrincipale=new JPanel[nbrSems];
		panMatiere=new JPanel[nbrSems];
		panDecis=new JLabel[nbrSems];
		panSigne=new JLabel[nbrSems];
		panNote=new JPanel[nbrSems];
		panRecNote=new JPanel[nbrSems];
		panTableNote=new JPanel[nbrSems];
		modelEc= new DefaultTableModel[nbrSems];
		modelUe= new DefaultTableModel[nbrSems];
		modelNote= new DefaultTableModel[nbrSems];
		modelRecNote= new DefaultTableModel[nbrSems];
		num=new JLabel[nbrSems];
		a=new JLabel[nbrSems];
		titre1=new JLabel[nbrSems];
		titre2=new JLabel[nbrSems];
		titre3=new JLabel[nbrSems];
		titre4=new JLabel[nbrSems];
		logo1=new JLabel[nbrSems];
		logo2=new JLabel[nbrSems];
		ment=new JLabel[nbrSems];
		valUe=new JButton[nbrSems];
		sup1=new JButton[nbrSems];
		
		print=new JButton[nbrSems];
		
		tableUe=new JTable[nbrSems];
		num1=new JTextField[nbrSems];
		num2=new JTextField[nbrSems];
		panDelib=new JPanel[nbrSems];
		panPanDelib=new JPanel[nbrSems];
		panValidation=new JPanel[nbrSems];
		panInfDelib=new JPanel[nbrSems];
		panTete=new JPanel[nbrSems];
		tableDelib=new JTable[nbrSems];
		tablePanDelib=new JTable[nbrSems];
		modelDelib=new DefaultTableModel[nbrSems];
		modelPanDelib=new DefaultTableModel[nbrSems];
		
		
		 centerRenderer= new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		
		
		
		for(int i=0;i<nbrSems;i++) {
			panPrincipale[i]=new JPanel();
			panMatiere[i]=new JPanel();
			panDecis[i]=new JLabel();
			panSigne[i]=new JLabel("Fianarantsoa, le ");
			panNote[i]=new JPanel();
			panRecNote[i]=new JPanel();
			panTableNote[i]=new JPanel();
			
			panDelib[i]=new JPanel();
			panInfDelib[i]=new JPanel();
			panTete[i]=new JPanel();
			panPanDelib[i]=new JPanel();
			num[i]=new JLabel("Numéro :");
			a[i]=new JLabel("à :");
			
			panSigne[i].setHorizontalAlignment(JLabel.RIGHT);
			//panDecis[i].setBorder(line);
			valUe[i]=new JButton (LoadImage.transformeb(100, 25, "/imprimer.jpg"));
			
			sup1[i]=new JButton (LoadImage.transformeb(100, 25, "/valide.jpg"));
			print[i]=new JButton (LoadImage.transformeb(100, 25, "/imprimer.jpg"));
			
			sup1[i].setEnabled(false);
			valUe[i].setEnabled(false);
			panDecis[i].setFont(font);
			numRe=new JLabel();
			logo1[i]=new JLabel();
			logo2[i]=new JLabel();
			logo1[i].setPreferredSize(new Dimension(90,90));
	       	logo2[i].setPreferredSize(new Dimension(90,90));
			logo1[i].setIcon(ImageBonneQualite.image("C:/Program Files (x86)/JDev/DataSciences/image/logoUniv.png",70));
	     	logo2[i].setIcon(ImageBonneQualite.image("C:/Program Files (x86)/JDev/DataSciences/image/logoFac.png",80));
	         titre1[i]=new JLabel("<html> <div id='bloc_page'>"
				     	 + " <p STYLE='padding: 0 0 0 0px;'> <font size='6'><b>UNIVERSITE&nbsp;DE&nbsp;FIANARANTSOA</b> "
				     	 + " </font> "
				     	 + " </p> "
		                 + "  <p STYLE='padding: 0 0 0 70px;'><i>"
		                 + " <font face= 'arial' size='5'> <b>FACULTE&nbsp;DES&nbsp;SCIENCES</b> </font></i></p>"
		                 + "</font>"
		                 + "  <p STYLE='padding: 0 0 0 40px;'><i>"
		                 + " <font face= 'arial' size='5'> <b> ANNEE&nbsp;UNIVERSITAIRE "+LoginPrincipale.anneField.getText()+" </b> </font></i></p>"
		                 + "</font>"
		                 + " </div></html>");
	     		
	     	titre1[i].setPreferredSize(new Dimension(400,100));
	     		
	     	 ment[i]=new JLabel("<html> <div id='bloc_page'><u>MENTION</u>&nbsp;:&nbsp;"+mention+"&nbsp;</div></html>");
	     		// titre1.setBorder(line);
	     		ment[i].setPreferredSize(new Dimension(290,15));
	     	
	     		panInfDelib[i].add(logo1[i]);
	     		panInfDelib[i].add(titre1[i]);
	     		panInfDelib[i].add(logo2[i]);
	     		panInfDelib[i].add(ment[i]);
	     		
	     		
			panDelib[i].add(panInfDelib[i]);
			modelDelib[i]=new TableModel(titreDelib);
			
			tableDelib[i]=new JTable(modelDelib[i]);
			tableDelib[i].setRowHeight(20);
			tableDelib[i].setShowGrid(false);
			tableDelib[i].setPreferredScrollableViewportSize(new Dimension(420,20));

			tableDelib[i].setShowGrid(false);
			tableDelib[i].setIntercellSpacing(new Dimension(2,2));
			tableDelib[i].getTableHeader().setVisible(true);
			tableDelib[i].setFillsViewportHeight(true);
			tableDelib[i].getColumnModel().getColumn(0).setPreferredWidth(220);
			tableDelib[i].getColumnModel().getColumn(1).setPreferredWidth(60);
			tableDelib[i].getColumnModel().getColumn(2).setPreferredWidth(60);
			tableDelib[i].getColumnModel().getColumn(3).setPreferredWidth(60);
			tableDelib[i].getColumnModel().getColumn(4).setPreferredWidth(90);
			panDelib[i].add(new JScrollPane(tableDelib[i]));
			panDelib[i].add(panDecis[i]);
			panDelib[i].add(panSigne[i]);
			panDelib[i].add(panRecNote[i]);
			
			modelUe[i]=new Table(titleUe);
			modelEc[i]=new Table(titleEc);
			
			num1[i]=new JTextField();
			num2[i]=new JTextField();
			
			
			modelPanDelib[i]=new DefaultTableModel() ;
		//	modelPanDelib[i].addColumn(titrePanDelib[0]);
			//tablePanDelib[i]=new JTable(modelPanDelib[i]);
			//tablePanDelib[i].setPreferredScrollableViewportSize(new Dimension(700,580));
			//panPanDelib[i].add(new JScrollPane(tablePanDelib[i]));
			
			panPrincipale[i].setBackground(Color.cyan);
			panMatiere[i].setBackground(Color.cyan);
			panNote[i].setBackground(Color.cyan);
			
			panTete[i].setBackground(Color.white);
			panInfDelib[i].setBackground(Color.white);
			panRecNote[i].setBackground(Color.white);
			
			panNote[i].setLayout(new FlowLayout(FlowLayout.LEFT));
			panInfDelib[i].setLayout(new FlowLayout(FlowLayout.LEFT));
			tableUe[i]=new JTable(modelUe[i]);
			panMatiere[i].add(num[i]);
			panMatiere[i].add(num1[i]);
			panMatiere[i].add(a[i]);
			panMatiere[i].add(num2[i]);
			tableUe[i].setPreferredScrollableViewportSize(new Dimension(250,200));
			tableUe[i].getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
			tableUe[i].setFillsViewportHeight(true);
			tableUe[i].getColumnModel().getColumn(0).setPreferredWidth(170);
			tableUe[i].getColumnModel().getColumn(1).setPreferredWidth(60);
			panMatiere[i].add(new JScrollPane(tableUe[i]));
			panMatiere[i].add(valUe[i]);
			panMatiere[i].add(sup1[i]);
			//panPrincipale[i].setPreferredSize(new Dimension(800,680));
			panMatiere[i].setPreferredSize(new Dimension(260,630));
			panDecis[i].setPreferredSize(new Dimension(530,20));
			panSigne[i].setPreferredSize(new Dimension(300,20));
			panNote[i].setPreferredSize(new Dimension(720,630));
			panRecNote[i].setPreferredSize(new Dimension(500,taille));
			panTableNote[i].setPreferredSize(new Dimension(710,520));
			panInfDelib[i].setPreferredSize(new Dimension(600,140));
			panTete[i].setPreferredSize(new Dimension(650,70));
			num1[i].setPreferredSize(new Dimension(40,20));
			num2[i].setPreferredSize(new Dimension(40,20));
			print[i].setPreferredSize(new Dimension(100,25));
			valUe[i].setPreferredSize(new Dimension(100,25));
			sup1[i].setPreferredSize(new Dimension(100,25));
			panPanDelib[i].setPreferredSize(new Dimension(720,580));
			print[i].setEnabled(false);
			
			sup1[i].addActionListener(new Annuler(i));
			print[i].addActionListener(new Imprimer(i));
			valUe[i].addActionListener(new Imprimer1(i));
			tableUe[i].addMouseListener(new Voir(i));
			/*
			tableDelib[i].setPreferredScrollableViewportSize(new Dimension(530,modelDelib[i].getRowCount()*30));
			panDelib[i].setPreferredSize(new Dimension(550,25*20+450));
			panDelib[i].setBackground(Color.white);
			modelPanDelib[i].addRow(new Object[] {panDelib[i]});
			tablePanDelib[i].setDefaultRenderer(Object.class, new Multirender(panDelib[i]));
			tablePanDelib[i].setRowHeight(25*20+450);*/
			
			
			 String databaMatiere="";
			 String parc[]= {};
			 switch(mention) {
			 case "MATHEMATIQUES ET APPLICATIONS":
				 databaMatiere=DataBase.databaseMatiereMaths;
				 parc=DataBase.parcMaths;
				 break;
			 }
			DataBase.mess.setText("Importation de la Fenetre Resultat s"+(i+debutSems+1)+"_"+parc[k]+"_"+type+"");
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
			
		}
		
		for(int i=0;i<nbrSems;i++) {
			panNote[i].add(panPanDelib[i]);
			panPrincipale[i].add(panMatiere[i]);
			panPrincipale[i].add(panNote[i]);
			panNote[i].add(print[i]);
		}
			
		
		int i = debutSems;
		for(JPanel paneau : panPrincipale){
		pan.add("Semestre "+(++i), paneau);
		}JPanel paneau=new OuvrirNote(null, "", post,null,null,null,nbrSems).pane;
		paneau.setBounds(2, 2,990,668);
		pan.setBounds(0, 0, 1000, 700);
		paneau.setBackground(new Color(249,0,0,80));
		
		layeredPane.add(pan,new Integer(0), 0);
		//layeredPane.add(paneau,new Integer(1), 0);
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
	//	String hg[]= {"Semestre1"};
	//	new FenetreRelever(null,"", true, "MATHEMATIQUES ET APPLICATIONS", 0, "rattrapage","T.C.M" , 1, 0, hg,"").setVisible(true);
	}
	
	
	
	public class Table extends DefaultTableModel{
		String title[];
		Table(String title[]){
			this.title=title;
			for(int i=0;i<title.length;i++)
				this.addColumn(title[i]);
		}
		public boolean isCellEditable(int row, int col){
				return false;
		}
	}
	public class Voir implements MouseListener{
		int i;
		public Voir(int i) {
			this.i=i;
		}
		public void mouseClicked(MouseEvent e) {
			 if(tableUe[i].getRowCount()>0 && tableUe[i].getSelectedRow()!=-1) {
				 if(e.getClickCount()>=1) {
					 valUe[i].setEnabled(true);
					 sup1[i].setEnabled(true);
					 print[i].setEnabled(true);
				 }
			 }
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
		
	}
	
	
	public class Annuler implements ActionListener {
		int i;
		public Annuler(int i) {
			this.i=i;
		}
		
	public void actionPerformed(ActionEvent arg0) {
		int x=0;
		int y=0;
		try {
		x=Integer.parseInt(num1[i].getText())-1;
		y=Integer.parseInt(num2[i].getText());
		}catch(Exception e){
			JOptionPane.showMessageDialog(Main.main, "Entrer la valeur entier ", 
					 "ERREUR",JOptionPane.ERROR_MESSAGE);
		}
		
		int ligne=tableUe[i].getSelectedRow();
		modelPanDelib[i]=DataBase.liste(mention, semestre[i], i+debutSems+1, k, modelPanDelib[i], 
				String.valueOf(tableUe[i].getValueAt(ligne, 0)), panPanDelib[i],x,y);
	  }
	}
	
	public  class Imprimer implements ActionListener{
		int i;
		Imprimer(int i){
			this.i=i;
		}
		public void actionPerformed(ActionEvent arg0) {
			int x=0;
			int y=0;
			try {
				x=Integer.parseInt(num1[i].getText());
				y=Integer.parseInt(num2[i].getText());
				}catch(Exception e){
					JOptionPane.showMessageDialog(Main.main, "Entrer une valeur entier ", 
							 "ERREUR",JOptionPane.ERROR_MESSAGE);
				}
			new FenetreImpressionPresenceAuExam(modelPanDelib[i],mention,parcour,type,semestre[i],(i+1+debutSems),
					Methode.getNom(tableUe[i]),modelPanDelib[i].getColumnCount(),x,y).setVisible(true);
		}
	}
	
	public  class Imprimer1 implements ActionListener{
		int i;
		Imprimer1(int i){
			this.i=i;
		}
		public void actionPerformed(ActionEvent arg0) {
			int x=0;
			int y=0;
			try {
				x=Integer.parseInt(num1[i].getText());
				y=Integer.parseInt(num2[i].getText());
				}catch(Exception e){
					JOptionPane.showMessageDialog(Main.main, "Entrer une valeur entier ", 
							 "ERREUR",JOptionPane.ERROR_MESSAGE);
				}
			new FenetreImpressionListeAuExamen(modelPanDelib[i],mention,parcour,type,semestre[i],(i+1+debutSems),
					Methode.getNom(tableUe[i]),5,x,y).setVisible(true);
		}
	}
	


	
}
	  
	





