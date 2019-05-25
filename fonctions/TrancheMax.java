/*
Exercice 3 — Tranches maximales d’une matrice
Vous allez écrire un programme qui demande à l’utilisateur d’entrer une matrice à
deux dimensions. Il s’agira d’une matrice binaire (ne contenant que les caractères
0 ou 1). Votre programme devra ensuite retourner les lignes de la matrice qui
comportent le plus de 1 consécutifs. Par exemple, pour la matrice


1 0 0
0 1 0
1 1 0
0 1 1


votre programme devra imprimer les indices des deux dernières lignes, car elles
comportent chacune deux 1 consécutifs.
3.1 Initialisation et affichage de la matrice
La matrice est entrée au clavier sur une seule ligne, par exemple l’entrée 100 010 110 011
correspond à la matrice ci-dessus. Notez bien que ce sont les espaces qui défi-
nissent les lignes.
Votre programme doit valider que l’entrée de caractères ne comporte que des 0,
des 1 ou des espaces. Vous devez également valider que chaque ligne de la matrice
ait la même longueur. Par exemple l’entrée 10 00 111 est invalide car la 3ème
ligne comporte 3 éléments, alors que les deux premières que 2 éléments.
Vous devez donc à écrire une méthode checkFormat, conforme à l’utilisation
qui en est faite dans la méthode main fournie, et qui réalise ces vérifications.
Pour vous aider à les mettre en œuvre vous pouvez employer la fonctionnalité
split définie pour les String. Cette fonctionnalité s’utilisera comme suit :
// Attention il y a un espace avant {1,}:
String[] lignes = matrice.split(" {1,}");
Vous aurez alors dans lignes l’ensembles des String présentes dans matrices
entre les espaces.
Par exemple :
String matrice = "00 01111"; // 3 espaces entre 00 et 01111
 l’espace avant {1,} est le séparateur à considérer
{1,} indique qu’il doit se répéter 1 fois ou plus

String[] lignes = matrice.split(" {1,}");
System.out.println(lignes[0]); // "00"
System.out.println(lignes[1]); // "01111"
Autre exemple (avec des espaces séparateurs en début de chaîne) :
String matrice = " 00 01111"; // il y a 2 espaces avant 00
String[] lignes = matrice.split(" {1,}");
System.out.println(lignes[0]); // ""
System.out.println(lignes[1]); // "00"
System.out.println(lignes[2]); // "01111"
Pour augmenter la modularisation de votre code, nous vous demandons d’écrire
la méthode checkFormat en utilisant une autre méthode (aussi à écrire, donc)
s’appelant checkLineLength. Cette dernière vérifiera que les lignes d’une
matrice, exprimée comme décrit précédemment, sous la forme d’une chaîne de
caractères (String), ont bien toutes la même longueur. Cette méthode retournera
true si les lignes ont toutes la même longueur, et false sinon. Cette méthode
ne se préoccupera pas du contenu des lignes (peu importe si elles contiennent autre
chose que des ’0’ ou des ’1’). Par exemple checkLineLength(" def 123 abc")
retournera true et checkLineLength(" 00 111 01bc") retournera false.
3.2 Tranches maximales
Le programme fourni déclare une variable maxConsecutifList sous la forme
d’un tableau dynamique de Integer. Il s’agit :
1. de stocker dans maxConsecutifList les indices des lignes contenant
la plus grande séquence de ’1’ consécutifs dans la matrice;
2. et pour ce faire, d’écrire la méthode findConsecutiveList conforme
à l’utilisation qui en est faite dans la méthode main.
L’exécution devra strictement se conformer aux exemples suivants :
Saisie de la matrice :
100 010 110 011
Matrice saisie :
100 010 110 011
Ligne(s) avec le plus de 1 consecutifs:
2
3
Saisie de la matrice :
un deux trois
Matrice saisie :
un deux trois
Matrice invalide, seulement ’1’ , ’0’ et ’ ’ admis!
Saisie de la matrice :
10 00 111
Matrice saisie :
10 00 111
Matrice invalide, lignes de longueurs differentes!
Saisie de la matrice :
111 101 000
Matrice saisie :
111 101 000
Lignes avec le plus de 1 consecutifs:
0
Saisie de la matrice :
1100011 1100110 1011000 0101010 0001100
Matrice saisie :
1100011 1100110 1011000 0101010 0001100
Ligne(s) avec le plus de 1 consecutifs:
0
1
2
4
Saisie de la matrice :
000 000
Matrice saisie :
000 000
Pas de lignes avec des 1!
Saisie de la matrice :
Matrice saisie :
Matrice vide!
*/

