
/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700)
 * @since December 2012
 *
 */
public class Drillmaschine implements Einsatzart {
	
	private int anzSäschare;
	
	public Drillmaschine(int anzSäschare) {
		this.anzSäschare = anzSäschare;
	}
	
	public int getAnzSäschare() {
		return this.anzSäschare;
	}

}
