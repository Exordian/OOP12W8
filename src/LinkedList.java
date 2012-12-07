
public class LinkedList {
	
	private Node head;
	private Node tail;
	private int size;
	
	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	public void append(Object o) {
		if(tail == null)
			tail = head = new Node(null, null, o);
		else {
			Node n = new Node(null, tail, o);
			tail = n;
			n.getPrevious().setNext(tail);
		}
		size++;
	}
	
	public void prepend(Object o) {
		if(head == null) //head && tail null
			tail = head = new Node(null, null, o);
		else {
			Node n = new Node(head, null, o);
			head = n;
			n.getNext().setPrevious(head);
		}
		size++;
	}
	
	public Node find(Object o) {
		Node temp = null;
		for(temp = head; temp != null; temp = temp.getNext()) {
			if(temp.equals(o)) 
				break;
		}
		return temp;
	}
	
	public Object remove(Object o) {
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
	
	public int getSize() {
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
	
	
	public class Node {
		
		private Node next;
		private Node previous;
		private Object data;
		
		public Node(Node next, Node previous, Object data) {
			this.next = next;
			this.previous = previous;
			this.data = data;
		}
		
		public Node getNext() {
			return this.next;
		}
		
		public void setNext(Node next) {
			this.next = next;
		}
		
		public Node getPrevious() {
			return this.previous;
		}
		
		public void setPrevious(Node previous) {
			this.previous = previous;
		}
		
		public Object getData() {
			return this.data;
		}
		
		public boolean equals(Object o) {
			return this.data.toString().equalsIgnoreCase(o.toString());
		}
		
	}
	
}