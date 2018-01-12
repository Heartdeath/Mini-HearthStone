package plateauDeJeu;



import java.util.ArrayList;


import cartes.FactoryCarte;
import etat.EtatAttente;
import power.PowerGuerrier;
import power.PowerMage;
import power.PowerPaladin;
import etat.EtatJouer;
import etat.Joueur;
import hero.Heros;

public class Jeux {
	public ArrayList<FactoryCarte> plateau = new ArrayList<FactoryCarte>();
	public int initialisationPartie(Joueur joueur1, Joueur joueur2){
		int min = 1;
		int max = 3;
		int random = (int)(Math.random()*(max-min)) + min;
		if(random == 1){
			joueur1.cartesEnMain(random);
			joueur2.cartesEnMain(2);
		} else {
			joueur1.cartesEnMain(random);
			joueur2.cartesEnMain(1);
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
			j2.ajoutCartesMain();
			
			affichageDeLaPartie(j2, j1);
			
			System.out.println(j1.getName() +" : " + j1.getEtat());
			System.out.println(j2.getName() +" : " + j2.getEtat());
			
			pointDeMana(j2);
		}else if (j1.getEtat().toString().equals("En Attente") && j2.getEtat().toString().equals("En jeu")) {
			joue.etatJouer(j1);
			enAttente.etatJouer(j2);
			j1.ajoutCartesMain();
			
			affichageDeLaPartie(j1, j2);
			
			System.out.println(j1.getName() +" : " + j1.getEtat());
			System.out.println(j2.getName() +" : " + j2.getEtat());
			
			pointDeMana(j1);
		}
	}
	
	public void observationEffectCarte(FactoryCarte carte){
		System.out.println(carte.getEffet());
		
	}

	public void jouerCarte(FactoryCarte carte){
		observationEffectCarte(carte);
	}
	
	public void jouerHeroPower(Heros h){
		System.out.println(h.getPower());
	}
	
	public void attaquerHero(Heros h){
		System.out.println(h.getJoueurAdversaire().getName());
	}
	
	public boolean coutManaCarte(Joueur joueur, FactoryCarte carte){
		if (joueur.getMana() >= carte.getMana()){
			return true;
		} else {
			return false;
		}
	}
	
	public void pointDeMana(Joueur j){
		
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
		adversaire.affichageCartesJeu();
		System.out.println("-------------------------------------------------------------------------------------");
		
		System.out.println("Vos carte en jeu :");
		
		joueur.affichageCartesJeu();
		
		System.out.println("--------------------------------------------------------------------------------------");
		
		System.out.println("Vos carte en main :");
		
		joueur.affichageCartesMain();
		
		System.out.println("--------------------------------------------------------------------------------------");
		
		joueur.affichageInfoJoueur();
		
		
	}
}
