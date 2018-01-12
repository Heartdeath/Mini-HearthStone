package cartes.effet;

import cartes.FactoryCarte;
import etat.Joueur;

public class EffetVolDeVie extends EffetDecorator {
	private String nom;
	private String effect;
	
	public EffetVolDeVie(FactoryCarte fc) {
		this.fc = fc;
		this.nom = "Vol de vie";
		this.effect = "Vol " + fc.getAttaque() + " point de vie";
	}

	@Override
	public String getNom() {
		return this.nom;
	}

	@Override
	public String getEffect() {
		return fc.getEffect()+" Vol de vie | " +this.effect;
	}

	@Override
	public void useEffect() {
		for(int i = 0;i < getAdversaire().getListeCarteEnJeux().size() ;i++){
			getAdversaire().getListeCarteEnJeux().get(getAdversaire().getValChoisi()).setVie(getAdversaire().getListeCarteEnJeux().get(getAdversaire().getValChoisi()).getVie() - getAttaque());
			if(getJoueur().getHeros().getVie() + getAttaque() > 30){
				getJoueur().getHeros().setVie(30);
			}else{
				getJoueur().getHeros().setVie(getJoueur().getHeros().getVie() + getAttaque());
			}
		}
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