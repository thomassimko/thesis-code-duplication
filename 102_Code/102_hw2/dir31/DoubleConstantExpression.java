
public class DoubleConstantExpression implements Expression 
{
	private double value;
	
	public DoubleConstantExpression(double value)
	{
		this.value = value;
	}
	
	public double evaluate(Bindings binding)
	{
		return value;
	}
	
	public String toString()
	{
		return("" + value);
	}
}
