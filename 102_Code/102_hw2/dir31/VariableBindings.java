import java.util.ArrayList;
import java.util.List;

public class VariableBindings implements Bindings 
{
	List<Binding> bindings = new ArrayList<Binding>();
	
	public VariableBindings()
	{
		 
	}
	@Override
	public void addBinding(String id, double value) 
	{
		Binding b = new Binding(id, value);
		boolean replaced = false;
		
		for(int i = 0; i < bindings.size(); i++)
		{
			Binding check = bindings.get(i);
			if(check.getId().equals(id))
			{
				bindings.set(i, b);
				replaced = true;
			}			
		}
		if(!replaced)
		{
			bindings.add(b);
		}
	}

	@Override
	public double lookupBinding(String id) throws UnboundIdentifierException 
	{
		for(int i = 0; i < bindings.size(); i++)
		{
			Binding check = bindings.get(i);
			if(check.getId().equals(id))
			{
				return check.getValue();
			}
		}
		throw new UnboundIdentifierException("unbound identifier: " + id);
	}
}
