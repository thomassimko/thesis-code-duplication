public class TestCases
{
   public static void main(String [] args)
   {
      Bindings binding = new BindingList();
		DoubleConstantExpression d1 = new DoubleConstantExpression(35.7);
		DoubleConstantExpression d2 = new DoubleConstantExpression(-23.767);
		DoubleConstantExpression d3 = new DoubleConstantExpression(0.1);
		DoubleConstantExpression d4 = new DoubleConstantExpression(-5);
      
		Check.check(new DoubleConstantExpression(1.22).evaluate(binding), 1.22);
		Check.check(new DoubleConstantExpression(-0.33).evaluate(binding), -0.33);
		
		Check.check(new NegationExpression(d1).evaluate(binding), -35.7);
		Check.check(new NegationExpression(d2).evaluate(binding), 23.767);
		
		Check.check(new AddExpression(d1, d2).evaluate(binding), 11.933);
		Check.check(new AddExpression(d3, d4).evaluate(binding), -4.9);
		
		Check.check(new SubtractExpression(d1, d2).evaluate(binding), 59.467);
		Check.check(new SubtractExpression(d3, d4).evaluate(binding), 5.1);
		
		Check.check(new MultiplyExpression(d1, d2).evaluate(binding), -848.4819);
		Check.check(new MultiplyExpression(d1, d3).evaluate(binding), 3.57);
		
		Check.check(new DivideExpression(d1, d3).evaluate(binding), 357);
		Check.check(new DivideExpression(d1, d4).evaluate(binding), -7.14);
		
		Check.check(new Assignment("a", d1).evaluate(binding), 35.7);
		Check.check(binding.lookupBinding("a"), 35.7);
		Check.check(new Assignment("b", new NegationExpression(d4)).evaluate(binding), 5);
		Check.check(binding.lookupBinding("b"), 5);
		binding.addBinding("c", 12.658);
		Check.check(binding.lookupBinding("c"), 12.658);
		
		Check.check(new IdentifierExpression("a").evaluate(binding), 35.7);
		Check.check(new IdentifierExpression("b").evaluate(binding), 5);
	}
}