public class NegationExpression
implements Expression
{
  double here;
  public NegationExpression(Expression e)
  { Binding rar=new Binding("nam",2);
    here=(-1)*e.evaluate(rar);
  }
  public double evaluate(Binding bindings)
  { bindings.value=here;
	return bindings.value;
  }

}
