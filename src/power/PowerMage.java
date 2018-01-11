package power;

import etat.Joueur;
import hero.Heros;
import power.Power;

public class PowerMage extends Power {
	
	private String name;
	private String effect;
	
	public PowerMage(Heros heros) {
		this.heros = heros;
		this.name = "Boule de feu";
		this.effect = "Inflige un point de degat a un adversaire";
	}

	public String getName() {return this.name;}
	public String getPower() {return heros.getPower() + this.getName();}

	public void usePower() {
		for(int i = 0;i < getJoueurAdversaire().getListeCarteEnJeux().size() ;i++){
			getJoueurAdversaire().getListeCarteEnJeux().get(getJoueurAdversaire().getValChoisi()).setVie(getJoueurAdversaire().getListeCarteEnJeux().get(getJoueurAdversaire().getValChoisi()).getVie() - 1);
    	}
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
