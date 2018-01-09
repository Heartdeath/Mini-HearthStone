package cartes.effets;

public class EffectProvocation extends EffectDecorator {
	private String name;
	private String effect;
	
	public EffectProvocation() {
		this.name = "Provocation";
		this.effect = "Cible prioritaire";
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
	public void useEffect() {
		// TODO Auto-generated method stub
		
	}
	
	public String toString() {
		return "Cette carte possede un effet de "+this.getName()+".\n"+
				this.effect;
	}
}
