public class TestCases
{
   public static void main(String [] args)
   {
      Binding testB = new Binding("test!", 123.0);
      Binding testB2 = new Binding("test2!", 234432.234);
      Bindings testBind = new VariableBindings();  
      Expression dblConst = new DoubleConstantExpression(5.0);
      Expression dblConst2 = new DoubleConstantExpression(0.5);
      Expression dblConst3 = new DoubleConstantExpression(-30.0);
      Expression neg = new NegationExpression(dblConst);
      Expression neg2 = new NegationExpression(dblConst2);
      Expression neg3 = new NegationExpression(dblConst3);
      Expression addExp = new AddExpression(dblConst, neg);
      Expression addExp2 = new AddExpression(dblConst2, dblConst);
      Expression addExp3 = new AddExpression(neg3, dblConst2);
      Expression multExp = new MultiplyExpression(dblConst, neg);
      Expression multExp2 = new MultiplyExpression(dblConst2, neg);
      Expression multExp3 = new MultiplyExpression(neg3, dblConst2);
      Expression divExp = new DivideExpression(multExp, neg);
      Expression divExp2 = new DivideExpression(neg3, dblConst2);
      Expression divExp3 = new DivideExpression(neg3, dblConst);

      //Binding: testing Binding methods
      System.out.println("***Binding Test Cases***");
      Check.check(testB.returnBind(), "test!");
      Check.check(testB.returnDbl(), 123.0);
      Check.check(testB2.returnBind(), "test2!");
      Check.check(testB2.returnDbl(), 234432.234);

      //DoubleConstantExpression: testing evaluate() and toString() methods
      System.out.println("***DoubleConstant Test Cases***");
      Check.check(dblConst.evaluate(testBind), 5.0);
      Check.check(dblConst.toString(), "5.0");
      Check.check(dblConst2.evaluate(testBind), 0.5);
      Check.check(dblConst2.toString(), "0.5");
      Check.check(dblConst3.evaluate(testBind), -30.0);
      Check.check(dblConst3.toString(), "-30.0");

      //NegationExpression: testing evaluate() and toString() methods
      System.out.println("***NegationExpression Test Cases***");
      Check.check(neg.evaluate(testBind), -5.0);
      Check.check(neg.toString(), "-5.0");
      Check.check(neg2.evaluate(testBind), -0.5);
      Check.check(neg2.toString(), "-0.5");
      Check.check(neg3.evaluate(testBind), 30.0);
      Check.check(neg3.toString(), "30.0");

      //AddExpression: testing evaluate() and toString() methods
      System.out.println("***AddExpression Test Cases***");
      Check.check(addExp.evaluate(testBind), 0.0);
      Check.check(addExp.toString(), "(5.0 + -5.0)");
      Check.check(addExp2.evaluate(testBind), 5.5);
      Check.check(addExp2.toString(), "(0.5 + 5.0)");
      Check.check(addExp3.evaluate(testBind), 30.5);
      Check.check(addExp3.toString(), "(30.0 + 0.5)");

      //MultiplyExpression: testing evaluate() and toString() methods
      System.out.println("***MultiplyExpression Test Cases***");
      Check.check(multExp.evaluate(testBind), -25.0);
      Check.check(multExp.toString(), "(5.0 * -5.0)");
      Check.check(multExp2.evaluate(testBind), -2.5);
      Check.check(multExp2.toString(), "(0.5 * -5.0)");
      Check.check(multExp3.evaluate(testBind), 15.0);
      Check.check(multExp3.toString(), "(30.0 * 0.5)");

      //DivideExpression: testing evalute() and toString() methods
      System.out.println("***DivideExpression Test Cases***");
      Check.check(divExp.evaluate(testBind), 5.0);
      Check.check(divExp.toString(), "((5.0 * -5.0) / -5.0)");
      Check.check(divExp2.evaluate(testBind), 60.0);
      Check.check(divExp2.toString(), "(30.0 / 0.5)");
      Check.check(divExp3.evaluate(testBind), 6.0);
      Check.check(divExp3.toString(), "(30.0 / 5.0)");

      //VariableBindings: testing lookupBinding() and addBinding() methods
      System.out.println("***VariableBindings Test Cases***");
      testBind.addBinding("abc", 4.55);
      testBind.addBinding("b", 4.0);
      testBind.addBinding("c", 5.0);
      Check.check(testBind.lookupBinding("abc"), 4.55);
      Check.check(testBind.lookupBinding("c"), 5.0);
      Check.check(testBind.lookupBinding("b"), 4.0);

      //IdentifierExpression: testing evaluate() and toString() methods
      System.out.println("***IdentifierExpression Test Cases***");
      Expression idExp = new IdentifierExpression("b");
      Check.check(idExp.evaluate(testBind), 4.0);
      Check.check(idExp.toString(), "b");
      testBind.addBinding("ggffgg", 123456.0);
      idExp = new IdentifierExpression("ggffgg");
      Check.check(idExp.evaluate(testBind), 123456.0);
      Check.check(idExp.toString(), "ggffgg");
      testBind.addBinding("b", 30.0);
      idExp = new IdentifierExpression("b");
      Check.check(idExp.evaluate(testBind), 30.0);
      Check.check(idExp.toString(), "b");

      //Assignment: testing evaluate() and toString() methods
      System.out.println("***Assignment Test Cases***");
      Operation assignExp = new Assignment("a", divExp);
      Check.check(assignExp.evaluate(testBind), 5.0);
      Check.check(assignExp.toString(), "set a");
      Operation assignExp2 = new Assignment("a", addExp2);
      Check.check(assignExp2.evaluate(testBind), 5.5);
      Check.check(assignExp2.toString(), "set a");
      assignExp2 = new Assignment("abc", divExp2);
      Check.check(assignExp2.evaluate(testBind), 60.0);
      Check.check(assignExp2.toString(), "set abc"); 
      
      //Exception Error Test 
      System.out.println("***Exception Test***");
      testBind.lookupBinding("Test. This string isn't bound. Should cause exception error.");      
   }
}
