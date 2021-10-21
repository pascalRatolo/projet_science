package panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
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
import javax.swing.table.TableCellRenderer;

import data_base.DataBase;
import image.LoadImage;
import impression.FenetreImpressionReleveOrg;
import loading.Main;
import loading.Methode;
import login.LoginPrincipale;
import table.TableModel;
import zdialog.OuvrirNote;

@SuppressWarnings("serial")
public class FenetreRelever extends JFrame{
	 
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
	
	 DefaultTableModel modelEc[];
	 DefaultTableModel modelUe[];
	 DefaultTableModel modelNote[];
	 DefaultTableModel modelRecNote[];
	
	 JTable tableUe[];
	 JTable tableEc[];
	
	 JTextField num[];
	 JComboBox<String> numRelT[];
	 JComboBox<String> combo1[];
	 String combo2[]= {"Normal","Rattrapage"};
	 JLabel semsF[];
	 JLabel semsT[];
	 JButton creer[];
	 JButton val[];
	 JButton sup[];
	 JButton valUe[];
	 JButton fin[];
	 JButton sup1[];
	 JButton sup2[];
	 
	 JButton print[];
	
	
	 String titleEc[]= {"E.C","Poids","Note"};
	 String titleUe[]= {"U.E","Credit","Note"};
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
	 
	 JLabel nomF[];
	 JLabel numF[];
	 JLabel mentF[];
	 JLabel parcF[];
	 JLabel parcT[];
	 
	 JLabel numCarte[];
	 JLabel numRel[];
	 
	 JLabel neeF[];
	 JLabel lieuF[];
	 
	 JLabel annF[];
	 JLabel sesF[];
	 
	 JLabel prenomF[];
	 JLabel prenomT[];
	 
	 JLabel nomT[];
	 JLabel numT[];
	 JLabel mentT[];
	 
	 JLabel credF[];
	 JLabel moyenF[];
	 JLabel credT[];
	 JLabel moyenT[];
	 
	 JLabel neeT[];
	 JLabel lieuT[];
	 
