
public class TestCases {

	public static void main(String[] args) {
		Bindings a = new VariableBindings();
		Bindings b = new VariableBindings();
		Bindings pi = new VariableBindings();
		
		Expression e = new DoubleConstantExpression(5.5);
		Expression f = new DoubleConstantExpression(9.8);
		Expression g = new DoubleConstantExpression(-1.2);
		Expression h = new DoubleConstantExpression(5);
		Expression i = new DoubleConstantExpression(0);
		
		String s1 = "string";
		String s2 = "a";
		
		a.addBinding("a", 5.5);
		b.addBinding("string", -1.2);
		pi.addBinding("a", 3.14);
		
		Check.check(new DoubleConstantExpression(10).evaluate(null), 10);
		Check.check(new DoubleConstantExpression(5.5).evaluate(a), 5.5);
		Check.check(new DoubleConstantExpression(-1.2).evaluate(b), -1.2);
		Check.check(new DoubleConstantExpression(10).toString(), "10.0");
		
		Check.check(new NegationExpression(e).evaluate(null), -5.5);
		Check.check(new NegationExpression(g).evaluate(b), 1.2);
		Check.check(new NegationExpression(new DoubleConstantExpression(0)).evaluate(null), 0);
		Check.check(new NegationExpression(e).toString(), "-5.5");
		
		Check.check(new AddExpression(e, f).evaluate(a), 15.3);
		Check.check(new AddExpression(e, f).toString(), "(5.5 + 9.8)");
		Check.check(new AddExpression(f, g).evaluate(null), 8.6);
		
		Check.check(new SubtractExpression(g, f).evaluate(null), -11.0);
		Check.check(new SubtractExpression(e, g).evaluate(a), 6.7);
		Check.check(new SubtractExpression(f, e).evaluate(null), 4.3);
		
		Check.check(new MultiplyExpression(e, f).evaluate(a), 53.9);
		Check.check(new MultiplyExpression(e, g).evaluate(null), -6.6);
		
		Check.check(new DivideExpression(e, h).evaluate(a), 1.1);
		Check.check(new DivideExpression(i, h).evaluate(null), 0);
		
		Check.check(a.lookupBinding("a"), 5.5);
		Check.check(b.lookupBinding("string"), -1.2);
		Check.check(pi.lookupBinding("a"), 3.14);
		
		Check.check(new IdentifierExpression(s1).evaluate(b), -1.2);
		Check.check(new IdentifierExpression(s2).evaluate(a), 5.5);
		Check.check(new IdentifierExpression(s1).toString(), "string");
		
		Check.check(new Assignment(s2, e).evaluate(a), 5.5);
		Check.check(new Assignment(s1, g).evaluate(b), -1.2);
		
		Check.check(new Binding(s2, 2.72).getString(), s2);
		Check.check(new Binding(s1, 31.59).getValue(), 31.59);
	}

}
