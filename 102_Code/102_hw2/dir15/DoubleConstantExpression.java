public class DoubleConstantExpression
   implements Expression
{
   private double Value;
   
   public DoubleConstantExpression(double value) 
   {
      this.Value = value;
   }
   
   public double evaluate(Bindings binding)
   {
      return Value;
   }
   
   public String toString()
   {
      return " " + Value;
   }
}