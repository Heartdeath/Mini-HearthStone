package etat;

public class EtatAttente implements Etat {

	@Override
	public void etatJouer(Joueur j) {
		j.setEtat(this);
	}

	@Override
	public String toString() {
		return "En Attente";
	}


}
