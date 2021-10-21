package reinscription;

import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class Verification extends DefaultTableModel{
	public  static String titleSems[]= {"S1","S2","S3","S4","S5","S6","S7","S8","S9","S10"};
	
	public static DefaultTableModel model( DefaultTableModel modelSems,String num,boolean oui) {
		modelSems= new DefaultTableModel(){
			public Class <?>getColumnClass(int Column) {
				return Boolean.class;
			}
			public boolean isCellEditable(int row, int col){
			return oui;
			}
		};
		for (int i=0; i<titleSems.length;i++) 
			modelSems.addColumn(titleSems[i]);
		
		if(!oui) {
		    return modelSems;
		}else {
			modelSems.addRow(new Object[] {false,false,false,false,false,false,false,false,false,false});
			return modelSems;
			}
		
		
		
   }
}
