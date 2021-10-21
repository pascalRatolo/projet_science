package loading;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;

import gest_etudiant.ListeMaths;
import gest_matiere.MatiereMaths;
import gest_note.GestNoteMathsNormal;
import gest_note.GestNoteMathsRattrapage;
import image.LoadImage;
import login.LoginPrincipale;
import zdialog.Auteur;

public class Menu {
	       public static JButton home= new JButton(LoadImage.transformeb(100, 25, "/home.jpg"));
	       public static JButton prec= new JButton( LoadImage.transformeb(100, 25, "/retour.jpg"));
	//Creation des menu
			public static JMenuBar menuBar = new  JMenuBar();
			private static  JMenu menu1 = new  JMenu("Fichier");
			private static  JMenu menu2 = new  JMenu("Edition");
			private static  JMenu menu3 = new  JMenu("Aide");
			private static 	JMenu menu1_1= new JMenu("Nouveau");
			private static  JMenu menu2_2= new JMenu("Gestion de notes");
	
	//Creation des sous menu
			
			private static JMenuItem menu1_2= new JMenuItem("Fermer");
			private static JMenuItem menu3_1= new JMenuItem("?");
			private static JMenuItem menu3_2= new JMenuItem("A propos");
			private static  JMenuItem menu2_1= new JMenuItem("Liste des Etudiants inscrits");
			
			private static  JMenuItem menu2_2_1= new JMenuItem("Session normale");
			private static  JMenuItem menu2_2_2= new JMenuItem("Session rattrapage");
			private static  JMenuItem menu2_3= new JMenuItem("Gestion de matière");
			private static JMenuItem menu2_4= new JMenuItem("Menu Principale");
			
			private static JMenuItem  menu1_1_1= new JMenuItem ("Inscription");
			private static JMenuItem  menu1_1_2= new JMenuItem ("Reinscription");
		
	
	public static void ajouter(){
		JProgressBar bar=new JProgressBar();
		bar.setBackground(Color.yellow);
		bar.setIndeterminate(true);
		bar.setStringPainted(true);
		bar.setString("Loading...");
		bar.setForeground(Color.green);
		bar.getForeground().darker();
		bar.setPreferredSize(new Dimension(80,20));
		home.setPreferredSize(new Dimension(100,25));
		prec.setPreferredSize(new Dimension(100,25));
		prec.setEnabled(false);
		menuBar.add(menu1);
		menuBar.add(menu2);
		menuBar.add(menu3);
		menuBar.add(Box.createGlue());
		menuBar.add(home);
		menuBar.add(prec);
		menuBar.setBackground(Color.white);
		menuBar.setPreferredSize(new Dimension(Main.main.getX(),35));
		menu1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menu2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menu3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//on ajoute les sous menu
		menu1.add(menu1_1);
		menu1.add(menu1_2);
		menu2.add(menu2_1);
		menu2.add(menu2_2);
		menu2_2.add(menu2_2_1);
		menu2_2.add(menu2_2_2);
		menu2.add(menu2_3);
		menu2.add(menu2_4);
		
		menu3.add(menu3_1);
		menu3.add(menu3_2);
		
		
		menu1_1.add(menu1_1_1);
		menu1_1.add(menu1_1_2);
		
	//Creation des racourci sur les menus / touche ALT+ Lettre entre cote' ';
		menu1.setMnemonic('F');
		menu2.setMnemonic('E');
		menu3.setMnemonic('A');
   		
   		menu1_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,KeyEvent.CTRL_MASK ));
   		menu2_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,KeyEvent.CTRL_MASK));
   		menu2_3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,KeyEvent.CTRL_MASK ));
   		menu2_4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,KeyEvent.CTRL_MASK ));
   		
   		
   		menu2_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.main.setContentPane(new JScrollPane(GestNoteMathsNormal.split));
				Main.main.setVisible(true);
				Menu.prec.setEnabled(true);
			
			}
		});
   		
   		menu2_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.main.setContentPane(new JScrollPane(GestNoteMathsRattrapage.split));
				Main.main.setVisible(true);
				Menu.prec.setEnabled(true);
			
			}
		});
   		menu2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.main.setContentPane(MatiereMaths.scrollpane);
				Main.main.setVisible(true);
				Menu.prec.setEnabled(true);
			
			}
		});
   		menu2_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.main.setContentPane(LoginPrincipale.panelPrincipale);
				LoginPrincipale.pan11.setVisible(true);
				Menu.prec.setEnabled(false);
				Main.main.setVisible(true);
			
			}
		});	
   		menu3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Auteur(Main.main, null, true);
			
			}
		});
   		
   	   home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				prec.setEnabled(false);
				Main.main.setContentPane(LoginPrincipale.panelPrincipale);
				LoginPrincipale.pan11.setVisible(true);
				Main.main.setVisible(true);
			
			}
		});
   	   
   	   prec.addActionListener(new  ActionListener(){
   		   public  void actionPerformed(ActionEvent arg0) {
				Main.main.setContentPane(LoginPrincipale.panelPrincipale);
				LoginPrincipale.pan11.setVisible(true);
				Main.main.setVisible(true);
	        
		}
	});
   		
   	menu1_2.addActionListener(new  ActionListener(){
			public  void actionPerformed(ActionEvent arg0) {
				int option = JOptionPane.showConfirmDialog(null,"Voulez-vous Terminer ?","ATTENTION!",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
					if(option == JOptionPane.OK_OPTION){
						System.exit(0);
						}
			}
		});
   		
   		menu1_1_2.addActionListener(new  ActionListener(){
			public  void actionPerformed(ActionEvent arg0) {
				Main.main.setContentPane(Action.pan1);
				Main.main.setVisible(true);
				Menu.prec.setEnabled(true);
			}
		});
   		
   		menu1_1_1.addActionListener(new  ActionListener(){
			public  void actionPerformed(ActionEvent arg0) {
				Main.main.setContentPane(Action.panIns);
				Main.main.setVisible(true);
				Menu.prec.setEnabled(true);
			}
		});
   		
   		menu2_1.addActionListener(new  ActionListener(){
			public  void actionPerformed(ActionEvent arg0) {
				Main.main.setContentPane(ListeMaths.scrollPane);
				Main.main.setVisible(true);
				Menu.prec.setEnabled(true);
			}
		});
   		
	}

}
