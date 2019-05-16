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