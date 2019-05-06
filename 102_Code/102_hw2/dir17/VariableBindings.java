import java.util.List;
import java.util.ArrayList;

public class VariableBindings
  implements Bindings
{
  List<Binding> bindings;

  public VariableBindings()
  {
    bindings = new ArrayList<Binding>();
  }

  public void addBinding(String id, double value)
  {
    int index = searchBindings(id);

    if(index>=0)
      bindings.set(index, new Binding(id, value));
    else
      bindings.add( new Binding(id, value) );
  }

  public double lookupBinding(String id)
  {
    Binding b;
    int index = searchBindings(id);

    if(index>=0)
      return bindings.get(index).value();
    else
      throw new UnboundIdentifierException("Unbound identifier" + id);
  }

  private int searchBindings(String id)
  {
    Binding b;

    for(int i=0; i<bindings.size(); i++)
    {
      b = bindings.get(i);

      if( b.id().equals(id) )
      {
        return i;
      }
    }
    return -1;
  }
}
