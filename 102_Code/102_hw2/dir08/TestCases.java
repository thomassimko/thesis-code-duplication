public class TestCases
{
   public static void main(String[] args)
   {
      VariableBindings bTest = new VariableBindings();

      bTest.addBinding("a", 1.0);
      bTest.addBinding("b", 2.75);
      bTest.addBinding("c", -0.7 * 2);
      Check.check(bTest.lookupBinding("a"), 1.0);
      Check.check(bTest.lookupBinding("b"), 2.75);
      Check.check(bTest.lookupBinding("c"), -1.4);

      Expression exp1 = new DoubleConstantExpression(1.0);
      Expression exp2 = new DoubleConstantExpression(2.5);
      Expression exp3 = new DoubleConstantExpression(-1.2);
      Expression exp4 = new DoubleConstantExpression(-5.0);

      Assignment assignTest;

      assignTest = new Assignment("d", exp1);
      Check.check(assignTest.evaluate(bTest), 1.0);
      Check.check(bTest.lookupBinding("d"), 1.0);
      assignTest = new Assignment("blub", exp2);
      Check.check(assignTest.evaluate(bTest), 2.5);
      Check.check(bTest.lookupBinding("blub"), 2.5);      

      Expression expTest;

      Check.check(exp1.evaluate(bTest), 1.0);
      Check.check(exp3.evaluate(bTest), -1.2); 

      expTest = new NegationExpression(exp1);
      Check.check(expTest.evaluate(bTest), -1.0);
      expTest = new NegationExpression(exp4);
      Check.check(expTest.evaluate(bTest), 5.0);

      expTest = new AddExpression(exp1, exp2);
      Check.check(expTest.evaluate(bTest), 3.5);
      expTest = new AddExpression(exp1, exp4);
      Check.check(expTest.evaluate(bTest), -4.0);

      expTest = new SubtractExpression(exp2, exp1);
      Check.check(expTest.evaluate(bTest), 1.5);
      expTest = new SubtractExpression(exp3, exp4);
      Check.check(expTest.evaluate(bTest), 3.8);

      expTest = new MultiplyExpression(exp1, exp2);
      Check.check(expTest.evaluate(bTest), 2.5);
      expTest = new MultiplyExpression(exp2, exp3);
      Check.check(expTest.evaluate(bTest), -3.0);

      expTest = new DivideExpression(exp2, exp1);
      Check.check(expTest.evaluate(bTest), 2.5);
      expTest = new DivideExpression(exp4, exp2);
      Check.check(expTest.evaluate(bTest), -2.0);

      expTest = new IdentifierExpression("a");
      Check.check(expTest.evaluate(bTest), 1.0);
      expTest = new IdentifierExpression("d");
      Check.check(expTest.evaluate(bTest), 1.0);
      expTest = new IdentifierExpression("c");
      Check.check(expTest.evaluate(bTest), -1.4);
      expTest = new IdentifierExpression("b");
      Check.check(expTest.evaluate(bTest), 2.75);
   }
}
