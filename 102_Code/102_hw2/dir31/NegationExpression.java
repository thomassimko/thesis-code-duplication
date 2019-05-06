
public class NegationExpression implements Expression 
{
	private Expression value;
	
	public NegationExpression(Expression e)
	{
		this.value = e;
	}
	@Override
	public double evaluate(Bindings bindings) 
	{
		return value.evaluate(bindings) * -1;
	}

	public String toString()
	{
		return ("-" + value);
	}
}
