package panel;


import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import loading.Loading;
@SuppressWarnings("serial")
	public  class  Panneau3  extends  JPanel {
	public static String path= null;
	
	public Panneau3(String pathe) {
		path=pathe;
	}
	
		public  void paintComponent(Graphics g){
			try  {
				ImageIcon img_boiss= new ImageIcon(Loading.class.getResource(path));
				Image img =img_boiss.getImage();
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(),this);
			} catch  (Exception e) {
				e.printStackTrace();
			}
		}
	}
