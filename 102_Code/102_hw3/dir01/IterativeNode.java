
public class IterativeNode {
	private IterativeNode next;
	private String element;
	public IterativeNode(String e)
	{
		this.element = e;
	}	
	public IterativeNode next()
	{
		return this.next;
	}
	public String  str()
	{
		return this.element;
	}
	public void setNext(IterativeNode n)
	{
		this.next = n;
	}

}
