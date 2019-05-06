public class AddExpression
implements Expression
{
private Expression left;
private Expression right;
   public AddExpression(Expression lft, Expression rht){
      left = lft;
      right = rht;
   }
   public double evaluate(Bindings binding){
	  double x = left.evaluate(binding);
	  double y = right.evaluate(binding);      
	  double add;
      add = x + y;
      return add;
   }
   public String toString()
   {
	   return "(" + left + " + " + right + ")";
   }
}
