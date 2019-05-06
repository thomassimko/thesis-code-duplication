public class Assignment
    implements Operation
{
    private String ID;
    private Expression expr;
    public Assignment(String id, Expression e)
    {
	this.ID = id;
	this.expr = e;
    }
    public double evaluate(Bindings binding)
    {
	binding.addBinding(ID, expr.evaluate(binding));
	return expr.evaluate(binding);
    }
    public String toString()
    {
	return "set " + ID.toString() + " = " + expr;
    }
}