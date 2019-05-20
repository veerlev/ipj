/*Le but de cet exercice est d’écrire un programme permettant d’identifier l’élément
apparaîssant le plus fréquemment dans un tableau d’entiers.
Ce programme devra également afficher le nombre d’occurences dans le tableau
de cet élément le plus fréquent. Par exemple, pour le tableau suivant :
{2, 7, 5, 6, 7, 1, 6, 2, 1, 7}
votre programme devra indiquer que l’élément le plus fréquent est le 7 et que sa
fréquence d’apparition est 3.

*/

class MostFrequent {

    public static void main(String[] args) {
        int[] tab1 = {2, 7, 5, 6, 7, 1, 6, 2, 1, 7, 6};
        int taille = tab1.length;

        /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/
        int[] tab = tab1.clone();
        int i = 0;
        int plusFreq = Integer.MAX_VALUE;
        int freqMax = 0;
        boolean complete = false;
        while(!complete && i < taille) {
        	if (tab[i] != Integer.MAX_VALUE) {
        		int freq = 1;
            	for (int j = i + 1; j < taille; j++) {
            		if (tab[j] == tab[i]) {
            			tab[j] = Integer.MAX_VALUE;
            			freq++;
            		}
            	}
            	if (freq > freqMax) {
            		freqMax = freq;
            		plusFreq = tab[i];
            	}
            	tab[i] = Integer.MAX_VALUE;
        	}        	
        	i++;
        	complete = true;
        	for (int no : tab) {
        		if (no != Integer.MAX_VALUE) {
        			complete = false;
        		}
        	}
        }
        System.out.println("Le nombre le plus frequent dans le tableau est le :");
        System.out.println(plusFreq + " (" + freqMax + " x)");
        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/

    }
}