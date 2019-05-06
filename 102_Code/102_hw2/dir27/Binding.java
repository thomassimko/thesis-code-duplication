public class Binding
{
	private String name;
	private double value;
	public Binding(String id, double val)
	{
		this.name = id;
		this.value = val;
	}
	public String getString()
	{
		return this.name;
	}
	public double getVal()
	{
		return this.value;
	}
}