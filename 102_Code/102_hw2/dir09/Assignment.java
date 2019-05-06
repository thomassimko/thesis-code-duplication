public class Assignment
   implements Operation
{
   private String id;
   private Expression e;
	
   public Assignment(String id, Expression e)
   {
      this.id = id;
      this.e = e;
   }
	
   public double evaluate(Bindings binding)
   {
      double value = e.evaluate(binding);
      
      binding.addBinding(id, value);
      return value;
   }
	
   public String toString()
   {
      return "set " + id + " = " + e.toString();
   }
}

