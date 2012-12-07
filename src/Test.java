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
		
		LinkedList list2 = new LinkedList();
		list2.append(new Traktor(1));
		list2.append(new Traktor(2));
		list2.append(new Traktor(3));
		System.out.println(list2);
		
		System.out.println(((Traktor)list2.find(3).getData()).getName());
		
	}
	
}