public class Assignment
implements Operation
{
    private String ida;
    private Expression ea;

    public Assignment(String id, Expression e)
    {
	this.ida=id;
	this.ea=e;
    }

    public double evaluate(Bindings binding)
    {
	binding.addBinding(ida, ea.evaluate(binding));
	return binding.lookupBinding(ida);
    }
    
    public String toString()
    {
	return "set " +this.ida+ "=" +this.ea;
    }
}
