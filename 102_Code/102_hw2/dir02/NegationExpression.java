public class NegationExpression implements Expression
{
   private Expression e;
   private Bindings tBind;
   public NegationExpression(Expression e)
   {
      this.e = e;
   }
   public double evaluate(Bindings binding)
   {
      this.tBind = binding;
      return(-1 * e.evaluate(binding));
   }
   public String toString()
   {
      return("" + -1 * e.evaluate(tBind));
   }
}
