public class ROONode 
	implements RecursiveOONode
{
	private String string;
	private RecursiveOONode next;
	
	public ROONode(String s, RecursiveOONode next)
	{
		this.string = s;
		this.next = next;
	}
	
	@Override
	public RecursiveOONode getNext()
	{
		return this.next;
	}

	@Override
	public String getString()
	{
		return this.string;
	}

	@Override
	public RecursiveOONode addToEnd(String element)
	{
		next = next.addToEnd(element);
		return this;
	}

	@Override
	public RecursiveOONode add(int index, String element)
	{
		if(index == 0)
		{
			RecursiveOONode node = new ROONode(element, this);
			return node;
		}
		else
		{
			next = next.add(index-1, element);
		}
		return this;
	}

	@Override
	public RecursiveOONode remove(int index)
	{
		if(index < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		if(index == 0)
		{
			return this.next;
		}
		else
		{
			this.next = next.remove(index-1);
			return this;
		}
	}

	@Override
	public RecursiveOONode get(int index)
	{
		if(index < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		if(index == 0)
		{
			return this;
		}
		else
		{
			return next.get(index-1);
		}
	}

	@Override
	public int indexOf(String element)
	{
		if(this.string.equals(element))
		{
			return 0;
		}
		else
		{
			return 1 + this.next.indexOf(element);
		}
		
	}

	@Override
	public int size()
	{
		return 1 + next.size();
	}

	@Override
	public StringList toLowerCase()
	{
		StringList sl = next.toLowerCase();
		sl.add(0, this.string.toLowerCase());
		return sl;
	}

	@Override
	public StringList toUpperCase()
	{
		StringList sl = next.toUpperCase();
		sl.add(0, this.string.toUpperCase());
		return sl;
	}

	@Override
	public StringList startsWith(String prefix)
	{
		StringList sl = next.startsWith(prefix);
		
		if(this.string.startsWith(prefix))
		{
			sl.add(0, this.string);
		}
		return sl;
	}

	@Override
	public StringList hasSubstring(String substring)
	{
		StringList sl = next.hasSubstring(substring);
		
		if(this.string.contains(substring))
		{
			sl.add(0, this.string);
		}
		return sl;
	}
}
