public class TestCases
{
   public static void main(String [] args)
   {
      Expression e1 = new DoubleConstantExpression(3.4);
      Expression e2 = new DoubleConstantExpression(-5.6);
      Expression e3 = new DoubleConstantExpression(125);
      
      Expression n1 = new NegationExpression(e1);
      Expression n2 = new NegationExpression(e2);
      Expression n3 = new NegationExpression(e3);
      
      Bindings b1 = new VariableBindings();
      Bindings b2 = new VariableBindings();
      Bindings b3 = new VariableBindings();
      
      b1.addBinding("x", 3.4);
      b2.addBinding("y", -5.6);
      b3.addBinding("z", 125);
      
      Check.check(e1.evaluate(null), 3.4);
      Check.check(e2.evaluate(null), -5.6);
      Check.check(e3.evaluate(null), 125);
      
      Check.check(n1.evaluate(null), -3.4);
      Check.check(n2.evaluate(null), 5.6);
      Check.check(n3.evaluate(null), -125);
      
      Check.check(b1.lookupBinding("x"), 3.4);
      Check.check(b2.lookupBinding("y"), -5.6);
      Check.check(b3.lookupBinding("z"), 125);
      
      Check.check(new DivideExpression(e1, e2).evaluate(null), 3.4/-5.6);
      Check.check(new DivideExpression(e3, e1).evaluate(null), 125/3.4);
      Check.check(new DivideExpression(e2, e3).evaluate(null), -5.6/125);
      
      Check.check(new MultiplyExpression(e1, e2).evaluate(null), -5.6*3.4);
      Check.check(new MultiplyExpression(e3, e1).evaluate(null), 125*3.4);
      Check.check(new MultiplyExpression(e2, e3).evaluate(null), 125*-5.6);
      
      Check.check(new SubtractExpression(e1, e2).evaluate(null), 3.4-(-5.6));
      Check.check(new SubtractExpression(e3, e1).evaluate(null), 125-3.4);
      Check.check(new SubtractExpression(e2, e3).evaluate(null), -5.6-125);
      
      Check.check(new AddExpression(e1, e2).evaluate(null), 3.4+-5.6);
      Check.check(new AddExpression(e3, e1).evaluate(null), 125+3.4);
      Check.check(new AddExpression(e2, e3).evaluate(null), -5.6+125);
   }
}