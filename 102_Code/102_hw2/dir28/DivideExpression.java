public class DivideExpression 
   implements Expression
{
   private Expression l,r;
   public DivideExpression(Expression lft, Expression rht)
   {
      this.l=lft;
      this.r=rht;
   }
   public double evaluate(Bindings binding)
   {
      return l.evaluate(binding)/r.evaluate(binding);
   }
   public String toString()
   {
      return "(" + l + " / " + r + ")";
   }
}