
public class ROOEmpty implements RecursiveOONode 
{
	public String getStr() 
	{
		return null;//throw new UnsupportedOperationException();
	}

	public RecursiveOONode getNext() 
	{
		return null;//throw new UnsupportedOperationException();
	}

	public void setNext(RecursiveOONode n) 
	{
		//throw new UnsupportedOperationException();
	}

	public void addToEnd(String element)
	{
		RecursiveOONode start = new ROONode(element, this);
	}	 
	 
	public void add(int index, String element)
	{
		//if(index > 0)
		//{
	   	//	throw new IndexOutOfBoundsException();
		//}
		RecursiveOONode start = new ROONode(element, this);
	}
	 
	public String remove(int index)
	{
		return null;//throw new UnsupportedOperationException();
	}
	 
	public String get(int index)
	{
		return null;//throw new UnsupportedOperationException();
	}
	 
	public int indexOf(String element)
	{
		return 0;//throw new UnsupportedOperationException();
	}
	 
	public int size()
	{
		return 0;
	}
	 
	public StringList toLowerCase()
	{
		return null;//throw new UnsupportedOperationException();
	}
	 
	public StringList toUpperCase()
	{
		return null;//throw new UnsupportedOperationException();
	}
	 
	public StringList startsWith(String prefix)
	{
		return null;//throw new UnsupportedOperationException();
	}
	 
	public StringList hasSubstring(String substring)
	{
		return null;//throw new UnsupportedOperationException();
	}
	
}
