public class Binding
{
   private String id;
   private double value;

   public Binding(String id, double value)
   {
      this.id = id;
      this.value = value;
   }
   public String id()
   {
      return id;
   }
   public double value()
   {
      return value;
   } 
}
