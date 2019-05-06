
public class MultiplyExpression implements Expression {
	private Expression lft;
	private Expression rht;
	
	public MultiplyExpression(Expression lft, Expression rht)
	{
		this.lft = lft;
		this.rht = rht;
	}
	public double evaluate(Bindings bindings) {
		// TODO Auto-generated method stub
		return lft.evaluate(bindings) * rht.evaluate(bindings);
	}
	
	public String toString()
	{
		return "(" +lft.toString() + " * " +rht.toString() + ")";
	}


}
