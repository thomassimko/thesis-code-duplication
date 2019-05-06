import java.lang.UnsupportedOperationException;

public class RIOEmpty
	implements RecursiveIONode
{
	public String thisString()
	{
		throw new UnsupportedOperationException();
	}
	
	public RecursiveIONode nextNode()
	{
		throw new UnsupportedOperationException();
	}

	public void setNext(RecursiveIONode next)
	{
		throw new UnsupportedOperationException();
	}
}
