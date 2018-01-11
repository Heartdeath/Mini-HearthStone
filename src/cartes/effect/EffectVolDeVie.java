package cartes.effect;

import cartes.FactoryCard;
import etat.Joueur;

public class EffectVolDeVie extends EffectDecorator {
	private String name;
	private String effect;
	
	public EffectVolDeVie(FactoryCard fc) {
		this.fc = fc;
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
		return fc.getEffect()+" Vol de vie | " +this.effect;
	}

	@Override
	public void useEffect() {
		for(int i = 0;i < getAdversaire().getListeCarteEnJeux().size() ;i++){
			getAdversaire().getListeCarteEnJeux().get(getAdversaire().getValChoisi()).setVie(getAdversaire().getListeCarteEnJeux().get(getAdversaire().getValChoisi()).getVie() - getAttaque());
			if(getJoueur().getHeros().getLife() + getAttaque() > 30){
				getJoueur().getHeros().setLife(30);
			}else{
				getJoueur().getHeros().setLife(getJoueur().getHeros().getLife() + getAttaque());
			}
		}
	}
	
	public String toString() {
		return fc.toString() + " Cette carte possede un "+this.getEffect() + " |";
	}
	
	@Override
	public int getAttaque() {return fc.getAttaque();}

	@Override
	public void setAttaque(int atk) {fc.setAttaque(atk);}

	@Override
	public int getVie() {return fc.getVie();}

	@Override
	public void setVie(int hp) {fc.setVie(hp);}

	@Override
	public int getNbMana() {return fc.getNbMana();}

	@Override
	public void setPeutAttaquer(boolean b) {fc.setPeutAttaquer(b);}

	@Override
	public boolean getPeutAttaquer() {return fc.getPeutEtreAttaquer();}

	@Override
	public void setPeutEtreAttaquer(boolean b) {fc.setPeutEtreAttaquer(b);}

	@Override
	public boolean getPeutEtreAttaquer() {return fc.getPeutEtreAttaquer();}
	
	@Override
	public void setNbMana(int mana) {fc.setNbMana(mana);}

	@Override
	public Joueur getJoueur() {return fc.getJoueur();}

	@Override
	public void setJoueur(Joueur j) {fc.setJoueur(j);}
	
	@Override
	public Joueur getAdversaire() {return fc.getAdversaire();}

	@Override
	public void setAdversaire(Joueur jAdv) {fc.setAdversaire(jAdv);}
}