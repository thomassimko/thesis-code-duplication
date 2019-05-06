import java.util.ArrayList;
import java.util.List;

public class VariableBindings implements Bindings {

	List<Binding> expression = new ArrayList<Binding>();
	
	public void addBinding(String id, double value) {
		expression.add(new Binding(id, value));
	}

	public double lookupBinding(String id) throws UnboundIdentifierException {
		for (Binding b: expression) {
			if (b.getID().equals(id))
				return b.getValue();
		}
		throw new UnboundIdentifierException("unbound identifier: " + id);
	}
}
