package etat;

public class EtatAttente implements Etat {

	@Override
	public void etatJouer(Joueur joueur) {
		joueur.setEtat(this);
	}

	@Override
	public String toString() {
		return "En Attente";
	}


}
