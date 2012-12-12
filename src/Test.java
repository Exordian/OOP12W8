import java.lang.reflect.Method;

/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700)
 * @since December 2012
 *
 */
/**
 * Info: Bauernhof gibt keine Werte zurueck, da die Ausgabe nur in der Testklasse benoetigt wird, und somit zur
 * 		 vereinfachung direkt String ausgaben genommen wurden
 * 		
 * 		 Bauernhof:
 * 		 Weiters wird um nochmal code wiederverwendung zu verzichten auf den generischen Typ Class zurueckgegriffen
 * 		 Da dies ein Teil von Reflection ist, meinen wir das dieser erlaubt ist, aehnlich wie getMethods - sollte eine
 * 		 Erklaerung dafuer notwendig sein
 */
@Writer("Jakob Englisch")
public class Test {
	public static void main(String[] args) {

		// Bauernhof 1, test bauernhof and traktors/traktor list, test list implementation due to statistics
		Bauernhof bauernhof = new Bauernhof("Mein Bauernhof");

		TraktorList list = new TraktorList();
		Dieseltraktor d1 = new Dieseltraktor(new Drillmaschine(100));
		Dieseltraktor d2 = new Dieseltraktor(new Duengerstreuer(100));
		Dieseltraktor d3 = new Dieseltraktor(new Drillmaschine(100));
		Dieseltraktor d4 = new Dieseltraktor(new Duengerstreuer(100));
		Biogastraktor b1 = new Biogastraktor(new Duengerstreuer(100));
		Biogastraktor b2 = new Biogastraktor(new Drillmaschine(100));
		Biogastraktor b3 = new Biogastraktor(new Duengerstreuer(100));

		d1.setBetriebsstunden(3);
		d2.setBetriebsstunden(100);
		d3.setBetriebsstunden(29);
		d4.setBetriebsstunden(77);
		b1.setBetriebsstunden(10);
		b2.setBetriebsstunden(98);
		b3.setBetriebsstunden(5);

		list.append(d1);
		list.append(d2);
		list.append(d3);
		list.append(d4);
		list.append(b1);
		list.append(b2);
		list.append(b3);
		
		System.out.println(list);
		System.out.println(list.find(b1).getData()); //find b1

		bauernhof.addTraktorList(list);
		
		// Test statistics
		try {
	        System.out.println(bauernhof.avgBetriebsstundenDuenger());
	        System.out.println(bauernhof.avgBetriebsstundenDrill());
	        System.out.println(bauernhof.avgBetriebsstundenEinsatz());
	        System.out.println(bauernhof.avgBetriebsstundenDiesel());
	        System.out.println(bauernhof.avgBetriebsstundenGas());
	        System.out.println(bauernhof.avgBetriebsstundenArt());
	        System.out.println(bauernhof.avgDieselVerbrauchDrill());
	        System.out.println(bauernhof.avgDieselVerbrauchDuenger());
	        System.out.println(bauernhof.avgDieselVerbrauch());
	        System.out.println(bauernhof.avgGasVerbrauchDrill());
	        System.out.println(bauernhof.avgGasVerbrauchDuenger());
	        System.out.println(bauernhof.avgGasVerbrauch());
	        System.out.println(bauernhof.AnzSaescharenDiesel());
	        System.out.println(bauernhof.AnzSaescharenBiogas());
	        System.out.println(bauernhof.AnzSaescharenGesamt());
	        System.out.println(bauernhof.avgDuengerKapazitaetDiesel());
	        System.out.println(bauernhof.avgDuengerKapazitaetGas());
	        System.out.println(bauernhof.avgDuengerKapazitaet());
		} catch (DivisionByNullException e) {
			System.out.println("division by zero catched");
		}

		// Bauernhof 2
		Bauernhof bauernhof2 = new Bauernhof("Mein 2. Bauernhof");

		TraktorList list2 = new TraktorList();
		Dieseltraktor d5 = new Dieseltraktor(new Drillmaschine(100));
		Dieseltraktor d6 = new Dieseltraktor(new Duengerstreuer(100));
		Dieseltraktor d7 = new Dieseltraktor(new Duengerstreuer(100));
		Dieseltraktor d8 = new Dieseltraktor(new Drillmaschine(100));
		Biogastraktor b4 = new Biogastraktor(new Duengerstreuer(100));
		Biogastraktor b5 = new Biogastraktor(new Duengerstreuer(100));
		Biogastraktor b6 = new Biogastraktor(new Drillmaschine(100));
		Biogastraktor b7 = new Biogastraktor(new Duengerstreuer(100));

		list2.append(d5);
		list2.append(d6);
		list2.append(d7);
		list2.append(d8);
		list2.append(b4);
		list2.append(b5);
		list2.append(b6);
		list2.append(b7);

		System.out.println();

		// BauernhofMap - test Map Implementation
		System.out.println("***BAUERNHOFMAP***");
		System.out.println();
		BauernhofMap b_map = new BauernhofMap();

		b_map.putBauernhof(bauernhof);
		b_map.putTraktorList(bauernhof2, list2);
		
		System.out.println("Bauernhof zu Traktor mit ID "+ d5.getID() +": "+ b_map.getKey(d5).getName());
		System.out.println();
		System.out.println(b_map);
		
		
		// Reflection Test
		System.out.println("\n\nReflection Tests:");
		System.out.print(getClassMethodWriters(Bauernhof.class));
		System.out.print(getClassMethodWriters(BauernhofIterator.class));
		System.out.print(getClassMethodWriters(BauernhofList.class));
		System.out.print(getClassMethodWriters(BauernhofMap.class));
		System.out.print(getClassMethodWriters(Biogastraktor.class));
		System.out.print(getClassMethodWriters(Dieseltraktor.class));
		System.out.print(getClassMethodWriters(DivisionByNullException.class));
		System.out.print(getClassMethodWriters(Drillmaschine.class));
		System.out.print(getClassMethodWriters(Duengerstreuer.class));
		System.out.print(getClassMethodWriters(Einsatzart.class));
		System.out.print(getClassMethodWriters(LinkedList.class));
		System.out.print(getClassMethodWriters(Node.class));
		System.out.print(getClassMethodWriters(ObjectIterator.class));
		System.out.print(getClassMethodWriters(Test.class));
		System.out.print(getClassMethodWriters(Traktor.class));
		System.out.print(getClassMethodWriters(TraktorIterator.class));
		System.out.print(getClassMethodWriters(TraktorList.class));
		System.out.print(getClassMethodWriters(Writer.class));
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Writer("Jakob Englisch")
	public static String getClassMethodWriters(Class c) {
		String tmp = "";
		if(c == null)
			return tmp;
		Writer cw = (Writer) c.getAnnotation(Writer.class);
		tmp += c.getName() + " wurde geschrieben von: " + (cw == null ? "keine Informationen vorhanden" : cw.value()) + "\n";
		for(Method m : c.getMethods()) {
			Writer cm = (Writer) m.getAnnotation(Writer.class);
			if(cm == null)
				continue;
			tmp += c.getName() + ": "+ m.getName() + " wurde geschrieben von: " + cm.value() + "\n";
		}		
		return tmp;
	}
}
