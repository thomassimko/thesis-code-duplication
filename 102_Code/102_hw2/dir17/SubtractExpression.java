public class SubtractExpression
  implements Expression
{
  private Expression lft;
  private Expression rht;

  public SubtractExpression(Expression lft, Expression rht)
  {
    this.lft = lft;
    this.rht = rht;
  }

  public double evaluate(Bindings binding)
  {
    return this.lft.evaluate(binding) - this.rht.evaluate(binding);
  }

  public String toString()
  {
    return "(" + this.lft.toString() + "-" + this.rht.toString()
      + ")";
  }
}
