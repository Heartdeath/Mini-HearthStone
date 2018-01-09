package cartes;

public abstract class FactoryCard{
	public abstract int getAttaque();
	public abstract void setAttaque(int atk);
	public abstract int getLife();
	public abstract void setLife(int hp);
	public abstract int getMana();
	public abstract String getEffect();
	public abstract void setCanAttaque(boolean b);
	public abstract boolean getCanAttaque();
	public abstract void setCanBeAttaque(boolean b);
	public abstract boolean getCanBeAttaque();
}
