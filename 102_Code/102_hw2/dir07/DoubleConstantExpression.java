
public class DoubleConstantExpression 
	implements Expression 
{
	private double value;
	
	public DoubleConstantExpression(double v)
	{
		this.value = v;
	}
	
	@Override
	public double evaluate(Bindings bindings) 
	{
		return this.value;
	}
	
	public String toString()
	{
		return "" + value;
	}

}
