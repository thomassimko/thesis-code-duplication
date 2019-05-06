public class Assignment
implements Operation
{
private String variable;
private Expression exp;

   public Assignment(String id, Expression e)
   {
      variable = id;
      exp = e;
   }
   public double evaluate(Bindings bindings)
   {
	  double result = exp.evaluate(bindings);
      bindings.addBinding(variable, result);
      return result;
   }
   public String toString()
   {
	   return "set " + variable + " = " + exp;
   }
}