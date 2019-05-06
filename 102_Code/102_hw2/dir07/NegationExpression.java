
public class NegationExpression 
	implements Expression 
{
	private Expression expression;
	
	public NegationExpression(Expression e)
	{
		this.expression = e;
	}
	
	@Override
	public double evaluate(Bindings bindings) 
	{
		return -(this.expression.evaluate(bindings));
	}
	
	public String toString()
	{
		return "-" + expression;
	}

}
