package hero;

import etat.Joueur;
import power.Power;
/**
 * Classe abstraite pour cr�er le heros du joueur
 * @author Pierre
 *
 */
public abstract class Heros {
	
	protected Joueur jAdversaire;
	protected Joueur joueur;
	protected int vie;
	protected boolean peutEtreAttaquer;
	
	/**
	 * @return la vie que poss�de un h�ros
	 */
	public abstract int getVie();
	
	/**
	 * Met a jour la vie que poss�de un h�ro
	 * @param life la vie apr�s mis � jours que poss�de le h�ro
	 */
	public abstract void setVie(int life);
	
	/**
	 * @return le type de h�ros
	 */
	public abstract String typeHero();
	
	/**
	 * @return le  hero power
	 */
	public abstract String getPower();
	
	/**
	 * @return le joueur qui joue le h�ro
	 */
	public abstract Joueur getJoueur();
	
	/**
	 * @return le joueur adversaire qui ne joue pas le h�ro
	 */
	public abstract Joueur getJoueurAdversaire();
	
	/**
	 * @return si le h�ros peut �tre attaqu� ou pas
	 */
	public abstract boolean getPeutEtreAttaquer();
	
	/**
	 * Met a jour si le h�ros peut �tre attaqu� ou pas
	 * @param b la valeur qui indique si un h�ro peut �tre attaqu� ou pas
	 */
	public abstract void setPeutEtreAttaque(boolean b);
	
}
