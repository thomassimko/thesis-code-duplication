
public class DoubleConstantExpression implements Expression {

	private double value;
	
	public DoubleConstantExpression(double value)
	{
		this.value = value;
	}
	public double evaluate(Bindings bindings) {
		// TODO Auto-generated method stub
		return value;
	}
	public String toString()
	{
		return "" +value;
	}
}
