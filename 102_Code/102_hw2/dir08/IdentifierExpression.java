public class IdentifierExpression
   implements Expression
{
   private String id;

   IdentifierExpression(String id)
   {
      this.id = id;
   }

   public double evaluate(Bindings binding)
   {
      return binding.lookupBinding(id);
   }

   public String toString()
   {
      return id;
   }
}
