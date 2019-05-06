public class TestCases
{
   public static void test()
   {
      Bindings b1 = new VariableBindings();
   
      Expression e1 = (new AddExpression(new DoubleConstantExpression(1), new DoubleConstantExpression(2)));
      Expression e2 = (new AddExpression(new NegationExpression(new DoubleConstantExpression(2)), new DoubleConstantExpression(1)));
      Expression e3 = (new AddExpression(new DoubleConstantExpression(1), new NegationExpression(new DoubleConstantExpression(4))));
      Expression e4 = (new AddExpression(new NegationExpression(new DoubleConstantExpression(4)), new NegationExpression(new DoubleConstantExpression(6))));
      Expression e5 = (new AddExpression(new DoubleConstantExpression(0), new DoubleConstantExpression(0)));
      Expression e6 = (new AddExpression(new DoubleConstantExpression(0.5), new DoubleConstantExpression(0.5)));
      Expression e7 = (new AddExpression(new DoubleConstantExpression(1.6), new DoubleConstantExpression(3.9)));
      
      Check.check(e1.evaluate(b1), 3);
      Check.check(e2.evaluate(b1), -1);
      Check.check(e3.evaluate(b1), -3);
      Check.check(e4.evaluate(b1), -10);
      Check.check(e5.evaluate(b1), 0);
      Check.check(e6.evaluate(b1), 1);
      Check.check(e7.evaluate(b1), 5.5);
      
      Expression e8 = (new SubtractExpression(new DoubleConstantExpression(4), new DoubleConstantExpression(2)));
      Expression e9 = (new SubtractExpression(new NegationExpression(new DoubleConstantExpression(1)), new DoubleConstantExpression(0)));
      Expression e10 = (new SubtractExpression(new NegationExpression(new DoubleConstantExpression(5)), new NegationExpression(new DoubleConstantExpression(10))));
      Expression e11 = (new SubtractExpression(new DoubleConstantExpression(7), new NegationExpression(new DoubleConstantExpression(3))));
      Expression e12 = (new SubtractExpression(new DoubleConstantExpression(3), new DoubleConstantExpression(8)));
      Expression e13 = (new SubtractExpression(new DoubleConstantExpression(0), new DoubleConstantExpression(0)));

      Check.check(e8.evaluate(b1), 2);
      Check.check(e9.evaluate(b1), -1);
      Check.check(e10.evaluate(b1), 5);
      Check.check(e11.evaluate(b1), 10);
      Check.check(e12.evaluate(b1), -5);
      Check.check(e13.evaluate(b1), 0);
      
      Expression e20 = (new MultiplyExpression(new DoubleConstantExpression(1), new DoubleConstantExpression(1)));
      Expression e21 = (new MultiplyExpression(new DoubleConstantExpression(2), new DoubleConstantExpression(5)));
      Expression e22 = (new MultiplyExpression(new DoubleConstantExpression(4), new DoubleConstantExpression(4)));
      Expression e23 = (new MultiplyExpression(new DoubleConstantExpression(0), new DoubleConstantExpression(0)));
      Expression e24 = (new MultiplyExpression(new DoubleConstantExpression(2), new DoubleConstantExpression(0)));
      Expression e25 = (new MultiplyExpression(new DoubleConstantExpression(0), new DoubleConstantExpression(9)));
      Expression e26 = (new MultiplyExpression(new NegationExpression(new DoubleConstantExpression(5)), new DoubleConstantExpression(4)));
      Expression e27 = (new MultiplyExpression(new DoubleConstantExpression(8), new NegationExpression(new DoubleConstantExpression(1))));
      Expression e28 = (new MultiplyExpression(new NegationExpression(new DoubleConstantExpression(3)), new NegationExpression(new DoubleConstantExpression(2))));
      
      Check.check(e20.evaluate(b1), 1);
      Check.check(e21.evaluate(b1), 10);
      Check.check(e22.evaluate(b1), 16);
      Check.check(e23.evaluate(b1), 0);
      Check.check(e24.evaluate(b1), 0);
      Check.check(e25.evaluate(b1), 0);
      Check.check(e26.evaluate(b1), -20);
      Check.check(e27.evaluate(b1), -8);
      Check.check(e28.evaluate(b1), 6);
      
      Expression e37 = (new DivideExpression(new DoubleConstantExpression(6), new DoubleConstantExpression(1)));
      Expression e38 = (new DivideExpression(new NegationExpression(new DoubleConstantExpression(6)), new DoubleConstantExpression(1)));
      Expression e39 = (new DivideExpression(new DoubleConstantExpression(6), new NegationExpression(new DoubleConstantExpression(1))));
      Expression e40 = (new DivideExpression(new NegationExpression(new DoubleConstantExpression(6)), new NegationExpression(new DoubleConstantExpression(1))));
      Expression e41 = (new DivideExpression(new DoubleConstantExpression(10), new DoubleConstantExpression(5)));
      Expression e42 = (new DivideExpression(new DoubleConstantExpression(1), new DoubleConstantExpression(2)));
      Expression e43 = (new DivideExpression(new DoubleConstantExpression(0), new DoubleConstantExpression(4.5)));
      Expression e44 = (new DivideExpression(new DoubleConstantExpression(1), new DoubleConstantExpression(0.5)));
      Expression e45 = (new DivideExpression(new DoubleConstantExpression(1.5), new DoubleConstantExpression(3.4)));
      Expression e46 = (new DivideExpression(new DoubleConstantExpression(0.5), new DoubleConstantExpression(0.5)));
      
      Check.check(e37.evaluate(b1), 6);
      Check.check(e38.evaluate(b1), -6);
      Check.check(e39.evaluate(b1), -6);
      Check.check(e40.evaluate(b1), 6);
      Check.check(e41.evaluate(b1), 2);
      Check.check(e42.evaluate(b1), 0.5);
      Check.check(e43.evaluate(b1), 0);
      Check.check(e44.evaluate(b1), 2);
      Check.check(e45.evaluate(b1), 0.44118);
      Check.check(e46.evaluate(b1), 1);
      
      Expression e50 = (new DoubleConstantExpression(0.563));
      Expression e51 = (new DoubleConstantExpression(-0.33));
      Expression e52 = (new DoubleConstantExpression(0));
      Expression e53 = (new DoubleConstantExpression(0.66667));
      
      Check.check(e50.evaluate(b1), 0.563);
      Check.check(e51.evaluate(b1), -0.33);
      Check.check(e52.evaluate(b1), 0);
      Check.check(e53.evaluate(b1), 0.66667);
      
      Expression e58 = (new NegationExpression(new DoubleConstantExpression(0)));
      Expression e59 = (new NegationExpression(new DoubleConstantExpression(1)));
      Expression e60 = (new NegationExpression(new DoubleConstantExpression(-1)));
      Expression e61 = (new NegationExpression(new DoubleConstantExpression(0.5)));
      Expression e62 = (new NegationExpression(new DoubleConstantExpression(-0.5)));
      
      Check.check(e58.evaluate(b1), 0);
      Check.check(e59.evaluate(b1), -1);
      Check.check(e60.evaluate(b1), 1);
      Check.check(e61.evaluate(b1), -0.5);
      Check.check(e62.evaluate(b1), 0.5);
      
      Assignment a1 = new Assignment("a", new DoubleConstantExpression(2));
      Assignment a2 = new Assignment("b", new NegationExpression(new DoubleConstantExpression(2)));
      
      a1.evaluate(b1);
      a2.evaluate(b1);
      
      Expression e01 = new MultiplyExpression(new IdentifierExpression("a"), new IdentifierExpression("b"));
      Expression e02 = new DivideExpression(new IdentifierExpression("a"), new IdentifierExpression("b"));
      Expression e03 = new SubtractExpression(new IdentifierExpression("a"), new IdentifierExpression("b"));
      Expression e04 = new AddExpression(new IdentifierExpression("a"), new IdentifierExpression("b"));
      
      Check.check(e01.evaluate(b1), -4);
      Check.check(e02.evaluate(b1), -1);
      Check.check(e03.evaluate(b1), 4);
      Check.check(e04.evaluate(b1), 0);

   }
   
   public static void main(String[] args)
   {
      test();
   }
}
