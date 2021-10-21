package resultat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JCheckBox;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import data_base.DataBase;
import image.LoadImage;
import impression.FenetreImpressionReleve;
import impression.FenetreImpressionResultatFinale;
import impression.FenetreImpressionResultatLicence;
import impression.FenetreImpressionResultatUe;
import impression.FenetreImpressionResultatUeGlobal;
import loading.Methode;
import table.TableModel;

@SuppressWarnings("serial")
public class FenetreResultat extends JFrame{
	 
	 String username = "postgres";     
	 String password = "postgres";     
	 String url = "jdbc:postgresql://localhost:5432/";     
	 Connection connection3 = null;     
	 Statement statement3 = null;      
	 ResultSet rset3 = null; 
	
	 JTabbedPane pan=new JTabbedPane();
	 JPanel panPrincipale[];
	 JPanel panNote[];
	 JPanel ligne[];
	 JPanel panTableListOK[];
	 JPanel panTableListNoOK[];
	 JPanel panRecNote[];
	 JPanel panParUe[];
	
	 JPanel panValidNorm[];
	 JPanel panValidRat[];
	 JPanel panValidComp[];
	 
	 JPanel panMatiere[];
	 JLabel titre[];
	 
	 JLabel numCarte[];
	 
	 JLabel sems[];
	 JLabel resul[];
	 JCheckBox semsBox[];
	 JCheckBox semsValidation[];
	 
	 JLabel result1[];
	 JLabel result2[];
	 
	 JLabel result3[];
	 JLabel result4[];
	 JLabel result5[];
	 
	 JButton printNorm[];
	 JButton printRat[];
	 JButton printComp[];
	 
	 JButton printResultGlob[];
	 
	 JButton resultGlob[];
	 
	 JLabel resultCrdt[];
	 JLabel resultMoyen[];
	 
	 JPanel panresultCrdt[];
	 JPanel panresultMoyen[];
	 
	 JPanel ligne1[];
	 JPanel ligne2[];
	 JPanel ligne3[];
	
	 DefaultTableModel modelEc[];
	 DefaultTableModel modelUe[];
	 DefaultTableModel modelList1[];
	 DefaultTableModel modelList2[];
	 
	 DefaultTableModel modelCred[];
	 DefaultTableModel modelMoyen[];
	 
	 DefaultTableModel modelValidation[];
	 DefaultTableModel modelLicence;
	 DefaultTableModel modelMaster;
	 DefaultTableModel modelListLicence;
	 DefaultTableModel modelListMaster;
	 
	 JButton lic=new JButton("LICENCE");
	 JButton mas=new JButton("MASTER");
	 
	 JLabel resultLic=new JLabel();
	 JLabel resultMas=new JLabel();
	 JLabel resultListLic=new JLabel();
	 JLabel resultListMas=new JLabel();
	 JButton validLic=new JButton (LoadImage.transformeb(100, 25, "/valide.jpg"));
	 JButton validMas=new JButton (LoadImage.transformeb(100, 25, "/valide.jpg"));
	 JButton actLic=new JButton (LoadImage.transformeb(100, 25, "/actualiser.jpg"));
	 JButton actMas=new JButton (LoadImage.transformeb(100, 25, "/actualiser.jpg"));
	 JButton printLic=new JButton (LoadImage.transformeb(100, 25, "/imprimer.jpg"));
	 JButton printMas=new JButton (LoadImage.transformeb(100, 25, "/imprimer.jpg"));
	
	 JButton valUeEc[];
	 JButton NovalUeEc[];
	 JButton valide[];
	 
	 JButton print[];
	 JButton printUe[];
	 
	 JButton infCred[];
	 JButton supCred[];
	 JButton egalCred[];
	 
	 JButton infMoy[];
	 JButton supMoy[];
	 JButton egalMoy[];
	 
	 JButton infMoyCred[];
	 JButton supMoyCred[];
	 JButton egalMoyCred[];
	 
	 JButton validation[];
	 
	 JButton validFinal[];
	 
	 JButton snValid[];
	 JButton srValid[];
	 JButton srComp[];
	 
	 JButton releve[];
	
	 String titleEc[]= {"E.C","Poids"};
	 String titleUe[]= {"U.E","Credit"};
	 String titreList[]= {"N°carte","Nom et prénom","Note"};
	 String titreCred[]= {"N°carte","Nom et prénom","Crédit"};
	 String titreMoyen[]= {"N°carte","Nom et prénom","Moyenne"};
	 String titleSems[]= {"Numéro","Nom et prénom","Crédit","Moyenne","validation"};
	 String diplome[]= {"Numéro","Nom et prénom","validation"};
	 String titleValid[]= {"Numéro","Nom et prénom"};
	
	 String semestre[];
	 String mention;
	 String parcour;
	 String type;
	 String post;
	 int nbrSems, debutSems;
	 int k=0;
	 JTable table1[];
	 JTable table2[];
	 
	 JTable tableCred[];
	 JTable tableMoyen[];
	 
	 JTable tableEc[];
	 JTable tableUe[];
	 JTable tableValidation[];
	 JTable tableLicence;
	 JTable tableListLicence;
	 JTable tableListMaster;
	 JTable tableMaster;
	 
	 JTable tableValidNorm[];
	 JTable tableValidRat[];
	 JTable tableValidComp[];
	 
	 JTextField typeUe[];
	 
	 JLabel cred[];
	 JTextField credTxt[];
	 
	 JTextField numTxt[];
	 JLabel num[];
	 
	 JLabel moyen[];
	 JTextField moyenTxt[];
	 
	 JLayeredPane layeredPane = new JLayeredPane();
	@SuppressWarnings("rawtypes")
	 JComboBox combo[];
	/*panel de la deliberation personnel */
	 String titreDelib[]= {"Unité d'enseignement","Elément constitutif","Note"};
	 String titrePanDelib[]= {"Réleve de Note de l'Université de Fianarantsoa Faculté des Sciences"};
	 JPanel panDelib[];
	 JPanel panInfDelib[];
	 JPanel panPanDelib[];
	 JPanel panValidation[];
	 JPanel panLicence=new JPanel();
	 JPanel panMaster=new JPanel();
	 
	 JPanel panListLicence=new JPanel();
	 JPanel panListMaster=new JPanel();
	 
	 JLabel nomF[];
	 JLabel numF[];
	 JLabel par[];
	 
	 JLabel prenomF[];
	 JLabel prenomT[];
	 
	 JLabel nomT[];
	 JLabel numT[];
	 
	 JLabel credF[];
	 JLabel moyenF[];
	 JLabel credT[];
	 JLabel moyenT[];
	 JLabel img[];
	 
	 JTable tableDelib[];
	 JTable tablePanDelib[];
	 DefaultTableModel modelDelib[];
	 DefaultTableModel modelPanDelib[];
	 
	 DefaultTableModel modelValidNorm[];
	 DefaultTableModel modelValidRat[];
	 DefaultTableModel modelValidComp[];
	 DefaultTableModel modelResult[];
	
	 JScrollPane scrol[];
	 Font font=new Font("arial",Font.BOLD,16);
	 Font font1=new Font("arial",Font.BOLD,12);
	
