
public class IdentifierExpression 
	implements Expression 
{
	
	private String id;
	
	public IdentifierExpression(String id2)
	{
		this.id = id2;
	}
	
	@Override
	public double evaluate(Bindings bindings) 
	{
		return bindings.lookupBinding(id);
	}

	public String toString()
	{
		return id;
	}
}
