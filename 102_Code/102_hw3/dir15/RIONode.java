
public class RIONode 
	implements RecursiveIONode 
{
	private RecursiveIONode next;
	private String string;
	
	public RIONode(String string, RecursiveIONode next)
	{
        this.string = string;
        this.next = next;
	}
	
	public RecursiveIONode getNext() 
	{
		return this.next;
	}

	@Override
	public String getValue() 
	{
		return this.string;
	}

	@Override
	public RecursiveIONode setNext(RecursiveIONode n) 
	{
		this.next = n;
		return n;
	}

}
