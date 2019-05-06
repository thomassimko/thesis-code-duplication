public class IdentifierExpression
	implements Expression
{
	private String id;

	public IdentifierExpression(String id)
	{
		this.id = id;
	}

	public double evaluate(Bindings bindings)
	{
		return bindings.lookupBinding(this.id);
	}

	public String toString()
	{
		return this.id;
	}
}
