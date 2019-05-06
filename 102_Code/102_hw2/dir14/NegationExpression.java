
public class NegationExpression implements Expression {
	private Expression expression;
	public NegationExpression(Expression e)
	{
		this.expression = e;
	}
	public double evaluate(Bindings bindings) {
		return -expression.evaluate(bindings);
	}

	public String toString()
	{
		return "-" + expression.toString();
	}
}
