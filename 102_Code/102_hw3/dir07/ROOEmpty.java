import java.util.NoSuchElementException;

public class ROOEmpty 
	implements RecursiveOONode
{
	@Override
	public RecursiveOONode getNext()
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public String getString()
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public RecursiveOONode addToEnd(String element)
	{
		RecursiveOONode node = new ROONode(element, this);
		return node;
	}

	@Override
	public RecursiveOONode add(int index, String element)
	{
		if(index!=0)
		{
			throw new IndexOutOfBoundsException();
		}
		RecursiveOONode node = new ROONode(element, this);
		return node;
	}

	@Override
	public RecursiveOONode remove(int index)
	{
		throw new IndexOutOfBoundsException();
	}

	@Override
	public RecursiveOONode get(int index)
	{
		throw new IndexOutOfBoundsException();
	}

	@Override
	public int indexOf(String element)
	{
		throw new NoSuchElementException();
	}

	@Override
	public int size()
	{
		return 0;
	}

	@Override
	public StringList toLowerCase()
	{
		StringList sl = new RecursiveOOStringList();
		return sl;
	}

	@Override
	public StringList toUpperCase()
	{
		StringList sl = new RecursiveOOStringList();
		return sl;
	}

	@Override
	public StringList startsWith(String prefix)
	{
		StringList sl = new RecursiveOOStringList();
		return sl;
	}

	@Override
	public StringList hasSubstring(String substring)
	{
		StringList sl = new RecursiveOOStringList();
		return sl;
	}

}
