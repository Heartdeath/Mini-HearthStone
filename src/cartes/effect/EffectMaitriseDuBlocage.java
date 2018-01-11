package cartes.effect;

import cartes.FactoryCarte;
import cartes.commune.ServiteurZeroDeux;
import etat.Joueur;

/**
 * Created by E178220S on 10/01/18.
 */
public class EffectMaitriseDuBlocage extends EffectDecorator{
    private String name;
    private String effect;

    public EffectMaitriseDuBlocage(FactoryCarte fc) {
        this.fc = fc;
        this.name = "Maitrise du blocage";
        this.effect = "+5 d armure et place une carte aleatoire de la pioche dans votre main";
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return this.name;
    }

    @Override
    public String getEffect() {
        // TODO Auto-generated method stub
        return fc.getEffect()+ " Maitrise du blocage | " +this.effect;
    }

    @Override
    public void useEffect() {
    	getJoueur().getHeros().setVie(getJoueur().getHeros().getVie() + 5);
    	getJoueur().tirageCarte();
    }

    public String toString() {
        return fc.toString() + " Cette carte possede un "+this.getName();
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
