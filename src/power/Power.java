package power;

import hero.Heros;
/**
 * Classe abstraite utilisant le design pattern decorator pour l'ajout
 * du pouvoir aux héros correspondant
 * @author E145855N
 *
 */
public abstract class Power extends Heros{
	protected Heros heros;
	
	/**
	 * @return le nom du pouvoir
	 */
	public abstract String getNomPower();
	
	/**
	 * Utilise le pouvoir du héros
	 */
	public abstract void usePower();
}
