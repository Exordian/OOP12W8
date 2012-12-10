
/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700)
 * @since December 2012
 *
 */
public class Duengerstreuer implements Einsatzart {
	
	private float kapazität;
	
	public Duengerstreuer(float kapazitaet) {
		this.kapazität = kapazitaet;
	}
	
	public float getKapazitaet() {
		return this.kapazität;
	}

}
