public class NegationExpression implements Expression {
	
	private Expression e;
	
	public NegationExpression(Expression e){
		this.e = e;
	}
	@Override
	public double evaluate(Bindings bindings) {
		return -e.evaluate(bindings);
	}
	public String toString() {
		return "-" + e.toString();	
	}

}
