public class Assignment
   implements Operation
{
   private String id;
   private Expression e;

   Assignment(String id, Expression e)
   {
      this.id = id;
      this.e = e;
   }

   public double evaluate(Bindings binding)
   {
      binding.addBinding(id, e.evaluate(binding));

      return binding.lookupBinding(id);
   }

   public String toString()
   {
      return "set " + id + " = " + e.toString();
   }
}
