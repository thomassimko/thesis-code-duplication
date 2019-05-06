public class Binding
{
   private String id;
   private double value;

   public Binding(String id, double value)
   {
      this.id = id;
      this.value = value;
   }
   
   public String getId()
   {
      return id;
   }
   
   public double getValue()
   {
      return value;
   }
}

