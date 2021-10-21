package table;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class TableRec extends DefaultTableModel {
String titre[];
JPanel pan;
JTable tab;
int x,y;

	public boolean isCellEditable(int row, int column) {
		return true;
	};

	
	public TableRec(String titre[],JPanel pan) {
		pan.removeAll();
		this.titre=titre;
		this.pan=pan;
		
		DefaultTableCellRenderer centerRenderer= new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
			this.addColumn("N°Examen");
			this.addColumn("N°Carte");
		for (int i=0; i<titre.length;i++) 
			this.addColumn(titre[i]);
			this.addColumn("EC 1");
			this.addColumn("EC 2");
			this.addColumn("EC 3");
			this.addColumn("EC 4");
			this.addColumn("EC 5");
			
			this.addRow(new Object[] {});
		
			tab = new JTable(this);
		
				for (int i=0; i<titre.length;i++) {
			tab.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
				
				tab.setPreferredScrollableViewportSize(new Dimension(600,30));
				tab.setRowHeight(30);
				tab.setFillsViewportHeight(true);
				pan.add(new JScrollPane(tab));
				
	}
	
	public static void addColonne(DefaultTableModel model,String titre[]) {
					model.setColumnCount(0);
					model.addColumn("N°Examen");
					model.addColumn("N°Carte");
					for (int i=0; i<titre.length;i++) 
						model.addColumn(titre[i]);
					}
}
