package cartes.effect;

import cartes.FactoryCard;
/**
 * Classe abstraite utilisant le design pattern decorator pour l'ajout
 * d'effet (multiple ou non) au cartes en possédant.
 * @author E145855N
 *
 */
public abstract class EffectDecorator extends FactoryCard{
	protected FactoryCard fc;
	
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
