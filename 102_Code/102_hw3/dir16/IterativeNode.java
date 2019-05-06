public class IterativeNode
{
	private String str;
	private IterativeNode next;
	
	public IterativeNode(String str, IterativeNode next)
	{
		this.str = str;
		this.next = next;
	}
	
	public String getString()
	{
		return this.str;
	}
	
	public IterativeNode getNext()
	{
		return this.next;
	}
	
	public void setNext(IterativeNode n)
	{
		this.next = n;
	}
}
