import java.util.ArrayList;
import java.util.List;

public class VariableBindings
    implements Bindings
{
	private List bindingList;
	
   public VariableBindings()
   {
	   bindingList = new ArrayList<Binding>();
   }
   
   public void addBinding(String id, double value)
   {
	   bindingList.add(new Binding(id, value));
   }
   
    public double lookupBinding(String id) throws UnboundIdentifierException
    {
    	for(int i=0; i<bindingList.size(); i++)
    	{
    		Binding b1 = (Binding) bindingList.get(i);
    		String s1 = b1.getId();
    		
    		if(id.equals(s1))
    		{
    			return b1.getValue();
    		}
    	}
    	throw new UnboundIdentifierException("unbound identifier: " + id);
    }
}
