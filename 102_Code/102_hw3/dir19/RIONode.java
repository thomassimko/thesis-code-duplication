public class RIONode
	implements RecursiveIONode
{
	private String myString;
	private RecursiveIONode myNode;
	
	public RIONode(String myString, RecursiveIONode myNode)
	{
		this.myString = myString;
		this.myNode = myNode;
	}

	public String thisString()
	{
		return this.myString;
	}
	
	public RecursiveIONode nextNode()
	{
		return this.myNode;
	}

	public void setNext(RecursiveIONode next)
	{
		this.myNode = next;
	}
}
