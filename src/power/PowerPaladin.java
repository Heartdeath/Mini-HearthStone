package power;

import cartes.commune.ServiteurUnUn;
import etat.Joueur;
import hero.Heros;
import power.Power;

public class PowerPaladin extends Power {
	
	private String name;
	private String effect;
	
	public PowerPaladin(Heros heros) {
		this.heros = heros;
		this.name = "Renfort";
		this.effect = "Invoquant un serviteur \"recrue de la Main d argent\" ."; //1/1
	}

	public String getName() {return this.name;}
	public String getPower() {return heros.getPower() + this.getName();}

	public void usePower() {
		getJoueur().getListeCarteEnJeux().add(new ServiteurUnUn(getJoueur(), getJoueurAdversaire()));
	}
	
	public String toString(){return heros.toString() + effect;}

	@Override
	public int getLife() {return heros.getLife();}

	@Override
	public void setLife(int life) {this.heros.setLife(life);}

	@Override
	public String typeHero() {return heros.typeHero();}
	
	@Override
	public Joueur getJoueurAdversaire() {return heros.getJoueurAdversaire();}
	
	@Override
	public Joueur getJoueur() {return heros.getJoueur();}
	
	@Override
	public boolean getCanBeAttaque() {return heros.getCanBeAttaque();}

	@Override
	public void setCanBeAttaque(boolean b) {heros.setCanBeAttaque(b);}
}
