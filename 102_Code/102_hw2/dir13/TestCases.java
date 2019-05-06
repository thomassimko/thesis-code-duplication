import java.util.*;

public class TestCases {

	public static void main(String[] args) {
		Expression one,two;
		one = new DoubleConstantExpression(4);
		two = new DoubleConstantExpression(5);
		VariableBindings bound = new VariableBindings();
		Assignment setter = new Assignment("A", new DoubleConstantExpression(2));
		setter.evaluate(bound);
		System.out.println("" + setter);
		Expression a = new NegationExpression(one);
		Expression b = new AddExpression(one,two);
		Expression c = new SubtractExpression(one,two);
		Expression d = new MultiplyExpression(one,two);
		Expression e = new DivideExpression(one,two);
		Expression f = new IdentifierExpression("A");
		Expression g = new IdentifierExpression("B");
		System.out.println("" + a.evaluate(bound));
		System.out.println("" + b + " = " + b.evaluate(bound));
		System.out.println("" + c + " = " + c.evaluate(bound));
		System.out.println("" + d + " = " + d.evaluate(bound));
		System.out.println("" + e + " = " + e.evaluate(bound));
		System.out.println("" + f + " = " + f.evaluate(bound));
		try {
			System.out.println("" + g + " = " + g.evaluate(bound));
		} catch (UnboundIdentifierException exp) {
			System.err.println(exp.getMessage());
		}
	}

}
