public class TestCases 
{
	public static void main(String [] args)
	{
		Bindings binder = new VariableBindings();
		
		DoubleConstantExpression one = new DoubleConstantExpression(1.0);
		DoubleConstantExpression two = new DoubleConstantExpression(2.0);
		DoubleConstantExpression three = new DoubleConstantExpression(3.0);
		DoubleConstantExpression four = new DoubleConstantExpression(4.0);
		
		//check the checker
		Check.check(2.0,2.0);
		
		Check.check(one.evaluate(binder), 1.0);
		Check.check(two.evaluate(binder), 2.0);
		Check.check(three.evaluate(binder), 3.0);
		Check.check(four.evaluate(binder), 4.0);
		
		Assignment x = new Assignment("x",new DoubleConstantExpression(5.0));
		x.evaluate(binder);
		Check.check(binder.lookupBinding("x"), 5.0);
		
		Assignment y = new Assignment("y",new DoubleConstantExpression(6.0));
		y.evaluate(binder);
		Check.check(binder.lookupBinding("y"), 6.0);
		
		x = new Assignment("x",new DoubleConstantExpression(7.0));
		x.evaluate(binder);
		Check.check(binder.lookupBinding("x"), 7.0);
		
		IdentifierExpression idx = new IdentifierExpression("x");
		Check.check(idx.evaluate(binder),7.0);
		
		AddExpression  add = new AddExpression(one,two);
		Check.check(add.evaluate(binder),3.0);
		
		SubtractExpression subtract = new SubtractExpression(two,one);
		Check.check(subtract.evaluate(binder), 1.0);
		
		MultiplyExpression Mult = new MultiplyExpression(three,four);
		Check.check(Mult.evaluate(binder),12.0);
		
		DivideExpression div = new DivideExpression(four,two);
		Check.check(div.evaluate(binder), 2.0);
		
		NegationExpression neg = new NegationExpression(one);
		Check.check(neg.evaluate(binder), -1.0);
		
		AddExpression comp = new AddExpression(one,Mult);
		Check.check(comp.evaluate(binder), 13.0);
		
		Check.check(new MultiplyExpression(comp,idx).evaluate(binder),13.0*7.0);
		
		Check.check(neg.toString(),"-1.0");
		Check.check(add.toString(),"(1.0 + 2.0)");
		Check.check(subtract.toString(),"(2.0 - 1.0)");
		Check.check(Mult.toString(),"(3.0 * 4.0)");
		Check.check(div.toString(),"(4.0 / 2.0)");
		Check.check(comp.toString(), "(1.0 + (3.0 * 4.0))");
		Check.check(new MultiplyExpression(comp,idx).toString(), "((1.0 + (3.0 * 4.0)) * x)");
		Check.check(idx.toString(), "x");
		Check.check(new NegationExpression(idx).toString(), "-x");
		Check.check(new NegationExpression(comp).toString(), "-(1.0 + (3.0 * 4.0))");
	}
}
