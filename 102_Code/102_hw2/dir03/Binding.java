public class Binding
{
    private double val;
    private String i;

    public Binding(String id, double value)
    {
	this.i=id;
	this.val=value;
    }
    
    public String getId()
    {
      return this.i;
    }
    
    public double getValue()
    {
      return this.val;
    }
}
