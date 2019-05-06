
public class RIONode implements RecursiveIONode
{
	String value;
	RecursiveIONode next;
	
	public RIONode(String value, RecursiveIONode next)
	{
		this.value = value;
		this.next = next;
	}
	
	@Override
	public String getString()
	{
		return this.value;
	}

	@Override
	public RecursiveIONode getNext()
	{
		return this.next;
	}

	@Override
	public void setNext(RecursiveIONode n)
	{
		this.next = n;
	}

}
