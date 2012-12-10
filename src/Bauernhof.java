
/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700)
 * @since December 2012
 *
 */
@Writer("Florian Schuster")
public class Bauernhof {

	private final String name;
	private TraktorList traktoren;

	public Bauernhof(String name) {
		this.name = name;
		this.traktoren = new TraktorList();
	}

	public void addTraktorList(TraktorList traktoren) {
		TraktorIterator it = new TraktorIterator(traktoren);
		Traktor elem = null;
		while(it.hasNext()) {
			elem = it.getNext();
			if(this.traktoren.find(elem) == null) //tractor does NOT already exist in this tractorlist
				this.insert(elem);
		}
	}
	
	public TraktorList getTraktorList() {
		return this.traktoren;
	}

	public void insert(Traktor t) {
		if(this.traktoren.find(t) == null) //tractor does NOT already exist in this tractorlist
			traktoren.append(t);
	}

	public void remove(Traktor t) {
		traktoren.remove(t);
	}

	public String getName() {
		return this.name;
	}

	/*----------------------------------------1-------------------------------------------------*/

	private<T extends Einsatzart> int getAnzEinsatzart(Class<T> trk) {
		int count = 0;
		TraktorIterator it = new TraktorIterator(this.traktoren);
		while(it.hasNext()) {
			Traktor t = it.getNext();
			if(trk.isInstance(t.getEinsatzart())) {
				count++;
			}
		}
		return count;
	}

