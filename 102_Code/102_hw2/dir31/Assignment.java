
public class Assignment implements Operation
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
		double val = e.evaluate(bindings);
		bindings.addBinding(id, val);
		return val;
	}
	
	public String toString()
	{
		return ("set " + id + " = " + e);
	}
}
