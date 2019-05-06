
public class DoubleConstantExpression implements Expression {

	private double value=0;
	
	public DoubleConstantExpression(double given) {
		this.value=given;
	}

	public double evaluate(Bindings bindings) {

		return value;
	}
	
	public String toString(){
		
		return ""+value+"";	
	}

}
