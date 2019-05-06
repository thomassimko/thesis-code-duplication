
public class RecursiveIOStringList implements StringList
{
	RecursiveIONode head;
	
	public RecursiveIOStringList()
	{
		head = new RIOEmpty();
	}

	@Override
	public void addToEnd(String element)
	{
		head = addToEnd(element, head);
	}
	
	private RecursiveIONode addToEnd(String element, RecursiveIONode cur)
	{
		if(cur instanceof RIOEmpty)
		{
			return new RIONode(element, cur);
		}
		else
		{
			cur.setNext(addToEnd(element, cur.getNext()));
			return cur;
		}
	}

	@Override
	public void add(int index, String element)
	{
		head = add(index, element, head);
	}
	
	private RecursiveIONode add(int index, String element, RecursiveIONode cur)
	{
		if(cur instanceof RIOEmpty)
		{
			if(index != 0)
			{
				throw new IndexOutOfBoundsException();
			}
			return new RIONode(element, cur);
		}
		else
		{
			if(index == 0)
			{
				RecursiveIONode n = new RIONode(element, cur);
				return n;
			}
			else
			{
				cur.setNext(add(index - 1, element, cur.getNext()));
				return cur;
			}
		}
	}

	@Override
	public String remove(int index)
	{
		String s;
		s = remove(index, head).getString();
		return s;
	}
	
	private RecursiveIONode remove(int index, RecursiveIONode cur)
	{
		if(cur instanceof RIOEmpty)
		{
			throw new IndexOutOfBoundsException();
		}
		else
		{
			if(index == 0)
			{
				RecursiveIONode temp = cur.getNext();
				cur.setNext(cur.getNext().getNext());
				return temp;
			}
			else
			{
				cur.setNext(remove(index - 1, cur.getNext()));
				return cur;
			}
		}
	}

	@Override
	public String get(int index)
	{
		return get(index, head);
	}
	
	private String get(int index, RecursiveIONode cur)
	{
		if(index == 0)
		{
			if(cur instanceof RIOEmpty)
			{
				return null;
			}
			else
			{
				return cur.getString();
			}
		}
		else
		{
			if(cur instanceof RIOEmpty)
			{
				throw new IndexOutOfBoundsException();
			}
			else
			{
				return get(index - 1, cur.getNext());
			}
		}
	}

	@Override
	public int indexOf(String element)
	{
		return indexOf(element, head);
	}
	
	private int indexOf(String element, RecursiveIONode cur)
	{
		if(cur instanceof RIOEmpty)
		{
			throw new IndexOutOfBoundsException();
		}
		else
		{
			if(cur.getString().equals(element))
			{
				return 0;
			}
			else
			{
				return 1 + indexOf(element, cur.getNext());
			}
		}
	}

	@Override
	public int size()
	{
		return size(head);
	}
	
	private int size(RecursiveIONode cur)
	{
		if(cur instanceof RIOEmpty)
		{
			return 0;
		}
		else
		{
			return 1 + size(cur.getNext());
		}
	}

	@Override
	public StringList toLowerCase()
	{
		return toLowerCase(head);
	}
	
	private StringList toLowerCase(RecursiveIONode cur)
	{
		if(cur instanceof RIOEmpty)
		{
			return new RecursiveIOStringList();
		}
		else 
		{
			StringList l = new RecursiveIOStringList();
			l = toLowerCase(cur.getNext());
			l.add(0, cur.getString().toLowerCase());
			return l;
		}
	}

	@Override
	public StringList toUpperCase()
	{
		return toUpperCase(head);
	}

	private StringList toUpperCase(RecursiveIONode cur)
	{
		if(cur instanceof RIOEmpty)
		{
			return new RecursiveIOStringList();
		}
		else 
		{
			StringList l = new RecursiveIOStringList();
			l = toUpperCase(cur.getNext());
			l.add(0, cur.getString().toUpperCase());
			return l;
		}
	}
	
	@Override
	public StringList startsWith(String prefix)
	{
		return startsWith(prefix, head);
	}
	
	private StringList startsWith(String prefix, RecursiveIONode cur)
	{
		if(cur instanceof RIOEmpty)
		{
			return new RecursiveIOStringList();
		}
		else 
		{
			StringList l = new RecursiveIOStringList();
			l = startsWith(prefix, cur.getNext());
			if(cur.getString().startsWith(prefix))
			{
				l.add(0, cur.getString());
			}
			return l;
		}
	}

	@Override
	public StringList hasSubstring(String substring)
	{
		return hasSubString(substring, head);
	}

	private StringList hasSubString(String substring, RecursiveIONode cur)
	{
		if(cur instanceof RIOEmpty)
		{
			return new RecursiveIOStringList();
		}
		else 
		{
			StringList l = new RecursiveIOStringList();
			l = hasSubString(substring, cur.getNext());
			if(cur.getString().contains(substring))
			{
				l.add(0, cur.getString());
			}
			return l;
		}
	}
}
