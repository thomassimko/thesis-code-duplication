
public class Binding {
	
	private String variable;
	private double current_value;
	
	public Binding(String id, double value)
	{
		this.variable = id;
		this.current_value = value;
	}
	
	public String getString()
	{
		return this.variable;
	}
	
	public double getValue()
	{
		return this.current_value;
	}
}
