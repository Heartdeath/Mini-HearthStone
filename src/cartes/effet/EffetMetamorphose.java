package cartes.effet;

import cartes.FactoryCarte;
import cartes.commune.RecrueMainArgent_Mouton;
import etat.Joueur;

public class EffetMetamorphose extends EffetDecorator{
	private String nom;
	private String effet;
	
	public EffetMetamorphose(FactoryCarte fc) {
		this.fc = fc;
		this.nom = "Metamorphose";
		this.effet = "Transforme un serviteur en mouton 1/1 ";
	}

	@Override
	public String getNom() {
		return this.nom;
	}

	@Override
	public String getEffet() {
		return fc.getEffet()+" Metamorphose -- " +this.effet;
	}

	@Override
	public void useEffet() { 
		for(int i = 0;i < getAdversaire().getListeCarteEnJeux().size() ;i++){
    		
			getAdversaire().getListeCarteEnJeux().remove(0);
    		
			getAdversaire().getListeCarteEnJeux().add(new RecrueMainArgent_Mouton(getJoueur(), getAdversaire()));
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
