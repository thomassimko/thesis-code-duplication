public class NegationExpression
   implements Expression
{
   private Expression e;

   public NegationExpression(Expression e)
   {
      this.e = e;
   }
   
   public double evaluate(Bindings binding)
   {
      return (-1) * this.e.evaluate(binding);
   }
   
   public String toString()
   {
      return "-" + this.e.toString();
   }
}
