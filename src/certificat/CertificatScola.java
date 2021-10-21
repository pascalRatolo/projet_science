package certificat;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import image.LoadImage;
import loading.Main;

@SuppressWarnings("serial")
public class CertificatScola extends JPanel { 
	
	public static JLabel titre;
	public static JLabel titre1;
	public static JLabel titre2;
	public static JLabel titre3;
	public static JLabel titre4;
	public static JTextArea text1;
	
	public static JPanel paneTab;
	
	public static Border line= new LineBorder(Color.black);
	public static Border  tite1= new TitledBorder(line,"",TitledBorder.DEFAULT_POSITION,
    		TitledBorder.DEFAULT_POSITION,new Font("arial",Font.BOLD,8),Color.black);
 
	public static Font police=new Font("arial",Font.BOLD,16);
	public static Font police1=new Font("arial",Font.ITALIC,10);
	
	public static JButton imp=new JButton (LoadImage.transformeb(100, 25, "/imprimer.jpg"));
	public static JFrame main= new JFrame();
	
	public static JScrollPane scrollPane ;
	public static String an;
	public static String nom;
	public static String prenom;
	public static String dateNaiss;
	public static String lieuNaiss;
	public static String clas;
	public static String num;
	public static String parcours;
	public static int j;
	public static String text;
	public static String ri;
	public static String numAt;
	String anne;
	String mention;
	public CertificatScola(String mention,int j,String an,String nom,String prenom,String dateNaiss,String lieuNaiss,String num,
			String parcours,String clas,String numAt) {
		CertificatScola.an=an;
		CertificatScola.nom=nom;
		CertificatScola.prenom=prenom;
		CertificatScola.dateNaiss=dateNaiss;
		CertificatScola.lieuNaiss=lieuNaiss;
		CertificatScola.num=num;
		CertificatScola.parcours=parcours;
		CertificatScola.clas=clas;
		CertificatScola.j=j;
		CertificatScola.numAt=numAt;
		this.mention=mention;
			switch(j) {
			case 1:
				text="A&nbsp;l'Universtité&nbsp;de&nbsp;Fianarantsoa,&nbsp;l'année&nbsp;Universitaire &nbsp<b>"+an+" </b>";
				titre2=new JLabel("<html> <div id='bloc_page'>"
				     	 + " <p STYLE='padding: 0 0 0 20px;'> <font face='Algerian' size='5'> "
				     	 + "<b> CERTIFICAT&nbsp;DE&nbsp;SCOLARITE </b> </font>  </p> "
		                 + " </div></html>");
				ri=an.substring(7,9);
				anne=Main.date2textField.getText().substring(8, 12);
				break;
			case 2:
				 text="a&nbsp;été&nbsp;assidue&nbsp;dépuis&nbsp;le&nbsp;"+dateText(an)+",&nbsp;date&nbsp;de&nbsp;"
				 		+ "la&nbsp;rentrée&nbsp;universitaire&nbsp;jusqu'à&nbsp;ce&nbsp;jour.";
				 titre2=new JLabel("<html> <div id='bloc_page'>"
				     	 + " <p STYLE='padding: 0 0 0 20px;'> <font face='Algerian' size='5'> "
				     	 + "<b> CERTIFICAT&nbsp;D'ASSIDUITE </b> </font>  </p> "
		                 + " </div></html>");
				 int f=an.length();
				 ri=an.substring(f-2,f);
				 anne=Main.date2textField.getText().substring(8, 12);
				break;
			}
			
			
			
		     titre=new JLabel("<html> <div id='bloc_page'>"
		     	 + " <p STYLE='padding: 0 0 0 105px;'> <font size='4'><b>REPOBLIKAN'I&nbsp;MADAGASIKARA</b> "
		     	 + "</p> </font>"
                 + "  <p STYLE='padding: 0 0 0 120px;'><i>"
                 + " <font face= 'courier' size='-4'> <b> Fitiavana - Tanindrazana - Fandrosoana </b> "
                 + "</font></i></p> "
                 + "<p STYLE='padding: 0 0 0 40px;'><i>"
                 + " <font  size='3'>Ministère de l'Enseignement Supérieur et de la Recherche Scientifique"
                 + ""
                 + "</font>"
                 + " </div></html>");
		     
		     titre1=new JLabel("<html> <div id='bloc_page'>"
			     	 + " <p STYLE='padding: 0 0 0 100px;'> <font size='4'><b>UNIVERSITE&nbsp;DE&nbsp;FIANARANTSOA</b> "
			     	 + " </font> "
			     	 + " </p> "
	                 + "  <p STYLE='padding: 0 0 0 127px;'><i>"
	                 + " <font face= 'arial' size='3'> <b>FACULTE&nbsp;DES&nbsp;SCIENCES</b> </font></i></p>"
	                 + "</font>"
	                 + "  <p STYLE='padding: 0 0 0 120px;'><i>"
	                 + " <font face= 'arial' size='3'> <b>N°"+numAt+"/"+anne+"/UF/FAC.S/S.SCO </b> </font></p>"
	                 + "</font>"
	                 + " </div></html>");
		     
		     
		     
		    
		     
		     titre3=new JLabel("<html> <div id='bloc_page'>"
			     	 + " <p STYLE='padding: 0 0 0 0px;'> <font face='arial' size='2.3'> "
			     	 + " Le&nbsp;DOYEN&nbsp;de&nbsp;la&nbsp;FACULTE&nbsp;des&nbsp;SCIENCES&nbsp;de&nbsp;L'Université"
			     	 + "&nbsp;de&nbsp;Fianarantsoa</font>  </p> "
			     	 + "<p STYLE='padding: 0 0 0 0px;'> <font face='arial' size='2.3'> "
			     	 + "Soussigné,&nbsp;Certifie&nbsp;que:  </font>  </p>"
			     	 + "<p></p>"
			     	 + "<p STYLE='padding: 0 0 0 0px;'> <font face='arial' size='2.3'> "
			     	 + " <b><u><i>Nom</i></u>:</b>&nbsp;"+nom+"  </font>  </p>"
			     	 + "<p></p>"
			     	 + "<p STYLE='padding: 0 0 0 0px;'> <font face='arial' size='2.3'> "
			     	 + " <b><u><i>Prénom</i></u>:</b>&nbsp;"+prenom+"  </font>  </p>"
			     	 + "<p></p>"
			     	 + "<p STYLE='padding: 0 0 0 0px;'> <font face='arial' size='2.3'> "
			     	 + " <b><u><i>Né(e) le</i></u>:</b>&nbsp;"+dateNaiss+" <b>à</b>&nbsp;"+lieuNaiss+" </p> </font> "
			     	 + "<p></p>"
			     	 + "<p STYLE='padding: 0 0 0 0px;'> <font face='arial' size='2.3'> "
			     	 + "est&nbsp;régulièrement&nbsp;inscrit(e)&nbsp;comme&nbsp;étudiant(e)&nbsp;"
			     	 + "en<b>&nbsp;"+clas+" </b> </font>  </p>"
			     	 + "<p></p>"
			     	+ "<p STYLE='padding: 0 0 0 0px;'> <font face='arial' size='2.3'> "
			     	 + " <u><i><b>MENTION</b></i></u>:&nbsp;&nbsp;"+mention+" </font> <b> </p>"
			     	 + "<p></p>"
			     	 + "<p STYLE='padding: 0 0 0 0px;'> <font face='arial' size='2.3'> "
			     	 + " <b><u><i>PARCOURS</i></u>:</b>&nbsp;&nbsp;"+parcours+" </font> <b> </p>"
			     	 + "<p></p>"
			     	 + "<p STYLE='padding: 0 0 0 0px;'> <font face='arial' size='2.3'> "
			     	 + " <b><u><i>N°Sur&nbsp;le&nbsp;registre</i></u>:</b>&nbsp;"+num+" RI-"+ri+" </font> <b> </p>"
			     	  + "<p></p>"
			     	 + "<p STYLE='padding: 0 0 0 0px;'> <font face='arial' size='2.3'> "
			     	 + " "+text+" </font>  </p>"
			     	 + "<p></p>"
			     	+ "<p></p>"
			     	 + "<p STYLE='padding: 0 0 0 0px;'> <font face='arial' size='2.3'> "
			     	 + "En&nbsp;foi&nbsp;de&nbsp;quoi,&nbsp;ce&nbsp;certificat&nbsp;lui&nbsp;est&nbsp;delivré&nbsp;"
			     	 + "pour&nbsp;servir&nbsp;et&nbsp;valoir&nbsp;ce&nbsp;que&nbsp;le&nbsp;droit&nbsp;</b> </font>  </p>"
			     	 + "<p></p>"
			     	 + "<p STYLE='padding: 0 0 0 220px;'> <font face='arial' size='2.3'> "
			     	 + "Fianarantsoa,&nbsp;le </b> </font>  </p>"
			     	 + "<p></p>"
			     	 + "<p></p>"
			     	 + "<p></p>"
			     	 + " </div></html>");
		     
		    
		     titre4=new JLabel("<html> <div id='bloc_page'>"
			     	 + "<p STYLE='padding: 0 0 0 0px;'> <font face='arial' size='2.5'> "
			     	 + "AVIS&nbsp;TRES&nbsp;IMPORTANT </b> </font>  </p>"
			     	 + "<p>Il&nbsp;n'est&nbsp;délivré&nbsp;qu'un&nbsp;seul&nbsp;certificat&nbsp;de&nbsp;scolarité</p>"
			     	 + "<p>Pendant&nbsp;l'année&nbsp;Universitaire</p>"
			     	 + "<p>L'intéressé&nbsp;doit&nbsp;établir&nbsp;des&nbsp;copies&nbsp;sur&nbsp;papier</p>"
			     	 + "<p>Libre&nbsp;et&nbsp;le&nbsp;faire&nbsp;certifié,&nbsp;conforme&nbsp;à&nbsp;l'original</p>"
			     	 + "<p></p>"
	                 + " </div></html>");
			
			text1=new JTextArea("             "
					+ "Nul ne peut se présenter à l'examen s'il n'a pas subi la visite\n"
					+ "        "
                  + "médicale organisée par le Service de la médecine préventive,\n\n"
                  + "                                    "
                  + "     Signature du Médecin \n\n\n\n\n"
                  + "               "
                  + "NB: il n'est delivré qu'une seule carte pendant l'année,\n"
                  + "l'interessé doit faire une déclaration auprès de la police en cas de perte");	
			//paneBas[i].add(nomSco[i]);
			
			Border test =BorderFactory.createEtchedBorder();
			titre2.setBorder(test);
			titre3.setBorder(BorderFactory.createLineBorder(Color.white));
			paneTab=new JPanel();
			//paneTab.setBorder(tite1);
			paneTab.setBackground(Color.WHITE);
			titre.setBackground(Color.CYAN);
			text1.setBackground(Color.CYAN);
			paneTab.setBackground(Color.white);
			//paneTab.setLayout(new FlowLayout(FlowLayout.LEFT));
			titre.setPreferredSize(new Dimension(500,50));
			titre1.setPreferredSize(new Dimension(500,60));
			titre2.setPreferredSize(new Dimension(300,50));
			titre3.setPreferredSize(new Dimension(500,390));
			titre4.setPreferredSize(new Dimension(450,80));
			
			text1.setPreferredSize(new Dimension(500,150));
			//titre.setFont(police);
			text1.setFont(police1);
			paneTab.setPreferredSize(new Dimension(520,700));
			paneTab.add(titre);
			paneTab.add(titre1);
			paneTab.add(titre2);
			paneTab.add(titre3);
			switch(j) {
			case 1:
				paneTab.add(titre4);
				break;
			case 2:
				break;
			}
			
			
			//paneTab.add(text1);
			
		    //paneTab.setLayout(new FlowLayout(FlowLayout.LEFT));
		      // panel.setBackground(Color.cyan);  
		       //panel.add(new JLabel(" " + feed.name+ " " + feed.url + "Articles " + feed.articles.length + ""));     
		      //panel.add(showButton);   
			this
			.setBackground(Color.white);
			this.setPreferredSize(new Dimension(500,700));
			this.add(paneTab) ;
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
					  mois="Février";
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
					  mois="Juillet";
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
					  mois="Séptembre";
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
		}