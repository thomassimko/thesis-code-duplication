public class SubtractExpression 
   implements Expression
{
   private Expression l,r;
   public SubtractExpression(Expression lft, Expression rht)
   {
      this.l=lft;
      this.r=rht;
   }
   public double evaluate(Bindings binding)
   {
      return l.evaluate(binding)-r.evaluate(binding);
   }
   public String toString()
   {
      return "(" + l + " - " + r + ")";
   }
}