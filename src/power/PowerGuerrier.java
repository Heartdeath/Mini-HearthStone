package power;

import etat.Joueur;
import hero.Heros;
import power.Power;

public class PowerGuerrier extends Power {

	
	public PowerGuerrier(Heros heros) {
		this.heros = heros;
		this.nom = "Armure";
		this.effet = "Confere 2 points d armure.";
	}

	public String getNomPower() {return this.nom;}
	public String getPower() {return heros.getPower() + this.getNomPower();}

	public void utiliserHeroPower() {
		setVie(getVie()+2);
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
