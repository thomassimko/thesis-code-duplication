
public class DivideExpression implements Expression {

	private double quotient; 
	private Expression dividend, divisor;

	public DivideExpression(Expression lft, Expression rht) {

		dividend = lft;
		divisor = rht;
	}

	public double evaluate(Bindings bindings) {
		
		quotient = dividend.evaluate(bindings)/divisor.evaluate(bindings);
		return quotient;
	}
	
	public String toString(){
		
		return "("+dividend.toString()+" / "+divisor.toString()+")";	
	}

}
