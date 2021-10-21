package histgramme;


import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Paint;

import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.SubCategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.GroupedStackedBarRenderer;
import org.jfree.data.KeyToGroupMap;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.StandardGradientPaintTransformer;

@SuppressWarnings("serial")
public class HistParFiliere extends JDialog {
	String [] parc;
	String [] niveau;
	String [] type;
	String title;
	DefaultTableModel model;
    public HistParFiliere(String title,String [] parc,String [] niveau,String [] type,DefaultTableModel model) {
        this.parc=parc;
        this.niveau=niveau;
        this.type=type;
        this.model=model;
        this.title=title;
        final CategoryDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 500));
        setContentPane(chartPanel);
    }

    private CategoryDataset createDataset() {
        DefaultCategoryDataset result = new DefaultCategoryDataset();
        int ligne=1;
        int ligneDep=-1;
        int ligneS=-1;
        int colM=1;
        int colF=4;
        	for(int j=0;j<type.length;j++) {
        		for(int k=0;k<parc.length;k++) {
        			for(int i=0;i<niveau.length;i++) {
        				if(i==0) {
        					if(k==0) {
        		        		//	result.addValue(1, "Passant TCM" , "L1" );
        							
        						result.addValue(5,type[j]+" "+parc[k],niveau[i]);
        						System.out.println(somme(model, 1, colM, colF)+" "+type[j]+" "+parc[k]+" "+niveau[i]);
        						
        					}else {
        						result.addValue(0,type[j]+" "+parc[0],niveau[i]);
        						System.out.println(0+" "+type[j]+" "+parc[k]+" "+niveau[i]);
        						
        					}
        				}else {
	        				if(k!=0) {
	        					ligne=ligneDep+3;
	            				ligneDep=ligne;
	        					result.addValue(somme(model, ligne, colM, colF),type[j]+" "+parc[k],niveau[i]);
	        					System.out.println(somme(model, ligne, colM, colF)+" "+type[j]+" "+parc[k]+" "+niveau[i]);
	        				}else {
	        					result.addValue(0,type[j]+" "+parc[k],niveau[i]);
	        					System.out.println(0+" "+type[j]+" "+parc[k]+" "+niveau[i]);
	        				}
        				}
        			}
        			if(k!=0) {
        			ligneS++;
        			ligneDep=ligneS;
        			}

            		System.out.println();
        	}
        		ligneDep=-1;
        	    ligneS=-1;
        		colM++;
        		colF++;
        		System.out.println();
        		System.out.println();
        }
      return result; 
      }
    /** * Creates a sample chart. * * @param dataset  the dataset for the chart. * * @return A sample chart. */
    private JFreeChart createChart( final CategoryDataset dataset) {
    final JFreeChart chart = ChartFactory.createStackedBarChart(
    title , // chart title
    "Category" , // domain axis label
    "Value" , // range axis label
    dataset, // data
    PlotOrientation.VERTICAL, // the plot orientation
    true, // legend
    true, // tooltips
    false // urls
    ); GroupedStackedBarRenderer renderer = new GroupedStackedBarRenderer();        
    KeyToGroupMap map = new KeyToGroupMap( "G1" );
        String group[]= {"G1","G2","G3"};
        
        for(int i=0;i<type.length;i++) {
        	 for(int j=0;j<parc.length;j++) {
        		 map.mapKeyToGroup(type[i]+" "+parc[j], group[i]);
        		 System.out.println(type[i]+" "+parc[j]+" "+group[i]);
        	 }
        }
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
        SubCategoryAxis domainAxis = new SubCategoryAxis( "Product / Month");        
        domainAxis.setCategoryMargin(0.1);    
        for(int i=0;i<type.length;i++) {
        	domainAxis.addSubCategory(type[i]);
        }
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        CategoryPlot plot = (CategoryPlot) chart.getPlot(); 
        plot.setDomainAxis(domainAxis);
        //plot.setDomainAxisLocation(AxisLocation.TOP_OR_RIGHT);
        plot.setRenderer(renderer);
        plot.setFixedLegendItems(createLegendItems());
        return chart; 
        }

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
    public static void main(final String[] args) {
    	

		String parc[]= {"M.I.S.S","M.E","M.F"};
		String niveau[]= {"L1","L2","L3","M1","M2"};
		String typeEt[]= {"Passant","Redoublant","Triplant"};
		DefaultTableModel model = null;
        final HistParFiliere demo = new HistParFiliere("Stacked Bar Chart",parc,niveau,typeEt,model);
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
       
    }
}
