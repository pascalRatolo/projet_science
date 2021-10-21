package zdialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import data_base.DataBase;
import inscription.FieldFormat;

@SuppressWarnings("serial")
public  class  Fenetre extends  JDialog implements KeyListener {
	
public static  JDialog dial= new JDialog();	

public static JPanel control = new  JPanel();
public static JPanel content = new  JPanel();

public static JLabel titre=new JLabel();
public static String title;
public static JLabel num=new JLabel("Numero Carte: ");
public static JLabel parc=new JLabel("Parcours: ");
public static JLabel niv=new JLabel("Niveau: ");
public static JLabel an=new JLabel("Année Universitaire: ");
public static JLabel rentr=new JLabel("Date d'entrer: ");
public static JLabel mess=new JLabel("Ce numero n'est pas Inscrit ");
public static JLabel mess1=new JLabel("Entrer l'année Universitaire ");
public static JLabel mess2=new JLabel("Entrer la date de rentrer ");
public static JLabel mess3=new JLabel("la date de rentrer est Invalide ");
public static JLabel mess4=new JLabel("le numero est invalide ");


public static String niveau []= {"L1","L2","L3","M1","M2"};
public static  JTextField numC = new  JTextField();
public static JTextField ligne2=new JTextField();
@SuppressWarnings({ "unchecked", "rawtypes" })
public static  JComboBox nivC=new JComboBox(niveau);
public static  FieldFormat anC=new FieldFormat("anne");
public static  FieldFormat rentreF=new FieldFormat("date");

public static  JButton creer = new  JButton("Créer");
public static  JButton annule = new  JButton("Annuler");

public static String nom;
public static String prenom;
public static String dateNaiss;
public static String lieuNaiss;

public static int k=0;

public  Fenetre(JFrame parent){
	super(parent);
}

	public  Fenetre(JFrame parent, String title, boolean modal){
		Fenetre.title=title;

		dial.setTitle( title );
		dial.setResizable(false);
		dial.setSize(280,280);
		dial.setModalityType(ModalityType.APPLICATION_MODAL);
		dial.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		dial.setLocationRelativeTo(parent);
		dial.getContentPane().add(content, BorderLayout.CENTER);
		dial.getContentPane().add(control, BorderLayout.SOUTH);
		
		initComponent();
		numC.addKeyListener(this);
		ligne2.addKeyListener(this);
		anC.addKeyListener(this);
		rentreF.addKeyListener(this);
	}

	public static  void initComponent(){
		titre=new JLabel("<html> <div id='bloc_page'>"
                + " <font face= 'algerian' size='4'> <b> "+title+" </b> "
                + "</font></i></p>"
                + " </div></html>");
		titre.setPreferredSize(new Dimension(250,50));
		titre.setHorizontalAlignment(JLabel.CENTER);
		Border test =BorderFactory.createEtchedBorder();
		titre.setBorder(test);
		JPanel ligne1=new JPanel();
		ligne1.setPreferredSize(new Dimension(92,1));
		
		JLabel numAt=new JLabel("Numero:");
		
		ligne2.setPreferredSize(new Dimension(80,20));
		
		JPanel ligne3=new JPanel();
		ligne3.setPreferredSize(new Dimension(35,1));
		
		JPanel ligne4=new JPanel();
		ligne4.setPreferredSize(new Dimension(65,1));
	    
	    
		JPanel panNom = new  JPanel();
		panNom.setBackground(Color.yellow);

		panNom.setPreferredSize(new  Dimension(400,400));
		
		numC.setPreferredSize(new  Dimension(140, 20));
		mess.setForeground(Color.red);
		mess1.setForeground(Color.red);
		mess2.setForeground(Color.red);
		mess3.setForeground(Color.red);
		mess4.setForeground(Color.red);
		
		Document doc=numC.getDocument();
		doc.addDocumentListener(new DocumentListener() {
			public void removeUpdate(DocumentEvent e) {
				update(e);
			}
			
			public void insertUpdate(DocumentEvent e) {
				update(e);
			}
			
			public void changedUpdate(DocumentEvent e) {
				update(e);
			}
			private void update(DocumentEvent e ) {
				boolean enable=e.getDocument().getLength()>3;
				if(enable)
				creer.setEnabled(true);
				else
				creer.setEnabled(false);
				}
		});
		
		
		
		content.add(titre);
		content.add(num);
		content.add(numC);
		//content.add(parc);
		//content.add(parcC);
		//content.add(ligne1);
		content.add(niv);
		content.add(nivC);
		content.add(numAt);
		content.add(ligne2);
		content.add(an);
		content.add(anC);
		content.add(ligne3);
		content.add(rentr);
		content.add(rentreF);
		content.add(ligne4);
		content.add(mess);
		content.add(mess1);
		content.add(mess2);
		content.add(mess3);
		content.add(mess4);
		mess.setVisible(false);
		mess1.setVisible(false);
		mess2.setVisible(false);
		mess3.setVisible(false);
		mess4.setVisible(false);
		content.setBackground(Color.white);
		creer.setEnabled(false);
		control.add(creer);	
		control.add(annule);	
		
		switch(title) {
		case "Certificat de Scolarité":
			rentr.setVisible(false);
			rentreF.setVisible(false);
			ligne4.setVisible(false);
			
			an.setVisible(true);
			anC.setVisible(true);
			ligne3.setVisible(true);
			k=1;
		break;
		
		case "Certificat d'Assuidite":
			rentr.setVisible(true);
			rentreF.setVisible(true);
			ligne4.setVisible(true);
			
			an.setVisible(false);
			anC.setVisible(false);
			ligne3.setVisible(false);
			k=2;
		break;
		
		case "Attestation d'Inscription":
			rentr.setVisible(false);
			rentreF.setVisible(false);
			ligne4.setVisible(false);
			
			an.setVisible(true);
			anC.setVisible(true);
			ligne3.setVisible(true);
			k=3;
		break;
		case "Attestation de validation de crédit":
			rentr.setVisible(false);
			rentreF.setVisible(false);
			ligne4.setVisible(false);
			
			an.setVisible(true);
			anC.setVisible(true);
			ligne3.setVisible(true);
			k=4;
		break;
		}
		
		numC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				mess.setVisible(false);
			}
		});
		
		anC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				mess1.setVisible(false);
			}
		});
		
		ligne2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				mess4.setVisible(false);
			}
		});
		
		rentreF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mess3.setVisible(false);
				mess2.setVisible(false);
			}
		});
		
		annule.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				reset();
				mess.setVisible(false);
				dial.dispose();
			}
		});	
		
	}
		
	
	public static void reset() {
		numC.setText("");
		anC.setText("");
		ligne2.setText("");
		nivC.setSelectedIndex(0);
		rentreF.setText("");
		
	}
	
	public static void main(String[] argv) {
		new Fenetre(null,"",true);
		Fenetre.dial.setVisible(true);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			String an="";
			if(Fenetre.k==1 || Fenetre.k==3 || Fenetre.k==4 )
				an=Fenetre.anC.getText();
			else
				an=Fenetre.rentreF.getText();
			DataBase.crerCert(Fenetre.k,Fenetre.numC.getText(),(String)Fenetre.nivC.getSelectedItem(),an,Fenetre.ligne2.getText());
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			System.out.println("a");
			}
		
	}

	
	
}
