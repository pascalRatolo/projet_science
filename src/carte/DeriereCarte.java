package carte;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableCellRenderer;

public class DeriereCarte implements TableCellRenderer{ 
	
	public static JTextArea titre;
	public static JTextArea text1;
	
	public static JPanel paneTab;
	
	public static Border line= new LineBorder(Color.black);
	public static Border  tite1= new TitledBorder(line,"",TitledBorder.DEFAULT_POSITION,
    		TitledBorder.DEFAULT_POSITION,new Font("arial",Font.BOLD,8),Color.black);
 
	public static Font police=new Font("arial",Font.BOLD,10);
	public static Font police1=new Font("arial",Font.ITALIC,8);
	
	public static JButton imp=new JButton("IMPRIMER");
	public static JFrame main= new JFrame();
	
	public static JScrollPane scrollPane ;
	
		public Component getTableCellRendererComponent(JTable table, Object value,
		boolean isSelected, boolean hasFocus, int row, int column) {     
		     titre=new JTextArea("\n     "
					   + "ETABLISSEMENT : FACULTE DES SCIENCES\n"
                 + "                     "
                 + "      VISITE MEDICALE \n"
                 + "               "
                 + "      MEDECINE PREVENTIVE");
			
			text1=new JTextArea("             "
					+ "Nul ne peut se présenter à l'examen s'il n'a pas subi la visite\n"
					+ "        "
                  + "médicale organisée par le Service de la médecine préventive,\n\n"
                  + "                                    "
                  + "     Signature du Médecin \n\n\n\n\n"
                  + "               "
                  + "NB: il n'est delivré qu'une seule carte pendant l'année,\n"
                  + "l'interessé doit faire une déclaration auprès de la police en cas de perte");	
			//paneBas[i].add(nomSco[i]);
			
			paneTab=new JPanel();
			paneTab.setBorder(tite1);
			paneTab.setBackground(Color.WHITE);
			paneTab.setLayout(new FlowLayout(FlowLayout.LEFT));
			titre.setPreferredSize(new Dimension(245,55));
			text1.setPreferredSize(new Dimension(245,100));
			titre.setFont(police);
			text1.setFont(police1);
			paneTab.setPreferredSize(new Dimension(255,175));
			paneTab.add(titre);
			paneTab.add(text1);
			
		    paneTab.setLayout(new FlowLayout(FlowLayout.LEFT));
		      // panel.setBackground(Color.cyan);  
		       //panel.add(new JLabel(" " + feed.name+ " " + feed.url + "Articles " + feed.articles.length + ""));     
		      //panel.add(showButton);   
		   return paneTab;   
		} 
		}