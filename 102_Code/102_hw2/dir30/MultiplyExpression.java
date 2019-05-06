public class MultiplyExpression
implements Expression
{ Expression left,right;
  public MultiplyExpression(Expression lft,Expression rht)
  { left=lft;
    right=rht;
  }
  
  public double evaluate(Binding bindings)
  { bindings.value=left.evaluate(bindings)*right.evaluate(bindings);
	return bindings.value;
  }

}
