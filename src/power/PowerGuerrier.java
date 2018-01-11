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
		setVie(getVie()+2);
	}
	
	public String toString(){return heros.toString() + effect;}

	@Override
	public int getVie() {return heros.getVie();}

	@Override
	public void setVie(int life) {this.heros.setVie(life);}

	@Override
	public String typeHero() {return heros.typeHero();}
	
	@Override
	public Joueur getJoueurAdversaire() {return heros.getJoueurAdversaire();}

	@Override
	public Joueur getJoueur() {return heros.getJoueur();}

	@Override
	public boolean getPeutEtreAttaquer() {return heros.getPeutEtreAttaquer();}

	@Override
	public void setPeutEtreAttaque(boolean b) {heros.setPeutEtreAttaque(b);}
}
