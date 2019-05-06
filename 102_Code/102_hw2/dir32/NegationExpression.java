
public class NegationExpression 
     implements Expression
{
	 private Expression value;
     public NegationExpression(Expression e)
	 {
		 value = e;
	 }


	public double evaluate(Bindings bindings) 
	{	
		return (-1)*(value.evaluate(bindings));
	}
	 
	public String toString()
	{
		return "-" + value.toString();
	}
	 
}
