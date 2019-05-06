public class MultiplyExpression
  implements Expression
{
  private Expression lft;
  private Expression rht;

  public MultiplyExpression(Expression lft, Expression rht)
  {
    this.lft = lft;
    this.rht = rht;
  }

  public double evaluate(Bindings bindings)
  {
    return this.lft.evaluate(bindings) * this.rht.evaluate(bindings);
  }

  public String toString()
  {
    return "(" + this.lft.toString() + "*" + 
      this.rht.toString() + ")";
  }
}
