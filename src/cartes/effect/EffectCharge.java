package cartes.effect;

import cartes.FactoryCarte;
import etat.Joueur;

public class EffectCharge extends EffectDecorator {
	private String name;
	private String effect;
	
	public EffectCharge(FactoryCarte fc) {
		this.fc = fc;
		this.name = "Charge";
		this.effect = "Attaque directement";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public String getEffect() {
		// TODO Auto-generated method stub
		return fc.getEffect()+" Charge | " +this.effect;
	}

	@Override
	public void useEffect() { 
		setPeutAttaquer(true);
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