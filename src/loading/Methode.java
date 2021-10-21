package loading;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import data_base.DataBase;
import image.ImageBonneQualite;
import login.LoginPrincipale;

public class Methode {


	public static String finitText(String text) {
		
		String vide = "";
		
		if(!text.equals("")) {
			text=text.trim();
		 vide=text.substring(0,1).toUpperCase();
			for (int i=1;i<=text.length()-1; i++) {
				if(text.substring(i,i+1).equals(" ")) {
					vide +=" "+ text.substring(i+1,i+2).toUpperCase();
					i=i+1;
				}
				else
					vide += text.substring(i,i+1).toLowerCase();
			}
			return vide;
	}
		return vide;
	}
public static String finitTextLab(String text) {
		
		String vide = "";
		
		if(!text.equals("")) {
			text=text.trim();
		 vide=text.substring(0,1).toUpperCase();
			for (int i=1;i<=text.length()-1; i++) {
				if(text.substring(i,i+1).equals(" ")) {
					vide +="&nbsp;"+ text.substring(i+1,i+2).toUpperCase();
					i=i+1;
				}
				else
					vide += text.substring(i,i+1).toLowerCase();
			}
			return vide;
	}
		return vide;
	}
	
public static String finit(String text,int k) {
		
		String vide = "";
		
		if(!text.equals("")) {
			text=text.trim();
		 vide=text.substring(0,1).toUpperCase();
			for (int i=1;i<=text.length()-1; i++) {
				if(text.substring(i,i+1).equals("_")) {
					vide +=" "+ text.substring(i+1,i+2);
					i=i+1;
				}
				else
					vide += text.substring(i,i+1).toLowerCase();
			}
			int l=vide.length();
			if(k<9)
				vide=vide.substring(0, l-3);
			else
				vide=vide.substring(0, l-4);
			//return vide;
	}
		
	return vide.toUpperCase();
	}

public static String finitBack(String text) {
	
	String vide = "";
	
	if(!text.equals("")) {
		text=text.trim();
	 vide=text.substring(0,1).toUpperCase();
		for (int i=1;i<=text.length()-1; i++) {
			if(text.substring(i,i+1).equals(" ")) {
				vide +="_"+ text.substring(i+1,i+2);
				i=i+1;
			}
			else
				vide += text.substring(i,i+1).toLowerCase();
		}
}
	
return vide;
}
 
 public static void creerReprrtoire() {		
		File p=new File("C:","\\Photo_Sciences");
		File p1=new File("C:\\Photo_Sciences","\\"+DataBase.database+"");
		File p2=new File("C:\\Photo_Sciences\\utilisateur");
		
		p.mkdir();
		p1.mkdir();
		p2.mkdir();
					
}
 
 public static String SemsPetit(JCheckBox S[]) {
	 int k[];
	 String l="";
	 k=new int[2];
	 int j=0;
	 int nbr=0;
	 for (int i=0; i<S.length;i++) {
			if(S[i].isSelected()) {
				k[j]=i;
				nbr++;
				j++;
			}
 }
	 if(nbr!=1) {
	 if (k[0]<k[1])
		 l=S[ k[0]].getText();
	  else 
		 l=S[ k[1]].getText();
	 }
	 return l;
	
 }
 
 public static String SemsGrand(JCheckBox S[]) {
	 int k[];
	 String l="";
	 k=new int[2];
	 int j=0;
	 for (int i=0; i<S.length;i++) {
			if(S[i].isSelected()) {
				k[j]=i;
				j++;
			}
 }
	 if (k[1]<k[0])
		 l=S[k[0]].getText();
	 else
		 l=S[k[1]].getText();
	 return l;
	
 }
 
 public static boolean testAnne() {
	 boolean k=false;
	 if(!LoginPrincipale.anneTxt.getText().equals("____-____")) {
		 int l=Integer.parseInt(LoginPrincipale.anneTxt.getText().substring(5,9))-
				 Integer.parseInt(LoginPrincipale.anneTxt.getText().substring(0,4));
		 if(l==1)
			 k=true;
	 }
	 return k;
}
 
