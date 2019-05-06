
public class MultiplyExpression implements Expression {

	private double product;
	private Expression p1, p2;

	public MultiplyExpression(Expression lft, Expression rht) {

		p1 = lft;
		p2 = rht;
	}

	public double evaluate(Bindings bindings) {

		product=p1.evaluate(bindings)*p2.evaluate(bindings);
		return product;
	}
	
	public String toString(){
		
		return "("+p1.toString()+" * "+p2.toString()+")";	
	}

}
