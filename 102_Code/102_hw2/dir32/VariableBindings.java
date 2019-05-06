import java.util.ArrayList;

public class VariableBindings 
     implements Bindings
{
    ArrayList<Binding> variables = new ArrayList<Binding>(); 
	public void addBinding(String id, double value)
	{   
		if(!variables.isEmpty())
		{
			for(int i = 0; i < variables.size();i++)
			{
				if(id.compareTo(variables.get(i).getId()) == 0)
				{
					variables.remove(i);
				}
			}
		}
		variables.add(new Binding(id,value));

	}


	public double lookupBinding(String id) throws UnboundIdentifierException 
	{
		if(!variables.isEmpty())
		{
			for(int i = 0; i < variables.size();i++)
			{
				if(id.compareTo(variables.get(i).getId()) == 0)
				{
					return variables.get(i).getValue();
				}
			}
					
		}
		throw new UnboundIdentifierException("unbound identifier: " + id);	
	}
	
	
}
