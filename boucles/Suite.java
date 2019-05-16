/*
Description
Considérons les opérations suivantes applicables à un nombre entier :
— si ce nombre est divisible par 3, on lui ajoute 4;
— s’il n’est pas divisible par 3 mais divisible par 4, on le divise par 2;
— s’il n’est divisible ni par 3, ni par 4, on lui soustrait 1.
On répète ces opérations successivement jusqu’à arriver à 0. Concrètement, partant d’un entier n0, on applique les opérations à n0 pour obtenir n1, puis si n1
n’est pas nul, on lui applique à nouveau les opérations précédentes, et ainsi de
suite jusqu’à obtenir un nombre nk valant 0. Par exemple, si on part de 7, on
trouve successivement les valeurs : 6, 10, 9, 13, 12, 16, 8, 4, 2, 1 et0. Le nombre
k de répétitions des opérations décrites ci-dessus est alors 11. Par contre, si on
part de 1, on tombe tout de suite sur 0, et le nombre de répétitions est alors de
k = 1. On vous demande d’écrire un programme qui affiche le nombre de répétitions des opérations précédentes nécessaires pour tomber à 0, en partant tour à tour
de chacun des entiers compris entre deux entiers saisis au clavier. Par exemple si
l’on demande ce nombre de répétitions pour chaque entier entre 1 et 7, l’affichage
produit par votre programme devra être :
1 -> 1
2 -> 2
3 -> 12
4 -> 3
5 -> 4
6 -> 10
7 -> 11
1
Ici, 1 et 7 (dans la 1re colonne) sont les bornes entrées au clavier, et la seconde
colonne correspond au nombre de répétitions nécessaires pour arriver à 0 en partant de chacun des nombres de la 1re colonne, par exemple 11 répétitions pour 7. Si
l’on demande ce nombre de répétitions pour les entiers entre 99 et 100, l’affichage
du programme devra être :
99 -> 18
100 -> 17
Note : pour tester si un nombre n est divisible par p, il suffit de tester si n % p
vaut zéro.

*/
import java.util.Scanner;

class Suite {

    public static void main(String[] args) {

        Scanner clavier = new Scanner(System.in);

        int debut;
        do {
            System.out.print("de (>= 1) ? ");
            debut = clavier.nextInt();
        } while (debut < 1);

        int fin;
        do {
            System.out.print("a (>= " + debut + ") ? ");
            fin = clavier.nextInt();
        } while (fin < debut);

        /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/
        for (int i = debut; i <= fin; i++){
    		int k = 0;
    		int nb = i;
    		while (nb > 0){
    			if (nb % 3 == 0){
    				nb += 4;
    			} else if (nb % 4 == 0){
    					nb /= 2;
    			} else {nb -= 1;}
    			k++;
    		}
    		System.out.println(i +  " -> " + k);
    	}
        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/
        clavier.close();
    }
}
