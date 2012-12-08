
/**
 *
 * @author Englisch (e1125164), Lenz (e1126963), Schuster (e1025700)
 * @since December 2012
 *
 */
public class Dieseltraktor extends Traktor {
	
	private int liter;
	
	public Dieseltraktor() {
		super();
	}
		
	public Dieseltraktor(int liter) {
		super();
		this.liter = liter;
	}
	
	public int getLiter() {
		return this.liter;
	}
	public void setLiter(int liter) {
		this.liter = liter;
	}
	
	public String toString() {
		return "Ich bin ein Dieseltraktor mit der ID " +this.getID();
	}
	
}
