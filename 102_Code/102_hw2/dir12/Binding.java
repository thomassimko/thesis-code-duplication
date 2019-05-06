
public class Binding{

	private String name;
	private double number;
	
	public Binding(String id, double value) {
		
		this.name = id;
		this.number = value;

	}
	
	public double value(){
		return number;
	}
	
	public String toString(){
		
		return name;	
	}

}
