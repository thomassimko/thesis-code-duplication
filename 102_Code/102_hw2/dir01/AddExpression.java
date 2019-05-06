
public class AddExpression implements Expression {
	
	private Expression lht;
	private Expression rht;

	public AddExpression(Expression lht,Expression rht)
	{
		this.lht = lht;
		this.rht = rht;
	}
	public double evaluate(Bindings bindings) {
		return lht.evaluate(bindings)+rht.evaluate(bindings);
	}
	public String toString()
	{
		return "("+this.lht.toString()+" + "+this.rht.toString()+")";
	}

}
