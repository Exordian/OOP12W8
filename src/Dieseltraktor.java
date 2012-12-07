
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
