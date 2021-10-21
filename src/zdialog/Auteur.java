package zdialog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import image.ImageBonneQualite;
import loading.Main;

@SuppressWarnings("serial")
public class Auteur extends JDialog {
	
	private JPanel pan =new JPanel();
	private JLabel logo=new JLabel();
	private JLabel texte;
	private JLabel aut[];
	private String nom[]= {"/franck.jpg","/mamy.jpg","/ofman.jpg","/fety.jpg","/pascal.jpg","/ando.jpg",
				"/namb.jpg"};
	
	
	public String franck="<p STYLE='padding: 0 0 0 0px;'> <font face='arial' size='2'>"
							+ "<br> RALAITSIMANOLAKAVANA Henri Franck </br> "
							+ "<br>Email: henrifranck.ralay@gmail.com </br> "
							+ "<br>N°Tel: +261 34 88 763 04 </br> </p>";
	
	public String mamy="<p STYLE='padding: 0 0 0 0px;'> <font face='arial' size='2'>"
							+ "<br> RAZANAKOTO Maminiaina Heritina </br> "
						//	+ "<br> henrifranck.ralay@gmail.com </br> "
							+ "<br>N°Tel: +261 34 90 357 50 </br> </p>";
	
	public String ofman="<p STYLE='padding: 0 0 0 0px;'> <font face='arial' size='2'>"
							+ "<br> ANDRIATSIOLAVINA Albertino Ofman </br> "
							+ "<br>Email: ofmanalbertino@gmail.com </br> "
							+ "<br>N°Tel: +261 34 63 487 45 </br> </p>";
	
	public String fety="<p STYLE='padding: 0 0 0 0px;'> <font face='arial' size='2'>"
							+ "<br> ANDRIAMPARANY Fety Michel </br> "
							+ "<br>Email: andriamparany.fetymichel@gmail.com </br> "
							+ "<br>N°Tel: +261 34 91 791 27 </br> </p>";
	
	public String pascal="<p STYLE='padding: 0 0 0 0px;'> <font face='arial' size='2'>"
							+ "<br> RATOLOJANAHARY Jean Mario Pascal </br> "
							+ "<br>Email: pascalratolo@gmail.com </br> "
							+ "<br>N°Tel: +261 34 10 283 92 </br> </p>";
	
	public String ando="<p STYLE='padding: 0 0 0 0px;'> <font face='arial' size='2'>"
							+ "<br> ANDRIAMBOLOLONA Ny Ando Nirina </br> "
							+ "<br> randriambololonaando@gmail.com </br> "
							+ "<br>N°Tel: +261 34 43 636 57 </br> </p>";
	
	public String namb="<p STYLE='padding: 0 0 0 0px;'> <font face='arial' size='2'>"
							+ "<br> ANDRIANAMBININA Jean Florent </br> "
							+ "<br>Email: jeanflorent.nambinina@gmail.com </br> "
							+ "<br>N°Tel: +261 34 99 315 91 </br> </p>";
	
	
	private String apropos[]= {franck,mamy,ofman,fety,pascal,ando,namb};
	
	public Auteur(JFrame parent, String title, boolean modal) {
		super(parent);
		this.setSize(new Dimension(600,300));
		this.setTitle("");
		this.setContentPane(pan);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		ajoute();
		this.setVisible(true);
	}
	
	public void ajoute() {
		texte=new JLabel("<html> <div id='bloc_page'>"
		     	 + " <p STYLE='padding: 0 0 0 0px;'> <font face='arial' size='2'> "
		     	 + "<b> <p> Ce logiciel a été créee le février 2020 par le groupe JDev </p> </b>"
		     	 + "<b>Il consiste à gérer les activités scolaires, comme: inscription,rélevé de notes "
		     	 + " carte d'étudiant.... </b>"
		     	 +"<br> </br>"
		     	 +"<br> </br>"
		     	 + "<p> Personne n'a pas le droit de copier, de manipuler ce logiciel </p> "
		     	 + "<p> Il est utilisable seulement au FACULTE DES SCIENCES DE L'UNIVERSITE DE FIANARANTSOA "
		     	 + "<br> </br>"
		       	 + "<br> </br>"
		     	 + "Contact: +261 34 91 791 27  / +261 32 52 601 15 </font>  </p> "
                 + " </div></html>");
		texte.setHorizontalAlignment(JLabel.LEADING);
		texte.setBackground(Color.white);
		logo.setIcon(new ImageIcon((Image)ImageBonneQualite.scaleImage(150,150,"/jdev.jpg")));
		logo.setOpaque(true);
		pan.add(logo);
		aut=new JLabel[7];
		
		
		texte.setPreferredSize(new Dimension(430,150));
		texte.setOpaque(true);
		pan.add(texte);
		for(int i=0;i<7;i++) {
			aut[i]=new JLabel();
			if(i<3) {
				aut[i].setIcon(new ImageIcon((Image)ImageBonneQualite.scaleImage(60,90,nom[i])));
				aut[i].setToolTipText("<html> <img src="+Main.class.getResource(nom[i])+" height='290',width='200'> "
						+ apropos[i]);
			}else {
			 aut[i].setIcon(new ImageIcon((Image)ImageBonneQualite.scaleImage(85,90,nom[i])));
			 aut[i].setToolTipText("<html> <img src="+Main.class.getResource(nom[i])+" height='200',width='340'> "
				+ apropos[i]);
			}
			pan.add(aut[i]);
		}
		pan.setLayout(new FlowLayout(FlowLayout.LEFT));
		pan.setBackground(Color.white);
		pan.setPreferredSize(new Dimension(600,300));
		
	}

	public static void main (String [] argv) {
		new Auteur(null, null, true);
	}
}
