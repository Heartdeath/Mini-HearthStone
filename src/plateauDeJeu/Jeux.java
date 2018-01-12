package plateauDeJeu;

import etat.EtatAttente;
import etat.EtatJouer;
import etat.Joueur;

public class Jeux {
	
	public int initialisationPartie(Joueur j1, Joueur j2){
		int min = 1;
		int max = 3;
		int random = (int)(Math.random()*(max-min)) + min;
		if(random == 1){
			j1.initialisationDesCartesEnMain(random);
			j2.initialisationDesCartesEnMain(2);
		} else {
			j1.initialisationDesCartesEnMain(random);
			j2.initialisationDesCartesEnMain(1);
		}
		return random;
	}
	
	public void changementJoueur(Joueur j1, Joueur j2){
		
		EtatJouer joue = new EtatJouer();
		EtatAttente enAttente = new EtatAttente();
		
		System.out.println("------Changement de joueur------");
		
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
		//CEDRIC
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
			System.out.println("Erreur - Mana hors norme, il ne faut pas tricher !");
			j.setMana(1);
		}
	}
	
	public void affichageDeLaPartie(Joueur j, Joueur adversaire){
		System.out.println("Carte de " +adversaire.getName()+ ":");
		adversaire.affichageDesCartesEnJeu();
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("Vos carte en jeu :");
		j.affichageDesCartesEnJeu();
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("Vos carte en main :");
		j.affichageDesCartesEnMain();
		System.out.println("-----------------------------------------------------------------------------------------------");
		j.affichageDesInfoJoueur();
		System.out.println("-----------------------------------------------------------------------------------------------");
	}
}
