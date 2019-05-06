public class RecursiveOOStringList
{
	private RecursiveOONode head;
	
	public RecursiveOOStringList(RecursiveOONode head)
	{
		this.head = head;
	}
	
	public RecursiveOONode addToEnd(String element)
	{
		return head.addToEnd(element);
	}

	public RecursiveOONode add(int index, String element)
	{
		return head.add(index,element);
	}
	
	public String remove(int index)
	{
		return head.remove(index).thisString();
	}
	
	public String get(int index)
	{
		return head.get(index);
	}

	public int indexOf(String element)
	{
		return head.indexOf(element);
	}

	public int size()
	{
		return head.size();
	}
	
	public StringList toLowerCase()
	{
		return head.toLowerCase();
	}

	public StringList toUpperCase()
	{
		return head.toUpperCase();
	}
	
	public StringList startsWith(String prefix)
	{
		return head.startsWith(prefix);
	}
	
	public StringList hasSubstring(String substring)
	{
		return head.hasSubstring(substring);
	}	
}
	
