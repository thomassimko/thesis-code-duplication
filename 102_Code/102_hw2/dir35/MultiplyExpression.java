public class MultiplyExpression
implements Expression
{
private Expression left;
private Expression right;
   public MultiplyExpression(Expression lft, Expression rht){
      left = lft;
      right = rht;
   }
   public double evaluate(Bindings binding){
	  double x = left.evaluate(binding);
	  double y = right.evaluate(binding);
      double multiply;
      multiply = x * y;
      return multiply;
   }
   public String toString()
   {
	   return "(" + left + " * " + right + ")";
   }
}
