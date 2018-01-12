package plateauDeJeu;

import java.util.Scanner;

import etat.EtatAttente;
import etat.EtatJouer;
import etat.Joueur;

public class Main {

	public static void main(String[] args) {
		
		Jeux jeu = new Jeux();
		Scanner scJoueur1 = new Scanner(System.in);
		Scanner scJoueur2 = new Scanner(System.in);
		
		//Creation des joueurs
		
		//joueur1
		System.out.println("Joueur 1 choisir votre nom :");
		String joueur1Nom = scJoueur1.nextLine();
		
		System.out.println(joueur1Nom + " choisissez un heros entrez : "
				+ "\n 1 pour le Mage"
				+ "\n 2 pour le Guerrier"
				+ "\n 3 pour le Paladin");
		
		int j1SelectHeros = scJoueur1.nextInt();
		String j1Heros = null;
		
		while(!((j1SelectHeros == 1) || (j1SelectHeros == 2) || (j1SelectHeros == 3))) {
				System.out.println("Mauvaise saisie, veuillez recommencer");
				j1SelectHeros = scJoueur1.nextInt();
		}
			
		if(j1SelectHeros == 1) {
			j1Heros = "Mage";
		}else if(j1SelectHeros == 2) {
			j1Heros = "Guerrier";
		}else if(j1SelectHeros == 3) {
			j1Heros = "Paladin";
		}
		
		//joueur2
		System.out.println("Joueur 2 choisir votre nom :");
		String joueur2Nom = scJoueur2.nextLine();
		
		System.out.println(joueur2Nom + " choisissez un heros entrez : "
				+ "\n 1 pour le Mage"
				+ "\n 2 pour le Guerrier"
				+ "\n 3 pour le Paladin");
		int joueur2SelectHeros = scJoueur2.nextInt();
		String j2Heros = null;
		
		while(!((joueur2SelectHeros == 1) || (joueur2SelectHeros == 2) || (joueur2SelectHeros == 3))) {
				System.out.println("Mauvaise saisie, veuillez recommencer");
				joueur2SelectHeros = scJoueur2.nextInt();
		}
			
		if(joueur2SelectHeros == 1) {
			j2Heros = "mage";
		}else if(joueur2SelectHeros == 2) {
			j2Heros = "guerrier";
		}else if(joueur2SelectHeros == 3) {
			j2Heros = "paladin";
		}
		

		Joueur j2 = new Joueur(joueur2Nom);
		Joueur j1 = new Joueur(joueur1Nom,j1Heros, j2);
		j2.setJoueurAdv(j1);
		j2.selectionHeros(j2Heros);
		
		int initialisation = jeu.initialisationPartie(j1, j2);
		
		EtatJouer joue = new EtatJouer();
		EtatAttente enAttente = new EtatAttente();
		

		
		
		if(initialisation == 1){
			joue.etatJouer(j1);
			enAttente.etatJouer(j2);
			jeu.affichageDeLaPartie(j1, j2);
						
			//test
			System.out.println("------------------Etat de depart------------------");
			System.out.println(j1.getName() +" : " + j1.getEtat());
			System.out.println(j2.getName() +" : " + j2.getEtat());
			jeu.pointDeMana(j1);
		} else {
			joue.etatJouer(j2);
			enAttente.etatJouer(j1);
			jeu.affichageDeLaPartie(j2, j1);
			
			//test
			System.out.println("------------------Etat de depart------------------");
			System.out.println(j1.getName() +" : " + j1.getEtat());
			System.out.println(j2.getName() +" : " + j2.getEtat());
			jeu.pointDeMana(j2);
		}
		
		while(j1.getHeros().getVie() != 0 || j1.getHeros().getVie() != 0){
			String choix = scJoueur1.nextLine();
			//if(choix.equalsIgnoreCase("attaqueCarte"))
			
			//if(choix.equalsIgnoreCase("attaqueHero"))
			
			//if(choix.equalsIgnoreCase("joueCarte"))
			
			//if(choix.equalsIgnoreCase("joueHeroPower"))
			
			if(choix.equalsIgnoreCase("finTour"))
				jeu.changementJoueur(j1, j2);
			else
				break;
		}
	}

}
