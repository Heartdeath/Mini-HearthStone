package power;

import etat.Joueur;
import hero.Heros;
import power.Power;

public class PowerMage extends Power {

	
	public PowerMage(Heros heros) {
		this.heros = heros;
		this.nom = "Boule de feu";
		this.effet = "Inflige un point de degat a un adversaire";
	}

	public String getNomPower() {
		return this.nom;
	}
	
	public String getPower() {
		return heros.getPower() + this.getNomPower();
	}

	public void utiliserHeroPower() {
		for(int i = 0;i < getJoueurAdversaire().getListeCarteEnJeux().size() ;i++){
			
			getJoueurAdversaire().getListeCarteEnJeux().get(0).setVie(getJoueurAdversaire().getListeCarteEnJeux().get(0).getVie() - 1);
    		}
	}
	
	public String toString(){
		return heros.toString() + effet;
	}

	@Override
	public int getVie() {
		return heros.getVie();
	}

	@Override
	public void setVie(int life) {
		this.heros.setVie(life);
	}

	@Override
	public String typeHero() {
		return heros.typeHero();
	}

	@Override
	public Joueur getJoueurAdversaire() {
		return heros.getJoueurAdversaire();
	}
	
	@Override
	public Joueur getJoueur() {
		return heros.getJoueur();
	}
	
	@Override
	public boolean getPeutEtreAttaquer() {
		return heros.getPeutEtreAttaquer();
	}

	@Override
	public void setPeutEtreAttaque(boolean b) {
		heros.setPeutEtreAttaque(b);
	}
}
