
public class Dieseltraktor extends Traktor {
	
	private int liter;
	
	public Dieseltraktor(int id, int liter) {
		super(id);
		this.liter = liter;
	}
	
	public int getLiter() {
		return this.liter;
	}
	public void setLiter(int liter) {
		this.liter = liter;
	}
	
}
