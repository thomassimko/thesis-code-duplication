/*Programmed by Michael Olivarez*/
public class IdentifierExpression
implements Expression
{ 
   private String ID;
   public IdentifierExpression(String id)
   {
      this.ID = id;
   }
   public double evaluate(Bindings binding)
   {
     return binding.lookupBinding(this.ID);
   }
   public String toString()
   {
      return this.ID;
   }
}
