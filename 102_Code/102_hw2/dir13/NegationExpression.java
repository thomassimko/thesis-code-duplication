
public class NegationExpression implements Expression {

	Expression neg;
	
	public NegationExpression(Expression e) {
		neg = e;
	}

	public double evaluate(Bindings bindings) {
		return -1.0 * neg.evaluate(bindings);
	}
	
	public String toString() {
		return "-"+neg.toString();
	}
}
