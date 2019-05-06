
public class DoubleConstantExpression implements Expression {
	public double value;
	public DoubleConstantExpression(double value)
	{
		this.value = value;
	}
	public double evaluate(Bindings bindings) {
		return value;
	}
	public String toString()
	{
		return ""+this.value;
	}

}
