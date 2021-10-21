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
public class HistParSex extends JFrame {
	DefaultTableModel model;
	String title;
/** * Creates a new demo. * * @param title  the frame title. */
public HistParSex( String title,DefaultTableModel model) {
super (title);
this.model=model;
this.title=title;
final CategoryDataset dataset = createDataset();
final JFreeChart chart = createChart(dataset);
final ChartPanel chartPanel = new ChartPanel(chart); 
chartPanel.setPreferredSize( new java.awt.Dimension(590, 350)); 
setContentPane(chartPanel); }
/** * Creates a sample dataset. * * @return A sample dataset. */
private CategoryDataset createDataset() { 
	DefaultCategoryDataset result = new DefaultCategoryDataset();
result.addValue(somme(model, 1, 7), "Homme TCM" , "L1" ); 
result.addValue(0, "Homme TCM" , "L2" );
result.addValue(0, "Homme TCM" , "L3" ); 
result.addValue(0, "Homme TCM" , "M1" );
result.addValue(0, "Homme TCM" , "M2" ); 

result.addValue(0, "Homme MISS" , "L1" ); 
result.addValue(somme(model, 2, 7), "Homme MISS" , "L2" ); 
result.addValue(somme(model, 5, 7), "Homme MISS" , "L3" );
result.addValue(somme(model, 8, 7), "Homme MISS" , "M1" ); 
result.addValue(somme(model, 11, 7), "Homme MISS" , "M2" );

result.addValue(0, "Homme ME" , "L1" );
result.addValue(somme(model, 3, 7), "Homme ME" , "L2" ); 
result.addValue(somme(model, 6, 7), "Homme ME" , "L3" );
result.addValue(somme(model, 9, 7), "Homme ME" , "M1" ); 
result.addValue(somme(model, 12, 7), "Homme ME" , "M2" );

result.addValue(0, "Homme MF" , "L1" ); 
result.addValue(somme(model, 4, 7), "Homme MF" , "L2" ); 
result.addValue(somme(model, 7, 7), "Homme MF" , "L3" );
result.addValue(somme(model, 10, 7), "Homme MF" , "M1" ); 
result.addValue(somme(model, 13, 7), "Homme MF" , "M2" );

result.addValue(somme(model, 1, 8), "Femme TCM" , "L1" ); 
result.addValue(0, "Femme TCM" , "L2" );
result.addValue(0, "Femme TCM" , "L3" ); 
result.addValue(0, "Femme TCM" , "M1" );
result.addValue(0, "Femme TCM" , "M2" ); 

result.addValue(0, "Femme MISS" , "L1" ); 
result.addValue(somme(model, 2, 8), "Femme MISS" , "L2" ); 
result.addValue(somme(model, 5, 8), "Femme MISS" , "L3" );
result.addValue(somme(model, 8, 8), "Femme MISS" , "M1" ); 
result.addValue(somme(model, 11,8), "Femme MISS" , "M2" );

result.addValue(0, "Femme ME" , "L1" );
result.addValue(somme(model, 3, 8), "Femme ME" , "L2" ); 
result.addValue(somme(model, 6, 8), "Femme ME" , "L3" );
result.addValue(somme(model, 9, 8), "Femme ME" , "M1" ); 
result.addValue(somme(model, 11, 8), "Femme ME" , "M2" );

result.addValue(0, "Femme MF" , "L1" ); 
result.addValue(somme(model, 4, 8), "Femme MF" , "L2" ); 
result.addValue(somme(model, 7, 8), "Femme MF" , "L3" );
result.addValue(somme(model, 10, 8), "Femme MF" , "M1" ); 
result.addValue(somme(model, 13, 8), "Femme MF" , "M2" );
return result; 
}
/* * * Creates a sample chart. 
 * * * @param dataset  the dataset for the chart.
 * * * @return A sample chart. */

private JFreeChart createChart( final CategoryDataset dataset) {
final JFreeChart chart = ChartFactory.createStackedBarChart(
title , // chart title
"Category" , // domain axis label
"Value" , // range axis label
dataset, // data
PlotOrientation.VERTICAL, // the plot orientation
true, // legend
false, // tooltips
false // urls
); GroupedStackedBarRenderer renderer = new GroupedStackedBarRenderer();        
KeyToGroupMap map = new KeyToGroupMap( "G1" );
map.mapKeyToGroup( "Homme TCM" , "G1" );
map.mapKeyToGroup( "Homme MISS" , "G1" );
map.mapKeyToGroup( "Homme ME" , "G1" ); 
map.mapKeyToGroup( "Homme MF" , "G1" );

map.mapKeyToGroup( "Femme TCM" , "G2" );
map.mapKeyToGroup( "Femme MISS" , "G2" );
map.mapKeyToGroup( "Femme ME" , "G2" );
map.mapKeyToGroup( "Femme MF" , "G2" );

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
domainAxis.addSubCategory( "Homme" );
domainAxis.addSubCategory( "Femme" ); 
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

public static int somme(DefaultTableModel model,int ligne,int col1) {
	return Integer.parseInt(String.valueOf(model.getValueAt(ligne, col1)));
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