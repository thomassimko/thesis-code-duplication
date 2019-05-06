public class MultiplyExpression
   implements Expression
{
   private Expression left;
   private Expression right;
   
   public MultiplyExpression(Expression lft, Expression rht)
   {
      this.left = lft;
      this.right = rht;
   }
   
   public double evaluate(Bindings binding)
   {
      return this.left.evaluate(binding) * this.right.evaluate(binding);
   }
   
   public String toString()
   {
      return "(" + this.left + " * " + this.right + ")";
   }
}
