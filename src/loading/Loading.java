package loading;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import data_base.DataBase;
import image.ImageBonneQualite;
import panel.Panneau8;
import zdialog.Bureau;
import zdialog.Fenetre;
import zdialog.Parametre;
import zdialog.ZDialog;

		public  class  Loading {
		public static  JFrame dial= new JFrame();
		public static JPanel control = new  JPanel();
		public static JPanel serveur = new  JPanel();
		public static JLabel serv=new JLabel("Serveur:");
		public static JComboBox <String> combServ;
		public static JPanel pan = new  JPanel();
		public static Panneau8 content = new  Panneau8("/profil_fac.jpg");

	public  Loading(){
		dial.setTitle("");
		dial.setUndecorated(true);
		dial.setResizable(false);
		
		dial.setSize(600,300);
		dial.setLocationRelativeTo(null);
		dial.setContentPane(content);
		dial.setIconImage((Image)ImageBonneQualite.scaleImage(30,30,"/logo_fac.jpg"));
		
		initComponent();
		dial.setVisible(true);
		createFile();
		combServ.setPreferredSize(new Dimension(120,20));
		Object par[]= {serv,combServ};
		int option = JOptionPane.showConfirmDialog(Main.main,par,"Choisir le serveur",
		JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
	if(option == JOptionPane.OK_OPTION){
		DataBase.port=((String)combServ.getSelectedItem()).trim();
	}else
		System.exit(0);
	}
	
	
	public static  void initComponent(){
		JProgressBar bar=new JProgressBar();
		bar.setBackground(new Color(192,192,192));
		bar.setIndeterminate(true);
		bar.setStringPainted(true);
		bar.setString("Chargement...");
		bar.setForeground(new Color(139,31,31));
		control.setOpaque(false);
		control.setPreferredSize(new Dimension(480,247));
		content.setLayout(new FlowLayout(FlowLayout.TRAILING));
		bar.setPreferredSize(new Dimension(200,14));		
		content.setBackground(new Color(0,0,0,15));
		content.add(control);
		DataBase.mess.setPreferredSize(new Dimension(480,20));
		pan.setPreferredSize(new Dimension(480,25));
		DataBase.mess.setFont(new Font("arial",Font.BOLD,9));
		DataBase.mess.setText("chargement...");
		DataBase.mess.setOpaque(false);
		pan.setBackground(new Color(0,0,0,15));
		DataBase.mess.setForeground(Color.black);
		content.add( DataBase.mess);
		content.add(bar,BorderLayout.SOUTH);
		dial.setLayout(new FlowLayout(FlowLayout.LEFT));
		}
		
		public static void main(String [] argv){
			new Loading();
			new Main();
			new ZDialog(Main.main, "CONNEXION", true,DataBase.testExistance("MATHEMATIQUES ET APPLICATIONS"));
			new Fenetre(Main.main,"Attestation de validation de credit",true);
			new Bureau(Main.main,"",true);
			new Parametre(Main.main,"",true);
			Loading.dial.dispose();
			ZDialog.dial.setVisible(true);
		}
		
		@SuppressWarnings("resource")
		public static void createFile() {
			File file=new File("C:/Program Files (x86)/JDev/DataSciences/package/serveur.txt");
			if(file.exists()) {
				try {
					BufferedReader reader=new BufferedReader(new FileReader(file));
					String ligne;
					String serv[]= new String[5];
					int i=0;
					while((ligne=reader.readLine())!= null) {
						serv[i]=ligne;
						i++;
					}
					combServ=new JComboBox<String>(serv);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else {
				JOptionPane.showMessageDialog(Main.main, "Impossible de trouver le fichier du serveur",
						"ERREUR",JOptionPane.ERROR_MESSAGE);  
				System.exit(0);
		}
	}	
}