package loading;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import login.LoginPrincipale;

public  class CliqueSouris {
	
	
	public static void action() {
		
		LoginPrincipale.change.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				LoginPrincipale.change.setForeground(Color.black);
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				LoginPrincipale.change.setForeground(Color.white);
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				LoginPrincipale.panAnne.setVisible(true);
				LoginPrincipale.panAnne1.setVisible(false);
			}
		});
			
		
		LoginPrincipale.nouv.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				LoginPrincipale.nouv.setForeground(Color.black);
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				LoginPrincipale.nouv.setForeground(Color.white);
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				LoginPrincipale.panAnne1.setVisible(true);
				LoginPrincipale.panAnne.setVisible(false);
			}
		});
		
		LoginPrincipale.panelPrincipale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				LoginPrincipale.panAnne1.setVisible(false);
				LoginPrincipale.panAnne.setVisible(false);
			}
		});
		
		LoginPrincipale.gestCartf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				LoginPrincipale.jpmF.show(LoginPrincipale.gestCartf,arg0.getX(),arg0.getY());
			}
		});
		
		LoginPrincipale.gestCartd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				LoginPrincipale.jpmD.show(LoginPrincipale.gestCartd,arg0.getX(),arg0.getY());
			}
		});
		
		LoginPrincipale.cert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				LoginPrincipale.jpmC.show(LoginPrincipale.cert,arg0.getX(),arg0.getY());
			}
		});
		
		
		
	}	
	

}
