
public class RIONode 
	implements RecursiveIONode
{
	private String string;
	private RecursiveIONode next;
	
	public RIONode(String string, RecursiveIONode next)
	{
		this.string = string;
		this.next = next;
	}
	
	@Override
	public RecursiveIONode getNext()
	{
		return this.next;
	}

	@Override
	public String getString()
	{
		return this.string;
	}

	@Override
	public void setNext(RecursiveIONode node)
	{
		this.next = node;
	}
	
}
