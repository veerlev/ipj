/*
Représentation des terrains
Le propriétaire dispose d’une représentation de ses terrains sous forme digitalisée :
un terrain y est représenté par le biais d’un tableau binaire à deux dimensions. Les
1 y représentent des plaques carrées faisant partie du terrain et les 0 celles n’en
faisant pas partie.
Il s’agit donc dans cet exercice de calculer le nombre de mètres de clôture nécessaire pour entourer un terrain donné selon ce format. Pour cela, il faudra compter
le nombre de 1 constituant le pourtour du terrain. Chaque 1 du pourtour correspond à 2.50 mètres de clôture pour chacun de ses cotés qui sont au bord du terrain.
Par exemple, le terrain
1
(tout seul) qui représente un tout petit terrain carré de 2.5 m de coté, nécessitera
10 (= quatre fois 2.5) mètres de clôture.
Le terrain
0110
0110
aura besoin de 20 m de clôture, et le terrain
0111110
0111110
0111110
de 40 m.
Le problème est un peu compliqué par le fait que le terrain peut contenir des
étangs. L’intérieur des étangs est aussi représenté par des 0, mais le pourtour d’un
étang ne doit pas être comptabilisé dans le périmètre du terrain.
Exemple de terrain digitalisé avec des étangs à l’intérieur :
6
00000000000000000000000000000111111100000
00000000000000000000000000011111111111110
00000000000011111111111111111111111111111
00111111111111111111111111111111111111111
01111111111111111111111111111111111111111
11111111111111111111111111111111111111111
11111111111111111111111111111111111111111
11111111111111111111111111111111111111111
01111111111111100111111111111111111111111
01111111111111100111111111111000111111100
01111111111111100111111111110000111111100
00111111111111100111111111100001111111100
00011111111110001111111111100011111110000
00011111111100000011111111111111111110000
00011111111000000000011111111111111110000
00000111110000000000001111111111110000000
00000011111100000000111111111111100000000
00000111111110000001111111111111110000000
00011111111111000011111111111111111000000
00011111111111110111111111111111100000000
00001111111111111011111111111111000000000
00000111111111111101111111111100000000000
00000111111111111111111111110000000000000
00000111111111111111111111100000000000000
00000001111111111111111111110000000000000
00000011111111111111111111100000000000000
00000011111111111111111111100000000000000
00000011111100000000000000000000000000000
00000011000000000000000000000000000000000
qui correspondrait au terrain suivant :
Pour simplifier, on supposera :
— que le terrain est « en un seul morceau » : il n’existe pas de zones du terrain
déconnectées les unes des autres ;
7
— qu’il n’y a pas de ligne ne contenant que des 0 ;
— que le pourtour extérieur du terrain est « convexe par ligne », c’est-à-dire
que pour chaque ligne de l’image du terrain 1
, les seuls 1 du pourtour extérieur sont le premier et le dernier présents sur la ligne 2
; on ne peut pas
avoir une ligne comme cela : « 0011110001111 » où les 0 du milieu
seraient des 0 extérieurs ; ce sont dans ce cas forcément des 0 d’un étang.
Tout cela pour garantir qu’un 0 est donc à l’intérieur du terrain (étang) si, sur sa
ligne 3
, il y a au moins un 1 qui le précède et au moins un 1 qui le suit.
3.4 Le code à produire
Le code que vous écrirez commencera par vérifier que le tableau fourni (carte)
contient bien uniquement des 0 et des 1. Si tel n’est pas le cas, un message d’erreur respectant strictement le format suivant sera affiché (avec les sauts de ligne) :
Votre carte du terrain n’a pas le bon format :
valeur ’2’ trouvée en position [8][7]
Le programme arrêtera dans ce cas son exécution. Notez que le tableau que nous
donnons dans le code fourni sera remplacé par d’autres tableaux pour tester votre
code.
Si le tableau carte représentant le terrain est correct, votre programme affichera
alors le nombre de mètres de clôture nécessaires en respectant strictement le format d’affichage donné dans les exemples d’exécution donnés plus bas (y compris
le saut de ligne en fin de message).
Indications :
— Une façon simple de procéder consiste à d’abord « effacer » les étangs (en
remplaçant les 0 des étangs par des 1), puis procéder ensuite au comptage
des 1 situés sur le pourtour.
— Un point du pourtour peut avoir plusieurs 0 comme voisins (par exemple
un 0 au dessus et un 0 à gauche). Il doit dans ce cas être comptabilisé
autant de fois dans la clôture (deux fois dans l’exemple).
1. mais on ne fait pas cette hypothèse pour les colonnes ! Voir l’exemple ci-dessus.
2. mais il peut n’y en avoir qu’un seul lorsque le premier et le dernier sont le même :
« 000010000 ».
3. mais pas forcément sur sa colonne ! Voir l’exemple ci-dessus.
8
— Pour forcer la sortie de la méthode main, si vous estimez que l’exécution doit s’arrêter à un certain point, vous pouvez utiliser l’instruction
return;.
3.5 Vérification de la convexité de ligne
Pour finir, nous vous demandons d’ajouter, entre la vérification que la carte contient
bien uniquement des 0 et des 1 et le calcul de la longueur de la clôture, une vérification supplémentaire que la carte soit bien « convexe par ligne ».
Noter que cette partie, plus difficile, est totalement indépendante du reste et que
vous pouvez tout à fait calculer la longueur de la clôture, et avoir quelques points
sur l’exercice, sans avoir fait cette dernière partie.
La vérification demandée devra donc rejeter toute carte dans laquelle des 0 de
l’extérieur du terrain sont présents entre deux 1 d’une même ligne, comme par
exemple dans cette carte :
L’algorithme que nous vous proposons pour détecter ces cartes erronées est le
suivant :
1. trouver toutes les zones de 0 (on parle de « composantes connexes ») ;
par exemple, les différentes zones de 0 de l’image précédente sont ici représentées de différentes couleurs :
2. trouver parmi ces zones, celles qui sont à l’extérieur du terrain (les autres
étant des étangs) ;
3. parcourir l’image ligne à ligne pour voir si une zone de 0 extérieurs est
comprise entre deux 1.
A noter que vous pourrez regrouper cette dernière étape avec votre étape
« d’effacement » des étangs (décrite dans la section précédente).
Pour la première étape (trouver les composantes connexes), avec les connaissances de programmation à ce stade du cours, nous vous proposons de procéder
comme suit :
1. déclarez deux tableaux dynamiques d’entiers ; ils serviront à stocker les
coordonnées des points de la carte en cours de traitement, l’un pour les
ordonnées i, l’autre pour les abscisses j ;
2. déclarez une variable de type entier et initialisez là à la valeur 1 ; cette
variable nous servira à compter et à étiqueter les différentes zone de 0 ;
pour simplifier, appelons-la « composante » ; elle sera augmentée de 1
à chaque nouvelle zone ;
3. bouclez sur toutes les positions de la carte ;
si la valeur à la position courante est 0 :
— augmentez de 1 la variable de compte des zones (composante) ;
— ajoutez l’ordonnée i et l’abscisse j de la positions courante à vos tableaux dynamiques ;
— tant que ces tableaux dynamiques ne sont pas vides :
— récupérez et supprimez les valeurs du premier élément de chaque
tableau (une abscisse et une ordonnée) ;
— si la valeur de la carte à cette position nouvellement récupérée est
0 :
— mettre la valeur de zone (composante) à cette position de la
carte ;
— pour chacun des voisins de la position récupère (voisins NORD,
SUD, EST et OUEST, s’ils existent) : si la valeur du voisin
est 0, ajoutez ses coordonnées (abscisse et ordonnée) à vos tableaux dynamiques.
Si vous affichez la carte précédente suite à cette étape, vous devriez obtenir :
22222222222222222222222222222111111133333
22222222222222222222222222211111111111113
22222222222211111111111111111111111111111
22111111111111111111111111111111111111111
21111111111111111141111111111111111111111
11111111111111111144111111111111111111111
11111111111111111114411111111111111111111
11111111111111111111441111111111111111111
51111111111111166111144111111111111111111
51111111111111166111114411111777111111144
51111111111111166111111411117777111111144
55111111111111166111111444177771111111144
55511111111116661111111114177711111114444
55511111111166666611111114111111111114444
55511111111666666666611114111111111114444
55555111116666666666661114111111114444444
55555511111166666666111114111111144444444
55555111111116666661111114111111114444444
55511111111111666611114444111111111444444
55511111111111116111114111111111144444444
55551111111111111811114111111111444444444
55555111111111111191114111111144444444444
55555111111111111111114111114444444444444
55555111111111111111114411144444444444444
55555551111111111111111411114444444444444
55555511111111111111111411144444444444444
55555511111111111111111411144444444444444
55555511111144444444444444444444444444444
55555511444444444444444444444444444444444

Pour la seconde étape, il suffit simplement de faire le tour du bord de la carte et
stocker dans un tableau dynamique toutes les valeurs rencontrées qui ne sont pas
1. Même si ce n’est pas optimal, ce n’est pas grave ici de répéter plusieurs fois la
même valeur dans ce tableau. 4
Pour la troisième étape enfin, il suffit de parcourir chaque ligne et rechercher toute
valeur non 1 comprise entre le premier et le dernier 1 de cette ligne. Si cette
valeur est présente dans le tableau construit à l’étape précédente (tableaux des
composantes du bord), alors c’est que la carte est erronée. Il faudra alors afficher
un message d’erreur respectant strictement le format suivant (avec les sauts de
ligne) :
Votre carte du terrain n’a pas le bon format :
bord extérieur entrant trouvé en position [4][18]
4. Avec des notions supplémentaires présentées plus tard dans le cours, on pourrait de façon
efficace n’ajouter qu’une seule fois chaque valeur. Mais ce n’est pas fondamental.
Exemples de déroulement
Avec la carte donnée dans le code fourni et illustrée plus haut :
Il vous faut 385.0 mètres de clôture pour votre terrain.
Avec une carte contenant un 2 en position i=8, j=7 :
Votre carte du terrain n’a pas le bon format :
valeur ’2’ trouvée en position [8][7]
Avec cette carte :
01110
01010
01110
vous devriez avoir :
Il vous faut 30.0 mètres de clôture pour votre terrain.
Et avec celle-ci :
111
001
111
vous devriez avoir :
Il vous faut 40.0 mètres de clôture pour votre terrain.
Avec une carte n’étant pas « convexe par ligne » comme par exemple celle illustrée
plus haut :
Votre carte du terrain n’a pas le bon format :
bord extérieur entrant trouvé en position [4][18]


*/

