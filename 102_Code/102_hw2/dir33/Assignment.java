public class Assignment
   implements Operation
{
   private Expression e;
   private String id;
   public Assignment(String id, Expression e)
   {
      this.e = e;
      this.id = id;
   }
   public double evaluate(Bindings binding)
   {
      binding.addBinding(id, e.evaluate(binding));
      return e.evaluate(binding);
   }
}
