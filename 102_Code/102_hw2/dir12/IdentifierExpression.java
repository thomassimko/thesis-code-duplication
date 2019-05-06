
public class IdentifierExpression implements Expression {

	private double value;
	private String id;
	
	public IdentifierExpression(String matchIdentifier) {

		this.id = matchIdentifier;
	}

	public double evaluate(Bindings bindings) {
		
		value = bindings.lookupBinding(id);

		return value;
	}
	
	public String toString(){
		
		return id;	
	}

}
