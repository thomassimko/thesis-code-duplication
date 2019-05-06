
public class TestCases {

	public static void main(String[] args) {
		Expression constant= new DoubleConstantExpression(2.731);
		Expression not = new NegationExpression(constant);
		Expression value = new AddExpression(constant,not);
		Bindings bindings = new VariableBindings();
		
		bindings.addBinding("hi",1);
		bindings.addBinding("meh",14);
		
		Operation assignment = new Assignment("minus", constant);
		
		Check.check(constant.evaluate(bindings),2.731);
		Check.check(constant.evaluate(bindings),2.731);
		Check.check(not.evaluate(bindings),-2.731);
		Check.check(not.evaluate(bindings),-2.731);
		Check.check(value.evaluate(bindings),0);
		
		value = new SubtractExpression(constant, not);
		Check.check(value.evaluate(bindings), 5.462);
		Check.check(value.evaluate(bindings), 5.462);
		value = new MultiplyExpression(constant, not);
		Check.check(value.evaluate(bindings), 2.731*(-2.731));
		Check.check(value.evaluate(bindings), 2.731*(-2.731));
		value = new DivideExpression(constant, not);
		Check.check(value.evaluate(bindings), -1);
		Check.check(value.evaluate(bindings), -1);
		
		Check.check(bindings.lookupBinding("hi"),1);
		Check.check(bindings.lookupBinding("meh"),14);
		
		Check.check(assignment.evaluate(bindings), 2.731);
		
	}

}