 public static String dateText(String date) {
	 String dtext="invalide date";
	 String mois;
	 int maxJour;
	 int maxMois;
	 int moisI;
	 int joursI;
	 int anneI;
	 if(!date.equals("__ /__ /____")) {
		 maxMois=12;
		 
		 joursI=Integer.parseInt(date.substring(0,2));
		  moisI=Integer.parseInt(date.substring(4,6));
		  anneI=Integer.parseInt(date.substring(8,12));
		 if(moisI<8) {
			 if(moisI%2!=0)
				 maxJour=31;
			 else {
				 if(moisI==2) {
					 if(anneI%4==0)
						 maxJour=29;
					 else
						 maxJour=28;
				 }else {
					maxJour=30; 
				 }
				 
			 }
		 }else {
			 if(moisI%2==0)
				 maxJour=31;
			 else 
				 maxJour=30; 
		}
		  
		 if( joursI<=maxJour && moisI<=maxMois ) {
		  switch(moisI) {
		  case 01:
			  mois="Janvier";
			  if(joursI<10)
			  dtext="0"+joursI+" "+mois+" "+anneI;
			  else
				  dtext=joursI+" "+mois+" "+anneI;
			  break;
		  case 02:
			  mois="Fevrier";
			  if(joursI<10)
				  dtext="0"+joursI+" "+mois+" "+anneI;
				  else
					  dtext=joursI+" "+mois+" "+anneI;
			  break;
		  case 03:
			  mois="Mars";
			  if(joursI<10)
				  dtext="0"+joursI+" "+mois+" "+anneI;
				  else
					  dtext=joursI+" "+mois+" "+anneI;
			  break;
		  case 04:
			  mois="Avril";
			  if(joursI<10)
				  dtext="0"+joursI+" "+mois+" "+anneI;
				  else
					  dtext=joursI+" "+mois+" "+anneI;
			  break;
		  case 05:
			  mois="Mai";
			  if(joursI<10)
				  dtext="0"+joursI+" "+mois+" "+anneI;
				  else
					  dtext=joursI+" "+mois+" "+anneI;
			  break;
		  case 06:
			  mois="Juin";
			  if(joursI<10)
				  dtext="0"+joursI+" "+mois+" "+anneI;
				  else
					  dtext=joursI+" "+mois+" "+anneI;
			  break;
		  case 07:
			  mois="Julliet";
			  if(joursI<10)
				  dtext="0"+joursI+" "+mois+" "+anneI;
				  else
					  dtext=joursI+" "+mois+" "+anneI;
			  break;
		  case 8:
			  mois="Aout";
			  		if(joursI<10)
				  		dtext="0"+joursI+" "+mois+" "+anneI;
				  	else
					  	dtext=joursI+" "+mois+" "+anneI;
			  break;
		  case 9:
			  mois="Septembre";
			  		if(joursI<10)
			  			dtext="0"+joursI+" "+mois+" "+anneI;
			  		else
			  			dtext=joursI+" "+mois+" "+anneI;
			  break;
		  case 10:
			  mois="Octobre";
			  		if(joursI<10)
			  			dtext="0"+joursI+" "+mois+" "+anneI;
			  		else
			  			dtext=joursI+" "+mois+" "+anneI;
			  break;	
		  case 11:
			  mois="Novembre";
			  		if(joursI<10)
				  	  dtext="0"+joursI+" "+mois+" "+anneI;
			  		else
					  dtext=joursI+" "+mois+" "+anneI;
			  break;
		  case 12:
			  mois="Décembre";
			  	  if(joursI<10)
			  		  dtext="0"+joursI+" "+mois+" "+anneI;
				  else
					  dtext=joursI+" "+mois+" "+anneI;
			  break;
		  }
	 }
		 
	 }
	 
	 return dtext;
 }
 
 public static boolean isNumeric(String str) {
	 boolean test=false;
	 if(str.length()!=0) {
	 try {
		 
		 if(DataBase.verificNum(str))
		 test=true;
	 }catch (NumberFormatException e) {
		 JOptionPane.showMessageDialog(Main.main, "Numero de Carte invalide", "ERREUR",
					JOptionPane.ERROR_MESSAGE);
		test=false;
	}
	 }else
		 JOptionPane.showMessageDialog(Main.main, "inserez le numero de carte", "ERREUR",
					JOptionPane.ERROR_MESSAGE);
	 return test;
	 
 }
 
 public static boolean isNumericIns(String str) {
	 boolean test=false;
	 if(str.length()!=0){
	 try {
		 if(DataBase.verificNumIns(str))
		 test=true;
	 }catch (NumberFormatException e) {
		 JOptionPane.showMessageDialog(Main.main, "Numéro d'inscription invalide", "ERREUR",
					JOptionPane.ERROR_MESSAGE);
		test=false;
	}
	 }else
		 JOptionPane.showMessageDialog(Main.main, "Inserer le numéro d'inscription", "ERREUR",
					JOptionPane.ERROR_MESSAGE);
	 return test;
	 
 }
 
