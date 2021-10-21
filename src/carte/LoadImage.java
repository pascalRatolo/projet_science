package carte;



import java.awt.Image;
import java.awt.image.BufferedImage; 
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

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
				return ImageIO.read(JFrame.class.getResource(path));
			} catch (IOException e) 
				{ e.printStackTrace();
				// System.exit(1);
				}
			return null;
		}
		
		public static ImageIcon transforme(int x, int y,String path) {
			
			ImageIcon icon = new ImageIcon(JFrame.class.getResource(path));;
			Image img_boiss_1 = icon.getImage();
			Image img_boiss_11=img_boiss_1.getScaledInstance(x,y, java.awt.Image.SCALE_REPLICATE);
			icon= new ImageIcon(img_boiss_11);
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