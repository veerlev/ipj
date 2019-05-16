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