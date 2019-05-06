public class SubtractExpression
   implements Expression
{
   private Expression left, right;

   public SubtractExpression(Expression left, Expression right)
   {
      this.left = left;
      this.right = right;
   }

   public double evaluate(Bindings binding)
   {
      return left.evaluate(binding) - right.evaluate(binding);
   }
	
	public String toString()
	{
	   return "(" + left.toString() + " - " + right.toString() + ")";
	}
}

