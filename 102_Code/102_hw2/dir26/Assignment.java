
public class Assignment implements Expression{
	
	private Expression e;
	private String id;
	
	public Assignment(String id, Expression e){
		this.e=e;
		this.id=id;
	}
	public double evaluate(Bindings binding){
		double value = e.evaluate(binding);
		binding.addBinding(id, value);
		return value;
	}
	public String toString(){
		return "set "+id+" = "+e.toString();
	}
}
