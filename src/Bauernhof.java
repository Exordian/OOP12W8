
/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700)
 * @since December 2012
 *
 */
public class Bauernhof {

	private final String name;
	private LinkedList traktoren;

	public Bauernhof(String name) {
		this.name = name;
		this.traktoren = new LinkedList();
	}

	public void addTraktorenliste(LinkedList traktoren) {
		this.traktoren = traktoren;
	}

	public void insert(Traktor t) {
		traktoren.append(t);
	}

	public void remove(Traktor t) {
		traktoren.remove(t);
	}

	public String getName() {
		return this.name;
	}

	private int getBetriebstundenDieselTraktoren() {
		int sum_diesel = 0;
		ObjectIterator it = new ObjectIterator(this.traktoren);

		while(it.hasNext()) {
			Traktor t = (Traktor)it.getNext();
			if(t instanceof Dieseltraktor) {
				sum_diesel += ((Dieseltraktor) t).getBetriebsstunden();
			}
		}
		return sum_diesel;
	}

	private int getAnzDieselTraktoren() {
		int count_diesel = 0;
		ObjectIterator it = new ObjectIterator(this.traktoren);

		while(it.hasNext()) {
			Traktor t = (Traktor)it.getNext();
			if(t instanceof Dieseltraktor) {
				count_diesel++;
			}
		}
		return count_diesel;
	}

	private int getBetriebstundenGasTraktoren() {
		int sum_gas = 0;
		ObjectIterator it = new ObjectIterator(this.traktoren);

		while(it.hasNext()) {
			Traktor t = (Traktor)it.getNext();
			if(t instanceof Biogastraktor) {
				sum_gas += ((Biogastraktor) t).getBetriebsstunden();
			}
		}
		return sum_gas;
	}

	private int getAnzGasTraktoren() {
		int count_gas = 0;
		ObjectIterator it = new ObjectIterator(this.traktoren);

		while(it.hasNext()) {
			Traktor t = (Traktor)it.getNext();
			if(t instanceof Biogastraktor) {
				count_gas++;
			}
		}
		return count_gas;
	}

	public double avgBetriebsstundenDiesel() {
		double avg_diesel = 0;
		avg_diesel = getBetriebstundenDieselTraktoren()/getAnzDieselTraktoren();
		System.out.println("Durchschnitt Betriebsstunden Dieseltraktoren: " +avg_diesel);
		return avg_diesel;
	}	

	public double avgBetriebsstundenGas() {
		double avg_biogas = 0;
		avg_biogas = getBetriebstundenGasTraktoren()/getAnzGasTraktoren();
		System.out.println("Durchschnitt Betriebsstunden Biogastraktoren: " +avg_biogas);
		return avg_biogas;
	}

	public double avgBetriebsstundenArt() {
		double avg = 0;
		avg = (getBetriebstundenDieselTraktoren()+getBetriebstundenGasTraktoren())/(getAnzDieselTraktoren()+getAnzGasTraktoren());

		avgBetriebsstundenDiesel();
		avgBetriebsstundenGas();
		System.out.println("Durchschnitt Traktoren gesamt:                " +avg);

		return avg;
	}

	private int getAnzDŁngerTraktoren() {
		int count_duengen = 0;
		ObjectIterator it = new ObjectIterator(this.traktoren);
		while(it.hasNext()) {
			Traktor t = (Traktor)it.getNext();
			if(t.getEinsatzart() instanceof DŁngerstreuer) { //duengen
				count_duengen++;
			}
		}
		return count_duengen;
	}

	private int getBetriebstundenDŁngerTraktoren() {
		int sum_duengen = 0;

		ObjectIterator it = new ObjectIterator(this.traktoren);
		while(it.hasNext()) {
			Traktor t = (Traktor)it.getNext();
			if(t.getEinsatzart() instanceof DŁngerstreuer) { //duengen
				sum_duengen += t.getBetriebsstunden();
			}
		}
		return sum_duengen;
	}

	private int getAnzDrillTraktoren() {
		int count_saen = 0;
		ObjectIterator it = new ObjectIterator(this.traktoren);
		while(it.hasNext()) {
			Traktor t = (Traktor)it.getNext();
			if(t.getEinsatzart() instanceof Drillmaschine) { //saeen
				count_saen++;
			}
		}
		return count_saen;
	}

	private int getBetriebstundenDrillTraktoren() {
		int sum_saen = 0;

		ObjectIterator it = new ObjectIterator(this.traktoren);
		while(it.hasNext()) {
			Traktor t = (Traktor)it.getNext();
			if(t.getEinsatzart() instanceof Drillmaschine) { //duengen
				sum_saen += t.getBetriebsstunden();
			}
		}
		return sum_saen;
	}

	public double avgBetriebsstundenDŁnger() {
		double avg_duengen = 0;
		avg_duengen = getBetriebstundenDŁngerTraktoren()/getAnzDŁngerTraktoren();
		System.out.println("Durchschnitt Betriebsstunden DŁngerstreuer:  " +avg_duengen);
		return avg_duengen;
	}

	public double avgBetriebsstundenDrill() {
		double avg_saen = 0;
		avg_saen = getBetriebstundenDrillTraktoren()/getAnzDrillTraktoren();
		System.out.println("Durchschnitt Betriebsstunden DŁngerstreuer:  " +avg_saen);
		return avg_saen;
	}

	public double avgBetriebsstundenEinsatz() {//TODO codewiederholung
		double avg = 0;
		avg = (getBetriebstundenDŁngerTraktoren()+getBetriebstundenDrillTraktoren())/(getAnzDŁngerTraktoren()+getAnzDrillTraktoren());

		avgBetriebsstundenDŁnger();
		avgBetriebsstundenDrill();
		System.out.println("Durchschnitt Traktoren gesamt:               " +avg);

		return avg;
	}


}
