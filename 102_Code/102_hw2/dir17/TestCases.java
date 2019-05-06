public class TestCases
{
  public static void main(String [] args)
  {
    testDoubleConstantExpression();
    testNegationExpression();
    testBinaryExpressions();
    testVariableBindings();
  }

  public static void testDoubleConstantExpression()
  {
    Check.check(new DoubleConstantExpression(1).evaluate(null), 1);
    Check.check(new DoubleConstantExpression(2).evaluate(null), 2);
  }

  public static void testNegationExpression()
  {
    Check.check(new NegationExpression( new 
      DoubleConstantExpression(1) ).evaluate(null), -1);
    Check.check(new NegationExpression( new 
      DoubleConstantExpression(-1) ).evaluate(null), 1);
  }

  public static void testBinaryExpressions()
  {
    Expression e1 = new DoubleConstantExpression(1);
    Expression e2 = new DoubleConstantExpression(2);

    Check.check( new AddExpression(e1,e2).evaluate(null), 3);
    Check.check( new SubtractExpression(e1,e2).evaluate(null), -1);
    Check.check( new SubtractExpression(e2,e1).evaluate(null), 1);
    Check.check( new MultiplyExpression(e1,e2).evaluate(null), 2);
    Check.check( new DivideExpression(e1,e2).evaluate(null), 0.5);
    Check.check( new DivideExpression(e2,e1).evaluate(null), 2);
  }

  public static void testVariableBindings()
  {
    Bindings b = new VariableBindings();

    b.addBinding("two", 2);
    b.addBinding("three", 3);

    Check.check( b.lookupBinding("two") , 2);
    Check.check( b.lookupBinding("three") , 3);

    b.addBinding("two", 5);

    Check.check( b.lookupBinding("two"), 5);
  }
}
