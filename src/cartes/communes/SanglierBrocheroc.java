package cartes.communes;

import cartes.FactoryCard;

public class SanglierBrocheroc extends FactoryCard {
	
	private int attaque;
	private int life;
	private int mana;
	private boolean canAttaque;
	private boolean canBeAttaque;

	public SanglierBrocheroc() {
		this.attaque      = 1;
		this.life         = 1;
		this.mana         = 1;
		this.canAttaque   = false;
		this.canBeAttaque = true;
	}

	@Override
	public int getAttaque() {return attaque;}
	
	@Override
	public int getLife() {return life;}
	
	@Override
	public int getMana() {return mana;}

	@Override
	public String getEffect() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAttaque(int atk) {this.attaque = atk;}

	@Override
	public void setLife(int hp) {this.life = hp;}

	@Override
	public void setCanAttaque(boolean b) {this.canAttaque = b;}

	@Override
	public boolean getCanAttaque() {return canAttaque;}

	@Override
	public void setCanBeAttaque(boolean b) {this.canBeAttaque = b;}

	@Override
	public boolean getCanBeAttaque() {return canBeAttaque;}
	
	public String toString(){
		return "Sanglier Brocheroc | "+getAttaque()+" atk | "+getLife()+" hp | " +getMana()+" mana |";
	}
}
