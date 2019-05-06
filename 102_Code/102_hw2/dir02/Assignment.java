public class Assignment implements Operation
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
      binding.addBinding(id, e.evaluate(binding));
      return(e.evaluate(binding));      
   }
   public String toString()
   {
      return("set " + this.id);
   }
}
