
/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700)
 * @since December 2012
 *
 */
@Writer("Lena Lenz")
public class ObjectIterator {
	
	private LinkedList list;
	private int cur_index;
	private Node node;
	
	
	public ObjectIterator(LinkedList list) {
		this.list = list;
		this.cur_index = 0;
		this.node = null;
	}
	
	public boolean hasNext() {
		return this.cur_index < this.list.getSize();
	}
	
	public Object getNext() {
		if(cur_index == 0)
			node = list.getHead();
		Object ret = this.node.getData();
		node = node.getNext();
		cur_index++;
		return ret;
	}
	
}
