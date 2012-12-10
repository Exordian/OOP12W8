
/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700)
 * @since December 2012
 *
 */
@Writer("Florian Schuster")
public class Drillmaschine implements Einsatzart {
	
	private int anzSaeschare;
	
	public Drillmaschine(int anzSaeschare) {
		this.anzSaeschare = anzSaeschare;
	}
	
	public int getAnzSaeschare() {
		return this.anzSaeschare;
	}

}
