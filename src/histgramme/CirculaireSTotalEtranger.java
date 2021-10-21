package histgramme;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

@SuppressWarnings("serial")
public class CirculaireSTotalEtranger extends JFrame
{
	
	 static DefaultTableModel model;
	 String title;

public CirculaireSTotalEtranger ( String title , String chartTitle,DefaultTableModel model ){

	CirculaireSTotalEtranger.model=model;
	this.title=title;
	
	JPanel pack = new JPanel();
// This will create the dataset
        PieDataset dataset = createDataset();
        PieDataset dataset1 = createDataset1();
        PieDataset dataset2 = createDataset2();
        PieDataset dataset3 = createDataset3();
        PieDataset dataset4 = createDataset4();

// based on the dataset we create the chart
        JFreeChart chart = createChart ( dataset , chartTitle );
        JFreeChart chart1 = createChart1 ( dataset1 , chartTitle );
        JFreeChart chart2 = createChart2( dataset2, chartTitle );
        JFreeChart chart3 = createChart3( dataset3, chartTitle );
        JFreeChart chart4 = createChart4( dataset4, chartTitle );
// we put the chart into a panel
        ChartPanel chartPanel = new ChartPanel ( chart );
        ChartPanel chartPanel1 = new ChartPanel ( chart1 );
        ChartPanel chartPanel2= new ChartPanel ( chart2 );
        ChartPanel chartPanel3= new ChartPanel ( chart3 );
        ChartPanel chartPanel4= new ChartPanel ( chart4 );
// default size
chartPanel . setPreferredSize( new java . awt. Dimension ( 350, 200));
chartPanel1 . setPreferredSize( new java . awt. Dimension ( 350, 200));
chartPanel2. setPreferredSize( new java . awt. Dimension ( 350, 200));
chartPanel3. setPreferredSize( new java . awt. Dimension ( 350, 200));
chartPanel4. setPreferredSize( new java . awt. Dimension ( 350, 200));


// add it to our application
pack.add(chartPanel);
pack.add(chartPanel1);
pack.add(chartPanel2);
pack.add(chartPanel3);
pack.add(chartPanel4);

setContentPane ( pack);


}
/**
* Creates a sample dataset
*/

public static PieDataset createDataset() {
DefaultPieDataset result =new DefaultPieDataset ();

result . setValue ("Africaine "+(sum1(sum2((Integer)model.getValueAt(1,1),(Integer) model.getValueAt(1,2)),sumT()))*100+"%",sum((Integer)model.getValueAt(1,1),(Integer) model.getValueAt(1,2)));
result . setValue ("Asiatique "+(sum1(sum2((Integer) model.getValueAt(1,3),(Integer) model.getValueAt(1,4)),sumT()))*100+"%",sum((Integer) model.getValueAt(1,3),(Integer) model.getValueAt(1,4)));
result . setValue ("Comorienne "+(sum1(sum2((Integer)model.getValueAt(1,5),(Integer)model.getValueAt(1,6)),sumT()))*100+"%",sum((Integer)model.getValueAt(1,5),(Integer)model.getValueAt(1,6)));
result . setValue ("Européenne "+(sum1(sum2((Integer) model.getValueAt(1,7),(Integer) model.getValueAt(1,8)),sumT()))*100+"%",sum((Integer) model.getValueAt(1,7),(Integer) model.getValueAt(1,8)));
result . setValue ("Autres "+(sum1(sum2((Integer) model.getValueAt(1,9),(Integer) model.getValueAt(1,10)),sumT()))*100+"%",sum((Integer) model.getValueAt(1,9),(Integer) model.getValueAt(1,10)));

return result ;
}
public static JFreeChart createChart
( PieDataset dataset , String title ) {	// chart title , data,include legend
	
JFreeChart chart = ChartFactory . createPieChart3D ("L1= "+sumT()+" Etrangers", dataset, true, true, false);

PiePlot plot =( PiePlot ) chart . getPlot ();
plot . setStartAngle(200); 
plot . setDirection( Rotation.CLOCKWISE );
plot . setForegroundAlpha( 0.5f );
return chart ;
}
public static PieDataset createDataset1() {
DefaultPieDataset result =new DefaultPieDataset ();

result . setValue ("Africaine "+(sum1(sum2((Integer)model.getValueAt(2,1),(Integer) model.getValueAt(2,2)),sumT2()))*100+"%",sum((Integer)model.getValueAt(2,1),(Integer) model.getValueAt(2,2)));
result . setValue ("Asiatique "+(sum1(sum2((Integer) model.getValueAt(2,3),(Integer) model.getValueAt(2,4)),sumT2()))*100+"%",sum((Integer) model.getValueAt(2,3),(Integer) model.getValueAt(2,4)));
result . setValue ("Comorienne "+(sum1(sum2((Integer)model.getValueAt(2,5),(Integer)model.getValueAt(2,6)),sumT2()))*100+"%",sum((Integer)model.getValueAt(2,5),(Integer)model.getValueAt(2,6)));
result . setValue ("Européenne "+(sum1(sum2((Integer) model.getValueAt(2,7),(Integer) model.getValueAt(2,8)),sumT2()))*100+"%",sum((Integer) model.getValueAt(2,7),(Integer) model.getValueAt(2,8)));
result . setValue ("Autres "+(sum1(sum2((Integer) model.getValueAt(2,9),(Integer) model.getValueAt(2,10)),sumT2()))*100+"%",sum((Integer) model.getValueAt(2,9),(Integer) model.getValueAt(2,10)));
return result ;
}
public static JFreeChart createChart1
( PieDataset dataset1 , String title ) {						// chart title , data,include legend
JFreeChart chart1 = ChartFactory . createPieChart3D ("L2= "+sumT2()+" Etrangers", dataset1 , true, true, false);

PiePlot plot1 =( PiePlot ) chart1 . getPlot ();
plot1 . setStartAngle(200); 
plot1 . setDirection( Rotation.ANTICLOCKWISE );
plot1 . setForegroundAlpha( 0.5f );
return chart1 ;
}
public static PieDataset createDataset2() {
DefaultPieDataset result =new DefaultPieDataset ();

result . setValue ("Africaine "+(sum1(sum2((Integer)model.getValueAt(3,1),(Integer) model.getValueAt(3,2)),sumT3()))*100+"%",sum((Integer)model.getValueAt(3,1),(Integer) model.getValueAt(3,2)));
result . setValue ("Asiatique "+(sum1(sum2((Integer) model.getValueAt(3,3),(Integer) model.getValueAt(3,4)),sumT3()))*100+"%",sum((Integer) model.getValueAt(3,3),(Integer) model.getValueAt(3,4)));
result . setValue ("Comorienne "+(sum1(sum2((Integer)model.getValueAt(3,5),(Integer)model.getValueAt(3,6)),sumT3()))*100+"%",sum((Integer)model.getValueAt(3,5),(Integer)model.getValueAt(3,6)));
result . setValue ("Européenne "+(sum1(sum2((Integer) model.getValueAt(3,7),(Integer) model.getValueAt(3,8)),sumT3()))*100+"%",sum((Integer) model.getValueAt(3,7),(Integer) model.getValueAt(3,8)));
result . setValue ("Autres "+(sum1(sum2((Integer) model.getValueAt(3,9),(Integer) model.getValueAt(3,10)),sumT3()))*100+"%",sum((Integer) model.getValueAt(3,9),(Integer) model.getValueAt(3,10)));
return result ;
}
public static JFreeChart createChart2
( PieDataset dataset2 , String title ) {						// chart title , data,include legend
JFreeChart chart2 = ChartFactory . createPieChart3D ("L3= "+sumT3()+" Etrangers" , dataset2, true, true, false);

PiePlot plot2 =( PiePlot ) chart2 . getPlot ();
plot2 . setStartAngle(200); 
plot2. setDirection( Rotation.CLOCKWISE );
plot2. setForegroundAlpha( 0.5f );
return chart2 ;
}
public static PieDataset createDataset3() {
DefaultPieDataset result =new DefaultPieDataset ();

result . setValue ("Africaine "+(sum1(sum2((Integer)model.getValueAt(4,1),(Integer) model.getValueAt(4,2)),sumT4()))*100+"%",sum((Integer)model.getValueAt(4,1),(Integer) model.getValueAt(4,2)));
result . setValue ("Asiatique "+(sum1(sum2((Integer)model.getValueAt(4,3),(Integer) model.getValueAt(4,4)),sumT4()))*100+"%",sum((Integer) model.getValueAt(4,3),(Integer) model.getValueAt(4,4)));
result . setValue ("Comorienne "+(sum1(sum2((Integer)model.getValueAt(4,5),(Integer) model.getValueAt(4,6)),sumT4()))*100+"%",sum((Integer)model.getValueAt(4,5),(Integer)model.getValueAt(4,6)));
result . setValue ("Européenne "+(sum1(sum2((Integer)model.getValueAt(4,7),(Integer) model.getValueAt(4,8)),sumT4()))*100+"%",sum((Integer) model.getValueAt(4,7),(Integer) model.getValueAt(4,8)));
result . setValue ("Autres "+(sum1(sum2((Integer)model.getValueAt(4,9),(Integer) model.getValueAt(4,10)),sumT4()))*100+"%",sum((Integer) model.getValueAt(4,9),(Integer) model.getValueAt(4,10)));

return result ;
}
public static JFreeChart createChart3
( PieDataset dataset3 , String title ) {						// chart title , data,include legend
JFreeChart chart3 = ChartFactory . createPieChart3D ("M1= "+sumT4()+" Etrangers"  , dataset3, true, true, false);
title.charAt(3);
PiePlot plot3 =( PiePlot ) chart3 . getPlot ();
plot3 . setStartAngle(200); 
plot3 . setDirection( Rotation.ANTICLOCKWISE );
plot3 . setForegroundAlpha( 0.5f );
return chart3 ;
}
public static PieDataset createDataset4() {
DefaultPieDataset result =new DefaultPieDataset ();

result . setValue ("Africaine "+(sum1(sum2((Integer)model.getValueAt(5,1),(Integer) model.getValueAt(5,2)),sumT5()))*100+"%",sum((Integer)model.getValueAt(5,1),(Integer) model.getValueAt(5,2)));
result . setValue ("Asiatique "+(sum1(sum2((Integer) model.getValueAt(5,3),(Integer) model.getValueAt(5,4)),sumT5()))*100+"%",sum((Integer) model.getValueAt(5,3),(Integer) model.getValueAt(5,4)));
result . setValue ("Comorienne "+(sum1(sum2((Integer)model.getValueAt(5,5),(Integer)model.getValueAt(5,6)),sumT5()))*100+"%",sum((Integer)model.getValueAt(5,5),(Integer)model.getValueAt(5,6)));
result . setValue ("Européenne "+(sum1(sum2((Integer) model.getValueAt(5,7),(Integer) model.getValueAt(5,8)),sumT5()))*100+"%",sum((Integer) model.getValueAt(5,7),(Integer) model.getValueAt(5,8)));
result . setValue ("Autres "+(sum1(sum2((Integer) model.getValueAt(5,9),(Integer) model.getValueAt(5,10)),sumT5()))*100+"%",sum((Integer) model.getValueAt(5,9),(Integer) model.getValueAt(5,10)));


return result ;
}


public static JFreeChart createChart4
( PieDataset dataset4 , String title ) {// chart title , data,include legend
	
JFreeChart chart4 = ChartFactory . createPieChart3D ("M2= "+sumT5()+" Etrangers", dataset4, true, true, false);

PiePlot plot4 =( PiePlot ) chart4 . getPlot ();
plot4 . setStartAngle(200); 
plot4 . setDirection( Rotation.CLOCKWISE );
plot4 . setForegroundAlpha( 0.5f );
return chart4 ;
}
private static double sum1(double val1, int val2) {
	// TODO Auto-generated method stub
	double S;
	S=val1/val2;
	S=(double)Math.round((S)*10000)/10000;
	return S;
}
private static double sum2(int val1, int val2) {
	// TODO Auto-generated method stub
	double S;
	S=val1+val2;
	//S=(double)Math.round((S)*100)/100;
	return S;
}

private static int sum(int val1, int val2) {
	// TODO Auto-generated method stub
	int S;
	S=val1+val2;
	
	return S;
}
private static int sumT() {
	// TODO Auto-generated method stub
	int b=(Integer) model.getValueAt(1,1);
for(int i=2;i<11;i++) {
		int a=(Integer) model.getValueAt(1,i);
		b=b+a;	
	}
return b;
}

private static int sumT2() {
	// TODO Auto-generated method stub
	int b=(Integer) model.getValueAt(2,1);
for(int i=2;i<11;i++) {
		int a=(Integer) model.getValueAt(2,i);
		b=b+a;	
	}
return b;
}
private static int sumT3() {
	// TODO Auto-generated method stub
	int b=(Integer) model.getValueAt(3,1);
for(int i=2;i<11;i++) {
		int a=(Integer) model.getValueAt(3,i);
		b=b+a;	
	}
return b;
}
private static int sumT4() {
	// TODO Auto-generated method stub
	int b=(Integer) model.getValueAt(4,1);
for(int i=2;i<11;i++) {
		int a=(Integer) model.getValueAt(4,i);
		b=b+a;	
	}
return b;
}
private static int sumT5() {
	// TODO Auto-generated method stub
	int b=(Integer) model.getValueAt(5,1);
for(int i=2;i<11;i++) {
		int a=(Integer) model.getValueAt(5,i);
		b=b+a;	
	}
return b;
}
}
