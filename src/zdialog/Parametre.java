package zdialog;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import data_base.DataBase;
import image.LoadImage;

@SuppressWarnings("serial")
public  class  Parametre  extends  JDialog{
private  JDesktopPane desktop = new  JDesktopPane();
public static JDialog bur=new JDialog();
private  static  int xy = 10;
public  Parametre(JFrame parent){
		super(parent);
	}
public  Parametre(JFrame parent, String title, boolean modal){
bur.setSize(700, 320);
bur.setLocationRelativeTo(null);
bur.setModalityType(ModalityType.APPLICATION_MODAL);
bur.setResizable(false);
desktop.add(new  MiniFenetre(1), 1);
xy += 230;
desktop.add(new  MiniFenetre(2), 2);
xy += 230;
desktop.add(new  MiniFenetre(3), 3);
xy += 230;

bur.getContentPane().add(desktop, BorderLayout.CENTER);
}
class  MiniFenetre  extends  JInternalFrame{
	public JPanel pan=new JPanel();
	public JPanel line=new JPanel();
	public JPanel panBout=new JPanel();
	public JLabel pic=new JLabel("Image");
	public JLabel mdp=new JLabel("Mot de passe actuelle");
	public JPasswordField mdpTxt=new JPasswordField("");
	public JLabel nouvmdp=new JLabel(" Nouveau mot de passe");
	public JPasswordField nouvmdpTxt=new JPasswordField("");
	public JLabel confmdp=new JLabel("Confirmer le mot de passe");
	public JPasswordField confmdpTxt=new JPasswordField("");
	public JButton mod=new JButton( LoadImage.transformeb(100, 25, "/Modif.jpg"));
	public JButton val=new JButton( LoadImage.transformeb(100, 25, "/valide.jpg"));
	
	public JLabel mess1=new JLabel("mot de passe incorrect");
	public JLabel mess2=new JLabel("mot de passe non confirmé");
	
