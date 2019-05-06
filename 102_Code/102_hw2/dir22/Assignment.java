/*Programmed by Michael Olivarez*/
public class Assignment implements Operation
{
   private String ID;
   private Expression exp;
   public Assignment(String id, Expression e)
   {
      this.ID = id;
      this.exp = e;
      
   }
   public double evaluate(Bindings binding)
   {
      Binding bin = new Binding(this.ID, this.exp.evaluate(binding));
      return this.exp.evaluate(binding); 
   }
   public String toString()
   {
      String str = "set " + this.ID + " = " + this.exp;
      return str;
   }
}
