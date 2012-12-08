
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
	
	public void insert (Traktor t) {
		traktoren.append(t);
	}
	
	public void remove(Traktor t) {
		traktoren.remove(t);
	}
	
	public String getName() {
		return this.name;
	}
	
	/*
	public double avgBetriebsstunden() {
		int avg_diesel = avgBetriebsstundenDieselTraktor();
		int avg_biogas = avgBetriebsstundenBiogasTraktor();
		System.out.println("Durchschnitt Betriebsstunden Dieseltraktoren: " +avg_diesel);
		System.out.println("Durchschnitt Betriebsstunden Biogastraktoren: " +avg_biogas);
		System.out.println("Durchschnitt Traktoren gesamt:                " +(avg_diesel+avg_biogas));
		return avg_diesel + avg_biogas;
	}*/
	
	public double avgBetriebsstunden() {
		double avg = 0,
			   avg_diesel = 0,
			   avg_biogas = 0;
		int sum_diesel = 0,
			sum_biogas = 0;
		int count_diesel = 0,
			count_biogas = 0;
		ObjectIterator it = new ObjectIterator(this.traktoren);
		while(it.hasNext()) {
			Traktor t = (Traktor)it.getNext();
			if(t instanceof Dieseltraktor) { //Dieseltraktoren
				sum_diesel += ((Dieseltraktor) t).getBetriebsstunden();
				count_diesel++;
			}
			else if(t instanceof Biogastraktor) { //Biogastraktoren
				sum_biogas += ((Biogastraktor) t).getBetriebsstunden();
				count_biogas++;
			}
		}
		avg_diesel = sum_diesel/count_diesel;
		avg_biogas = sum_biogas/count_biogas;
		avg = (sum_diesel+sum_biogas)/(count_diesel+count_biogas);
		
		System.out.println("Durchschnitt Betriebsstunden Dieseltraktoren: " +avg_diesel);
		System.out.println("Durchschnitt Betriebsstunden Biogastraktoren: " +avg_biogas);
		System.out.println("Durchschnitt Traktoren gesamt:                " +avg);
		
		return avg;
	}

}
