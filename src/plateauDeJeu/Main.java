package plateauDeJeu;

import java.util.Scanner;

import cartes.FactoryCarte;
import etat.EtatAttente;
import etat.EtatJouer;
import etat.Joueur;

public class Main {

	public static void main(String[] args) {
		
		Jeux jeu = new Jeux();
		Scanner sc = new Scanner(System.in);
		jeu.lancerLeJeu(sc);
	}
	

}
