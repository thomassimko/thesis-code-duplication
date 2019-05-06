import java.util.ArrayList;
import java.util.List;

public class VariableBindings
   implements Bindings
{
   private List<Binding> bindings = new ArrayList<Binding>();
   public void addBinding(String id, double value)
   {
      for(int i = 0; i < bindings.size(); i++)
      {
         if(bindings.get(i).getId().equals(id))
         {
            bindings.get(i).changeValue(value);
            return;
         }
      }
      bindings.add(new Binding(id, value));
   }
   public double lookupBinding(String id) throws UnboundIdentifierException
   {
      for(int i = 0; i < bindings.size(); i++)
      {
         if(bindings.get(i).getId().equals(id))
         {
            return bindings.get(i).getValue();
         }
      }
      throw new UnboundIdentifierException("unbound identifier: " + id);
   }
}