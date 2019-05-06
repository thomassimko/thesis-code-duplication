
public class Assignment implements Operation {
	private String id;
	private Expression e;
	public Assignment(String id, Expression e){
		this.id = id;
		this.e = e;
	}
	@Override
	public double evaluate(Bindings bindings) {
		double value = e.evaluate(bindings);
		bindings.addBinding(id, value);
		return value;
	}
	@Override
	public String toString() {
		return "set " + id + " = " + e.toString();
	}

}
