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
public class AttestationScola extends JPanel { 
	
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
	 String an;
	 String nom;
	 String prenom;
	 String dateNaiss;
	 String lieuNaiss;
	 String clas;
	 String num;
	 String parcours;
	 String numAt;
	 int j;
	 String text;
	String ri;
	String anne;
	String mention;
	public AttestationScola(String mention,int j,String an,String nom,String prenom,String dateNaiss,String lieuNaiss,String num,
			String parcours,String clas,String numAt) {
		this.an=an;
		this.nom=nom;
		this.prenom=prenom;
		this.dateNaiss=dateNaiss;
		this.lieuNaiss=lieuNaiss;
		this.num=num;
		this.parcours=parcours;
		this.clas=clas;
		this.j=j;
		this.mention=mention;
		this.numAt=numAt;
		
		
			switch(j) {
			case 3:
				text="Durant,&nbsp;l'année&nbsp;Universitaire <b>"+an+" </b>";
				titre2=new JLabel("<html> <div id='bloc_page'>"
				     	 + " <p STYLE='padding: 0 0 0 10px;'> <font face='Algerian' size='5'> "
				     	 + "<b> ATTESTATION&nbsp;D'INSCRIPTION </b> </font>  </p> "
		                 + " </div></html>");
				ri=an.substring(7, 9);
				anne=Main.date2textField.getText().substring(8, 12);
				titre3=new JLabel("<html> <div id='bloc_page'>"
				     	 + " <p STYLE='padding: 0 0 0 0px;'> <font face='arial' size='2.3'> "
				     	 + " Le&nbsp;DOYEN&nbsp;de&nbsp;la&nbsp;FACULTE&nbsp;des&nbsp;SCIENCES&nbsp;de&nbsp;"
				     	 + "L'Université&nbsp;de&nbsp;Fianarantsoa</font>  </p> "
				     	 + "<p STYLE='padding: 0 0 0 0px;'> <font face='arial' size='2.3'> "
				     	 + "Soussigné,&nbsp;atteste&nbsp;que:  </font>  </p>"
				     	 + "<p></p>"
				     	 + "<p STYLE='padding: 0 0 0 0px;'> <font face='arial' size='2.3'> "
				     	 + " <b><u><i>Nom</i></u>: </b>&nbsp;"+nom+"  </font>  </p>"
				     	 + "<p></p>"
				     	 + "<p STYLE='padding: 0 0 0 0px;'> <font face='arial' size='2.3'> "
				     	 + " <b><u><i>Prénom</i></u>: </b>&nbsp;"+prenom+"  </font>  </p>"
				     	 + "<p></p>"
				     	 + "<p STYLE='padding: 0 0 0 0px;'> <font face='arial' size='2.3'> "
				     	 + " <b><u><i>Né(e)&nbsp;Le</i></u>: </b>&nbsp;"+dateNaiss+"  </font> <b>&nbsp;à&nbsp;</b> "+lieuNaiss+" </p>"
				     	 + "<p></p>"
				     	 + "<p STYLE='padding: 0 0 0 0px;'> <font face='arial' size='2.3'> "
				     	 + "est&nbsp;régulièrement&nbsp;inscrit(e)&nbsp;comme&nbsp;étudiant(e)&nbsp;en&nbsp;"
				     	 + "<b>"+clas+" </b> </font>  </p>"
				     	 + "<p></p>"
				     	 + "<p STYLE='padding: 0 0 0 0px;'> <font face='arial' size='2.3'> "
				     	 + " <u><i><b>MENTION</b></i></u>:&nbsp;"+mention+" </font>  </p>"
				     	 + "<p></p>"
				     	 + "<p STYLE='padding: 0 0 0 0px;'> <font face='arial' size='2.3'> "
				     	 + " <b><u><i>N°Sur&nbsp;le&nbsp;registre&nbsp;</i></u>: </b>&nbsp;"+num+"&nbsp;RI-"+ri+" </font> </p>"
				     	 + "<p></p>"
				     	 + "<p STYLE='padding: 0 0 0 0px;'> <font face='arial' size='2.3'> "
				     	 + " "+text+" </font>  </p>"
				     	 + "<p></p>");
				titre2.setPreferredSize(new Dimension(300,50));
				break;
			case 4:
				switch(clas) {
				case "L1": clas="PREMIERE&nbsp;ANNEE&nbsp;DU&nbsp;LICENCE&nbsp;(S1&nbsp;et&nbsp;S2)";
				break;
				case "L2": clas="DEUXIEME&nbsp;ANNEE&nbsp;DU&nbsp;LICENCE&nbsp;(S3&nbsp;et&nbsp;S4)";
				break;
				case "L3": clas="TROISIEME&nbsp;ANNEE&nbsp;DU&nbsp;LICENCE&nbsp;(S5&nbsp;et&nbsp;S6)";
				break;
				case "M1": clas="QUATRIEME&nbsp;ANNEE&nbsp;DU&nbsp;MASTER&nbsp;(S7&nbsp;et&nbsp;S8)";
				break;
				case "M2": clas="CINQUIEME&nbsp;ANNEE&nbsp;DU&nbsp;MASTER&nbsp;(S9&nbsp;et&nbsp;S10)";
				break;
				
				}
				 text="A&nbsp;validé&nbsp;les&nbsp;60&nbsp;crédits&nbsp;de&nbsp;la&nbsp;"+clas+"&nbsp;<p></p>en&nbsp;"+parcours+""
				 		+ "<p></p>";
				 titre2=new JLabel("<html> <div id='bloc_page'>"
				     	 + " <p STYLE='padding: 0 0 0 20px;'> <font face='Algerian' size='5'> "
				     	 + "<b> ATTESTATION&nbsp;DE&nbsp;VALIDATION&nbsp;DE&nbsp;CREDITS </b> </font>  </p> "
		                 + " </div></html>");
				 int f=an.length();
				 ri=an.substring(f-2,f);
				 titre2.setPreferredSize(new Dimension(450,50));
				 anne=Main.date2textField.getText().substring(8, 12);
				 titre3=new JLabel("<html> <div id='bloc_page'>"
				     	 + " <p STYLE='padding: 0 0 0 0px;'> <font face='arial' size='2.3'> "
				     	 + " Le&nbsp;DOYEN&nbsp;de&nbsp;la&nbsp;FACULTE&nbsp;des&nbsp;SCIENCES&nbsp;de&nbsp;"
				     	 + "L'Université&nbsp;de&nbsp;Fianarantsoa</font>  </p> "
				     	 + "<p STYLE='padding: 0 0 0 0px;'> <font face='arial' size='2.3'> "
				     	 + "Soussigné,&nbsp;atteste&nbsp;que:  </font>  </p>"
				     	 + "<p></p>"
				     	 + "<p STYLE='padding: 0 0 0 0px;'> <font face='arial' size='2.3'> "
				     	 + " <b><u><i>Nom</i></u>: </b>&nbsp;"+nom+"  </font>  </p>"
				     	 + "<p></p>"
				     	 + "<p STYLE='padding: 0 0 0 0px;'> <font face='arial' size='2.3'> "
				     	 + " <b><u><i>Prénom</i></u>: </b>&nbsp;"+prenom+"  </font>  </p>"
				     	 + "<p></p>"
				     	 + "<p STYLE='padding: 0 0 0 0px;'> <font face='arial' size='2.3'> "
				     	 + " <b><u><i>Né(e)&nbsp;Le</i></u>: </b>&nbsp;"+dateNaiss+"  </font> <b>&nbsp;à&nbsp;</b> "+lieuNaiss+" </p>"
				     	 + "<p></p>"
				     	 + "<p STYLE='padding: 0 0 0 0px;'> <font face='arial' size='2.3'> "
				     	 + " <u><i><b>MENTION</b></i></u>:&nbsp;"+mention+" </font>  </p>"
				     	 + "<p></p>"
				     	 + " <u><i><b>PARCOURS</b></i></u>:&nbsp;"+parcours+" </font>  </p>"
				     	 + "<p></p>"
				     	 + "<p STYLE='padding: 0 0 0 0px;'> <font face='arial' size='2.3'> "
				     	 + " <b><u><i>N°Sur&nbsp;le&nbsp;registre&nbsp;</i></u>: </b>&nbsp;"+num+"&nbsp;RI-"+ri+" </font> </p>"
				     	 + "<p></p>"
				     	 + "<p STYLE='padding: 0 0 0 0px;'> <font face='arial' size='2.3'> "
				     	 + " "+text+" </font>  </p>"
				     	 + "<p></p>"
				     	 + "<p></p>"
				     	 + "A&nbsp;la&nbsp;Faculté&nbsp;des&nbsp;Sciences&nbsp;durant&nbsp;l'année&nbsp;universitaire&nbsp;"+an);
				break;
			}
			
			
			
			 titre=new JLabel("<html> <div id='bloc_page'>"
			     	 + " <p STYLE='padding: 0 0 0 105px;'> <font size='4'><b> REPOBLIKAN'I&nbsp;MADAGASIKARA</b> "
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
	                 + " <font face= 'arial' size='3'> <b>N°"+numAt+"/"+anne+"/UF/FAC.S/SCO </b> </font></i></p>"
	                 + "</font>"
	                 + " </div></html>");
		     
		     
		     
		    
		     
		     
		     
		   titre4=new JLabel("<html> <div id='bloc_page'>"
			     	 + "<p STYLE='padding: 0 0 0 0px;'> <font face='arial' size='2.3'> "
			     	 + "En&nbsp;foi&nbsp;de&nbsp;quoi,&nbsp;la&nbsp;présence&nbsp;d'attestation&nbsp;lui&nbsp;est&nbsp;"
			     	 + "delivré&nbsp;pour&nbsp;servir&nbsp;et&nbsp;valoir&nbsp;ce&nbsp que&nbsp;de&nbsp;droit "
			     	 + "</b> </font>  </p>"
			     	 + "<p></p>"
			     	 + "<p STYLE='padding: 0 0 0 220px;'> <font face='arial' size='2.3'> "
			     	 + "Fianarantsoa, le  </font>  </p>"
			     	 + "<p></p>"
			     	 + "<p></p>"
			     	 + "<p></p>"
			     	 + " </div></html>");
		    /* titre4=new JLabel("<html> <div id='bloc_page'>"
			     	 + "<p STYLE='padding: 0 0 0 0px;'> <font face='arial' size='2.3'> "
			     	 + "AVIS&nbsp;TRES&nbsp;IMPORTANT </b> </font>  </p>"
			     	 + "<p>Il&nbsp;n'est&nbsp;délivré&nbsp;qu'un&nbsp;seul&nbsp;Certificat&nbsp;de&nbsp;scolatrité</p>"
			     	 + "<p>Pendant&nbsp;l'année&nbsp;Universitaire</p>"
			     	 + "<p>L'intéressé&nbsp;doit&nbsp;etablir&nbsp;des&nbsp;copies&nbsp;sur&nbsp;papier</p>"
			     	 + "<p>Libre&nbsp;et&nbsp;les&nbsp;faires&nbsp;certifier&nbsp;conforme&nbsp;à&nbsp;l'original</p>"
			     	 + "<p></p>"
	                 + " </div></html>");
			//paneBas[i].add(nomSco[i]);*/
			
			Border test =BorderFactory.createEtchedBorder();
			titre2.setBorder(test);
			paneTab=new JPanel();
			/*paneTab.setBorder(tite1);
			paneTab.setBackground(Color.WHITE);
			titre.setBackground(Color.CYAN);
			text1.setBackground(Color.CYAN);
			paneTab.setBackground(Color.white);
			*/
			//paneTab.setLayout(new FlowLayout(FlowLayout.LEFT));
			titre.setPreferredSize(new Dimension(500,50));
			titre1.setPreferredSize(new Dimension(500,60));
			
			titre3.setPreferredSize(new Dimension(500,350));
			titre4.setPreferredSize(new Dimension(500,90));
			
			//text1.setPreferredSize(new Dimension(500,150));
			//titre.setFont(police);
			//text1.setFont(police1);
			paneTab.setPreferredSize(new Dimension(500,700));
			paneTab.add(titre);
			paneTab.add(titre1);
			paneTab.add(titre2);
			paneTab.add(titre3);
			paneTab.add(titre4);
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
			this.setBackground(Color.white);
			paneTab.setBackground(Color.white);
			this.setPreferredSize(new Dimension(500,700));
			this.add(paneTab) ;
		} 
		
		public static String dateText(String date) {
			 String dtext="Date invalide";
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
		}