
public class RIOEmpty
implements RecursiveIONode
{

	public RecursiveIONode next()
	{
		throw new UnsupportedOperationException("Index Out Of Bounds");
	}

	public String getValue()
	{
		throw new UnsupportedOperationException("It's Empty");
	}

	public void setNext(RecursiveIONode n)
	{
		throw new UnsupportedOperationException("a");
	}
	
}
