public class NegationExpression
implements Expression
{
private Expression exp;
   public NegationExpression(Expression e){
      exp= e;
   }
   public double evaluate(Bindings binding){
	  double x = exp.evaluate(binding);
      return -x;
   }
   public String toString()
   {
	   return "-" + exp;
   }
}
