public class IdentifierExpression
   implements Expression 
{
   private String id;
   private double value;
   
   public IdentifierExpression(String id) 
   {
      this.value = value;
      this.id = id;
   }
   
   public double evaluate(Bindings binding)
   {
      return binding.lookupBinding(id);
   }
   
   public String toString()
   {
      return " " + id;
   }
}