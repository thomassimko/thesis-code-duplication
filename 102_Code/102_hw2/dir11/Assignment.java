
public class Assignment implements Expression
{
	private String id;
	private Expression e;
	
	public Assignment(String id, Expression e)
	{
		this.id = id;
		this.e = e;
	}

	@Override
	public double evaluate(Bindings bindings)
	{
		bindings.addBinding(this.id, e.evaluate(bindings));
		return bindings.lookupBinding(this.id);
	}
	
	@Override
	public String toString()
	{
		return "set " + id + " = " + e.toString();
	}
}