	public  FenetreResultat(JFrame parent, String title, boolean modal,String mention
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
		this.setSize(1100,700);
		//this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(parent);
	
		
	
		panPrincipale=new JPanel[nbrSems];
		panMatiere=new JPanel[nbrSems];
		panNote=new JPanel[nbrSems];
		panRecNote=new JPanel[nbrSems];
		panParUe=new JPanel[nbrSems];
		panTableListNoOK=new JPanel[nbrSems];
		panTableListOK=new JPanel[nbrSems];
		ligne=new JPanel[nbrSems];
		modelEc= new DefaultTableModel[nbrSems];
		modelUe= new DefaultTableModel[nbrSems];
		
		panValidNorm=new JPanel[nbrSems];
		panValidRat=new JPanel[nbrSems];
		panValidComp=new JPanel[nbrSems];
		
		panresultCrdt=new JPanel[nbrSems];
		panresultMoyen=new JPanel[nbrSems];
		
		ligne1=new JPanel[nbrSems];
		ligne2=new JPanel[nbrSems];
		ligne3=new JPanel[nbrSems];
		
		table1= new JTable[nbrSems];
		table2= new JTable[nbrSems];
		tableCred= new JTable[nbrSems];
		tableMoyen= new JTable[nbrSems];
		tableValidation= new JTable[nbrSems];
		scrol=new JScrollPane[nbrSems];
		tableUe= new JTable[nbrSems];
		tableEc= new JTable[nbrSems];
		
		tableValidNorm= new JTable[nbrSems];
		tableValidRat= new JTable[nbrSems];
		tableValidComp= new JTable[nbrSems];
		
		modelList1= new DefaultTableModel[nbrSems];
		modelList2= new DefaultTableModel[nbrSems];
		modelCred= new DefaultTableModel[nbrSems];
		modelMoyen= new DefaultTableModel[nbrSems];
		modelValidation= new DefaultTableModel[nbrSems];
		
		titre=new JLabel[nbrSems];
		sems=new JLabel[nbrSems];
		resul=new JLabel[nbrSems];
		
		numCarte=new JLabel[nbrSems];
		
		semsBox=new JCheckBox[nbrSems];
		semsValidation=new JCheckBox[nbrSems];
		
		result1=new JLabel[nbrSems];
		result2=new JLabel[nbrSems];
		
		result3=new JLabel[nbrSems];
		result4=new JLabel[nbrSems];
		result5=new JLabel[nbrSems];
		
		resultCrdt=new JLabel[nbrSems];
		resultMoyen=new JLabel[nbrSems];
		
		cred=new JLabel[nbrSems];
		credTxt= new JTextField[nbrSems];
		
		numTxt= new JTextField[nbrSems];
		
		moyen=new JLabel[nbrSems];
		moyenTxt= new JTextField[nbrSems];
		
		valUeEc=new JButton[nbrSems];
		NovalUeEc=new JButton[nbrSems];
		valide=new JButton[nbrSems];
		print=new JButton[nbrSems];
		printUe=new JButton[nbrSems];
		
		infCred=new JButton[nbrSems];
		supCred=new JButton[nbrSems];
		egalCred=new JButton[nbrSems];
		
		infMoy=new JButton[nbrSems];
		supMoy=new JButton[nbrSems];
		egalMoy=new JButton[nbrSems];
		
		printNorm=new JButton[nbrSems];
		printRat=new JButton[nbrSems];
		printComp=new JButton[nbrSems];
		printResultGlob=new JButton[nbrSems];
		resultGlob=new JButton[nbrSems];
		
		infMoyCred=new JButton[nbrSems];
		supMoyCred=new JButton[nbrSems];
		egalMoyCred=new JButton[nbrSems];
		validation=new JButton[nbrSems];
		releve=new JButton[nbrSems];
		validFinal=new JButton[nbrSems];
		
		snValid=new JButton[nbrSems];
		srValid=new JButton[nbrSems];
		srComp=new JButton[nbrSems];
		
		combo=new JComboBox[nbrSems];
		
		typeUe=new JTextField[nbrSems];
		
		panDelib=new JPanel[nbrSems];
		panPanDelib=new JPanel[nbrSems];
		panValidation=new JPanel[nbrSems];
		panInfDelib=new JPanel[nbrSems];
		img=new JLabel[nbrSems];
		nomF=new JLabel[nbrSems];
		prenomF=new JLabel[nbrSems];
		numF=new JLabel[nbrSems];
		par=new JLabel[nbrSems];
		
		nomT=new JLabel[nbrSems];
		prenomT=new JLabel[nbrSems];
		numT=new JLabel[nbrSems];
		
		credF=new JLabel[nbrSems];
		credT=new JLabel[nbrSems];
		
		moyenF=new JLabel[nbrSems];
		moyenT=new JLabel[nbrSems];
		
		tableDelib=new JTable[nbrSems];
		tablePanDelib=new JTable[nbrSems];
		modelDelib=new DefaultTableModel[nbrSems];
		modelPanDelib=new DefaultTableModel[nbrSems];
		
		modelValidNorm=new DefaultTableModel[nbrSems];
		modelValidRat=new DefaultTableModel[nbrSems];
		modelValidComp=new DefaultTableModel[nbrSems];
		modelResult=new DefaultTableModel[nbrSems];
		
		
		

		DefaultTableCellRenderer centerRenderer= new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		
		modelLicence= new DefaultTableModel(){
			public Class <?>getColumnClass(int Column) {
				if(Column == 2) 
					return Boolean.class;
				else
					return String.class;
				
			}
			public boolean isCellEditable(int row, int col){
				if(col!=2)
					return false;
				else
					return true;
			}
		};
		
		modelMaster= new DefaultTableModel(){
			public Class <?>getColumnClass(int Column) {
				if(Column == 2) 
					return Boolean.class;
				else
					return String.class;
				
			}
			public boolean isCellEditable(int row, int col){
				if(col!=2)
					return false;
				else
					return true;
			}
		};
		
		modelListMaster= new DefaultTableModel(){
			public boolean isCellEditable(int row, int col){
				return false;
			}
		};
		
		modelListLicence= new DefaultTableModel(){
			public boolean isCellEditable(int row, int col){
				return false;
			}
		};
		
		for(int k1=0;k1<titleValid.length;k1++)
			modelListLicence.addColumn(titleValid[k1]);
		tableListLicence=new JTable(modelListLicence);
		
		for(int k1=0;k1<titleValid.length;k1++)
			modelListMaster.addColumn(titleValid[k1]);
		tableListMaster=new JTable(modelListMaster);
		
		for(int k1=0;k1<diplome.length;k1++)
			modelLicence.addColumn(diplome[k1]);
		tableLicence=new JTable(modelLicence);
		
		for(int k1=0;k1<diplome.length;k1++)
			modelMaster.addColumn(diplome[k1]);
		tableMaster=new JTable(modelMaster);
		
		for(int i=0;i<nbrSems;i++) {
			panPrincipale[i]=new JPanel();
			panMatiere[i]=new JPanel();
			panNote[i]=new JPanel();
			panRecNote[i]=new JPanel();
			panParUe[i]=new JPanel();
			panTableListOK[i]=new JPanel();
			panTableListNoOK[i]=new JPanel();
			ligne[i]=new JPanel();
			ligne1[i]=new JPanel();
			ligne2[i]=new JPanel();
			ligne3[i]=new JPanel();
			panDelib[i]=new JPanel();
			panInfDelib[i]=new JPanel();
			panPanDelib[i]=new JPanel();
			panresultCrdt[i]=new JPanel();
			panresultMoyen[i]=new JPanel();
			panValidation[i]=new JPanel();
			
			panValidNorm[i]=new JPanel();
			panValidRat[i]=new JPanel();
			panValidComp[i]=new JPanel();
			
			result1[i]=new JLabel("");
			result2[i]=new JLabel("");
			result3[i]=new JLabel("");
			result4[i]=new JLabel("");
			result5[i]=new JLabel("");
			resul[i]=new JLabel();
			
			resultCrdt[i]=new JLabel("");
			resultMoyen[i]=new JLabel("");
			
			cred[i]=new JLabel("Credit:");
			moyen[i]=new JLabel("Moyenne:");
			
			par[i]=new JLabel(parcour);
			
			numCarte[i]=new JLabel("N°Carte :");
			numF[i]=new JLabel("N°Carte :");
			nomF[i]=new JLabel("Nom:");
			prenomF[i]=new JLabel("Prénom:");
			credF[i]=new JLabel("Crédit :");
			moyenF[i]=new JLabel("Moyenne :");
			numT[i]=new JLabel();
			nomT[i]=new JLabel();
			prenomT[i]=new JLabel();
			credT[i]=new JLabel();
			moyenT[i]=new JLabel();
			img[i]=new JLabel();
			sems[i]=new JLabel("Semsetre "+(i+debutSems+1));
			semsBox[i]=new JCheckBox();
			
			credTxt[i]=new JTextField();
			moyenTxt[i]=new JTextField();
			numTxt[i]=new JTextField();
			
			printUe[i]=new JButton (LoadImage.transformeb(100, 25, "/imprimer.jpg"));
			valUeEc[i]=new JButton (LoadImage.transformeb(40, 20, "/vraie.jpg"));
			NovalUeEc[i]=new JButton (LoadImage.transformeb(40, 20, "/croi.jpg"));
			valide[i]=new JButton (LoadImage.transformeb(100, 25, "/valide.jpg"));
			print[i]=new JButton (LoadImage.transformeb(100, 25, "/imprimer.jpg"));
			
			printNorm[i]=new JButton (LoadImage.transformeb(100, 25, "/imprimer.jpg"));
			printRat[i]=new JButton (LoadImage.transformeb(100, 25, "/imprimer.jpg"));
			printComp[i]=new JButton (LoadImage.transformeb(100, 25, "/imprimer.jpg"));
			printResultGlob[i]=new JButton (LoadImage.transformeb(100, 25, "/imprimer.jpg"));
			
			resultGlob[i]=new JButton (LoadImage.transformeb(100, 25, "/resultatglob.jpg"));
			
			infCred[i]=new JButton (LoadImage.transformeb(35, 20, "/inf.jpg"));
			egalCred[i]=new JButton (LoadImage.transformeb(35, 20, "/egale.jpg"));
			supCred[i]=new JButton (LoadImage.transformeb(35, 20, "/sup.jpg"));
			
			infMoy[i]=new JButton (LoadImage.transformeb(35, 20, "/inf.jpg"));
			egalMoy[i]=new JButton (LoadImage.transformeb(35, 20, "/egale.jpg"));
			supMoy[i]=new JButton (LoadImage.transformeb(35, 20, "/sup.jpg"));
			
			infMoyCred[i]=new JButton (LoadImage.transformeb(50, 20, "/inf.jpg"));
			egalMoyCred[i]=new JButton (LoadImage.transformeb(50, 20, "/egale.jpg"));
			supMoyCred[i]=new JButton (LoadImage.transformeb(50, 20, "/sup.jpg"));
			
			snValid[i]=new JButton (LoadImage.transformeb(75, 20, "/sndef.jpg"));
			srValid[i]=new JButton (LoadImage.transformeb(75, 20, "/srdef.jpg"));
			srComp[i]=new JButton (LoadImage.transformeb(85, 20, "/srcomp.jpg"));
			
			snValid[i].setToolTipText("Resultat Séssion normal définitive");
			srValid[i].setToolTipText("Resultat Séssion Rattrapage définitive");
			srComp[i].setToolTipText("Resultat Séssion Rattrapage Compensé");
			
			valUeEc[i].setToolTipText("etudiant validé a la fois l'U.E et l'E.C ");
			NovalUeEc[i].setToolTipText("liste des etudiants rattrapés");
			
			valide[i].setToolTipText("Reléve de Note");
			
			validFinal[i]=new JButton (LoadImage.transformeb(85, 20, "/valide.jpg"));
			releve[i]=new JButton (LoadImage.transformeb(85, 20, "/valide.jpg"));
			validation[i]=new JButton (LoadImage.transformeb(100, 20, "/deliberation.jpg"));
			
			semsValidation[i]=new JCheckBox("Selectioner tout");
			
			typeUe[i]=new JTextField();
			typeUe[i].setEnabled(false);
			
			modelEc[i]=new TableModel(titleEc);
			modelUe[i]=new TableModel(titleUe);
			
			modelList1[i]=new TableModel(titreList);
			modelList2[i]=new TableModel(titreList);
			
			modelCred[i]=new TableModel(titreCred);
			modelMoyen[i]=new TableModel(titreMoyen);
			
			modelValidNorm[i]=new TableModel(titleValid);
			modelValidRat[i]=new TableModel(titleValid);
			modelValidComp[i]=new TableModel(titleValid);
			
			modelDelib[i]=new TableModel(titreDelib);
			modelPanDelib[i]=new DefaultTableModel() {
				public boolean isCellEditable(int row, int col){
					return false;
					}
			};
			
			modelValidation[i]= new DefaultTableModel(){
				public Class <?>getColumnClass(int Column) {
					if(Column == 4) 
						return Boolean.class;
					else
						return String.class;
					
				}
				public boolean isCellEditable(int row, int col){
					if(col!=4)
						return false;
					else
						return true;
				}
			};
			
			
			
			
			
			for(int k1=0;k1<titleSems.length;k1++)
			modelValidation[i].addColumn(titleSems[k1]);
			
			tableValidation[i]=new JTable(modelValidation[i]);
			
			tableUe[i]=new JTable(modelUe[i]);
			tableEc[i]=new JTable(modelEc[i]);
			
			table1[i]=new JTable(modelList1[i]);
			table2[i]=new JTable(modelList2[i]);
			
			tableCred[i]=new JTable(modelCred[i]);
			tableMoyen[i]=new JTable(modelMoyen[i]);
			
			tableValidNorm[i]=new JTable(modelValidNorm[i]);
			tableValidNorm[i].setPreferredScrollableViewportSize(new Dimension(380,480));
			tableValidNorm[i].getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
			tableValidNorm[i].setFillsViewportHeight(true);
			tableValidNorm[i].getColumnModel().getColumn(0).setPreferredWidth(50);
			tableValidNorm[i].getColumnModel().getColumn(1).setPreferredWidth(280);
			panValidNorm[i].add(new JScrollPane(tableValidNorm[i]));
			panValidNorm[i].add(result3[i]);
			panValidNorm[i].add(new JScrollPane(printNorm[i]));
			
			tableValidRat[i]=new JTable(modelValidRat[i]);
			tableValidRat[i].setPreferredScrollableViewportSize(new Dimension(380,480));
			tableValidRat[i].getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
			tableValidRat[i].setFillsViewportHeight(true);
			tableValidRat[i].getColumnModel().getColumn(0).setPreferredWidth(70);
			tableValidRat[i].getColumnModel().getColumn(1).setPreferredWidth(280);
			panValidRat[i].add(new JScrollPane(tableValidRat[i]));
			panValidRat[i].add(result4[i]);
			panValidRat[i].add(new JScrollPane(printRat[i]));
			
			tableValidComp[i]=new JTable(modelValidComp[i]);
			tableValidComp[i].setPreferredScrollableViewportSize(new Dimension(380,480));
			tableValidComp[i].getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
			tableValidComp[i].setFillsViewportHeight(true);
			tableValidComp[i].getColumnModel().getColumn(0).setPreferredWidth(70);
			tableValidComp[i].getColumnModel().getColumn(1).setPreferredWidth(280);
			panValidComp[i].add(new JScrollPane(tableValidComp[i]));
			panValidComp[i].add(result5[i]);
			panValidComp[i].add(printComp[i]);
			
			tableDelib[i]=new JTable(modelDelib[i]);
			tableDelib[i].setRowHeight(20);
			tableDelib[i].setShowGrid(false);
			tableDelib[i].setPreferredScrollableViewportSize(new Dimension(500,20));
			tableDelib[i].setDefaultRenderer(Object.class,new ColorCell(i));
			tableDelib[i].setIntercellSpacing(new Dimension(0,4));
			tableDelib[i].setFillsViewportHeight(true);
			tableDelib[i].getColumnModel().getColumn(0).setPreferredWidth(220);
			tableDelib[i].getColumnModel().getColumn(1).setPreferredWidth(220);
			tableDelib[i].getColumnModel().getColumn(2).setPreferredWidth(50);
			
			panDelib[i].add(img[i]);
			panDelib[i].add(panInfDelib[i]);
			panInfDelib[i].add(nomF[i]);
			panInfDelib[i].add(nomT[i]);
			panInfDelib[i].add(prenomF[i]);
			panInfDelib[i].add(prenomT[i]);
			panInfDelib[i].add(numF[i]);
			panInfDelib[i].add(numT[i]);
			panInfDelib[i].add(new JLabel("Parcours: "));
			panInfDelib[i].add(par[i]);
			
			panInfDelib[i].add(sems[i]);
			panInfDelib[i].add(semsBox[i]);
			panInfDelib[i].add(resul[i]);
			panDelib[i].add(panInfDelib[i]);
			panDelib[i].add(new JScrollPane(tableDelib[i]));
			panDelib[i].add(credF[i]);
			panDelib[i].add(credT[i]);
			panDelib[i].add(moyenF[i]);
			panDelib[i].add(moyenT[i]);
			
			modelPanDelib[i].addColumn(titrePanDelib[0]);
			tablePanDelib[i]=new JTable(modelPanDelib[i]);
			tablePanDelib[i].setPreferredScrollableViewportSize(new Dimension(500,500));
			panPanDelib[i].add(new JScrollPane(tablePanDelib[i]));
			panPanDelib[i].add(print[i]);
			
			tableValidation[i].setPreferredScrollableViewportSize(new Dimension(550,500));
			tableValidation[i].getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
			tableValidation[i].getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
			tableValidation[i].setFillsViewportHeight(true);
			tableValidation[i].getColumnModel().getColumn(0).setPreferredWidth(90);
			tableValidation[i].getColumnModel().getColumn(1).setPreferredWidth(300);
			tableValidation[i].getColumnModel().getColumn(2).setPreferredWidth(50);
			tableValidation[i].getColumnModel().getColumn(3).setPreferredWidth(60);
			tableValidation[i].getColumnModel().getColumn(4).setPreferredWidth(60);
			panValidation[i].add(new JScrollPane(tableValidation[i]));
			panValidation[i].add(semsValidation[i]);
			panValidation[i].add(validFinal[i]);
			
			
			tableLicence.setPreferredScrollableViewportSize(new Dimension(390,480));
			tableLicence.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
			tableLicence.setFillsViewportHeight(true);
			tableLicence.getColumnModel().getColumn(0).setPreferredWidth(90);
			tableLicence.getColumnModel().getColumn(1).setPreferredWidth(250);
			tableLicence.getColumnModel().getColumn(2).setPreferredWidth(50);
			
			tableListLicence.setPreferredScrollableViewportSize(new Dimension(390,480));
			tableListLicence.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
			tableListLicence.setFillsViewportHeight(true);
			tableListLicence.getColumnModel().getColumn(0).setPreferredWidth(90);
			tableListLicence.getColumnModel().getColumn(1).setPreferredWidth(300);
			
			tableListMaster.setPreferredScrollableViewportSize(new Dimension(390,480));
			tableListMaster.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
			tableListMaster.setFillsViewportHeight(true);
			tableListMaster.getColumnModel().getColumn(0).setPreferredWidth(90);
			tableListMaster.getColumnModel().getColumn(1).setPreferredWidth(300);
			
			
			
			tableMaster.setPreferredScrollableViewportSize(new Dimension(390,480));
			tableMaster.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
			tableMaster.setFillsViewportHeight(true);
			tableMaster.getColumnModel().getColumn(0).setPreferredWidth(90);
			tableMaster.getColumnModel().getColumn(1).setPreferredWidth(250);
			tableMaster.getColumnModel().getColumn(2).setPreferredWidth(50);
			
			
			table1[i].setPreferredScrollableViewportSize(new Dimension(380,490));
			table1[i].getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
			table1[i].getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
			table1[i].setFillsViewportHeight(true);
			table1[i].getColumnModel().getColumn(0).setPreferredWidth(60);
			table1[i].getColumnModel().getColumn(1).setPreferredWidth(280);
			table1[i].getColumnModel().getColumn(2).setPreferredWidth(50);
			panTableListOK[i].add(new JScrollPane(table1[i]));
			panTableListOK[i].add(result1[i]);
			
			table2[i].setPreferredScrollableViewportSize(new Dimension(380,490));
			table2[i].getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
			table2[i].getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
			table2[i].setFillsViewportHeight(true);
			table2[i].getColumnModel().getColumn(0).setPreferredWidth(60);
			table2[i].getColumnModel().getColumn(1).setPreferredWidth(280);
			table2[i].getColumnModel().getColumn(2).setPreferredWidth(50);
			panTableListNoOK[i].add(new JScrollPane(table2[i]));
			panTableListNoOK[i].add(result2[i]);
			
			
			tableUe[i].setPreferredScrollableViewportSize(new Dimension(230,120));
			tableUe[i].getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
			tableUe[i].setFillsViewportHeight(true);
			tableUe[i].getColumnModel().getColumn(0).setPreferredWidth(190);
			tableUe[i].getColumnModel().getColumn(1).setPreferredWidth(40);
			panMatiere[i].add(new JScrollPane(tableUe[i]));
			
			tableEc[i].setPreferredScrollableViewportSize(new Dimension(230,200));
			tableEc[i].getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
			tableEc[i].setFillsViewportHeight(true);
			tableEc[i].getColumnModel().getColumn(0).setPreferredWidth(190);
			tableEc[i].getColumnModel().getColumn(1).setPreferredWidth(40);
			panMatiere[i].add(new JScrollPane(tableEc[i]));
			
			tableCred[i].setPreferredScrollableViewportSize(new Dimension(380,490));
			tableCred[i].getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
			tableCred[i].getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
			tableCred[i].setFillsViewportHeight(true);
			tableCred[i].getColumnModel().getColumn(0).setPreferredWidth(60);
			tableCred[i].getColumnModel().getColumn(1).setPreferredWidth(280);
			tableCred[i].getColumnModel().getColumn(2).setPreferredWidth(50);
			panresultCrdt[i].add(new JScrollPane(tableCred[i]));
			panresultCrdt[i].add(resultCrdt[i]);
			
			tableMoyen[i].setPreferredScrollableViewportSize(new Dimension(380,490));
			tableMoyen[i].getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
			tableMoyen[i].getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
			tableMoyen[i].setFillsViewportHeight(true);
			tableMoyen[i].getColumnModel().getColumn(0).setPreferredWidth(60);
			tableMoyen[i].getColumnModel().getColumn(1).setPreferredWidth(270);
			tableMoyen[i].getColumnModel().getColumn(2).setPreferredWidth(60);
			panresultMoyen[i].add(new JScrollPane(tableMoyen[i]));
			panresultMoyen[i].add(resultMoyen[i]);
			
			
			panTableListOK[i].setPreferredSize(new Dimension(400,550));
			panTableListNoOK[i].setPreferredSize(new Dimension(400,550));
			panPanDelib[i].setPreferredSize(new Dimension(520,560));
			panValidation[i].setPreferredSize(new Dimension(560,580));
			panMaster.setPreferredSize(new Dimension(400,580));
			panLicence.setPreferredSize(new Dimension(400,580));
			panListLicence.setPreferredSize(new Dimension(400,580));
			panListMaster.setPreferredSize(new Dimension(400,580));
			panresultCrdt[i].setPreferredSize(new Dimension(400,550));
			panresultMoyen[i].setPreferredSize(new Dimension(400,550));
			panTableListOK[i].setPreferredSize(new Dimension(400,550));
			panTableListNoOK[i].setPreferredSize(new Dimension(400,550));
			numTxt[i].setPreferredSize(new Dimension(80,20));
			resultListMas.setPreferredSize(new Dimension(390,20));
			resultListLic.setPreferredSize(new Dimension(390,20));
			result1[i].setPreferredSize(new Dimension(280,20));
			result2[i].setPreferredSize(new Dimension(280,20));
			
			result3[i].setPreferredSize(new Dimension(280,20));
			result4[i].setPreferredSize(new Dimension(280,20));
			result5[i].setPreferredSize(new Dimension(280,20));
			
			panValidNorm[i].setPreferredSize(new Dimension(400,550));
			panValidRat[i].setPreferredSize(new Dimension(400,550));
			panValidComp[i].setPreferredSize(new Dimension(400,550));
			
			ligne[i].setPreferredSize(new Dimension(800,1));
			ligne1[i].setPreferredSize(new Dimension(250,1));
			ligne2[i].setPreferredSize(new Dimension(250,1));
			ligne3[i].setPreferredSize(new Dimension(250,60));
			printUe[i].setPreferredSize(new Dimension(100,20));
			typeUe[i].setPreferredSize(new Dimension(143,20));
			valUeEc[i].setPreferredSize(new Dimension(40,20));
			NovalUeEc[i].setPreferredSize(new Dimension(40,20));
			valide[i].setPreferredSize(new Dimension(80,20));
			validFinal[i].setPreferredSize(new Dimension(80,20));
			print[i].setPreferredSize(new Dimension(100,20));
			printNorm[i].setPreferredSize(new Dimension(100,20));
			printRat[i].setPreferredSize(new Dimension(100,20));
			printComp[i].setPreferredSize(new Dimension(100,20));
			resultGlob[i].setPreferredSize(new Dimension(100,25));
			validation[i].setPreferredSize(new Dimension(100,25));
			releve[i].setPreferredSize(new Dimension(100,25));
			lic.setPreferredSize(new Dimension(100,25));
			mas.setPreferredSize(new Dimension(100,25));
			validLic.setPreferredSize(new Dimension(100,25));
			validMas.setPreferredSize(new Dimension(100,25));
			actLic.setPreferredSize(new Dimension(100,25));
			actMas.setPreferredSize(new Dimension(100,25));
			printLic.setPreferredSize(new Dimension(100,25));
			printMas.setPreferredSize(new Dimension(100,25));
			
			img[i].setPreferredSize(new Dimension(90,100));
			panInfDelib[i].setPreferredSize(new Dimension(395,100));
			nomT[i].setPreferredSize(new Dimension(345,15));
			prenomT[i].setPreferredSize(new Dimension(325,15));
			numT[i].setPreferredSize(new Dimension(325,15));
			par[i].setPreferredSize(new Dimension(325,15));
			
			nomF[i].setPreferredSize(new Dimension(40,15));
			prenomF[i].setPreferredSize(new Dimension(60,15));
			numF[i].setPreferredSize(new Dimension(60,15));
			sems[i].setPreferredSize(new Dimension(70,15));
			semsBox[i].setPreferredSize(new Dimension(20,15));
			
			cred[i].setPreferredSize(new Dimension(60,20));
			moyen[i].setPreferredSize(new Dimension(60,20));
			credTxt[i].setPreferredSize(new Dimension(40,20));
			moyenTxt[i].setPreferredSize(new Dimension(40,20));
			
			infCred[i].setPreferredSize(new Dimension(35,20));
			egalCred[i].setPreferredSize(new Dimension(35,20));
			supCred[i].setPreferredSize(new Dimension(35,20));
			
			infMoy[i].setPreferredSize(new Dimension(35,20));
			egalMoy[i].setPreferredSize(new Dimension(35,20));
			supMoy[i].setPreferredSize(new Dimension(35,20));
			
			infMoyCred[i].setPreferredSize(new Dimension(50,20));
			egalMoyCred[i].setPreferredSize(new Dimension(50,20));
			supMoyCred[i].setPreferredSize(new Dimension(50,20));
			panParUe[i].setPreferredSize(new Dimension(810,560));
			snValid[i].setPreferredSize(new Dimension(75,20));
			srValid[i].setPreferredSize(new Dimension(75,20));
			srComp[i].setPreferredSize(new Dimension(85,20));
			printResultGlob[i].setPreferredSize(new Dimension(100,20));

			panMatiere[i].setPreferredSize(new Dimension(260,630));
			panNote[i].setPreferredSize(new Dimension(820,630));
			panRecNote[i].setPreferredSize(new Dimension(710,60));
			
			panTableListOK[i].add(printUe[i]);
			printUe[i].setVisible(false);
			
			titre[i]=new JLabel("RESULTAT SESSION "+type.toUpperCase()+" S"+(i+debutSems+1)+" "+parcour);
			titre[i].setFont(font);
			panNote[i].add(titre[i]);
			panNote[i].add(ligne[i]);
			panNote[i].add(panTableListOK[i]);
			panNote[i].add(panTableListNoOK[i]);
			panNote[i].add(panPanDelib[i]);
			panNote[i].add(panTableListNoOK[i]);
			panNote[i].add(panresultCrdt[i]);
			panNote[i].add(panValidation[i]);
			panNote[i].add(panValidNorm[i]);
			panNote[i].add(panValidRat[i]);
			panNote[i].add(panParUe[i]);
			panNote[i].add(panValidComp[i]);
			panresultCrdt[i].setVisible(false);
			panNote[i].setLayout(new FlowLayout(FlowLayout.LEFT));
			panInfDelib[i].setLayout(new FlowLayout(FlowLayout.LEFT));
			panMatiere[i].setLayout(new FlowLayout(FlowLayout.LEFT));
			panParUe[i].setLayout(new FlowLayout(FlowLayout.LEFT));
			
			
			panPanDelib[i].setBackground(Color.cyan);
			panValidation[i].setBackground(Color.cyan);
			panValidNorm[i].setBackground(Color.cyan);
			panValidRat[i].setBackground(Color.cyan);
			panValidComp[i].setBackground(Color.cyan);
			panTableListOK[i].setBackground(Color.cyan);
			panTableListNoOK[i].setBackground(Color.cyan);
			panresultCrdt[i].setBackground(Color.cyan);
			panresultMoyen[i].setBackground(Color.cyan);
			panPrincipale[i].setBackground(Color.cyan);
			panMatiere[i].setBackground(Color.cyan);
			panNote[i].setBackground(Color.cyan);
			panParUe[i].setBackground(Color.cyan);
			
			
			//panTableListOK[i].setVisible(false);
			panPanDelib[i].setVisible(false);
			panValidation[i].setVisible(false);
			panMaster.setVisible(false);
			panLicence.setVisible(false);
			panListLicence.setVisible(false);
			panListMaster.setVisible(false);
			panParUe[i].setVisible(false);
			panValidNorm[i].setVisible(false);
			panValidRat[i].setVisible(false);
			panValidComp[i].setVisible(false);
			
			panMatiere[i].add(typeUe[i]);
			panMatiere[i].add(valUeEc[i]);
			panMatiere[i].add(NovalUeEc[i]);
			panMatiere[i].add(panresultMoyen[i]);
			panMatiere[i].add(cred[i]);
			panMatiere[i].add(credTxt[i]);
			panMatiere[i].add(infCred[i]);
			panMatiere[i].add(egalCred[i]);
			panMatiere[i].add(supCred[i]);
			panMatiere[i].add(moyen[i]);
			panMatiere[i].add(moyenTxt[i]);
			
			panMatiere[i].add(infMoy[i]);
			panMatiere[i].add(egalMoy[i]);
			panMatiere[i].add(supMoy[i]);
			
			panMatiere[i].add(infMoyCred[i]);
			panMatiere[i].add(egalMoyCred[i]);
			panMatiere[i].add(supMoyCred[i]);
			panMatiere[i].add(ligne1[i]);
			panMatiere[i].add(numCarte[i]);
			panMatiere[i].add(numTxt[i]);
			panMatiere[i].add(valide[i]);
			panMatiere[i].add(ligne2[i]);
			panMatiere[i].add(validation[i]);
			//panMatiere[i].add(releve[i]);
			panMatiere[i].add(ligne3[i]);
			ligne3[i].add(resultGlob[i]);
			if((i+debutSems+1)==6) {
			ligne3[i].add(lic);
			panLicence.add(new JScrollPane(tableLicence));
			panListLicence.add(new JScrollPane(tableListLicence));
			panLicence.add(resultLic);
			panLicence.add(validLic);
			panListLicence.add(resultListLic);
			panListLicence.add(actLic);
			panListLicence.add(printLic);

			printLic.addActionListener(new ImprimerLitLis(i));
			validLic.addActionListener(new validLicence());
			actLic.addActionListener(new ActLicence());
			panNote[i].add(panLicence);
			panNote[i].add(panListLicence);
			}
			if((i+debutSems+1)==10) {
			ligne3[i].add(mas);
			panMaster.add(new JScrollPane(tableMaster));
			panListMaster.add(new JScrollPane(tableListMaster));
			panMaster.add(resultMas);
			panMaster.add(validMas);
			validMas.addActionListener(new validMaster());
			actMas.addActionListener(new ActMaster());
			panListMaster.add(resultListMas);
			panListMaster.add(actMas);
			panListMaster.add(printMas);
			panNote[i].add(panMaster);
			panNote[i].add(panListMaster);
			}
			resultGlob[i].setEnabled(false);
			panMatiere[i].add(snValid[i]);
			panMatiere[i].add(srValid[i]);
			panMatiere[i].add(srComp[i]);
			panNote[i].add(panresultMoyen[i]);
			panresultMoyen[i].setVisible(false);
			
			panPrincipale[i].add(panMatiere[i]);
			panPrincipale[i].add(panNote[i]);
			valUeEc[i].setVisible(true);
			valide[i].setVisible(true);
			semsValidation[i].setOpaque(false);
			
			
			
			panDelib[i].setLayout(new FlowLayout(FlowLayout.LEFT));
			panPanDelib[i].setLayout(new FlowLayout(FlowLayout.RIGHT));
			print[i].addActionListener(new Imprimer(i));
			printUe[i].addActionListener(new ImprimerResultat(i));
			
			printNorm[i].addActionListener(new ImprimerListNorm(i));
			printRat[i].addActionListener(new ImprimerListRat(i));
			printComp[i].addActionListener(new ImprimerListComp(i));
			printResultGlob[i].addActionListener(new ImprimerRes(i));
			
			resultGlob[i].addActionListener(new ResultatGlobal(i));
			
			valUeEc[i].addActionListener(new valideUeEc(i));
			NovalUeEc[i].addActionListener(new NovalideUeEc(i));
			
			infCred[i].addActionListener(new getCredInf(i));
			egalCred[i].addActionListener(new getCredEgal(i));
			supCred[i].addActionListener(new getCredSup(i));
			
			infMoy[i].addActionListener(new getMoyenInf(i));
			egalMoy[i].addActionListener(new getMoyenEgal(i));
			supMoy[i].addActionListener(new getMoyenSup(i));
			
			infMoyCred[i].addActionListener(new getMoyenCredInf(i));
			egalMoyCred[i].addActionListener(new getMoyenCredEgal(i));
			supMoyCred[i].addActionListener(new getMoyenCredSup(i));
			
			valide[i].addActionListener(new Information(i));
			validation[i].addActionListener(new validation(i));
			//releve[i].addActionListener(new Releve(i));
			semsValidation[i].addActionListener(new Select(i));
			validFinal[i].addActionListener(new validFinal(i));
			
			snValid[i].addActionListener(new ListesNorm(i));
			srValid[i].addActionListener(new ListesRat(i));
			srComp[i].addActionListener(new ListesComp(i));
			if((i+debutSems+1)==6)
			lic.addActionListener(new Licence(i));
			if((i+debutSems+1)==10)
			mas.addActionListener(new Master(i));
			
			tableUe[i].addMouseListener(new actue(i));
			tableEc[i].addMouseListener(new actec(i));
			
			if(!DataBase.testTable(mention, i+1+debutSems, k, type)) {
				resultGlob[i].setEnabled(false);
				//lic.setEnabled(false);
				//mas.setEnabled(false);
				valUeEc[i].setEnabled(false);
				NovalUeEc[i].setEnabled(false);
				infCred[i].setEnabled(false);
				egalCred[i].setEnabled(false);
				supCred[i].setEnabled(false);
				infMoy[i].setEnabled(false);
				egalMoy[i].setEnabled(false);
				supMoy[i].setEnabled(false);
				infMoyCred[i].setEnabled(false);
				egalMoyCred[i].setEnabled(false);
				supMoyCred[i].setEnabled(false);
				valide[i].setEnabled(false);
				validation[i].setEnabled(false);
				releve[i].setEnabled(false);
				semsValidation[i].setEnabled(false);
				validFinal[i].setEnabled(false);
				snValid[i].setEnabled(false);
				srValid[i].setEnabled(false);
				srComp[i].setEnabled(false);
				tableUe[i].setEnabled(false);
				tableEc[i].setEnabled(false);
			}

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
	        	connection3 = DriverManager.getConnection(url, username, password);      
	        	statement3 = connection3.createStatement(); 
	        	rset3 = statement3.executeQuery(" SELECT * FROM uni_enseign_"+parc[k]+" WHERE semestre='"+semestre[i]+"'ORDER BY nom_ue");
	        	while(rset3.next()) {
	        		modelUe[i].addRow(new Object[] {rset3.getString(1),rset3.getString(2)});
	        		}
	        	rset3.close();
	        	statement3.close();
	        	connection3.close();
	        	}catch(Exception e) {
	        		System.out.println(e.getMessage());
	        	}
			
			try {
				String url = "jdbc:postgresql://"+DataBase.port+":5432/"+databaMatiere;
	        	connection3 = DriverManager.getConnection(url, username, password);      
	        	statement3 = connection3.createStatement(); 
	        	rset3 = statement3.executeQuery(" SELECT * FROM el_cons_"+parc[k]+" WHERE semestre='"+semestre[i]+"'ORDER BY nom_ue");
	        	while(rset3.next()) {
	        		modelEc[i].addRow(new Object[] {rset3.getString(1),rset3.getString("poids")});
	        		}
	        	rset3.close();
	        	statement3.close();
	        	connection3.close();
	        	}catch(Exception e) {
	        		System.out.println(e.getMessage());
	        	}
			
		}
	
		
		
