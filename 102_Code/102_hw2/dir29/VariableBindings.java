import java.util.ArrayList;
import java.util.List;

public class VariableBindings implements Bindings {
	private List<Binding> list = new ArrayList<Binding>();
	@Override
	public void addBinding(String id, double value) {
		boolean exists = false;		
		for(Binding b : list ){
			if(b.getId().equals(id)){
				b.setValue(value);
				exists = true;
			}
		}
		if(!exists){
			Binding newBinding = new Binding(id,value);
			list.add(newBinding);
		}
	}

	@Override
	public double lookupBinding(String id) throws UnboundIdentifierException {
		for(Binding b : list ){
			if(b.getId().equals(id)){
				return b.getValue();
			}
		}
		throw new UnboundIdentifierException("unbound identifier: " + id);
	}
}
