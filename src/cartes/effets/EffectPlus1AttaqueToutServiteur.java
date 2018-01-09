package cartes.effets;

import cartes.FactoryCard;

import etat.Joueur;

public class EffectPlus1AttaqueToutServiteur extends EffectDecorator {
	private String name;
	private String effect;
	private Joueur j;
	
	public EffectPlus1AttaqueToutServiteur() {
		this.name = "Plus 1 d attaque";
		this.effect = "Plus 1 d attaque a tous les serviteurs alliés sur le plateau (tant que ce serviteur est vivant)";
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
	public void useEffect() { //donne a tout les serviteurs 1 point d attaque en plus pendant que ce serviteur est en vie 
		// TODO Auto-generated method stub
		for(FactoryCard c : j.getListeCarteEnJeux()){
			int attack = c.getAttaque();
			c.setAttaque(attack++);
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Cette carte possede un effet de "+this.getName()+".\n"+
			this.effect;
	}

}
