public class Assignment
	implements Expression
{
	private String id;
	private Expression e;
	
	public Assignment(String id, Expression e)
	{
		this.id = id;
		this.e = e;
	}

	public double evaluate(Bindings binding)
	{
		Binding bindThis = new Binding(id,e.evaluate(binding));
		bindThis.addBinding(id,e.evaluate(binding));
		return e.evaluate(binding);
	}

	public String toString()
	{
		return "set " + this.id;
	}
}
		
