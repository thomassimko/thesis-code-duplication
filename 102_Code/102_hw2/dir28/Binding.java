public class Binding
{
   private String s;
   private double v;
   public Binding(String id, double value)
   {
      this.s=id;
      this.v=value;
   }
   public String getId()
   {
      return this.s;
   }
   public double getValue()
   {
      return this.v;
   }
   public void changeValue(double newValue)
   {
      this.v=newValue;
   }
}