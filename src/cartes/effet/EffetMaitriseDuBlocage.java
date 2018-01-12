package cartes.effet;

import cartes.FactoryCarte;
import cartes.commune.ImageMiroir;
import etat.Joueur;



public class EffetMaitriseDuBlocage extends EffetDecorator{
    private String nom;
    private String effect;

    public EffetMaitriseDuBlocage(FactoryCarte fc) {
        this.fc = fc;
        this.nom = "Maitrise du blocage";
        this.effect = "Vous gagner 5 points d'armure. Vous piochez une carte";
    }

    @Override
    public String getNom() {
        return this.nom;
    }

    @Override
    public String getEffet() {
        return fc.getEffet()+ " Maitrise du blocage -- " +this.effect;
    }

    @Override
    public void useEffet() {
    	
    	getJoueur().getHeros().setVie(getJoueur().getHeros().getVie() + 5);
    	
    	getJoueur().tirageCarte();
    }

    public String toString() {
      return fc.toString() + " Cette carte possede un "+this.getNom();
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
    public int getMana() {
    		return fc.getMana();
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
	public void setJoueur(Joueur joueur) {
		fc.setJoueur(joueur);
	}
	
	@Override
	public Joueur getAdversaire() {
		return fc.getAdversaire();
	}

	@Override
	public void setAdversaire(Joueur jAdversaire) {
		fc.setAdversaire(jAdversaire);
	}

}
