
/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700)
 * @since December 2012
 *
 */
public class Duengerstreuer implements Einsatzart {
	
	private float kapazitaet;
	
	public Duengerstreuer(float kapazitaet) {
		this.kapazitaet = kapazitaet;
	}
	
	public float getKapazitaet() {
		return this.kapazitaet;
	}

}
