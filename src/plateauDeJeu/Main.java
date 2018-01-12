package plateauDeJeu;

import java.util.Scanner;

import etat.EtatAttente;
import etat.EtatJouer;
import etat.Joueur;

public class Main {

	public static void main(String[] args) {
		
		Jeux jeu = new Jeux();
		
		/*
		 * Creation des joueurs
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Joueur 1 choisir votre nom :");
		String j1Nom = sc.nextLine();
		System.out.println("Joueur 2 choisir votre nom :");
		String j2Nom = sc.nextLine();
		
		System.out.println(j1Nom + " choisissez un heros !!! Entrez : "
				+ "\n 1 pour le Mage"
				+ "\n 2 pour le Guerrier"
				+ "\n 3 pour le Paladin");
		int j1SelectHeros = sc.nextInt();
		String j1Heros = null;
		System.out.println(j1SelectHeros);
		
		while(!((j1SelectHeros == 1) || (j1SelectHeros == 2) || (j1SelectHeros == 3))) {
				System.out.println("Mauvaise saisie, veuillez recommencer");
				j1SelectHeros = sc.nextInt();
		}
			
		if(j1SelectHeros == 1) {
			j1Heros = "mage";
		}else if(j1SelectHeros == 2) {
			j1Heros = "guerrier";
		}else if(j1SelectHeros == 3) {
			j1Heros = "paladin";
		}
		
		System.out.println(j2Nom + " choisissez un heros !!! Entrez : "
				+ "\n 1 pour le Mage"
				+ "\n 2 pour le Guerrier"
				+ "\n 3 pour le Paladin");
		int j2SelectHeros = sc.nextInt();
		String j2Heros = null;
		System.out.println(j2SelectHeros);
		
		while(!((j2SelectHeros == 1) || (j2SelectHeros == 2) || (j2SelectHeros == 3))) {
				System.out.println("Mauvaise saisie, veuillez recommencer");
				j2SelectHeros = sc.nextInt();
		}
			
		if(j2SelectHeros == 1) {
			j2Heros = "mage";
		}else if(j2SelectHeros == 2) {
			j2Heros = "guerrier";
		}else if(j2SelectHeros == 3) {
			j2Heros = "paladin";
		}
		

		// a ameliorer
		Joueur j2 = null;
		Joueur j1 = null;
		j2 = new Joueur(j2Nom);
		j1 = new Joueur(j1Nom,j1Heros, j2);
		j2.setJoueurAdv(j1);
		j2.setHeros(j2Heros);
		
		int initialisation = jeu.initialisationPartie(j1, j2);
		
		EtatJouer joue = new EtatJouer();
		EtatAttente enAttente = new EtatAttente();
		

		
		
		if(initialisation == 1){
			joue.etatJouer(j1);
			enAttente.etatJouer(j2);
			
			//clearscreen
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			
			jeu.affichageDeLaPartie(j1, j2);
						
			//test
			System.out.println("------------------Etat de depart------------------");
			System.out.println(j1.getName() +" : " + j1.getEtat());
			System.out.println(j2.getName() +" : " + j2.getEtat());
			jeu.pointDeMana(j1);
		} else {
			joue.etatJouer(j2);
			enAttente.etatJouer(j1);
						
			//clearscreen
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			
			jeu.affichageDeLaPartie(j2, j1);
			
			//test
			System.out.println("------------------Etat de depart------------------");
			System.out.println(j1.getName() +" : " + j1.getEtat());
			System.out.println(j2.getName() +" : " + j2.getEtat());
			jeu.pointDeMana(j2);
		}
		
		while(j1.getHeros().getVie() != 0 || j1.getHeros().getVie() != 0){
			String choix = sc.nextLine();
			//if(choix.equalsIgnoreCase("attaqueCarte"))
			
			//if(choix.equalsIgnoreCase("attaqueHero"))
			
			//if(choix.equalsIgnoreCase("joueCarte"))
			
			//if(choix.equalsIgnoreCase("joueHeroPower"))
			
			if(choix.equalsIgnoreCase("finTour"))
				jeu.changementJoueur(j1, j2);
			else
				break;
		}
		
		//TODO Scanner
	}

}
