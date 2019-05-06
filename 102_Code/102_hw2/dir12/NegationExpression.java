
public class NegationExpression implements Expression {

	private Expression value;

	public NegationExpression(Expression e) {

		value = e;

	}

	public double evaluate(Bindings bindings) {

		
		return value.evaluate(bindings)-value.evaluate(bindings)*2;
	}

	public String toString(){
		
		return "-"+value.toString();	
	}
	
}