 public static boolean valide(String mention,String num,JComboBox<String> typeEt,
		 JComboBox<String> typeSexe,JComboBox<String> typeNation,
		 JTextField nomTxt,JTextField dateNaisTxt,JTextField lieuNaissTxt,JTextField adresseTxt
		 ,JTextField numCinTxt,JTextField dateCinTxt,JTextField lieuCinTxt,JTextField montantTxt
		 ,JTextField numQuitTxt,JTextField dateQuitTxt) {
	 boolean val=false;
	 if(isNumeric(num)) {
	 if(typeEt.getSelectedIndex()!=-1) {
	 if(typeSexe.getSelectedIndex()!=0) {
	 if(typeNation.getSelectedIndex()!=0) {
	 if(nomTxt.getText().length()!=0) {
	 if(!dateNaisTxt.getText().equals("__ /__ /____")) {
	 if(!dateText(dateNaisTxt.getText()).equals("invalide date")) {
	 if(lieuNaissTxt.getText().length()!=0) {
	 if(adresseTxt.getText().length()!=0) {
	 if(!numCinTxt.getText().equals("___ ___ ___ ___")) {
	 if(!dateCinTxt.getText().equals("__ /__ /____")) {
	 if(!dateText(dateCinTxt.getText()).equals("invalide date")) {
	 if(lieuCinTxt.getText().length()!=0) {
	 if(montantTxt.getText().length()!=0) {
	 if(numQuitTxt.getText().length()!=0) {
	 if(!dateQuitTxt.getText().equals("__ /__ /____")) {
	 if(!dateText(dateQuitTxt.getText()).equals("invalide date")) {
		 val=true;
	 }else JOptionPane.showMessageDialog(Main.main, " date de quitus Invalide ", 
			"ERREUR",JOptionPane.ERROR_MESSAGE);
	 }else JOptionPane.showMessageDialog(Main.main, "Entrer la date de quitus", 
															 "ERREUR",JOptionPane.ERROR_MESSAGE);
	 }else JOptionPane.showMessageDialog(Main.main, "Entrer le numero de quitus", 
														 "ERREUR",JOptionPane.ERROR_MESSAGE);
	 }else JOptionPane.showMessageDialog(Main.main, "Entrer le Montant ", 
														 "ERREUR",JOptionPane.ERROR_MESSAGE);
	 }else JOptionPane.showMessageDialog(Main.main, " Lieu CIN absente ", 
													 "ERREUR",JOptionPane.ERROR_MESSAGE);
	 }else JOptionPane.showMessageDialog(Main.main, " Invalide date CIN ", 
												 "ERREUR",JOptionPane.ERROR_MESSAGE);
	 }else JOptionPane.showMessageDialog(Main.main, "Entrer la date du CIN ", 
											 "ERREUR",JOptionPane.ERROR_MESSAGE);
	 }else {
		 if(montantTxt.getText().length()!=0) {
		 if(numQuitTxt.getText().length()!=0) {
		 if(!dateQuitTxt.getText().equals("__ /__ /____")) {
		 if(!dateText(dateQuitTxt.getText()).equals("invalide date")) {
				 val=true;
		 }else JOptionPane.showMessageDialog(Main.main, " date de quitus Invalide ", 
														 "ERREUR",JOptionPane.ERROR_MESSAGE);
		 }else JOptionPane.showMessageDialog(Main.main, "Entrer la date de quitus", 
													 "ERREUR",JOptionPane.ERROR_MESSAGE);
		 }else JOptionPane.showMessageDialog(Main.main, "Entrer le numero de quitus", 
												 "ERREUR",JOptionPane.ERROR_MESSAGE);
		 }else JOptionPane.showMessageDialog(Main.main, "Entrer le Montant ", 
												 "ERREUR",JOptionPane.ERROR_MESSAGE);
	 }
							 
							 
 }else JOptionPane.showMessageDialog(Main.main, " Choisir l'addresse ", 
										 "ERREUR",JOptionPane.ERROR_MESSAGE);
 }else JOptionPane.showMessageDialog(Main.main, "Lieu de Naissance Vide ", "ERREUR",
										JOptionPane.ERROR_MESSAGE);
 }else JOptionPane.showMessageDialog(Main.main, "date de Naissance Invalide ", "ERREUR",
									JOptionPane.ERROR_MESSAGE);
 }else JOptionPane.showMessageDialog(Main.main, "Entrer la date de Naissance ", "ERREUR",
								JOptionPane.ERROR_MESSAGE);
 }else JOptionPane.showMessageDialog(Main.main, "Entre le Nom de l'etudiant ", "ERREUR",
							JOptionPane.ERROR_MESSAGE); 
 }else JOptionPane.showMessageDialog(Main.main, "Choisir le Nationalité ", "ERREUR",
				JOptionPane.ERROR_MESSAGE); 
 }else JOptionPane.showMessageDialog(Main.main, "Choisir le Sexe", "ERREUR",
				JOptionPane.ERROR_MESSAGE); 
 }else JOptionPane.showMessageDialog(Main.main, "Choisir le Parcours", "ERREUR",
						JOptionPane.ERROR_MESSAGE); 
 }else  
    {
		 val=false; 
	 }
		 
	 return val;
}
 
