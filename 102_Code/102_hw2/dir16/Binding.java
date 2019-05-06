public class Binding
{
	private String id;
	private double value;
	
	public Binding(String id, double value)
	{
		this.id = id;
		this.value = value;
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
