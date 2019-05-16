/*
Le but de cet exercice est d’écrire un programme Java posant des questions à l’utilisateur pour deviner (parmi une liste connue à l’avance) à quel champignon pense l’utilisateur.
Pour deviner un champignon, le programme ne peut poser que trois questions au maximum 1
, dont la réponse est soit oui, soit non (l’utilisateur répondra aux questions du programme par false pour non, et par true pour oui; voir l’exemple de déroulement fourni
plus bas).
Les 6 champignons possibles sont :
— l’agaric jaunissant;
— l’amanite tue-mouches;
— le cèpe de Bordeaux;
— le coprin chevelu;
— la girolle;
— et le pied bleu.
Seul le cèpe de Bordeaux possède des tubes, les autres champignons ayant des lamelles.
Le coprin chevelu et l’agaric jaunissant poussent dans les prés, les autres dans la forêt.
Les seuls à avoir un chapeau convexe sont l’agaric jaunissant, l’amanite tue-mouches
et le pied bleu.
Enfin, les seuls à avoir un anneau sont l’agaric jaunissant, l’amanite tue-mouches et le
coprin chevelu.
Commentaire : clavier.nextBoolean() permet de lire les booléens.
2.2 Instructions
Pour ce devoir, nous ne vous imposons pas de code au départ, mais simplement le
format des questions et les noms des champignons.
Pour vous faciliter leur écriture, téléchargez le programme Champi.java fourni sur
le site du courset utilisez le code fourni à votre guise, mais sans modifier les affichages.
Ce qu’il vous faut faire, c’est écrire tout le programme (en utilisant les System.out.print
fournis) de sorte à ce qu’il puisse trouver, en trois questions maximum le champignon auquel pense l’utilisateur (dans le cadre décrit plus haut).
1. Mais ce ne sont pas forcément les trois mêmes questions à chaque fois !
3
Faites simplement attention à ne pas modifier le texte des questions (mais déplacez les
pour changer l’ordre si nécessaire); notre correcteur automatique s’appuie sur le texte de
ces questions pour évaluer votre programme.
Une des difficultés de cet exercice consiste à trouver quelles questions poser et dans
quel ordre. Tous les ordres ne sont pas équivalents et ne conduisent pas à la solution en
trois questions maximum.
Note : On suppose que l’utilisateur respecte les règles. Si les réponses de l’utilisateur
sont incohérentes ou incorrectes, l’affichage du programme n’est pas spécifié, c.-à-d. qu’il
peut être n’importe quoi suivant votre choix.
Nous ne testerons pas ces cas là. Notre correcteur ne fournira que des réponses correctes
et cohérentes à votre programme.
2.3 Exemples de déroulement
Attention, ces exemples ne sont là que pour donner une idée de ce qui se passe. Il n’est
pas dit que les questions posées ici soient pertinentes ni dans le bon ordre pour garantir
trois questions maximum !
Il n’est pas dit non plus que ces deux exemples proviennent du même programme. Ce
sont juste des exemples possibles d’interactions avec l’utilisateur.
Exemple 1 :
Pensez à un champignon : amanite tue mouches, pied bleu, girolle,
cèpe de Bordeaux, coprin chevelu ou agaric jaunissant.
Est-ce que votre champignon a des lamelles (true : oui, false : non) ? true
Est-ce que votre champignon a un anneau (true : oui, false : non) ? false
Est-ce que votre champignon a un chapeau convexe (true : oui, false : non) ? false
==> Le champignon auquel vous pensez est la girolle.
Exemple 2 :
Pensez à un champignon : amanite tue mouches, pied bleu, girolle,
cèpe de Bordeaux, coprin chevelu ou agaric jaunissant.
Est-ce que votre champignon vit en forêt (true : oui, false : non) ? true
Est-ce que votre champignon a des lamelles (true : oui, false : non) ? false
==> Le champignon auquel vous pensez est le cèpe de Bordeaux.
*/
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

