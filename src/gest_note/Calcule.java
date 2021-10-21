package gest_note;

public class Calcule {
	
	public static double  Calcule1(double nbr1,double nom1){
			double nbr[]= {nbr1};
			double nom[]= {nom1};
			
			double S=0;
			for(int j=0;j<nbr.length;j++) {
			S=S+nbr[j]*nom[j];
			}
			
			S=(double)Math.round((S)*1000)/1000;
			
			return S;
}
	
	public static double  Calcule2(double nbr1, double nbr2,
										 double nom1, double nom2){
		double nbr[]= {nbr1,nbr2};
		double nom[]= {nom1,nom2};
		double S=0;
		for(int j=0;j<nbr.length;j++) {
			S=S+nbr[j]*nom[j];
		}
		S=(double)Math.round((S)*1000)/1000;
		return S;
	}
	
	public static double  Calcule3(double nbr1, double nbr2,double nbr3,
										double nom1, double nom2,double nom3){
		double nbr[]= {nbr1,nbr2,nbr3};
		double nom[]= {nom1,nom2,nom3};
		
		double S=0;
		for(int j=0;j<nbr.length;j++) {
			S=S+nbr[j]*nom[j];
		}
		S=(double)Math.round((S)*1000)/1000;
		
		return S;
		}
	
	public static double  Calcule4(double nbr1, double nbr2,double nbr3,double nbr4,
										  double nom1, double nom2,double nom3,double nom4){
		double nbr[]= {nbr1,nbr2,nbr3,nbr4};
		double nom[]= {nom1,nom2,nom3,nom4};
		double S=0;
		for(int j=0;j<nbr.length;j++) {
			S=S+nbr[j]*nom[j];
		}
		S=(double)Math.round((S)*1000)/1000;
		
		return S;
		}	
	
	public static double  Calcule5(double nbr1, double nbr2,double nbr3,double nbr4,double nbr5,
										 double nom1, double nom2,double nom3,double nom4,double nom5){
			double nbr[]= {nbr1,nbr2,nbr3,nbr4,nbr5};
			double nom[]= {nom1,nom2,nom3,nom4,nom5};
			
			double S=0;
			for(int j=0;j<nbr.length;j++) {
			S=S+nbr[j]*nom[j];
		  }
			S=(double)Math.round((S)*1000)/1000;
			
			return S;
		}	

}
