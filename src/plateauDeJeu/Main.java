package plateauDeJeu;

import java.util.Scanner;

import etat.EtatAttente;
import etat.EtatJouer;
import etat.Joueur;

public class Main {

	public static void main(String[] args) {
		
		Jeux jeu1 = new Jeux();
		
		/*
		 * Creation des joueurs
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Joueur 1 : Veuillez choisir un pseudo : ");
		String joueur1Pseudo = sc.nextLine();
		System.out.println("Joueur 2 : Veuillez choisir un pseudo : ");
		String joueur2Pseudo = sc.nextLine();
		
		System.out.println("Joueur 1 : Veuillez choisir un heros (Mage|Guerrier|Paladin) : ");
		String joueur1Heros = sc.nextLine();
		while(!((joueur1Heros.equalsIgnoreCase("mage")) || (joueur1Heros.equalsIgnoreCase("paladin")) || (joueur1Heros.equalsIgnoreCase("guerrier")))){
			System.out.println("Erreur lors de la saisis, veuillez choisir un bon heros !");
			System.out.println("Joueur 1 : Veuillez choisir un heros (Mage|Guerrier|Paladin) : ");
			joueur1Heros = sc.nextLine();
		}
			
		System.out.println("Joueur 2 : Veuillez choisir un heros (Mage|Guerrier|Paladin) : ");
		String joueur2Heros = sc.nextLine();
		while(!((joueur2Heros.equalsIgnoreCase("mage")) || (joueur2Heros.equalsIgnoreCase("paladin")) || (joueur2Heros.equalsIgnoreCase("guerrier")))){
			System.out.println("Erreur lors de la saisis, veuillez choisir un bon heros !");
			System.out.println("Joueur 2 : Veuillez choisir un heros (Mage|Guerrier|Paladin) : ");
			joueur2Heros = sc.nextLine();
		}
		
		System.err.println("psd1+>"+joueur1Pseudo);
		System.err.println("psd2+>"+joueur2Pseudo);
		System.err.println("her1+>"+joueur1Heros);
		System.err.println("her2+>"+joueur2Heros);
		// a ameliorer
		Joueur j2 = null;
		Joueur j1 = null;
		j2 = new Joueur(joueur2Pseudo);
		j1 = new Joueur(joueur1Pseudo,joueur1Heros, j2);
		j2.setJoueurAdv(j1);
		j2.setHeros(joueur2Heros);
		
		int initialisation = jeu1.initialisationPartie(j1, j2);
		
		EtatJouer joue = new EtatJouer();
		EtatAttente enAttente = new EtatAttente();
		

		
		
		if(initialisation == 1){
			joue.etatJouer(j1);
			enAttente.etatJouer(j2);
			
			//clearscreen
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			
			jeu1.affichageBoard(j1, j2);
						
			//test
			System.out.println("------------------Etat de depart------------------");
			System.out.println(j1.getName() +" : " + j1.getEtat());
			System.out.println(j2.getName() +" : " + j2.getEtat());
			jeu1.pointDeMana(j1);
		} else {
			joue.etatJouer(j2);
			enAttente.etatJouer(j1);
						
			//clearscreen
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			
			jeu1.affichageBoard(j2, j1);
			
			//test
			System.out.println("------------------Etat de depart------------------");
			System.out.println(j1.getName() +" : " + j1.getEtat());
			System.out.println(j2.getName() +" : " + j2.getEtat());
			jeu1.pointDeMana(j2);
		}
		
		while(j1.getHeros().getVie() != 0 || j1.getHeros().getVie() != 0){
			String choix = sc.nextLine();
			//if(choix.equalsIgnoreCase("attaqueCarte"))
			
			//if(choix.equalsIgnoreCase("attaqueHero"))
			
			//if(choix.equalsIgnoreCase("joueCarte"))
			
			//if(choix.equalsIgnoreCase("joueHeroPower"))
			
			if(choix.equalsIgnoreCase("finTour"))
				jeu1.changementDeTour(j1, j2);
			else
				break;
		}
		
		//TODO Scanner
	}

}
