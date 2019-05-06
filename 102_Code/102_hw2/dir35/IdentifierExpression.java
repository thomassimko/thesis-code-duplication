
public class IdentifierExpression
implements Expression
{
	private String iden;
	public IdentifierExpression(String id)
	{
		iden= id;
	}
	public double evaluate(Bindings bindings)
	{
        double value = bindings.lookupBinding(iden);
		return value;
	}
	   public String toString()
	   {
		   return iden;
	   }
}

