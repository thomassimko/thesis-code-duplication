public class TestCases {
	public static void main(String[] args) {
		Bindings b = new VariableBindings();
		
		DoubleConstantExpression c1 = new DoubleConstantExpression(1.0); // c1 = 1
		DoubleConstantExpression c2 = new DoubleConstantExpression(-1.0); // c2 = -1
		DoubleConstantExpression c3 = new DoubleConstantExpression(0.0); // c3 = 0
		DoubleConstantExpression c4 = new DoubleConstantExpression(4.0); // c4 = 4
		
		NegationExpression n1 = new NegationExpression(c1); // n1 = -1
		NegationExpression n2 = new NegationExpression(c2); // n2 = 1
		
		AddExpression a1 = new AddExpression(c1,c2); // a1 = 0
		AddExpression a2 = new AddExpression(c1,c1); // a2 = 2
		AddExpression a3 = new AddExpression(a2,c1); // a3 = 3
		AddExpression a4 = new AddExpression(a2,a3); // a4 = 5
		
		SubtractExpression s1 = new SubtractExpression(c4,c1); // s1 = 3
		SubtractExpression s2 = new SubtractExpression(c1,c4); // s2 = -3
		SubtractExpression s3 = new SubtractExpression(s1,c4); // s3 = -1
		SubtractExpression s4 = new SubtractExpression(a1,c3); // s4 = 0
		
		MultiplyExpression m1 = new MultiplyExpression(c1,c2); // m1 = -1
		MultiplyExpression m2 = new MultiplyExpression(s1,s2); // m2 = -9
		
		DivideExpression d1 = new DivideExpression(c1,c2); // d1 = -1
		DivideExpression d2 = new DivideExpression(s4,s2); // d2 = 0
		
		Assignment x = new Assignment("x",c1); // x = 1
		Assignment y = new Assignment("y",a1); // y = 0
		
		IdentifierExpression x_id = new IdentifierExpression("x"); // x_id = 1
		IdentifierExpression y_id = new IdentifierExpression("y"); // y_id = 0
		
		Check.check(c1.evaluate(b), 1.0);
		Check.check(c2.evaluate(b), -1.0);
		Check.check(c1.toString(), "1.0");
		
		Check.check(n1.evaluate(b), -1.0);
		Check.check(n2.evaluate(b), 1.0);
		Check.check(n1.toString(), "-1.0");
		
		Check.check(a1.evaluate(b), 0.0);
		Check.check(a2.evaluate(b), 2.0);
		Check.check(a3.evaluate(b), 3.0);
		Check.check(a4.evaluate(b), 5.0);
		Check.check(a1.toString(), "(1.0 + -1.0)");
		
		Check.check(s1.evaluate(b), 3.0);
		Check.check(s2.evaluate(b), -3.0);
		Check.check(s3.evaluate(b), -1.0);
		Check.check(s4.evaluate(b), 0);
		Check.check(s1.toString(), "(4.0 - 1.0)");
		
		Check.check(m1.evaluate(b), -1.0);
		Check.check(m2.evaluate(b), -9);
		Check.check(m1.toString(), "(1.0 * -1.0)");
		
		Check.check(d1.evaluate(b), -1);
		Check.check(d2.evaluate(b), 0);
		Check.check(d1.toString(), "(1.0 / -1.0)");
		
		Check.check(x.evaluate(b), 1);
		Check.check(y.evaluate(b), 0);
		Check.check(x.toString(), "set x = 1.0");
		
		Check.check(x_id.evaluate(b), 1);
		Check.check(y_id.evaluate(b), 0);
		Check.check(x_id.toString(), "x");
		
	}

}
