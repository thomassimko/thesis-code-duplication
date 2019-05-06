public class ROONode
	implements RecursiveOONode
{
	private String name;
	private RecursiveOONode next;
	public ROONode(String name, RecursiveOONode next)
	{
		this.name = name;
		this.next = next;
	}
	public String getName()
	{
		return this.name;
	}
	public RecursiveOONode getNext()
	{
		return this.next;
	}
	public RecursiveOONode addToFront(String element)
	{
		RecursiveOONode n = new ROONode(element, this);
		return n;
	}
   public RecursiveOONode addToEnd(String element)
	{
		this.next = this.next.addToEnd(element);
		return this;
	}
	public RecursiveOONode add(int index, String element)
	{
		if (index==0)
		{
			RecursiveOONode n = new ROONode(element, this);
			return n;
		}
		else
		{
			next = next.add(index-1, element);
		}
		return this;
	}
	public RecursiveOONode remove(int index)
	{
		if (index==0)
		{
			RecursiveOONode ret = new ROONode(this.name, this.next);
			return this.next;
		}
		else if (index==1)
		{
			RecursiveOONode ret = new ROONode(next.getName(), next.getNext());
			next = next.getNext();
			return ret;
		}
		else
		{
			next = next.remove(index-1);
		}
		return this;
	}
   public String get(int index)
	{
		String want;
		if (index==0)
		{
			want = this.name;
		}
		else
		{
			want = next.get(index-1);
		}
		return want;
	}
   public int indexOf(String element)
	{
		int index = 0;
		if (element.equals(this.name))
		{
			return 0;
		}
		else
		{
			index = next.indexOf(element)+1;
		}
		return index;
	}
   public int size()
	{
		int count = 0;
		count = next.size();
		return count+1;
	}
   public StringList toLowerCase()
	{
		StringList list = next.toLowerCase();
		((RecursiveOOStringList)list).addToFront(this.name.toLowerCase());
		return (RecursiveOOStringList)list;
	}
   public StringList toUpperCase()
	{
		StringList list = next.toLowerCase();
		((RecursiveOOStringList)list).addToFront(this.name.toUpperCase());
		return list;
	}
   public StringList startsWith(String prefix)
	{
		StringList list = next.startsWith(prefix);
		if (this.name.startsWith(prefix))
		{
			((RecursiveOOStringList)list).addToFront(this.name);
		}
		return list;
	}
   public StringList hasSubstring(String substring)
	{
		StringList list = next.hasSubstring(substring);
		if (this.name.contains(substring))
		{
			((RecursiveOOStringList)list).addToFront(this.name);
		}
		return list;
	}
}
