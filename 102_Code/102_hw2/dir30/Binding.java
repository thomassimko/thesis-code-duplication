public class Binding
{ private String name;
  public double value;

  public Binding(String id,double value)
  { this.name=id;
	this.value=value;
  }
  
  public String getname()
  { return this.name;  }
  
  public void setName(String newname)
  { this.name=newname;  }
}
