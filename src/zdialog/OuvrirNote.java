package zdialog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import data_base.DataBase;

@SuppressWarnings("serial")
public class OuvrirNote extends JPanel{
	public JPanel pane=new JPanel();
	public JDialog dial=new JDialog();
	public JPanel panelPrincipale= new JPanel();
	public JPanel panel= new JPanel();
	
	public JLabel mdpChefSco=new JLabel("Mot de passe Chef Scolarité");
	public JLabel mdpchefMent=new JLabel("Mot de passe Chef de la Mention");
	public JPasswordField chefSco=new JPasswordField();
	public JPasswordField chefMent=new JPasswordField();
	
	public JLabel mess1=new JLabel("Mot de passe invalide ");
	public JLabel mess2=new JLabel("Mot de passe invalide ");
	
	public JButton valide=new JButton("Valider");
	public JButton annul=new JButton("Annuler");
	public Font police=new Font("arial",Font.BOLD,12);
	String postmention;
	JButton pan[];
	JButton pan1[];
	JComboBox<String> box[];
	int k;
	public JDialog parent;
	public OuvrirNote(JDialog parent,String title,String postmention,JButton pan[],JButton pan1[],JComboBox<String> box[],int k)  {
	
	this.postmention=postmention;
	this.parent=parent;
	this.pan=pan;
	this.pan1=pan1;
	this.box=box;
	this.k=k;
		
		panel.add(valide);
		panel.add(annul);
		mdpChefSco.setFont(police);
		mdpchefMent.setFont(police);
		
		chefSco.setPreferredSize(new Dimension(200,20));
		chefMent.setPreferredSize(new Dimension(200,20));
		panelPrincipale.add(mdpChefSco);
		panelPrincipale.add(chefSco);
		panelPrincipale.add(mess1);
		
		mess1.setVisible(false);
		mess2.setVisible(false);
		
		mess1.setForeground(Color.red);
		mess2.setForeground(Color.red);
		
		panelPrincipale.add(mdpchefMent);
		panelPrincipale.add(chefMent);
		panelPrincipale.add(mess2);
		
		panelPrincipale.add(panel);
		
		panelPrincipale.setOpaque(true);
		chefSco.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mess1.setVisible(false);
				mess2.setVisible(false);
			}
		});
		chefMent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mess1.setVisible(false);
				mess2.setVisible(false);
			}
		});
		
		valide.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				String mdpSco=DataBase.recuperMdpSco();
				String mdpMent=DataBase.recuperMotDePasseMent(postmention);
				if(chefSco.getText().equals(mdpSco)) {
					if(chefMent.getText().equals(mdpMent)) {
						new Move().start();
						for(int i=0;i<k;i++) {
						pan[i].setEnabled(true);
						pan1[i].setEnabled(true);
						box[i].setEnabled(true);
						}
					}else
						mess2.setVisible(true);
				}else
					mess1.setVisible(true);
			}
		});
		
		
		annul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				parent.dispose();
				dial.dispose();
			}
		});
		JPanel vide=new JPanel();
		vide.setPreferredSize(new Dimension(900,200));
		vide.setOpaque(false);
		pane.add(vide);
		pane.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelPrincipale.setPreferredSize(new Dimension(235,150));
		
		pane.add(panelPrincipale);
	}
	
	class Move extends Thread{
		public void run() {
				for(int i=0;i<991;i++) {
					try {
						Thread.sleep(1);
					}catch(InterruptedException ex) {
						//Logger.getLogger(TobbleBtn.class.getName());
					}
					pane.setBounds(i, i, 990-2*i, 690-2*i);
					panelPrincipale.setBounds(panelPrincipale.getX()-i, panelPrincipale.getY()-i, 235-i/5, 150-i/5);
				}
		}
		}
}
