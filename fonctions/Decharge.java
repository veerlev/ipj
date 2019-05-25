/*
Exercice 1 — Décharge communale
1.1 Introduction
Votre commune cherche le meilleur endroit pour installer sa décharge publique.
Elle souhaite que sa décharge soit la plus éloignée possible des habitations. Les
habitations sont repérées par leur coordonnées x et y sur un plan à deux dimensions. Comme la commune a déjà une idée de l’endroit où elle aimerait placer
la décharge, elle souhaite vérifier que la distance entre la position souhaitée et la
plus proche des habitations soit raisonnable et la placer de façon optimale près de
l’endroit envisagé.
Voici un exemple de configuration des données (les cercles désignent les habitations et le carré, la position souhaitée pour la décharge) :
x
y
Télécharger le programme Decharge.java fourni sur le site du courset le compléter suivant les instructions données ci-dessous.
Toutes les méthodes que vous définirez dans votre programme devront être
public et static.
1.2 Calcul des distances
Dans le fichier fourni, définissez une méthode :
double calculerDistance(int x1, int y1, int x2, int y2)
qui calcule et retourne la distance entre les deux points (x1,y1) et (x2, y2)
passés en arguments.
Pour calculer la distance entre deux points (x1, y1) et (x2, y2), vous utiliserez la formule suivante :
p
(x1 − x2)2 + (y1 − y2)2
Indication : Pour représenter la distance la plus importante possible entre le point
choisi pour la décharge et un habitation, vous pourrez utiliser la constante Java
Integer.MAX_VALUE.
Voir l’exemple de déroulement plus bas pour des valeurs de test.
1.3 Habitation la plus proche
Complétez votre programme en définissant la méthode :
int plusProche(int x, int y, int[] coordonneesHabitations)
où coordonneesHabitations est un tableau de coordonnées pour les habitations de la commune, tel que décrit plus haut. La méthode plusProche doit
retourner la position (dans le tableau coordonnesHabitations) de la paire
(xp, yp) de l’habitation la plus proche de point (x, y). Par exemple, si c’est la
deuxième habitation (12, 55) du tableau (33, 12, 12, 55, 12, 12),
la méthode doit retourner 1 (la numérotation commence à 0). Dans le cas où plusieurs habitations seraient candidates, seule la première dans le tableau sera retenue.
Voir l’exemple de déroulement plus bas pour des valeurs de test.
1.4 Trois habitations les plus proches
Complétez votre programme en définissant une méthode supplémentaire :
int[] troisPlusProches(int x, int y, int[] coordonneesHabitations)
qui retourne dans un tableau d’entiers les coordonnées des trois habitations les
plus proches du point de (x,y) donné en argument parmi toutes les habitations
de la commune (passée en argument). La tableau sera ordonné selon les mêmes
conventions que pour la tableau de coordonnées des habitations (cooordonnée en
x puis en y).
Il sera aussi ordonné de la coordonnée la plus proche à la plus distante.
Indication : Pour atteindre ce résultat, vous pouvez copier la tableau des coordonnées dans un tableau temporaire tmp au moyen de l’instruction
System.arraycopy(coordonneesHabitations, 0, tmp, 0,
coordonneesHabitations.length);
puis chercher trois fois le point le plus proche dans tmp. A chaque fois qu’un
point le plus proche aura été déterminé il faudra le remplacer par une point trop
éloigné pour être à nouveau candidat. Vous prendrez la valeur 1000000 pour
chacune de ces coordonnées (nous supposerons qu’à cette distance on sort de la
commune).
Voir l’exemple de déroulement plus bas pour des valeurs de test.
1.5 Place optimale
Terminez enfin votre programme en définissant la fonction
int[] meilleurePlace(int x, int y, int[] coordonneesHabitations)
qui donne le centre de gravité du triangle définit par les trois habitations les plus
proches du point de (x,y).
Le tableau retourné sera donc un tableau à deux entrées dont la première sera la
coordonnée en x et la seconde la coordonnées en y du centre de gravité.
Ce « centre de gravité » représente le meilleur compromis pour les trois habitations
les plus proches. Si (x1,y1), (x2,y2) et (x3,y3) sont les points les plus
proches du point (x,y), les coordonnées (cx,cy) du centre de gravité seront :
cx = (x1 + x2 + x3) / 3
cy = (y1 + y2 + y3) / 3
Exemple de déroulement Cet exemple s’applique au tableau de coordonnées
d’habitations fourni, à savoir :
int[] coordonneesHabitations = {
9, 30, 18, 8, 3, 18, 25, 36
};
Entrez la coordonnee x de la decharge: 10
Entrez le coordonnee y de la decharge: 15
--- Question 1 ---
Coordonnees de l’habitation la plus proche de la decharge :
(3,18) ; distance = 7.616 metres
--- Question 2 ---
Coordonnees des 3 habitations les plus proches de la decharge :
(10,15) est a :
7.616 de (3,18)
10.630 de (18,8)
15.033 de (9,30)
--- Question 3 ---
Coordonnees de la meilleure place pour la decharge :
(10,18)

*/

