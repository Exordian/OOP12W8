
/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700)
 * @since December 2012
 *
 */
@Writer("Lena Lenz")
public class BauernhofMap {
	
	private BauernhofList keys;
	
	public BauernhofMap() {
		this.keys   = new BauernhofList();
	}
	
	public int size() {
		return this.keys.getSize();
		//returns size
	}
	
	public boolean isEmpty() {
		return size() == 0;
		//returns whether map is empty or not
	}
	
	public boolean containsKey(Bauernhof b) {
		BauernhofIterator it = new BauernhofIterator(this.keys);
		Bauernhof elem = null;
		while(it.hasNext()) {
			elem = it.getNext();
			if(elem.getName().equals(b.getName()))
				return true;
		}
		return false;
		//returns whether specific key is in map or not
	}
	
	public Bauernhof getKey(Traktor t) {
		BauernhofIterator it = new BauernhofIterator(this.keys);
		Bauernhof b = null;
		TraktorList list = null;
		Traktor elem = null;
		while(it.hasNext()) { //first iterate through farms
			b = it.getNext();
			list = b.getTraktorList();
			TraktorIterator traktoren = new TraktorIterator(list);
			while(traktoren.hasNext()) { //next iterate through corresponding lists of tractors
				elem = traktoren.getNext();
				if(elem.getID() == t.getID())
					return b;
			}
		}
		return null;
		//returns: if tractor t is in map: corresponding farm b
		//         else: null
	}
	
	public TraktorList getTraktorList(Bauernhof b) {
		if(!containsKey(b))
			return null;
		return b.getTraktorList();
		//returns: if farm b is in map: corresponding tractor list
		//         else: null
	}
	
	public void put(Bauernhof b, Traktor t) {
		if(!containsKey(b)) {
			this.keys.append(b);
		}
		b.insert(t);
		//new entry consisting of a farm b and its corresponding tractor t has been inserted
	}
	
	public void putTraktorList(Bauernhof b, TraktorList t_list) {
		if(!containsKey(b)) {
			this.keys.append(b);
		}
		b.addTraktorList(t_list);
		//new entry consinsting of a farm b and its corresponding tractorlist t_list has been inserted
	}
	
	public void putBauernhof(Bauernhof b) {
		if(!containsKey(b)) {
			this.keys.append(b);
		}
		//new farm has been put to map
	}
	
	public void removeTraktor(Traktor t) {
		Bauernhof b = getKey(t);
		if(b == null)
			return;
		b.remove(t);
		//tractor t has been removed(only if t previously was in map!!)
	}
	
	public String toString() {
		StringBuffer buf = new StringBuffer();
		BauernhofIterator it = new BauernhofIterator(this.keys);
		Bauernhof b = null;
		buf.append("Map enthaelt: \n");
		while(it.hasNext()) {
			b = it.getNext();
			buf.append("KEY: "+ b.getName());
			buf.append('\n');
			buf.append("VALUES:\n"+ b.getTraktorList().toString());
			buf.append('\n');
		}
		return buf.toString();
	}
	
}
