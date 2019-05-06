import java.util.NoSuchElementException;

public class ROOEmpty
	implements RecursiveOONode
{
	public RecursiveOONode addToEnd(String element)
	{
		RecursiveOONode n = new ROONode(element, this);
		return n;
	}
	public String getName()
	{
		throw new UnsupportedOperationException();
	}
	public RecursiveOONode getNext()
	{
		throw new UnsupportedOperationException();
	}
	public RecursiveOONode addToFront(String element)
	{
		RecursiveOONode n = new ROONode(element, this);
		return n;
	}
   public RecursiveOONode add(int index, String element)
	{
		if (index!=0)
		{
			throw new IndexOutOfBoundsException();
		}
		RecursiveOONode n = new ROONode(element, this);
		return n;
	}
   public RecursiveOONode remove(int index)
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
		return new RecursiveOOStringList();
	}
   public StringList toUpperCase()
	{
		return new RecursiveOOStringList();
	}
   public StringList startsWith(String prefix)
	{
		return new RecursiveOOStringList();
	}
   public StringList hasSubstring(String substring)
	{
		return new RecursiveOOStringList();
	}
}