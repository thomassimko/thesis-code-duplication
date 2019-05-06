public class MultiplyExpression 
   implements Expression
{
   private Expression lft;
   private Expression rht;
   
   public MultiplyExpression(Expression lft, Expression rht) 
   {
      this.lft = lft;
      this.rht = rht;
   }
   
   public double evaluate(Bindings binding)
   {
      return lft.evaluate(binding) * rht.evaluate(binding);
   }
   
   public String toString()
   {
      return "(" + lft.toString() + " * " + rht.toString() + ")";
   }
}