
public class RIONode implements RecursiveIONode 
{
	private String data;
	private RecursiveIONode next;
	
	public RIONode(String data, RecursiveIONode next)
	{
		this.data = data;
		this.next = next;
	}
	
	public String getData()
	{
		return this.data;
	}
	
	public RecursiveIONode getNext()
	{
		return this.next;
	}

	public void setNext(RecursiveIONode n) 
	{
		this.next = n;		
	}
}
