package bdProjet;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Fichier {

	public static void enregistrer(String nomFichier,ArrayList moves) throws IOException{
		FileWriter fw=new FileWriter(nomFichier);
		PrintWriter out=new PrintWriter(fw);
		String s="";
		for(int i=0;i<moves.size();i++){
			int t= (Integer) moves.get(i);
		switch(t){
		case 2:
		s+='D';
		break;
		
		case 8:
			s+='U';
			break;
		case 4:
			s+='L';
			break;
		case 6:
			s+='R';
			break;
		default:s+="I";
		}
		}
		out.println(s);
		out.close();
}

	public static void lirefichier(String nomfichier) throws FileNotFoundException{
	
		File file=new File(nomfichier);
		Scanner sc1= new Scanner (file); 
		Scanner sc2= new Scanner (file); 
		BufferedReader br= new BufferedReader (new FileReader(file));
		Scanner sc=new Scanner(file);
		//FileReader a= new FileReader(file);
		String ligne="";
		String mot="";
		Niveau n= new Niveau();
		Rockford rockford= new Rockford();
		//StringTokenizer st = new StringTokenizer(ligne,"=",false);
		//Scanner sl=new Scanner(ligne);	
		ligne=sc.nextLine();
		
		//mot=de.next();
		
		try {
			while(sc.hasNextLine()){
			ligne=sc.nextLine();
			//System.out.println(ligne);
			//StringTokenizer st = new StringTokenizer(ligne,"=",false);
			/*while(!ligne.equals("[cave]")){
					ligne=sc.nextLine();
					System.out.println(ligne);
				}*/
			
			/*sc1= new Scanner(ligne);
			 sc2= new Scanner (ligne);
			 System.out.println(ligne);
			while(!sc1.nextLine().equals("[map]")&&!sc2.nextLine().equals("[map]")){
				System.out.println ("Adelieeeeee");
				sc1.nextLine();
				sc2.nextLine();
			}
			char [][] map =Fichier.lirecarte(sc1,sc2);*/
			System.out.println(sc.nextLine());
			
			
			
				if (ligne.equals("[cave]")){
					//while (st.hasMoreTokens()){
					//mot=st.nextToken();
					//System.out.println(mot);
					
					while (!ligne.equals("[map]")){
						ligne=sc.nextLine();
						System.out.println(ligne);
						Scanner de= new Scanner (ligne).useDelimiter("=");
						while (de.hasNext()){
							mot=de.next();
							//mot=st.nextToken();
							//System.out.println(mot);
										
						//mot=st.nextToken();
							if (mot.equals("Name")){
							//System.out.println("ok");
								String ab=de.next();
								n.setname(ab);
								//test
								//System.out.println("ok");
								//System.out.println(ab);
							}
							/*if (mot.equals("CaveDelay")){
								//n.setCaveDelay(Integer.parseInt(st.nextToken()));
							}*/
							if (mot.equals("CaveTime")){
								//System.out.println("ok?");
								String d=de.next();
								int dep= Integer.parseInt(d);
								rockford.setTime(dep);
								n.setCaveTime(dep);
							}
							
							if (mot.equals("DiamondsRequired")){
								
								n.setDiamondsRequired(Integer.parseInt(de.next()));
							}
							
							if (mot.equals("DiamondValue")){
							System.out.println("aff");
							//a deux val min il faut les additionner et les ajouter
								//de.next();
								//de.next();
								//Scanner st2= new Scanner (ligne).useDelimiter(" ");
								//StringTokenizer st2 = new StringTokenizer(ligne," ",false);
								//n.setDiamondValue(Integer.parseInt(st2.nextToken()));
								//n.ajouterDiamondValue(Integer.parseInt(st2.nextToken()));
								//test
								
								//n.toString();
							}
							
							if (mot.equals("AmoebaTime")){
								
								n.setAmoebaTime(Integer.parseInt(de.next()));
								}
							if (mot.equals("MagicWallTime")){
								
								n.setMagicWallTime(Integer.parseInt(de.next()));
								}
							
						 /*System.out.println(sc.nextLine());*/
							
						}	
						//System.out.println(ligne+"aa");
						//mot=de.next();
						de.close();
					}	
					
				}
				
			}
				//ligne=ligne.trim();
				
				//}
			
			
			
			
			
					
		}catch(Exception ex){ 
			ex.getMessage();//catch
		}
		
		}
	
	
	
	
//$ commence les lignes optionnelles
public static char[][] lirecarte(Scanner sc,Scanner sc2) throws Exception{
	int cpl=0;
	int cph=0;
	String ligne2=sc2.nextLine();
	String ligne=sc.nextLine();
	
	
	
	/*while(sc2.hasNextLine()){
		ligne2=sc2.nextLine();
		System.out.println(ligne2+"tttttttt");
	}*/
	char[][]map;
	/*char[][] map=new char [5][40];
	for(int i=0;i<5;i++){
		//System.out.println("aaaa"+ligne+"bbbb");
		for(int j=0;j<ligne2.length();j++){
			map[i][j]=ligne2.charAt(j);
		}
		ligne2=sc2.nextLine();
		System.out.println(ligne);
		ligne=sc.nextLine();
		
	}*/
	//if(ligne.equals("[map]")){
		System.out.print("test");
		//ligne=sc.nextLine();
		cpl=ligne.length();
	while (!ligne.equals("[/map]")&& sc.hasNextLine()){
		
		//System.out.print(sc.nextLine());
		ligne=sc.nextLine();
		cph++;
	}
	System.out.println("cph"+cph+" cpl"+cpl);
	map= new char[cph][cpl];	
		
		ligne2=sc2.nextLine();
		
		//System.out.print("lllllllllll"+ligne2+"l2l2l2l2");
		for(int i=0;i<cph;i++){
			for(int j=0;j<cpl;j++){
				map[i][j]=ligne2.charAt(j);	
			}
			//System.out.println("ccc"+ligne2);
			ligne2=sc2.nextLine();
		}
			//System.out.println("ddd"+ligne);
			//Scanner sc1=new Scanner(ligne);
			/*if(sc2.hasNextLine()){
				//System.out.print("test2");
			//ligne=sc2.next();
			System.out.println(ligne+"bbbb");}*/
		
		//return map;
	//}
	return map;
}

	
	
	
	
	
}
