package plateauDeJeu;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Jeux jeu = new Jeux();
		Scanner sc = new Scanner(System.in);
		jeu.lancerLeJeu(sc);
	}
	

}
