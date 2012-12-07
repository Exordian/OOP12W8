
public class Traktor {
	
	protected final int id;
	private int betriebsstunden;
	protected Einsatzart einsatzart;
	
	public Traktor(int id) {
		this.id = id;
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
	
	public String getName() {
		return "Ich bin ein Traktor mit der ID " +this.id;
	}
	
	public String toString() {
		return (new Integer(this.id)).toString();
	}

}
