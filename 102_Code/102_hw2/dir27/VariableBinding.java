import java.util.ArrayList;
import java.util.List;

public class VariableBinding
	implements Bindings
{
	List<Binding>bind = new ArrayList<Binding>();
	public void addBinding(String id, double value)
	{
		if (bind.size()>0)
		{
			int replaced = 0;
			for (int i=0; i<bind.size(); i++)
			{
				if (bind.get(i).getString().equals(id))
				{
					Binding a = new Binding(id, value);
					bind.set(i, a);
					replaced = 1;
				}
			}
			if (replaced == 0)
			{
				Binding a = new Binding(id, value);
				bind.add(a);
			}
		}
		else
		{
			Binding a = new Binding(id, value);
			bind.add(a);
		}
	}
	
	public double lookupBinding(String id)
	{
		for (int i=0; i<bind.size(); i++)
		{
			if (bind.get(i).getString()==id)
			{
				return bind.get(i).getVal();
			}
		}
		throw new UnboundIdentifierException("unbound identifier: " + id);
	}
}
		