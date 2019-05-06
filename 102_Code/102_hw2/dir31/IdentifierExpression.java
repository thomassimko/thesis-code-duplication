
public class IdentifierExpression implements Expression
{
	private String id;
	
	public IdentifierExpression(String id)
	{
		this.id = id;
	}
	
	public double evaluate(Bindings bindings)
	{
		return bindings.lookupBinding(id);	
	}

	public String toString()
	{
		return (id);
	}
}
