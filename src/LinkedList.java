
/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700)
 * @since December 2012
 *
 */
@Writer("Lena Lenz")
public abstract class LinkedList {
	
	protected Node head;
	protected Node tail;
	protected int size;
	
	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	protected Node getHead() {
		return this.head;
	}
	
	protected void append(Object o) {
		if(tail == null)
			tail = head = new Node(null, null, o);
		else {
			Node n = new Node(null, tail, o);
			tail = n;
			n.getPrevious().setNext(tail);
		}
		size++;
	}
	
	protected void prepend(Object o) {
		if(head == null) //head && tail null
			tail = head = new Node(null, null, o);
		else {
			Node n = new Node(head, null, o);
			head = n;
			n.getNext().setPrevious(head);
		}
		size++;
	}
	
	protected Node find(Object o) {
		Node temp = null;
		for(temp = head; temp != null; temp = temp.getNext()) {
			if(temp.equals(o)) 
				break;
		}
		return temp;
	}
	
	protected Object remove(Object o) {
		Node n = this.find(o);
		Object ret = null;
		
		if(n != null) {
			if(head == n) {
				head = n.getNext();
			}
			if(tail == n) {
				tail = n.getPrevious();
			}
			if(n.getPrevious() != null) { //not last element
				n.getPrevious().setNext(n.getNext());
			}
			if(n.getNext() != null) { //not last element
				n.getNext().setPrevious(n.getPrevious());
			}
			n.setNext(null);
			n.setPrevious(null);
			
			ret = n.getData();
		}
		
		size--;
		return ret;
	}
	
	protected int getSize() {
		return this.size;
	}
	
	public String toString() {
		StringBuffer buf = new StringBuffer();
		for(Node temp = head; temp != null; temp = temp.getNext()) {
			buf.append(temp.getData().toString());
			buf.append('\n');
		}
		return buf.toString();
	}
	
}
