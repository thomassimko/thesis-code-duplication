
public class RIONode implements RecursiveIONode 
{
	private String str;
	private RecursiveIONode next;

	public RIONode(String message, RecursiveIONode next)
	{
		this.str = message;
		this.next = next;
	}

	public String getStr() 
	{
		return str;
	}

	public RecursiveIONode getNext() 
	{
		return next;
	}

	public void setNext(RecursiveIONode n) 
	{
		next = n;
	}

	

}
