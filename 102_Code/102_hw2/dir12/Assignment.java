public class Assignment implements Operation{
	
	private String name;
	private Expression expression;
	private double value;
	
	public Assignment(String id, Expression e){
		
		this.name = id;
		this.expression = e;
		
	}
	
	public double evaluate(Bindings bindings){

		value=expression.evaluate(bindings);
		
		bindings.addBinding(name,value);
		
		return value;
	}
	
public String toString(){
		return "set "+name+" = "+ expression.toString();	
	}

}
