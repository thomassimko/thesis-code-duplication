
public class NegationExpression implements Expression {

	private Expression value;
	public NegationExpression(Expression e)
	{
		this.value = e;
		
	}
	public double evaluate(Bindings bindings) {
		return -1*(this.value.evaluate(bindings));
	}
	public String toString()
	{
		return "-"+this.value.toString();
	}

}
