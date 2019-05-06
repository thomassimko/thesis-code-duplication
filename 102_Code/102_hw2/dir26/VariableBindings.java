import java.util.ArrayList;
import java.util.List;


public class VariableBindings implements Bindings {

	private List<Binding> bindings;
	
	public VariableBindings(){
		bindings = new ArrayList<Binding>();
	}
	@Override
	public void addBinding(String id, double value) {
		bindings.add(new Binding(id,value));
	}
	@Override
	public double lookupBinding(String id) throws UnboundIdentifierException {;
		for(int i=0;i<bindings.size();i++){
			if(bindings.get(i).getId().equals(id))
				return bindings.get(i).getValue();
		}
		throw new UnboundIdentifierException("unbound identifier: " + id);
	}
}
