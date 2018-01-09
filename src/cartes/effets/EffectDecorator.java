package cartes.effets;

import cartes.FactoryCard;

public abstract class EffectDecorator {
	protected FactoryCard fc;
	public abstract String getName();
	public abstract String getEffect();
	public abstract void useEffect();
	public abstract String toString();
}
