
/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700)
 * @since December 2012
 *
 */
@Writer("Lena Lenz")
public class BauernhofIterator extends ObjectIterator {

	public BauernhofIterator(BauernhofList b_list) {
		super(b_list);
	}
	
	public Bauernhof getNext() {
		return (Bauernhof)super.getNext();
	}
	
}
