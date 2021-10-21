package table;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class TableModel extends DefaultTableModel {
String titre[];
JPanel pan;
JTable tab;
JTable table;
int x,y;

	public boolean isCellEditable(int row, int column) {
		return false;
	};

	public TableModel(String titre[],JPanel pan,int x,int y) {
		this.titre=titre;
		this.pan=pan;
		this.x=x;
		this.y=y;
		
		DefaultTableCellRenderer centerRenderer= new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		for (int i=0; i<titre.length;i++) 
			this.addColumn(titre[i]);
			tab = new JTable(this);
		
				for (int i=0; i<titre.length;i++) {
			tab.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
			//tab.getColumnModel().getColumn(i).setPreferredWidth(150);
		}
				
				tab.setPreferredScrollableViewportSize(new Dimension(x,y));
				tab.setFillsViewportHeight(true);
				tab.getColumnModel().getColumn(0).setPreferredWidth(150);
				tab.getColumnModel().getColumn(1).setPreferredWidth(80);
				pan.add(new JScrollPane(tab));
				
	}	
	
	public TableModel(String titre[],int l) {
		this.titre=titre;
		DefaultTableCellRenderer centerRenderer= new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		for (int i=0; i<titre.length;i++) 
			this.addColumn(titre[i]);
		/*	tab = new JTable(this);
		
				for (int i=0; i<titre.length;i++) {
			tab.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
				
				tab.setPreferredScrollableViewportSize(new Dimension(x,y));
				tab.setFillsViewportHeight(true);
				tab.getColumnModel().getColumn(col1).setPreferredWidth(3);
				tab.getColumnModel().getColumn(col2).setPreferredWidth(50);
				tab.getColumnModel().getColumn(col3).setPreferredWidth(250);
				
				pan.add(new JScrollPane(tab));*/
				
	}	
	public TableModel(String titre[]) {
		this.titre=titre;
		
		for (int i=0; i<titre.length;i++) 
			this.addColumn(titre[i]);
				
	}	
	
	public TableModel(String titre[],boolean te) {
		this.titre=titre;
		DefaultTableCellRenderer centerRenderer= new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		for (int i=0; i<titre.length;i++) 
			this.addColumn(titre[i]);
		
		
				
	}	
	
	public TableModel(String titre[],JPanel pan) {
		pan.removeAll();
		this.titre=titre;
		this.pan=pan;
		
		DefaultTableCellRenderer centerRenderer= new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
			this.addColumn("N°Examen");
			this.addColumn("N°Carte");
		for (int i=0; i<titre.length;i++) 
			this.addColumn(titre[i]);
			this.addColumn("Moyenne");
		
			tab = new JTable(this);
		
				for (int i=0; i<titre.length+3;i++) {
			tab.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
				
				tab.setPreferredScrollableViewportSize(new Dimension(700,490));
				tab.setFillsViewportHeight(true);
				pan.add(new JScrollPane(tab));
				
	}
	
	public TableModel(String titre[],String k,int j) {
	 
		this.titre=titre;
		
			this.addColumn("N°Examen");
			this.addColumn("N°Carte");
		for (int i=0; i<titre.length;i++) 
			this.addColumn(titre[i]);
		
	}
	
	public static void addCol(String titre[],DefaultTableModel model) {
		 
		for (int i=0; i<titre.length;i++) 
			model.addColumn(titre[i]);
		
	}
}
