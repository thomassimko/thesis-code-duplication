import java.util.ArrayList;
import java.util.List;


public class VariableBindings implements Bindings {

	
	List<Binding> bindings = new ArrayList<Binding>();
	int i;
	
	public void addBinding(String id, double value) {

		Binding temp;
		temp = new Binding(id, value);
		for(i=0;i<bindings.size();i++){
			if (bindings.get(i).toString().equals(id))
				bindings.remove(i);	
		}
		bindings.add(temp);

	}


	public double lookupBinding(String id) throws UnboundIdentifierException {

		for(i=0;i<bindings.size();i++){
			if (bindings.get(i).toString().equals(id))
				return bindings.get(i).value();
		}
		throw new UnboundIdentifierException("unbound identifier: " + id);
	}

	public String toString(){
		
		return bindings.get(i).toString();	
	}
}
