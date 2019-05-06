
public class SubtractExpression implements Expression {
	private Expression left;
	private Expression right;
	public SubtractExpression(Expression lft, Expression rht)
	{
		this.left = lft;
		this.right = rht;
	}
	
	public double evaluate(Bindings bindings) {
		return left.evaluate(bindings) - right.evaluate(bindings);
	}
	
	public String toString()
	{
		return "(" + this.left.toString() + " - " + this.right.toString() + ")";
	}
}
