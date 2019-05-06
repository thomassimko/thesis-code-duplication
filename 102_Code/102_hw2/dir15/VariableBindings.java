import java.util.List;
import java.util.ArrayList;

public class VariableBindings 
   implements Bindings
{
   private List<Binding> bindingList;
   
   public VariableBindings() 
   {
      bindingList = new ArrayList<Binding>();
   }
   
   public void addBinding(String id, double value)
   {
      Binding binding = new Binding(id, value);
      
      bindingList.add(0, binding);
   }
   
   public double lookupBinding(String id)
   {
      for (int i = 0; i<bindingList.size(); i++) 
      {
         Binding tmp = bindingList.get(i);
         
         if(tmp.getID().equals(id))
         {
            return tmp.getValue();
         }
      }
      throw new UnboundIdentifierException("unbound identifier: " + id);
   }
}