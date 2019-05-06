public class Assignment
  implements Operation
{
  private String id;
  private Expression e;

  public Assignment(String id, Expression e)
  {
    this.id = id;
    this.e = e;
  }

  public double evaluate(Bindings bindings)
  {
    bindings.addBinding(id, e.evaluate(bindings));

    return e.evaluate(bindings);
  }

  public String toString()
  {
    return "set " + id + " = " + e.toString();
  }
}
