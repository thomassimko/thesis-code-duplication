
public class DivideExpression implements Expression{

	Expression l,r;
	
	public DivideExpression(Expression lft, Expression rht) {
		l = lft;
		r = rht;
	}

	public double evaluate(Bindings binding) {
		return l.evaluate(binding) / r.evaluate(binding);
	}
	
	public String toString() {
		return "(" + l + " / " + r + ")";
	}
}
