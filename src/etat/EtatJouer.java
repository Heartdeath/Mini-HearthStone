package etat;

public class EtatJouer implements Etat{

	@Override
	public void etatJouer(Joueur j) {
		// TODO Auto-generated method stub
//		System.out.println("En jeu");
		j.setEtat(this);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "En jeu";
	}

}
