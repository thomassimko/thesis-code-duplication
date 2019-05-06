public class DivideExpression
implements Expression
{ Expression left,right;
  public DivideExpression(Expression lft,Expression rht)
  { right=rht;
    left=lft;
  }
  
  public double evaluate(Binding bindings)
  { bindings.value=left.evaluate(bindings)/right.evaluate(bindings);
	return bindings.value;
  }

}
