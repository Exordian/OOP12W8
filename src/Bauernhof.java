
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

	private <T extends Traktor> int getBetriebstundenAntrieb(Class<T> trk) {
		int sum_gas = 0;
		ObjectIterator it = new ObjectIterator(this.traktoren);

		while(it.hasNext()) {
			Traktor t = (Traktor)it.getNext();
			if(trk.isInstance(t)) {
				sum_gas += t.getBetriebsstunden();
			}
		}
		return sum_gas;
	}

	private <T extends Traktor> int getAnzAntrieb(Class<T> trk) {
		int count_diesel = 0;
		ObjectIterator it = new ObjectIterator(this.traktoren);

		while(it.hasNext()) {
			Traktor t = (Traktor)it.getNext();
			if(trk.isInstance(t)) {
				count_diesel++;
			}
		}
		return count_diesel;
	}

	public double avgBetriebsstundenDiesel() {
		double avg_diesel = 0;
		avg_diesel = getBetriebstundenAntrieb(Dieseltraktor.class)/getAnzAntrieb(Dieseltraktor.class);
		System.out.println("Durchschnitt Betriebsstunden Dieseltraktoren: " +avg_diesel);
		return avg_diesel;
	}	

	public double avgBetriebsstundenGas() {
		double avg_biogas = 0;
		avg_biogas = getBetriebstundenAntrieb(Biogastraktor.class)/getAnzAntrieb(Biogastraktor.class);
		System.out.println("Durchschnitt Betriebsstunden Biogastraktoren: " +avg_biogas);
		return avg_biogas;
	}

	public double avgBetriebsstundenArt() {
		double avg = 0;
		avg = (getBetriebstundenAntrieb(Dieseltraktor.class)+getBetriebstundenAntrieb(Biogastraktor.class))/
				(getAnzAntrieb(Biogastraktor.class)+getAnzAntrieb(Biogastraktor.class));

		avgBetriebsstundenDiesel();
		avgBetriebsstundenGas();
		System.out.println("Durchschnitt Traktoren gesamt:                " +avg);

		return avg;
	}

	private<T extends Traktor> double getAntriebsMenge(Class<T> trk) {
		double menge = 0;
		ObjectIterator it = new ObjectIterator(this.traktoren);

		while(it.hasNext()) {
			Traktor t = (Traktor)it.getNext();
			if(trk.isInstance(t)) {
				menge += ((Dieseltraktor) t).getLiter();
			}
		}
		return menge;
	}

	/*
	public double avgDieselVerbrauchDrill() {

	}

	public double avgDieselVerbrauchDuenger() {

	}

	public double avgDieselVerbrauch() {

	}

	public double avgGasVerbrauchDrill() {

	}

	public double avgGasVerbrauchDuenger() {

	}

	public double avgGasVerbrauch() {

	}
	 */
	private<T extends Einsatzart> int getAnzEinsatzart(Class<T> trk) {
		int count = 0;
		ObjectIterator it = new ObjectIterator(this.traktoren);
		while(it.hasNext()) {
			Traktor t = (Traktor)it.getNext();
			if(trk.isInstance(t.getEinsatzart())) {
				count++;
			}
		}
		return count;
	}

	private<T extends Einsatzart> int getBetriebstundenEinsatzart(Class<T> trk) {
		int sum = 0;

		ObjectIterator it = new ObjectIterator(this.traktoren);
		while(it.hasNext()) {
			Traktor t = (Traktor)it.getNext();
			if(trk.isInstance(t.getEinsatzart())) {
				sum += t.getBetriebsstunden();
			}
		}
		return sum;
	}

	public double avgBetriebsstundenDuenger() {
		double avg_duengen = 0;
		avg_duengen = getBetriebstundenEinsatzart(Duengerstreuer.class)/getAnzEinsatzart(Duengerstreuer.class);
		System.out.println("Durchschnitt Betriebsstunden Duengerstreuer:  " +avg_duengen);
		return avg_duengen;
	}

	public double avgBetriebsstundenDrill() {
		double avg_saen = 0;
		avg_saen = getBetriebstundenEinsatzart(Drillmaschine.class)/getAnzEinsatzart(Drillmaschine.class);
		System.out.println("Durchschnitt Betriebsstunden Drillmaschinen:  " +avg_saen);
		return avg_saen;
	}

	public double avgBetriebsstundenEinsatz() {
		double avg = 0;
		avg = (getBetriebstundenEinsatzart(Duengerstreuer.class)+getBetriebstundenEinsatzart(Drillmaschine.class))
				/(getAnzEinsatzart(Duengerstreuer.class)+getAnzEinsatzart(Drillmaschine.class));

		avgBetriebsstundenDuenger();
		avgBetriebsstundenDrill();
		System.out.println("Durchschnitt Traktoren gesamt:                " +avg);

		return avg;
	}
}