	 JLabel annT[];
	 JLabel sesT[];
	 JLabel img[];
	 
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
	 JScrollPane scrol=new JScrollPane();
	 DefaultTableCellRenderer centerRenderer;
	 Font font=new Font("Aparajita",Font.HANGING_BASELINE,15);
	 public  Border line= new LineBorder(Color.black);
	 JLabel numRe;
		String anne=LoginPrincipale.anneField.getText();
	@SuppressWarnings("unchecked")
	public  FenetreRelever(JFrame parent, String title, boolean modal,String mention
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
		titre=new JLabel[nbrSems];
		titre1=new JLabel[nbrSems];
		titre2=new JLabel[nbrSems];
		titre3=new JLabel[nbrSems];
		titre4=new JLabel[nbrSems];
		semsF=new JLabel[nbrSems];
		semsT=new JLabel[nbrSems];
		
		creer=new JButton[nbrSems];
		val=new JButton[nbrSems];
		sup=new JButton[nbrSems];
		valUe=new JButton[nbrSems];
		fin=new JButton[nbrSems];
		sup1=new JButton[nbrSems];
		sup2=new JButton[nbrSems];
		combo1=new JComboBox[nbrSems];
		
		print=new JButton[nbrSems];
		
		tableUe=new JTable[nbrSems];
		tableEc=new JTable[nbrSems];
		
		num=new JTextField[nbrSems];
		numRelT=new JComboBox[nbrSems];
		panDelib=new JPanel[nbrSems];
		panPanDelib=new JPanel[nbrSems];
		panValidation=new JPanel[nbrSems];
		panInfDelib=new JPanel[nbrSems];
		panTete=new JPanel[nbrSems];
		img=new JLabel[nbrSems];
		nomF=new JLabel[nbrSems];
		prenomF=new JLabel[nbrSems];
		numF=new JLabel[nbrSems];
		mentF=new JLabel[nbrSems];
		parcF=new JLabel[nbrSems];
		parcT=new JLabel[nbrSems];
		
		numCarte=new JLabel[nbrSems];
		numRel=new JLabel[nbrSems];
		
		nomT=new JLabel[nbrSems];
		prenomT=new JLabel[nbrSems];
		numT=new JLabel[nbrSems];
		mentT=new JLabel[nbrSems];
		
		neeT=new JLabel[nbrSems];
		annT=new JLabel[nbrSems];
		lieuT=new JLabel[nbrSems];
		sesT=new JLabel[nbrSems];
		
		neeF=new JLabel[nbrSems];
		annF=new JLabel[nbrSems];
		lieuF=new JLabel[nbrSems];
		sesF=new JLabel[nbrSems];
		
		credF=new JLabel[nbrSems];
		credT=new JLabel[nbrSems];
		
		moyenF=new JLabel[nbrSems];
		moyenT=new JLabel[nbrSems];
		
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
			
			annF[i]=new JLabel("Année universitaire :");
			numF[i]=new JLabel("N°Carte :");
			nomF[i]=new JLabel("Nom:");
			prenomF[i]=new JLabel("Prénom:");
			neeF[i]=new JLabel("Né(e) le :");
			lieuF[i]=new JLabel(" à ");
			
			mentF[i]=new JLabel("Mention :");
			parcF[i]=new JLabel("Parcours :");

		    semsF[i]=new JLabel("Semestre :");
			sesF[i]=new JLabel("Session :");
			
			annT[i]=new JLabel();
			numT[i]=new JLabel();
			nomT[i]=new JLabel();
			prenomT[i]=new JLabel();
			neeT[i]=new JLabel();
			lieuT[i]=new JLabel();
			
			panSigne[i].setHorizontalAlignment(JLabel.RIGHT);
			//panDecis[i].setBorder(line);
			valUe[i]=new JButton (LoadImage.transformeb(100, 25, "/valide.jpg"));
			fin[i]=new JButton (LoadImage.transformeb(100, 25, "/terminer.jpg"));
			
			sup1[i]=new JButton (LoadImage.transformeb(100, 25, "/annul.jpg"));
			print[i]=new JButton (LoadImage.transformeb(100, 25, "/imprimer.jpg"));
			
			mentT[i]=new JLabel();
			parcT[i]=new JLabel();
			prenomT[i]=new JLabel();
			sesT[i]=new JLabel();
			semsT[i]=new JLabel();
			
			numCarte[i]=new JLabel("N°Carte:");
			numRel[i]=new JLabel("N°Rel:");
			
			nomF[i].setFont(font);
			nomT[i].setFont(font);
			prenomF[i].setFont(font);
			prenomT[i].setFont(font);
			neeF[i].setFont(font);
			neeT[i].setFont(font);
			semsF[i].setFont(font);
			semsT[i].setFont(font);
			sesF[i].setFont(font);
			sesT[i].setFont(font);
			parcF[i].setFont(font);
			parcT[i].setFont(font);
			mentT[i].setFont(font);
			mentF[i].setFont(font);
			numT[i].setFont(font);
			numF[i].setFont(font);
			lieuF[i].setFont(font);
			lieuT[i].setFont(font);
			panDecis[i].setFont(font);
			numRelT[i]=new JComboBox<String>(combo2);
			numRe=new JLabel();
			titre1[i]=new JLabel("<html> <div id='bloc_page'>"
			     	 + " <p STYLE='padding: 0 0 0 20px;'> <font size='4'><b>REPOBLIKAN'I&nbsp;MADAGASIKARA</b> "
			     	 + "</p> </font>"
	                 + "  <p STYLE='padding: 0 0 0 30px;'><i>"
	                 + " <font face= 'courier' size='-4'> <b> Fitiavana - Tanindrazana - Fandrosoana </b> "
	                 + "</font></i></p> "
	                 + "<p STYLE='padding: 0 0 0 0px;'><i> <font  size='3'> MINISTERE&nbsp;DE&nbsp;l'ENSEIGNEMENT&nbsp;SUPERIEUR"
	                 + "</font></i> </p>"
	                 + "<p STYLE='padding: 0 0 0 20px;'><i> <font  size='3'> ET&nbsp;DE&nbsp;LA&nbsp;RECHERCHE&nbsp;SCIENTIFIQUE"
	                 + "</font></i> </p>"
	                 + " </div></html>");
			titre2[i]=new JLabel("<html> <div id='bloc_page'>"
			     	 + " <p STYLE='padding: 0 0 0 100px;'> <font size='4'><b>UNIVERSITE&nbsp;DE&nbsp;FIANARANTSOA</b> "
			     	 + " </font> "
			     	 + " </p> "
	                 + "  <p STYLE='padding: 0 0 0 127px;'><i>"
	                 + " <font face= 'arial' size='3'> <b>FACULTE&nbsp;DES&nbsp;SCIENCES</b> </font></i></p>"
	                 + "</font>"
	                 + "  <p STYLE='padding: 0 0 0 145px;'><i>"
	                 + " <font face= 'arial' size='2'> <b>SERVICE&nbsp;SCOLARITE </b> </font></p>"
	                 + "</font>"
	                 + "  <p STYLE='padding: 0 0 0 125px;'><i>"
	                 + " <font face= 'arial' size='2'> <b>Année&nbsp;Universitaire :"+anne
	                 +"</b> </font></p>"
	                 + "</font>"
	                 + " </div></html>");
			
			titre3[i]=new JLabel("<html> <div id='bloc_page'>"
	                 + "  <p STYLE='padding: 0 0 0 28px;'><i>"
	                 + " <font  size='3'> <b>RELEVE&nbsp;DE&nbsp;NOTES</b> </font></i></p>"
	                 + "</font>"
	                 + "  <p STYLE='padding: 0 0 0 8px;'><i>"
	                 + " <font face= 'arial' size='3'> <b>N°&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
	                 + "&nbsp;&nbsp;&nbsp;&nbsp;/"+Main.date2textField.getText().substring(8, 12)+"/UF/FAC.S/S.SCO </b> </font></p>"
	                 + "</font>"
	                 + " </div></html>");
			titre4[i]=new JLabel("<html> <div id='bloc_page'>"
	                 + "  <p STYLE='padding: 0 0 0 5px;'><i>"
	                 + " <font  size='2'> <b><u><i>N.B:</i></u>&nbsp;Ce&nbsp;relevé&nbsp;de&nbsp;Notes&nbsp;ne&nbsp;doit&nbsp;être&nbsp;en&nbsp;"
	                 + "aucun&nbsp;cas&nbsp;remis&nbsp;</b> </font></i></p>"
	                 + "</font>"
	                 + "  <p STYLE='padding: 0 0 0 30px;'><i>"
	                 + " <font  size='2'> <b>à&nbsp;l'intéressé&nbsp;sous&nbsp;peine&nbsp;d'annulation.</b> </font></p>"
	                 + "</font>"
	                 + " </div></html>");
			nomF[i].setPreferredSize(new Dimension(60,12));
			nomT[i].setPreferredSize(new Dimension(420,12));
			
			prenomF[i].setPreferredSize(new Dimension(60,12));
			prenomT[i].setPreferredSize(new Dimension(420,12));
			
			neeF[i].setPreferredSize(new Dimension(60,12));
			neeT[i].setPreferredSize(new Dimension(95,12));
			
			lieuF[i].setPreferredSize(new Dimension(15,12));
			lieuT[i].setPreferredSize(new Dimension(300,12));
			
			semsF[i].setPreferredSize(new Dimension(70,12));
			semsT[i].setPreferredSize(new Dimension(410,12));
			
			sesF[i].setPreferredSize(new Dimension(60,12));
			sesT[i].setPreferredSize(new Dimension(420,12));
			
			numF[i].setPreferredSize(new Dimension(60,12));
			numT[i].setPreferredSize(new Dimension(420,12));
			
			mentF[i].setPreferredSize(new Dimension(60,12));
			mentT[i].setPreferredSize(new Dimension(420,12));
			
			parcF[i].setPreferredSize(new Dimension(60,12));
			parcT[i].setPreferredSize(new Dimension(420,12));
			
			valUe[i].setPreferredSize(new Dimension(80,20));
			sup1[i].setPreferredSize(new Dimension(100,20));
			fin[i].setPreferredSize(new Dimension(100,20));
			
			panInfDelib[i].setBorder(line);			
			panDelib[i].add(panInfDelib[i]);
			panInfDelib[i].add(nomF[i]);
			panInfDelib[i].add(nomT[i]);
			panInfDelib[i].add(prenomF[i]);
			panInfDelib[i].add(prenomT[i]);
			panInfDelib[i].add(neeF[i]);
			panInfDelib[i].add(neeT[i]);
			panInfDelib[i].add(lieuF[i]);
			panInfDelib[i].add(lieuT[i]);
			panInfDelib[i].add(numF[i]);
			panInfDelib[i].add(numT[i]);
			panInfDelib[i].add(mentF[i]);
			panInfDelib[i].add(mentT[i]);
			panInfDelib[i].add(parcF[i]);
			panInfDelib[i].add(parcT[i]);
			
			panInfDelib[i].add(semsF[i]);
			panInfDelib[i].add(semsT[i]);
			panInfDelib[i].add(sesF[i]);
			panInfDelib[i].add(sesT[i]);
			panDelib[i].add(panTete[i]);
			panDelib[i].add(titre3[i]);
			panDelib[i].add(panInfDelib[i]);
			modelDelib[i]=new TableModel(titreDelib);
			
			tableDelib[i]=new JTable(modelDelib[i]);
			tableDelib[i].setRowHeight(20);
			tableDelib[i].setShowGrid(false);
			tableDelib[i].setPreferredScrollableViewportSize(new Dimension(420,20));
			tableDelib[i].setDefaultRenderer(Object.class,new ColorCell(i));

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
			panDelib[i].add(titre4[i]);
			
			modelUe[i]=new Table(titleUe);
			modelEc[i]=new Table(titleEc);
			
			num[i]=new JTextField();
			
			
			val[i]=new JButton("valider");
			modelPanDelib[i]=new DefaultTableModel() {
				public boolean isCellEditable(int row, int col){
					return false;
				}
			};
			modelPanDelib[i].addColumn(titrePanDelib[0]);
			tablePanDelib[i]=new JTable(modelPanDelib[i]);
			tablePanDelib[i].setPreferredScrollableViewportSize(new Dimension(660,580));
			panPanDelib[i].add(new JScrollPane(tablePanDelib[i]));
			
			panPrincipale[i].setBackground(Color.cyan);
			panMatiere[i].setBackground(Color.cyan);
			panNote[i].setBackground(Color.cyan);
			
			panTete[i].setBackground(Color.white);
			panInfDelib[i].setBackground(Color.white);
			panRecNote[i].setBackground(Color.white);
			
			panNote[i].setLayout(new FlowLayout(FlowLayout.LEFT));
			panTete[i].setLayout(new FlowLayout(FlowLayout.LEFT));
			tableUe[i]=new JTable(modelUe[i]);
			tableEc[i]=new JTable(modelEc[i]);
			panMatiere[i].add(numCarte[i]);
			panMatiere[i].add(num[i]);
			//panMatiere[i].add(numRel[i]);
			panMatiere[i].add(numRelT[i]);
			panMatiere[i].add(val[i]);
			tableUe[i].setPreferredScrollableViewportSize(new Dimension(250,200));
			tableUe[i].getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
			tableUe[i].getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
			tableUe[i].setFillsViewportHeight(true);
			tableUe[i].getColumnModel().getColumn(0).setPreferredWidth(170);
			tableUe[i].getColumnModel().getColumn(1).setPreferredWidth(60);
			tableUe[i].getColumnModel().getColumn(2).setPreferredWidth(60);
			panMatiere[i].add(new JScrollPane(tableUe[i]));
			panMatiere[i].add(valUe[i]);
			panMatiere[i].add(sup1[i]);
			
			tableEc[i].setPreferredScrollableViewportSize(new Dimension(250,250));
			tableEc[i].getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
			tableEc[i].getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
			tableEc[i].setFillsViewportHeight(true);
			tableEc[i].getColumnModel().getColumn(0).setPreferredWidth(170);
			tableEc[i].getColumnModel().getColumn(1).setPreferredWidth(60);
			tableEc[i].getColumnModel().getColumn(2).setPreferredWidth(60);
			panMatiere[i].add(new JScrollPane(tableEc[i]));
			panMatiere[i].add(fin[i]);
			panTete[i].add(titre1[i]);
			panTete[i].add(titre2[i]);
			//panPrincipale[i].setPreferredSize(new Dimension(800,680));
			panMatiere[i].setPreferredSize(new Dimension(260,630));
			panDecis[i].setPreferredSize(new Dimension(530,20));
			panSigne[i].setPreferredSize(new Dimension(300,20));
			panNote[i].setPreferredSize(new Dimension(720,630));
			panRecNote[i].setPreferredSize(new Dimension(500,taille));
			panTableNote[i].setPreferredSize(new Dimension(710,520));
			panInfDelib[i].setPreferredSize(new Dimension(530,140));
			panTete[i].setPreferredSize(new Dimension(650,70));
			titre1[i].setPreferredSize(new Dimension(280,70));
			titre2[i].setPreferredSize(new Dimension(350,70));
			titre4[i].setPreferredSize(new Dimension(600,30));
			num[i].setPreferredSize(new Dimension(80,20));
			numRelT[i].setPreferredSize(new Dimension(100,20));
			print[i].setPreferredSize(new Dimension(100,22));
			val[i].setPreferredSize(new Dimension(80,25));
			
			
			tableUe[i].addMouseListener(new actue(i));
			tableEc[i].addMouseListener(new actec(i));
			val[i].addActionListener(new ajoutNote(i));
			valUe[i].addActionListener(new Valider(i));
			sup1[i].addActionListener(new Annuler(i));
			fin[i].addActionListener(new Terminer(i));
			print[i].addActionListener(new Imprimer(i));
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
		}JPanel paneau=new OuvrirNote(null, "", post,creer,sup,combo1,nbrSems).pane;
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
		//String hg[]= {"Semestre1"};
	//	new FenetreRelever(null,"", true, "MATHEMATIQUES ET APPLICATIONS", 0, "normal","T.C.M" , 1, 0, hg,"").setVisible(true);
	}
	
	
	public   class NouvTable implements ActionListener{
		int i;
		NouvTable(int i){
			this.i=i;
		}
		public void actionPerformed(ActionEvent e) {
			String l=(String) combo1[i].getSelectedItem();
			modelNote[i]=DataBase.crerTable(mention,(i+debutSems+1),semestre[i], l, k, panTableNote[i],panRecNote[i],type);
			DataBase.modifTable(mention,modelRecNote[i], semestre[i], l, k);
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
			modelPanDelib[i].setRowCount(0);
			modelDelib[i].setRowCount(0);
				if(DataBase.verificNum(mention,(i+debutSems+1),num[i].getText(), parcour)) {
					Main.main.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			DataBase.creerRelever(mention,(i+debutSems+1), k,type,num[i].getText(),modelUe[i],modelEc[i],
					nomT[i],prenomT[i],neeT[i],lieuT[i],parcT[i]);
			sesT[i].setText((String)numRelT[i].getSelectedItem());
			numT[i].setText("<html>"+num[i].getText()+"RI-"+anne.substring(7,9)+"</html>");
			tableDelib[i].setPreferredScrollableViewportSize(new Dimension(530,modelDelib[i].getRowCount()*30));
			panDelib[i].setPreferredSize(new Dimension(550,25*20+450));
			panDelib[i].setBackground(Color.white);
			modelPanDelib[i].addRow(new Object[] {panDelib[i]});
			tablePanDelib[i].setDefaultRenderer(Object.class, new Multirender(panDelib[i]));
			tablePanDelib[i].setRowHeight(25*20+450);
			mentT[i].setText("<html>"+Methode.finitTextLab(mention)+"</html>");
			semsT[i].setText("<html>"+Methode.finitTextLab((i+debutSems+1)+"")+"</html>");
			setVisible(true);
			Main.main.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			Toolkit.getDefaultToolkit().beep();
			
				
			}else {
				JOptionPane.showMessageDialog(panPrincipale[i], "numero carte n'est pas inscrit ", "ERREUR",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	public class Table extends DefaultTableModel{
		String title[];
		Table(String title[]){
			this.title=title;
			for(int i=0;i<title.length;i++)
				this.addColumn(title[i]);
		}
		public boolean isCellEditable(int row, int col){
			if(col==1)
				return true;
			else
				return false;
		}
	}
	
	public class Multirender implements TableCellRenderer{
		JPanel pan;
		public Multirender(JPanel pan) {
			this.pan=pan;
		}
		public Component getTableCellRendererComponent(JTable table, Object value,
				boolean isSelected, boolean hasFocus, int row, int column) { 
			return pan;
		}
	}
	
	public class ColorCell implements TableCellRenderer{
		int i;
		public ColorCell(int i) {
			this.i=i;
		}
		public Component getTableCellRendererComponent(JTable table, Object value,
				boolean isSelected, boolean hasFocus, int row, int column) { 
			JTextField lab=new JTextField();
			lab.setPreferredSize(new Dimension(280,30));
			lab.setBorder(line);
			String status=String.valueOf(tableDelib[i].getValueAt(row,0));
			String statu2=String.valueOf(tableDelib[i].getValueAt(row,1));
			String statu3=String.valueOf(tableDelib[i].getValueAt(row,4));
			lab.setText(String.valueOf(value));
			if(!status.equals("") ) {
				//lab.setBackground(new Color(218,218,218));
				lab.setForeground(Color.black);
				lab.setFont(new Font("arial",Font.TRUETYPE_FONT,10));
			}
			if( status.equals("MOYENNE GENERALE")) {
				lab.setHorizontalAlignment(JLabel.CENTER);
				lab.setFont(new Font("arial",Font.ITALIC,10));
			}
			if(!statu2.equals("") && column!=0 || statu2.equals("") ) {
				lab.setHorizontalAlignment(JLabel.CENTER);
				lab.setFont(new Font("arial",Font.TYPE1_FONT,10));
			}
			if(!statu3.equals("") ) {
				lab.setHorizontalAlignment(JLabel.CENTER);
				lab.setFont(new Font("algerian",Font.ITALIC,12));
			}
			if(status.equals("MOYENNE GENERALE") && (column==2 || column==3 || column==4) ) {
				lab.setBackground(Color.white);
				lab.setForeground(Color.black);
				lab.setBorder(null);
			}
			return lab;
		}
	}
	
	public  class actue implements MouseListener{
		int i;
		actue(int i){
			this.i=i;
		}
		@Override
		public void mouseClicked(MouseEvent e) {
		 if(tableUe[i].getRowCount()>0 && tableUe[i].getSelectedRow()!=-1) {
			 if(e.getClickCount()==2) {
				
				 int ligne=tableUe[i].getSelectedRow();
				 if(taille>20) {
				 taille-=20;
				 panRecNote[i].setVisible(false);
				 panRecNote[i].setPreferredSize(new Dimension(500,taille));
				 panRecNote[i].setVisible(true);
				
				 modelPanDelib[i].setRowCount(0);
				 modelDelib[i].addRow(new Object[] {"UE"+(ligne+1)+": "+Methode.finit((String)(tableUe[i].getValueAt(ligne, 0)),i),"","","",""});
				 tableDelib[i].setPreferredScrollableViewportSize(new Dimension(530,modelDelib[i].getRowCount()*20));
				 panDelib[i].setPreferredSize(new Dimension(550,25*20+450));
				panDelib[i].setBackground(Color.white);
				modelPanDelib[i].addRow(new Object[] {panDelib[i]});
				tablePanDelib[i].setDefaultRenderer(Object.class, new Multirender(panDelib[i]));
				tablePanDelib[i].setRowHeight(25*20+450);
				 setVisible(true);
				 j=0;
			 }
			 } 
		 }
	}
		@Override
		public void mouseEntered(MouseEvent arg0) {}
		@Override
		public void mouseExited(MouseEvent arg0) {}
		@Override
		public void mousePressed(MouseEvent arg0) {}
		@Override
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	public  class actec implements MouseListener{
		int i;
		actec(int i){
			this.i=i;
		}
		@Override
		public void mouseClicked(MouseEvent e) {
		 if(tableEc[i].getRowCount()>0 && tableEc[i].getSelectedRow()!=-1) {
			 if(e.getClickCount()==2) {
				 if(taille>20) {
					 taille-=20;
					 panRecNote[i].setVisible(false);
					 panRecNote[i].setPreferredSize(new Dimension(500,taille));
					 panRecNote[i].setVisible(true);
					
				 int ligne=tableEc[i].getSelectedRow();
				 modelPanDelib[i].setRowCount(0);
				 modelDelib[i].addRow(new Object[] {"EC"+(j+1)+": "+Methode.finit((String)(tableEc[i].getValueAt(ligne, 0)),i),
						 tableEc[i].getValueAt(ligne, 2), tableEc[i].getValueAt(ligne, 1),"",""});
				 tableDelib[i].setPreferredScrollableViewportSize(new Dimension(530,modelDelib[i].getRowCount()*20));
				 panDelib[i].setPreferredSize(new Dimension(550,25*20+450));
					panDelib[i].setBackground(Color.white);
					modelPanDelib[i].addRow(new Object[] {panDelib[i]});
					tablePanDelib[i].setDefaultRenderer(Object.class, new Multirender(panDelib[i]));
					tablePanDelib[i].setRowHeight(25*20+450);
				 setVisible(true);
				 j++;
			 }
			 }
		 }
	}
		@Override
		public void mouseEntered(MouseEvent arg0) {}
		@Override
		public void mouseExited(MouseEvent arg0) {}
		@Override
		public void mousePressed(MouseEvent arg0) {}
		@Override
		public void mouseReleased(MouseEvent arg0) {}
	
}
	
	public class Annuler implements ActionListener {
		int i;
		public Annuler(int i) {
			this.i=i;
		}
		
	public void actionPerformed(ActionEvent arg0) {
		if(modelDelib[i].getRowCount()>0){
			 if(taille<555) {
				 taille+=20;
				 panRecNote[i].setVisible(false);
				 panRecNote[i].setPreferredSize(new Dimension(500,taille));
				 panRecNote[i].setVisible(true);
				
		 modelPanDelib[i].setRowCount(0);
		 modelDelib[i].removeRow(modelDelib[i].getRowCount()-1);
		 tableDelib[i].setPreferredScrollableViewportSize(new Dimension(530,modelDelib[i].getRowCount()*20));
		 panDelib[i].setPreferredSize(new Dimension(550,25*20+450));
			panDelib[i].setBackground(Color.white);
			modelPanDelib[i].addRow(new Object[] {panDelib[i]});
			tablePanDelib[i].setDefaultRenderer(Object.class, new Multirender(panDelib[i]));
			tablePanDelib[i].setRowHeight(25*20+450);
		 setVisible(true);
			 }
	 }
	}
	}
	
	public class Valider implements ActionListener {
		int i;
		public Valider(int i) {
			this.i=i;
		}
		
	public void actionPerformed(ActionEvent arg0) {
		if(modelDelib[i].getRowCount()>0){
			 int ligne=tableUe[i].getSelectedRow();
			 if(taille>20) {
				 taille-=20;
				 panRecNote[i].setVisible(false);
				 panRecNote[i].setPreferredSize(new Dimension(500,taille));
				 panRecNote[i].setVisible(true);
				
		modelPanDelib[i].setRowCount(0);
		modelDelib[i].addRow(new Object[] {"NOTE SOUS TOTAL UE"+(ligne+1),
				 tableUe[i].getValueAt(ligne, 2),"", tableUe[i].getValueAt(ligne, 1),type(tableUe[i], ligne)});
		tableDelib[i].setPreferredScrollableViewportSize(new Dimension(530,modelDelib[i].getRowCount()*20));
		panDelib[i].setPreferredSize(new Dimension(550,25*20+450));
		panDelib[i].setBackground(Color.white);
		modelPanDelib[i].addRow(new Object[] {panDelib[i]});
		tablePanDelib[i].setDefaultRenderer(Object.class, new Multirender(panDelib[i]));
		tablePanDelib[i].setRowHeight(25*20+450);
		 
		 setVisible(true);
			 }
	 }
	}
	}
	
	public class Terminer implements ActionListener {
		int i;
		public Terminer(int i) {
			this.i=i;
		}
		
	public void actionPerformed(ActionEvent arg0) {
		if(modelDelib[i].getRowCount()>0){
			 if(taille>20) {
				 taille-=20;
				 panRecNote[i].setVisible(false);
				 panRecNote[i].setPreferredSize(new Dimension(500,taille));
				 panRecNote[i].setVisible(true);
				 
		 modelPanDelib[i].setRowCount(0);
		 modelDelib[i].addRow(new Object[] {"MOYENNE GENERALE",calculeMoyenne(tableUe[i]),"", "",""});
		 tableDelib[i].setPreferredScrollableViewportSize(new Dimension(530,modelDelib[i].getRowCount()*20));
		 panDelib[i].setPreferredSize(new Dimension(550,25*20+450));
			panDelib[i].setBackground(Color.white);
			modelPanDelib[i].addRow(new Object[] {panDelib[i]});
			tablePanDelib[i].setDefaultRenderer(Object.class, new Multirender(panDelib[i]));
			tablePanDelib[i].setRowHeight(25*20+450);
		 panDecis[i].setText(type1(tableUe[i]));
		 setVisible(true);
	     }
		}
	  }
	}
	
	public  class Imprimer implements ActionListener{
		int i;
		Imprimer(int i){
			this.i=i;
		}
		public void actionPerformed(ActionEvent arg0) {
			new FenetreImpressionReleveOrg(modelPanDelib[i],modelDelib[i],panDelib[i]).setVisible(true);
		}
	}
	
public double calculeMoyenne(JTable table) {
	double S=0;
	for(int h=0;h<table.getRowCount();h++) {
		try {
			S+=Double.parseDouble((String)table.getValueAt(h, 1))*Double.parseDouble((String)table.getValueAt(h, 2));
		}catch(Exception e) {
			JOptionPane.showMessageDialog(FenetreRelever.this,"invalide valeur du crédit", 
                    "Erreur",JOptionPane.INFORMATION_MESSAGE);
			break;
		}
	}
	S=(double) S/30;
	S=(double)Math.round(S*1000)/1000;
	return S;
}
public String type(JTable table,int ligne) {
	String S="";
	if(Double.parseDouble((String)table.getValueAt(ligne, 2))<10)
		S="Compensé";
	else
		S="validé";
	return S;
}

public String type1(JTable table) {
	String S="<html><p STYLE='padding: 0 0 0 50px;'><u>Décision&nbsp;du&nbsp;jury</u>:&nbsp;Etudiant(e)&nbsp;ayant&nbsp;validé(e)&nbsp;"
			+ "les&nbsp;30&nbsp;crédits"
			+ "&nbsp;définitive&nbsp;</p></html>";;
	for(int h=0;h<table.getRowCount();h++) {
		if(Double.parseDouble((String)table.getValueAt(h, 2))<10)
				S="<html><p STYLE='padding: 0 0 0 50px;'><u>Décision&nbsp;du&nbsp;jury</u>:&nbsp;Etudiant(e)&nbsp;ayant&nbsp;validé(e)&nbsp;"
						+ "les&nbsp;30&nbsp;crédits"
						+ "&nbsp;par&nbsp;compensation</html>";
	}
	return S;
}
	
}
	  
	





