
public class IterativeNode
{
	private String s;
	private IterativeNode n;
	
	public IterativeNode(String s, IterativeNode n)
	{
		this.s = s;
		this.n = n;
	}
	
	public String getString()
	{
		return s;
	}
	
	public IterativeNode getNext()
	{
		return n;
	}
	
	public IterativeNode setNext(IterativeNode next)
	{
		this.n = next; 
		return next;
	}
}
