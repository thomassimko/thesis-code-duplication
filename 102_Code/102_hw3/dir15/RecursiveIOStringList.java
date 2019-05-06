import java.util.NoSuchElementException;


public class RecursiveIOStringList 
	implements StringList 
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

	private RecursiveIONode addToEndHelper(String string, RecursiveIONode cur)
	{
		if(cur instanceof RIOEmpty)
		{
			RecursiveIONode n = new RIONode(string, cur);
			return n;
		}
		else
		{
			RecursiveIONode n = addToEndHelper(string, ((RIONode)cur).getNext());
			((RIONode)cur).setNext(n);
			return cur;
		}
	}
	
	public void add(int index, String element) 
	{
		head = add(index, element, head);
	}

	private RecursiveIONode add(int index, String element, RecursiveIONode cur)
	{
		if(cur instanceof RIOEmpty && index == 0)
		{
			RecursiveIONode n = new RIONode(element, cur);
			return n;
		}
		else if(cur instanceof RIONode)
		{
			if(index==0)
			{
				RecursiveIONode n = new RIONode(element, cur);
				return n;
			}
			else
			{
				RecursiveIONode n = add(index-1, element, ((RIONode)cur).getNext());
				((RIONode)cur).setNext(n);
				return cur;
			}
		}
		else
		{
			throw new IndexOutOfBoundsException();
		}
	}
	
	public String remove(int index) 
	{
		String tmp = remove(index, head);
		return tmp;
	}
	
	private String remove(int index, RecursiveIONode cur)
	{
		if(cur instanceof RIOEmpty && index==1)
		{
			throw new NullPointerException();
		}
		else if(cur instanceof RIONode)
		{
			if(index==1)
			{
				String tmp = ((RIONode)cur).getNext().getValue();
				RecursiveIONode target = ((RIONode)cur).getNext().getNext();
				cur.setNext(target);
				return tmp;
			}
			else
			{
				String tmp = remove(index-1, ((RIONode)cur).getNext());
				return tmp;
			}
		}
		else
		{
			throw new IndexOutOfBoundsException();
		}
	}

	
	public String get(int index) 
	{
		String tmp = get(index, head);
		return tmp;
	}

	private String get(int index, RecursiveIONode cur)
	{
		if(cur instanceof RIOEmpty && index == 0)
		{
			throw new NullPointerException();
		}
		else if(cur instanceof RIONode)
		{
			if(index == 0)
			{
				return ((RIONode)cur).getValue();
			}
			else
			{
				String tmp = get(index-1, ((RIONode)cur).getNext());
				return tmp;
			}
		}
		else
		{
			throw new IndexOutOfBoundsException();
		}
	}

	public int indexOf(String element) 
	{
		int tmp = indexOf(element, head, 0);
		return tmp;
	}
	
	private int indexOf(String element, RecursiveIONode cur, int index)
	{
		if(cur instanceof RIOEmpty)
		{
			throw new NoSuchElementException();
		}
		else if(cur instanceof RIONode)
		{
			if(((RIONode)cur).getValue().equals(element))
			{
				return index;
			}
			else
			{
				index = indexOf(element, ((RIONode)cur).getNext(), index+1);
				return index;
			}
		}
		else
		{
			throw new IndexOutOfBoundsException();
		}
	}
	
	public int size() 
	{
		int tmp = sizehelp(head);
		return tmp;
	}

	private int sizehelp(RecursiveIONode cur)
	{
		if(cur instanceof RIOEmpty)
		{
			return 0;
		}
		else
		{
			return 1+sizehelp(cur.getNext());
		}
	}
	
	public StringList toLowerCase() 
	{
		return toLowerCaseHelp(head);
	}

	private StringList toLowerCaseHelp(RecursiveIONode cur) 
	{
		if(cur instanceof RIOEmpty)
		{
			StringList newList = new RecursiveIOStringList();
			return newList;
		}
		else
		{
			StringList newList =  toLowerCaseHelp(((RIONode)cur).getNext());
			newList.add(0,((RIONode)cur).getValue().toLowerCase());
		    return newList;
		}
	}

	public StringList toUpperCase() 
	{
		return toUpperCaseHelp(head);
	}

	private StringList toUpperCaseHelp(RecursiveIONode cur) 
	{
		if(cur instanceof RIOEmpty)
		{
			StringList newList = new RecursiveIOStringList();
			return newList;
		}
		else
		{
			StringList newList =  toUpperCaseHelp(((RIONode)cur).getNext());
			newList.add(0,((RIONode)cur).getValue().toUpperCase());
		    return newList;
		}
	}

	public StringList startsWith(String prefix) 
	{
		return startsWithHelp(head, prefix);
	}

	private StringList startsWithHelp(RecursiveIONode cur, String prefix) 
	{
		if(cur instanceof RIOEmpty)
		{
			StringList newList = new RecursiveIOStringList();
			return newList;
		}
		else
		{
			if(cur.getValue().startsWith(prefix))
			{
				StringList newList =  startsWithHelp(((RIONode)cur).getNext(), prefix);
				newList.add(0,((RIONode)cur).getValue());
			    return newList;
			}
			else
			{
				StringList newList = startsWithHelp(((RIONode)cur).getNext(), prefix);
				return newList;
			}
		}
	}

	public StringList hasSubstring(String substring) 
	{
		return hasSubstringHelp(head, substring);
	}

	private StringList hasSubstringHelp(RecursiveIONode cur, String substring) 
	{
		if(cur instanceof RIOEmpty)
		{
			StringList newList = new RecursiveIOStringList();
			return newList;
		}
		else
		{
			if(cur.getValue().contains(substring))
			{
				StringList newList =  hasSubstringHelp(((RIONode)cur).getNext(), substring);
				newList.add(0,((RIONode)cur).getValue());
			    return newList;
			}
			else
			{
				StringList newList = hasSubstringHelp(((RIONode)cur).getNext(), substring);
				return newList;
			}
		}
	}

}
