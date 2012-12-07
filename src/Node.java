//import LinkedList.Node;

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