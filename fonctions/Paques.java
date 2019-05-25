import java.util.Scanner;

public class Paques {
	private final static Scanner CLAVIER = new Scanner(System.in);


	public static int demanderAnnee()
	{
		int annee = 0;
		while(true){
			System.out.println("Entrez une annee (1583-4000): ");
		    annee = CLAVIER.nextInt();
			if ((annee >= 1583) && (annee <= 4000)){
				return annee;
			}
		}
		
	}

	public static void afficheDate(int annee, int journees){
		System.out.print("Date de Paques en " + annee + " : ");
		if (journees <= 31){
			System.out.print(journees + " mars");
		} else {
			System.out.print(journees - 31 + " avril");
		}
	}

	public static int datePaques(int annee)
	{
		int siecle = annee/100;
		int p = (13 + siecle * 8) / 25;
		int q = siecle / 4;
		int m = (15 - p + siecle - q) % 30;
		int n = (4 + siecle - q) % 7;
		int d = (m + 19 * (annee % 19)) % 30;
	       	int e = (2 * (annee % 4) + 4 * (annee % 7) + 6 *d + n) % 7;
		int journees = e + d + 22;
		if ((e == 6) && ((d == 29) || ((d == 28) && (11 * (m+1) % 30 <19)))){
			journees -= 7;
		}
		return journees;
	}


	public static void main(String args[])
	{
		int annee = demanderAnnee();
		afficheDate(annee, datePaques(annee));
		CLAVIER.close();
	}
}
