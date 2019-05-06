public class TestCases 
{	
	public static void main(String[] args) 
	{
		VariableBindings bindings = new VariableBindings();
		
		checkDoubleConstant(bindings);
		checkNegation(bindings);
		checkAdd(bindings);
		checkSubtract(bindings);
		checkMultiply(bindings);
		checkDivide(bindings);
		checkAssignment(bindings);
	}

	private static void checkAssignment(Bindings bindings) 
	{
		Expression e = new DoubleConstantExpression(2);
		Expression e2 = new DoubleConstantExpression(3);
		Expression e3 = new AddExpression(e,e2);
		Assignment a = new Assignment("a",e);
		Assignment b = new Assignment("b",e2);
		Assignment c = new Assignment("c",e3);

		
		Expression f = new IdentifierExpression("a");
		Expression f2 = new IdentifierExpression("b");
		Expression f3 = new IdentifierExpression("c");
		
		Check.check(a.evaluate(bindings), 2);
		Check.check(b.evaluate(bindings), 3);
		Check.check(c.evaluate(bindings), 5);
		
		Check.check(f.evaluate(bindings), 2);
		Check.check(f2.evaluate(bindings), 3);
		Check.check(f3.evaluate(bindings), 5);

		Assignment d = new Assignment("a", e3);
		
		Check.check(d.evaluate(bindings), 5);
		Check.check(f.evaluate(bindings), 5);

		Expression e4 = new AddExpression(f,e);
		Assignment d2 = new Assignment("a", e4);
		Check.check(d2.evaluate(bindings), 7);
	}

	private static void checkDivide(Bindings bindings) 
	{
		Expression a = new DoubleConstantExpression(2);
		Expression b = new DoubleConstantExpression(3);
		Expression c = new DoubleConstantExpression(6);
		Expression d = new AddExpression(a,c);
		Expression f = new SubtractExpression(c,a);
		
		Expression e = new DivideExpression(c,a);
		Expression e2 = new DivideExpression(c,b);
		Expression e3 = new DivideExpression(d,a);
		Expression e4 = new DivideExpression(d,f);
		
		Check.check(e.evaluate(bindings), 3);
		Check.check(e2.evaluate(bindings), 2);
		Check.check(e3.evaluate(bindings), 4);
		Check.check(e4.evaluate(bindings), 2);
	}

	private static void checkMultiply(Bindings bindings) 
	{
		Expression a = new DoubleConstantExpression(2);
		Expression b = new DoubleConstantExpression(3);
		Expression c = new DoubleConstantExpression(5);
		Expression d = new AddExpression(a,b);
		
		Expression e = new MultiplyExpression(a,b);
		Expression e2 = new MultiplyExpression(a,c);
		Expression e3 = new MultiplyExpression(c,d);
		Expression e4 = new MultiplyExpression(d,c);
		
		Check.check(e.evaluate(bindings), 6);
		Check.check(e2.evaluate(bindings), 10);
		Check.check(e3.evaluate(bindings), 25);
		Check.check(e4.evaluate(bindings), 25);
	}

	private static void checkSubtract(Bindings bindings) 
	{
		Expression a = new DoubleConstantExpression(2);
		Expression b = new DoubleConstantExpression(3);
		Expression e = new SubtractExpression(a,b);
		Expression e2 = new SubtractExpression(b,a);
		
		Check.check(e.evaluate(bindings), -1);
		Check.check(e2.evaluate(bindings), 1);
	}
	
	private static void checkAdd(Bindings bindings) 
	{
		Expression a = new DoubleConstantExpression(2);
		Expression b = new DoubleConstantExpression(3);
		Expression e = new AddExpression(a,b);
		
		Check.check(e.evaluate(bindings), 5);
	}
	
	private static void checkNegation(Bindings bindings) 
	{
		Expression a = new DoubleConstantExpression(2);
		Expression e = new NegationExpression(a);
		
		Check.check(e.evaluate(bindings), -2.0);
	}

	private static void checkDoubleConstant(Bindings bindings) 
	{
		Expression e = new DoubleConstantExpression(2);
		
		Check.check(e.evaluate(bindings), 2.0);
	}

}
