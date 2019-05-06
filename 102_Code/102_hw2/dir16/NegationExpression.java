public class NegationExpression
	implements Expression
{
	private Expression e;
	
	public NegationExpression(Expression e)
	{
		this.e = e;
	}

	public double evaluate(Bindings bindings)
	{
		return -this.e.evaluate(bindings);
	}
	
	public String toString()
	{
		return "-" + this.e;
	}
}
