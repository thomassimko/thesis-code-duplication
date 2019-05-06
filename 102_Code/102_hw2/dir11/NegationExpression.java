
public class NegationExpression implements Expression
{
	private Expression e;
	
	public NegationExpression(Expression e)
	{
		this.e = e;
	}
	
	@Override
	public double evaluate(Bindings binding)
	{
		return (e.evaluate(binding) * -1.0);
	}
	
	@Override
	public String toString()
	{
		return "-" + e.toString();
	}
}
