public class DoubleConstantExpression
implements Expression
{
private double val;
   public DoubleConstantExpression(double value)
   {
      val = value;
   }
   public double evaluate(Bindings binding)
   {
	   return val;
   }
   public String toString()
   {
	   return "" + val;
   }
}
