
public class IdentifierExpression implements Expression {
	
	private String variable;
	
	public IdentifierExpression(String id)
	{
		this.variable = id;
	}
	
	public double evaluate(Bindings bindings) {
		return bindings.lookupBinding(variable);
	}

	public String toString()
	{
		return variable;
	}
}
