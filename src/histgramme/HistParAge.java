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
public class HistParAge extends JFrame {
	DefaultTableModel model;
	String title;
/** * Creates a new demo. * * @param title  the frame title. */
public HistParAge( String title,DefaultTableModel model) {
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
result.addValue(somme1(model, 1, 1), "Homme Passant" , "[--,16[" ); 
result.addValue(somme2(model, 2, 1), "Homme Passant" , "[16,20[" );
result.addValue(somme2(model, 6, 1), "Homme Passant" , "[20,24[" ); 
result.addValue(somme2(model, 10, 1), "Homme Passant" , "[24,28[" );
result.addValue(somme3(model, 14, 1), "Homme Passant" , "[28,++[" ); 

result.addValue(somme1(model, 1, 2), "Homme Redoublant" , "[--,16[" ); 
result.addValue(somme2(model, 2, 2), "Homme Redoublant" , "[16,20[" ); 
result.addValue(somme2(model, 6, 2), "Homme Redoublant" , "[20,24[" );
result.addValue(somme2(model, 10, 2), "Homme Redoublant" , "[24,28[" ); 
result.addValue(somme3(model, 14, 2), "Homme Redoublant" , "[28,++[" );

result.addValue(somme1(model, 1, 3), "Homme Triplant" , "[--,16[" );
result.addValue(somme2(model, 2, 3), "Homme Triplant" , "[16,20[" ); 
result.addValue(somme2(model, 6, 3), "Homme Triplant" , "[20,24[" );
result.addValue(somme2(model, 10, 3), "Homme Triplant" , "[24,28[" ); 
result.addValue(somme3(model, 11, 3), "Homme Triplant" , "[28,++[" );


result.addValue(somme1(model, 1, 5), "Femme Passant" , "[--,16[" ); 
result.addValue(somme2(model, 2, 5), "Femme Passant" , "[16,20[" );
result.addValue(somme2(model, 6, 5), "Femme Passant" , "[20,24[" ); 
result.addValue(somme2(model, 10, 5), "Femme Passant" , "[24,28[" );
result.addValue(somme3(model, 14, 5), "Femme Passant" , "[28,++[" ); 

result.addValue(somme1(model, 1, 6), "Femme Redoublant" , "[--,16[" ); 
result.addValue(somme2(model, 2, 6), "Femme Redoublant" , "[16,20[" ); 
result.addValue(somme2(model, 6, 6), "Femme Redoublant" , "[20,24[" );
result.addValue(somme2(model, 10, 6), "Femme Redoublant" , "[24,28[" ); 
result.addValue(somme3(model, 14,6), "Femme Redoublant" , "[28,++[" );

result.addValue(somme1(model, 1, 7), "Femme Triplant" , "[--,16[" );
result.addValue(somme2(model, 2, 7), "Femme Triplant" , "[16,20[" ); 
result.addValue(somme2(model, 6, 7), "Femme Triplant" , "[20,24[" );
result.addValue(somme2(model, 10, 7), "Femme Triplant" , "[24,28[" ); 
result.addValue(somme3(model, 14, 7), "Femme Triplant" , "[28,++[" );

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
map.mapKeyToGroup( "Homme Passnt" , "G1" );
map.mapKeyToGroup( "Homme Redoublant" , "G1" );
map.mapKeyToGroup( "Homme Triplant" , "G1" ); 

map.mapKeyToGroup( "Femme Passant" , "G2" );
map.mapKeyToGroup( "Femme Redoublant" , "G2" );
map.mapKeyToGroup( "Femme Triplant" , "G2" );

renderer.setSeriesToGroupMap(map); 
renderer.setItemMargin(0.0); 

Paint p1 = new GradientPaint( 0.0f, 0.0f, new Color(0x22, 0x22, 0xFF), 0.0f, 0.0f, 
		new Color(0x88, 0x88, 0xFF));         
renderer.setSeriesPaint(0, p1);        
renderer.setSeriesPaint(3, p1);        
renderer.setSeriesPaint(6, p1);
renderer.setSeriesPaint(9, p1);
renderer.setSeriesPaint(12, p1);

Paint p2 = new GradientPaint( 0.0f, 0.0f, new Color(0x22, 0xFF, 0x22), 0.0f, 0.0f, new Color(0x88, 0xFF, 0x88) );         
renderer.setSeriesPaint(1, p2);         
renderer.setSeriesPaint(4, p2);        
renderer.setSeriesPaint(7, p2);
renderer.setSeriesPaint(10, p2);
renderer.setSeriesPaint(13, p2);

Paint p3 = new GradientPaint( 0.0f, 0.0f, new Color(0xFF, 0x22, 0x22), 0.0f, 0.0f, new Color(0xFF, 0x88, 0x88));        
renderer.setSeriesPaint(2, p3);         
renderer.setSeriesPaint(5, p3);        
renderer.setSeriesPaint(8, p3); 
renderer.setSeriesPaint(11, p3); 
renderer.setSeriesPaint(14, p3); 

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
	LegendItem item1 = new LegendItem("Passant", new Color(0x22, 0x22, 0xFF));
    LegendItem item2 = new LegendItem("Redoublant", new Color(0x22, 0xFF, 0x22));
    LegendItem item3 = new LegendItem("Triplant", new Color(0xFF, 0x22,0x22));  
    
  result.add(item1);      
  result.add(item2);   
  result.add(item3); 
return result; 
}

public static int somme1(DefaultTableModel model,int ligne,int col1) {
	return Integer.parseInt(String.valueOf(model.getValueAt(ligne, col1)));
}

public static int somme2(DefaultTableModel model,int ligne,int col1) {
	int S=0;
	for(int i=ligne;i<ligne+4;i++)
		S=S+Integer.parseInt(String.valueOf(model.getValueAt(i, col1)));
	return S;
}

public static int somme3(DefaultTableModel model,int ligne,int col1) {
	int S=0;
	for(int i=ligne;i<ligne+2;i++)
		S=S+Integer.parseInt(String.valueOf(model.getValueAt(i, col1)));
	return S;
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