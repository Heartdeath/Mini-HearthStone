package hero;

import etat.Joueur;
import power.Power;
/**
 * Classe abstraite pour créer le heros du joueur
 * @author Pierre
 *
 */
public abstract class Heros {
	
	/**
	 * @return la vie que possède un héros
	 */
	public abstract int getVie();
	
	/**
	 * Met a jour la vie que possède un héro
	 * @param life la vie après mis à jours que possède le héro
	 */
	public abstract void setVie(int life);
	
	/**
	 * @return le type de héros
	 */
	public abstract String typeHero();
	
	/**
	 * @return le  hero power
	 */
	public abstract String getPower();
	
	/**
	 * @return le joueur qui joue le héro
	 */
	public abstract Joueur getJoueur();
	
	/**
	 * @return le joueur adversaire qui ne joue pas le héro
	 */
	public abstract Joueur getJoueurAdversaire();
	
	/**
	 * @return si le héros peut être attaqué ou pas
	 */
	public abstract boolean getPeutEtreAttaquer();
	
	/**
	 * Met a jour si le héros peut être attaqué ou pas
	 * @param b la valeur qui indique si un héro peut être attaqué ou pas
	 */
	public abstract void setPeutEtreAttaque(boolean b);
	
}
