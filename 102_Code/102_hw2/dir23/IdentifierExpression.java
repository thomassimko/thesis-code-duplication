public class IdentifierExpression
    implements Expression
{
	private String id;
	
	public IdentifierExpression(String id)
	{
		this.id = id;
	}
	
	@Override
	public double evaluate(Bindings bindings) {
		// TODO Auto-generated method stub
		double value;
		value = bindings.lookupBinding(this.id);
		
		return value;
	}
	
	public String toString()
    {
    	return "(" + id + ")";
    }
}
