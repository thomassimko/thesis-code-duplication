
public class RIONode 
implements RecursiveIONode
{
	public String val;
	public RecursiveIONode next;
	public RIONode (String value, RecursiveIONode nextNode)
	{
		val=value;
		next= nextNode;
	}
	public String getValue()
	{
		return val;
	}
	public RecursiveIONode next()
	{
		return next;
	}
	public void setNext(RecursiveIONode n)
	{
		next=n;
	}
}
