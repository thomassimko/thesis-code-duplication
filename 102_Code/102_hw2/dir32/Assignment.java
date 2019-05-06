
public class Assignment 
     implements Expression    
{
	private Expression e;
	private String id;
	public Assignment(String id, Expression e)
	{
		this.e = e;
		this.id = id;		
	}
 

	public double evaluate(Bindings bindings) 
	{
		bindings.addBinding(id, e.evaluate(bindings));
		return e.evaluate(bindings);
	}
	
	public String toString()
	{
		return "set " + id + " = " + e.toString();
	}

}
