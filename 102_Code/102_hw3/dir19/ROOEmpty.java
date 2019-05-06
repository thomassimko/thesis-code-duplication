import java.lang.UnsupportedOperationException;
import java.lang.IndexOutOfBoundsException;

public class ROOEmpty
	implements RecursiveOONode
{
	public String thisString()
	{
		throw new UnsupportedOperationException();
	}

	public RecursiveOONode nextNode()
	{
		throw new UnsupportedOperationException();
	}

	public RecursiveOONode addToEnd(String element)
	{
		ROONode n = new ROONode(element,this);
		return n;
	}

   public RecursiveOONode add(int index, String element)
	{
		if (index != 0)
		{
			throw new IndexOutOfBoundsException();
		}
		else
		{
			RecursiveOONode n = new ROONode(element,this);
			return n;
		}
	}
			
   public RecursiveOONode remove(int index)
	{
		throw new UnsupportedOperationException();
	}

   public String get(int index)
	{
		throw new UnsupportedOperationException();
	}

   public int indexOf(String element)
	{
		throw new UnsupportedOperationException();
	}

   public int size()
	{
		return 0;
	}

   public StringList toLowerCase()
	{
		throw new UnsupportedOperationException();
	}

   public StringList toUpperCase()
	{
		throw new UnsupportedOperationException();
	}

   public StringList startsWith(String prefix)
	{
		throw new UnsupportedOperationException();
	}

   public StringList hasSubstring(String substring)
	{
		throw new UnsupportedOperationException();
	}
}















