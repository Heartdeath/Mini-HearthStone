package heroPower;

import etat.Joueur;
import heroPower.Power;

public class PowerMage implements Power {
	
	private String name;
	private String effect;
	private Joueur joueurAdversaire;
	
	public PowerMage() {
		this.name = "Boule de feu";
		this.effect = "Inflige un point de degat a  "+this.joueurAdversaire.getName();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public String getEffect() {
		// TODO Auto-generated method stub
		return this.effect;
	}

	@Override
	public void usePower() {
		// TODO Auto-generated method stub
		System.out.println(toString());
		joueurAdversaire.getHeros().setLife(joueurAdversaire.getHeros().getLife() - 1);
	}

	public String toString(){
		return "Utilise sa capacite special : " + this.name + " !"+
				"\n" + this.effect;
	}
}
