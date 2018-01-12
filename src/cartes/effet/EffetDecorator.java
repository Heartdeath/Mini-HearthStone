package cartes.effet;

import cartes.FactoryCarte;
/**
 * Classe abstraite utilisant le design pattern decorator 
 *
 *
 */
public abstract class EffetDecorator extends FactoryCarte{
	protected FactoryCarte fc;
	
	/**
	 * @return le nom de l'effet
	 */
	public abstract String getName();
	
	/**
	 * @return l'effet
	 */
	public abstract String getEffect();
	
	/**
	 * Utilise l'effet
	 */
	public abstract void useEffect();
}
