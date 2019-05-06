
public class AddExpression implements Expression{

	Expression l,r;
	
	public AddExpression(Expression lft, Expression rht) {
		l = lft;
		r = rht;
	}

	public double evaluate(Bindings binding) {
		return l.evaluate(binding) + r.evaluate(binding);
	}
	
	public String toString() {
		return "(" + l + " + " + r + ")";
	}
}
