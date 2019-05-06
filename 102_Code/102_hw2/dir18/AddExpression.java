public class AddExpression
    implements Expression
{
    private Expression left, right;
    public AddExpression(Expression lft, Expression rht)
    {
	this.left = lft;
	this.right = rht;
    }
    public double evaluate(Bindings binding)
    {
	return left.evaluate(binding) + right.evaluate(binding);
    }
    public String toString()
    {
	return "(" + left.toString() + " + " + right.toString() + ")";
    }
}