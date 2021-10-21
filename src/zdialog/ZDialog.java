package zdialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import data_base.DataBase;
import image.ImageBonneQualite;
import loading.Main;

@SuppressWarnings("serial")
public  class  ZDialog  extends  JDialog implements KeyListener {
	
public static   JDialog dial= new JDialog();	

public static JPanel control = new  JPanel();
public static JPanel content = new  JPanel();

public static  JTextField nom = new  JTextField();;
public static  JPasswordField mdp=new JPasswordField();
public static  JPasswordField mdpF=new JPasswordField();
public static  JPasswordField confMdp=new JPasswordField();

public static  JButton connectBouton = new  JButton("connecter");
public static JLabel pic=new JLabel();
public static JLabel util=new JLabel("");
public static JLabel avert0=new JLabel("INSERER LE MOT DE PASSE");
public static JLabel avertNom=new JLabel("INSERER LE MOT DE PASSE");
public static JLabel avert=new JLabel("MOT DE PASSE INCORRECTE ");
public static JLabel avert1=new JLabel("MOT DE PASSE NON CONFIRME  ");
public static JCheckBox aff=new JCheckBox("Afficher le Mot De Passe");

public static int k=0;
 static String mention="MATHEMATIQUES ET APPLICATIONS";

public  ZDialog(JFrame parent){
	super(parent);
}

	public  ZDialog(JFrame parent, String title, boolean modal,boolean test){
		dial.setTitle( "CONNEXION1" );
		dial.setResizable(false);
		dial.setSize(400,350);
		dial.setModalityType(ModalityType.APPLICATION_MODAL);
		dial.setLocationRelativeTo(parent);
		dial.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		dial.getContentPane().add(content, BorderLayout.CENTER);
		dial.getContentPane().add(control, BorderLayout.SOUTH);
		initComponent(test);
		nom.addKeyListener(this);
		mdp.addKeyListener(this);
		mdpF.addKeyListener(this);
		confMdp.addKeyListener(this);
		aff.addKeyListener(this);
	}

