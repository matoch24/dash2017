package bdProjet;

public class Niveau {
public String name;
public String CaveDelay;
public String CaveTime;
private int[] tabdiamondsval;


//public void ajouterValue(int d){
	

public String toString(){
	String s="";
	for (int i=0; i<tabdiamondsval.length;i++){
		s=s+tabdiamondsval[i];
	}
return s;
}

public void setname(String n){
	name=n;
}

}