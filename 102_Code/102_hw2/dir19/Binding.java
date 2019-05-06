public class Binding
	extends VariableBindings
{
	private String id;
	private double value;

	public Binding(String id, double value)
	{
		this.id = id;
		this.value = value;
	}

	public Binding(double value)
	{
		this.value = value;
	}

	public String getString()
	{
		return this.id;
	}

	public double getValue()
	{
		return this.value;
	}

	public String toString()
	{
		return this.id;
	}
}