import java.util.ArrayList;

class Cloture {
    public static void main(String[] args) {
        int[][] carte = {
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,0,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,0,0},
            {0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,1,0,0},
            {0,0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,0,0,0,0},
            {0,0,0,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0},
            {0,0,0,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0},
            {0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,1,1,1,1,1,1,1,1,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0},
            {0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0},
            {0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0},
            {0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        };

        /*******************************************
         * Completez le programme à  partir d'ici.
         *******************************************/
        //Vérification que la carte contient bien uniquement des 0 et des 1
         for (int i = 0; i < carte.length; i++)
        	for (int j = 0; j < carte[i].length; j++)
        		if ((carte[i][j] != 0) && (carte[i][j] != 1)){
        			System.out.println("Votre carte du terrain n’a pas le bon format :");
        			System.out.printf("valeur \'%d\' trouvée en position [%d][%d]\r\n",
        					carte[i][j], i, j);
        			return;
        		}
        
        //Vérification de la convexité de ligne
             //trouver les composantes connexes
        ArrayList<Integer> lignes = new ArrayList<Integer>();
        ArrayList<Integer> colonnes = new ArrayList<Integer>();
        int composante = 1;
        for (int i = 0; i < carte.length; i++) {
        	for (int j = 0; j < carte[i].length; j++) {
        		if (carte[i][j] == 0) {
        			composante++;
        			lignes.add(i);
        			colonnes.add(j);
        			while (!lignes.isEmpty()) {
        				int ligne = lignes.get(0);
        				int colonne = colonnes.get(0);
        				lignes.remove(0);
        				colonnes.remove(0);
        				if(carte[ligne][colonne] == 0) {
        					carte[ligne][colonne] = composante;
        					if (ligne > 0) {                          //NORD
        						if (carte[ligne - 1][colonne] == 0) {
        							lignes.add(ligne - 1);
        							colonnes.add(colonne);
        							
        						}
        					}        					
        					if (ligne < carte.length - 1) {              //SUD
        						if (carte[ligne + 1][colonne] == 0) {
        							lignes.add(ligne + 1);
        							colonnes.add(colonne);
        							
        						}
        					}        					
        					if (colonne > 0) {                          //OUEST
        						if (carte[ligne][colonne - 1] == 0) {
        							lignes.add(ligne);
        							colonnes.add(colonne - 1);
        							
        						}
        					}
        					if (colonne < carte[0].length - 1) {          //EST
        						if (carte[ligne][colonne + 1] == 0) {
        							lignes.add(ligne);
        							colonnes.add(colonne + 1);
        							
        						}
        					}
        				}
        			}
        		}
        	}
        }


        // tour du bord de la carte
        ArrayList<Integer> bord = new ArrayList<Integer>();  
        for (int i = 0; i < carte.length; i++) {
        	int element = carte[i][0];                          //NORD
        	if ((element != 1) && !(bord.contains(element))){
        		bord.add(element);
        	}
        	int j = carte[i].length - 1;
        	element = carte[i][j];								//SUD
        	if ((element != 1) && (!bord.contains(element))){
        		bord.add(element);
        	}
        }
        for (int j = 0; j < carte[0].length; j++) {
        	int element = carte[0][j];                           //OUEST
        	if ((element != 1) && (!bord.contains(element))){
        		bord.add(element);
        	}
        	int i = carte.length - 1; 
        	element = carte[i][j];								//EST
        	if ((element != 1) && (!bord.contains(element))){
        		bord.add(element);
        	}
        }

          //trouver cartes n’étant pas « convexes par ligne » / effacer étangs
        for (int i = 0; i < carte.length; i++) {
        	int debut = 0;
            int fin = carte[0].length - 1;
            while (carte[i][debut] != 1) {debut++;}
            while (carte[i][fin] != 1) {fin--;}
            for (int j = debut + 1; j < fin; j++) {
            	if (carte[i][j] != 1) {
            		if (!bord.contains(carte[i][j])) {
            			carte[i][j] = 1;
            		} else {
            			System.out.println("Votre carte du terrain n'a pas le bon format :");
            	        System.out.print("bord extérieur entrant trouvé en position [");
            	        System.out.print(i + "][" + j);
            	        System.out.println("]");
            	        return;
            		}
            	}
            }
        }

       //calculer cloture
        int somme = carte.length * 2;               //EST + OUEST
        for (int i = 0; i < carte.length; i++) {
        	int debut = 0;
            int fin = carte[0].length - 1;
            while (carte[i][debut] != 1) {debut++;}
            while (carte[i][fin] != 1) {fin--;}
            if (i == 0 ) {
            	somme += fin - debut + 1;          //NORD
            }	
            if (i == carte.length - 1) {   
            	somme += fin - debut + 1;  			//SUD
            }
            if (i < carte.length - 1) {                  	                     //0111            	
            	int d = debut, f = fin;                                          //0XX1
        		while (d < carte[0].length && carte[i + 1][d] != 1){              
        			somme++;
        			d++;
        		}        		
        		while (f > 0 && carte[i + 1][f] != 1){                   //111110
        			somme++;                                             //1xxxx0
        			f--;                                      
        		}        		
        	}
            if (i - 1 >= 0) {
            	while(debut < carte[0].length && carte[i - 1][debut] != 1) {
            		somme++;
            		debut++;
            	}
            	while(fin > 0 && carte[i - 1][fin] != 1) {
            		somme++;
            		fin--;
            	}
            }            
        }                      
        System.out.print("Il vous faut " + somme * 2.5);
        System.out.println(" mètres de clôture pour votre terrain.");       
        /*******************************************
         * Ne rien modifier après cette ligne.
         *******************************************/
    }
}
