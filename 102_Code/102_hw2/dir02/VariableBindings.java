import java.util.*;
import java.util.ArrayList;
public class VariableBindings implements Bindings 
{
   private List<Binding> bindings;
   public VariableBindings()
   {
      this.bindings = new ArrayList<Binding>();
   }
   public void addBinding(String id, double value)
   {
      boolean flag = true;
      int i = 0;
      while((i < bindings.size()) && (flag) && (bindings.size() != 0))
      {
         if(id.equals(bindings.get(i).returnBind()))
         {
            flag = false;
         }
         i++;
      }
      if(flag)
      {
         bindings.add(new Binding(id, value));   
      }
      else
      {
         bindings.set(i - 1, new Binding(id, value));
      }
   } 
   public double lookupBinding(String id) 
   {
      int i = 0;
      double boundNum = 0;
      boolean flag = true;
      while((i < bindings.size()) && flag)
      {
         if(id.equals(bindings.get(i).returnBind()))
         {
            boundNum = (bindings.get(i)).returnDbl();
            flag = false;
         }   
         i++;
      }
      if(flag)
      {
         throw new UnboundIdentifierException("undbound identifier: " + id);
      }
      return (boundNum);
   }
}
