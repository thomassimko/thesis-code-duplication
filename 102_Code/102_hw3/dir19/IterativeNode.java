public class IterativeNode
{
	private String myString;
	private IterativeNode nextNode;
	
	public IterativeNode(String myString, IterativeNode nextNode)
	{
		this.myString = myString;
		this.nextNode = nextNode;
	}

	public IterativeNode thisNode()
	{
		return this;
	}

	public String toString()
	{
		return this.myString;
	}
	
	public IterativeNode toNode()
	{
		return this.nextNode;
	}
		
	public void setNext(IterativeNode node)
	{
		this.nextNode = node;
	}
}
	
	
