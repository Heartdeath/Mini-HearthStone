package cartes.effet;

import etat.Joueur;
import cartes.FactoryCarte;
import cartes.commune.ImageMiroir;


public class EffetImageMiroir extends EffetDecorator{
    private String nom;
    private String effect;

    public EffetImageMiroir(FactoryCarte fc) {
        this.fc = fc;
        this.nom = "Image miroir";
        this.effect = "Invoque deux serviteurs 0/2 avec provocation";
    }

    @Override
    public String getNom() {
        return this.nom;
    }

    @Override
    public String getEffect() {
        return fc.getEffect()+" Image miroir | " +this.effect;
    }

    @Override
    public void useEffect() {
    	FactoryCarte fc = new ImageMiroir(getJoueur(), getAdversaire());
    	            fc = new EffetProvocation(fc);
    	getJoueur().getListeCarteEnJeux().add(fc);
    	getJoueur().getListeCarteEnJeux().add(fc);
    }

    public String toString() {
        return fc.toString() + " Cette carte possede un "+this.getEffect() + " |";
    }

    @Override
    public int getAttaque() {
    		return fc.getAttaque();
    	}

    @Override
    public void setAttaque(int atk) {
    	
    }

    @Override
    public int getVie() {
    		return fc.getVie();
    	}

    @Override
    public void setVie(int hp) {
    	
    }

    @Override
    public int getNbMana() {
    		return fc.getNbMana();
    	}

    @Override
    public void setPeutAttaquer(boolean b) {
    	
    }

    @Override
    public boolean getPeutAttaquer() {
    		return fc.getPeutEtreAttaquer();
    	}

    @Override
    public void setPeutEtreAttaquer(boolean b) {}

    @Override
    public boolean getPeutEtreAttaquer() {
    		return fc.getPeutEtreAttaquer();
    	}

    @Override
	public void setNbMana(int mana) {
    		fc.setNbMana(mana);
    	}

	@Override
	public Joueur getJoueur() {
		return fc.getJoueur();
	}

	@Override
	public void setJoueur(Joueur j) {
		fc.setJoueur(j);
	}
	
	@Override
	public Joueur getAdversaire() {
		return fc.getAdversaire();
	}

	@Override
	public void setAdversaire(Joueur jAdv) {
		fc.setAdversaire(jAdv);
	}

}
