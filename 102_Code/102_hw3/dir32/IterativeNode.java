
public class IterativeNode 
{
	private String data;
	private IterativeNode next;
	
	public IterativeNode(String data, IterativeNode next)
	{
		this.data = data;
		this.next = next;
	}
	
	public String getData()
	{
		return data;
	}
	
	public IterativeNode getNext()
	{
		return next;
	}
	
	public void setNext(IterativeNode n)
	{
		this.next = n;
	}
}
