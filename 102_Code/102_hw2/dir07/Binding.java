
public class Binding 
{
	private String id;
	private double value;
	
	public Binding(String id2, double value2)
	{
		this.id = id2;
		this.value = value2;
	}
	
	public String getId()
	{
		return this.id;
	}
	
	public double getValue()
	{
		return this.value;
	}
}