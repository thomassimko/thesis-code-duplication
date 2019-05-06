import java.util.List;
import java.util.ArrayList;
public class VariableBindings
implements Bindings
{ List<Binding>values=new ArrayList<Binding>();

  public void addBinding(String id, double value)
  { Binding next= new Binding(id,value);
    values.add(next);
  }
  
  public double lookupBinding(String id)
	throws UnboundIdentifierException
  { for(int i=0;i<values.size();i++)
    { if(values.get(i).getname().equals(id))
      { return values.get(i).value;  }
	}
	throw new UnboundIdentifierException("unbound identifier: "+id);
  }

}
