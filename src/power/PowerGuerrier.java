package power;

import etat.Joueur;
import hero.Heros;
import power.Power;

public class PowerGuerrier extends Power {
	
	private String name;
	private String effect;
	
	public PowerGuerrier(Heros heros) {
		this.heros = heros;
		this.name = "Armure";
		this.effect = "Confere 2 points d armure.";
	}

	public String getName() {return this.name;}
	public String getPower() {return heros.getPower() + this.getName();}

	public void usePower() {
		setLife(getLife()+2);
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
