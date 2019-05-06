public class TestCases
{
    private static void tests()
    {
	Expression expr1 = new DoubleConstantExpression(1.0);
	Expression expr2 = new DoubleConstantExpression(2.0);
	Expression expr3 = new DoubleConstantExpression(3.0);

	Bindings bind1 = new VariableBindings();
	Bindings bind2 = new VariableBindings();
	Bindings bind3 = new VariableBindings();

	bind1.addBinding("x", 1.0);
	bind2.addBinding("y", 2.0);
	bind3.addBinding("z", 3.0);

	Check.check(bind1.lookupBinding("x"), 1.0);
	Check.check(bind2.lookupBinding("y"), 2.0);
	Check.check(bind3.lookupBinding("z"), 3.0);

	Check.check(expr1.evaluate(null), 1);

	Check.check(new AddExpression(expr1, expr2).evaluate(null), 3);
	Check.check(new AddExpression(expr1, expr3).evaluate(null), 4);
	Check.check(new AddExpression(expr2, expr3).evaluate(null), 5);

	Check.check(new SubtractExpression(expr1, expr2).evaluate(null), -1);
	Check.check(new SubtractExpression(expr1, expr3).evaluate(null), -2);
	Check.check(new SubtractExpression(expr3, expr2).evaluate(null), 1);

	Check.check(new MultiplyExpression(expr1, expr2).evaluate(null), 2);
	Check.check(new MultiplyExpression(expr1, expr3).evaluate(null), 3);
	Check.check(new MultiplyExpression(expr3, expr2).evaluate(null), 6);

	Check.check(new DivideExpression(expr1, expr2).evaluate(null), .5);
	Check.check(new DivideExpression(expr1, expr3).evaluate(null), 1.0/3.0);
	Check.check(new DivideExpression(expr3, expr2).evaluate(null), 1.5);


    }

    public static void main(String [] args)
    {
	tests();
    }
}