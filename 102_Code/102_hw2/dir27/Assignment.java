public class Assignment
	implements Operation
{
	private String name;
	private Expression value;
	public Assignment(String id, Expression e)
	{
		this.name = id;
		this.value = e;
	}
	public double evaluate(Bindings binding)
	{
		binding.addBinding(this.name, value.evaluate(binding));
		return value.evaluate(binding);
	}
	public String toString()
	{
		return "set " + this.name + " = " + this.value.toString();
	}
}