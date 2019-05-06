public class RecursiveIOStringList 
	implements StringList
{
	private RecursiveIONode head;
	
	public RecursiveIOStringList()
	{
		this.head = new RIOEmpty();
	}
	
	@Override
	public void addToEnd(String element)
	{
		head = addToEndHelper(element, head);
	}
	
	private RecursiveIONode addToEndHelper(String element, RecursiveIONode cur)
	{
		if(cur instanceof RIOEmpty)
		{
			RecursiveIONode node = new RIONode(element, cur);
			return node;
		}
		else
		{
			RecursiveIONode node = addToEndHelper(element, cur.getNext());
			cur.setNext(node);
			return cur;
		}
	}

	@Override
	public void add(int index, String element)
	{
		head = addHelper(index, element, head);
	}
	
	private RecursiveIONode addHelper(int index, String element, RecursiveIONode cur)
	{
		if(cur instanceof RIOEmpty)
		{
			RecursiveIONode node = new RIONode(element, cur);
			return node;
		}
		else if(cur instanceof RIONode)
		{
			if(index == 0)
			{
				RecursiveIONode node = new RIONode(element, cur);
				return node;
			}
			else
			{
				RecursiveIONode node = addHelper(index-1, element, cur.getNext());
				cur.setNext(node);
				return cur;
			}
		}
		else
		{
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public void remove(int index)
	{
		head = removeHelper(index, head);
	}
	
	private RecursiveIONode removeHelper(int index, RecursiveIONode cur)
	{
		if(cur instanceof RIOEmpty)
		{
			RecursiveIONode node = new RIOEmpty();
			return node;
		}
		else
		{
			if(index<0)
			{
				throw new IndexOutOfBoundsException();
			}
			else if(index==0)
			{
				return cur.getNext();
			}
			else
			{
				RecursiveIONode node = removeHelper(index-1, cur.getNext());
				cur.setNext(node);
				return cur;
			}
		}
	}

	@Override
	public String get(int index)
	{
		RecursiveIONode node = getHelper(index, head);
		return node.getString();
	}
	
	private RecursiveIONode getHelper(int index, RecursiveIONode cur)
	{
		if(cur instanceof RIONode)
		{
			if(index == 0)
			{
				return cur;
			}
			else
			{
				RecursiveIONode node = getHelper(index-1, cur.getNext());
				return node;
			}
			
		}
		else
		{
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public int indexOf(String element)
	{
		return indexOfHelper(element, head);
	}
	
	private int indexOfHelper(String element, RecursiveIONode cur)
	{
		if(cur.getString().equals(element))
		{
			return 0;
		}
		else
		{
			return 1 + indexOfHelper(element, cur.getNext());
		}
	}

	@Override
	public int size()
	{
		return sizeHelper(head);
	}
	
	private int sizeHelper(RecursiveIONode cur)
	{
		if(cur instanceof RIOEmpty)
		{
			return 0;
		}
		else
		{
			return 1 + sizeHelper(cur.getNext());
		}
	}

	@Override
	public StringList toLowerCase()
	{
		return toLowerCaseHelper(head);
	}
	
	private StringList toLowerCaseHelper(RecursiveIONode cur)
	{
		if(cur instanceof RIOEmpty)
		{
			StringList sl = new RecursiveIOStringList();
			return sl;
		}
		StringList sl = toLowerCaseHelper(cur.getNext());
		sl.add(0, cur.getString().toLowerCase());
		return (RecursiveIOStringList) sl;
	}

	@Override
	public StringList toUpperCase()
	{
		return toUpperCaseHelper(head);
	}
	
	private StringList toUpperCaseHelper(RecursiveIONode cur)
	{
		if(cur instanceof RIOEmpty)
		{
			StringList sl = new RecursiveIOStringList();
			return sl;
		}
		StringList sl = toUpperCaseHelper(cur.getNext());
		sl.add(0, cur.getString().toUpperCase());
		return (RecursiveIOStringList) sl;
	}

	@Override
	public StringList startsWith(String prefix)
	{
		return startsWithHelper(prefix, head);
	}
	
	private StringList startsWithHelper(String prefix, RecursiveIONode cur)
	{
		if(cur instanceof RIOEmpty)
		{
			StringList sl = new RecursiveIOStringList();
			return sl;
		}
		StringList sl = startsWithHelper(prefix, cur.getNext());
		if(cur.getString().startsWith(prefix))
		{
			sl.add(0, cur.getString());
		}
		return sl;
	}

	@Override
	public StringList hasSubstring(String substring)
	{
		return hasSubstringHelper(substring, head);
	}
	
	private StringList hasSubstringHelper(String substring, RecursiveIONode cur)
	{
		if(cur instanceof RIOEmpty)
		{
			StringList sl = new RecursiveIOStringList();
			return sl;
		}
		StringList sl = hasSubstringHelper(substring, cur.getNext());
		if(cur.getString().contains(substring))			
		{
			sl.add(0, cur.getString());
		}
		return sl;
	}
}