import java.util.ArrayList;
import java.util.Scanner;

class TrancheMax {

    public static void main(String[] args) {

        Scanner clavier = new Scanner(System.in);

        // Entree de la matrice
        System.out.println("Saisie de la matrice :");
        String matrice = clavier.nextLine();
        System.out.format("Matrice saisie :\n%s\n", matrice);
        clavier.close();

        // Validation de la matrice
        if (!checkFormat(matrice)) {
            return;
        }

        // Trouver la liste des lignes avec le plus grand nombre de 1 consecutif
        // Ces numÃ©ros de lignes sont stockÃ©s dans un tableau dynamique
        ArrayList<Integer> maxConsecutifList = findConsecutiveList(matrice);

        if (maxConsecutifList.isEmpty()) {
            System.out.println("Pas de lignes avec des 1 !");
        } else {
            System.out.println("Ligne(s) avec le plus de 1 consecutifs :");
            for (Integer index : maxConsecutifList) {
                System.out.println(index);
            }
        }
    }

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/
    
    public static boolean checkLineLength(String matrice) {
    	String[] lignes = matrice.split(" {1,}");
    	int dimension = lignes[lignes.length - 1].length();
    	int start = (lignes[0].equals("")) ? 1 : 0; 
    	for (int i = start; i < lignes.length - 1; i++) {
    		if (lignes[i].length() != dimension) {
    			System.out.println("Matrice invalide, lignes de longueurs differentes !");
    			return false;
    		}
    	}
    	return true;
    }
    
    public static boolean checkFormat(String matrice) {
    	if (!matrice.matches("(0|1| )*")) {
    		System.out.println("Matrice invalide : seuls '1', '0' et ' ' sont admis !");
    		return false;
    	} else if (matrice.matches("( )*")){
    		System.out.println("Matrice vide !");
    		return false;
    	}
    	return checkLineLength(matrice);
    }
    
    public static ArrayList<Integer> findConsecutiveList(String matrice){
    	ArrayList<Integer> maxConsecutifs = new ArrayList<Integer>();
    	String[] lignes = matrice.split(" {1,}");
    	if (lignes.length == 0) {
    		System.out.println("Matrice vide !");
    		return maxConsecutifs;
    	}
    	int[] sommeMaxLignes = new int[lignes.length];
    	int max = 0;
    	int start = (lignes[0].equals("")) ? 1 : 0;
    	for (int i = start; i < lignes.length; i++) {
    		int somme = 0; 
    		
    		for (int j = 0; j < lignes[i].length(); j++) {
    			if(lignes[i].charAt(j) == '1') {
    				somme++;
    			} 
    			if (somme > 0 && (j == lignes[i].length() - 1 || lignes[i].charAt(j + 1) == '0')) {
    				if (somme > sommeMaxLignes[i]) {
    					sommeMaxLignes[i] = somme;
    				}
    				if (somme > max) {
    					max = somme;
    				}
    				somme = 0;
    			} 
    		}
    	}
    	if (max == 0) {
    		return maxConsecutifs;
    	}
    	for (int i = 0; i < sommeMaxLignes.length; i++) {
    		if (sommeMaxLignes[i] == max) {
    			maxConsecutifs.add(start == 0? i : i - 1);
    		}
    	}
    	return maxConsecutifs;
    }
    /*******************************************
     * Ne rien modifier apres cette ligne
     *******************************************/
}
