public class DoubleConstantExpression
   implements Expression
{
   private double x;

   DoubleConstantExpression(double value)
   {
      this.x = value;
   }

   public double evaluate(Bindings binding)
   {
      return x;
   }

   public String toString()
   {
      return Double.toString(x);
   }
}
