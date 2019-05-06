
public class TestCases {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Test DoubleConstant
		Expression a = new DoubleConstantExpression(1.0);
		Check.check(a.evaluate(null), 1.0);
		System.out.println(a.toString());
		
		Expression d = new DoubleConstantExpression(2.0);
		Check.check(d.evaluate(null), 2.0);
		System.out.println(d.toString());
		
		// Test Negation
		Expression b = new NegationExpression(a);
		Check.check(b.evaluate(null), -1.0);
		System.out.println(b.toString());
		
		// Test Add
		Expression c = new AddExpression(a,b);
		Check.check(c.evaluate(null), 0.0);
		System.out.println(c.toString());
		
	    Expression e = new AddExpression(a,d);
	    System.out.println(e.toString());
	    Check.check(e.evaluate(null), 3.0);
	    
	    //Test Subtract
	    Expression f = new SubtractExpression(d,a);
	    Check.check(f.evaluate(null), 1.0);
	    System.out.println(f.toString());
	    
	    //Test Multiply
	    Expression g = new MultiplyExpression(d,a);
	    Check.check(g.evaluate(null), 2.0);
	    System.out.println(g.toString());
	    
	    //Test Divide
	    Expression h = new DivideExpression(d,a);
	    Check.check(h.evaluate(null), 2.0);
	    System.out.println(h.toString());
	   
	    //Test Variable Bindings
	    VariableBindings vb = new VariableBindings();
	    vb.addBinding("a", 2.0);
	    
	    double bindvalue = vb.lookupBinding("a");
	    System.out.println(bindvalue);  
	    
	    vb.addBinding("b",5.0);
	    double bindvalue2 = vb.lookupBinding("b");
	    System.out.println(bindvalue2);
	    
	    vb.addBinding("c",6.0);
	    double bindvalue3 = vb.lookupBinding("c");
	    System.out.println(bindvalue3);   
	    
	    // Test Assignment
	    Expression z = new AddExpression(a,b);
	    Assignment assign = new Assignment("a", z);
	    Check.check(assign.evaluate(vb), 0.0);
	    System.out.println(assign.toString());

	    // Test Identifier Expression
	    vb.addBinding("j",2.0);
	    Expression p = new IdentifierExpression("j");
	    Check.check(p.evaluate(vb), 2.0);
	    System.out.println(p.toString());
	    
	 
	    
	}

}
