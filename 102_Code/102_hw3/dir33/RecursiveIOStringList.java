
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
	
	private RecursiveIONode addToEndHelper(String element, RecursiveIONode cur) 
	{
		if(cur instanceof RIOEmpty)
		{
			RecursiveIONode n = new RIONode(element,cur);
			return n;
		}
		else
		{
			RecursiveIONode n = addToEndHelper(element, ((RIONode)cur).getNext());
			((RIONode)cur).setNext(n);
			return cur;
		}
	}
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
			if(index ==0)
			{
				RecursiveIONode n = new RIONode(element, cur);
				return n;
			}
			else
			{
				RecursiveIONode n = addHelper(index-1, element, ((RIONode)cur).getNext());
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
	public String remove(int index) 
	{
		if(index == 0)
		{
			RecursiveIONode n = head;
			head = removeHelper1();
			return n.getValue();
		}
		return removeHelper2(index, head).getValue();
	}
	
	private RecursiveIONode removeHelper1()
	{
		if(head instanceof RIOEmpty)
		{
			throw new IndexOutOfBoundsException();
		}
		else
		{
			return head.getNext();
		}
	}
	
	private RecursiveIONode removeHelper2(int index, RecursiveIONode cur)
	{
		if(cur instanceof RIOEmpty && index == 0)
		{
			throw new IndexOutOfBoundsException();
		}
		else if(cur instanceof RIONode)
		{
			if(index == 1)
			{
				RecursiveIONode n = cur.getNext();
				cur.setNext(cur.getNext().getNext());
				return n;
			}
			else
			{
				RecursiveIONode n = removeHelper2(index-1, ((RIONode)cur).getNext());
				return n;
			}
		}
		else
		{
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public String get(int index) 
	{
		return getHelper(index, head).getValue();
	}
	
	private RecursiveIONode getHelper(int index,RecursiveIONode cur)
	{
		if(cur instanceof RIOEmpty && index == 0)
		{
			throw new IndexOutOfBoundsException();
		}
		else if(cur instanceof RIONode)
		{
			if(index ==0)
			{
				return cur;
			}
			else
			{
				RecursiveIONode n = getHelper(index-1, ((RIONode)cur).getNext());
				return n;
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
		if(cur instanceof RIONode)
		{
			if(cur.getValue().equals(element))
			{
				return 0;
			}
			return 1 + indexOfHelper(element, cur.getNext());
		}
		else return -size()- 1;
		
	}
	
	@Override
	public int size() {
		
		return sizeHelper( head);
	}
	
	private int sizeHelper(RecursiveIONode cur)
	{
		if(cur instanceof RIONode)
			return 1 + sizeHelper(cur.getNext());
		else return 0;
	}

	@Override
	public StringList toLowerCase() 
	{
		RecursiveIOStringList list = new RecursiveIOStringList();
		return toLowerCaseHelper(list, head);
	}
	
	private RecursiveIOStringList toLowerCaseHelper(RecursiveIOStringList list, RecursiveIONode cur)
	{
		if(cur instanceof RIOEmpty)
		{
			return list;
		}
		else
		{
			list.addToEnd(cur.getValue().toLowerCase());
			return toLowerCaseHelper(list, cur.getNext());
		}
	}

	@Override
	public StringList toUpperCase() 
	{
		RecursiveIOStringList list = new RecursiveIOStringList();
		return toUpperCaseHelper(list, head);
	}
	
	private RecursiveIOStringList toUpperCaseHelper(RecursiveIOStringList list, RecursiveIONode cur)
	{
		if(cur instanceof RIOEmpty)
		{
			return list;
		}
		else
		{
			list.addToEnd(cur.getValue().toUpperCase());
			return toUpperCaseHelper(list, cur.getNext());
		}
	}
	
	@Override
	public StringList startsWith(String prefix) {
		RecursiveIOStringList list = new RecursiveIOStringList();
		return startsWithHelper(list, head, prefix);
	}
	
	private RecursiveIOStringList startsWithHelper(RecursiveIOStringList list, RecursiveIONode cur, String prefix)
	{
		if(cur instanceof RIOEmpty)
		{
			return list;
		}
		else
		{
			if(cur.getValue().startsWith(prefix))
			{
				list.addToEnd(cur.getValue());
			}
			return startsWithHelper(list, cur.getNext(), prefix);
		}
	}
	

	@Override
	public StringList hasSubstring(String substring) {
		RecursiveIOStringList list = new RecursiveIOStringList();
		return hasSubstringHelper(list, head, substring);
	}
	
	private RecursiveIOStringList hasSubstringHelper(RecursiveIOStringList list, RecursiveIONode cur, String substring)
	{
		if(cur instanceof RIOEmpty)
		{
			return list;
		}
		else
		{
			if(cur.getValue().contains(substring))
			{
				list.addToEnd(cur.getValue());
			}
			return hasSubstringHelper(list, cur.getNext(), substring);
		}
	}

}
