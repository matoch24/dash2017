package bdProjet;

import java.util.ArrayList;
import java.util.Scanner;

public class Niveau {

static Scanner in = new Scanner(System.in);	
private String name;
private int caveDelay;
public int CaveTime;
private int diamondsRequired;
private int[] diamondValue;
private int amoebaTime;
private int magicWallTime;
private int largeur;
private int hauteur;
private char[][] carte;
private Rockford rockford;
//private int[] tabdiamondsval;

public Niveau(String name, int caveDelay, int caveTime, int diamondsRequired, int[] diamondValue, int amoebaTime, int magicWallTime, int largeur, int hauteur){
	this.name=name;
	this.caveDelay=caveDelay;
	this.CaveTime=caveTime;
	this.diamondsRequired=diamondsRequired;
	this.diamondValue=diamondValue;
	this.amoebaTime=amoebaTime;
	this.magicWallTime=magicWallTime;
	this.largeur=largeur;
	this.hauteur=hauteur;
	carte= new char[this.largeur][this.hauteur] ;
}

public Niveau(){
	this.name="Cave 1";
	this.caveDelay=6;
	this.CaveTime=150;
	this.diamondsRequired=3;
	this.diamondValue=new int[]{30,15};
	this.amoebaTime=135;
	this.magicWallTime=6;
	this.largeur=40;
	this.hauteur=22;
	carte= new char[this.largeur][this.hauteur] ;
	this.rockford=new Rockford();
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getCaveDelay() {
	return caveDelay;
}
public void setCaveDelay(int caveDelay) {
	this.caveDelay = caveDelay;
}
public int getCaveTime() {
	return CaveTime;
}
public void setCaveTime(int caveTime) {
	this.CaveTime = caveTime;
}
public int getDiamondsRequired() {
	return diamondsRequired;
}


public void setDiamondsRequired(int diamondsRequired) {
	this.diamondsRequired = diamondsRequired;
}
public int[] getDiamondValue() {
	return diamondValue;
}
public void setDiamondValue(int[] diamondValue) {
	this.diamondValue = diamondValue;
}
public int getAmoebaTime() {
	return amoebaTime;
}
public void setAmoebaTime(int amoebaTime) {
	this.amoebaTime = amoebaTime;
}
public int getMagicWallTime() {
	return magicWallTime;
}
public void setMagicWallTime(int magicWallTime) {
	this.magicWallTime = magicWallTime;
}
//public void ajouterValue(int d){
	

/*public String toString(){
	String s="";
	for (int i=0; i<tabdiamondsval.length;i++){
		s=s+tabdiamondsval[i];
	}
return s;
}*/

public Rockford getRockford() {
	return rockford;
}


public void setRockford(Rockford rockford) {
	this.rockford = rockford;
}


public char[][] getCarte() {
	return carte;
}

public void setCarte(char[][] carte) {
	this.carte = carte;
}

public void setCaveTime(){
	
}

public void setname(String n){
	name=n;
}




public static void main(String[] args) {
    char[][] grille = new char[7][7];
    int taille = grille.length;
    for (int i = 1; i < taille - 1; i++) {
        for (int j = 1; j < taille - 1; j++) grille[i][j] = '.';
    }
    int a = 0;
    for (int b = 0; b < taille; b++) grille[a][b] = 'W';
    int d = 0;
    for (int c = 0; c < taille; c++) grille[c][d] = 'W';
    int e = taille - 1;
    for (int f = 0; f < taille; f++) grille[e][f] = 'W';
    int h = taille - 1;
    for (int g = 0; g < taille; g++) grille[g][h] = 'W';


    int x = 3, y = 3;
    grille[x][y] = '/'; //placement du personnage
    grille[4][4] = 'd';
            // ↑ ↑ ↓ ↓ ← → ← → B A//
    grille[5][5] = 'o';//sortie
    afficher(grille, taille);

    ArrayList moves = new ArrayList();
    int[] shift = {6,2,6,2};
    int lg = shift.length - 1;


    while (grille[x][y] != grille[5][5] && lg > 0) {
        for (int i = 0; i < shift.length; i++) {
            int deplacement = shift[i];
            moves.add(deplacement);


            switch (deplacement) {  //2,4,5,6,8 : bas,gauche,immobile,droite,haut D,L,I,R,U
                case 2:
                    if (grille[x + 1][y] == 'W') {
                        grille[x][y] = '/';
                        System.out.println("mur bas");
                        break;}
                    else {
                        grille[x + 1][y] = '/';
                        grille[x][y] = '.';
                        x++;
                        break;}
                case 4:
                    if (grille[x][y - 1] == 'W') {
                        grille[x][y] = '/';
                        System.out.println("mur gauche");
                        break;}
                    else {
                        grille[x][y - 1] = '/';
                        grille[x][y] = '.';
                        y--;
                        break;}
                case 5:

                    grille[x][y] = '/';
                    break;
                case 6:
                    if (grille[x][y + 1] == 'W') {
                        grille[x][y] = '/';
                        System.out.println("mur droite");
                        break;}
                    else {
                        grille[x][y + 1] = '/';
                        grille[x][y] = '.';
                        y++;
                        break;}
                case 8:
                    if (grille[x - 1][y] == 'W') {
                        grille[x][y] = '/';
                        System.out.println("mur haut");
                        break;}
                    else {
                        grille[x - 1][y] = '/';
                        grille[x][y] = '.';
                        x--;
                        break;}
                default:
                    grille[x][y] = '/';
                    break; // default pour autres touches
            }

            afficher(grille, taille);
            lg--;
        }


        if (grille[x][y] == grille[5][5]) {
            System.out.println("exit found");
        }

    }
    for (int ct = 0; ct < moves.size(); ct++) {
        System.out.print(moves.get(ct) +" ");}

}//end main



public static void afficher (char [][]grille, int taille){
    int a=0;
    while(a<taille){
        int b=0;
        while(b<taille){
            System.out.print(grille[a][b]+" ");
            b++;
        }
        System.out.println("");
        a++;
    }
    System.out.println();
}//end afficher

}






