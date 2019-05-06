public class Binding
{
  private String id;
  private double value;

  public Binding(String name, double value)
  {
    this.id = name;
    this.value = value;
  }

  public String id()
  {
    return this.id;
  }

  public double value()
  {
    return this.value;
  }
}
