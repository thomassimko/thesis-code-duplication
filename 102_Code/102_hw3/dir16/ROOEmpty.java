import java.util.NoSuchElementException;

public class ROOEmpty
	implements RecursiveOONode
{
	public RecursiveOONode addToEnd(String element)
	{
		return new ROONode(element, this);
	}
	
	public RecursiveOONode add(int index, String element)
	{		
		if(index != 0)		// Only index in an empty list is 0
		{
			throw new IndexOutOfBoundsException();
		}

		return new ROONode(element, this);
	}
	
	public String remove(int index)
	{
		throw new IndexOutOfBoundsException();
	}
	
	public String get(int index)
	{
		throw new IndexOutOfBoundsException();
	}
	
	public int indexOf(String element)
	{
		throw new NoSuchElementException();
	}
	
	public int size()
	{
		return 0;
	}
	
	public StringList toLowerCase()
	{
		return new RecursiveOOStringList();	// return an empty list
	}
	
	public StringList toUpperCase()
	{
		return new RecursiveOOStringList();	// return an empty list
	}
	
	public StringList startsWith(String prefix)
	{
		return new RecursiveOOStringList();	// return an empty list
	}
	
	public StringList hasSubstring(String substring)
	{
		return new RecursiveOOStringList();	// return an empty list
	}

	public String getString()
	{
		throw new UnsupportedOperationException();
	}
	
	public RecursiveOONode getNext()
	{
		throw new UnsupportedOperationException();
	}
}
