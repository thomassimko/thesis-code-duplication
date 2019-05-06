import java.util.NoSuchElementException;

public class RecursiveIOStringList
	implements StringList
{
	private RecursiveIONode head;
	
	public RecursiveIOStringList()
	{
		this.head = new RIOEmpty();
	}
	
	public void addToEnd(String element)
	{
		this.head = addToEnd(element, this.head);
	}
	
	private RecursiveIONode addToEnd(String element, RecursiveIONode cur)
	{
		if(cur instanceof RIOEmpty)
		{
			return new RIONode(element, cur);
		}
		
		RecursiveIONode next = addToEnd(element, ((RIONode)cur).getNext());
		((RIONode)cur).setNext(next);
		return cur;
	}
	
	public void add(int index, String element)
	{
		this.head = add(index, element, this.head);
	}
	
	private RecursiveIONode add(int index, String element, RecursiveIONode cur)
	{
		if(index == 0)
		{
			return new RIONode(element, cur);
		}
		else if(cur instanceof RIONode)
		{
			RecursiveIONode next  = add(index-1, element, ((RIONode)cur).getNext());
			((RIONode)cur).setNext(next);
			return cur;
		}

		throw new IndexOutOfBoundsException();
	}
	
	public String remove(int index)
	{
		if(index == 0)
		{
			String delete = ((RIONode)this.head).getString();
			this.head = ((RIONode)this.head).getNext();
			return delete;
		}

		return remove(index, this.head);
	}

	private String remove(int index, RecursiveIONode cur)
	{
		if(cur instanceof RIOEmpty)
		{
			throw new IndexOutOfBoundsException();
		}

		if(index == 1)
		{
			String delete = ((RIONode)((RIONode)cur).getNext()).getString();
			((RIONode)cur).setNext(((RIONode)((RIONode)cur).getNext()).getNext());
			return delete;
		}

		return remove(index-1, ((RIONode)cur).getNext());
	}
	
	public String get(int index)
	{
		return get(index, this.head);
	}

	private String get(int index, RecursiveIONode cur)
	{
		if(cur instanceof RIOEmpty)
		{
			throw new IndexOutOfBoundsException();
		}

		if(index == 0)
		{
			return ((RIONode)cur).getString();
		}

		return get(index-1, ((RIONode)cur).getNext());
	}
	
	public int indexOf(String element)
	{
		return indexOf(element, this.head);
	}

	private int indexOf(String element, RecursiveIONode cur)
	{
		if(cur instanceof RIOEmpty)
		{
			throw new NoSuchElementException();
		}

		if(((RIONode)cur).getString().equals(element))
		{
			return 0;
		}

		return 1 + indexOf(element, ((RIONode)cur).getNext());
	}
	
	public int size()
	{
		return size(this.head);
	}
	
	private int size(RecursiveIONode cur)
	{
		if(cur instanceof RIOEmpty)
		{
			return 0;
		}
		
		return 1 + size(((RIONode)cur).getNext());
	}
	
	public StringList toLowerCase()
	{
		return toLowerCase(this.head);
	}

	private StringList toLowerCase(RecursiveIONode cur)
	{
		if(cur instanceof RIOEmpty)
		{
			return new RecursiveIOStringList();
		}

		StringList newList = toLowerCase(((RIONode)cur).getNext());
		newList.add(0, ((RIONode)cur).getString().toLowerCase());
		return newList;
	}
	
	public StringList toUpperCase()
	{
		return toUpperCase(this.head);
	}

	private StringList toUpperCase(RecursiveIONode cur)
	{
		if(cur instanceof RIOEmpty)
		{
			return new RecursiveIOStringList();
		}

		StringList newList = toUpperCase(((RIONode)cur).getNext());
		newList.add(0, ((RIONode)cur).getString().toUpperCase());
		return newList;
	}
	
	public StringList startsWith(String prefix)
	{
		return startsWith(prefix, this.head);
	}

	private StringList startsWith(String prefix, RecursiveIONode cur)
	{
		if(cur instanceof RIOEmpty)
		{
			return new RecursiveIOStringList();
		}

		StringList newList = startsWith(prefix, ((RIONode)cur).getNext());
		String checkString = ((RIONode)cur).getString();

		if(checkString.startsWith(prefix))
		{
			newList.add(0, checkString);
		}

		return newList;
	}
	
	public StringList hasSubstring(String substring)
	{
		return hasSubstring(substring, this.head);
	}

	private StringList hasSubstring(String substring, RecursiveIONode cur)
	{
		if(cur instanceof RIOEmpty)
		{
			return new RecursiveIOStringList();
		}

		StringList newList = hasSubstring(substring, ((RIONode)cur).getNext());
		String checkString = ((RIONode)cur).getString();

		if(checkString.contains(substring))
		{
			newList.add(0, checkString);
		}

		return newList;
	}
}
