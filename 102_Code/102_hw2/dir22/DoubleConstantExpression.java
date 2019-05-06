/*Programmed by Michael Olivarez*/
public class DoubleConstantExpression
implements Expression
{
   private double num;
   public DoubleConstantExpression(double value)
   {
      this.num = value;
   }  
   public double evaluate(Bindings binding)
   {
      return this.num;
   }
   public String toString()
   {
      String str = this.num + "";
      return str;
   }
}
