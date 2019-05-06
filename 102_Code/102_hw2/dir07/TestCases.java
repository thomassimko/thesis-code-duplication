
public class TestCases 
{
	public static void main(String[] args) 
	{
		Expression ex1 = new DoubleConstantExpression(1.0);
		Expression ex2 = new DoubleConstantExpression(2.0);
		Expression ex3 = new DoubleConstantExpression(-1.0);
		Expression ex4 = new DoubleConstantExpression(10.0);
		Expression ex5 = new DoubleConstantExpression(3.0);
		Expression ex6 = new DoubleConstantExpression(1.0/3.0);
		
		Bindings bind1 = new VariableBindings();
		Bindings bind2 = new VariableBindings();
		
		bind1.addBinding("x", 1.0);
		bind1.addBinding("a", -1.0);
		bind2.addBinding("y", 2.0);
		
		Check.check(bind1.lookupBinding("x"), 1.0);
		Check.check(bind1.lookupBinding("a"), -1.0);
		Check.check(bind2.lookupBinding("y"), 2.0);
		
		Check.check(ex1.evaluate(null), 1);
		Check.check(ex2.evaluate(null), 2);
		Check.check(ex3.evaluate(null), -1);
		Check.check(ex4.evaluate(null), 10);
		Check.check(ex5.evaluate(null), 3.0);
		Check.check(ex6.evaluate(null), 1.0/3.0);
		
		Check.check(new AddExpression(ex1, ex2).evaluate(null), 3);
		Check.check(new AddExpression(ex1, ex3).evaluate(null), 0);
		Check.check(new AddExpression(ex2, ex3).evaluate(null), 1);
		
		Check.check(new SubtractExpression(ex1, ex2).evaluate(null), -1);
		Check.check(new SubtractExpression(ex2, ex3).evaluate(null), 3);
		Check.check(new SubtractExpression(ex4, ex1).evaluate(null), 9);
		
		Check.check(new DivideExpression(ex1, ex3).evaluate(null), -1);
		Check.check(new DivideExpression(ex4, ex1).evaluate(null), 10);
		Check.check(new DivideExpression(ex1, ex5).evaluate(null), 1.0/3.0);
		
		Check.check(new MultiplyExpression(ex1, ex2).evaluate(null), 2);
		Check.check(new MultiplyExpression(ex3, ex4).evaluate(null), -10);
		Check.check(new MultiplyExpression(ex5, ex6).evaluate(null), 1);
	}

}
