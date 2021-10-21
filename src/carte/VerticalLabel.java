package carte;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class VerticalLabel extends JPanel {
	public Font font=new Font("arial",Font.ITALIC,10);
	
/**
* Nom à afficher.
*/
private String name;
/**
* Constructeur.
* Initialise les valeurs de la classe.
*
* @param name
*/
public VerticalLabel(String name) {
super ();
this.name = name; }
/*
*  (non-Javadoc)
* @see javax.swing.JLabel#setText(java.lang.String)
*/
public void setText(String text) {
name = text; repaint(); 
}
/*
*  (non-Javadoc)
* @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
*/
protected void paintComponent(Graphics graphics) {
Graphics2D graphics2D = (Graphics2D) graphics;
super .paintComponent(graphics); 
graphics2D.setColor(Color.black); 
graphics2D.translate( 0 , getHeight()); 
graphics2D.rotate(-Math.PI/ 2 ); 
graphics2D.setFont(font); 
graphics2D.drawString(name, 0 ,11);
}
/*
*  (non-Javadoc)
* @see java.awt.Component#getPreferredSize()
*/
public Dimension getPreferredSize() {
Dimension dimension = new Dimension(getStringHeight(), getStringWidth());
return dimension; }
/*
*  (non-Javadoc)
* @see java.awt.Component#getMinimumSize()
*/
public Dimension getMinimumSize() {
return getPreferredSize(); 
}
private int getStringWidth() {
FontMetrics metrics = getFontMetrics(font);
int width = metrics.stringWidth(name);
return width; }
private int getStringHeight() {
FontMetrics metrics = getFontMetrics(font);
int height = metrics.getHeight();
return height; }
}