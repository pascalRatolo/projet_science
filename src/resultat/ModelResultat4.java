package resultat;
import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class ModelResultat4 extends AbstractTableModel { 
	@SuppressWarnings("rawtypes")
	List feeds;
  public ModelResultat4(@SuppressWarnings("rawtypes") List feeds) {   
	  this.feeds=feeds;
  }
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
public Class getColumnClass(int columnIndex) { 
     return RecuperInfo4.class; 
     }     
public int getColumnCount() { 
     return 1; 
}     
  public String getColumnName(int columnIndex) { 
	  return ""; }  
  
  public int getRowCount() { 
	  return feeds.size(); 
	  
  } 
  
  public Object getValueAt(int rowIndex, int columnIndex) {
	  Object k=null;
	  k=(feeds == null) ? null : feeds.get(rowIndex);

	 return k;
	  }
  
  public boolean isCellEditable(int columnIndex, int rowIndex) { 
	  return true; 
	  } 
}