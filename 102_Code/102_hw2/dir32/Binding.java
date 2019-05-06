
public class Binding 
{
	private double value;
	private String id;
	
	public Binding(String id, double value)
	{
		this.id = id;
		this.value = value;
	}
	
	public String getId()
	{
		return id;
	}
	public double getValue()
	{
		return value;
	}
}