 public static boolean valide1(String mention,String num,JComboBox<String> typeEt,
		 JTextField nomTxt,JTextField dateNaisTxt,JTextField lieuNaissTxt,JTextField adresseTxt
		 ,JTextField numCinTxt,JTextField dateCinTxt,JTextField lieuCinTxt,JTextField montantTxt
		 ,JTextField numQuitTxt,JTextField dateQuitTxt) {
	 boolean val=false;
	 if(typeEt.getSelectedIndex()!=-1) {
	 if(nomTxt.getText().length()!=0) {
	 if(!dateNaisTxt.getText().equals("__ /__ /____")) {
	 if(!dateText(dateNaisTxt.getText()).equals("invalide date")) {
	 if(lieuNaissTxt.getText().length()!=0) {
	 if(adresseTxt.getText().length()!=0) {
	 if(!numCinTxt.getText().equals("___ ___ ___ ___")) {
	 if(!dateCinTxt.getText().equals("__ /__ /____")) {
	 if(!dateText(dateCinTxt.getText()).equals("invalide date")) {
	 if(lieuCinTxt.getText().length()!=0) {
	 if(montantTxt.getText().length()!=0) {
	 if(numQuitTxt.getText().length()!=0) {
	 if(!dateQuitTxt.getText().equals("__ /__ /____")) {
	 if(!dateText(dateQuitTxt.getText()).equals("invalide date")) {
		 val=true;
	 }else JOptionPane.showMessageDialog(Main.main, " date de quitus Invalide ", 
			"ERREUR",JOptionPane.ERROR_MESSAGE);
	 }else JOptionPane.showMessageDialog(Main.main, "Entrer la date de quitus", 
															 "ERREUR",JOptionPane.ERROR_MESSAGE);
	 }else JOptionPane.showMessageDialog(Main.main, "Entrer le numero de quitus", 
														 "ERREUR",JOptionPane.ERROR_MESSAGE);
	 }else JOptionPane.showMessageDialog(Main.main, "Entrer le Montant ", 
														 "ERREUR",JOptionPane.ERROR_MESSAGE);
	 }else JOptionPane.showMessageDialog(Main.main, " Lieu CIN absente ", 
													 "ERREUR",JOptionPane.ERROR_MESSAGE);
	 }else JOptionPane.showMessageDialog(Main.main, " Invalide date CIN ", 
												 "ERREUR",JOptionPane.ERROR_MESSAGE);
	 }else JOptionPane.showMessageDialog(Main.main, "Entrer la date du CIN ", 
											 "ERREUR",JOptionPane.ERROR_MESSAGE);
	 }else {
		 if(montantTxt.getText().length()!=0) {
		 if(numQuitTxt.getText().length()!=0) {
		 if(!dateQuitTxt.getText().equals("__ /__ /____")) {
		 if(!dateText(dateQuitTxt.getText()).equals("invalide date")) {
				 val=true;
		 }else JOptionPane.showMessageDialog(Main.main, " date de quitus Invalide ", 
														 "ERREUR",JOptionPane.ERROR_MESSAGE);
		 }else JOptionPane.showMessageDialog(Main.main, "Entrer la date de quitus", 
													 "ERREUR",JOptionPane.ERROR_MESSAGE);
		 }else JOptionPane.showMessageDialog(Main.main, "Entrer le numero de quitus", 
												 "ERREUR",JOptionPane.ERROR_MESSAGE);
		 }else JOptionPane.showMessageDialog(Main.main, "Entrer le Montant ", 
												 "ERREUR",JOptionPane.ERROR_MESSAGE);
	 }
							 
							 
 }else JOptionPane.showMessageDialog(Main.main, " Choisir l'addresse ", 
										 "ERREUR",JOptionPane.ERROR_MESSAGE);
 }else JOptionPane.showMessageDialog(Main.main, "Lieu de Naissance Vide ", "ERREUR",
										JOptionPane.ERROR_MESSAGE);
 }else JOptionPane.showMessageDialog(Main.main, "date de Naissance Invalide ", "ERREUR",
									JOptionPane.ERROR_MESSAGE);
 }else JOptionPane.showMessageDialog(Main.main, "Entrer la date de Naissance ", "ERREUR",
								JOptionPane.ERROR_MESSAGE);
 }else JOptionPane.showMessageDialog(Main.main, "Entrer le Nom de l'étudiant ", "ERREUR",
							JOptionPane.ERROR_MESSAGE); 
 }else JOptionPane.showMessageDialog(Main.main, "Choisir le Parcours", "ERREUR",
						JOptionPane.ERROR_MESSAGE); 
		 
	 return val;
}
 
 public static void enable(JTextField tabField[],JTextField num,JComboBox<String> typeEt) {
		for(int i=0;i<tabField.length;i++) {
			tabField[i].setEditable(true);
		}
			num.setEditable(true);
			typeEt.setEnabled(true);
	}
 
 public static void desable(JTextField tabField[],JTextField num,JComboBox<String> typeEt) {
		for(int i=0;i<tabField.length;i++) {
			tabField[i].setEditable(false);
		}
			num.setEditable(false);
			typeEt.setEnabled(false);
	}
 
 public static String getNomEt(JTable tab) {
		int ligne= tab.getSelectedRow();
		String num= (String) tab.getValueAt(ligne, 1);
		return num;
		
	}
 
 public static String getNomIns(JTable tab) {
		int ligne= tab.getSelectedRow();
		String num= (String) tab.getValueAt(ligne, 0);
		return num;
		
	}
 
 public static String getNom(JTable tab) {
		int ligne= tab.getSelectedRow();
		String num= String.valueOf((String) tab.getValueAt(ligne, 0));
		return num;
		
	}
	
