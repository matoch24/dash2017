package dash;

import java.io.IOException;
import java.util.*;

public class Tableau {
	public char[][] Map = new char[8][7];
	public int x;
	public int y;
	public ArrayList depl = new ArrayList();

	public Tableau() {
		/*
		 * for (int i=0; i<Map.length; i++){ for (int j=0; j<Map.length; j++){
		 * if (Map [i][j]=='P'){ this.x=i; this.y=j; } }
		 * 
		 * } this.depl=new ArrayList();
		 */
	}

	public Tableau(char[][] map) {
		this.Map = map;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] == 'P') {
					this.x = i;
					this.y = j;
				}
			}

		}

	}

	public Tableau(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void adddepl(String d) {
		// ajoute une direction dans la liste depl
		depl.add(d);
	}

	public static char cible_al(Tableau Map) {
		// A modifier pour j
		int c = 0;
		char a = ' ';
		for (int i = 0; i < Map.Map.length; i++) {
			for (int j = 0; j < Map.Map.length; j++) {
				c = c + 1;
				Random r = new Random();
				int elt = Map.Map.length * Map.Map.length;// ts les elt du
															// tableau
				int de = r.nextInt(elt);
				if (c == elt) {
					a = Map.Map[i][j];
				}

			}
		}
		return a;
	}

	public static Tableau debuttab(Tableau tab) {

		tab.Map[tab.x][tab.y] = 'R';

		return tab;
	}

	public static Tableau suitetab(Tableau tab) {
		for (int i = 0; i < tab.Map.length; i++) {
			for (int j = 0; j < tab.Map[0].length; j++) {
				if (tab.Map[i][j] == 'R') {
					tab.Map[i][j] = ' ';

				}
			}

		}
		tab.Map[tab.x][tab.y] = 'R';

		return tab;
	}

	public static void simplet(Rockford rockford, Tableau Map, Niveau niv) {
		// strategie du simplet
		int dp = 0;
		String nom = "time";
		Tableau depart = Map;// tableau de depart
		ArrayList chemin = new ArrayList();
		Tableau suiv = depart;// suite tableau
		// chemin doit memoriser tout le chemin
		debuttab(depart);// remplace lepoint de départ par R

		for (int i = 0; i < depart.Map.length; i++) {
			for (int j = 0; j < depart.Map[0].length; j++) {
				System.out.print(depart.Map[i][j]);
			}
			System.out.println();
		}

		while (rockford.getTime() != 0) {
			dp = 0;
			suiv = rockford.prochaindeplacementA(depart, depart.x, depart.y);// renvoi
																				// tableau
																				// du
																				// prochain
																				// deplacement
			char contenusuiv = rockford.contenusuiv(suiv, suiv.x, suiv.y);

			// contenu du prochain deplacement
			// System.out.println("depl:"+contenusuiv);

			if (contenusuiv == 'R') {

				dp = 1;
				rockford.setTime((rockford.getTime()) + 1);
			}

			if (contenusuiv == 'r') {
				System.out.println("depl:" + contenusuiv);
				deplacerRoc(Map, suiv.x, suiv.y);
				// nom=tomberRoc(suiv);
				if (nom.equals("G")) {
					break;
				}
				// depart=suiv;

				// Map.Map[depart.x][depart.y]='R';
				// Map.Map[suiv.x][suiv.y]='r';//

				// faire si il peux pas le déplacer
				// Map.Map[depart.x][depart.y]=' ';//

			}

			if (contenusuiv == 'd') {
				System.out.println("depl:" + contenusuiv);
				rockford.adddiamant();
				suitetab(suiv);
				nom = tomberRoc(suiv);
				if (nom.equals("G")) {
					break;
				}

				// Map.Map[depart.x][depart.y]=' ';//
				// Map.Map[suiv.x][suiv.y]='R';//
				// depart=suiv;
			}

			if (contenusuiv == ' ' || contenusuiv == '.') {
				System.out.println("depl:" + contenusuiv);
				suitetab(suiv);
				nom = tomberRoc(suiv);
				if (nom.equals("G")) {
					break;
				}

				// Map.Map[depart.x][depart.y]=' ';
				// Map.Map[suiv.x][suiv.y]='R';
				// depart=suiv;
			}

			if (contenusuiv == 'c' || contenusuiv == 'b' || contenusuiv == 'B'
					|| contenusuiv == 'C') {
				System.out.println("depl:" + contenusuiv);
				nom = "libellule";
				suitetab(suiv);
				// Map.Map[depart.x][depart.y]=' ';
				// Map.Map[suiv.x][suiv.y]='R';
				break;
			}

			if (contenusuiv == 'F' || contenusuiv == 'q' || contenusuiv == 'o'
					|| contenusuiv == 'O' || contenusuiv == 'Q') {
				System.out.println("depl:" + contenusuiv);
				nom = "luciole";
				// Map.Map[depart.x][depart.y]=' ';
				// Map.Map[suiv.x][suiv.y]='R';
				suitetab(suiv);
				break;
			}

			if (contenusuiv == 'a') {
				System.out.println("depl:" + contenusuiv);
				nom = "amibe";
				// Map.Map[depart.x][depart.y]=' ';
				// Map.Map[suiv.x][suiv.y]='R';
				suitetab(suiv);
				break;
			}

			if (contenusuiv == 'X') {
				nom = "fin";
				break;
			}

			// suitetab(depart);
			if (dp != 1) {
				for (int i = 0; i < depart.Map.length; i++) {
					for (int j = 0; j < depart.Map[0].length; j++) {
						System.out.print(depart.Map[i][j]);
					}
					System.out.println();
				}
				chemin.add(depart.depl);
				; // prend tous les déplacements
			}

			rockford.setTime((rockford.getTime()) - 1);
		}
		System.out.println(rockford.toString(nom, rockford.getNbdiamant(),
				chemin));

	}

	public static boolean deplacerRoc(Tableau Map, int x, int y) {
		// déplacement de Roc par Rockford
		// x, y là ou il y a r
		if (Map.Map[x][y + 1] == ' ' && Map.Map[x][y - 1] == 'R') {
			Map.Map[x][y] = 'R';
			Map.Map[x][y + 1] = 'r';
			return true;
		} else if (Map.Map[x][y - 1] == ' ' && Map.Map[x][y + 1] == 'R') {
			Map.Map[x][y] = 'R';
			Map.Map[x][y - 1] = 'r';
			return true;
		}

		return false;

	}

	public static String tomberRoc(Tableau Map) {
		// Quand Roc tombe
		String a = "time";
		for (int x = 0; x < Map.Map.length; x++) {
			for (int y = 0; y < Map.Map[0].length; y++) {
				if (Map.Map[x][y] == 'r') {

					if (Map.Map[x][y + 1] == ' '
							&& Map.Map[x + 1][y + 1] == ' ') {
						Map.Map[x][y] = ' ';
						Map.Map[x + 1][y + 1] = 'r';
						if (Map.Map[x + 2][y + 1] == 'R') {
							a = "G";
						}
					}

					if (Map.Map[x][y - 1] == ' '
							&& Map.Map[x + 1][y - 1] == ' ') {
						Map.Map[x][y] = ' ';
						Map.Map[x + 1][y - 1] = 'r';
						if (Map.Map[x + 2][y - 1] == 'R') {
							a = "G";
						}
					}
					while (Map.Map[x + 1][y] == ' ') {
						Map.Map[x + 1][y] = 'r';
						x = x + 1;
						if (Map.Map[x][y + 1] == 'R') {
							a = "G";
						}
					}

				}
			}
		}
		return a;
	}

}
