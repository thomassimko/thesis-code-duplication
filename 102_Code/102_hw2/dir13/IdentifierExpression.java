
public class IdentifierExpression implements Expression {
	String identity;
	
	public IdentifierExpression(String identifier) {
		identity = identifier;
	}
	
	public double evaluate(Bindings bindings) {
		return bindings.lookupBinding(identity);
	}
	
	public String toString() {
		return identity;
	}

}