	public static int getNum1(int i,JTable tab) {
		int num= Integer.parseInt((String) tab.getValueAt(i, 1));
		return num;
		
	}
 
 
 public static void renitial1(JTextField tabField[],JTextField num,JComboBox<String> typeEt
		 ,JButton mod,JButton supp,JButton enregmod,JButton enreg,JTable table[],JCheckBox S[],JLabel image,JCheckBox chek[]
				 ,JComboBox<String> sexe ,JComboBox<String> nation, JLabel vide1) {
		for(int i=0;i<tabField.length;i++) {
			tabField[i].setText("");
		}
			num.setText("");
			typeEt.setSelectedIndex(0);
			mod.setVisible(false);
			supp.setVisible(false);
			enregmod.setVisible(false);
			enreg.setVisible(true);
			sexe.setSelectedIndex(0);
			nation.setSelectedIndex(0);
			vide1.setText("");
			for(int i=0;i<table.length;i++) {
				table[i].clearSelection();
			}
			
			for(int i=0;i<chek.length;i++) {
				chek[i].setEnabled(true);
			}
			for(int i=0;i<S.length;i++) {
				S[i].setSelected(false);
				S[i].setVisible(true);
				S[i].setEnabled(false);
			}
				
			image.setIcon(new ImageIcon((Image)ImageBonneQualite.scaleImage(120, 120,"/profil.png")));
			}
 
 @SuppressWarnings("rawtypes")
public static void renitial(JTextField txtTab1[],JTextField numBaccTxt,JTextField numTelTxt,JTextField dateNaisTxt
		 ,JTextField numTxt,JTextField numCintTxt,JTextField montantTxt,JTextField numQuitTxt,JTextField dateQuitTxt,JComboBox serieBox
		 ,JComboBox situationBox,JComboBox nationBox,JComboBox anneBox,JComboBox sexeBox,JComboBox typeEt
		 ,JComboBox typefilComb,JLabel fil,JTable table,JTextField txtTab2[],JTextField txtTab3[],JLabel image) {
		for(int i=0;i<txtTab1.length;i++) {
			txtTab1[i].setText("");
		}
			numBaccTxt.setText("");
			numTelTxt.setText("");
			dateNaisTxt.setText("");
			numTxt.setText("");
			montantTxt.setText("");
			numQuitTxt.setText("");
			dateQuitTxt.setText("");
			serieBox.setSelectedIndex(0);
			situationBox.setSelectedIndex(0);
			nationBox.setSelectedIndex(0);
			anneBox.setSelectedIndex(0);
			sexeBox.setSelectedIndex(0);
			typeEt.setSelectedIndex(0);
			typefilComb.setSelectedIndex(0);
			fil.setVisible(false);
			typefilComb.setVisible(false);
			table.clearSelection();
			
		for(int i=0;i<txtTab2.length;i++) {
			txtTab2[i].setText("");
			}
		for(int i=0;i<txtTab3.length;i++) {
			txtTab3[i].setText("");
			numCintTxt.setText("");
			}
		image.setIcon(new ImageIcon((Image)ImageBonneQualite.scaleImage(120, 120,"/profil.png")));
		
	}
 
 @SuppressWarnings("rawtypes")
public static void desable1(JTextField txtTab1[],JTextField numBaccTxt,JTextField numTelTxt,JTextField dateNaisTxt
		 ,JTextField numTxt,JTextField numCinTxt,JTextField montantTxt,JTextField numQuitTxt,JTextField dateQuitTxt,JComboBox serieBox
		 ,JComboBox situationBox,JComboBox nationBox,JComboBox anneBox,JComboBox sexeBox,JComboBox typeEt
		 ,JComboBox typefilComb,JTextField txtTab2[],JTextField txtTab3[]) {
		for(int i=0;i<txtTab1.length;i++) {
			txtTab1[i].setEditable(false);
		}
		for(int i=0;i<txtTab2.length;i++) {
			txtTab2[i].setEditable(false);
		}
		for(int i=0;i<txtTab3.length;i++) {
			txtTab3[i].setEditable(false);
		}
		numCinTxt.setEditable(false);
		numBaccTxt.setEditable(false);
		numTelTxt.setEditable(false);
		dateNaisTxt.setEditable(false);
		numTxt.setEditable(false);
		montantTxt.setEditable(false);
		numQuitTxt.setEditable(false);
		dateQuitTxt.setEditable(false);
		serieBox.setEnabled(false);
		situationBox.setEnabled(false);
		nationBox.setEnabled(false);
		anneBox.setEnabled(false);
		sexeBox.setEnabled(false);
		typeEt.setEnabled(false);
		typefilComb.setEnabled(false);
	}
	
	@SuppressWarnings("rawtypes")
	public static void enable1(JTextField txtTab1[],JTextField numBaccTxt,JTextField numTelTxt,JTextField dateNaisTxt
			 ,JTextField numTxt,JTextField numCinTxt,JTextField montantTxt,JTextField numQuitTxt,JTextField dateQuitTxt,JComboBox serieBox
			 ,JComboBox situationBox,JComboBox nationBox,JComboBox anneBox,JComboBox sexeBox,JComboBox typeEt
			 ,JComboBox typefilComb,JTextField txtTab2[],JTextField txtTab3[]) {
		for(int i=0;i<txtTab1.length;i++) {
			txtTab1[i].setEditable(true);
		}
		for(int i=0;i<txtTab2.length;i++) {
			txtTab2[i].setEditable(true);
		}
		for(int i=0;i<txtTab3.length;i++) {
			txtTab3[i].setEditable(true);
		}
		numCinTxt.setEditable(true);
		numBaccTxt.setEditable(true);
		numTelTxt.setEditable(true);
		dateNaisTxt.setEditable(true);
		numTxt.setEditable(true);
		montantTxt.setEditable(true);
		numQuitTxt.setEditable(true);
		dateQuitTxt.setEditable(true);
		serieBox.setEnabled(true);
		situationBox.setEnabled(true);
		nationBox.setEnabled(true);
		anneBox.setEnabled(true);
		sexeBox.setEnabled(true);
		typeEt.setEnabled(true);
		typefilComb.setEnabled(true);
	}
	
