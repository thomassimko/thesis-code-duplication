import java.util.*;

public class VariableBindings implements Bindings {

	private List<Binding> stored_variables = new ArrayList<Binding>();
	
	public void addBinding(String id, double value) {
		for(int i = 0; i < stored_variables.size(); i++)
		{
			if(stored_variables.get(i).getString().equals(id))
			{
				stored_variables.set(i, new Binding(id, value));
				return;
			}
		}
		stored_variables.add(new Binding(id, value));
	}

	public double lookupBinding(String id) throws UnboundIdentifierException {
		double value = 0;
		for(int i = 0; i < stored_variables.size(); i++)
		{
			if(stored_variables.get(i).getString().equals(id))
			{
				value = stored_variables.get(i).getValue();
			}
			else
			{
				throw new UnboundIdentifierException("unbound identifier: " + id);
			}
		}
		return value;
	}
}
