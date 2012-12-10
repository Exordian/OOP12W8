
/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700)
 * @since December 2012
 *
 */
@Writer("Lena Lenz")
public class TraktorIterator extends ObjectIterator {

	public TraktorIterator(TraktorList t_list) {
		super(t_list);
	}
	
	public Traktor getNext() {
		return (Traktor)super.getNext();
	}

}
