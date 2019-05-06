public class TestCases 
{
   public static void main(String[] args) 
   {
      Check.check(new DoubleConstantExpression(2.731).evaluate(null), 2.731);
      Check.check(new DoubleConstantExpression(1.00).evaluate(null), 1);
      Check.check(new DoubleConstantExpression(2.00).evaluate(null), 2);
      
      Check.check(new NegationExpression(new DoubleConstantExpression(2.731)).evaluate(null), -2.731);
      Check.check(new NegationExpression(new DoubleConstantExpression(1.00)).evaluate(null), -1);
      Check.check(new NegationExpression(new DoubleConstantExpression(2.00)).evaluate(null), -2);
      
      Check.check(new AddExpression(new DoubleConstantExpression(1.00),new DoubleConstantExpression(2.00)).evaluate(null), 3);
      Check.check(new AddExpression(new DoubleConstantExpression(2.00),new DoubleConstantExpression(3.00)).evaluate(null), 5);
      Check.check(new AddExpression(new DoubleConstantExpression(3.00),new DoubleConstantExpression(4.00)).evaluate(null), 7);
      
      Check.check(new SubtractExpression(new DoubleConstantExpression(10.00),new DoubleConstantExpression(5.00)).evaluate(null), 5);
      Check.check(new SubtractExpression(new DoubleConstantExpression(11.00),new DoubleConstantExpression(5.00)).evaluate(null), 6);
      Check.check(new SubtractExpression(new DoubleConstantExpression(16.00),new DoubleConstantExpression(6.00)).evaluate(null), 10);
      
      Check.check(new MultiplyExpression(new DoubleConstantExpression(10.00),new DoubleConstantExpression(5.00)).evaluate(null), 50);
      Check.check(new MultiplyExpression(new DoubleConstantExpression(11.00),new DoubleConstantExpression(5.00)).evaluate(null), 55);
      Check.check(new MultiplyExpression(new DoubleConstantExpression(12.00),new DoubleConstantExpression(5.00)).evaluate(null), 60);
            
      Check.check(new DivideExpression(new DoubleConstantExpression(50.00),new DoubleConstantExpression(5.00)).evaluate(null), 10);
      Check.check(new DivideExpression(new DoubleConstantExpression(40.00),new DoubleConstantExpression(5.00)).evaluate(null), 8);
      Check.check(new DivideExpression(new DoubleConstantExpression(30.00),new DoubleConstantExpression(5.00)).evaluate(null), 6);
      
      BindingTest();
   }
   
   public static void BindingTest()
   {
      VariableBindings Test1 = new VariableBindings();
      VariableBindings Test2 = new VariableBindings();
      VariableBindings Test3 = new VariableBindings();
      
      Binding TestA = new Binding("a", 1);
      Binding TestB = new Binding("b", 2);
      Binding TestC = new Binding("c", 3);
      
      Test1.addBinding("two", 2);
      Test2.addBinding("three", 3);
      Test3.addBinding("PI", 3.14);
            
      Check.check(Test1.lookupBinding("two"), 2);
      Check.check(Test2.lookupBinding("three"), 3);
      Check.check(Test3.lookupBinding("PI"), 3.14);
      
      Check.check(TestA.getID(), "a");
      Check.check(TestA.getValue(), 1);
      Check.check(TestB.getID(), "b");
      Check.check(TestB.getValue(), 2);
      Check.check(TestC.getID(), "c");
      Check.check(TestC.getValue(), 3);
            
   }
}