import java.util.ArrayList;
import java.util.List;

public class VariableBindings
   implements Bindings
{
   List<Binding> bindlist = new ArrayList<Binding>();

   public void addBinding(String id, double value)
   {
      boolean found = false;
      for(int i = 0; i < bindlist.size(); i++)
      {
         if(id.equals(bindlist.get(i).getName()))
         {
            bindlist.set(i, new Binding(id, value));
            found = true;
         }
      }
      if(!found)
      {
         bindlist.add(new Binding(id, value));
      }
   }
   
   public double lookupBinding(String id) throws UnboundIdentifierException
   {
      for(int i = 0; i < bindlist.size(); i++)
      {
         if(bindlist.get(i).getName().equals(id))
         {
            return bindlist.get(i).getValue();
         }
      }
      throw new UnboundIdentifierException("unbound identifier: " + id);
   }
}
