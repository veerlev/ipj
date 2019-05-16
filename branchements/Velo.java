/*
Le but de cet exercice est de permettre à un service de location de vélos (online, tournant
24 heures sur 24) de facturer ses clients.
Le programme demandera à l’utilisateur d’entrer les heures de début et de fin de location sous la forme d’entiers (on ne se préoccupe pas des minutes pour simplifier).
Les tarifs de location sont définis comme suit :
— 1 franc par heure si le vélo est loué entre 0h et 7h ou entre 17h et 24h;
— 2 francs par heure si le vélo est loué entre 7h et 17h.
Votre programme demandera à l’utilisateur de quelle heure à quelle heure se fait la
location (partie du code fournie) et calculera le prix de la location en conséquence.
Vous adoterez les simplifications suivantes :
— les heures de début et fin de location sont des entiers (pas de demi ni de quart, toute
heure entamée est due);
— l’heure du début de la location est toujours inférieure à l’heure de la fin de la location;
cela implique que la location ne peut pas se faire sur plus de 24 heures; elle doit se
faire dans la même journée.
Si les données introduites sont correctes, votre programme affichera simplement le coût
de la location en respectant strictement les formats donnés dans les exemples de déroulement ci-dessous.
En cas de donnée incorrecte, votre programme devra afficher un message d’erreur et
s’arrêter. Utilisez strictement les messages suivants :
— « Les heures doivent être comprises entre 0 et 24 ! » suivi
d’un saut de ligne, si une des heures introduites par l’utilisateur n’est pas comprise
entre 0 et 24 (inclus);
— « Bizarre, vous n’avez pas loué votre vélo bien longtemps ! »
suivi d’un saut de ligne, si les heures de début et fin de location sont identiques;
— et « Bizarre, le début de la location est après la fin ... »
suivi d’un saut de ligne si l’heure de début de la location est supérieure à l’heure de
fin.
1
Le code fourni contient des instructions à utiliser telles quelles (en les plaçant aux bons
endroits) pour produire les affichages souhaités.
Vous n’utiliserez pas l’instruction return; pour ce programme.
*/

import java.util.Scanner;

public class Velo {

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.print("Donnez l'heure de début de la location (un entier) : ");
        int debut = clavier.nextInt();
        System.out.print("Donnez l'heure de fin de la location (un entier) : ");
        int fin = clavier.nextInt();

        /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/
        if ((debut < 0) || (debut > 24) || (fin < 0) || (fin > 24)){
            System.out.println("Les heures doivent être comprises entre 0 et 24 !");
        }
        else if (debut == fin) {
            System.out.println("Bizarre, vous n'avez pas loué votre vélo bien longtemps !\n");
        }
        else if (debut > fin){
            System.out.println("Bizarre, le début de la location est après la fin ...\n");
        }
        else{
            int heures1 = fin - debut;
            int heures2 = 0;
            if (fin > 7){
                if (fin < 17) {
                    if (debut < 7){
                        heures2 = fin - 7;
                    } else {
                        heures2 = fin - debut;
                    }
                } else if (debut < 7) {
                    heures2 = 17-7;
                } else if (debut < 17){
                    heures2 = 17 - debut;
                }
                heures1 -= heures2;
            }
            double total = heures1 + heures2 * 2;
            System.out.printf("Vous avez loué votre vélo pendant\n");
            if (heures1 > 0){
                System.out.printf("%d heure(s) au tarif horaire de 1.0 franc(s)\n", heures1);
            }
            if (heures2 > 0){
                System.out.printf("%d heure(s) au tarif horaire de 2.0 franc(s)\n", heures2);
            }
            System.out.printf("Le montant total à payer est de %.1f franc(s).\n", total);
        }


        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/

        clavier.close();
    }
}
