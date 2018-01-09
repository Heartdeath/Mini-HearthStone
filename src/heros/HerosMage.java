package heros;

import heroPower.Power;

public class HerosMage implements Heros {

	private int life;
	
	public HerosMage(){
		this.life = 30;
	}
	
	@Override
	public int getLife() {return life;}

	@Override
	public void setLife(int life) {this.life = life;}

	@Override
	public String typeHero() {return "Mage";}

	@Override
	public Power getPower() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String toString(){return typeHero();}
	
}
