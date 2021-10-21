package histgramme;


import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.awt.Rectangle;

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
public class HistParSexe extends JDialog {
	String [] parc;
	String [] niveau;
	String [] sexe;
	String title;
	DefaultTableModel model;
    public HistParSexe(String title,String [] parc,String [] niveau,String [] sexe,DefaultTableModel model) {
        this.parc=parc;
        this.niveau=niveau;
        this.sexe=sexe;
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
        int colM=7;
        int colF=8;
        int col=0;
        	for(int j=0;j<sexe.length;j++) {
        		if(j==0)
        			col=colM;
        		else
        			col=colF;
        		for(int k=0;k<parc.length;k++) {
        			
        			for(int i=0;i<niveau.length;i++) {
        				if(niveau[i]=="L1") {
        					ligne=1;
        					if(k==0)
        						result.addValue(somme(model, ligne, col),sexe[j]+" "+parc[k],niveau[i]);
        					else
        						result.addValue(0,sexe[j]+" "+parc[k],niveau[i]);
        				}else {
        				ligne=ligneDep+3;
        				ligneDep=ligne;
        				result.addValue(somme(model, ligne, col),sexe[j]+" "+parc[k],niveau[i]);
        				}
        		}
        			ligneS++;
        			ligneDep=ligneS;
        	}
        		ligneDep=-1;
        	    ligneS=-1;
        }
        return result;
    }

    private JFreeChart createChart(final CategoryDataset dataset) {

        final JFreeChart chart = ChartFactory.createStackedBarChart(
               title, "Category", "Effectif", dataset,
                PlotOrientation.VERTICAL, true, true, false);

        chart.setBackgroundPaint(new Color(249, 231, 236));

        GroupedStackedBarRenderer renderer = new GroupedStackedBarRenderer();
        KeyToGroupMap map = new KeyToGroupMap("G1");
        String group[]= {"G1","G2"};
        
        for(int i=0;i<sexe.length;i++) {
        	 for(int j=0;j<parc.length;j++) {
        		 map.mapKeyToGroup(sexe[i]+" "+parc[j], group[i]);
        	 }
        }
        renderer.setSeriesToGroupMap(map);


        renderer.setItemMargin(0.0);
       Paint p1 = new GradientPaint(
                0.0f, 0.0f, new Color(16, 89, 172), 0.0f, 0.0f, new Color(201, 201, 244));
        renderer.setSeriesPaint(0, p1);
        renderer.setSeriesPaint(3, p1);
        renderer.setSeriesPaint(6, p1);

        Paint p2 = new GradientPaint(
                0.0f, 0.0f, new Color(10, 144, 40), 0.0f, 0.0f, new Color(160, 240, 180));
        renderer.setSeriesPaint(1, p2);
        renderer.setSeriesPaint(4, p2);
        renderer.setSeriesPaint(7, p2);

        Paint p3 = new GradientPaint(
                0.0f, 0.0f, new Color(255, 35, 35), 0.0f, 0.0f, new Color(255, 180, 180));
        renderer.setSeriesPaint(2, p3);
        renderer.setSeriesPaint(5, p3);
        renderer.setSeriesPaint(8, p3);


        renderer.setGradientPaintTransformer(
                new StandardGradientPaintTransformer(GradientPaintTransformType.HORIZONTAL));

        SubCategoryAxis domainAxis = new SubCategoryAxis("Effectif / Filiere");
        domainAxis.setCategoryMargin(0.1);
        for(int i=0;i<sexe.length;i++) {
        	domainAxis.addSubCategory(sexe[i]);
        }
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setDomainAxis(domainAxis);
        plot.setRenderer(renderer);
        plot.setFixedLegendItems(createLegendItems());
        
        return chart;
    }

    private LegendItemCollection createLegendItems() {
        LegendItemCollection result = new LegendItemCollection();
        LegendItem item1 = new LegendItem("M.I.S.S", "Passaant", "Passaant", "Passaant",
                new Rectangle(10, 10), new GradientPaint(0.0f, 0.0f,
                new Color(16, 89, 172), 0.0f, 0.0f, new Color(201, 201, 244)));
        LegendItem item2 = new LegendItem("M.E", "Redoublant", "Redoublant", "Redoublant",
                new Rectangle(10, 10), new GradientPaint(0.0f, 0.0f,
                new Color(10, 144, 40), 0.0f, 0.0f, new Color(160, 240, 180)));
        LegendItem item3 = new LegendItem("M.F", "Triplant", "Triplant", "Triplant",
                new Rectangle(10, 10), new GradientPaint(0.0f, 0.0f,
                new Color(255, 35, 35), 0.0f, 0.0f, new Color(255, 180, 180)));

        result.add(item1);
        result.add(item2);
        result.add(item3);

        return result;
    }

    public static int somme(DefaultTableModel model,int ligne,int col1) {
    	return Integer.parseInt(String.valueOf(model.getValueAt(ligne, col1)));
    	
    }
    public static void main(final String[] args) {
    	

		String parc[]= {"M.I.S.S","M.E","M.F"};
		String niveau[]= {"L1","L2","L3","M1","M2"};
		String sexe[]= {"Passant","Redoublant","Triplant"};
		DefaultTableModel model = null;
        final HistParSexe demo = new HistParSexe("Stacked Bar Chart",parc,niveau,sexe,model);
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
       
    }
}