	public static boolean valideIns(String mention,String num,JComboBox<String> typeEt,
			 JTextField nomEtTxt,JTextField dateNaisTxt,JTextField lieuNaissTxt,JTextField adresseEtTxt
			 ,JTextField numCinTxt,JTextField dateCinTxt,JTextField lieuCinTxt,JTextField montantTxt
			 ,JTextField numQuitTxt,JTextField dateQuitTxt) {
		 boolean val=false;

		 if(isNumericIns(num)) {
		 if(typeEt.getSelectedIndex()!=0) {
		 if(nomEtTxt.getText().length()!=0) {
		 if(!dateNaisTxt.getText().equals("__ /__ /____")) {
		 if(!dateText(dateNaisTxt.getText()).equals("invalide date")) {
		 if(lieuNaissTxt.getText().length()!=0) {
		 if(adresseEtTxt.getText().length()!=0) {
		 if(!numCinTxt.getText().equals("___ ___ ___ ___")) {
		 if(!dateCinTxt.getText().equals("__ /__ /____")) {
		 if(!dateText(dateCinTxt.getText()).equals("invalide date")) {
		 if(lieuCinTxt.getText().length()!=0) {
		 if(montantTxt.getText().length()!=0) {
		 if(numQuitTxt.getText().length()!=0) {
		 if(!dateQuitTxt.getText().equals("__ /__ /____")) {
		 if(!dateText(dateQuitTxt.getText()).equals("invalide date")) {
			 val=true;
		 }else JOptionPane.showMessageDialog(Main.main, " date de quitus Invalide ", 
				"ERREUR",JOptionPane.ERROR_MESSAGE);
		 }else JOptionPane.showMessageDialog(Main.main, "Entrer la date de quitus", 
																 "ERREUR",JOptionPane.ERROR_MESSAGE);
		 }else JOptionPane.showMessageDialog(Main.main, "Entrer le numero de quitus", 
															 "ERREUR",JOptionPane.ERROR_MESSAGE);
		 }else JOptionPane.showMessageDialog(Main.main, "Entrer le Montant ", 
															 "ERREUR",JOptionPane.ERROR_MESSAGE);
		 }else JOptionPane.showMessageDialog(Main.main, " Lieu CIN absente ", 
														 "ERREUR",JOptionPane.ERROR_MESSAGE);
		 }else JOptionPane.showMessageDialog(Main.main, " Invalide date CIN ", 
													 "ERREUR",JOptionPane.ERROR_MESSAGE);
		 }else JOptionPane.showMessageDialog(Main.main, "Entrer la date du CIN ", 
												 "ERREUR",JOptionPane.ERROR_MESSAGE);
		 }else {
			 if(montantTxt.getText().length()!=0) {
			 if(numQuitTxt.getText().length()!=0) {
			 if(!dateQuitTxt.getText().equals("__ /__ /____")) {
			 if(!dateText(dateQuitTxt.getText()).equals("invalide date")) {
					 val=true;
			 }else JOptionPane.showMessageDialog(Main.main, " date de quitus Invalide ", 
															 "ERREUR",JOptionPane.ERROR_MESSAGE);
			 }else JOptionPane.showMessageDialog(Main.main, "Entrer la date de quitus", 
														 "ERREUR",JOptionPane.ERROR_MESSAGE);
			 }else JOptionPane.showMessageDialog(Main.main, "Entrer le numero de quitus", 
													 "ERREUR",JOptionPane.ERROR_MESSAGE);
			 }else JOptionPane.showMessageDialog(Main.main, "Entrer le Montant ", 
													 "ERREUR",JOptionPane.ERROR_MESSAGE);
		 }
								 
								 
	 }else JOptionPane.showMessageDialog(Main.main, " Choisir l'addresse ", 
											 "ERREUR",JOptionPane.ERROR_MESSAGE);
	 }else JOptionPane.showMessageDialog(Main.main, "Lieu de Naissance Vide ", "ERREUR",
											JOptionPane.ERROR_MESSAGE);
	 }else JOptionPane.showMessageDialog(Main.main, "date de Naissance Invalide ", "ERREUR",
										JOptionPane.ERROR_MESSAGE);
	 }else JOptionPane.showMessageDialog(Main.main, "Entrer la date de Naissance ", "ERREUR",
									JOptionPane.ERROR_MESSAGE);
	 }else JOptionPane.showMessageDialog(Main.main, "Entre le Nom de l'etudiant ", "ERREUR",
								JOptionPane.ERROR_MESSAGE); 
	 }else JOptionPane.showMessageDialog(Main.main, "Choisir le Niveau", "ERREUR",
							JOptionPane.ERROR_MESSAGE); 
		 }	 
		 return val;
}
	
	 
	 public static boolean valideIns1(String mention,String num,JComboBox<String> typeEt,
			 JTextField nomEtTxt,JTextField dateNaisTxt,JTextField lieuNaissTxt,JTextField adresseEtTxt
			 ,JTextField numCinTxt,JTextField dateCinTxt,JTextField lieuCinTxt,JTextField montantTxt
			 ,JTextField numQuitTxt,JTextField dateQuitTxt) {
		 boolean val=false;

		 if(typeEt.getSelectedIndex()!=0) {
		 if(nomEtTxt.getText().length()!=0) {
		 if(!dateNaisTxt.getText().equals("__ /__ /____")) {
		 if(!dateText(dateNaisTxt.getText()).equals("invalide date")) {
		 if(lieuNaissTxt.getText().length()!=0) {
		 if(adresseEtTxt.getText().length()!=0) {
		 if(!numCinTxt.getText().equals("___ ___ ___ ___")) {
		 if(!dateCinTxt.getText().equals("__ /__ /____")) {
		 if(!dateText(dateCinTxt.getText()).equals("invalide date")) {
		 if(lieuCinTxt.getText().length()!=0) {
		 if(montantTxt.getText().length()!=0) {
		 if(numQuitTxt.getText().length()!=0) {
		 if(!dateQuitTxt.getText().equals("__ /__ /____")) {
		 if(!dateText(dateQuitTxt.getText()).equals("invalide date")) {
			 val=true;
		 }else JOptionPane.showMessageDialog(Main.main, " date de quitus Invalide ", 
				"ERREUR",JOptionPane.ERROR_MESSAGE);
		 }else JOptionPane.showMessageDialog(Main.main, "Entrer la date de quitus", 
																 "ERREUR",JOptionPane.ERROR_MESSAGE);
		 }else JOptionPane.showMessageDialog(Main.main, "Entrer le numero de quitus", 
															 "ERREUR",JOptionPane.ERROR_MESSAGE);
		 }else JOptionPane.showMessageDialog(Main.main, "Entrer le Montant ", 
															 "ERREUR",JOptionPane.ERROR_MESSAGE);
		 }else JOptionPane.showMessageDialog(Main.main, " Lieu CIN absente ", 
														 "ERREUR",JOptionPane.ERROR_MESSAGE);
		 }else JOptionPane.showMessageDialog(Main.main, " Invalide date CIN ", 
													 "ERREUR",JOptionPane.ERROR_MESSAGE);
		 }else JOptionPane.showMessageDialog(Main.main, "Entrer la date du CIN ", 
												 "ERREUR",JOptionPane.ERROR_MESSAGE);
		 }else {
			 if(montantTxt.getText().length()!=0) {
			 if(numQuitTxt.getText().length()!=0) {
			 if(!dateQuitTxt.getText().equals("__ /__ /____")) {
			 if(!dateText(dateQuitTxt.getText()).equals("invalide date")) {
					 val=true;
			 }else JOptionPane.showMessageDialog(Main.main, " date de quitus Invalide ", 
															 "ERREUR",JOptionPane.ERROR_MESSAGE);
			 }else JOptionPane.showMessageDialog(Main.main, "Entrer la date de quitus", 
														 "ERREUR",JOptionPane.ERROR_MESSAGE);
			 }else JOptionPane.showMessageDialog(Main.main, "Entrer le numero de quitus", 
													 "ERREUR",JOptionPane.ERROR_MESSAGE);
			 }else JOptionPane.showMessageDialog(Main.main, "Entrer le Montant ", 
													 "ERREUR",JOptionPane.ERROR_MESSAGE);
		 }
								 
								 
	 }else JOptionPane.showMessageDialog(Main.main, " Choisir l'addresse ", 
											 "ERREUR",JOptionPane.ERROR_MESSAGE);
	 }else JOptionPane.showMessageDialog(Main.main, "Lieu de Naissance Vide ", "ERREUR",
											JOptionPane.ERROR_MESSAGE);
	 }else JOptionPane.showMessageDialog(Main.main, "date de Naissance Invalide ", "ERREUR",
										JOptionPane.ERROR_MESSAGE);
	 }else JOptionPane.showMessageDialog(Main.main, "Entrer la date de Naissance ", "ERREUR",
									JOptionPane.ERROR_MESSAGE);
	 }else JOptionPane.showMessageDialog(Main.main, "Entre le Nom de l'etudiant ", "ERREUR",
								JOptionPane.ERROR_MESSAGE); 
	 }else JOptionPane.showMessageDialog(Main.main, "Choisir le Niveau", "ERREUR",
							JOptionPane.ERROR_MESSAGE); 
		 	 
		 return val;
}
	 
