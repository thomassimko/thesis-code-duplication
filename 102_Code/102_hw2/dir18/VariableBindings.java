import java.util.ArrayList;
import java.util.List;

public class VariableBindings
    implements Bindings
{
    private List<Binding> list = new ArrayList<Binding>();

    public void addBinding(String id, double value)
    {
	boolean found = false;
	for(int i=0; i < list.size(); i++)
	{
	    if(id.equals(list.get(i).getVariable())){
		list.set(i, new Binding(id, value));
		found = true;
	    }
	}
	if(!found){
	    list.add(new Binding(id, value));
	}
    }

    public double lookupBinding(String id) throws UnboundIdentifierException
    {
	for(int i = 0; i < list.size(); i++){
	    if(id.equals(list.get(i).getVariable())){
		return list.get(i).getValue();
	    }
	}
	throw new UnboundIdentifierException("unbound identifier: " + id);
    }
}