package histgramme;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Paint;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.axis.SubCategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.GroupedStackedBarRenderer;
import org.jfree.data.KeyToGroupMap;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.StandardGradientPaintTransformer;
/**  * A simple demonstration application showing how to create a stacked bar chart  * using data from a {@link CategoryDataset}.  */
@SuppressWarnings("serial")
public class HistParFil extends JFrame {
	DefaultTableModel model;
	String titre;
/** * Creates a new demo. * * @param title  the frame title. */
public HistParFil( String title,String titre,DefaultTableModel model) {
super (title);
this.model=model;
this.titre=titre;
final CategoryDataset dataset = createDataset();
final JFreeChart chart = createChart(dataset);
final ChartPanel chartPanel = new ChartPanel(chart); 
chartPanel.setPreferredSize( new java.awt.Dimension(590, 350)); 
setContentPane(chartPanel); }
/** * Creates a sample dataset. * * @return A sample dataset. */
private CategoryDataset createDataset() { 
	DefaultCategoryDataset result = new DefaultCategoryDataset();
result.addValue(somme(model, 1, 1, 4), "Passant TCM" , "L1" ); 
result.addValue(0, "Passant TCM" , "L2" );
result.addValue(0, "Passant TCM" , "L3" ); 
result.addValue(0, "Passant TCM" , "M1" );
result.addValue(0, "Passant TCM" , "M2" ); 

result.addValue(0, "Passant MISS" , "L1" ); 
result.addValue(somme(model, 2, 1, 4), "Passant MISS" , "L2" ); 
result.addValue(somme(model, 5, 1, 4), "Passant MISS" , "L3" );
result.addValue(somme(model, 8, 1, 4), "Passant MISS" , "M1" ); 
result.addValue(somme(model, 11, 1, 4), "Passant MISS" , "M2" );

result.addValue(0, "Passant ME" , "L1" );
result.addValue(somme(model, 3, 1, 4), "Passant ME" , "L2" ); 
result.addValue(somme(model, 6, 1, 4), "Passant ME" , "L3" );
result.addValue(somme(model, 9, 1, 4), "Passant ME" , "M1" ); 
result.addValue(somme(model, 12, 1, 4), "Passant ME" , "M2" );

result.addValue(0, "Passant MF" , "L1" ); 
result.addValue(somme(model, 4, 1, 4), "Passant MF" , "L2" ); 
result.addValue(somme(model, 7, 1, 4), "Passant MF" , "L3" );
result.addValue(somme(model, 10, 1, 4), "Passant MF" , "M1" ); 
result.addValue(somme(model, 13, 1, 4), "Passant MF" , "M2" );

result.addValue(somme(model, 1, 2, 5), "Redoublant TCM" , "L1" ); 
result.addValue(0, "Redoublant TCM" , "L2" );
result.addValue(0, "Redoublant TCM" , "L3" ); 
result.addValue(0, "Redoublant TCM" , "M1" );
result.addValue(0, "Redoublant TCM" , "M2" ); 

result.addValue(0, "Redoublant MISS" , "L1" ); 
result.addValue(somme(model, 2, 2, 5), "Redoublant MISS" , "L2" ); 
result.addValue(somme(model, 5, 2, 5), "Redoublant MISS" , "L3" );
result.addValue(somme(model, 8, 2, 5), "Redoublant MISS" , "M1" ); 
result.addValue(somme(model, 11, 2, 5), "Redoublant MISS" , "M2" );

result.addValue(0, "Redoublant ME" , "L1" );
result.addValue(somme(model, 3, 2, 5), "Redoublant ME" , "L2" ); 
result.addValue(somme(model, 6, 2, 5), "Redoublant ME" , "L3" );
result.addValue(somme(model, 9, 2, 5), "Redoublant ME" , "M1" ); 
result.addValue(somme(model, 11, 2, 5), "Redoublant ME" , "M2" );

result.addValue(0, "Redoublant MF" , "L1" ); 
result.addValue(somme(model, 4, 2, 5), "Redoublant MF" , "L2" ); 
result.addValue(somme(model, 7, 2, 5), "Redoublant MF" , "L3" );
result.addValue(somme(model, 10, 2, 5), "Redoublant MF" , "M1" ); 
result.addValue(somme(model, 13, 2, 5), "Redoublant MF" , "M2" );

result.addValue(somme(model, 1, 3, 6), "Triplant TCM" , "L1" ); 
result.addValue(0, "Triplant TCM" , "L2" );
result.addValue(0, "Triplant TCM" , "L3" );
result.addValue(0, "Triplant TCM" , "M1" );
result.addValue(0, "Triplant TCM" , "M2" );

result.addValue(0, "Triplant MISS" , "L1" ); 
result.addValue(somme(model, 2, 3, 6), "Triplant MISS" , "L2" ); 
result.addValue(somme(model, 5, 3, 6), "Triplant MISS" , "L3" );
result.addValue(somme(model, 8, 3, 6), "Triplant MISS" , "M1" ); 
result.addValue(somme(model, 11, 3, 6), "Triplant MISS" , "M2" );

result.addValue(0, "Triplant ME" , "L1" );
result.addValue(somme(model, 3, 3, 6), "Triplant ME" , "L2" ); 
result.addValue(somme(model, 6, 3, 6), "Triplant ME" , "L3" );
result.addValue(somme(model, 9, 3, 6), "Triplant ME" , "M1" ); 
result.addValue(somme(model, 11, 3, 6), "Triplant ME" , "M2" );

result.addValue(0, "Triplant MF" , "L1" ); 
result.addValue(somme(model, 4, 3, 6), "Triplant MF" , "L2" ); 
result.addValue(somme(model, 7, 3, 6), "Triplant MF" , "L3" );
result.addValue(somme(model, 10, 3, 6), "Triplant MF" , "M1" ); 
result.addValue(somme(model, 13, 3, 6), "Triplant MF" , "M2" );

return result; 
}
/* * * Creates a sample chart. 
 * * * @param dataset  the dataset for the chart.
 * * * @return A sample chart. */

private JFreeChart createChart( final CategoryDataset dataset) {
final JFreeChart chart = ChartFactory.createStackedBarChart(
		titre, // chart title
"Category" , // domain axis label
"Value" , // range axis label
dataset, // data
PlotOrientation.VERTICAL, // the plot orientation
true, // legend
false, // tooltips
false // urls
); GroupedStackedBarRenderer renderer = new GroupedStackedBarRenderer();        
KeyToGroupMap map = new KeyToGroupMap( "G1" );
map.mapKeyToGroup( "Passant TCM" , "G1" );
map.mapKeyToGroup( "Passant MISS" , "G1" );
map.mapKeyToGroup( "Passant ME" , "G1" ); 
map.mapKeyToGroup( "Passant MF" , "G1" );

map.mapKeyToGroup( "Redoublant TCM" , "G2" );
map.mapKeyToGroup( "Redoublant MISS" , "G2" );
map.mapKeyToGroup( "Redoublant ME" , "G2" );
map.mapKeyToGroup( "Redoublant MF" , "G2" );

map.mapKeyToGroup( "Triplant TCM" , "G3" );
map.mapKeyToGroup( "Triplant MISS" , "G3" ); 
map.mapKeyToGroup( "Triplant ME" , "G3" ); 
map.mapKeyToGroup( "Triplant MF" , "G3" ); 
renderer.setSeriesToGroupMap(map); 
renderer.setItemMargin(0.0); 

Paint p1 = new GradientPaint( 0.0f, 0.0f, new Color(0x22, 0x22, 0xFF), 0.0f, 0.0f, 
		new Color(0x88, 0x88, 0xFF));         
renderer.setSeriesPaint(0, p1);        
renderer.setSeriesPaint(4, p1);        
renderer.setSeriesPaint(8, p1);        

Paint p2 = new GradientPaint( 0.0f, 0.0f, new Color(0x22, 0xFF, 0x22), 0.0f, 0.0f, new Color(0x88, 0xFF, 0x88) );         
renderer.setSeriesPaint(1, p2);         
renderer.setSeriesPaint(5, p2);        
renderer.setSeriesPaint(9, p2);         

Paint p3 = new GradientPaint( 0.0f, 0.0f, new Color(0xFF, 0x22, 0x22), 0.0f, 0.0f, new Color(0xFF, 0x88, 0x88));        
renderer.setSeriesPaint(2, p3);         
renderer.setSeriesPaint(6, p3);        
renderer.setSeriesPaint(10, p3);         

Paint p4 = new GradientPaint( 0.0f, 0.0f, new Color(0xFF, 0xFF, 0x22), 0.0f, 0.0f, new Color(0xFF, 0xFF, 0x88) );         
renderer.setSeriesPaint(3, p4);         
renderer.setSeriesPaint(7, p4);         
renderer.setSeriesPaint(11, p4);

renderer.setGradientPaintTransformer(new StandardGradientPaintTransformer(GradientPaintTransformType.HORIZONTAL));        
SubCategoryAxis domainAxis = new SubCategoryAxis( "");        
domainAxis.setCategoryMargin(0.05);        
domainAxis.addSubCategory( "Passant" );
domainAxis.addSubCategory( "Radoublant" ); 
domainAxis.addSubCategory( "Triplant" ); 
CategoryPlot plot = (CategoryPlot) chart.getPlot(); 
plot.setDomainAxis(domainAxis);
//plot.setDomainAxisLocation(AxisLocation.TOP_OR_RIGHT);
plot.setRenderer(renderer);
plot.setFixedLegendItems(createLegendItems());
return chart; }
/** * Creates the legend items for the chart.  
 * In this case, we set themmanually because we 
 * * only want legend items for a subset of the data series. 
 * * * @return The legend items. */
private LegendItemCollection createLegendItems() { 
	LegendItemCollection result = new LegendItemCollection();
LegendItem item1 = new LegendItem("TCM", new Color(0x22, 0x22, 0xFF));
     LegendItem item2 = new LegendItem("MISS", new Color(0x22, 0xFF, 0x22));
   LegendItem item3 = new LegendItem("ME", new Color(0xFF, 0x22,0x22));
  LegendItem item4 = new LegendItem("MF", new Color(0xFF, 0xFF, 0x22));        
  result.add(item1);      
  result.add(item2);   
  result.add(item3);  
  result.add(item4);
return result; 
}

public static int somme(DefaultTableModel model,int ligne,int col1,int col2) {
	
	return Integer.parseInt(String.valueOf(model.getValueAt(ligne, col1)))+
			Integer.parseInt(String.valueOf(model.getValueAt(ligne, col2)));
	
}
// ****************************************************************************
// * JFREECHART DEVELOPER GUIDE*
// * The JFreeChart Developer Guide, written by David Gilbert, is available   *
// * to purchase from Object Refinery Limited:*
// **
// * http://www.object-refinery.com/jfreechart/guide.html*
// **
// * Sales are used to provide funding for the JFreeChart project - please    *
// * support us so that we can continue developing free software.*
// ****************************************************************************
/** * Starting point for the demonstration application. * * @param args  ignored. */
public static void main( final String[] args) {
//final StackedBarChart1 demo = new StackedBarChart1( "Stacked Bar Chart Demo 4" ); 
//demo.pack(); RefineryUtilities.centerFrameOnScreen(demo); 
//demo.setVisible(true); 
	}
}