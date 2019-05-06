public class AddExpression implements Expression
{
   private Expression lfht, rht;
   public AddExpression(Expression lfht, Expression rht)
   {
      this.lfht = lfht;
      this.rht = rht;
   }
   public double evaluate(Bindings binding)
   {
      return(lfht.evaluate(binding) + rht.evaluate(binding));
   }
   public String toString()
   {
      return("(" + lfht.toString() + " + "  + rht.toString() + ")");
   }
}
