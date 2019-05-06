
public class TestCases 
{
  
     public static void main(String[] args)
     {
         Expression a1 = new DoubleConstantExpression(1.5);
         Expression a2 = new DoubleConstantExpression(2.0);
         Expression a3 = new DoubleConstantExpression(2.5);
         Expression a4 = new DoubleConstantExpression(3.0);
         Expression add = new AddExpression(a1,a2);
    	 Expression subtract = new SubtractExpression(a4,a1);
    	 Expression multiply = new MultiplyExpression(a2,a3);
    	 Expression divide = new DivideExpression(a4,a1);
    	 Expression negative = new NegationExpression(divide);
    	 Expression all = new NegationExpression(new AddExpression(a1, new SubtractExpression(a4, new DivideExpression(a2,multiply))));
    	 Bindings binder = new VariableBindings();
    	 Assignment assign = new Assignment("x",add);
    	 IdentifierExpression id = new IdentifierExpression("x");
	 Expression varTest = new AddExpression(a1, id);
    	 
    	 Check.check(add.evaluate(null), 3.5);
    	 Check.check(add.toString(), "(1.5 + 2.0)");
    	 
    	 Check.check(subtract.evaluate(null), 1.5);
    	 Check.check(subtract.toString(), "(3.0 - 1.5)");
    	 
    	 Check.check(multiply.evaluate(null), 5.0);
    	 Check.check(multiply.toString(), "(2.0 * 2.5)");
    	 
    	 Check.check(divide.evaluate(null), 2.0);
    	 Check.check(divide.toString(), "(3.0 / 1.5)");
    	 
    	 Check.check(negative.evaluate(null), -2.0);
    	 Check.check(negative.toString(), "-(3.0 / 1.5)");
    	 
    	 Check.check(all.evaluate(null),-4.1);
    	 Check.check(all.toString(), "-(1.5 + (3.0 - (2.0 / (2.0 * 2.5))))");
    	 
    	 assign.evaluate(binder);
    	 Check.check(id.evaluate(binder), 3.5);
         Check.check(id.toString(),"x");

         Check.check(varTest.evaluate(binder), 5.0);
         Check.check(varTest.toString(),"(1.5 + x)" );

    	 
     }
}
