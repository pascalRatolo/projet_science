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
import javax.swing.JTextField;

import data_base.DataBase;
import image.LoadImage;
import loading.Methode;

@SuppressWarnings("serial")
public  class  Bureau  extends  JDialog{
private  JDesktopPane desktop = new  JDesktopPane();
public static JDialog bur=new JDialog();
private  static  int xy = 10;
public  Bureau(JFrame parent){
		super(parent);
	}
public  Bureau(JFrame parent, String title, boolean modal){
bur.setSize(870, 280);
bur.setLocationRelativeTo(null);
bur.setModalityType(ModalityType.APPLICATION_MODAL);
bur.setResizable(false);
desktop.add(new  MiniFenetre(1), 1);
xy += 210;
desktop.add(new  MiniFenetre(2), 2);
xy += 210;
desktop.add(new  MiniFenetre(3), 3);
xy += 210;
desktop.add(new  MiniFenetre(4), 4);
xy += 210;
bur.getContentPane().add(desktop, BorderLayout.CENTER);
//this.getContentPane().add(ajouter, BorderLayout.SOUTH);
}
class  MiniFenetre  extends  JInternalFrame{
	public JPanel pan=new JPanel();
	public JPanel line=new JPanel();
	public JPanel panBout=new JPanel();
	public JLabel pic=new JLabel("Image");
	public JLabel nom=new JLabel("Nom:");
	public JTextField nomTxt=new JTextField("");
	public JLabel prenom=new JLabel("Prenom:");
	public JTextField prenomTxt=new JTextField("");
	public JButton mod=new JButton( LoadImage.transformeb(100, 25, "/Modif.jpg"));
	public JButton val=new JButton( LoadImage.transformeb(100, 25, "/valide.jpg"));
	public String titre;
public  MiniFenetre(int nbre){
	DataBase.nomPers(nbre, nomTxt, prenomTxt, pic);
	pan.setBackground(Color.cyan);
	pic.setPreferredSize(new Dimension(90,90));
	pic.setOpaque(false);
	line.setPreferredSize(new Dimension(200,1));
	prenomTxt.setPreferredSize(new Dimension(130,20));
	panBout.setPreferredSize(new Dimension(200,30));
	mod.setPreferredSize(new Dimension(90,22));
	val.setPreferredSize(new Dimension(90,22));
	prenomTxt.setOpaque(false);
	nomTxt.setPreferredSize(new Dimension(150,20));
	nomTxt.setOpaque(false);
	panBout.setBackground(Color.cyan);
	//pic.setOpaque(true);
	
	Font police = new  Font("Arial", Font.BOLD, 10);
	prenomTxt.setFont(police);
	prenomTxt.setForeground(Color.black);
	nomTxt.setFont(police);
	nomTxt.setForeground(Color.black);
	
	nomTxt.setEditable(false);
	prenomTxt.setEditable(false);
	
	nomTxt.setBorder(null);
	prenomTxt.setBorder(null);
	
	pan.add(pic);
	pan.add(line);
	pan.add(nom);
	pan.add(nomTxt);
	pan.add(prenom);
	pan.add(prenomTxt);
	panBout.add(mod);
	panBout.add(val);
	val.setVisible(false);  
	switch(nbre) {
	case 1:
		titre="DOYEN";
		break;
	case 2:
		titre="Chef-Scolarité";
		break;
	case 3:
		titre="Chef-Mention";
		break;
	case 4:
		titre="Sec-Pal";
		break;
	}
	mod.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
		prenomTxt.setEditable(true);	
		nomTxt.setEditable(true);
		nomTxt.setOpaque(true);
		prenomTxt.setOpaque(true);
		mod.setVisible(false);
		val.setVisible(true);
		}
	});
	
	pan.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			prenomTxt.setEditable(false);
			nomTxt.setEditable(false);
			nomTxt.setOpaque(false);
			prenomTxt.setOpaque(false);
			mod.setVisible(true);
			val.setVisible(false);
		}
	});
	
	panBout.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			prenomTxt.setEditable(false);
			nomTxt.setEditable(false);
			nomTxt.setOpaque(false);
			prenomTxt.setOpaque(false);
			mod.setVisible(true);
			val.setVisible(false);
		}
	});
	
	val.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int option = JOptionPane.showConfirmDialog(null,
					"Voulez-vous appliquer la modification de l'information "
					+titre+" "
							+ "?","ATTENTION!",
			JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE);
		if(option == JOptionPane.OK_OPTION){
		prenomTxt.setEditable(false);
		nomTxt.setEditable(false);
		nomTxt.setOpaque(false);
		prenomTxt.setOpaque(false);
		DataBase.modifierPers(nbre, nomTxt.getText().toUpperCase(), Methode.finitText(prenomTxt.getText()),"MATHEMATIQUES_ET_APPLICATIONS");
		DataBase.nomPers(nbre, nomTxt, prenomTxt, pic);
		mod.setVisible(true);
		val.setVisible(false);
		}
		}
	});
	
		this.setTitle(titre);
		this.setClosable(false);
		this.setResizable(false);
		this.setSize(200, 210);
		this.setLocation(xy, 20);
		this.getContentPane().add(pan);
		this.getContentPane().add(panBout,BorderLayout.SOUTH);
		this.setVisible(true);
	  }
	}
}