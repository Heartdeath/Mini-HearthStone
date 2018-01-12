package power;

import hero.Heros;
/**
 * Classe abstraite utilisant qui utilise le design pattern decorator pour mettre
 * le hero power aux héros correspondant
 *
 */
public abstract class Power extends Heros{
	protected Heros heros;
	
	/**
	 * @return le nom du pouvoir
	 */
	public abstract String getNomPower();
	
	/**
	 * Utiliser le hero power
	 */
	public abstract void utiliserHeroPower();
}
