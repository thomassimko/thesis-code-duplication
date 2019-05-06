public class SubtractExpression
   implements Expression
{
   private Expression e1;
   private Expression e2;

   SubtractExpression(Expression lft, Expression rht)
   {
      this.e1 = lft;
      this.e2 = rht;
   }

   public double evaluate(Bindings binding)
   {
      return e1.evaluate(binding) - e2.evaluate(binding);
   }

   public String toString()
   {
      return "(" + e1.toString() + " - " + e2.toString() + ")";
   }
}
