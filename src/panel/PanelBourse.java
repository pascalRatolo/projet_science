package panel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import image.ImageBonneQualite;
import image.LoadImage;
import impression.FenetreImpressionListeB;

@SuppressWarnings("serial")
public class PanelBourse extends JPanel{
	String titre;
	JButton ferme= new JButton("F");
	JPanel   tete= new JPanel();
	JPanel   corp= new JPanel();
	JLabel title;
	JTable table;
	JButton bout;
	JButton bout1;
	DefaultTableModel model;
	 Font font=new Font("arial",Font.BOLD,16);
	
	public PanelBourse(String titre,JTable table,JButton bout,DefaultTableModel model) {
		this.titre=titre;
		this.table=table;
		this.bout=bout;
		this.model=model;
		bout1=new JButton( LoadImage.transformeb(100, 25, "/imprimer.jpg"));
		bout1.setPreferredSize(new Dimension(100,25));
		DefaultTableCellRenderer centerRenderer= new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		
		for (int c=0; c<2;c++) 
			table.getColumnModel().getColumn(c).setCellRenderer(centerRenderer);
			table.setPreferredScrollableViewportSize(new Dimension(480,520));
			table.setFillsViewportHeight(true);
			table.getColumnModel().getColumn(0).setPreferredWidth(10);
			table.getColumnModel().getColumn(1).setPreferredWidth(90);
			table.getColumnModel().getColumn(2).setPreferredWidth(270);
		
		title=new JLabel ("ETUDIANTS PASSANTS ET BOURSIERS EN "+titre);
		title.setHorizontalAlignment(JLabel.CENTER);
		
		bout.setPreferredSize(new Dimension(100,25));
		bout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		title.setFont(font);
		title.setPreferredSize(new Dimension(430,25));
		this.setPreferredSize(new Dimension(490,620));
		tete.setPreferredSize(new Dimension(480,30));
		ferme.setPreferredSize(new Dimension(30,25));
		ferme.setIcon(new ImageIcon(ImageBonneQualite.scaleImage(40, 25, "/ferme.png")));
		
		tete.add(title);
		tete.add(ferme);
		this.add(tete);
		this.add(new JScrollPane(table));
		this.add(bout1);
		this.add(bout);
		this.setBackground(Color.white);
		ferme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		bout1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FenetreImpressionListeB(model, titre).setVisible(true);
				
			}
		});
	}

}
