
/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700)
 * @since December 2012
 *
 */
@Writer("Lena Lenz")
public abstract class ObjectIterator {
	
	protected LinkedList list;
	protected int cur_index;
	protected Node node;
	
	
	public ObjectIterator(LinkedList list) {
		this.list = list;
		this.cur_index = 0;
		this.node = null;
	}
	
	protected boolean hasNext() {
		return this.cur_index < this.list.getSize();
	}
	
	protected Object getNext() {
		if(cur_index == 0)
			node = list.getHead();
		Object ret = this.node.getData();
		node = node.getNext();
		cur_index++;
		return ret;
	}
	
}
