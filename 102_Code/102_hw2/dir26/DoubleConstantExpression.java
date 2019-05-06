
public class DoubleConstantExpression implements Expression {
	
	private double value;
	
	public DoubleConstantExpression(double value){
		this.value=value;
	}
	@Override
	public double evaluate(Bindings bindings) {
		return value;
	}
	public String toString(){
		return String.format("%.1f", value);
	}
}