public class TestCases
{
    public static void main(String [] args)
    {
	Expression  e1 = new DoubleConstantExpression(10);
	Expression  e2 = new DoubleConstantExpression(20);

	Bindings b1 = new VariableBindings();

	b1.addBinding("test1", 10.0);
	Check.check(b1.lookupBinding("test1"), 10.0 );

	Check.check(e1.evaluate(null), 10);

	Check.check(new AddExpression(e1, e2).evaluate(null), 30);
	Check.check(new AddExpression(e1, e1).evaluate(null), 20);
	Check.check(new SubtractExpression(e1, e2).evaluate(null), -10);        
        Check.check(new SubtractExpression(e2, e1).evaluate(null), 10);
        Check.check(new SubtractExpression(e1, e1).evaluate(null), 0);
	Check.check(new DivideExpression(e1, e2).evaluate(null), 0.5);
        Check.check(new DivideExpression(e2, e1).evaluate(null), 2);
	Check.check(new MultiplyExpression(e2, e1).evaluate(null), 200);
        Check.check(new MultiplyExpression(e1, e2).evaluate(null), 200);
    }
}