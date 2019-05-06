

public class ROOEmpty implements RecursiveOONode 
{

	
	public RecursiveOONode addToEnd(String element) 
	{
		RecursiveOONode n = new ROONode(element, this);
		return n;
	}

	public RecursiveOONode add(int index, String element) 
	{
		if (index != 0)
		{
			throw new IndexOutOfBoundsException();
		}
		RecursiveOONode n = new ROONode(element, this);
		return n;
	}
	
	public RecursiveOONode remove(int index) 
	{
		throw new UnsupportedOperationException();
	}

	public String get(int index) 
	{
		throw new UnsupportedOperationException();
	}
	
	public int indexOf(String element, int index) 
	{
		throw new UnsupportedOperationException();
	}

	public int size(int curSize) 
	{
		return curSize;
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
