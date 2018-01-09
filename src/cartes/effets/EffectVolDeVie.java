package cartes.effets;

import etat.Joueur;

public class EffectVolDeVie extends EffectDecorator {
	private String name;
	private String effect;
	private Joueur joueurHeros;
	
	public EffectVolDeVie() {
		this.name = "Vol de vie";
		this.effect = "Vol " + fc.getAttaque() + " point de vie";
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
	public void useEffect() {
		// TODO Auto-generated method stub
		if(joueurHeros.getHeros().getLife() + fc.getAttaque() > 30){
			joueurHeros.getHeros().setLife(30);
		}else{
			joueurHeros.getHeros().setLife(joueurHeros.getHeros().getLife() + fc.getAttaque());
		}
	}
	
	public String toString() {
		return "Cette carte possede un effet de "+this.getName()+".\n"+
				this.effect;
	}
}