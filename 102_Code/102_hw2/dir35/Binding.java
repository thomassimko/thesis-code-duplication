public class Binding
{
private String variable;
private double val;
   public Binding(String id, double value)
   {
      variable = id;
      val = value;
   }
   public double getValue()
   {
      return val;
   }
   public String getId()
   {
	   return variable;
   }
}