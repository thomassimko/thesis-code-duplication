
public class AddExpression implements Expression
{

	private Expression lft, rht;
	
	public AddExpression(Expression val1, Expression val2)
	{
		this.lft = val1;
		this.rht = val2;
	}
	
	@Override
	public double evaluate(Bindings binding)
	{
		return lft.evaluate(binding) + rht.evaluate(binding);
	}
	
	@Override
	public String toString()
	{
		return "(" + lft.toString() + " + " + rht.toString() + ")";
	}

}
