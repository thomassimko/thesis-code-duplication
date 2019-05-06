public class SubtractExpression
	implements Expression
{
	private Expression lft;
	private Expression rht;

	public SubtractExpression(Expression lft, Expression rht)
	{
		this.lft = lft;
		this.rht = rht;
	}

	public double evaluate(Bindings bindings)
	{
		return lft.evaluate(bindings) - rht.evaluate(bindings);
	}
	
	public String toString()
	{
		return "(" + this.lft + " - " + this.rht + ")";
	}
}
