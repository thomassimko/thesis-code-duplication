public class SubtractExpression
implements Expression
{
private Expression left;
private Expression right;
   public SubtractExpression(Expression lft, Expression rht){
      left = lft;
      right = rht;
   }
   public double evaluate(Bindings binding){
      double x = left.evaluate(binding);
      double y = right.evaluate(binding);
	  double subtract;
      subtract = x - y;
      return subtract;
   }
   public String toString()
   {
	   return "(" + left + " - " + right + ")";
   }
}