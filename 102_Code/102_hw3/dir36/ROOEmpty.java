
public class ROOEmpty
implements RecursiveOONode
{

	public RecursiveOONode addToEnd(String element)
	{
		RecursiveOONode n = new ROONode(element, this);
		return n;
	}

	public RecursiveOONode add(int index, String element)
	{
		if(index!= 0)
		{
			throw new IndexOutOfBoundsException();
		}
		RecursiveOONode n = new ROONode(element, this);
		return n;
	}

	public RecursiveOONode remove(int index)
	{
		throw new IndexOutOfBoundsException("Index Out Of Bounds");
	}

	public String get(int index)
	{
		throw new IndexOutOfBoundsException("Index Out Of Bounds");
	}

	public int indexOf(String element)
	{
		throw new UnsupportedOperationException("No Such Element");
	}

	public int size() {
		return 0;
	}

	public RecursiveOONode toLowerCase()
	{
		RecursiveOONode n = new ROOEmpty();
		return n;
	}

	public RecursiveOONode toUpperCase()
	{
		RecursiveOONode n = new ROOEmpty();
		return n;
	}

	public RecursiveOONode startsWith(String prefix)
	{
		RecursiveOONode n = new ROOEmpty();
		return n;
	}

	public RecursiveOONode hasSubstring(String substring)
	{
		RecursiveOONode n = new ROOEmpty();
		return n;
	}

}
