package plateauDeJeu;

import etat.EtatAttente;
import etat.EtatJouer;
import etat.Joueur;

public class Jeux {
	
	public void initialisationPartie(Joueur j1, Joueur j2){
		int lower = 1 , higher = 3;
		int random = (int)(Math.random()*(higher-lower)) + lower;
		System.out.println("random == " + random);
		if(random == 1){
			j1.initialiseMain(random);
			System.out.println("---------");
			j2.initialiseMain(2);
		} else {
			j1.initialiseMain(random);
			System.out.println("---------");
			j2.initialiseMain(1);
		}
		System.out.println("--------- verif des mains ci dessous");
		//verif des mains ci dessous
		j1.afficherCardMain();
		System.out.println("---------");
		j2.afficherCardMain();
		
	}
	
	public void changementDeTour(Joueur j1, Joueur j2){
		//TODO DP State
		EtatJouer joue = new EtatJouer();
		EtatAttente enAttente = new EtatAttente();
		
		System.out.println("------------------Changement de Tour------------------");
		
		if (j1.getEtat().toString().equals("En jeu") && j2.getEtat().toString().equals("En Attente")){
			
			enAttente.etatJouer(j1);
			joue.etatJouer(j2);
			
			System.out.println("joueur1 : " + j1.getEtat());
			System.out.println("joueur2 : " + j2.getEtat());
			
		}else if (j1.getEtat().toString().equals("En Attente") && j2.getEtat().toString().equals("En jeu")) {
			
			joue.etatJouer(j1);
			enAttente.etatJouer(j2);
			
			System.out.println("joueur1 : " + j1.getEtat());
			System.out.println("joueur2 : " + j2.getEtat());
			
		}
	}
	
	public void observationEffectCarte(){
		//TODO DP Observer (et DP State)
		//CEDRIC
	}
	
	public void pointDeMana(Joueur j){
		//TODO +1 par tour (max 10)
		int manaJoueur = j.getMana();
		if(manaJoueur == 10){
			j.setMana(10);
		} else if (manaJoueur < 10 && manaJoueur > 0){
			j.setMana(manaJoueur++);
		} else {
			System.out.println("Erreur - Mana hors norme, il ne faut pas tricher !");
			j.setMana(1);
		}
	}
}
