import java.util.ArrayList;

public class BindingList
   implements Bindings
{
   private ArrayList<Binding> bindingList = new ArrayList<Binding>();
	
   public BindingList()
   {
      
   }

   public void addBinding(String id, double value)
   {
      for(int i=0;i<bindingList.size();i++)
      {
         if(bindingList.get(i).getId().equals(id))
         {
            bindingList.set(i, (new Binding(id, value)));
	    return;
	 }
      }
      bindingList.add(new Binding(id, value));
   }
   
   public double lookupBinding(String id) throws UnboundIdentifierException
   {
      for(int i=0;i<bindingList.size();i++)
      {
         if(bindingList.get(i).getId().equals(id))
         {
            return bindingList.get(i).getValue();
         }
      }
      throw new UnboundIdentifierException("unbound identifier: " + id);
   }
}
