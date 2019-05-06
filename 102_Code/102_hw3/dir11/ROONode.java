
public class ROONode implements RecursiveOONode
{
	private String value;
	private RecursiveOONode next;

	public ROONode(String value, RecursiveOONode next)
	{
		this.value = value;
		this.next = next;
	}
	
	@Override
	public String getString()
	{
		return value;
	}

	@Override
	public RecursiveOONode getNext()
	{
		return next;
	}

	@Override
	public RecursiveOONode addToEnd(String element)
	{
		RecursiveOONode n = next.addToEnd(element);
		next = n;
		return this;
	}

	@Override
	public RecursiveOONode add(int index, String element)
	{
		if(index == 0)
		{
			RecursiveOONode n = new ROONode(element, this);
			return n;
		}
		else
		{
			next = next.add(index - 1, element);
			return this;
		}
	}

	@Override
	public RecursiveOONode remove(int index)
	{
		if(index == 0)
		{
			RecursiveOONode n = this.next;
			this.next = this.getNext().getNext();
			return n;
		}
		else
		{
			next = next.remove(index - 1);
			return this;
		}
	}

	@Override
	public String get(int index)
	{
		if(index == 0)
		{
			return this.value;
		}
		else
		{
			return next.get(index - 1);
		}
	}

	@Override
	public int indexOf(String element)
	{
		if(this.getString().equals(element))
		{
			return 0;
		}
		else
		{
			return 1 + this.getNext().indexOf(element);
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
		StringList l = new RecursiveOOStringList();
		l = this.next.toLowerCase();
		l.add(0, this.value.toLowerCase());
		return l;
	}

	@Override
	public StringList toUpperCase()
	{
		StringList l = new RecursiveOOStringList();
		l = this.next.toUpperCase();
		l.add(0, this.value.toUpperCase());
		return l;
	}

	@Override
	public StringList startsWith(String prefix)
	{
		StringList l = new RecursiveOOStringList();
		l = this.next.startsWith(prefix);
		if(this.value.startsWith(prefix))
		{
			l.add(0, this.value);
		}
		return l;
	}

	@Override
	public StringList hasSubstring(String substring)
	{
		StringList l = new RecursiveOOStringList();
		l = this.next.hasSubstring(substring);
		if(this.value.contains(substring))
		{
			l.add(0, this.value);
		}
		return l;
	}

}
