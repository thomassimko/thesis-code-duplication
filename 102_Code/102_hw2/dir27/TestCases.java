public class TestCases
{
	public static void main (String[]args)
	{
	  
		Expression a = new DoubleConstantExpression(1.0);
		Check.check(a.evaluate(null), 1.0);
		Expression b = new DoubleConstantExpression(2.0);
		Check.check(b.evaluate(null), 2.0);
		Expression c = new DivideExpression(a, b);
		Check.check(c.evaluate(null), 0.5);
		
		Bindings d = new VariableBinding();
		d.addBinding("first", 2.0);
		d.addBinding("second", 3.0);
		Expression e = new DoubleConstantExpression(d.lookupBinding("first"));
		Expression f = new DoubleConstantExpression(d.lookupBinding("second"));
		Expression g = new AddExpression(e, f);
		Check.check(g.toString(), "(2.0 + 3.0)");
		d.addBinding("first", 5.0);
		Check.check(d.lookupBinding("first"), 5.0);
		Check.check(g.evaluate(null), 5.0);
		
		Operation h = new Assignment("third", g);
		Check.check(h.evaluate(d), 5.0);
		Check.check(d.lookupBinding("third"), 5.0);
		
		Expression i = new SubtractExpression(a, b);
		Check.check(i.evaluate(d), -1.0);
		
		Expression j = new MultiplyExpression(e, i);
		Check.check(j.evaluate(d), -2.0);
		
		Expression l = new MultiplyExpression(c, i);
		Expression m = new NegationExpression(a);
		Expression n = new AddExpression(l, m);
		Check.check(n.evaluate(d), -1.5);
		Check.check(n.toString(), "(((1.0 / 2.0) * (1.0 - 2.0)) + -1.0)");
		
		Expression o = new IdentifierExpression("fourth");
		h = new Assignment("fourth", o);
		Check.check(h.toString(), "set fourth = fourth");
		h = new Assignment("fourth", g);
		h.evaluate(d);
	   Check.check(d.lookupBinding("fourth"), 5.0);
		
	}
}