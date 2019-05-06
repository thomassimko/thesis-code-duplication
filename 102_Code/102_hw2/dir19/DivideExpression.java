public class DivideExpression
	implements Expression
{
	private Expression first;
	private Expression second;

	public DivideExpression(Expression first, Expression second)
	{
		this.first = first;
		this.second = second;
	}
	
	public double evaluate(Bindings binding)
	{
		return (first.evaluate(binding) / second.evaluate(binding));
	}

	public String toString()
	{
		return "(" + first.toString() + " / " + second.toString() + ")";
	}
}
