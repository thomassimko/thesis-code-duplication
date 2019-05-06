import java.util.ArrayList;
import java.util.List;

public class VariableBindings
	implements Bindings
{
	private static ArrayList<Binding> bindingList = new ArrayList<Binding>();

	public VariableBindings()
	{
		this.bindingList = bindingList;
	}

	public void addBinding(String id, double value)
	{
		Binding bindThis = new Binding(id,value);
		int i = 0;
		boolean within = false;
		if (!bindingList.isEmpty()) //this block checks if the element already exists within the list, and replaces binding
		{
			while (true)
			{
				if (i < bindingList.size()) //checks if element is in array bounds
				{
					if (id.equals(bindingList.get(i).getString())) //checks if ID is already used in arraylist
					{
						within = true;
						bindingList.set(i,bindThis); //replaces old binding with new binding
						break;
					}
				}
				else //breaks if element is not within array bounds
				{
					break;
				}
				i++;
			}
		}
		if (!within)
		{
			bindingList.add(bindThis);
		}
	}

	public double lookupBinding(String id)
	{
		int i;
		for (i = 0; i < bindingList.size() ;i++)
		{
			if (id.equals(bindingList.get(i).getString()))
			{
				return bindingList.get(i).getValue();
			}
		}
		throw new UnboundIdentifierException("unbound identifier: " + id);
	}
}







