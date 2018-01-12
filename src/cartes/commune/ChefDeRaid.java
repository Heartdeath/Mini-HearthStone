package cartes.commune;

import cartes.FactoryCarte;
import etat.Joueur;

public class ChefDeRaid extends FactoryCarte {

	private Joueur joueur;
	private Joueur jAdversaire;
	private int vie;
	private int nbMana;
	private int attaque;
	private boolean peutAttaquer;
	private boolean peutEtreAttaquer;

	public ChefDeRaid(Joueur j, Joueur jAdv) {
		this.joueur = j;
		this.jAdversaire = jAdv;
		this.vie = 2;
		this.nbMana = 3;
		this.attaque = 2;
		this.peutAttaquer = false;
		this.peutEtreAttaquer = true;
	}

	@Override
	public Joueur getJoueur() {
		return joueur;
	}

	@Override
	public void setJoueur(Joueur j) {
		this.joueur = j;
	}
	
	@Override
	public Joueur getAdversaire() {
		return jAdversaire;
	}

	@Override
	public void setAdversaire(Joueur jAdv) {
		this.jAdversaire = jAdv;
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
	public int getNbMana() {
		return nbMana;
	}

	@Override
	public void setNbMana(int mana) {
		this.nbMana = mana;
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
	public String getEffect() {
		return "Effet : ";
	}
	
	public String toString(){
		return "Chef de raid | "+getAttaque()+" atk | "+getVie()+" hp | " +getNbMana()+" mana |";
	}
}