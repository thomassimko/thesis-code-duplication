
public class NegationExpression implements Expression {
	private Expression value;

	public NegationExpression(Expression e)
	{
		this.value = e;
	}
	public double evaluate(Bindings bindings) {
		// TODO Auto-generated method stub
		return (-1)*value.evaluate(bindings);
	}
	public String toString()
	{
		return "-" +value.toString();
	}

}
