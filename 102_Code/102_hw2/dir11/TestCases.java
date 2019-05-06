
public class TestCases
{
	public static void main(String [] args)
	{
		Expression d = new DoubleConstantExpression(2.31);
		Expression d2 = new DoubleConstantExpression(3.01);
		Expression n = new NegationExpression(new DoubleConstantExpression(2.0));
		Expression a = new AddExpression(d, d2);
		Expression s = new SubtractExpression(d, d2);
		Expression m = new MultiplyExpression(d, d2);
		Expression di = new DivideExpression(d, d2);
		
		Bindings var = new VariableBindings();
		var.addBinding("one", 1.0);
		var.addBinding("two", 2.0);
		
		Check.check(d.evaluate(null), 2.31);
		Check.check(d2.evaluate(null), 3.01);
		
		Check.check(n.evaluate(null), -2.0);
		
		Check.check(a.evaluate(null), 5.32);
		Check.check(s.evaluate(null), -0.7);
		Check.check(m.evaluate(null), 6.9531);
		Check.check(di.evaluate(null), 0.7674418605);
	
		Check.check(var.lookupBinding("one"), 1.0);
		Check.check(var.lookupBinding("two"), 2.0);
	}
}
