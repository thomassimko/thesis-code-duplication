
public class Assignment implements Expression {

	private Expression e;
	private String id;
	public Assignment(String id, Expression e)
	{
		this.id = id;
		this.e = e;
	}
	public double evaluate(Bindings bindings) {
		bindings.addBinding(id, e.evaluate(bindings));
		return e.evaluate(bindings);
	}
	public String toString()
	{
		return "set "+this.id+" = "+this.e.toString();
	}

}
