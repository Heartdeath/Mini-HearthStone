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
		
		int initialisation = jeu.initialisationPartie(joueur1, joueur2);
		
		EtatJouer joue = new EtatJouer();
		EtatAttente enAttente = new EtatAttente();
		

		
		
		if(initialisation == 1){
			joue.etatJouer(joueur1);
			enAttente.etatJouer(joueur2);
			jeu.affichageDeLaPartie(joueur1, joueur2);
						
			
			
			jeu.pointDeMana(joueur1);
		} else {
			joue.etatJouer(joueur2);
			enAttente.etatJouer(joueur1);
			jeu.affichageDeLaPartie(joueur2, joueur1);
			
			
			jeu.pointDeMana(joueur2);
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
			String joueur1Action = null;
			int mana = joueurEnJeu.getMana();
		while(!((joueur1SelectionAction == 1) || (joueur1SelectionAction == 2) || (joueur1SelectionAction == 3)|| (joueur1SelectionAction == 4)|| (joueur1SelectionAction == 5))) {
					System.out.println("Mauvaise saisie");
					joueur1SelectionAction = scJoueur1.nextInt();
			}
		
			if(joueur1SelectionAction == 1) {
				joueurEnJeu.afficherCarteMain();
			}else if(joueur1SelectionAction == 2) {
				jeu.attaquerHero(joueurAdv.getHeros());
			}else if(joueur1SelectionAction == 3) {
				jeu.jouerHeroPower(joueurEnJeu.getHeros());
			}else if (joueur1SelectionAction == 4) {
				System.out.println("Veuillez saisir le numéro de la carte :");
				String idCarte = sc.nextLine();
				System.out.println("Mana : " + mana);
				for (FactoryCarte carte : joueurEnJeu.getListeCarteDuJoueurMain()){
					if(!idCarte.equals("")){
						
					
					if ( Integer.parseInt(idCarte) == joueurEnJeu.getListeCarteDuJoueurMain().indexOf(carte)){
						
						if (jeu.coutManaCarte(joueurEnJeu, carte) == true){
							jeu.plateau.add(carte);
							jeu.jouerCarte(carte);							
							mana = mana - carte.getMana();
							
						} else {
							System.out.println("mana insuffisant ");
						}
	
					}
					}
				}
					
				
			

			}else if (joueur1SelectionAction == 5) {
				 jeu.changementJoueur(joueur1, joueur2);;
			}
		
			else
				break;
		}
	}

}
