package plateauDeJeu;



import java.util.ArrayList;
import java.util.Scanner;

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
	
	public void lancerLeJeu(Joueur joueur1, Joueur joueur2) {
		
		Scanner scJoueur1 = new Scanner(System.in);
		Scanner scJoueur2 = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		
		EtatJouer joue = new EtatJouer();
		EtatAttente enAttente = new EtatAttente();
		
		int initialisation = this.initialisationPartie(joueur1, joueur2);
		
		if(initialisation == 1){
			joue.etatJouer(joueur1);
			enAttente.etatJouer(joueur2);
			this.affichageDeLaPartie(joueur1, joueur2);
			this.pointDeMana(joueur1);
		} else {
			joue.etatJouer(joueur2);
			enAttente.etatJouer(joueur1);
			this.affichageDeLaPartie(joueur2, joueur1);
			this.pointDeMana(joueur2);
		}
		
		
		while(joueur1.getHeros().getVie() != 0 || joueur2.getHeros().getVie() != 0){
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println(" choisissez votre action : "
					+ "\n 1 Voir sa main "
					+ "\n 2 Attaquer Hero  "
					+ "\n 3 HeroPower  "
					+ "\n 4 Jouer une carte"
					+ "\n 5 Fin de tour");
			Joueur joueurEnJeu = joueur1;
			Joueur joueurAdv = joueur2;
			
			if (joueur1.getEtat().toString().equals("En jeu")){
				joueurEnJeu = joueur1;
				joueurAdv = joueur2;
			} else {
				joueurEnJeu = joueur2;
				joueurAdv = joueur1;
			}
			
			int joueur1SelectionAction = scJoueur1.nextInt();
			int mana = joueurEnJeu.getMana();
			while(!((joueur1SelectionAction == 1) || (joueur1SelectionAction == 2) || (joueur1SelectionAction == 3)|| (joueur1SelectionAction == 4)|| (joueur1SelectionAction == 5))) {
					System.out.println("Mauvaise saisie");
					joueur1SelectionAction = scJoueur1.nextInt();
			}
		
			if(joueur1SelectionAction == 1) {
				joueurEnJeu.afficherCarteMain();
			}else if(joueur1SelectionAction == 2) {
				this.attaquerHero(joueurAdv.getHeros());
			}else if(joueur1SelectionAction == 3) {
				this.jouerHeroPower(joueurEnJeu.getHeros());
			}else if (joueur1SelectionAction == 4) {
				System.out.println("Veuillez saisir le num�ro de la carte :");
				String idCarte = sc.nextLine();
				System.out.println("Mana : " + mana);
				for (FactoryCarte carte : joueurEnJeu.getListeCarteDuJoueurMain()){
					if(!idCarte.equals("")){
						if ( Integer.parseInt(idCarte) == joueurEnJeu.getListeCarteDuJoueurMain().indexOf(carte)){
							if (this.coutManaCarte(joueurEnJeu, carte) == true){
								this.plateau.add(carte);
								this.jouerCarte(carte);							
								mana = mana - carte.getMana();
							} else {
								System.out.println("mana insuffisant ");
							}
						}
					}
				}
			}else if (joueur1SelectionAction == 5) {
				 this.changementJoueur(joueur1, joueur2);
			}else{
				break;
			}
		}
	}
	
}
