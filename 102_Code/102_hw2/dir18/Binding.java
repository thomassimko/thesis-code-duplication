public class Binding
{
    private String ID;
    private double value;
    public Binding(String id, double value)
    {
	this.ID = id;
	this.value = value;
    }
    public String getVariable()
    {
	return ID;
    }
    public double getValue()
    {
	return value;
    }
}