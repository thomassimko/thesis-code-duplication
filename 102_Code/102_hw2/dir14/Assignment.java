
public class Assignment implements Operation {
	
	private String variable;
	private Expression expression;
	
	public Assignment(String id, Expression e)
	{
		this.variable = id;
		this.expression = e;
	}
	public double evaluate(Bindings bindings) {
		double evaluation = expression.evaluate(bindings);
		bindings.addBinding(variable, evaluation);
		return evaluation;
	}
	
	public String toString()
	{
		return "set " + variable.toString() + " = " + expression;
	}
}
