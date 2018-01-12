package cartes.effet;

import cartes.FactoryCarte;
import etat.Joueur;

public class EffetPlus1Attaque extends EffetDecorator {
	private String name;
	private String effect;
	
	public EffetPlus1Attaque(FactoryCarte fc) {
		this.fc = fc;
		this.name = "Plus 1 attaque";
		this.effect = "Plus 1 attaque a tous les serviteurs allies sur le plateau (tant que ce serviteur est vivant)";
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getEffect() {return fc.getEffect()+" | " +this.effect;}

	@Override
	public void useEffect() {
		for(FactoryCarte c : getJoueur().getListeCarteEnJeux()){
			int attack = c.getAttaque();
			c.setAttaque(attack+1);
		}
		//TODO VERIFIER LEFFET TANT QUE SERVITEUR VIVANT
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
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
