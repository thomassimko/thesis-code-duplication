public class DoubleConstantExpression
implements Expression
{ double number;

  public DoubleConstantExpression(double value)
  {	this.number=value;  }

  public double evaluate(Binding bindings)
  { bindings.value=this.number;
	return bindings.value;
  }
}
