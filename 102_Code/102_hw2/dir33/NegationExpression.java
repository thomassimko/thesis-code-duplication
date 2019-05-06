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
      return e.evaluate(binding)*(-1);
   }
}
