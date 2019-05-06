public class NegationExpression
    implements Expression
{
    private Expression expression;
    public NegationExpression(Expression e)
    {
	this.expression = e;
    }
    public double evaluate(Bindings binding)
    {
	return -1 * expression.evaluate(binding);
    }
    public String toString()
    {
	return "-" + expression.toString();
    }
}