public class TestCases
{
	public static void testMultiplyExpression()
	{
		Check.check(new MultiplyExpression(new DoubleConstantExpression(3), new DoubleConstantExpression(5)).evaluate(null), 15);
		Check.check(new MultiplyExpression(new DoubleConstantExpression(5), new DoubleConstantExpression(5)).evaluate(null), 25);
		Check.check(new MultiplyExpression(new DoubleConstantExpression(0), new DoubleConstantExpression(500)).evaluate(null), 0);
		Check.check(new MultiplyExpression(new DoubleConstantExpression(-3), new DoubleConstantExpression (-5)).evaluate(null), 15);
		Check.check(new MultiplyExpression(new DoubleConstantExpression(-4), new DoubleConstantExpression(4)).evaluate(null), -16);
	}
	public static void testDivideExpression()
	{
		Check.check(new DivideExpression(new DoubleConstantExpression(5), new DoubleConstantExpression(5)).evaluate(null), 1);
		Check.check(new DivideExpression(new DoubleConstantExpression(-5), new DoubleConstantExpression(5)).evaluate(null), -1);
		Check.check(new DivideExpression(new DoubleConstantExpression(-5), new DoubleConstantExpression(-5)).evaluate(null), 1);
		Check.check(new DivideExpression(new DoubleConstantExpression(5), new DoubleConstantExpression(-5)).evaluate(null), -1);
		Check.check(new DivideExpression(new DoubleConstantExpression(0), new DoubleConstantExpression(5)).evaluate(null), 0);
		Check.check(new DivideExpression(new DoubleConstantExpression(3), new DoubleConstantExpression(2)).evaluate(null), 1.5);
	}
	public static void testAddExpression()
	{
		Check.check(new AddExpression(new DoubleConstantExpression(5), new DoubleConstantExpression(5)).evaluate(null), 10);
		Check.check(new AddExpression(new DoubleConstantExpression(0), new DoubleConstantExpression(5)).evaluate(null), 5);
		Check.check(new AddExpression(new DoubleConstantExpression(-4), new DoubleConstantExpression(5)).evaluate(null), 1);
		Check.check(new AddExpression(new DoubleConstantExpression(5), new DoubleConstantExpression(-5)).evaluate(null), 0);
		Check.check(new AddExpression(new DoubleConstantExpression(-5), new DoubleConstantExpression(-5)).evaluate(null), -10);
	}
	public static void testSubtractExpression()
	{
		Check.check(new SubtractExpression(new DoubleConstantExpression(5), new DoubleConstantExpression(5)).evaluate(null), 0);
		Check.check(new SubtractExpression(new DoubleConstantExpression(5), new DoubleConstantExpression(-5)).evaluate(null), 10);
		Check.check(new SubtractExpression(new DoubleConstantExpression(4), new DoubleConstantExpression(5)).evaluate(null), -1);
		Check.check(new SubtractExpression(new DoubleConstantExpression(-5), new DoubleConstantExpression(-5)).evaluate(null), 0);
		Check.check(new SubtractExpression(new DoubleConstantExpression(10), new DoubleConstantExpression(5)).evaluate(null), 5);
		Check.check(new SubtractExpression(new DoubleConstantExpression(-5), new DoubleConstantExpression(10)).evaluate(null), -15);
	}
	public static void main(String[] args)
	{
		testMultiplyExpression();
		testSubtractExpression();
		testDivideExpression();
		testAddExpression();
	}
}
