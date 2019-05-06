public class IterativeNode
{
	private String string;
	private IterativeNode next;
	
	public IterativeNode(String string, Node next)
	{
		this.string = string;
		this.next = next;
	}
	
	public String getString()
	{
		return this.string;
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