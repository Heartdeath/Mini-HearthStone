package cartes.effect;

import cartes.FactoryCarte;
import cartes.commune.ServiteurZeroDeux;
import etat.Joueur;

/**
 * Created by E178220S on 10/01/18.
 */
public class EffectInvoqueDeuxServiteurs extends EffectDecorator{
    private String name;
    private String effect;

    public EffectInvoqueDeuxServiteurs(FactoryCarte fc) {
        this.fc = fc;
        this.name = "Image miroir";
        this.effect = "Invoque deux serviteurs 0/2 avec provocation";
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return this.name;
    }

    @Override
    public String getEffect() {
        // TODO Auto-generated method stub
        return fc.getEffect()+" Image miroir | " +this.effect;
    }

    @Override
    public void useEffect() {
    	FactoryCarte fc = new ServiteurZeroDeux(getJoueur(), getAdversaire());
    	            fc = new EffectProvocation(fc);
    	getJoueur().getListeCarteEnJeux().add(fc);
    	getJoueur().getListeCarteEnJeux().add(fc);
    }

    public String toString() {
        return fc.toString() + " Cette carte possede un "+this.getEffect() + " |";
    }

    @Override
    public int getAttaque() {return fc.getAttaque();}

    @Override
    public void setAttaque(int atk) {}

    @Override
    public int getVie() {return fc.getVie();}

    @Override
    public void setVie(int hp) {}

    @Override
    public int getNbMana() {return fc.getNbMana();}

    @Override
    public void setPeutAttaquer(boolean b) {}

    @Override
    public boolean getPeutAttaquer() {return fc.getPeutEtreAttaquer();}

    @Override
    public void setPeutEtreAttaquer(boolean b) {}

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
