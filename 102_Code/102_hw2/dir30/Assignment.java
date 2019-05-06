public class Assignment
implements Operation
{ public String name;
  public double score;
 
  public Assignment(String id,Expression e)
  { Binding rar=new Binding(id,2);
	name=id;
	score=e.evaluate(rar);
  }
  
  public double evaluate(Binding bindings)
  { bindings.setName(name);
    bindings.value=score;
    return bindings.value;
  }
}
