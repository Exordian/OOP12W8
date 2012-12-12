
/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700)
 * @since December 2012
 *
 */
@Writer("Florian Schuster")
public class Bauernhof {

	private final String name; //identifies farm
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
		//tractorlist has been added(only tractors which did not already exist in tractorlist)
	}
	
	public TraktorList getTraktorList() {
		return this.traktoren;
	}

	public void insert(Traktor t) {
		if(this.traktoren.find(t) == null) //tractor does NOT already exist in this tractorlist
			traktoren.append(t);
		//tractor has been inserted(if he did not already exist in tractorlist)
	}

	public void remove(Traktor t) {
		traktoren.remove(t);
		//tractor has been removed
	}

	public String getName() {
		return this.name;
		//returns name of farm(which identifies each farm)
	}

	/*----------------------------------------1-------------------------------------------------*/

	private int getAnzEinsatzart(Class trk) {
		//trk has to be an instance of Einsatzart
		int count = 0;
		TraktorIterator it = new TraktorIterator(this.traktoren);
		while(it.hasNext()) {
			Traktor t = it.getNext();
			if(trk.isInstance(t.getEinsatzart())) {
				count++;
			}
		}
		return count;
		//returns number of tractors with either drill machine or fertilizer
	}

	private int getBetriebstundenEinsatzart(Class trk) {
		//trk has to be an instance of Einsatzart
		int sum = 0;

		TraktorIterator it = new TraktorIterator(this.traktoren);
		while(it.hasNext()) {
			Traktor t = it.getNext();
			if(trk.isInstance(t.getEinsatzart())) {
				sum += t.getBetriebsstunden();
			}
		}
		return sum;
		//returns number of operating hours of tractors with either drill machine or fertilizer
	}

	public String avgBetriebsstundenDuenger() throws DivisionByNullException {
		double avg_duengen = 0;
		double nenner = getAnzEinsatzart(Duengerstreuer.class);
		if(nenner == 0) {
			throw new DivisionByNullException();
		}
		avg_duengen = getBetriebstundenEinsatzart(Duengerstreuer.class)/nenner;
		return "Durchschnitt Betriebsstunden Duengerstreuer: " +avg_duengen;
		//returns average of operating hours of tractors with fertilizer
	}

	public String avgBetriebsstundenDrill() throws DivisionByNullException {
		double avg_saen = 0;
		double nenner = getAnzEinsatzart(Drillmaschine.class);
		if(nenner == 0) {
			throw new DivisionByNullException();
		}
		avg_saen = getBetriebstundenEinsatzart(Drillmaschine.class)/nenner;
		return "Durchschnitt Betriebsstunden Drillmaschinen: " +avg_saen;
		//returns average of operating hours of tractors with drill machine
	}

	public String avgBetriebsstundenEinsatz() throws DivisionByNullException {
		double avg = 0;
		double nenner = (getAnzEinsatzart(Duengerstreuer.class)+getAnzEinsatzart(Drillmaschine.class));
		if(nenner == 0) {
			throw new DivisionByNullException();
		}
		avg = (getBetriebstundenEinsatzart(Duengerstreuer.class)+getBetriebstundenEinsatzart(Drillmaschine.class))
				/nenner;
		String tmp = "";
		tmp += avgBetriebsstundenDuenger() + "\n";
		tmp += avgBetriebsstundenDrill() + "\n";
		return tmp + "Durchschnitt Traktoren gesamt: " +avg;
		//returns average of operating hours of tractors with fertilizer/drill machine
	}

	/*----------------------------------------2-------------------------------------------------*/

	private int getBetriebstundenAntrieb(Class trk) {
		//trk has to be an instance of Traktor
		int sum_gas = 0;
		TraktorIterator it = new TraktorIterator(this.traktoren);

		while(it.hasNext()) {
			Traktor t = it.getNext();
			if(trk.isInstance(t)) {
				sum_gas += t.getBetriebsstunden();
			}
		}
		return sum_gas;
		//returns number of operating hours of tractors with motor of either diesel or biogas
	}

	private int getAnzAntrieb(Class trk) {
		//trk has to be an instance of Traktor
		int count_diesel = 0;
		TraktorIterator it = new TraktorIterator(this.traktoren);

		while(it.hasNext()) {
			Traktor t = it.getNext();
			if(trk.isInstance(t)) {
				count_diesel++;
			}
		}
		return count_diesel;
		//returns number of tractors with motor of either diesel or biogas
	}

	public String avgBetriebsstundenDiesel() throws DivisionByNullException {
		double avg_diesel = 0;
		double nenner = getAnzAntrieb(Dieseltraktor.class);
		if(nenner == 0) {
			throw new DivisionByNullException();
		}
		avg_diesel = getBetriebstundenAntrieb(Dieseltraktor.class)/nenner;
		return "Durchschnitt Betriebsstunden Dieseltraktoren: " +avg_diesel;
		//returns average of operating hours of diesel tractors
	}	

	public String avgBetriebsstundenGas() throws DivisionByNullException {
		double avg_biogas = 0;
		double nenner = getAnzAntrieb(Biogastraktor.class);
		if(nenner == 0) {
			throw new DivisionByNullException();
		}
		avg_biogas = getBetriebstundenAntrieb(Biogastraktor.class)/nenner;
		 return "Durchschnitt Betriebsstunden Biogastraktoren: " +avg_biogas;
		//returns average of operating hours of biogas tractors
	}

	public String avgBetriebsstundenArt() throws DivisionByNullException {
		double avg = 0;
		double nenner = (getAnzAntrieb(Biogastraktor.class)+getAnzAntrieb(Biogastraktor.class));
		if(nenner == 0) {
			throw new DivisionByNullException();
		}
		avg = (getBetriebstundenAntrieb(Dieseltraktor.class)+getBetriebstundenAntrieb(Biogastraktor.class))/
				nenner;
		String tmp = "";
		tmp += avgBetriebsstundenDiesel() + "\n";
		tmp += avgBetriebsstundenGas() + "\n";
		return tmp + "Durchschnitt Traktoren gesamt: " +avg;
		//returns average of operating hours of biogas/diesel tractors
	}

	/*----------------------------------------3-------------------------------------------------*/

	private double getDieselMenge(Class trk) {
		//trk has to be an instance of Einsatzart
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
		//returns amount of used diesel
	}

	private int getAnzDieselEinsatzart(Class trk) {
		//trk has to be an instance of Einsatzart
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
		//returns number of dieseltractors
	}

	public String avgDieselVerbrauchDrill() throws DivisionByNullException {
		double avg = 0;
		double nenner = getAnzDieselEinsatzart(Drillmaschine.class);
		if(nenner == 0) {
			throw new DivisionByNullException();
		}
		avg = getDieselMenge(Drillmaschine.class)/nenner;
		return "Durchschnitt Dieselverbrauch Drillmaschinen: " +avg;
		//returns average diesel consumption of tractors with drill machine
	}

	public String avgDieselVerbrauchDuenger() throws DivisionByNullException {
		double avg = 0;
		double nenner = getAnzDieselEinsatzart(Duengerstreuer.class);
		if(nenner == 0) {
			throw new DivisionByNullException();
		}
		avg = getDieselMenge(Duengerstreuer.class)/nenner;
		return "Durchschnitt Dieselverbrauch Duengerstreuer: " +avg;
		//returns average diesel consumption of tractors with fertilizer
	}

	public String avgDieselVerbrauch() throws DivisionByNullException {
		double avg = 0;
		double nenner = (getAnzDieselEinsatzart(Drillmaschine.class)+getAnzDieselEinsatzart(Duengerstreuer.class));
		if(nenner == 0) {
			throw new DivisionByNullException();
		}
		avg = (getDieselMenge(Drillmaschine.class)+getDieselMenge(Duengerstreuer.class))/
				nenner;
		String tmp = "";
		tmp += avgDieselVerbrauchDrill() + "\n";
		tmp += avgDieselVerbrauchDuenger() + "\n";
		return tmp + "Durchschnitt Dieselverbrauch gesamt: " +avg;
		//returns average diesel consumption
	}

	/*----------------------------------------4-------------------------------------------------*/

	private float getGasMenge(Class trk) {
		//trk has to be an instance of Einsatzart
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
		//returns amount of used gas
	}

	private int getAnzGasEinsatzart(Class trk) {
		//trk has to be an instance of Einsatzart
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
		//returns number of biogastractors
	}

	public String avgGasVerbrauchDrill() {
		float avg = 0;
		avg = getGasMenge(Drillmaschine.class)/getAnzGasEinsatzart(Drillmaschine.class);
		return "Durchschnitt Biogasverbrauch Drillmaschinen: " +avg;
		//returns average gas consumption of tractors with drill machine
	}

	public String avgGasVerbrauchDuenger() throws DivisionByNullException {
		float avg = 0;
		float nenner = getAnzGasEinsatzart(Duengerstreuer.class);
		if(nenner == 0) {
			throw new DivisionByNullException();
		}
		avg = getGasMenge(Duengerstreuer.class)/nenner;
		return "Durchschnitt Biogasverbrauch Duengerstreuer: " +avg;
		//returns average gas consumption of tractors with fertilizer
	}

	public String avgGasVerbrauch() throws DivisionByNullException {
		float avg = 0;
		float nenner = (getAnzGasEinsatzart(Drillmaschine.class)+getAnzGasEinsatzart(Duengerstreuer.class));
		if(nenner == 0) {
			throw new DivisionByNullException();
		}
		avg = (getGasMenge(Drillmaschine.class)+getGasMenge(Duengerstreuer.class))/
				nenner;
		
		String tmp = "";
		tmp += avgGasVerbrauchDrill() + "\n";
		tmp += avgGasVerbrauchDuenger() + "\n";
		return tmp + "Durchschnitt Biogasverbrauch gesamt: " +avg;

		//returns average gas consumption
	}

	/*----------------------------------------5-------------------------------------------------*/

	private int getMinDrill(Class trk) {
		//trk has to be an instance of Traktor
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
		//returns min number of sowing coulters of tractors with drill machines
	}

	private int getMaxDrill(Class trk) {
		//trk has to be an instance of Traktor
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
		//returns max number of sowing coulters of tractors with drill machines
	}

	public String AnzSaescharenDiesel() {
		return "Min Anzahl Saescharen Diesel: " +getMinDrill(Dieseltraktor.class) +
				"\nMax Anzahl Saescharen Diesel: " + getMaxDrill(Dieseltraktor.class);
		//prints number of sowing coulters of diesel tractors
	}

	public String AnzSaescharenBiogas() {
		return "Min Anzahl Saescharen Biogas: " +getMinDrill(Biogastraktor.class) +
				"\nMax Anzahl Saescharen Biogas: " + getMaxDrill(Biogastraktor.class);
		//prints number of sowing coulters of biogas tractors
	}

	public String AnzSaescharenGesamt() {
		int max = getMaxDrill(Biogastraktor.class) + getMaxDrill(Dieseltraktor.class);
		int min = getMinDrill(Biogastraktor.class) + getMinDrill(Dieseltraktor.class);

		return "Min Anzahl Saescharen: " + min +
				"\nMax Anzahl Saescharen: " + max;
		//prints number of sowing coulters
	}

	/*----------------------------------------6-------------------------------------------------*/

	private float getKapazitaetDuenger(Class trk) {
		//trk has to be an instance of Traktor
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
		//returns capacity of fertilizer
	}

	public String avgDuengerKapazitaetDiesel() throws DivisionByNullException {
		float avg = 0;
		float nenner = getAnzDieselEinsatzart(Duengerstreuer.class);
		if(nenner == 0) {
			throw new DivisionByNullException();
		}
		avg = getKapazitaetDuenger(Dieseltraktor.class)/nenner;
		return "Durchschnitt Fassungskapazitaet Duengerstreuer mit Diesel: " +avg;
		//returns average of capacity of fertilizer of diesel tractor
	}

	public String avgDuengerKapazitaetGas() throws DivisionByNullException {
		float avg = 0;
		float nenner = getAnzGasEinsatzart(Duengerstreuer.class);
		if(nenner == 0) {
			throw new DivisionByNullException();
		}
		avg = getKapazitaetDuenger(Biogastraktor.class)/nenner;
		return "Durchschnitt Fassungskapazitaet Duengerstreuer mit Biogas: " +avg;
		//returns average of capacity of fertilizer of biogas tractor
	}

	public String avgDuengerKapazitaet() throws DivisionByNullException {
		float avg = 0;
		float nenner = (getAnzDieselEinsatzart(Duengerstreuer.class)+getAnzGasEinsatzart(Duengerstreuer.class));
		if(nenner == 0) {
			throw new DivisionByNullException();
		}
		avg = (getKapazitaetDuenger(Dieseltraktor.class)+getKapazitaetDuenger(Biogastraktor.class))/
				nenner;
		
		String tmp = "";
		tmp += avgDuengerKapazitaetDiesel() + "\n";
		tmp += avgDuengerKapazitaetGas() + "\n";
		return tmp + "Durchschnitt Fassungskapazitaet Duengerstreuer gesamt: " +avg;
		//returns average of capacity of fertilizer
	}
}
