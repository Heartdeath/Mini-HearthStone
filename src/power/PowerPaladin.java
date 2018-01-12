package power;

import cartes.commune.RecrueMainArgent_Mouton;
import etat.Joueur;
import hero.Heros;
import power.Power;

public class PowerPaladin extends Power {
	
	private String name;
	private String effet;
	
	public PowerPaladin(Heros heros) {
		this.heros = heros;
		this.name = "Renfort";
		this.effet = "Invoquant un serviteur \"recrue de la Main d argent\" ."; //1/1
	}

	public String getNomPower() {
		return this.name;
	}
	
	public String getPower() {
		return heros.getPower() + this.getNomPower();
	}

	public void utiliserHeroPower() {
		getJoueur().getListeCarteEnJeux().add(new RecrueMainArgent_Mouton(getJoueur(), getJoueurAdversaire()));
	}
	
	public String toString(){
		return heros.toString() + effet;
	}

	@Override
	public int getVie() {
		return heros.getVie();
	}

	@Override
	public void setVie(int life) {
		this.heros.setVie(life);
	}

	@Override
	public String typeHero() {
		return heros.typeHero();
	}
	
	@Override
	public Joueur getJoueurAdversaire() {
		return heros.getJoueurAdversaire();
	}
	
	@Override
	public Joueur getJoueur() {
		return heros.getJoueur();
	}
	
	@Override
	public boolean getPeutEtreAttaquer() {
		return heros.getPeutEtreAttaquer();
	}

	@Override
	public void setPeutEtreAttaque(boolean b) {
		heros.setPeutEtreAttaque(b);
	}
}
