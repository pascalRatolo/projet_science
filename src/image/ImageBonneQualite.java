package image;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.ImageIcon;

import loading.Loading;

public class ImageBonneQualite{
	public static BufferedImage scaleImage(int x,int y, String filename) {
		BufferedImage bi=null;
		try {
			ImageIcon ii=new ImageIcon(Loading.class.getResource(filename));
			bi=new BufferedImage(x,y,BufferedImage.TYPE_INT_RGB);
			Graphics2D g2d= (Graphics2D) bi.createGraphics();
			g2d.setRenderingHints(new RenderingHints( RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON));
			g2d.setRenderingHints(new RenderingHints( RenderingHints.KEY_RENDERING,
					RenderingHints.VALUE_RENDER_QUALITY));
			g2d.setRenderingHints(new RenderingHints( RenderingHints.KEY_STROKE_CONTROL,
					RenderingHints.VALUE_STROKE_PURE));
			g2d.drawImage(ii.getImage(), 0, 0, x, y, null);
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return bi;
	}
	
	public static BufferedImage scaleImage2(int x,int y, String filename) {
		BufferedImage bi=null;
		File f=new File(filename);
		if(!f.exists()) {
			filename="C:\\Photo_Sciences\\utilisateur\\nopic.jpg";
		}
		try {
			ImageIcon ii=new ImageIcon(filename);
			bi=new BufferedImage(x,y,BufferedImage.TYPE_INT_RGB);
			Graphics2D g2d= (Graphics2D) bi.createGraphics();
			g2d.setRenderingHints(new RenderingHints( RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON));
			g2d.setRenderingHints(new RenderingHints( RenderingHints.KEY_RENDERING,
					RenderingHints.VALUE_RENDER_QUALITY));
			g2d.setRenderingHints(new RenderingHints( RenderingHints.KEY_STROKE_CONTROL,
					RenderingHints.VALUE_STROKE_PURE));
			g2d.drawImage(ii.getImage(), 0, 0, x, y, null);
			
		}catch(Exception e) {
		}
		return bi;
	}
	
	public static ImageIcon image(String file,int x) {
		Image img = null;
		File f=new File(file);
		if(!f.exists()) {
			file="C:/Program Files (x86)/JDev/DataSciences/image/vide.jpg";
		}
	if(file!=null) {
		Toolkit kit=Toolkit.getDefaultToolkit();
		img=kit.getImage(file);
		img=img.getScaledInstance(x, -1, Image.SCALE_SMOOTH);
	}
	return new ImageIcon(img);
	}
	
	public static ImageIcon imageLogo(String file,int x) {
		Image img = null;
		ImageIcon icon;
		File f=new File(file);
		
		if(!f.exists()) {
			icon = new ImageIcon(Loading.class.getResource("/icon.png"));
			 Image img_boiss_1 = icon.getImage();
			 Image img_boiss_11=img_boiss_1.getScaledInstance(x,x, java.awt.Image.SCALE_REPLICATE);
			icon= new ImageIcon(img_boiss_11);
			return icon;
			
		}else {
			Toolkit kit=Toolkit.getDefaultToolkit();
			img=kit.getImage(file);
			img=img.getScaledInstance(x, -1, Image.SCALE_SMOOTH);
			return new ImageIcon(img);
		}
	
	
	}
}