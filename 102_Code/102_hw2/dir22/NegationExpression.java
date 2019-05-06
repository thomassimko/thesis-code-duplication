/*Programmed by Michael Olivarez*/
public class NegationExpression
implements Expression
{
   private Expression exp;
   public NegationExpression(Expression e)
   {
      this.exp = e;
   }
   public double evaluate(Bindings binding)
   {
       return 0 - this.exp.evaluate(binding);
   } 
   public String toString()
   {
      String str = "-" + this.exp;
      return str;
   } 
}
