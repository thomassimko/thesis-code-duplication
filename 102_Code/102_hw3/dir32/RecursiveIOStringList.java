import java.util.NoSuchElementException;


public class RecursiveIOStringList implements StringList
{
	private RecursiveIONode head;
	
	public RecursiveIOStringList()
	{
		head = new RIOEmpty();
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
			RecursiveIONode n = new RIONode(element, cur);
			return n;
		}
		else
		{
			RecursiveIONode n = addToEndHelper(element, ((RIONode) cur).getNext());
			((RIONode) cur).setNext(n);
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
		if(cur instanceof RIOEmpty && index == 0)
		{
			RecursiveIONode n = new RIONode(element, cur);
			return n;
		}
		else if(cur instanceof RIONode)
		{
			if(index == 0)
			{
				RecursiveIONode n = new RIONode(element, cur);
				return n;
			}
			else
			{
				RecursiveIONode n = addHelper(index - 1, element, ((RIONode)cur).getNext());
				((RIONode)cur).setNext(n);
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
			throw new IndexOutOfBoundsException();
		}
		else
		{
			if(index == 0)
			{
				return ((RIONode)cur).getNext();
			}
			else
			{
				RecursiveIONode n = removeHelper(index - 1, ((RIONode)cur).getNext());
				((RIONode)cur).setNext(n);
				return cur;
			}
		}
	}

	@Override
	public String get(int index) 
	{
		return getHelper(index, head);
	}

	private String getHelper(int index, RecursiveIONode cur) 
	{
		if(cur instanceof RIOEmpty)
		{
			throw new IndexOutOfBoundsException();
		}
		else
		{
			if(index == 0)
			{
				return ((RIONode)cur).getData();
			}
			else
			{
				return getHelper(index - 1, ((RIONode)cur).getNext());
			}
		}
	}

	@Override
	public int indexOf(String element) 
	{
		return indexOfHelper(element, head, 0);
	}

	private int indexOfHelper(String element, RecursiveIONode cur, int i) 
	{
		if(cur instanceof RIOEmpty)
		{
			throw new NoSuchElementException();
		}
		else
		{
			if(((RIONode)cur).getData().equals(element))
			{
				return i;
			}
			else
			{
				return indexOfHelper(element, ((RIONode)cur).getNext(), i + 1);
			}
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
			return 1 + sizeHelper(((RIONode)cur).getNext());
		}
	}

	@Override
	public StringList toLowerCase() 
	{
		StringList n = new RecursiveIOStringList();
		((RecursiveIOStringList)n).head = this.toLowerCaseHelper(head);
		return n;
	}

	private RecursiveIONode toLowerCaseHelper(RecursiveIONode cur) 
	{
		if(cur instanceof RIOEmpty)
		{
			RecursiveIONode e = new RIOEmpty();
			return e;
		}
		else
		{
			RecursiveIONode n = new RIONode(((RIONode)cur).getData().toLowerCase(), toLowerCaseHelper(((RIONode)cur).getNext()));
			return n;
		}
	}

	@Override
	public StringList toUpperCase() 
	{
		StringList n = new RecursiveIOStringList();
		((RecursiveIOStringList)n).head = this.toUpperCaseHelper(head);
		return n;
	}

	private RecursiveIONode toUpperCaseHelper(RecursiveIONode cur) 
	{
		if(cur instanceof RIOEmpty)
		{
			RecursiveIONode e = new RIOEmpty();
			return e;
		}
		else
		{
			RecursiveIONode n = new RIONode(((RIONode)cur).getData().toUpperCase(), toUpperCaseHelper(((RIONode)cur).getNext()));
			return n;
		}
	}

	@Override
	public StringList startsWith(String prefix) 
	{
		StringList n = new RecursiveIOStringList();
		((RecursiveIOStringList)n).head = this.startsWithHelper(prefix, head);
		return n;
	}

	private RecursiveIONode startsWithHelper(String prefix, RecursiveIONode cur) 
	{
		if(cur instanceof RIOEmpty)
		{
			RecursiveIONode e = new RIOEmpty();
			return e;
		}
		else
		{
			if(((RIONode)cur).getData().startsWith(prefix))
			{
				RecursiveIONode n = new RIONode(((RIONode)cur).getData(), startsWithHelper(prefix, ((RIONode)cur).getNext()));
				return n;
			}
			else
			{
				return startsWithHelper(prefix, ((RIONode)cur).getNext());
			}
		}
	}

	@Override
	public StringList hasSubstring(String substring) 
	{
		StringList n = new RecursiveIOStringList();
		((RecursiveIOStringList)n).head = this.hasSubstringHelper(substring, head);
		return n;
	}

	private RecursiveIONode hasSubstringHelper(String substring, RecursiveIONode cur) 
	{
		if(cur instanceof RIOEmpty)
		{
			RecursiveIONode e = new RIOEmpty();
			return e;
		}
		else
		{
			if(((RIONode)cur).getData().contains(substring))
			{
				RecursiveIONode n = new RIONode(((RIONode)cur).getData(), hasSubstringHelper(substring, ((RIONode)cur).getNext()));
				return n;
			}
			else
			{
				return hasSubstringHelper(substring, ((RIONode)cur).getNext());
			}
		}
	}
}
