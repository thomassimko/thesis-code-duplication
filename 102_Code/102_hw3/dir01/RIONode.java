
public class RIONode implements RecursiveIONode {

	private String element;
	private RecursiveIONode node;
	public RIONode(String element)
	{
		this.element = element;
		this.node = new RIOEmpty();
	}
	public RecursiveIONode next()
	{
		return node;
	}
	public String str()
	{
		return element;
	}
	public void setNext(RecursiveIONode n)
	{
		node = n;
	}
}
