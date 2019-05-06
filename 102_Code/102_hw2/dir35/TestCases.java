
public class TestCases {
   public static void main(String[] args)
   {
	   Bindings b1 = new VariableBindings();
	   Assignment a1 = new Assignment("p", new DoubleConstantExpression(4));
	   Assignment a2 = new Assignment("r", new NegationExpression(new DoubleConstantExpression(10)));
	   a1.evaluate(b1);
	   a2.evaluate(b1);	 
	   
	   Expression ex1= new AddExpression(new DoubleConstantExpression(1), new DoubleConstantExpression(2));
	   Expression ex2 = new MultiplyExpression(new MultiplyExpression (new IdentifierExpression("p"), new IdentifierExpression("r")), new DoubleConstantExpression(2));
	   Expression ex3 = new DivideExpression(new DoubleConstantExpression(90), new NegationExpression( new DoubleConstantExpression(9)));
	   Expression ex4 = new SubtractExpression(new DoubleConstantExpression(4), new NegationExpression(new DoubleConstantExpression (8)));
	   
	   Expression ex5 = new MultiplyExpression(new DoubleConstantExpression(1.7), new DoubleConstantExpression(3.2));
	   Expression ex6 = new SubtractExpression(new AddExpression(new DoubleConstantExpression(1), new MultiplyExpression(new DoubleConstantExpression(2), new DoubleConstantExpression(3))), new MultiplyExpression(new DoubleConstantExpression(4), new DoubleConstantExpression(17)));
	   Expression ex7 = new IdentifierExpression("p");
	   Expression ex8 = new DivideExpression(new DoubleConstantExpression(0), new DoubleConstantExpression(3.2));

	   Expression ex9 = new AddExpression(new DoubleConstantExpression(4), new DoubleConstantExpression(7));
	   Expression ex10 = new AddExpression(new DoubleConstantExpression(4), new NegationExpression(new DoubleConstantExpression(7)));
	   Expression ex11 = new AddExpression(new NegationExpression(new DoubleConstantExpression(4)), new NegationExpression(new DoubleConstantExpression(7)));
	   Expression ex12 = new AddExpression(new NegationExpression(new DoubleConstantExpression(4)), (new DoubleConstantExpression(7)));

	   Expression ex13 = new MultiplyExpression(new DoubleConstantExpression(4), new DoubleConstantExpression(7));
	   Expression ex14 = new MultiplyExpression(new DoubleConstantExpression(4), new NegationExpression(new DoubleConstantExpression(7)));
	   Expression ex15 = new MultiplyExpression(new NegationExpression(new DoubleConstantExpression(4)), new NegationExpression(new DoubleConstantExpression(7)));
	   Expression ex16 = new MultiplyExpression(new NegationExpression(new DoubleConstantExpression(4)), (new DoubleConstantExpression(7)));

	   Expression ex17 = new DivideExpression(new DoubleConstantExpression(10), new DoubleConstantExpression(5));
	   Expression ex18 = new DivideExpression(new DoubleConstantExpression(10), new NegationExpression(new DoubleConstantExpression(5)));
	   Expression ex19 = new DivideExpression(new NegationExpression(new DoubleConstantExpression(10)), new NegationExpression(new DoubleConstantExpression(5)));
	   Expression ex20 = new DivideExpression(new NegationExpression(new DoubleConstantExpression(10)), (new DoubleConstantExpression(5)));

	   Expression ex21 = new SubtractExpression(new DoubleConstantExpression(3), new DoubleConstantExpression(12));
	   Expression ex22 = new SubtractExpression(new DoubleConstantExpression(3), new NegationExpression(new DoubleConstantExpression(12)));
	   Expression ex23 = new SubtractExpression(new NegationExpression(new DoubleConstantExpression(3)), new NegationExpression(new DoubleConstantExpression(12)));
	   Expression ex24 = new SubtractExpression(new NegationExpression(new DoubleConstantExpression(3)), (new DoubleConstantExpression(12)));
	   Expression ex25 = new SubtractExpression(new NegationExpression(new DoubleConstantExpression(-3)), new NegationExpression(new DoubleConstantExpression(12)));

	   Expression ex26 = new SubtractExpression(new IdentifierExpression("p"), new IdentifierExpression("r"));
	   Expression ex27 = new AddExpression(new IdentifierExpression("p"), new IdentifierExpression("r"));
	   Expression ex28 = new MultiplyExpression(new IdentifierExpression("p"), new IdentifierExpression("r"));
	   Expression ex29 = new DivideExpression(new IdentifierExpression("p"), new IdentifierExpression("r"));

	   
	   Check.check(ex1.evaluate(b1), 3);
	   Check.check(ex2.evaluate(b1), -80);
	   Check.check(ex3.evaluate(b1), -10);
	   Check.check(ex4.evaluate(b1), 12);
	   Check.check(ex5.evaluate(b1), 5.44);
	   Check.check(ex6.evaluate(b1), -61);
	   Check.check(ex7.evaluate(b1), 4);
	   Check.check(ex8.evaluate(b1), 0);
	   
	   Check.check(ex9.evaluate(b1), 11);
	   Check.check(ex10.evaluate(b1), -3);
	   Check.check(ex11.evaluate(b1), -11);
	   Check.check(ex12.evaluate(b1), 3);
	   
	   Check.check(ex13.evaluate(b1), 28);
	   Check.check(ex14.evaluate(b1), -28);
	   Check.check(ex15.evaluate(b1), 28);
	   Check.check(ex16.evaluate(b1), -28);
	   
	   Check.check(ex17.evaluate(b1), 2);
	   Check.check(ex18.evaluate(b1), -2);
	   Check.check(ex19.evaluate(b1), 2);
	   Check.check(ex20.evaluate(b1), -2);

	   Check.check(ex21.evaluate(b1), -9);
	   Check.check(ex22.evaluate(b1), 15);
	   Check.check(ex23.evaluate(b1), 9);
	   Check.check(ex24.evaluate(b1), -15);
	   Check.check(ex25.evaluate(b1), 15);

	   Check.check(ex26.evaluate(b1), 14);
	   Check.check(ex27.evaluate(b1), -6);
	   Check.check(ex28.evaluate(b1), -40);
	   Check.check(ex29.evaluate(b1), -.4);


   }
}