import java.util.Scanner;
import java.util.Arrays;
import java.text.DecimalFormat;
							  
public class Decharge {
	private static DecimalFormat df = new DecimalFormat("#.000");
	
       /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/
		public static int[] troisPlusProches(int x, int y, int[] coordoneesHabitations) {
			int[] plusProches = new int[6];
			int[] tmp = new int[coordoneesHabitations.length];
			System.arraycopy(coordoneesHabitations, 0, tmp, 0,
					coordoneesHabitations.length);
			int premiere = plusProche(x, y, tmp);
			plusProches[0] = coordoneesHabitations[2 * premiere];
			plusProches[1] = coordoneesHabitations[2 * premiere + 1];
			tmp[2 * premiere] = 1000000;
			tmp[2 * premiere + 1] = 1000000;
			int deuxieme = plusProche(x, y, tmp);
			plusProches[2] = coordoneesHabitations[2 * deuxieme];
			plusProches[3] = coordoneesHabitations[2 * deuxieme + 1];
			tmp[2 * deuxieme] = 1000000;
			tmp[2 * deuxieme + 1] = 1000000;
			int troisieme = plusProche(x, y, tmp);
			plusProches[4] = coordoneesHabitations[2 * troisieme];
			plusProches[5] = coordoneesHabitations[2 * troisieme + 1];
			return plusProches;
		}
		
		public static int plusProche(int x, int y, int[] coordonneesHabitations) {			
			int laPlusProche = -1;
			double distance = Integer.MAX_VALUE;
			for (int i = 0; i < coordonneesHabitations.length / 2; i++) {
				double nouvelleDistance = calculerDistance(x, y, coordonneesHabitations[2 * i],
						coordonneesHabitations[2 * i + 1]);
				if (nouvelleDistance < distance) {
					distance = nouvelleDistance;
					laPlusProche = i;
				}
			}
			return laPlusProche;
		}
		
		public static double calculerDistance(int x1, int y1, int x2, int y2) {
		 return Math.sqrt(Math.pow(x1 - x2,2) + Math.pow(y1 - y2, 2));
		}

		public static int[] meilleurePlace(int x, int y, int[] coordonneesHabitations) {
			int[] place = new int[2];
			int[] tpp = troisPlusProches(x, y, coordonneesHabitations);
			place[0] = (tpp[0] + tpp[2] + tpp[4]) / 3;
			place[1] = (tpp[1] + tpp[3] + tpp[5]) / 3;
			return place;
		}
        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/

	public static void afficheTroisPlusProches(int x, int y, int[] coordonneesHabitations) {
		int[] tpp = troisPlusProches(x, y, coordonneesHabitations);
		
		System.out.println("(" + x + "," + y + ") est a :");
		for (int i = 0 ; i < 3 ; i++) {
			System.out.println("    " + df.format(calculerDistance(x, y, tpp[2*i], tpp[2*i+1])) + " de (" + tpp[2*i] + "," + tpp[2*i+1] + ")"); 
		}
	}
	
	

	//PROGRAMME PRINCIPAL
	public static void main(String args[]) {
		
		int[] coordonneesHabitations = {
				9, 30, 18, 8, 3, 18, 25, 36
		};
		
		// Lecture des donnees
		Scanner clavier = new Scanner(System.in);
		System.out.print("Entrez la coordonnee x de la decharge: ");
		int x = clavier.nextInt();
		System.out.print("Entrez le coordonnee y de la decharge: ");
		int y = clavier.nextInt();
		
		// trouve les coordonnees de l'habitation la plus proche
		// (identifiees par l'indice correspondant dans le tableau
		// de coordonnees)
		int plusProche = plusProche(x, y, coordonneesHabitations);
		System.out.println("--- Question 1 ---");
		System.out.println("Coordonnees de l'habitation la plus proche de la decharge :");
		System.out.println("(" + coordonneesHabitations[plusProche * 2] + "," + coordonneesHabitations[plusProche * 2 + 1] + ") ; distance = " +
						   df.format(calculerDistance(x, y, coordonneesHabitations[plusProche * 2], coordonneesHabitations[plusProche * 2 + 1]))  + " metres");	
			
		// trouve les coordonnees des 3 habitations les plus proches et affiche les coordonnees
		
		System.out.println("--- Question 2 ---");
		System.out.println("Coordonnees des 3 habitations les plus proches de la decharge :");
		afficheTroisPlusProches(x, y, coordonneesHabitations);
		
		// affiche le centre de gravite des 3 plus proches (la meilleure place)
		int[] grav = meilleurePlace(x, y, coordonneesHabitations);
		System.out.println("--- Question 3 ---");
		System.out.println("Coordonnees de la meilleure place pour la decharge :");
		System.out.println("(" + grav[0] + "," + grav[1] + ")");
		clavier.close();
	}

}
