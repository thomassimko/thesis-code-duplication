import java.util.*;
public class VariableBindings
   implements Bindings
{
   List<Binding> binding_list = new ArrayList<Binding>();
   public VariableBindings()
   {
   }
   public void addBinding(String id, double value)
   {
     boolean found = false;
     for(int i=0; i < binding_list.size() && !found; i++)
     {
        if(binding_list.get(i).id().equals(id))
        {
           binding_list.set(i, new Binding(id, value));
           found = true;
        }
     }
     if(!found)
     {
        binding_list.add(new Binding(id, value));
     }
   }

   public double lookupBinding(String id)
   {
     for(int i=0; i < binding_list.size(); i++)
     {
        if(binding_list.get(i).id().equals(id))
        {
           return binding_list.get(i).value();
        }
     }
     throw new UnboundIdentifierException("unbound identifier: " + id);
   }
}
