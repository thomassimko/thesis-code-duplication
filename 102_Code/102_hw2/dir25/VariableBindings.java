import java.util.ArrayList;
import java.util.List;
public class VariableBindings implements Bindings {
	List<Binding> bindings = new ArrayList<Binding>();
	

	@Override
	public void addBinding(String id, double value) {
		// TODO Auto-generated method stub
		int done = 0;
		
		if (bindings.size() > 0)
		{
			for (int i = 0; i < bindings.size() && done != 1; i++)
			{
				
				if (bindings.get(i).getString().equals(id) )
				{
					Binding bind = new Binding(id, value);
					bindings.set(i, bind);
					done = 1;
				}
				
			}
			if (done == 0)
			{ 
				Binding bind = new Binding(id, value);
				bindings.add(bind);
			}
		}
		else
		{
			Binding bind = new Binding(id, value);
			bindings.add(bind);
			
		}
		
	}

	@Override
	public double lookupBinding(String id) throws UnboundIdentifierException {
		// TODO Auto-generated method stub
		for (int i = 0; i < bindings.size(); i++)
		{
			if ( bindings.get(i).getString().equals(id) )
			{
				return bindings.get(i).getValue();
			}
		}
		throw new UnboundIdentifierException("unbound identifier: " + id);
	}

}
