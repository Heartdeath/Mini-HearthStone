package hero;

import etat.Joueur;
import power.Power;

public class HerosPaladin extends Heros {

	private Joueur jAdversaire;
	private Joueur joueur;
	private int vie;
	private boolean peutEtreAttaquer;
	
	public HerosPaladin(Joueur jAdv, Joueur j){
		this.joueur = j;
		this.jAdversaire = jAdv;
		this.vie = 30;
		this.peutEtreAttaquer = true;
	}
	
	@Override
	public int getVie() {
		return vie;
	}

	@Override
	public void setVie(int life) {
		this.vie = life;
	}

	@Override
	public String typeHero() {
		return "Paladin";
	}

	@Override
	public String getPower() {
		return "Power :";
	}
	
	public String toString() {
		return typeHero();
	}

	@Override
	public Joueur getJoueurAdversaire() {
		return jAdversaire;
	}

	@Override
	public Joueur getJoueur() {
		return joueur;
	}
	
	@Override
	public boolean getPeutEtreAttaquer() {
		return peutEtreAttaquer;
	}

	@Override
	public void setPeutEtreAttaque(boolean b) {
		this.peutEtreAttaquer = b;
	}
}
