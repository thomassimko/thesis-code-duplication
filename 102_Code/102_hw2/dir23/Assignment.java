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
      double a1 = this.e.evaluate(binding);
      binding.addBinding(this.id, a1);
      return a1;
   }
   
   public String toString()
   {
	   return "set " + id + " = " + e;
   }
}
