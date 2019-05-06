/*Programmed by Michael Olivarez*/
import java.util.List;
import java.util.ArrayList;
public class VariableBindings
implements Bindings
{
    private double bindval;
    private List<Binding> bindlist = new ArrayList<Binding>();
    public void addBinding(String id, double value)
    {
       Binding bin = new Binding(id, value);
       this.bindlist.add(bin);
    } 
    public double lookupBinding(String id)
    {
        for(int i=0; i<this.bindlist.size(); i++)
        {
           if(this.bindlist.get(i).getstr().equals(id))
           {
             this.bindval = this.bindlist.get(i).getval();
             return this.bindval; 
           }       
        }
        throw new UnboundIdentifierException("unbound identifier: " + id);  
    }
}
