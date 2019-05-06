import java.util.List;
import java.util.ArrayList;

public class VariableBindings
   implements Bindings
{
   private List<Binding> bindingList;

   VariableBindings()
   {
      this.bindingList = new ArrayList<Binding>();
   }

   public void addBinding(String id, double value)
   {
      bindingList.add(new Binding(id, value));
   }

   public double lookupBinding(String id) 
      throws UnboundIdentifierException
   {
      int check = 0;
      double answer = 0.0;

      for(Binding binding : bindingList)
      {
         if (binding.getId().equals(id))
         {
            answer = binding.getValue();
            check = 1;
         }
      }

      if (check == 1)
         return answer;
      else
         throw new UnboundIdentifierException("unbound identifier: " + id);
   }
}
