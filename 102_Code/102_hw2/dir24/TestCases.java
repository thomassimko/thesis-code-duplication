public class TestCases
{
   public static void main(String [] args)
   {
      Bindings b1 = new VariableBindings();
      b1.addBinding("test", 6.0);
      b1.addBinding("test1", 4.0);
      Check.check(b1.lookupBinding("test"), 6.0);
      Check.check(b1.lookupBinding("test1"), 4.0);
      
      try {
         b1.lookupBinding("blah");
         Check.check(false, true);
      } catch (UnboundIdentifierException e) { }
      
      Binding b2 = new Binding("z", 5.0);
      Check.check(b2.getName(), "z");
      Check.check(b2.getValue(), 5.0);
      
      Expression three = new DoubleConstantExpression(3.0);
      Expression four = new DoubleConstantExpression(4.0);
      Expression twelve = new DoubleConstantExpression(12.0);
      Assignment a1 = new Assignment("x", twelve);
      Check.check(a1.evaluate(b1), 12.0);
      
      AddExpression add1 = new AddExpression(three, four);
      Check.check(add1.evaluate(b1), 7);
      
      DivideExpression div1 = new DivideExpression(twelve, four);
      Check.check(div1.evaluate(b1), 3);
      
      MultiplyExpression mul1 = new MultiplyExpression(three, four);
      Check.check(mul1.evaluate(b1), 12);
      
      SubtractExpression sub1 = new SubtractExpression(four, three);
      Check.check(sub1.evaluate(b1), 1);
      
      IdentifierExpression id = new IdentifierExpression("test");
      Check.check(id.evaluate(b1), 6.0);

   }
}