	public String titre;
	
public  MiniFenetre(int nbre){
	//DataBase.nomPers(nbre, nomTxt, prenomTxt, pic);
	pan.setBackground(Color.cyan);
	pic.setPreferredSize(new Dimension(90,90));
	pic.setOpaque(false);
	line.setPreferredSize(new Dimension(200,1));
	nouvmdpTxt.setPreferredSize(new Dimension(130,20));
	confmdpTxt.setPreferredSize(new Dimension(130,20));
	panBout.setPreferredSize(new Dimension(200,30));
	mod.setPreferredSize(new Dimension(100,25));
	val.setPreferredSize(new Dimension(100,25));
	mdpTxt.setPreferredSize(new Dimension(130,20));
	panBout.setBackground(Color.cyan);
	
	Font police = new  Font("Arial", Font.BOLD, 10);
	Font police1 = new  Font("Arial", Font.BOLD, 12);
	confmdpTxt.setFont(police);
	confmdpTxt.setForeground(Color.black);
	nouvmdpTxt.setFont(police);
	nouvmdpTxt.setForeground(Color.black);
	mdpTxt.setFont(police);
	mdpTxt.setForeground(Color.black);
	mess1.setFont(police1);
	mess2.setFont(police1);
	
	mess1.setForeground(Color.red);
	mess2.setForeground(Color.red);
	
	mdpTxt.setEditable(true);
	nouvmdpTxt.setEditable(true);
	confmdpTxt.setEditable(true);
	
	mdpTxt.setBorder(null);
	nouvmdpTxt.setBorder(null);
	confmdpTxt.setBorder(null);
	
	//pan.add(pic);
	pan.add(line);
	pan.add(mdp);
	pan.add(mdpTxt);
	pan.add(nouvmdp);
	pan.add(nouvmdpTxt);
	pan.add(confmdp);
	pan.add(confmdpTxt);
	pan.add(confmdpTxt);
	pan.add(mess1);
	pan.add(mess2);
	
	mess1.setVisible(false);
	mess2.setVisible(false);
	panBout.add(val);
	val.setVisible(true);  
	switch(nbre) {
	case 1:
		titre="Utilisateur";
		break;
	case 2:
		titre="Chef de Mention";
		break;
	case 3:
		titre="Chef-Scolarité";
		break;
	}
	
	mdpTxt.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			mess1.setVisible(false);
			mess2.setVisible(false);
		}
	});
	nouvmdpTxt.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			mess1.setVisible(false);
			mess2.setVisible(false);
		}
	});
	confmdpTxt.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			mess1.setVisible(false);
			mess2.setVisible(false);
		}
	});
	val.addActionListener(new ActionListener() {
		
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent arg0) {
			switch(nbre) {
			case 1:
				String mdputil=DataBase.recuperMotDePasseUtil("MATHEMATIQUES ET APPLICATIONS");
				if(mdpTxt.getText().equals(mdputil)) {
					if(nouvmdpTxt.getText().equals(confmdpTxt.getText())) {
						DataBase.modif_mdp_utilisateur(nouvmdpTxt.getText(), "MATHEMATIQUES ET APPLICATIONS");
						mdpTxt.setText("");
						nouvmdpTxt.setText("");
						confmdpTxt.setText("");
						JOptionPane.showMessageDialog(bur, "Opération effectué" , "",
								JOptionPane.INFORMATION_MESSAGE);
					}else {
						mdpTxt.setText("");
						nouvmdpTxt.setText("");
						confmdpTxt.setText("");
						mess2.setVisible(true);
					}
					
				}else {
					mdpTxt.setText("");
					nouvmdpTxt.setText("");
					confmdpTxt.setText("");
					mess1.setVisible(true);
					}
				
				break;
			case 2:	
				String mdpchment=DataBase.recuperMotDePasseMent("MATHEMATIQUES_ET_APPLICATIONS");
				if(mdpTxt.getText().equals(mdpchment)) {
					if(nouvmdpTxt.getText().equals(confmdpTxt.getText())) {
						DataBase.modif_mdp_chef_mention(nouvmdpTxt.getText(),"Chef de la Mention Maths");
						mdpTxt.setText("");
						nouvmdpTxt.setText("");
						confmdpTxt.setText("");
						JOptionPane.showMessageDialog(bur, "Opération effectué" , "",
								JOptionPane.INFORMATION_MESSAGE);
					}else {
						mdpTxt.setText("");
						nouvmdpTxt.setText("");
						confmdpTxt.setText("");
						mess2.setVisible(true);
					}
					
				}else {
					mdpTxt.setText("");
					nouvmdpTxt.setText("");
					confmdpTxt.setText("");
					mess1.setVisible(true);
					}
				
				break;
				
			case 3:
				String mdpsco=DataBase.recuperMdpSco();
				if(mdpTxt.getText().equals(mdpsco)) {
					if(nouvmdpTxt.getText().equals(confmdpTxt.getText())) {
						DataBase.modif_mdp_chef_sco(nouvmdpTxt.getText());
						mdpTxt.setText("");
						nouvmdpTxt.setText("");
						confmdpTxt.setText("");
						JOptionPane.showMessageDialog(null, "Opération effectué" , "",
								JOptionPane.INFORMATION_MESSAGE);
					}else {
						mdpTxt.setText("");
						nouvmdpTxt.setText("");
						confmdpTxt.setText("");
						mess2.setVisible(true);
					}
					
				}else {
					mdpTxt.setText("");
					nouvmdpTxt.setText("");
					confmdpTxt.setText("");
					mess1.setVisible(true);
					}
				
				break;
			}
			
		//DataBase.modifierPers(nbre, nomTxt.getText().toUpperCase(), Methode.finitText(prenomTxt.getText()),"MATHEMATIQUES_ET_APPLICATIONS");
		//DataBase.nomPers(nbre, nomTxt, prenomTxt, pic);
		}
	});
	
		this.setTitle(titre);
		this.setClosable(false);
		this.setResizable(false);
		this.setSize(220, 250);
		this.setLocation(xy, 20);
		this.getContentPane().add(pan);
		this.getContentPane().add(panBout,BorderLayout.SOUTH);
		this.setVisible(true);
	  }
	}

public static void main (String [] argv) {
	new Parametre(null,"",true);
}
}