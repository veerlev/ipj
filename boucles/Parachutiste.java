
/*
 * Description
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
 * 
 * */
import java.util.Scanner;

class Parachutiste {

    public static void main(String[] args) {

        Scanner clavier = new Scanner(System.in);

        double masse = 80.0;
        do {
            System.out.print("masse du parachutiste (>= 40) ? ");
            masse = clavier.nextDouble();
        } while (masse < 40.0);

        double h0 = 39000.0;
        do {
            System.out.print("hauteur de depart du parachutiste (>= 250) ? ");
            h0 = clavier.nextDouble();
        } while (h0 < 250.0);

        /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/
        final double G = 9.81;
        final double VITESSE_DU_SON = 343;
        double v0 = 0;
        double t0 = 0;
        double vitesse = v0;
        double hauteur = h0;
        double accel = G;
        double t = t0;
        double surface = 2.0;
        double s = surface / masse;
        double q = Math.exp(-s * (t - t0));
        double terme = G / s;
        boolean son = false;
        boolean maximale = false;
        boolean ouvert = false; 
        System.out.printf("%.0f, %.4f, %.4f, %.5f\n",
        		t, hauteur, vitesse, accel);
        while (hauteur > 0) {        	
        	t++;
        	q = Math.exp(-s * (t - t0));
        	vitesse = terme * (1 - q) + v0 * q;
        	hauteur = h0 - terme * (t - t0) - ((v0 - terme) / s) * (1 - q);
        	accel = G - s * vitesse;   
        	if ((!son) && (vitesse > VITESSE_DU_SON)) {
        		System.out.println("## Felix depasse la vitesse du son");
        		son = true;
        	}
        	if ((!maximale) && (accel < 0.5)) {
        		System.out.println("## Felix a atteint sa vitesse maximale");
        		maximale = true;
        	}
        	if ((!ouvert) && (hauteur < 2500)) {
        		System.out.println("## Felix ouvre son parachute");
        		ouvert = true;
        		surface = 25;
        		s = surface / masse;
        		terme = G / s;
        		t0 = t;
        		v0 = vitesse;
        		h0 = hauteur;
        	}
        	if (hauteur > 0) {
        		System.out.printf("%.0f, %.4f, %.4f, %.5f\n",
        				t, hauteur, vitesse, accel);
        	}            		
        }
        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/
        clavier.close();
    }
}
