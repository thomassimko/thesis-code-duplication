public class IdentifierExpression
implements Expression
{
  public double evaluate(Binding bindings)
  {
    return bindings.value;
  }
}
