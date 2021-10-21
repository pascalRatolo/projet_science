package carte;
public class RecuperInfo {   
   public String nume;
   public String nom;
   public String prenom;
   public String dat_naiss;
   public String lieu_naiss;
   public String cin;
   public String date_cin;
   public String lieu_cin;
   public String l;
   public String pic;
   public String sco;
   public String h;
   
public RecuperInfo(String nume, String nom,String prenom,String dat_naiss,
		       String lieu_naiss,String cin,String date_cin,String lieu_cin,String l,String pic,String sco,String h) {     
 this.nume = nume;
 this.nom = nom;
 this.prenom = prenom;
 this.dat_naiss = dat_naiss;
 this.lieu_naiss = lieu_naiss;
 this.cin = cin;
 this.date_cin = date_cin;
 this.lieu_cin = lieu_cin;
 this.sco = sco;
 
 if(l.equals("M.I.S.S")) {
	 l="  Parcours: M.I.S.S  ";
	 h="RI-";
 }if(l.equals("M.E")) {
	 l="   Parcours: M.E     ";
	 h="RM-";
 }if(l.equals("M.F")) {
	 l="   Parcours: M.F     ";
      h="RM-";
 }if(l.equals("T.C.M")) {
	 l="  Parcours: T.C.M    ";
     h="RI-";
}
 this.l=l;
 this.h=h;
 this.pic=pic;
    
} 
}
