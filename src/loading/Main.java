package loading;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;

import image.ImageBonneQualite;
import login.LoginPrincipale;

	public class Main implements ActionListener{
		JLabel timeLabel= new JLabel();
		SimpleDateFormat sdf= new SimpleDateFormat("HH:mm:ss");
		Timer timer;
		public static JFormattedTextField date2textField;
		public static JFrame main=new JFrame();
		public static int l=0;
		public Main() {
			JPanel an=new JPanel();
			DateFormat displayFormat= new SimpleDateFormat("dd MMMM YYYY");
			DateFormatter displayFormatter= new DateFormatter(displayFormat);
			DefaultFormatterFactory factory= new DefaultFormatterFactory(displayFormatter,displayFormatter);
			date2textField= new JFormattedTextField(factory, new Date());
			date2textField.setEditable(false);
			an.setBackground(Color.white);
			date2textField.setFont(new Font("algerian",Font.PLAIN,20));
			an.setPreferredSize(new Dimension(100,35));
			timeLabel.setFont(new Font("algerian",Font.PLAIN,20));
			timer=new Timer(500,this);
			timer.setRepeats(true);
			timer.start();
			JFrame.setDefaultLookAndFeelDecorated(true);
			main.setIconImage((Image)ImageBonneQualite.scaleImage(30,30,"/logo_fac.jpg"));

			main.setTitle("GESTION DE SCOLARITE");
			main.setResizable(true);
			main.setJMenuBar(Menu.menuBar);
			Action.action();
			an.add(date2textField,BorderLayout.NORTH);
			
			an.add(timeLabel);
			Menu.menuBar.add(an);
			main.setExtendedState(JFrame.MAXIMIZED_BOTH);
			main.setMinimumSize(new Dimension(800,480));
			main.setLocationRelativeTo(null);
			main.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			main.addWindowListener(new WindowAdapter() {
	  			public void windowClosing(WindowEvent e){
	  				int option = JOptionPane.showConfirmDialog(Main.main.getContentPane(),"Voulez-vous Terminer ?","ATTENTION!",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE);
						if(option == JOptionPane.OK_OPTION){
							System.exit(0);
							}
	  				}
	  			});
			main.setContentPane(LoginPrincipale.scrollPane);
			
			
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			timeLabel.setText(sdf.format(new Date(System.currentTimeMillis())));
		}
	}
