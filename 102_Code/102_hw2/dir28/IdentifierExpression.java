public class IdentifierExpression
   implements Expression
{
   private String s;
   public IdentifierExpression(String id)
   {
      this.s=id;
   }
   public double evaluate(Bindings bindings)
   {
      return bindings.lookupBinding(this.s);
   }
   public String toString()
   {
      return this.s;
   }
}