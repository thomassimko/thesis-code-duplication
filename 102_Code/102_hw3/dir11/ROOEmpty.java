import java.util.NoSuchElementException;


public class ROOEmpy implements RecursiveOONode
{
	@Override
	public String getString()
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public RecursiveOONode getNext()
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public RecursiveOONode addToEnd(String element)
	{
		RecursiveOONode n = new ROONode(element, this);
		return n;
	}

	@Override
	public RecursiveOONode add(int index, String element)
	{
		if(index != 0)
		{
			throw new IndexOutOfBoundsException();
		}
		RecursiveOONode n = new ROONode(element, this);
		return n;
	}

	@Override
	public RecursiveOONode remove(int index)
	{
		throw new IndexOutOfBoundsException();
	}	

	@Override
	public String get(int index)
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
		return new RecursiveOOStringList();
	}

	@Override
	public StringList toUpperCase()
	{
		return new RecursiveOOStringList();
	}

	@Override
	public StringList startsWith(String prefix)
	{
		return new RecursiveOOStringList();
	}

	@Override
	public StringList hasSubstring(String substring)
	{
		return new RecursiveOOStringList();
	}

}
