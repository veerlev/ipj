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