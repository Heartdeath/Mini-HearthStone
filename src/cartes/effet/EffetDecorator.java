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
	public abstract String getNom();
	
	/**
	 * @return l'effet
	 */
	public abstract String getEffet();
	
	/**
	 * Utilise l'effet
	 */
	public abstract void useEffet();
}
