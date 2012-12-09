
/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700)
 * @since December 2012
 *
 */
public class Test {
	
	public static void main(String[] args) {
		/*
		LinkedList list = new LinkedList();
		list.append(new Integer(1));
		list.append(new Integer(2));
		list.append(new Integer(3));
		
		list.prepend(new Integer(4));
		list.prepend(new Integer(5));
		
		System.out.println(list);
		
		list.remove(new Integer(3));
		System.out.println(list);
		
		list.remove(new Integer(5));
		System.out.println(list);
		
		list.remove(new Integer(1));
		System.out.println(list);
		*/
		
		Bauernhof bauernhof = new Bauernhof("Mein Bauernhof");
		
		LinkedList list = new LinkedList();
		Dieseltraktor d1 = new Dieseltraktor();
		Dieseltraktor d2 = new Dieseltraktor();
		Dieseltraktor d3 = new Dieseltraktor();
		Dieseltraktor d4 = new Dieseltraktor();
		Biogastraktor b1 = new Biogastraktor();
		Biogastraktor b2 = new Biogastraktor();
		Biogastraktor b3 = new Biogastraktor();
		
		d1.setBetriebsstunden(3);
		d2.setBetriebsstunden(100);
		d3.setBetriebsstunden(29);
		d4.setBetriebsstunden(77);
		b1.setBetriebsstunden(10);
		b2.setBetriebsstunden(98);
		b3.setBetriebsstunden(5);
		
		d1.setEinsatzart(new Drillmaschine(100));
		b1.setEinsatzart(new Düngerstreuer(100));
		
		list.append(d1);
		list.append(d2);
		list.append(d3);
		list.append(d4);
		list.append(b1);
		list.append(b2);
		list.append(b3);
		
		System.out.println(list);
		System.out.println(list.find(b1).getData()); //find b1
		
		bauernhof.addTraktorenliste(list);
		System.out.println();
		bauernhof.avgBetriebsstundenArt(); //Durchschnitt Betriebsstunden
		System.out.println();
		bauernhof.avgBetriebsstundenEinsatz();
	}
	
}