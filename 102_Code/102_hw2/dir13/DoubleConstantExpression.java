
public class DoubleConstantExpression implements Expression {

	double v;
	
	public DoubleConstantExpression(double value) {
		v = value;
	}

	public double evaluate(Bindings bindings) {
		return v;
	}
	
	public String toString() {
		return "" + v;
	}
}
