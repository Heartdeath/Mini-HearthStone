package cartes.effets;

public class EffectCharge extends EffectDecorator {
	private String name;
	private String effect;
	
	public EffectCharge() {
		this.name = "Charge";
		this.effect = "Attaque directement";
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
	public void useEffect() { //Instaurer le dp d etat de tel sorte que l etat passe directe a l etat d attaque
		// TODO Auto-generated method stub
	}
	
	public String toString() {
		return "Cette carte possede un effet de "+this.getName()+".\n"+
				this.effect;
	}
}