package heros;

import heroPower.Power;

public interface Heros {
	int getLife();
	void setLife(int life);
	String typeHero();
	Power getPower();
}
