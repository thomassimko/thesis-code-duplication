public class IdentifierExpression
   implements Expression
{
   private String id;

   public IdentifierExpression(String id)
   {
      this.id = id;
   }

   public double evaluate(Bindings binding)
   {
      return binding.lookupBinding(this.id);
   }
   
   public String toString()
   {
      return this.id;
   }
}
