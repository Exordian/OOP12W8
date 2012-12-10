
/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700)
 * @since December 2012
 *
 */
@Writer("Florian Schuster")
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

	/*----------------------------------------1-------------------------------------------------*/

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

	public String avgBetriebsstundenDuenger() {
		double avg_duengen = 0;
		avg_duengen = getBetriebstundenEinsatzart(Duengerstreuer.class)/getAnzEinsatzart(Duengerstreuer.class);
		return "Durchschnitt Betriebsstunden Duengerstreuer:  " +avg_duengen;
	}

	public String avgBetriebsstundenDrill() {
		double avg_saen = 0;
		avg_saen = getBetriebstundenEinsatzart(Drillmaschine.class)/getAnzEinsatzart(Drillmaschine.class);
		return "Durchschnitt Betriebsstunden Drillmaschinen:  " +avg_saen;
	}

	public String avgBetriebsstundenEinsatz() {
		double avg = 0;
		avg = (getBetriebstundenEinsatzart(Duengerstreuer.class)+getBetriebstundenEinsatzart(Drillmaschine.class))
				/(getAnzEinsatzart(Duengerstreuer.class)+getAnzEinsatzart(Drillmaschine.class));
		return "Durchschnitt Traktoren gesamt: " +avg;
	}

	/*----------------------------------------2-------------------------------------------------*/

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

	public String avgBetriebsstundenDiesel() {
		double avg_diesel = 0;
		avg_diesel = getBetriebstundenAntrieb(Dieseltraktor.class)/getAnzAntrieb(Dieseltraktor.class);
		return "Durchschnitt Betriebsstunden Dieseltraktoren: " +avg_diesel;
	}	

	public String avgBetriebsstundenGas() {
		double avg_biogas = 0;
		avg_biogas = getBetriebstundenAntrieb(Biogastraktor.class)/getAnzAntrieb(Biogastraktor.class);
		return "Durchschnitt Betriebsstunden Biogastraktoren: " +avg_biogas;
	}

	public String avgBetriebsstundenArt() {
		double avg = 0;
		avg = (getBetriebstundenAntrieb(Dieseltraktor.class)+getBetriebstundenAntrieb(Biogastraktor.class))/
				(getAnzAntrieb(Biogastraktor.class)+getAnzAntrieb(Biogastraktor.class));
		return "Durchschnitt Traktoren gesamt: " +avg;
	}

	/*----------------------------------------3-------------------------------------------------*/

	private <T extends Einsatzart> double getDieselMenge(Class<T> trk) {
		double diesel = 0;
		ObjectIterator it = new ObjectIterator(this.traktoren);

		while(it.hasNext()) {
			Traktor t = (Traktor)it.getNext();
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
		ObjectIterator it = new ObjectIterator(this.traktoren);

		while(it.hasNext()) {
			Traktor t = (Traktor)it.getNext();
			if(t instanceof Dieseltraktor) {
				if (trk.isInstance(t.getEinsatzart())) {
					anz++;
				}
			}
		}
		return anz;
	}

	public String avgDieselVerbrauchDrill() {
		double avg = 0;
		avg = getDieselMenge(Drillmaschine.class)/getAnzDieselEinsatzart(Drillmaschine.class);
		return "Durchschnitt Dieselverbrauch Drillmaschinen: " +avg;
	}

	public String avgDieselVerbrauchDuenger() {
		double avg = 0;
		avg = getDieselMenge(Duengerstreuer.class)/getAnzDieselEinsatzart(Duengerstreuer.class);
		return "Durchschnitt Dieselverbrauch Duengerstreuer: " +avg;
	}

	public String avgDieselVerbrauch() {
		double avg = 0;
		avg = (getDieselMenge(Drillmaschine.class)+getDieselMenge(Duengerstreuer.class))/
				(getAnzDieselEinsatzart(Drillmaschine.class)+getAnzDieselEinsatzart(Duengerstreuer.class));
		return "Durchschnitt Dieselverbrauch gesamt: " +avg;
	}

	/*----------------------------------------4-------------------------------------------------*/

	private <T extends Einsatzart> float getGasMenge(Class<T> trk) {
		float gas = 0;
		ObjectIterator it = new ObjectIterator(this.traktoren);

		while(it.hasNext()) {
			Traktor t = (Traktor)it.getNext();
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
		ObjectIterator it = new ObjectIterator(this.traktoren);

		while(it.hasNext()) {
			Traktor t = (Traktor)it.getNext();
			if(t instanceof Biogastraktor) {
				if (trk.isInstance(t.getEinsatzart())) {
					anz++;
				}
			}
		}
		return anz;
	}

	public String avgGasVerbrauchDrill() {
		float avg = 0;
		avg = getGasMenge(Drillmaschine.class)/getAnzGasEinsatzart(Drillmaschine.class);
		return "Durchschnitt Biogasverbrauch Drillmaschinen: " +avg;
	}

	public String avgGasVerbrauchDuenger() {
		float avg = 0;
		avg = getGasMenge(Duengerstreuer.class)/getAnzGasEinsatzart(Duengerstreuer.class);
		return "Durchschnitt Biogasverbrauch Duengerstreuer: " +avg;
	}

	public String avgGasVerbrauch() {
		float avg = 0;
		avg = (getGasMenge(Drillmaschine.class)+getGasMenge(Duengerstreuer.class))/
				(getAnzGasEinsatzart(Drillmaschine.class)+getAnzGasEinsatzart(Duengerstreuer.class));
		return "Durchschnitt Biogasverbrauch gesamt: " +avg;
	}

	/*----------------------------------------5-------------------------------------------------*/

	private <T extends Traktor> int getMinDrill(Class<T> trk) {
		int min = 0;
		ObjectIterator it = new ObjectIterator(this.traktoren);

		while(it.hasNext()) {
			Traktor t = (Traktor)it.getNext();
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
		ObjectIterator it = new ObjectIterator(this.traktoren);

		while(it.hasNext()) {
			Traktor t = (Traktor)it.getNext();
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
	
	public String AnzSaescharenDiesel() {
		return "Min Anzahl Saescharen Diesel: " +getMinDrill(Dieseltraktor.class) +
				"\nMax Anzahl Saescharen Diesel" + getMaxDrill(Dieseltraktor.class);
	}

	public String AnzSaescharenBiogas() {
		return "Min Anzahl Saescharen Biogas: " +getMinDrill(Biogastraktor.class) +
				"\nMax Anzahl Saescharen Biogas" + getMaxDrill(Biogastraktor.class);
	}

	public String AnzSaescharenGesamt() {
		int max = getMaxDrill(Biogastraktor.class) + getMaxDrill(Dieseltraktor.class);
		int min = getMinDrill(Biogastraktor.class) + getMinDrill(Dieseltraktor.class);
		
		return "Min Anzahl Saescharen: " + min + "\nMax Anzahl Saescharen" + max;
	}

	/*----------------------------------------6-------------------------------------------------*/

	private <T extends Traktor> float getKapazitaetDuenger(Class<T> trk) {
		float kapa = 0;
		ObjectIterator it = new ObjectIterator(this.traktoren);

		while(it.hasNext()) {
			Traktor t = (Traktor)it.getNext();
			if(trk.isInstance(t)) {
				if (t.getEinsatzart() instanceof Duengerstreuer) {
					kapa += ((Duengerstreuer) t.getEinsatzart()).getKapazitaet();
				}
			}
		}
		return kapa;
	}

	public String avgDuengerKapazitaetDiesel() {
		float avg = 0;
		avg = getKapazitaetDuenger(Dieseltraktor.class)/getAnzDieselEinsatzart(Duengerstreuer.class);
		return "Durchschnitt Fassungskapazitaet Duengerstreuer mit Diesel: " +avg;
	}

	public String avgDuengerKapazitaetGas() {
		float avg = 0;
		avg = getKapazitaetDuenger(Biogastraktor.class)/getAnzGasEinsatzart(Duengerstreuer.class);
		return "Durchschnitt Fassungskapazitaet Duengerstreuer mit Biogas: " +avg;
	}

	public String avgDuengerKapazitaet() {
		float avg = 0;
		avg = (getKapazitaetDuenger(Dieseltraktor.class)+getKapazitaetDuenger(Biogastraktor.class))/
				(getAnzDieselEinsatzart(Duengerstreuer.class)+getAnzGasEinsatzart(Duengerstreuer.class));
		return "Durchschnitt Fassungskapazitaet Duengerstreuer gesamt: " +avg;
	}
}
