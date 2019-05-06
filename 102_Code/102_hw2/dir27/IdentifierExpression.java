public class IdentifierExpression
	implements Expression
{
	public String name;
	public IdentifierExpression(String id)
	{
		this.name = id;
	}
	public double evaluate(Bindings binding)
	{
		return binding.lookupBinding(this.name);
	}
	public String toString()
	{
		return this.name;
	}
}