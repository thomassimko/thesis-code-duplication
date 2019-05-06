//Programmed by Michael Olivarez
public class Binding
{
    private String ID;
    private double Val;
    public Binding(String id, double value)
    {
	this.ID = id;
	this.Val = value;
    }
    public void setstring(String name)
    {
	this.ID = name;
    }
    public void setvalue(double num)
    {
	this.Val = num;
    }
    public String getstr()
    {
	return this.ID;
    }
    public double getval()
    {
	return this.Val;
    }
}
