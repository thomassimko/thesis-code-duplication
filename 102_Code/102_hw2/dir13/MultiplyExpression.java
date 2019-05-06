
public class MultiplyExpression implements Expression{

	Expression l,r;
	
	public MultiplyExpression(Expression lft, Expression rht) {
		l = lft;
		r = rht;
	}

	public double evaluate(Bindings binding) {
		return l.evaluate(binding) * r.evaluate(binding);
	}
	
	public String toString() {
		return "(" + l + " * " + r + ")";
	}
}
