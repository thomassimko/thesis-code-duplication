/*Programmed by Michael Olivarez*/
public class SubtractExpression
implements Expression
{
    private Expression left;
    private Expression right;
    public SubtractExpression(Expression lft, Expression rht)
    {
	this.left = lft;
	this.right = rht;
    }
    public double evaluate(Bindings binding)
    {
	return this.left.evaluate(binding) - this.right.evaluate(binding);
    }
    public String toString()
    {
       String str = "(" + this.left + " - " + this.right + ")";
       return str;
    }
}
