public class DoubleConstantExpression
	implements Expression
{
	private double val;
	public DoubleConstantExpression(double value)
	{
		this.val = value;
	}
	public double evaluate(Bindings binding)
	{
		return this.val;
	}
	public String toString()
	{
		return "" + this.val;
	}
}