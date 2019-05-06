public class Assignment 
   implements Operation
{
   private String var;
   private Expression expression;
   public Assignment(String id, Expression e)
   {
      this.var=id;
      this.expression=e;
   }
   public double evaluate(Bindings binding)
   {
      binding.addBinding(var, expression.evaluate(binding));
      return binding.lookupBinding(var);
   }
   public String toString()
   {
      return "set " + this.var + " = " + this.expression;
   }
}