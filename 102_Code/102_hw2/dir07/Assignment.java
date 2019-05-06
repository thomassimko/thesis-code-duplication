
public class Assignment 
	implements Operation 
{
	private String id;
	private Expression expression;
	
	public Assignment(String id2, Expression e)
	{
		this.id = id2;
		this.expression = e;
	}
	
	@Override
	public double evaluate(Bindings bindings)
	{		
		bindings.addBinding(id, expression.evaluate(bindings));
		return expression.evaluate(bindings);
	}
	
	public String toString()
	{
		return "set " + id + " = " + expression; 
	}

}
