public class RIOEmpty 
	implements RecursiveIONode
{

	@Override
	public RecursiveIONode getNext()
	{
		throw new IndexOutOfBoundsException();
	}

	@Override
	public String getString()
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public void setNext(RecursiveIONode node)
	{
		throw new UnsupportedOperationException();
	}

}
