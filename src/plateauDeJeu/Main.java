package plateauDeJeu;

import java.util.Scanner;


import etat.EtatAttente;
import etat.EtatJouer;
import etat.Joueur;

public class Main {

	public static void main(String[] args) {
		
		Jeux jeu1 = new Jeux();
		
		/*
		 * Création des joueurs
		 */
		/*
		 * ERREUR - A corriger
		 * 
		Scanner sc = new Scanner(System.in);
		System.out.println("Joueur 1 : Veuillez choisir un pseudo : ");
		String joueur1Pseudo = sc.nextLine();
		System.out.println("Joueur 2 : Veuillez choisir un pseudo : ");
		String joueur2Pseudo = sc.nextLine();
		
		System.out.println("Joueur 1 : Veuillez choisir un heros (Mage|Guerrier|Paladin) : ");
		String joueur1Heros = sc.nextLine();
		System.out.println("Joueur 2 : Veuillez choisir un heros (Mage|Guerrier|Paladin) : ");
		String joueur2Heros = sc.nextLine();
		
		System.err.println("psd1+>"+joueur1Pseudo);
		System.err.println("psd2+>"+joueur2Pseudo);
		System.err.println("her1+>"+joueur1Heros);
		System.err.println("her2+>"+joueur2Heros);
		Joueur j1 = new Joueur(joueur1Pseudo,joueur1Heros);
		Joueur j2 = new Joueur(joueur2Pseudo,joueur2Heros);
		*/
		Joueur j1 = new Joueur("Samix", "Mage");
		Joueur j2 = new Joueur("Cedric", "Mage");
		
		jeu1.initialisationPartie(j1, j2);
		
		EtatJouer joue = new EtatJouer();
		EtatAttente enAttente = new EtatAttente();
		
		joue.etatJouer(j1);
		enAttente.etatJouer(j2);
		System.out.println("------------------Etat de depart------------------");
		System.out.println("joueur1 : " + j1.getEtat());
		System.out.println("joueur2 : " + j2.getEtat());
		
		jeu1.changementDeTour(j1, j2);
		jeu1.changementDeTour(j1, j2);
		
		// TODO Auto-generated method stub
		//TODO Scanner
	}

}
