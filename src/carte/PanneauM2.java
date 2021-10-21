package carte;



import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import loading.Loading;
@SuppressWarnings("serial")
	public  class  PanneauM2  extends  JPanel {
	public  String path= null;
	
	public PanneauM2(String path) {
		this.path=path;
	}
	
		public  void paintComponent(Graphics g){
			File f=new File(path);
			ImageIcon img_boiss;
			try  {
				if(!f.exists()) {
					 img_boiss= new ImageIcon(Loading.class.getResource("/default.jpg"));
				}else
				 img_boiss= new ImageIcon(path);
				Image img =img_boiss.getImage();
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(),this);
			} catch  (Exception e) {
				e.printStackTrace();
			}
		}
	}
