package cartes.effect;

import cartes.FactoryCarte;
import etat.Joueur;

public class Effect1DegatTOUSServiteur extends EffectDecorator {
	private String name;
    private String effect;

    public Effect1DegatTOUSServiteur(FactoryCarte fc) {
        this.fc = fc;
        this.name = "Tourbillon";
        this.effect = "Inflige 1 degat a tous les serviteurs";
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return this.name;
    }

    @Override
    public String getEffect() {
        // TODO Auto-generated method stub
        return fc.getEffect()+" Tourbillon | " +this.effect;
    }

    @Override
    public void useEffect() { 
    	for(FactoryCarte c : getJoueur().getListeCarteEnJeux()){
			int life = c.getVie();
			c.setVie(life-1);
		}
    	for(FactoryCarte c : getAdversaire().getListeCarteEnJeux()){
			int life = c.getVie();
			c.setVie(life-1);
		}
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