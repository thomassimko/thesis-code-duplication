
public class DoubleConstantExpression implements Expression {
	
    private double constant;
    
	public DoubleConstantExpression(double value)
	{
		this.constant = value;
	}
	
	public double evaluate(Bindings bindings) {
		return constant;
	}
	
	public String toString()
	{
		return "" + constant;
	}
}
