package heros;

import heroPower.Power;

public class HerosPaladin implements Heros {

	private int life;
	
	public HerosPaladin(){
		this.life = 30;
	}
	
	@Override
	public int getLife() {return life;}

	@Override
	public void setLife(int life) {this.life = life;}

	@Override
	public String typeHero() {return "Paladin";}

	@Override
	public Power getPower() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String toString(){return typeHero();}

}
