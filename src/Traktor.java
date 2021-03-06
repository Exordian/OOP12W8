
/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700)
 * @since December 2012
 *
 */
@Writer("Lena Lenz")
public abstract class Traktor {
	
	private static int IDnummer = 1;
	protected final int id; //identifies tractor
	private int betriebsstunden;
	protected Einsatzart einsatzart;
	
	public Traktor(Einsatzart e) {
		this.id = Traktor.IDnummer++;
		einsatzart = e;
		betriebsstunden = 0;
	}
	
	public int getID() {
		return this.id;
	}
	
	public void setBetriebsstunden(int betriebsstunden) {
		this.betriebsstunden = betriebsstunden;
	}
	public int getBetriebsstunden() {
		return this.betriebsstunden;
	}
	
	public void setEinsatzart(Einsatzart einsatzart) {
		this.einsatzart = einsatzart;
	}
	public Einsatzart getEinsatzart() {
		return this.einsatzart;
	}
	
}
