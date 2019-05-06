
public class DivideExpression implements Expression {
	private Expression lft;
	private Expression rht;

	public DivideExpression(Expression lft, Expression rht)
	{
		this.lft = lft;
		this.rht = rht;
	}
	public double evaluate(Bindings bindings) {
		// TODO Auto-generated method stub
		return this.lft.evaluate(bindings) / this.rht.evaluate(bindings);
	}
	public String toString()
	{
		return "(" +lft.toString() + " / " +rht.toString() + ")";
	}
}
