
import java.util.*;

public class VariableBindings 
	implements Bindings 
{
	private List<Binding> bindingsList = new ArrayList<Binding>();
	
	@Override
	public void addBinding(String id, double value) 
	{
		boolean found = false;
		
		for(int i=0; i < bindingsList.size(); i++)
		{
			if(id.equals(bindingsList.get(i).getId()))
			{
				bindingsList.set(i, new Binding(id, value));
				found = true;
			}
		}
	
		if(!found)
		{
			bindingsList.add(new Binding(id, value));
		}
	}

	@Override
	public double lookupBinding(String id2) 
			throws UnboundIdentifierException 
	{
		for(int i=0; i < bindingsList.size(); i++)
		{
			if(id2.equals(bindingsList.get(i).getId()))
			{
				return bindingsList.get(i).getValue();
			}
		}
		
		throw new UnboundIdentifierException("unbound identifier: " + id2);
	}

}
