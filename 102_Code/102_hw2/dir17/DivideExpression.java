public class DivideExpression
  implements Expression
{
  private Expression lft;
  private Expression rht;

  public DivideExpression(Expression lft, Expression rht)
  {
    this.lft = lft;
    this.rht = rht;
  }

  public double evaluate(Bindings binding)
  {
    return this.lft.evaluate(binding) / this.rht.evaluate(binding);
  }

  public String toString()
  {
    return "(" + this.lft.toString() + "/" + this.rht.toString()
      + ")";
  }
}
