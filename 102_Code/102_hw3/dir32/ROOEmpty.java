import java.util.NoSuchElementException;


public class ROOEmpty implements RecursiveOONode 
{
	public ROOEmpty()
	{
		
	}
	@Override
	public RecursiveOONode addToEnd(String element) 
	{
		ROONode n = new ROONode(element, this);
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
	public RecursiveOONode toLowerCase() 
	{
		ROOEmpty e = new ROOEmpty();
		return e;
	}

	@Override
	public RecursiveOONode toUpperCase() 
	{
		ROOEmpty e = new ROOEmpty();
		return e;
	}

	@Override
	public RecursiveOONode startsWith(String prefix) 
	{
		ROOEmpty e = new ROOEmpty();
		return e;
	}

	@Override
	public RecursiveOONode hasSubstring(String substring) 
	{
		ROOEmpty e = new ROOEmpty();
		return e;
	}

	@Override
	public RecursiveOONode getNext() 
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public String getData() 
	{
		throw new UnsupportedOperationException();
	}

}
