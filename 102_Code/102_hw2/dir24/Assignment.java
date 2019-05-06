import java.util.List;
import java.util.ArrayList;

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
      binding.addBinding(this.id, this.e.evaluate(binding));
      return this.e.evaluate(binding);
   }
   
   public String toString()
   {
      return "set " + id + " = " + e;
   }
}
