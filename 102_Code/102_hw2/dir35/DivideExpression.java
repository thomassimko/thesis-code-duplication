public class DivideExpression
implements Expression
{
private Expression left;
private Expression right;
   public DivideExpression(Expression lft, Expression rht){
      left = lft;
      right = rht;
   }
   public double evaluate(Bindings binding){
      double x = left.evaluate(binding);
      double y = right.evaluate(binding);
      double divide = x/y;
      return divide;
   }
   public String toString()
   {
	   return "(" + left + " / " + right + ")";
   }
}
