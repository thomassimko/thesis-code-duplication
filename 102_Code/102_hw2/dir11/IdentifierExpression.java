
public class IdentifierExpression implements Expression
{
	private String id;
	
	public IdentifierExpression(String id)
	{
		this.id = id;
	}
	
	@Override
	public double evaluate(Bindings bindings)
	{
		return bindings.lookupBinding(id);
	}
	
	@Override
	public String toString()
	{
		return id;
	}

}
