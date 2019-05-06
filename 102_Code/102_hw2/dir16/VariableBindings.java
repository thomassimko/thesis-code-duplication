import java.util.ArrayList;
import java.util.List;

public class VariableBindings
	implements Bindings
{
	private List<Binding> bindings;

	public VariableBindings()
	{
		this.bindings = new ArrayList<Binding>();
	}
	
	public void addBinding(String id, double value)
	{
		int i;
		int index = 0;
		
		for(i=0; i<this.bindings.size(); i++)
		{
			if(id.equals(bindings.get(i).getId()))
			{
				index = i;
				break;
			}
		}

		if(i < this.bindings.size())
		{
			bindings.set(index, new Binding(id, value));
		}
		else
		{
			bindings.add(new Binding(id, value));
		}
	}

	public double lookupBinding(String id)
	{
		int i;
		int index = 0;
		
		for(i=0; i<this.bindings.size(); i++)
		{
			if(id.equals(bindings.get(i).getId()))
			{
				index = i;
				break;
			}
		}
		
		if(i < this.bindings.size())
		{
			return bindings.get(index).getValue();
		}
		else
		{
			throw new UnboundIdentifierException("unbound indentifier: " + id);
		}
	}
}
