
public class DivideExpression 
	implements Expression 
{
	private Expression left, right;
	
	public DivideExpression(Expression lft, Expression rht)
	{
		this.left = lft;
		this.right = rht;
	}

	@Override
	public double evaluate(Bindings bindings) 
	{
		return this.left.evaluate(bindings) / this.right.evaluate(bindings);
	}

	public String toString()
	{
		return "(" + left + " / " + right + ")";
	}
}
