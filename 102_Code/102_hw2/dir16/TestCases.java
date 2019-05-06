public class TestCases
{
	public static void testDoubleConstantExpression(Bindings bindings)
	{
		Expression doub1 = new DoubleConstantExpression(1.0);
		Expression doub2 = new DoubleConstantExpression(10);
		Expression doub3 = new DoubleConstantExpression(-99.99);
		Check.check(doub1.evaluate(bindings), 1.0);
		Check.check(doub2.evaluate(bindings), 10.0);
		Check.check(doub3.evaluate(bindings), -99.99);
	}
	
	public static void testNegationExpression(Bindings bindings)
	{
		Expression neg1 = new NegationExpression(new DoubleConstantExpression(10.0));
		Expression neg2 = new NegationExpression(new DoubleConstantExpression(2.2222));
		Expression neg3 = new NegationExpression(new DoubleConstantExpression(-31.1));
		Check.check(neg1.evaluate(bindings), -10);
		Check.check(neg2.evaluate(bindings), -2.2222);
		Check.check(neg3.evaluate(bindings), 31.1);
	}
	
	public static void testAddExpression(Bindings bindings)
	{
		Expression add1 = new AddExpression(new DoubleConstantExpression(1),new DoubleConstantExpression(2));
		Expression add2 = new AddExpression(new DoubleConstantExpression(10.1),new DoubleConstantExpression(20.2));
		Expression add3 = new AddExpression(new DoubleConstantExpression(-1),new DoubleConstantExpression(-2));
		Check.check(add1.evaluate(bindings), 3);
		Check.check(add2.evaluate(bindings), 30.3);
		Check.check(add3.evaluate(bindings), -3);
	}
	
	public static void testSubtractExpression(Bindings bindings)
	{
		Expression sub1 = new SubtractExpression(new DoubleConstantExpression(1),new DoubleConstantExpression(2));
		Expression sub2 = new SubtractExpression(new DoubleConstantExpression(50),new DoubleConstantExpression(25.5));
		Expression sub3 = new SubtractExpression(new DoubleConstantExpression(2.2),new DoubleConstantExpression(10.2));
		Check.check(sub1.evaluate(bindings), -1);
		Check.check(sub2.evaluate(bindings), 24.5);
		Check.check(sub3.evaluate(bindings), -8);
	}
	
	public static void testMultiplyExpression(Bindings bindings)
	{
		Expression mult1 = new MultiplyExpression(new DoubleConstantExpression(1),new DoubleConstantExpression(2));
		Expression mult2 = new MultiplyExpression(new DoubleConstantExpression(10),new DoubleConstantExpression(-20));
		Expression mult3 = new MultiplyExpression(new DoubleConstantExpression(1.2),new DoubleConstantExpression(1.2));
		Check.check(mult1.evaluate(bindings), 2);
		Check.check(mult2.evaluate(bindings), -200);
		Check.check(mult3.evaluate(bindings), 1.44);
	}
	
	public static void testDivideExpression(Bindings bindings)
	{
		Expression div1 = new DivideExpression(new DoubleConstantExpression(1),new DoubleConstantExpression(2));
		Expression div2 = new DivideExpression(new DoubleConstantExpression(-10),new DoubleConstantExpression(20));
		Expression div3 = new DivideExpression(new DoubleConstantExpression(5.5),new DoubleConstantExpression(1.1));
		Check.check(div1.evaluate(bindings), 0.5);
		Check.check(div2.evaluate(bindings), -0.5);
		Check.check(div3.evaluate(bindings), 5);
	}

	public static void testBinding()
	{
		Binding bind1 = new Binding("a", 10);
		Binding bind2 = new Binding("abc", -10);
		Binding bind3 = new Binding("cat", 1.1);
		Check.check(bind1.getId(), "a");
		Check.check(bind2.getId(), "abc");
		Check.check(bind3.getId(), "cat");
		Check.check(bind1.getValue(), 10);
		Check.check(bind2.getValue(), -10);
		Check.check(bind3.getValue(), 1.1);
	}

	public static void testVariableBindings(Bindings bindings)
	{
		bindings.addBinding("cats", 100);
		bindings.addBinding("a", 2.2);
		Check.check(bindings.lookupBinding("cats"), 100);
		Check.check(bindings.lookupBinding("a"), 2.2);
		bindings.addBinding("a", -1.1);
		bindings.addBinding("cats", 991231);
		Check.check(bindings.lookupBinding("a"), -1.1);
		Check.check(bindings.lookupBinding("cats"), 991231);
	}
	
	public static void testAssignment(Bindings bindings)
	{
		Operation asgn1 = new Assignment("a", new DoubleConstantExpression(10));
		Operation asgn2 = new Assignment("b", new MultiplyExpression(new DoubleConstantExpression(10), new DoubleConstantExpression(2.2)));
		Operation asgn3 = new Assignment("a", new AddExpression(new DoubleConstantExpression(-1.2), new DoubleConstantExpression(-6.07)));
		Check.check(asgn1.evaluate(bindings), 10);
		Check.check(asgn2.evaluate(bindings), 22);
		Check.check(asgn3.evaluate(bindings), -7.27);
	}
	
	public static void testIdentifierExpression(Bindings bindings)
	{
		Expression id1 = new IdentifierExpression("a");
		Expression id2 = new IdentifierExpression("b");
		Expression id3 = new IdentifierExpression("cats");
		Check.check(id1.evaluate(bindings), -7.27);
		Check.check(id2.evaluate(bindings), 22);
		Check.check(id3.evaluate(bindings), 991231);
	}
	
	public static void main(String [] args)
	{
		Bindings bindings = new VariableBindings();
		
		testDoubleConstantExpression(bindings);
		testNegationExpression(bindings);
		testAddExpression(bindings);
		testSubtractExpression(bindings);
		testMultiplyExpression(bindings);
		testDivideExpression(bindings);
		
		testBinding();
		testVariableBindings(bindings);
		testAssignment(bindings);
		testIdentifierExpression(bindings);
	}
}
