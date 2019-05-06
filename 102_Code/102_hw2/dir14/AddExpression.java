
public class AddExpression implements Expression {
	
	private Expression left;
	private Expression right;
	
	public AddExpression(Expression lft, Expression rht)
	{
		this.left = lft;
		this.right = rht;
	}
	
	public double evaluate(Bindings bindings) {
		return this.left.evaluate(bindings) + this.right.evaluate(bindings);
	}
	
	public String toString()
	{
		
		return "(" + this.left.toString() + " + " + this.right.toString() + ")";
	}

}