	private<T extends Einsatzart> int getBetriebstundenEinsatzart(Class<T> trk) {
		int sum = 0;

		TraktorIterator it = new TraktorIterator(this.traktoren);
		while(it.hasNext()) {
			Traktor t = it.getNext();
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

	/*----------------------------------------2-------------------------------------------------*/

	private <T extends Traktor> int getBetriebstundenAntrieb(Class<T> trk) {
		int sum_gas = 0;
		TraktorIterator it = new TraktorIterator(this.traktoren);

		while(it.hasNext()) {
			Traktor t = it.getNext();
			if(trk.isInstance(t)) {
				sum_gas += t.getBetriebsstunden();
			}
		}
		return sum_gas;
	}

	private <T extends Traktor> int getAnzAntrieb(Class<T> trk) {
		int count_diesel = 0;
		TraktorIterator it = new TraktorIterator(this.traktoren);

		while(it.hasNext()) {
			Traktor t = it.getNext();
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

	/*----------------------------------------3-------------------------------------------------*/

	private <T extends Einsatzart> double getDieselMenge(Class<T> trk) {
		double diesel = 0;
		TraktorIterator it = new TraktorIterator(this.traktoren);

		while(it.hasNext()) {
			Traktor t = it.getNext();
			if(t instanceof Dieseltraktor) {
				if (trk.isInstance(t.getEinsatzart())) {
					diesel += ((Dieseltraktor) t).getLiter();
				}
			}
		}
		return diesel;
	}

	private <T extends Einsatzart> int getAnzDieselEinsatzart(Class<T> trk) {
		int anz = 0;
		TraktorIterator it = new TraktorIterator(this.traktoren);

		while(it.hasNext()) {
			Traktor t = it.getNext();
			if(t instanceof Dieseltraktor) {
				if (trk.isInstance(t.getEinsatzart())) {
					anz++;
				}
			}
		}
		return anz;
	}

	public double avgDieselVerbrauchDrill() {
		double avg = 0;
		avg = getDieselMenge(Drillmaschine.class)/getAnzDieselEinsatzart(Drillmaschine.class);
		System.out.println("Durchschnitt Dieselverbrauch Drillmaschinen: " +avg);
		return avg;
	}

	public double avgDieselVerbrauchDuenger() {
		double avg = 0;
		avg = getDieselMenge(Duengerstreuer.class)/getAnzDieselEinsatzart(Duengerstreuer.class);
		System.out.println("Durchschnitt Dieselverbrauch Duengerstreuer: " +avg);
		return avg;
	}

	public double avgDieselVerbrauch() {
		double avg = 0;
		avg = (getDieselMenge(Drillmaschine.class)+getDieselMenge(Duengerstreuer.class))/
				(getAnzDieselEinsatzart(Drillmaschine.class)+getAnzDieselEinsatzart(Duengerstreuer.class));

		avgDieselVerbrauchDrill();
		avgDieselVerbrauchDuenger();
		System.out.println("Durchschnitt Dieselverbrauch gesamt:                " +avg);

		return avg;
	}

	/*----------------------------------------4-------------------------------------------------*/

	private <T extends Einsatzart> float getGasMenge(Class<T> trk) {
		float gas = 0;
		TraktorIterator it = new TraktorIterator(this.traktoren);

		while(it.hasNext()) {
			Traktor t = it.getNext();
			if(t instanceof Biogastraktor) {
				if (trk.isInstance(t.getEinsatzart())) {
					gas += ((Biogastraktor) t).getGas();
				}
			}
		}
		return gas;
	}

	private <T extends Einsatzart> int getAnzGasEinsatzart(Class<T> trk) {
		int anz = 0;
		TraktorIterator it = new TraktorIterator(this.traktoren);

		while(it.hasNext()) {
			Traktor t = it.getNext();
			if(t instanceof Biogastraktor) {
				if (trk.isInstance(t.getEinsatzart())) {
					anz++;
				}
			}
		}
		return anz;
	}

	public float avgGasVerbrauchDrill() {
		float avg = 0;
		avg = getGasMenge(Drillmaschine.class)/getAnzGasEinsatzart(Drillmaschine.class);
		System.out.println("Durchschnitt Biogasverbrauch Drillmaschinen: " +avg);
		return avg;
	}

	public float avgGasVerbrauchDuenger() {
		float avg = 0;
		avg = getGasMenge(Duengerstreuer.class)/getAnzGasEinsatzart(Duengerstreuer.class);
		System.out.println("Durchschnitt Biogasverbrauch Duengerstreuer: " +avg);
		return avg;
	}

	public float avgGasVerbrauch() {
		float avg = 0;
		avg = (getGasMenge(Drillmaschine.class)+getGasMenge(Duengerstreuer.class))/
				(getAnzGasEinsatzart(Drillmaschine.class)+getAnzGasEinsatzart(Duengerstreuer.class));

		avgGasVerbrauchDrill();
		avgGasVerbrauchDuenger();
		System.out.println("Durchschnitt Biogasverbrauch gesamt:                " +avg);

		return avg;
	}

	/*----------------------------------------5-------------------------------------------------*/

	private <T extends Traktor> int getMinDrill(Class<T> trk) {
		int min = 0;
		TraktorIterator it = new TraktorIterator(this.traktoren);

		while(it.hasNext()) {
			Traktor t = it.getNext();
			if(trk.isInstance(t)) {
				if (t.getEinsatzart() instanceof Drillmaschine) {
					if (min == 0) {
						min = ((Drillmaschine) t.getEinsatzart()).getAnzSaeschare();
					}
					if (((Drillmaschine) t.getEinsatzart()).getAnzSaeschare() < min) {
						min = ((Drillmaschine) t.getEinsatzart()).getAnzSaeschare();
					}
				}
			}
		}
		return min;
	}

	private <T extends Traktor> int getMaxDrill(Class<T> trk) {
		int max = 0;
		TraktorIterator it = new TraktorIterator(this.traktoren);

		while(it.hasNext()) {
			Traktor t = it.getNext();
			if(trk.isInstance(t)) {
				if (t.getEinsatzart() instanceof Drillmaschine) {
					if (((Drillmaschine) t.getEinsatzart()).getAnzSaeschare() > max) {
						max = ((Drillmaschine) t.getEinsatzart()).getAnzSaeschare();
					}
				}
			}
		}
		return max;
	}

	public void AnzSaescharenDiesel() {
		System.out.println("Min Anzahl Saescharen Diesel: " +getMinDrill(Dieseltraktor.class) +
				"\nMax Anzahl Saescharen Diesel" + getMaxDrill(Dieseltraktor.class));
	}

	public void AnzSaescharenBiogas() {
		System.out.println("Min Anzahl Saescharen Biogas: " +getMinDrill(Biogastraktor.class) +
				"\nMax Anzahl Saescharen Biogas" + getMaxDrill(Biogastraktor.class));
	}

	public void AnzSaescharenGesamt() {
		int max = getMaxDrill(Biogastraktor.class) + getMaxDrill(Dieseltraktor.class);
		int min = getMinDrill(Biogastraktor.class) + getMinDrill(Dieseltraktor.class);

		System.out.println("Min Anzahl Saescharen: " + min +
				"\nMax Anzahl Saescharen" + max);
	}

	/*----------------------------------------6-------------------------------------------------*/

	private <T extends Traktor> float getKapazitaetDuenger(Class<T> trk) {
		float kapa = 0;
		TraktorIterator it = new TraktorIterator(this.traktoren);

		while(it.hasNext()) {
			Traktor t = it.getNext();
			if(trk.isInstance(t)) {
				if (t.getEinsatzart() instanceof Duengerstreuer) {
					kapa += ((Duengerstreuer) t.getEinsatzart()).getKapazitaet();
				}
			}
		}
		return kapa;
	}

	public float avgDuengerKapazitaetDiesel() {
		float avg = 0;
		avg = getKapazitaetDuenger(Dieseltraktor.class)/getAnzDieselEinsatzart(Duengerstreuer.class);
		System.out.println("Durchschnitt Fassungskapazitaet Duengerstreuer mit Diesel: " +avg);
		return avg;
	}

	public float avgDuengerKapazitaetGas() {
		float avg = 0;
		avg = getKapazitaetDuenger(Biogastraktor.class)/getAnzGasEinsatzart(Duengerstreuer.class);
		System.out.println("Durchschnitt Fassungskapazitaet Duengerstreuer mit Biogas: " +avg);
		return avg;
	}

	public float avgDuengerKapazitaet() {
		float avg = 0;
		avg = (getKapazitaetDuenger(Dieseltraktor.class)+getKapazitaetDuenger(Biogastraktor.class))/
				(getAnzDieselEinsatzart(Duengerstreuer.class)+getAnzGasEinsatzart(Duengerstreuer.class));

		avgDuengerKapazitaetDiesel();
		avgDuengerKapazitaetGas();
		System.out.println("Durchschnitt Fassungskapazitaet Duengerstreuer gesamt:      " +avg);

		return avg;
	}
}
