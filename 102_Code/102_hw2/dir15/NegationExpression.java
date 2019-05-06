public class NegationExpression
   implements Expression 
{
   private Expression original;
   
   public NegationExpression(Expression e)
   {
      this.original = e;
   }
   
   public double evaluate(Bindings binding)
   {
      return -(original.evaluate(binding));
   }
   
   public String toString()
   {
      return "(" + " -" + original + ")";
   }
}