import java.util.ArrayList;
import java.util.List;


public class VariableBindings implements Bindings {
	
	//private Map<String,DoubleConstantExpression> keys = new TreeMap<String, DoubleConstantExpression>();
	private List<Binding> binds = new ArrayList<Binding>();
	
	public void addBinding(String id, double value) {
		//keys.put(id, new DoubleConstantExpression(value));
		for(int i = 0; i<binds.size(); i++)
		{
			if (binds.get(i).name().equals(id))
			{
				binds.get(i).setVal(value);
				return  ;
			}
		}
		binds.add(new Binding(id,value));
	}
	
	public double lookupBinding(String id) throws UnboundIdentifierException {
		//return keys.get(id).evaluate(this);
		for (int i = 0; i<binds.size(); i++)
		{
			if (binds.get(i).name().equals(id))
			{
				return binds.get(i).val();
			}
		}
		throw new UnboundIdentifierException("unbound identifier: "+id);
	}
}