		int i = debutSems;
		for(JPanel paneau : panPrincipale){
		pan.add("Semestre "+(++i), paneau);
		}JPanel paneau=new JPanel();
		paneau.setBounds(2, 2,990,668);
		pan.setBounds(0, 0, 1100, 700);
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
		String hg[]= {"Semestre1"};
		new FenetreResultat(null,"", true, "MATHEMATIQUES ET APPLICATIONS", 0, "final","T.C.M" , 1, 0, hg,"").setVisible(true);
		
	}
	
	public  class Imprimer implements ActionListener{
		int i;
		Imprimer(int i){
			this.i=i;
		}
		public void actionPerformed(ActionEvent arg0) {
			new FenetreImpressionReleve(modelPanDelib[i],modelDelib[i],panDelib[i]).setVisible(true);
		}
	}
	
	public  class ImprimerResultat implements ActionListener{
		int i;
		ImprimerResultat(int i){
			this.i=i;
		}
		public void actionPerformed(ActionEvent arg0) {
			if(type=="final")
				type="Rattrapage";
			new FenetreImpressionResultatUe(modelList1[i],mention,parcour,type,semestre[i],(i+1+debutSems),
					Methode.finit(Methode.getNom(tableUe[i]),i)).setVisible(true);
		}
	}
	
	public  class ImprimerListNorm implements ActionListener{
		int i;
		ImprimerListNorm(int i){
			this.i=i;
		}
		public void actionPerformed(ActionEvent arg0) {
			if(type=="final")
				type="Rattrapage";
			new FenetreImpressionResultatFinale(modelValidNorm[i],mention,parcour,type,semestre[i],(i+1+debutSems),0).setVisible(true);
		}
	}
	public  class ImprimerListRat implements ActionListener{
		int i;
		ImprimerListRat(int i){
			this.i=i;
		}
		public void actionPerformed(ActionEvent arg0) {
			if(type=="final")
				type="Rattrapage";
			new FenetreImpressionResultatFinale(modelValidRat[i],mention,parcour,type,semestre[i],(i+1+debutSems),1).setVisible(true);
		}
	}
	public  class ImprimerListComp implements ActionListener{
		int i;
		ImprimerListComp(int i){
			this.i=i;
		}
		public void actionPerformed(ActionEvent arg0) {
			if(type=="final")
				type="Rattrapage";
			new FenetreImpressionResultatFinale(modelValidComp[i],mention,parcour,type,semestre[i],(i+1+debutSems),2).setVisible(true);
		}
	}
	
	public  class ImprimerLitLis implements ActionListener{
		int i;
		ImprimerLitLis(int i){
			this.i=i;
		}
		public void actionPerformed(ActionEvent arg0) {
			if(type=="final")
				type="Rattrapage";
			new FenetreImpressionResultatLicence(modelLicence,mention,parcour,type,semestre[i],(i+1+debutSems)).setVisible(true);
		}
	}
	
	public  class ImprimerRes implements ActionListener{
		int i;
		ImprimerRes(int i){
			this.i=i;
		}
		public void actionPerformed(ActionEvent arg0) {
			if(type=="final")
				type="Rattrapage";
			new FenetreImpressionResultatUeGlobal(modelResult[i],mention,parcour,type,semestre[i],(i+1+debutSems),
					Methode.getNom(tableUe[i]),modelResult[i].getColumnCount()).setVisible(true);
		}
	}
	
	
	public  class Select implements ActionListener{
		int i;
		Select(int i){
			this.i=i;
		}
		public void actionPerformed(ActionEvent arg0) {
			if(semsValidation[i].isSelected()) {
				for(int k=0;k<modelValidation[i].getRowCount();k++)
					modelValidation[i].setValueAt(true, k, 4);
			}
			else
				for(int k=0;k<modelValidation[i].getRowCount();k++)
					modelValidation[i].setValueAt(false, k, 4);
			setVisible(true);
		}
		
	}
	
	public  class ResultatGlobal implements ActionListener{
		int i;
		ResultatGlobal(int i){
			this.i=i;
		}
		public void actionPerformed(ActionEvent arg0) {
			panresultCrdt[i].setVisible(false);
			panresultMoyen[i].setVisible(false);
			panListMaster.setVisible(false); 
			panListLicence.setVisible(false);
			panTableListNoOK[i].setVisible(false);
			panTableListOK[i].setVisible(false);
			panPanDelib[i].setVisible(false);
			panValidation[i].setVisible(false); 
			panMaster.setVisible(false); 
			panLicence.setVisible(false); 
			panValidNorm[i].setVisible(false);
			panValidRat[i].setVisible(false);
			panValidComp[i].setVisible(false);
			panParUe[i].setVisible(true);
			modelResult[i]=
			DataBase.resultParUe(mention, semestre[i], (i+debutSems+1),k,modelResult[i],type,Methode.getNom(tableUe[i]),panParUe[i]);
			panParUe[i].add(printResultGlob[i]);
			System.out.println(modelResult[i].getColumnCount());
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
			if(e.getClickCount()==1)
				resultGlob[i].setEnabled(true);
			if(e.getClickCount()==2) {
				panMaster.setVisible(false); 
				panLicence.setVisible(false); 
				panListMaster.setVisible(false); 
				panListLicence.setVisible(false);
				panresultCrdt[i].setVisible(false);
				panresultMoyen[i].setVisible(false);
				panTableListNoOK[i].setVisible(true);
				panTableListOK[i].setVisible(true);
				panPanDelib[i].setVisible(false);
				panValidation[i].setVisible(false);
				printUe[i].setVisible(true);
				panValidNorm[i].setVisible(false);
				panValidRat[i].setVisible(false);
				panValidComp[i].setVisible(false);
				panParUe[i].setVisible(false);
				DataBase.donne_resultat_ue(mention, modelList1[i], modelList2[i], 
						Methode.getNom(tableUe[i]), k, (i+debutSems+1), type);
				result1[i].setText(modelList1[i].getRowCount()+" étudiant(s) validé(s) l'U.E: "+Methode.finit(Methode.getNom(tableUe[i]),i));
				result2[i].setText(modelList2[i].getRowCount()+" étudiant(s) non validé(s) l'U.E: "+Methode.finit(Methode.getNom(tableUe[i]),i));
			}
		 }
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
		
	}
	
	public class actec implements MouseListener{
		int i;
		actec(int i){
			this.i=i;
		}
		@Override
		public void mouseClicked(MouseEvent e) {
		 if(tableEc[i].getRowCount()>0 && tableEc[i].getSelectedRow()!=-1) {
			if(e.getClickCount()==1) {
				panMaster.setVisible(false); 
				panLicence.setVisible(false); 
				panListMaster.setVisible(false); 
				panListLicence.setVisible(false);
				panresultCrdt[i].setVisible(false);
				panresultMoyen[i].setVisible(false);
				panTableListNoOK[i].setVisible(true);
				panTableListOK[i].setVisible(true);
				panPanDelib[i].setVisible(false);
				panValidation[i].setVisible(false);
				printUe[i].setVisible(false);
				panValidNorm[i].setVisible(false);
				panValidRat[i].setVisible(false);
				panValidComp[i].setVisible(false);
				panParUe[i].setVisible(false);
				DataBase.selectUe(mention, semestre[i], k, typeUe[i], Methode.getNom(tableEc[i]));
			}
			if(e.getClickCount()==2) {
				panMaster.setVisible(false); 
				panLicence.setVisible(false);
				panListMaster.setVisible(false); 
				panListLicence.setVisible(false); 
				panresultCrdt[i].setVisible(false);
				panresultMoyen[i].setVisible(false);
				panTableListNoOK[i].setVisible(true);
				panTableListOK[i].setVisible(true);
				panPanDelib[i].setVisible(false);
				panValidation[i].setVisible(false);
				panValidNorm[i].setVisible(false);
				panValidRat[i].setVisible(false);
				panValidComp[i].setVisible(false);
				panParUe[i].setVisible(false);
				DataBase.donne_resultat_ec(mention, modelList1[i], modelList2[i], 
						Methode.getNom(tableEc[i]), k, (i+debutSems+1), type);
				result1[i].setText(modelList1[i].getRowCount()+" étudiant(s) validé(s) l'E.C: "+Methode.finit(Methode.getNom(tableEc[i]),i));
				result2[i].setText(modelList2[i].getRowCount()+" étudiant(s) non validé(s) l'E.C: "+Methode.finit(Methode.getNom(tableEc[i]),i));
			}
		 }
		}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
		
	}
	
	
	public   class valideUeEc implements ActionListener{
		int i;
		valideUeEc(int i){
			this.i=i;
		}
		public void actionPerformed(ActionEvent e) {
			panMaster.setVisible(false); 
			panLicence.setVisible(false); 
			panListMaster.setVisible(false); 
			panListLicence.setVisible(false);
			panresultCrdt[i].setVisible(false);
			panresultMoyen[i].setVisible(false);
			panTableListNoOK[i].setVisible(true);
			panTableListOK[i].setVisible(true);
			panPanDelib[i].setVisible(false);
			panValidation[i].setVisible(false);
			panValidNorm[i].setVisible(false);
			panValidRat[i].setVisible(false);
			panValidComp[i].setVisible(false);
			panParUe[i].setVisible(false);
			DataBase.donne_resultat_ue_ec_succe(mention, modelList1[i], modelList2[i], 
					Methode.getNom(tableEc[i]),typeUe[i].getText(), k, (i+debutSems+1), type);
			result1[i].setText("Note de l'U.E: "+Methode.finit(typeUe[i].getText(),i)+" de "+modelList1[i].getRowCount()+" étudiant(s) ");
			result2[i].setText("Note de l'E.C: "+Methode.finit(Methode.getNom(tableEc[i]),i)+" de "+modelList2[i].getRowCount()+" étudiant(s) ");
		}
	}
	public   class NovalideUeEc implements ActionListener{
		int i;
		NovalideUeEc(int i){
			this.i=i;
		}
		public void actionPerformed(ActionEvent e) {
			panMaster.setVisible(false); 
			panLicence.setVisible(false); 
			panListMaster.setVisible(false); 
			panListLicence.setVisible(false);
			panresultCrdt[i].setVisible(false);
			panresultMoyen[i].setVisible(false);
			panTableListNoOK[i].setVisible(true);
			panTableListOK[i].setVisible(true);
			panPanDelib[i].setVisible(false);
			panValidation[i].setVisible(false);
			panValidNorm[i].setVisible(false);
			panValidRat[i].setVisible(false);
			panValidComp[i].setVisible(false);
			panParUe[i].setVisible(false);
			DataBase.donne_resultat_ue_ec_echec(mention, modelList1[i], modelList2[i], 
					Methode.getNom(tableEc[i]),typeUe[i].getText(), k, (i+debutSems+1), type);
			result1[i].setText("Note de l'U.E: "+Methode.finit(typeUe[i].getText(),i)+" de "+modelList1[i].getRowCount()+" étudiant(s) ");
			result2[i].setText("Note de l'E.C: "+Methode.finit(Methode.getNom(tableEc[i]),i)+" de "+modelList2[i].getRowCount()+" étudiant(s) ");
			}
		}
	
	public   class getCredInf implements ActionListener{
		int i;
		getCredInf(int i){
			this.i=i;
		}
		public void actionPerformed(ActionEvent e) {
			if(testDouble(credTxt[i].getText())) {
			panMaster.setVisible(false); 
			panLicence.setVisible(false); 
			panListMaster.setVisible(false); 
			panListLicence.setVisible(false);
			panresultCrdt[i].setVisible(true);
			panresultMoyen[i].setVisible(true);
			panTableListNoOK[i].setVisible(false);
			panTableListOK[i].setVisible(false);
			panPanDelib[i].setVisible(false);
			panValidation[i].setVisible(false);
			panValidNorm[i].setVisible(false);
			panValidRat[i].setVisible(false);
			panValidComp[i].setVisible(false);
			panParUe[i].setVisible(false);
			DataBase.resultCreditinf(mention, semestre[i], (i+debutSems+1), k, modelCred[i], type, 
											Integer.parseInt(credTxt[i].getText()));
			resultCrdt[i].setText(modelCred[i].getRowCount()+" étudiant(s) obtenue le crédit inférieur à "+credTxt[i].getText());
			}
		  }
		}
	public   class getCredEgal implements ActionListener{
		int i;
		getCredEgal(int i){
			this.i=i;
		}
		public void actionPerformed(ActionEvent e) {
			if(testDouble(credTxt[i].getText())) {
			panresultCrdt[i].setVisible(true);
			panMaster.setVisible(false); 
			panLicence.setVisible(false); 
			panListMaster.setVisible(false); 
			panListLicence.setVisible(false);
			panresultMoyen[i].setVisible(true);
			panTableListNoOK[i].setVisible(false);
			panTableListOK[i].setVisible(false);
			panPanDelib[i].setVisible(false);
			panValidation[i].setVisible(false);
			panValidNorm[i].setVisible(false);
			panValidRat[i].setVisible(false);
			panValidComp[i].setVisible(false);
			panParUe[i].setVisible(false);
			DataBase.resultCreditegal(mention, semestre[i], (i+debutSems+1), k, modelCred[i], type, 
										Integer.parseInt(credTxt[i].getText()));
			resultCrdt[i].setText(modelCred[i].getRowCount()+" étudiant(s) obtenue le crédit égal à "+credTxt[i].getText());
			}
		  }	
		}
	
	public   class getCredSup implements ActionListener{
		int i;
		getCredSup(int i){
			this.i=i;
		}
		public void actionPerformed(ActionEvent e) {
			if(testDouble(credTxt[i].getText())) {
			panresultCrdt[i].setVisible(true);
			panMaster.setVisible(false); 
			panLicence.setVisible(false); 
			panListMaster.setVisible(false); 
			panListLicence.setVisible(false);
			panresultMoyen[i].setVisible(true);
			panTableListNoOK[i].setVisible(false);
			panTableListOK[i].setVisible(false);
			panPanDelib[i].setVisible(false);
			panValidation[i].setVisible(false);
			panValidNorm[i].setVisible(false);
			panValidRat[i].setVisible(false);
			panValidComp[i].setVisible(false);
			panParUe[i].setVisible(false);
			DataBase.resultCreditsup(mention, semestre[i], (i+debutSems+1), k, modelCred[i], type, 
												Integer.parseInt(credTxt[i].getText()));
			resultCrdt[i].setText(modelCred[i].getRowCount()+" étudiant(s) obtenue le crédit supétieur à "+credTxt[i].getText());
			}
		   }
		}
	
	public   class getMoyenInf implements ActionListener{
		int i;
		getMoyenInf(int i){
			this.i=i;
		}
		public void actionPerformed(ActionEvent e) {
			if(testDouble(moyenTxt[i].getText())) {
			panresultCrdt[i].setVisible(true);
			panMaster.setVisible(false); 
			panLicence.setVisible(false); 
			panListMaster.setVisible(false); 
			panListLicence.setVisible(false);
			panresultMoyen[i].setVisible(true);
			panTableListNoOK[i].setVisible(false);
			panTableListOK[i].setVisible(false);
			panPanDelib[i].setVisible(false);
			panValidation[i].setVisible(false);
			panValidNorm[i].setVisible(false);
			panValidRat[i].setVisible(false);
			panValidComp[i].setVisible(false);
			panParUe[i].setVisible(false);
			DataBase.resultMoyeninf(mention, semestre[i], (i+debutSems+1), k, modelMoyen[i], type, 
											Double.parseDouble(moyenTxt[i].getText()));
			resultMoyen[i].setText(modelMoyen[i].getRowCount()+" étudiant(s) obtenue la moyenne inférieur à "+moyenTxt[i].getText());
			}
		  }
		}
	public   class getMoyenEgal implements ActionListener{
		int i;
		getMoyenEgal(int i){
			this.i=i;
		}
		public void actionPerformed(ActionEvent e) {
			if(testDouble(moyenTxt[i].getText())) {
			panresultCrdt[i].setVisible(true);
			panMaster.setVisible(false); 
			panLicence.setVisible(false); 
			panListMaster.setVisible(false); 
			panListLicence.setVisible(false);
			panresultMoyen[i].setVisible(true);
			panTableListNoOK[i].setVisible(false);
			panTableListOK[i].setVisible(false);
			panPanDelib[i].setVisible(false);
			panValidation[i].setVisible(false);
			panValidNorm[i].setVisible(false);
			panValidRat[i].setVisible(false);
			panValidComp[i].setVisible(false);
			panParUe[i].setVisible(false);
			DataBase.resultMoyenegal(mention, semestre[i], (i+debutSems+1), k, modelMoyen[i], type, 
										Double.parseDouble(moyenTxt[i].getText()));
			resultMoyen[i].setText(modelMoyen[i].getRowCount()+" étudiant(s) obtenue la moyenne égal à "+moyenTxt[i].getText());
			}
		  }
		}
	
	public   class getMoyenSup implements ActionListener{
		int i;
		getMoyenSup(int i){
			this.i=i;
		}
		public void actionPerformed(ActionEvent e) {
			if(testDouble(moyenTxt[i].getText())) {
			panresultCrdt[i].setVisible(true);
			panMaster.setVisible(false); 
			panLicence.setVisible(false); 
			panListMaster.setVisible(false); 
			panListLicence.setVisible(false);
			panresultMoyen[i].setVisible(true);
			panTableListNoOK[i].setVisible(false);
			panTableListOK[i].setVisible(false);
			panPanDelib[i].setVisible(false);
			panValidation[i].setVisible(false);
			panValidNorm[i].setVisible(false);
			panValidRat[i].setVisible(false);
			panValidComp[i].setVisible(false);
			panParUe[i].setVisible(false);
			DataBase.resultMoyensup(mention, semestre[i], (i+debutSems+1), k, modelMoyen[i], type, 
												Double.parseDouble(moyenTxt[i].getText()));
			resultMoyen[i].setText(modelMoyen[i].getRowCount()+" étudiant(s) obtenue la moyenne supétieur à "+moyenTxt[i].getText());
			}
		}
		}
	
	public   class getMoyenCredInf implements ActionListener{
		int i;
		getMoyenCredInf(int i){
			this.i=i;
		}
		public void actionPerformed(ActionEvent e) {
			if(testDouble(moyenTxt[i].getText()) && testDouble(credTxt[i].getText()) ) {
			panresultCrdt[i].setVisible(true);
			panMaster.setVisible(false); 
			panLicence.setVisible(false); 
			panListMaster.setVisible(false); 
			panListLicence.setVisible(false);
			panresultMoyen[i].setVisible(true);
			panTableListNoOK[i].setVisible(false);
			panTableListOK[i].setVisible(false);
			panPanDelib[i].setVisible(false);
			panValidation[i].setVisible(false);
			panValidNorm[i].setVisible(false);
			panValidRat[i].setVisible(false);
			panValidComp[i].setVisible(false);
			panParUe[i].setVisible(false);
			DataBase.resultMoyenCredtinf(mention, semestre[i], (i+debutSems+1), k,modelCred[i], modelMoyen[i], type, 
					Double.parseDouble(moyenTxt[i].getText()),Integer.parseInt(credTxt[i].getText()));
				resultMoyen[i].setText(modelMoyen[i].getRowCount()+" étudiant(s) obtenue la moyenne supétieur à "+moyenTxt[i].getText());
				resultCrdt[i].setText(modelCred[i].getRowCount()+" étudiant(s) obtenue le credit inférieur à "+credTxt[i].getText());
			}
		 }
		}
	public   class getMoyenCredEgal implements ActionListener{
		int i;
		getMoyenCredEgal(int i){
			this.i=i;
		}
		public void actionPerformed(ActionEvent e) {
			if(testDouble(moyenTxt[i].getText()) && testDouble(credTxt[i].getText()) ) {
			panresultCrdt[i].setVisible(true);
			panMaster.setVisible(false); 
			panLicence.setVisible(false); 
			panListMaster.setVisible(false); 
			panListLicence.setVisible(false);
			panresultMoyen[i].setVisible(true);
			panTableListNoOK[i].setVisible(false);
			panTableListOK[i].setVisible(false);
			panPanDelib[i].setVisible(false);
			panValidation[i].setVisible(false);
			panValidNorm[i].setVisible(false);
			panValidRat[i].setVisible(false);
			panValidComp[i].setVisible(false);
			panParUe[i].setVisible(false);
			DataBase.resultMoyenCredtegal(mention, semestre[i], (i+debutSems+1), k,modelCred[i], modelMoyen[i], type, 
					Double.parseDouble(moyenTxt[i].getText()),Integer.parseInt(credTxt[i].getText()));
			resultMoyen[i].setText(modelMoyen[i].getRowCount()+" étudiant(s) obtenue la moyenne supétieur à "+moyenTxt[i].getText());
			resultCrdt[i].setText(modelCred[i].getRowCount()+" étudiant(s) obtenue le credit égale à "+credTxt[i].getText());
			}
		 }
		}
	
	public   class getMoyenCredSup implements ActionListener{
		int i;
		getMoyenCredSup(int i){
			this.i=i;
		}
		public void actionPerformed(ActionEvent e) {
			if(testDouble(moyenTxt[i].getText()) && testDouble(credTxt[i].getText()) ) {
			panresultCrdt[i].setVisible(true);
			panMaster.setVisible(false); 
			panLicence.setVisible(false); 
			panListMaster.setVisible(false); 
			panListLicence.setVisible(false);
			panresultMoyen[i].setVisible(true);
			panTableListNoOK[i].setVisible(false);
			panTableListOK[i].setVisible(false);
			panPanDelib[i].setVisible(false);
			panValidation[i].setVisible(false);
			panValidNorm[i].setVisible(false);
			panValidRat[i].setVisible(false);
			panValidComp[i].setVisible(false);
			panParUe[i].setVisible(false);
			DataBase.resultMoyenCredtsup(mention, semestre[i], (i+debutSems+1), k,modelCred[i], modelMoyen[i], type, 
												Double.parseDouble(moyenTxt[i].getText()),Integer.parseInt(credTxt[i].getText()));
			resultMoyen[i].setText(modelMoyen[i].getRowCount()+" étudiant(s) obtenue la moyenne supétieur à "+moyenTxt[i].getText());
			resultCrdt[i].setText(modelCred[i].getRowCount()+" étudiant(s) obtenue le credit supétieur à "+credTxt[i].getText());
			}
		 }
		}
	
	public   class validation implements ActionListener{
		int i;
		validation(int i){
			this.i=i;
		}
		public void actionPerformed(ActionEvent e) {
			if(testDouble(moyenTxt[i].getText()) && testDouble(credTxt[i].getText()) ) {
			panresultCrdt[i].setVisible(false);
			panMaster.setVisible(false); 
			panLicence.setVisible(false); 
			panListMaster.setVisible(false); 
			panListLicence.setVisible(false);
			panresultMoyen[i].setVisible(false);
			panTableListNoOK[i].setVisible(false);
			panTableListOK[i].setVisible(false);
			panPanDelib[i].setVisible(false);
			panValidation[i].setVisible(true);
			panValidNorm[i].setVisible(false);
			panValidRat[i].setVisible(false);
			panValidComp[i].setVisible(false);
			panParUe[i].setVisible(false);
			DataBase.deliberation(mention, semestre[i], (i+debutSems+1), k,modelValidation[i],type, 
												Double.parseDouble(moyenTxt[i].getText()),Integer.parseInt(credTxt[i].getText()));
			resultMoyen[i].setText(modelMoyen[i].getRowCount()+" étudiant(s) obtenue la moyenne supétieur à "+moyenTxt[i].getText());
			resultCrdt[i].setText(modelCred[i].getRowCount()+" étudiant(s) obtenue le credit supétieur à "+credTxt[i].getText());
			}
		 }
		}
	
	public   class validFinal implements ActionListener{
		int i;
		validFinal(int i){
			this.i=i;
		}
		public void actionPerformed(ActionEvent e) {
			
			int option = JOptionPane.showConfirmDialog(pan,"Voulez-vous valider ?","ATTENTION!",
			JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE);
			if(option == JOptionPane.OK_OPTION){	
			for(int k=0;k<modelValidation[i].getRowCount();k++)
			DataBase.deliberationFinal(panValidation[i],(String)modelValidation[i].getValueAt(k,0),(i+debutSems+1) ,
					String.valueOf(modelValidation[i].getValueAt(k,4)));
			JOptionPane.showMessageDialog(pan,"Opération terminé","",JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
		}
	
	public   class Information implements ActionListener{
		int i;
		Information(int i){
			this.i=i;
		}
		public void actionPerformed(ActionEvent e) {
			//panPanDelib[i].removeAll();
			modelPanDelib[i].setRowCount(0);
			//panPanDelib[i].setVisible(false);
			panMaster.setVisible(false); 
			panLicence.setVisible(false); 
			panListMaster.setVisible(false); 
			panListLicence.setVisible(false);
			panresultCrdt[i].setVisible(false);
			panresultMoyen[i].setVisible(false);
			panTableListNoOK[i].setVisible(false);
			panTableListOK[i].setVisible(false);
			panPanDelib[i].setVisible(true);
			panValidation[i].setVisible(false); 
			panValidNorm[i].setVisible(false);
			panValidRat[i].setVisible(false);
			panValidComp[i].setVisible(false);
			panParUe[i].setVisible(false);
			numT[i].setText("");
			moyenT[i].setText("");
			credT[i].setText("");
			nomT[i].setText("");
			prenomT[i].setText("");
			semsBox[i].setSelected(false);
			img[i].setIcon(null);
			
			DataBase.resultEtudiant(mention, semestre[i], (i+debutSems+1), k,modelDelib[i], type, 
										moyenT[i],credT[i],nomT[i],prenomT[i],numTxt[i].getText(),numT[i],img[i],semsBox[i]);
			tableDelib[i].setPreferredScrollableViewportSize(new Dimension(500,modelDelib[i].getRowCount()*20));
			resul[i].setText(DataBase.typeResult(mention,semestre[i],(i+debutSems+1), k,numT[i].getText()));
			panDelib[i].setPreferredSize(new Dimension(400,modelDelib[i].getRowCount()*20+170));
			panDelib[i].setBackground(Color.white);
			tablePanDelib[i].setDefaultRenderer(Object.class, new Multirender(panDelib[i]));
			modelPanDelib[i].addRow(new Object[] {panDelib[i]});
			tablePanDelib[i].setRowHeight(modelDelib[i].getRowCount()*20+170);
			setVisible(true);
			}
		}
	
	
	
	public   class ListesNorm implements ActionListener{
		int i;
		ListesNorm(int i){
			this.i=i;
		}public void actionPerformed(ActionEvent arg0) {
			panresultCrdt[i].setVisible(false);
			panMaster.setVisible(false); 
			panLicence.setVisible(false); 
			panListMaster.setVisible(false); 
			panListLicence.setVisible(false);
			panresultMoyen[i].setVisible(false);
			panTableListNoOK[i].setVisible(false);
			panTableListOK[i].setVisible(false);
			panPanDelib[i].setVisible(false);
			panValidation[i].setVisible(false); 
			panValidNorm[i].setVisible(true);
			panValidRat[i].setVisible(false);
			panValidComp[i].setVisible(false);
			panParUe[i].setVisible(false);
			DataBase.typeResult(mention,semestre[i],(i+debutSems+1), k,modelValidNorm[i],modelValidRat[i],modelValidComp[i]);
			result3[i].setText(modelValidNorm[i].getRowCount()+" étudiant définitive session normal" );
			
		}
	}
	
	public   class ListesRat implements ActionListener{
		int i;
		ListesRat(int i){
			this.i=i;
		}public void actionPerformed(ActionEvent arg0) {
			panresultCrdt[i].setVisible(false);
			panMaster.setVisible(false); 
			panLicence.setVisible(false); 
			panListMaster.setVisible(false); 
			panListLicence.setVisible(false);
			panresultMoyen[i].setVisible(false);
			panTableListNoOK[i].setVisible(false);
			panTableListOK[i].setVisible(false);
			panPanDelib[i].setVisible(false);
			panValidation[i].setVisible(false); 
			panValidNorm[i].setVisible(false);
			panValidRat[i].setVisible(true);
			panValidComp[i].setVisible(false);
			panParUe[i].setVisible(false);
			DataBase.typeResult(mention,semestre[i],(i+debutSems+1), k,modelValidNorm[i],modelValidRat[i],modelValidComp[i]);
			result4[i].setText(modelValidRat[i].getRowCount()+" étudiant définitive session rattrapage" );
		}
	}
	
	public   class ListesComp implements ActionListener{
		int i;
		ListesComp(int i){
			this.i=i;
		}public void actionPerformed(ActionEvent arg0) {
			panresultCrdt[i].setVisible(false);
			panMaster.setVisible(false); 
			panLicence.setVisible(false); 
			panListMaster.setVisible(false); 
			panListLicence.setVisible(false);
			panresultMoyen[i].setVisible(false);
			panTableListNoOK[i].setVisible(false);
			panTableListOK[i].setVisible(false);
			panPanDelib[i].setVisible(false);
			panValidation[i].setVisible(false); 
			panValidNorm[i].setVisible(false);
			panValidRat[i].setVisible(false);
			panValidComp[i].setVisible(true);
			panParUe[i].setVisible(false);
			DataBase.typeResult(mention,semestre[i],(i+debutSems+1), k,modelValidNorm[i],modelValidRat[i],modelValidComp[i]);
			result5[i].setText(modelValidComp[i].getRowCount()+" étudiant Compensé " );
		}
	}
	
	public   class Licence implements ActionListener{
		int i;
		Licence(int i){
			this.i=i;
		}public void actionPerformed(ActionEvent arg0) {
			panresultCrdt[i].setVisible(false);
			panMaster.setVisible(false); 
			panLicence.setVisible(true); 
			panListMaster.setVisible(false); 
			panListLicence.setVisible(true);
			panresultMoyen[i].setVisible(false);
			panTableListNoOK[i].setVisible(false);
			panTableListOK[i].setVisible(false);
			panPanDelib[i].setVisible(false);
			panValidation[i].setVisible(false); 
			panValidNorm[i].setVisible(false);
			panValidRat[i].setVisible(false);
			panValidComp[i].setVisible(false);
			panParUe[i].setVisible(false);
			DataBase.licence(mention,modelLicence);
			DataBase.act_diplome(mention,modelListLicence,"S5","S6");
			resultLic.setText(modelLicence.getRowCount()+" etudiant(s) validé(s) la semestre S6" );
			resultListLic.setText(modelListLicence.getRowCount()+" etudiant(s) obtenue(s) le diplome de LICENCE" );
		}
	}
	
	public   class Master implements ActionListener{
		int i;
		Master(int i){
			this.i=i;
		}public void actionPerformed(ActionEvent arg0) {
			panresultCrdt[i].setVisible(false);
			panMaster.setVisible(true); 
			panLicence.setVisible(false); 
			panListMaster.setVisible(true); 
			panListLicence.setVisible(false); 
			panresultMoyen[i].setVisible(false);
			panTableListNoOK[i].setVisible(false);
			panTableListOK[i].setVisible(false);
			panPanDelib[i].setVisible(false);
			panValidation[i].setVisible(false); 
			panValidNorm[i].setVisible(false);
			panValidRat[i].setVisible(false);
			panValidComp[i].setVisible(false);
			panParUe[i].setVisible(false);
			DataBase.Master(mention,modelMaster);
			DataBase.act_diplome(mention,modelListMaster,"S5","S10");
			resultMas.setText(modelMaster.getRowCount()+" etudiant(s) validé(s) la semestre S10" );
			resultListMas.setText(modelListMaster.getRowCount()+" etudiant(s) obtenue(s) le diplome MASTER 2" );
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
			lab.setPreferredSize(new Dimension(280,20));
			lab.setBorder(null);
			String status=String.valueOf(tableDelib[i].getValueAt(row,0));
			lab.setText(String.valueOf(value).toLowerCase());
			if(!status.equals("")) {
				lab.setBackground(new Color(216,216,216));
				lab.setForeground(Color.black);
			}
			return lab;
		}
	}
		
	public   class validLicence implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			int option = JOptionPane.showConfirmDialog(pan,"Voulez-vous valider ?","ATTENTION!",
			JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE);
			if(option == JOptionPane.OK_OPTION){	
			for(int k=0;k<modelLicence.getRowCount();k++)
			DataBase.modif_diplome((String)modelLicence.getValueAt(k,0),String.valueOf(modelLicence.getValueAt(k,2)));
			JOptionPane.showMessageDialog(pan,"Opération terminé","",JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
	}
	
	public   class validMaster implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int option = JOptionPane.showConfirmDialog(pan,"Voulez-vous valider ?","ATTENTION!",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);
					if(option == JOptionPane.OK_OPTION){	
					for(int k=0;k<modelLicence.getRowCount();k++)
					DataBase.modif_diplome((String)modelLicence.getValueAt(k,0),String.valueOf(modelLicence.getValueAt(k,2)));
					JOptionPane.showMessageDialog(pan,"Opération terminé","",JOptionPane.INFORMATION_MESSAGE);
					}
			
		   }
		}
	
	public   class ActLicence implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			DataBase.act_diplome(mention,modelListLicence,"S5","S6");
			resultListLic.setText(modelListLicence.getRowCount()+" etudiant(s) obtenue(s) le diplome LICENCE" );
		}
	}
	
	public   class ActMaster implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			DataBase.act_diplome(mention,modelListMaster,"S9","S10");
			resultListMas.setText(modelListMaster.getRowCount()+" etudiant(s) obtenue(s) le diplome MASTER" );
		}
	}
	
	public boolean testDouble(String num) {
		boolean rep=false;
		if(num.length()!=0) {
			try {
			Double.parseDouble(num);
			rep=true;
			}catch(Exception e) {
				JOptionPane.showMessageDialog(pan,"Entrer une valeur numerique","",JOptionPane.INFORMATION_MESSAGE);
			}
		}else {
			JOptionPane.showMessageDialog(pan,"Champ vide","",JOptionPane.INFORMATION_MESSAGE);
		}
		return rep;
	}
}
	
	






