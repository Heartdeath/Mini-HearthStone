package cartes.paladin;

import cartes.FactoryCarte;
import etat.Joueur;

public class ChampionFrisselame extends FactoryCarte {


	public ChampionFrisselame(Joueur joueur, Joueur jAdversaire) {
		this.joueur = joueur;
		this.jAdversaire = jAdversaire;
		this.vie = 2;
		this.mana = 4;
		this.attaque = 3;
		this.peutAttaquer = false;
		this.peutEtreAttaquer = true;
	}

	@Override
	public Joueur getJoueur() {
		return joueur;
	}

	@Override
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}
	
	@Override
	public Joueur getAdversaire() {
		return jAdversaire;
	}

	@Override
	public void setAdversaire(Joueur jAdversaire) {
		this.jAdversaire = jAdversaire;
	}

	@Override
	public int getVie() {
		return vie;
	}
	
	@Override
	public void setVie(int vie) {
		this.vie = vie;
	}
	
	@Override
	public int getMana() {
		return mana;
	}

	@Override
	public void setNbMana(int mana) {
		this.mana = mana;
	}
	
	@Override
	public int getAttaque() {
		return attaque;
	}

	@Override
	public void setAttaque(int attaque) {
		this.attaque = attaque;
	}

	@Override
	public boolean getPeutAttaquer() {
		return peutAttaquer;
	}

	@Override
	public void setPeutAttaquer(boolean bool) {
		this.peutAttaquer = bool;
	}

	@Override
	public boolean getPeutEtreAttaquer() {
		return peutEtreAttaquer;
	}

	@Override
	public void setPeutEtreAttaquer(boolean bool) {
		this.peutEtreAttaquer = bool;
	}
	
	@Override
	public String getEffet() {
		return "Effet : ";
	}
	
	public String toString(){
		return "Champion Frisselame -- "+getAttaque()+" d'attaque -- "+getVie()+" de vie -- " +getMana()+" nombre de mana --" ;
	}
}
