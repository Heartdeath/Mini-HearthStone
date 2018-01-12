package plateauDeJeu;

import java.util.Scanner;

import cartes.FactoryCarte;
import etat.EtatAttente;
import etat.EtatJouer;
import etat.Joueur;

public class Main {

	public static void main(String[] args) {
		
		Jeux jeu = new Jeux();
		Scanner scJoueur1 = new Scanner(System.in);
		Scanner scJoueur2 = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		//Creation des joueurs
		
		//joueur1
		System.out.println("Joueur 1 choisir votre pseudo :");
		String joueur1Nom = scJoueur1.nextLine();
		
		System.out.println(joueur1Nom + " choisissez un heros  : "
				+ "\n 1 pour le Mage"
				+ "\n 2 pour le Guerrier"
				+ "\n 3 pour le Paladin");
		
		int joueur1SelectionHeros = scJoueur1.nextInt();
		String joueur1Heros = null;
		
		while(!((joueur1SelectionHeros == 1) || (joueur1SelectionHeros == 2) || (joueur1SelectionHeros == 3))) {
				System.out.println("Mauvaise saisie");
				joueur1SelectionHeros = scJoueur1.nextInt();
		}
			
		if(joueur1SelectionHeros == 1) {
			joueur1Heros = "Mage";
		}else if(joueur1SelectionHeros == 2) {
			joueur1Heros = "Guerrier";
		}else if(joueur1SelectionHeros == 3) {
			joueur1Heros = "Paladin";
		}
		
		//joueur2
		System.out.println("Joueur 2 choisir votre pseudo :");
		String joueur2Nom = scJoueur2.nextLine();
		
		System.out.println(joueur2Nom + " choisissez un heros : "
				+ "\n 1 pour le Mage"
				+ "\n 2 pour le Guerrier"
				+ "\n 3 pour le Paladin");
		int joueur2SelectionHeros = scJoueur2.nextInt();
		String joueur2Heros = null;
		
		while(!((joueur2SelectionHeros == 1) || (joueur2SelectionHeros == 2) || (joueur2SelectionHeros == 3))) {
				System.out.println("Mauvaise saisie");
				joueur2SelectionHeros = scJoueur2.nextInt();
		}
			
		if(joueur2SelectionHeros == 1) {
			joueur2Heros = "mage";
			
		}else if(joueur2SelectionHeros == 2) {
			joueur2Heros = "guerrier";
			
		}else if(joueur2SelectionHeros == 3) {
			joueur2Heros = "paladin";
		}
		
		Joueur joueur2 = new Joueur(joueur2Nom);
		Joueur joueur1 = new Joueur(joueur1Nom,joueur1Heros, joueur2);
		
		joueur2.setJoueurAdv(joueur1);
		joueur2.selectionHeros(joueur2Heros);
		
		jeu.lancerLeJeu(joueur1, joueur2);
		
		
	}
	

}
