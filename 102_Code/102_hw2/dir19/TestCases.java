public class TestCases
{
	public static void main(String [] args)
	{
		final double ARBITRARY_BINDING = 0.0;
		Expression first = new DoubleConstantExpression(10);
		Expression second = new DoubleConstantExpression(20);
		Expression addThis = new AddExpression(first,second);
		Expression subThis = new SubtractExpression(first,second);
		Expression multThis = new MultiplyExpression(first,second);
		Expression divThis = new DivideExpression(first,second);
		Expression negThis = new NegationExpression(first);
		Expression idThis = new IdentifierExpression("myName");
		Expression assThis = new Assignment("myName",first);
		Binding bindId = new Binding("myName",10);
		Binding bind = new Binding(ARBITRARY_BINDING);

		Check.check(first.evaluate(bind),10);
		Check.check(second.evaluate(bind),20);
		Check.check(addThis.evaluate(bind),30);
		Check.check(subThis.evaluate(bind),-10);
		Check.check(multThis.evaluate(bind),200);
		Check.check(divThis.evaluate(bind),0.5);
		Check.check(negThis.evaluate(bind),-10);
		Check.check(idThis.toString(),"myName");
		Check.check(bindId.getString(),"myName");
		Check.check(bindId.getValue(),10);
		Check.check(assThis.evaluate(bind),10);
	}
}
		
	
