
public class AddExpression implements Expression {

	private double sum; 
	private Expression num1, num2;
	
	public AddExpression(Expression lft, Expression rht) {

		num1 = lft;
		num2 = rht;
	}

	public double evaluate(Bindings bindings) {
		
		sum = num1.evaluate(bindings) + num2.evaluate(bindings);

		return sum;
	}
	
	public String toString(){
		
		return "("+num1.toString()+" + "+num2.toString()+")";	
	}
}
