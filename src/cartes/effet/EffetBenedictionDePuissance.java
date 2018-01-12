package cartes.effet;

import cartes.FactoryCarte;
import etat.Joueur;

public class EffetBenedictionDePuissance extends EffetDecorator {
	private String nom;
    private String effet;

    public EffetBenedictionDePuissance(FactoryCarte fc) {
        this.fc = fc;
        this.nom = "Benediction de puissance";
        this.effet = "Donne +3 ATQ a un serviteur";
    }

    @Override
    public String getNom() {
        return this.nom;
    }

    @Override
    public String getEffet() {
        return fc.getEffet()+" Benediction de puissance -- " +this.effet;
    }

    @Override
    public void useEffet() { 
    	for(int i = 0;i < getJoueur().getListeCarteEnJeux().size() ;i++){
    		
    		
    		getJoueur().getListeCarteEnJeux().get(0).setAttaque(getJoueur().getListeCarteEnJeux().get(0).getAttaque() + 3);
    	}
    }

    public String toString() {
        return fc.toString() + " Cette carte possede un "+this.getEffet() + " --";
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