	 public static String dateTextInt(String date) {
			int n=date.length();
			String dtext="";
			String nouvDate=date;
			dtext=date.substring(3, n-5);
			String jours=date.substring(0,2);;
			String anne=date.substring(n-4, n);;
			
			 switch(dtext) {
			 case "Janvier": nouvDate=jours+" /01 /"+anne;
				 break;
			 case "Fevrier": nouvDate=jours+" /02 /"+anne;
				 break;
			 case "Mars": nouvDate=jours+" /03 /"+anne;
				 break;
			 case "Avril": nouvDate=jours+" /04 /"+anne;
				 break;
			 case "Mai": nouvDate=jours+" /05 /"+anne;
				 break;
			 case "Juin": nouvDate=jours+" /06 /"+anne;
				 break;
			 case "Julliet": nouvDate=jours+" /07 /"+anne;
				 break;
			 case "Aout": nouvDate=jours+" /08 /"+anne;
				 break;
			 case "Septembre": nouvDate=jours+" /09 /"+anne;
				 break;
			 case "Octobre": nouvDate=jours+" /10 /"+anne;
				 break;
			 case "Novembre": nouvDate=jours+" /11 /"+anne;
				 break;
			 case "Décembre": nouvDate=jours+" /12 /"+anne;
				 break;
			 }
			 return nouvDate;
		 }	 
	 
