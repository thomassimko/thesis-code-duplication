
public class RecursiveOOStringList
implements StringList
{
	private RecursiveOONode head;
	
	public RecursiveOOStringList()
	{
		head = new ROOEmpty();
	}
	public void changeHead(RecursiveOONode h)
	{
		head = h;
	}
	public void addToEnd(String element)
	{
		head = head.addToEnd(element);
	}

	public void add(int index, String element)
	{
		head = head.add(index, element);
	}
	
	public String remove(int index)
	{
		String v = get(index);
		head = head.remove(index);
		return v;
	}

	public String get(int index)
	{
		String v= head.get(index);
		return v;
	}

	public int indexOf(String element)
	{
		int i = head.indexOf(element);
		return i;
	}

	public int size()
	{
		int i = head.size();
		return i;
	}
	
	public StringList toLowerCase()
	{
		RecursiveOOStringList r = new RecursiveOOStringList();
		r.changeHead(head.toLowerCase()); 
		return r;
	}

	public StringList toUpperCase()
	{
		RecursiveOOStringList r = new RecursiveOOStringList();
		r.changeHead(head.toUpperCase());
		return r;
	}

	public StringList startsWith(String prefix)
	{
		RecursiveOOStringList r = new RecursiveOOStringList();
		r.changeHead(head.startsWith(prefix));
		return r;
	}

	public StringList hasSubstring(String substring) 
	{
		RecursiveOOStringList r = new RecursiveOOStringList();
		r.changeHead(head.hasSubstring(substring));
		return r;
	}

}
