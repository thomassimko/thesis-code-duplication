
public class SubtractExpression implements Expression {

	private double difference;
	private Expression d1, d2;
	public SubtractExpression(Expression lft, Expression rht) {
		d1 = lft;
		d2 = rht;
	}

	public double evaluate(Bindings bindings) {
		difference = d1.evaluate(bindings)-d2.evaluate(bindings);
		return difference;
	}
	
	public String toString(){
		
		return "("+d1.toString()+" - "+d2.toString()+")";	
	}
}
