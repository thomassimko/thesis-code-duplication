public class NegationExpression
  implements Expression
{
  private Expression expression;

  public NegationExpression(Expression e)
  {
    this.expression = e;
  }

  public double evaluate(Bindings bindings)
  {
    return -1 * this.expression.evaluate(bindings);
  }

  public String toString()
  {
    return "(-" + this.expression.toString() + ")";
  }
}
