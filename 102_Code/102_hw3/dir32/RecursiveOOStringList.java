
public class RecursiveOOStringList implements StringList
{
	private RecursiveOONode head;
	
	public RecursiveOOStringList()
	{
		head = new ROOEmpty();
	}
	
	@Override
	public void addToEnd(String element) 
	{
		head = head.addToEnd(element);
	}

	@Override
	public void add(int index, String element) 
	{
		head = head.add(index, element);
	}

	@Override
	public void remove(int index) 
	{
		head.remove(index);
	}

	@Override
	public String get(int index) 
	{
		return head.get(index);
	}

	@Override
	public int indexOf(String element) 
	{
		return head.indexOf(element);
	}

	@Override
	public int size() 
	{
		return head.size();
	}

	@Override
	public StringList toLowerCase() 
	{
		RecursiveOOStringList n = new RecursiveOOStringList();
		n.head = this.head.toLowerCase();
		return n;
	}

	@Override
	public StringList toUpperCase() 
	{
		RecursiveOOStringList n = new RecursiveOOStringList();
		n.head = this.head.toUpperCase();
		return n;
	}

	@Override
	public StringList startsWith(String prefix)
	{
		RecursiveOOStringList n = new RecursiveOOStringList();
		n.head = this.head.startsWith(prefix);
		return n;
	}

	@Override
	public StringList hasSubstring(String substring) 
	{
		RecursiveOOStringList n = new RecursiveOOStringList();
		n.head = this.head.hasSubstring(substring);
		return n;
	}
}
