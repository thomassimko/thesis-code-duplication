import java.util.ArrayList;
import java.util.List;

public class IdentifierExpression
	implements Expression
{
	private String id;
	
	public IdentifierExpression(String id)
	{
		this.id = id;
	}

	public double evaluate(Bindings binding)
	{
		VariableBindings bindThis = new VariableBindings();			
		return bindThis.lookupBinding(id);
	}
	
	public String toString()
	{
		return this.id;
	}

}
