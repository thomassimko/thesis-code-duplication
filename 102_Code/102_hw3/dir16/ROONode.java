public class ROONode
	implements RecursiveOONode
{
	private String str;
	private RecursiveOONode next;

	public ROONode(String str, RecursiveOONode next)
	{
		this.str = str;
		this.next = next;
	}

	public RecursiveOONode addToEnd(String element)
	{
		this.next = this.next.addToEnd(element);
		return this;
	}
	
	public RecursiveOONode add(int index, String element)
	{
		if(index == 0)
		{
			return new ROONode(element, this);
		}

		this.next = this.next.add(index-1, element);
		return this;
	}
	
	public String remove(int index)
	{
		if(index == 1)
		{
			String delete = this.next.getString();
			this.next = this.next.getNext();
			return delete;
		}

		return this.next.remove(index-1);
	}
	
	public String get(int index)
	{
		if(index < 0)
		{
			throw new IndexOutOfBoundsException();
		}

		if(index == 0)
		{
			return this.str;
		}

		return this.next.get(index-1);
	}
	
	public int indexOf(String element)
	{
		if(this.str.equals(element))
		{
			return 0;
		}

		return 1 + this.next.indexOf(element);
	}
	
	public int size()
	{
		return 1 + this.next.size();
	}
	
	public StringList toLowerCase()
	{
		StringList newList = this.next.toLowerCase();
		newList.add(0, this.str.toLowerCase());

		return newList;
	}
	
	public StringList toUpperCase()
	{
		StringList newList = this.next.toUpperCase();
		newList.add(0, this.str.toUpperCase());

		return newList;
	}
	
	public StringList startsWith(String prefix)
	{
		StringList newList = this.next.startsWith(prefix);
		if(this.str.startsWith(prefix))
		{
			newList.add(0, this.str);
		}

		return newList;
	}
	
	public StringList hasSubstring(String substring)
	{
		StringList newList = this.next.hasSubstring(substring);
		if(this.str.contains(substring))
		{
			newList.add(0, this.str);
		}

		return newList;
	}
	
	public String getString()
	{
		return this.str;
	}

	public RecursiveOONode getNext()
	{
		return this.next;
	}
}
