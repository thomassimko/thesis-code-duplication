
public class IterativeNode 
{
	private String val;
	private IterativeNode next;
	
	public IterativeNode(String val, IterativeNode next)
	{
		this.val = val;
		this.next = next;
	}
	
	public String getVal()
	{
		return val;
	}
	
	public IterativeNode getNext()
	{
		return next;
	}
	
	public void setVal(String val)
	{
		this.val = val;
	}
	
	public void setNext(IterativeNode next)
	{
		this.next = next;
	}
}
