
/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700)
 * @since December 2012
 *
 */
@Writer("Lena Lenz")
public class Biogastraktor extends Traktor {
	
	private float gas;
	
	public Biogastraktor(Einsatzart e) {
		super(e);
	}
	
	public Biogastraktor(Einsatzart e, float gas) {
		super(e);
		this.gas = gas;
	}

	public float getGas() {
		return this.gas;
	}
	
	public void setGas(float gas) {
		this.gas = gas;
	}
	
	public String toString() {
		return "Ich bin ein Biogastraktor mit der ID " +this.getID();
	}

}
