public class DoubleConstantExpression
   implements Expression
{
   private double v;
   public DoubleConstantExpression(double value)
   {
      this.v=value;
   }
   public double evaluate(Bindings binding)
   {
      return v;
   }
   public String toString()
   {
      return Double.toString(v);
   }
}