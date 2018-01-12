package power;

import hero.Heros;
/**
 * Classe abstraite utilisant qui utilise le design pattern decorator pour mettre
 * le hero power aux h�ros correspondant
 *
 */
public abstract class Power extends Heros{
	
	protected String nom;
	protected String effet;
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
