
public class AddExpression 
	implements Expression 
{
	private Expression left, right;
	
	public AddExpression(Expression lft, Expression rht)
	{
		this.left = lft;
		this.right = rht;
	}

	@Override
	public double evaluate(Bindings bindings) 
	{
		return left.evaluate(bindings) + right.evaluate(bindings);
	}
	
	public String toString()
	{
		return "(" + left + " + " + right + ")";
	}
}
