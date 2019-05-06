public class NegationExpression
	implements Expression
{
	private Expression negative;
	public NegationExpression(Expression e)
	{
		this.negative = e;
	}
	public double evaluate(Bindings binding)
	{
		return -this.negative.evaluate(binding);
	}
	public String toString()
	{
		return "-"+this.negative.toString();
	}

}