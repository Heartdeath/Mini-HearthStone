package hero;

import etat.Joueur;
import power.Power;
/**
 * Classe abstraite creant le heros du joueur
 * @author E145855N
 *
 */
public abstract class Heros {
	
	/**
	 * @return la vie du héros
	 */
	public abstract int getLife();
	
	/**
	 * Met a jour la vie du héros
	 * @param life etant la vie du héros mise a jour
	 */
	public abstract void setLife(int life);
	
	/**
	 * @return le type de héros (Mage|Paladin|Guerrier)
	 */
	public abstract String typeHero();
	
	/**
	 * @return le pouvoir du héros
	 */
	public abstract String getPower();
	
	/**
	 * @return le joueur jouant le héro
	 */
	public abstract Joueur getJoueur();
	
	/**
	 * @return le joueur adversaire ne jouant pas le héro
	 */
	public abstract Joueur getJoueurAdversaire();
	
	/**
	 * @return si le héros peut être attaqué ou non
	 */
	public abstract boolean getCanBeAttaque();
	
	/**
	 * Met a jour si le héros peut être attaqué ou non
	 * @param b étant la valeur indiquant si le héros peut être attaqué ou non
	 */
	public abstract void setCanBeAttaque(boolean b);
	
}
