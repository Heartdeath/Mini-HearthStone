package plateauDeJeu;

import etat.EtatAttente;
import etat.EtatJouer;
import etat.Joueur;

public class Jeux {
	
	public int initialisationPartie(Joueur joueur1, Joueur joueur2){
		int min = 1;
		int max = 3;
		int random = (int)(Math.random()*(max-min)) + min;
		if(random == 1){
			joueur1.initialisationDesCartesEnMain(random);
			joueur2.initialisationDesCartesEnMain(2);
		} else {
			joueur1.initialisationDesCartesEnMain(random);
			joueur2.initialisationDesCartesEnMain(1);
		}
		return random;
	}
	
	public void changementJoueur(Joueur j1, Joueur j2){
		
		EtatJouer joue = new EtatJouer();
		EtatAttente enAttente = new EtatAttente();
		
		System.out.println("-- Tour suivant --");
		
		if (j1.getEtat().toString().equals("En jeu") && j2.getEtat().toString().equals("En Attente")){
			joue.etatJouer(j2);
			enAttente.etatJouer(j1);
			j2.ajoutCarteDansLaMain();
			
			affichageDeLaPartie(j2, j1);
			
			System.out.println(j1.getName() +" : " + j1.getEtat());
			System.out.println(j2.getName() +" : " + j2.getEtat());
			
			pointDeMana(j2);
		}else if (j1.getEtat().toString().equals("En Attente") && j2.getEtat().toString().equals("En jeu")) {
			joue.etatJouer(j1);
			enAttente.etatJouer(j2);
			j1.ajoutCarteDansLaMain();
			
			affichageDeLaPartie(j1, j2);
			
			System.out.println(j1.getName() +" : " + j1.getEtat());
			System.out.println(j2.getName() +" : " + j2.getEtat());
			
			pointDeMana(j1);
		}
	}
	
	public void observationEffectCarte(){
		//TODO DP Observer (et DP State)
		
	}
	
	public void coutManaCarteDiffPointDeManCourant(){
		//TODO Verifier qu'il y a assez de mana pour jouer les cartes
	}
	
	public void pointDeMana(Joueur j){
		//TODO +1 par tour (max 10)
		int manaJoueur = j.getMana();
		if(manaJoueur == 10){
			j.setMana(10);
		} else if (manaJoueur < 10){
			j.setMana(manaJoueur+1);
		} else {
			System.out.println("Erreur");
			j.setMana(1);
		}
	}
	
	public void affichageDeLaPartie(Joueur joueur, Joueur adversaire){
		System.out.println("Carte de " +adversaire.getName()+ ":");
		adversaire.affichageDesCartesEnJeu();
		System.out.println("-------------------------------------------------------------------------------------");
		
		System.out.println("Vos carte en jeu :");
		
		joueur.affichageDesCartesEnJeu();
		
		System.out.println("--------------------------------------------------------------------------------------");
		
		System.out.println("Vos carte en main :");
		
		joueur.affichageDesCartesEnMain();
		
		System.out.println("--------------------------------------------------------------------------------------");
		
		joueur.affichageDesInfoJoueur();
		
		System.out.println("--------------------------------------------------------------------------------------");
	}
}
