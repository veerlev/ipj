import java.util.Scanner;

public class Champi{
    public static void main(String[] args)
    {
        boolean anneau, foret, convexe, lamelles;
        Scanner clavier = new Scanner(System.in);
        String reponse = "==> Le champignon auquel vous pensez est ";
        System.out.println("Pensez à  un champignon : amanite tue-mouches, pied bleu, girolle,");
        System.out.println("cèpe de Bordeaux, coprin chevelu ou agaric jaunissant.\n");
        System.out.print("Est-ce que votre champignon a un chapeau convexe (true : oui, false : non) ? ");
        convexe = clavier.nextBoolean();
        if (convexe){
            System.out.print("Est-ce que votre champignon a un anneau (true : oui, false : non) ? ");
            anneau = clavier.nextBoolean();
            if (anneau){
                System.out.print("Est-ce que votre champignon vit en forêt (true : oui, false : non) ? ");
                foret = clavier.nextBoolean();
                reponse += foret ? "l'amanite tue-mouches" : "l'agaric jaunissant";
            } else {
                reponse += "le pied bleu";
            }
        } else {
            System.out.print("Est-ce que votre champignon a des lamelles (true : oui, false : non) ? ");
            lamelles = clavier.nextBoolean();
            if (lamelles){
                System.out.print("Est-ce que votre champignon vit en forêt (true : oui, false : non) ? ");
                foret = clavier.nextBoolean();
                reponse += foret ? "la girolle" : "le coprin chevelu";
            } else {
                reponse += "le cèpe de Bordeaux";
            }

        }
        System.out.print(reponse + ".");
        clavier.close();
    }
}

