package heroPower;

import heroPower.Power;

public class PowerPaladin implements Power {
	
	private String name;
	private String effect;
	
	public PowerPaladin() {
		this.name = "Renfort";
		this.effect = "Invoquant un serviteur \"recrue de la Main d argent\" ."; //1/1
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public String getEffect() {
		// TODO Auto-generated method stub
		return this.effect;
	}

	@Override
	public void usePower() {
		// TODO Auto-generated method stub
		System.out.println(toString());
	}
	
	public String toString(){
		return "Utilise sa capacite special : " + this.name + " !"+
				"\n" + this.effect;
	}
}
