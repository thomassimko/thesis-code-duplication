
public class SubtractExpression implements Expression {
	
	private Expression lft,rht;
	
	public SubtractExpression(Expression lft, Expression rht){
		this.lft=lft;
		this.rht=rht;
	}
	@Override
	public double evaluate(Bindings bindings) {
		return lft.evaluate(bindings)-rht.evaluate(bindings);
	}
	public String toString(){
		return "("+lft.toString()+" - "+rht.toString()+")";
	}
}
