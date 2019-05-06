public class RIONode
	implements RecursiveIONode
{
	private String name;
	private RecursiveIONode next;
	public RIONode(String name, RecursiveIONode next)
	{
		this.name = name;
		this.next = next;
	}
	public String getName()
	{
		return this.name;
	}
	public RecursiveIONode getNext()
	{
		return this.next;
	}
	public void setNext(RecursiveIONode next)
	{
		this.next = next;
	}
}