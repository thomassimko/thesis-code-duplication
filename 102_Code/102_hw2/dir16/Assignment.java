public class Assignment
	implements Operation
{
	private String id;
	private Expression e;
	
	public Assignment(String id, Expression e)
	{
		this.id = id;
		this.e = e;
	}

	public double evaluate(Bindings bindings)
	{
		double value = e.evaluate(bindings);
		
		bindings.addBinding(this.id, value);
		
		return value;
	}
	
	public String toString()
	{
		return "set " + this.id + " = " + this.e;
	}
}
