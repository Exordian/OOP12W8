
/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700)
 * @since December 2012
 *
 */
public class Düngerstreuer implements Einsatzart {
	
	private float kapazität;
	
	public Düngerstreuer(float kapazität) {
		this.kapazität = kapazität;
	}
	
	public float getKapazität() {
		return this.kapazität;
	}

}
