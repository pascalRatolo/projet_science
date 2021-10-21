package carte;
import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class ModelCarte extends AbstractTableModel {   
  @SuppressWarnings("rawtypes")
List feeds;
  public ModelCarte(@SuppressWarnings("rawtypes") List feeds) {     
       this.feeds = feeds;   }
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
public Class getColumnClass(int columnIndex) { 
     return RecuperInfo.class; 
     }     
public int getColumnCount() { 
     return 2; 
}     
  public String getColumnName(int columnIndex) { 
	  return ""; }  
  
  public int getRowCount() { 
	  return (feeds == null) ? 0 : feeds.size()/2; 
  } 
  
  public Object getValueAt(int rowIndex, int columnIndex) {
	  Object k=null;
	 if(columnIndex%2!=0)
	     k=(feeds == null) ? null : feeds.get((rowIndex+1)*(columnIndex+1)-1);
	 else
		 k=(feeds == null) ? null : feeds.get(((rowIndex+1)*(columnIndex+1)+(rowIndex+1)-(columnIndex+1))-1);
	 return k;
	  }
  
  public boolean isCellEditable(int columnIndex, int rowIndex) { 
	  return true; 
	  } 
}