import java.util.NoSuchElementException;


public class RecursiveIOStringList implements StringList 
{

	private RecursiveIONode head;
	
	public RecursiveIOStringList()
	{
		head = new RIOEmpty();
	}

	public void addToEnd(String element) 
	{
		head = addToEndHelper(element, head);
	}
	
	private RecursiveIONode addToEndHelper(String element, RecursiveIONode cur)
	{
		if (cur instanceof RIOEmpty)
		{
			RecursiveIONode n = new RIONode(element, cur);
			return n;
		}
		else 
		{
			RecursiveIONode n = addToEndHelper(element, cur.getNext());
			cur.setNext(n);
			return cur;
		}
	}


	public void add(int index, String element) 
	{
		head = addHelper(index, element, head);
	}
	
	private RecursiveIONode addHelper(int index, String element, RecursiveIONode cur)
	{
		if (cur instanceof RIOEmpty && index == 0)
		{
			RecursiveIONode n = new RIONode(element, cur);
			return n;
		}
		else if (cur instanceof RIONode)
		{
			if (index == 0)
			{
				RecursiveIONode n = new RIONode(element, cur);
				return n;
			}
			else
			{
				RecursiveIONode n = addHelper(index - 1, element, cur.getNext());
				cur.setNext(n);
				return cur;
			}
		}
		else throw new IndexOutOfBoundsException();
	}

	
	public void remove(int index) 
	{
		head = removeHelper(index, head);
	}
	
	private RecursiveIONode removeHelper(int index, RecursiveIONode cur)
	{
		if (cur instanceof RIOEmpty)
		{
			throw new IndexOutOfBoundsException();
		}
		else 
		{
			if (index == 0)
			{
				return cur.getNext();
			}
			else
			{
				RecursiveIONode n = removeHelper(index - 1, cur.getNext());
				cur.setNext(n);
				return cur;
			}
		}
	}


	public String get(int index) 
	{
		String n = getHelper(index, head);
		return n;
	}
	
	private String getHelper(int index, RecursiveIONode cur)
	{
		if (cur instanceof RIOEmpty)
		{
			throw new IndexOutOfBoundsException();
		}
		else
		{
			if (index == 0)
			{
				return cur.getString();
			}
			else return getHelper(index - 1, cur.getNext());
		}
	}

	
	public int indexOf(String element) 
	{
		int n = indexOfHelper(element, head, 0);
		return n;
	}
	
	private int indexOfHelper(String element, RecursiveIONode cur, int index)
	{
		if (cur instanceof RIOEmpty)
		{
			throw new NoSuchElementException();
		}
		else
		{
			if (element.equals(cur.getString()))
			{
				return index;
			}
			else
			index ++;
			return indexOfHelper(element, cur.getNext(), index);
		}
	}

	
	public int size() 
	{
		int n = sizeHelper(head);
		return n;
	}
	
	private int sizeHelper(RecursiveIONode cur)
	{
		if (cur instanceof RIOEmpty)
		{
			return 0;
		}
		else
		{
			return 1 + sizeHelper(cur.getNext());
		}
	}

	
	public StringList toLowerCase() 
	{
		StringList newList = toLowerCaseHelper(head);
		return newList;
	}
	
	private StringList toLowerCaseHelper(RecursiveIONode cur)
	{
		if (cur instanceof RIOEmpty)
		{
			return new RecursiveIOStringList();
		}
		else
		{
			StringList newList = toLowerCaseHelper(cur.getNext());
			newList.add(0, cur.getString().toLowerCase());
			return newList;
		}
	}

	
	public StringList toUpperCase() 
	{
		StringList newList = toUpperCaseHelper(head);
		return newList;
	}
	
	private StringList toUpperCaseHelper(RecursiveIONode cur)
	{
		if (cur instanceof RIOEmpty)
		{
			return new RecursiveIOStringList();
		}
		else
		{
			StringList newList = toUpperCaseHelper(cur.getNext());
			newList.add(0, cur.getString().toUpperCase());
			return newList;
		}
	}

	
	public StringList startsWith(String prefix) 
	{
		StringList newList = startsWithHelper(head, prefix);
		return newList;
	}
	
	private StringList startsWithHelper(RecursiveIONode cur, String prefix)
	{
		if (cur instanceof RIOEmpty)
		{
			return new RecursiveIOStringList();
		}
		else
		{
			StringList newList = startsWithHelper(cur.getNext(), prefix);
			if (cur.getString().startsWith(prefix))
			{
				newList.add(0, cur.getString());
			}
			return newList;
		}
	}

	
	public StringList hasSubstring(String substring) 
	{
		StringList newList = hasSubstringHelper(head, substring);
		return newList;
	}
	
	private StringList hasSubstringHelper(RecursiveIONode cur, String substring)
	{
		if (cur instanceof RIOEmpty)
		{
			return new RecursiveIOStringList();
		}
		else 
		{
			StringList newList = hasSubstringHelper(cur.getNext(), substring);
			if (cur.getString().indexOf(substring) >= 0)
			{
				newList.add(0, cur.getString());
			}
			return newList;
		}
	}

}
