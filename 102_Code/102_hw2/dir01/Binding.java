
public class Binding {
	private String id;
	private double value;
	
	public Binding(String id, double value)
	{
		this.id = id;
		this.value = value;
	}
	public String name()
	{
		return this.id;
	}
	public double val()
	{
		return this.value;
	}
	public void setVal(double value)
	{
		this.value = value;
	}
}
