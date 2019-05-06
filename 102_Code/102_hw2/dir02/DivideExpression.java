public class DivideExpression implements Expression
{
   private Expression lfht, rht;
   public DivideExpression(Expression lfht, Expression rht)
   { 
      this.lfht = lfht;
      this.rht = rht;
   }
   public double evaluate(Bindings binding)
   {
      return(lfht.evaluate(binding) / rht.evaluate(binding));
   }
   public String toString()
   {
      return("(" + lfht.toString() + " / " + rht.toString() + ")");
   }
}
