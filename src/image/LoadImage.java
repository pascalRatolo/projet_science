package image;


import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.RenderingHints.Key;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import loading.Loading;

	public class LoadImage {
		public static BufferedImage fermer;
		public static BufferedImage reduire; 
		public static ImageIcon fermer1;
		public static ImageIcon fermer2;
		public static ImageIcon reduire1;
		public static ImageIcon reduire2;
		
		public static void init()
			{
			fermer = imageLoader("/quite.png");
			reduire = imageLoader("/reduire.png");
			crop();
			}
		
		public static BufferedImage imageLoader(String path){
			try
			{
				return ImageIO.read(Loading.class.getResource(path));
			} catch (IOException e) 
				{ e.printStackTrace();
				// System.exit(1);
				}
			return null;
		}
		
		@SuppressWarnings("unchecked")
		public static BufferedImage transformel(int x, int y,String path) {
			BufferedImage bi=null;
			ImageIcon icon=null;
			try {
				 icon = new ImageIcon(Loading.class.getResource(path));
				 bi=new BufferedImage(x,y,BufferedImage.TYPE_INT_RGB);
				 Graphics2D g2d= (Graphics2D)bi.createGraphics();
				 g2d.setRenderingHints(new RenderingHints((Map<Key, ?>) RenderingHints.KEY_RENDERING));
				 g2d.drawImage(icon.getImage(), 0, 0, x, y, null);
			}catch(Exception e) {
				
			}
			
			return bi;
		}
		
		public static ImageIcon transformeb(int x, int y,String path) {
			ImageIcon icon=null;
			try {
				 icon = new ImageIcon(Loading.class.getResource(path));
				 Image img_boiss_1 = icon.getImage();
				 Image img_boiss_11=img_boiss_1.getScaledInstance(x,y, java.awt.Image.SCALE_REPLICATE);
				icon= new ImageIcon(img_boiss_11);
			}catch(Exception e) {
				
			}
			
			return icon;
		}
		
			public static ImageIcon transforme1(int x, int y,String path) {
			
			ImageIcon icon = new ImageIcon(path);
			Image img_boiss_1 = icon.getImage();
			Image img_boiss_11=img_boiss_1.getScaledInstance(x,y, java.awt.Image.SCALE_REPLICATE);
			icon= new ImageIcon(img_boiss_11);
			return icon;
		}
		
		public static void crop()
		{
			
			fermer1 = new ImageIcon(fermer.getSubimage(0, 0, 26, 20));
			fermer2 =new ImageIcon(fermer.getSubimage(32, 0, 28, 20));
			reduire1 = new ImageIcon(reduire.getSubimage(0, 0, 26, 20));
			reduire2 =new ImageIcon(reduire.getSubimage(32, 0, 28, 20));
		}
	}