	public static  void initComponent(boolean test){
		JLabel nomLabel,mdpLabel,confMdpLabel,mdpLabelF;
		JPanel ligne1=new JPanel();
		ligne1.setPreferredSize(new Dimension(400,5));
		
		JPanel ligne2=new JPanel();
		ligne2.setPreferredSize(new Dimension(400,5));
		
	    aff.setOpaque(false);
	    pic.setPreferredSize(new Dimension(150,150));
	    pic.setOpaque(true);
	    pic.setIcon(ImageBonneQualite.image(DataBase.recuperPhotoUtil(), 150));
	    
		JPanel panNom = new  JPanel();
		panNom.setBackground(Color.cyan);

		panNom.setPreferredSize(new  Dimension(400,400));
		
		nom.setPreferredSize(new  Dimension(140, 20));
		nomLabel = new  JLabel("Nom d'utilisateur :");
		nomLabel.setPreferredSize(new  Dimension(160, 20));
		
		mdp.setPreferredSize(new  Dimension(140, 20));
		mdpLabel = new  JLabel("Nouveau Mot De Passe:");
		mdpLabel.setPreferredSize(new  Dimension(160, 20));
		
		confMdp.setPreferredSize(new  Dimension(140, 20));
		confMdpLabel = new  JLabel("Confirmé le Mot De Passe:");
		confMdpLabel.setPreferredSize(new  Dimension(160, 20));
		
		mdpF.setPreferredSize(new  Dimension(140, 20));
		mdpLabelF = new  JLabel("Mot De Passe:");
		mdpLabelF.setPreferredSize(new  Dimension(90, 20));
		
		JLabel titre= new JLabel("Connecter en tant que:");
		util=new JLabel(DataBase.recuperNomUtil(mention));
		if(!test) {
			//panNom.add(pic);
			//panNom.add(add);
			panNom.add(ligne1);
			avert1.setPreferredSize(new Dimension(350,20));
			avert1.setHorizontalAlignment(JLabel.CENTER);
			avert1.setForeground(Color.red);
			avert1.setVisible(false);
			
			avert0.setPreferredSize(new Dimension(350,20));
			avert0.setHorizontalAlignment(JLabel.CENTER);
			avert0.setForeground(Color.red);
			avert0.setVisible(false);
			

			avertNom.setPreferredSize(new Dimension(350,20));
			avertNom.setHorizontalAlignment(JLabel.CENTER);
			avertNom.setForeground(Color.red);
			avertNom.setVisible(false);
			
			panNom.add(avert1);
			panNom.add(avert0);
			panNom.add(avertNom);
			panNom.add(nomLabel);
			panNom.add(nom);
			panNom.add(mdpLabel);
			panNom.add(mdp);
			panNom.add(confMdpLabel);
			panNom.add(confMdp);
			panNom.add(aff);
		}
		else {
			
			dial.setSize(400,350);
			panNom.add(titre);
			panNom.add(util);
			ligne2.setOpaque(false);
			ligne1.setOpaque(true);
			ligne1.setBackground(Color.black);
			panNom.add(ligne2);
			panNom.add(pic);
			ligne1.setPreferredSize(new Dimension(350,1));
			avert.setPreferredSize(new Dimension(350,20));
			avert.setHorizontalAlignment(JLabel.CENTER);
			avert.setForeground(Color.red);
			avert.setVisible(false);
			panNom.add(ligne1);
			panNom.add(avert);
			panNom.add(mdpLabelF);
			panNom.add(mdpF);
			panNom.add(aff);
		}
		
		
		content.setBackground(Color.white);
		content.add(panNom);


		JButton quiteBouton = new  JButton("Quitter");
		

		
			connectBouton.addActionListener(new  ActionListener(){
				@SuppressWarnings("deprecation")
				public  void actionPerformed(ActionEvent arg0){
					if(!DataBase.testExistance("MATHEMATIQUES ET APPLICATIONS")){
						if(!ZDialog.nom.getText() .equals("")){
							if(!ZDialog.mdp.getText() .equals("")) {
								if(ZDialog.mdp.getText() .equals(ZDialog.confMdp.getText())) {
									dial.setVisible(false);
								}else {
									 ZDialog.avert1.setVisible(true);
								}
							}else
							avert0.setVisible(true);
						}else {
							avertNom.setVisible(true);
						}
					}else {
					if(ZDialog.mdpF.getText().equals(DataBase.recuperMotDePasseUtil("MATHEMATIQUES ET APPLICATIONS"))) {
						dial.setVisible(false);
					   }
				       else {
				    	   ZDialog.avert.setVisible(true);
				    }
					}
				}
			});
			
			quiteBouton.addActionListener(new  ActionListener(){
				public  void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			
			control.add(quiteBouton);
			control.add(connectBouton);	
		}

	@SuppressWarnings("deprecation")
	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode()==KeyEvent.VK_ENTER) {
		if(!DataBase.testExistance("MATHEMATIQUES ET APPLICATIONS")) {
			if(String.valueOf(ZDialog.mdp.getText()).length()!=0) {
			if(ZDialog.mdp.getText() .equals(ZDialog.confMdp.getText())) {
					dial.setVisible(false);
					}else {
						ZDialog.avert1.setVisible(true);
					}
			}else {
				avert0.setVisible(true);
			}
		}else {
		if(ZDialog.mdpF.getText().equals(DataBase.recuperMotDePasseUtil("MATHEMATIQUES ET APPLICATIONS"))) {
			dial.setVisible(false);
		   }
	       else {
	    	   ZDialog.avert.setVisible(true);
	    }
	  }
		if(!DataBase.testExistance("MATHEMATIQUES ET APPLICATIONS") ) {
			
			if(ZDialog.mdp.getText() .equals(ZDialog.confMdp.getText())) {
				DataBase.ajout_utilisateur(ZDialog.nom.getText(),
				ZDialog.mdp.getText(), "utilisateur","MATHEMATIQUES ET APPLICATIONS");
				//Main.main.setVisible(true);
				Main.main.setVisible(true);
			}else {
				ZDialog.mdp.setText("");
				ZDialog.confMdp.setText("");
			}
			
		}else {
			if(ZDialog.mdpF.getText().equals(DataBase.recuperMotDePasseUtil("MATHEMATIQUES ET APPLICATIONS"))) {
				//Main.main.setContentPane(GestNote.split);
			    Main.main.setVisible(true);
			   }
		       else {
		    	   ZDialog.mdpF.setText("");
		    }
		}
		
	 }
   }

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
