/*
Exercice 2 — Date de Pâques
Pour cet exercice, il n’y a pas de matériel fourni. Vous coderez ce qui vous est
demandé dans une classe Paques, en tenant compte des contraintes imposées
par l’énoncé.
Le but de cet exercice est de déterminer la date des Pâques (chrétiennes grégoriennes) : on demande à l’utilisateur d’entrer une année et le programme affiche
la date de Pâques de l’année correspondante. Par exemple :
Entrez une annee (1583-4000) :
2006
Date de Paques en 2006 : 16 avril
On vous demande pour cela d’écrire une classe Paques qui contient trois méthodes :
1. une méthode statique demanderAnnee qui ne prend pas d’argument et
retourne un entier; cette méthode doit :
— demander une année à l’utilisateur
(message : « Entrez une annee (1583-4000) : », voir l’exemple
d’affichage ci-dessus); tant que l’année entrée n’est pas conforme,
cette méthode devra reposer la question.
— vérifier que l’année saisie est bien entre 1583 et 4000; sinon redemander;
— retourner l’année (correcte) saisie;
2. une méthode statique afficheDate qui prend deux entiers en paramètres : une année et un nombre de jours compris entre 22 et 56 1
; cette
méthode doit :
— afficher le message « Date de Paques en » suivi de l’année reçue
en premier paramètre, suivi de « : » comme dans l’exemple d’affichage
ci-dessus;
— si le nombre de jours reçu en second paramètre est inférieur ou égal à
31, afficher le simplement, suivi du mot « mars »;
— si ce nombre de jours est supérieur ou égal à 32, lui retrancher 31, et
l’afficher suivi du mot « avril »;
3. une méthode statique datePaques qui reçoit une année en paramètre
(nombre entier) et retourne un entier entre 22 et 56 indiquant le jour suivant
la convention appliquée dans la méthode afficheDate; cette méthode
doit calculer les valeurs suivantes (il s’agit de l’algorithme de Gauss; c’est
moins compliqué qu’il n’y parait) :
— le siècle. Il suffit de diviser l’année par 100;
— une valeur p qui vaut 13 plus 8 fois le siècle, le tout divisé par 25;
— une valeur q, division du siècle par 4;
— une valeur m valant (15 - p + siecle - q) modulo 30;
— une valeur n valant (4 + siecle - q) modulo 7;
— une valeur d qui vaut m plus 19 fois « l’année modulo 19 », le tout
modulo 30;
— une valeur e qu’il serait trop compliqué de décrire en français et que
nous vous donnons directement :
(2 * (annee % 4) + 4 * (annee % 7) + 6 * d + n) % 7
— le jour (ou presque, voir ci-dessous) : e plus d plus 22.
Toutes les divisions ci-dessus sont des divisions entières, et, pour rappel,
« a modulo b » s’écrit « a % b » en Java.
La valeur du jour doit cependant encore être corrigée dans certains cas
particuliers :
— si e vaut 6
— et que :
• d vaut 29
• ou d vaut 28 et 11*(m+1) modulo 30 est inférieur à 19,
(1. Il s’agit du nombres de jours entre Pâques et le dernier jour de Février. La date de Pâques
étant toujours comprise entre le 22 mars et le 25 avril, ce nombre sera en fait toujours compris
entre 22 et 56 : de 22 à 31 pour un jour de mars et de 32 à 56 pour un jour entre le 1er et le 25 avril.)
alors il faut soustraire 7 au jour.
C’est cette valeur (jour) que devra renvoyer la méthode datePaques.
Complétez ensuite votre programme en utilisant les trois méthodes précédentes
dans le main() de sorte à avoir le comportement décrit au début de cet exercice.
ATTENTION ! Pour obtenir tous les points, votre programme devra :
— faire les lectures des données nécessaires via une variable CLAVIER déclarée comme suit au début de la classe Paques :
private final static Scanner CLAVIER = new Scanner(System.in);
— respecter strictement le format d’affichage indiqué au début de l’exercice
et ne rien écrire d’autre que la question et sa réponse au format défini,
exactement comme dans l’exemple donné plus haut. Notez qu’il y a un
espace avant et après les deux points. Notez également qu’il n’y a pas
d’accents, ni de ligne vide après la question, ni de retour à la ligne en fin
de réponse. Notez enfin que pour que nous puissions tester vos méthodes,
celles-ci devront être static et ne pas être private.
Pour le rendu :
1. sauvegarder et tester votre programme pour être sûr(e) qu’il fonctionne
correctement;
2. soumettre votre fichier comme d’habitude.
*/

import java.util.Scanner;

public class Paques {
	private final static Scanner CLAVIER = new Scanner(System.in);


	public static int demanderAnnee()
	{
		int annee = 0;
		while(true){
			System.out.println("Entrez une annee (1583-4000): ");
		    annee = CLAVIER.nextInt();
			if ((annee >= 1583) && (annee <= 4000)){
				return annee;
			}
		}
		
	}

	public static void afficheDate(int annee, int journees){
		System.out.print("Date de Paques en " + annee + " : ");
		if (journees <= 31){
			System.out.print(journees + " mars");
		} else {
			System.out.print(journees - 31 + " avril");
		}
	}

	public static int datePaques(int annee)
	{
		int siecle = annee/100;
		int p = (13 + siecle * 8) / 25;
		int q = siecle / 4;
		int m = (15 - p + siecle - q) % 30;
		int n = (4 + siecle - q) % 7;
		int d = (m + 19 * (annee % 19)) % 30;
	       	int e = (2 * (annee % 4) + 4 * (annee % 7) + 6 *d + n) % 7;
		int journees = e + d + 22;
		if ((e == 6) && ((d == 29) || ((d == 28) && (11 * (m+1) % 30 <19)))){
			journees -= 7;
		}
		return journees;
	}


	public static void main(String args[])
	{
		int annee = demanderAnnee();
		afficheDate(annee, datePaques(annee));
		CLAVIER.close();
	}
}
