
public class TestCases {
	
	static Expression a = new DoubleConstantExpression(1.0);
	static Expression b = new DoubleConstantExpression(1.2);
	static Expression c = new DoubleConstantExpression(2.2);
	static Expression d = new DoubleConstantExpression(-8.0);
	
	static Bindings binding = new VariableBindings();
	
	public static void checkDoubleConstantExpression(){
		Check.check(a.evaluate(binding),1.0);
		Check.check(b.evaluate(binding),1.2);
		Check.check(c.evaluate(binding),2.2);
		Check.check(d.evaluate(binding),-8.0);
	}
	public static void checkNegationExpression(){
		Expression e = new NegationExpression(a);
		Expression f = new NegationExpression(b);
		Expression g = new NegationExpression(c);
		Expression h = new NegationExpression(d);
		
		Check.check(e.evaluate(binding),-1.0);
		Check.check(f.evaluate(binding),-1.2);
		Check.check(g.evaluate(binding),-2.2);
		Check.check(h.evaluate(binding),8.0);
	}
	public static void checkAddExpression(){
		Expression e = new AddExpression(a,b);
		Expression f = new AddExpression(c,d);
		Expression g = new AddExpression(a,d);
		
		Check.check(e.evaluate(binding),2.2);
		Check.check(f.evaluate(binding),-5.8);
		Check.check(g.evaluate(binding),-7.0);
	}
	public static void checkSubtractExpression(){
		Expression e = new SubtractExpression(a,b);
		Expression f = new SubtractExpression(c,d);
		Expression g = new SubtractExpression(a,d);
		
		Check.check(e.evaluate(binding),-0.2);
		Check.check(f.evaluate(binding),10.2);
		Check.check(g.evaluate(binding),9.0);
	}
	public static void checkMultiplyExpression(){
		Expression e = new MultiplyExpression(a,b);
		Expression f = new MultiplyExpression(c,d);
		Expression g = new MultiplyExpression(a,d);
		
		Check.check(e.evaluate(binding),1.2);
		Check.check(f.evaluate(binding),-17.6);
		Check.check(g.evaluate(binding),-8.0);
	}
	public static void checkDivideExpression(){
		Expression e = new DivideExpression(a,b);
		Expression f = new DivideExpression(c,d);
		Expression g = new DivideExpression(a,d);
		
		Check.check(e.evaluate(binding),0.83333333);
		Check.check(f.evaluate(binding),-0.275);
		Check.check(g.evaluate(binding),-0.125);
	}
	public static void checkBindings(){
		binding.addBinding("a", 0.1);
		binding.addBinding("b", 0.2);
		binding.addBinding("c", 20);
		
		Check.check(binding.lookupBinding("a"), 0.1);
		Check.check(binding.lookupBinding("b"), 0.2);
		Check.check(binding.lookupBinding("c"), 20);
		try{
			binding.lookupBinding("d");
		}catch(UnboundIdentifierException e){
			Check.check(e.getMessage(), "unbound identifier: d");
		}
	}
	public static void checkAssignment(){
		Expression e = new Assignment("h",a);
		Expression f = new Assignment("i",b);
		Expression g = new Assignment("j",c);
		
		Check.check(e.evaluate(binding), 1.0);
		Check.check(f.evaluate(binding), 1.2);
		Check.check(g.evaluate(binding), 2.2);
		
		Check.check(binding.lookupBinding("h"), 1.0);
		Check.check(binding.lookupBinding("i"), 1.2);
		Check.check(binding.lookupBinding("j"), 2.2);
	}
	public static void checkIdentifierExpression(){
		Expression e = new IdentifierExpression("a");
		Expression f = new IdentifierExpression("b");
		Expression g = new IdentifierExpression("c");
		
		Check.check(e.evaluate(binding), 0.1);
		Check.check(f.evaluate(binding), 0.2);
		Check.check(g.evaluate(binding), 20);
	}
	public static void main(String [] args){
		checkDoubleConstantExpression();
		checkNegationExpression();
		checkAddExpression();
		checkSubtractExpression();
		checkMultiplyExpression();
		checkDivideExpression();
		checkBindings();
		checkAssignment();
		checkIdentifierExpression();
	}
}