	 public static String numCarte(int debut,int rowCount) {
			int s=debut + rowCount;
			int k=String.valueOf(s).length();
			String num="";
			switch(k) {
			case 1:
				num="M00000"+s;
				break;
			case 2:
				num="M0000"+s;
				break;
			case 3:
				num="M000"+s;
				break;
			case 4:
				num="M00"+s;
				break;
			case 5:
				num="M0"+s;
				break;
			case 6:
				num="M"+s;
				break;
				
			}
			return num;
		}
	 public static String last_anne(String ans) {
			String anne="";
			int an1=Integer.valueOf(ans.substring(0,4))-1;
			int an2=Integer.valueOf(ans.substring(5,9))-1;
			anne=an1+"-"+an2;
			return anne;
		}
	 
	 public static String next_anne(String ans) {
			String anne="";
			int an1=Integer.valueOf(ans.substring(0,4))+1;
			int an2=Integer.valueOf(ans.substring(5,9))+1;
			anne=an1+"-"+an2;
			return anne;
		}
	 
	 public static void main(String [] arg) {
		 System.out.println(finit("langue_et_culture_tc",9));
	 }
		
	 /*********************************************************
	  * 						diplome								 *
	  *********************************************************/
	  
	 public static void desable2(JTextField txtTab1[],JTextField ane,JTextField num,
			 JComboBox<String> parcEt,JComboBox<String> mentEt,JComboBox<String> typeSexe) {
	 	 
	 	 for(int i=0;i<txtTab1.length;i++) {
	 			txtTab1[i].setEditable(false);
	 		}
	 	 ane.setEditable(false);
	 	 num.setEditable(false);
	 	 parcEt.setEnabled(false);
	 	 mentEt.setEnabled(false);
	 	 typeSexe.setEnabled(false);
	 }

	 public static boolean valideDiplome(String mention,String num,JComboBox<String> parcEt,
	 		 JTextField nomTxt,JComboBox<String> mentEt,JTextField anne) {
	 	 boolean val=false;
	 	 if(isNumeric(num)) {
	 	 if(parcEt.getSelectedIndex()!=-1) {
	 	 if(nomTxt.getText().length()!=0) {
	 	 if(mentEt.getSelectedIndex()!=-1) {
	 	 if(!anne.getText().equals("____-____")) {
	 		 val=true;
	 	 }else JOptionPane.showMessageDialog(Main.main, " Entrer l'année universitaire ", 
	 			"ERREUR",JOptionPane.ERROR_MESSAGE);
	 	 }else JOptionPane.showMessageDialog(Main.main, "Choisir la diplome", 
	 															 "ERREUR",JOptionPane.ERROR_MESSAGE);
	 	 }else JOptionPane.showMessageDialog(Main.main, "Entrer le nom de l'étudiant", 
	 														 "ERREUR",JOptionPane.ERROR_MESSAGE);
	 	 }else JOptionPane.showMessageDialog(Main.main, "Choisir le parcour ", 
	 														 "ERREUR",JOptionPane.ERROR_MESSAGE);
	 	 
	 	 }else {
	 		 val=false; 
	 	 }
	 		 
	 	 return val;
	 }

	 public static void enable2(JTextField tabField[],JTextField num,JComboBox<String> typeEt,JComboBox<String> mentEt,JTextField ane) {
	 		for(int i=0;i<tabField.length;i++) {
	 			tabField[i].setEditable(true);
	 		}
	 			num.setEditable(true);
	 			typeEt.setEnabled(true);
	 			mentEt.setEnabled(true);
	 			ane.setEnabled(true);
	 	}

	 public static void renitial2(JTextField tabField[],JTextField numTxt,JComboBox<String> parcEt
	 		 ,JButton mod,JButton annule,JButton enreg,JButton actual,JButton enregmod,JButton supp,JTable table[],JComboBox<String> mentEt,JTextField anne) {
	 		for(int i=0;i<tabField.length;i++) {
	 			tabField[i].setText("");
	 		}
	 			numTxt.setText("");
	 		
	 			parcEt.setSelectedIndex(0);
	 			mod.setVisible(false);
	 			annule.setVisible(true);
	 			enreg.setVisible(true);
	 			actual.setVisible(true);
	 			enregmod.setVisible(false);
	 			supp.setVisible(false);
	 			mentEt.setSelectedIndex(0);
	 			anne.setText("");
	 		for(int i=0;i<table.length;i++) {
	 			table[i].clearSelection();
	 		}
	 }
 }
				 



