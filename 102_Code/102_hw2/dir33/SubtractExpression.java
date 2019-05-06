public class SubtractExpression
   implements Expression
{
   private Expression lft;
   private Expression rht;

   public String toString()
   {
      return "(" + lft.toString() + " - " + rht.toString() + ")";
   }
   
   public SubtractExpression(Expression lft, Expression rht)
   {
      this.lft = lft;
      this.rht = rht;
   }

   public double evaluate(Bindings binding)
   {
      return lft.evaluate(binding) - rht.evaluate(binding);
   }
}
