public class AddExpression
	implements Expression
{
	private Expression first;
	private Expression second;

	public AddExpression(Expression first, Expression second)
	{
		this.first = first;
		this.second = second;
	}
	
	public double evaluate(Bindings binding)
	{
		return (first.evaluate(binding) + second.evaluate(binding));
	}

	public String toString()
	{
		return "(" + this.first.toString() + " + " + this.second.toString() + ")";
	}
}
