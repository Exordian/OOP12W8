
public class Biogastraktor extends Traktor {
	
	private float gas;
	
	public Biogastraktor(int id, float gas) {
		super(id);
		this.gas = gas;
	}

	public float getGas() {
		return this.gas;
	}
	public void setGas(float gas) {
		this.gas = gas;
	}

}
