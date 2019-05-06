
public class Assignment implements Operation{
	String id;
	Expression expression;
	
	public Assignment(String id, Expression e) {
		this.id = id;
		expression = e;
	}
	
	public double evaluate(Bindings binding) {
		binding.addBinding(id, expression.evaluate(binding));
		return expression.evaluate(binding);
	}
	
	public String toString() {
		return "set " + id + " = " + expression.toString();
	}
}
