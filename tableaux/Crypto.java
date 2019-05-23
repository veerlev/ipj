/*
Exercice 2 — Cryptage
Jules César utilisait un système de codage très simple, qui consiste à remplacer
chaque lettre d’un message par la lettre placée plusieurs rangs après dans l’ordre
alphabétique. Par exemple, pour un décalage de 4, A devient E, B devient F, jusque
Z qui devient D.
Il s’agit ici d’appliquer cette technique pour coder une chaîne de caractère. Vous
écrirez pour cela un programme qui met en oeuvre les traitements décrits cidessous.
2.1 Codage
Le programme fourni pour cet exercice met à votre disposition une chaîne de
caractère ALPHABET contenant toutes les lettres de l’alphabet latin, en minuscule.
Il demande à l’utilisateur de saisir une chaîne de caractères s.
Le but de l’exercice est de construire une nouvelle chaîne aCoder comme suit :
— aCoder contient, dans l’ordre, tous les caractères de s qui sont présents
dans ALPHABET ou qui correspondent au caractères espace (’ ’). Tous
les autres caractères sont ignorés.
La chaîne aCoder sera codée au moyen de la technique de Jules César. Elle
devra être affichée. Si elle ne contient aucun caractère, un message indiquant
que la chaîne à coder est vide sera affiché.
Lorsque la chaîne à coder est non vide, votre programme devra la coder avec un
décalage fixe donné par la constante fournie DECALAGE.
Codez la chaîne aCoder en remplaçant chaque caractère par celui situé DECALAGE
lettres plus loin dans la chaîne de caractères ALPHABET, et cela de façon cyclique
(’z’ sera remplacé par ’d’ par exemple). Les espaces seront maintenus tels quels.
Il ne feront l’objet d’aucun codage mais resteront présents à l’endroit qu’ils occupaient.
La chaîne ainsi codée sera affichée.
L’exécution de votre programme devra strictement se conformer aux exemples
suivants :
Veuillez entrer une chaine de caracteres :
fuyez manants
La chaine initiale etait : ’fuyez manants’
La chaine a coder est : ’fuyez manants’
La chaine codee est : ’jycid qererxw’
Veuillez entrer une chaine de caracteres :
avez-vous vu mes 3 chats et mes 2 chiens ?
La chaine initiale etait : ’avez-vous vu mes 3 chats et mes 2 chiens ?’
La chaine a coder est : ’avezvous vu mes chats et mes chiens ’
La chaine codee est : ’ezidzsyw zy qiw glexw ix qiw glmirw ’
Veuillez entrer une chaine de caracteres :
93589()çç%&=+12AD
La chaine initiale etait : ’93589()çç%&=+12AD’
La chaine a coder est vide.
*/
import java.util.Scanner;

public class Crypto {

    static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    static final int DECALAGE = 4;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Veuillez entrer une chaine de caracteres : ");
        String s = scanner.nextLine();

        // la chaine a coder
        String aCoder = "";
        // la chaine codee
        String chaineCodee = "";

        /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/
        
        for (int i = 0; i < s.length(); i++) {
        	char character = s.charAt(i);
        	//System.out.println(character);
        	if (character == ' ') { 
        		aCoder += character;
        	} else if (character >= 'a' && character <= 'z') {
        		aCoder += character;
        	}
        }
        
        for (int i = 0; i < aCoder.length(); i++) {
        	char character = aCoder.charAt(i);
        	if (character != ' ') {
        		int codedIndex = (ALPHABET.indexOf(character) + DECALAGE) % ALPHABET.length();
        		character = ALPHABET.charAt(codedIndex);
        	}
    		chaineCodee += character;
        }
        
        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/
        System.out.format("La chaine initiale etait : '%s'\n", s);

        if (aCoder.isEmpty()) {
            System.out.println("La chaine a coder est vide.\n");
        } else {
            System.out.format("La chaine a coder est : '%s'\n", aCoder);
            System.out.format("La chaine codee est : '%s'\n", chaineCodee);
        }
    }
}