package etat;

public class EtatAttente implements Etat {

	@Override
	public void etatJouer(Joueur j) {
		// TODO Auto-generated method stub
//		System.out.println("En Attente");
		j.setEtat(this);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "En Attente";
	}


}
