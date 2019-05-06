import java.util.NoSuchElementException;

public class RecursiveIOStringList
	implements StringList
{
	public RecursiveIONode head;
	public RecursiveIOStringList()
	{
		this.head = new RIOEmpty();
	}
	public void addToFront(String element)
	{
		RecursiveIONode n = new RIONode(element, head);
		head = n;
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
			RecursiveIONode n = addToEndHelper(element, ((RIONode)cur).getNext());
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
		if (cur instanceof RIOEmpty && index==0)
		{
			RecursiveIONode n = new RIONode(element, cur);
			return n;
		}
		else if (cur instanceof RIONode)
		{
			if (index==0)
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
		if (index==0 && head instanceof RIONode)
		{
			RecursiveIONode n = head;
			head = n.getNext();
			return ((RIONode)n).getName();
		}
		return remove(index, head);
	}
	private String remove(int index, RecursiveIONode cur)
	{
		if (cur instanceof RIOEmpty)
		{
			throw new IndexOutOfBoundsException();
		}
		else if (index==1 && cur instanceof RIONode)
		{
			RecursiveIONode n = cur.getNext();
			cur.setNext(n.getNext());
			return n.getName();
		}
		else
		{
			String want = remove(index-1, cur.getNext());
			return want;
		}
	}
   public String get(int index)
	{
		return get(index, head);
	}
	private String get(int index, RecursiveIONode cur)
	{
		String want;
		if (cur instanceof RIOEmpty)
		{
			throw new IndexOutOfBoundsException();
		}
		else if (index==0)
		{
			want = cur.getName();
		}
		else
		{
			want = get(index-1, cur.getNext());
		}
		return want;
	}
   public int indexOf(String element)
	{
		return indexOf(element, head);
	}
	private int indexOf(String element, RecursiveIONode cur)
	{
		int count = 0;
		if (cur instanceof RIOEmpty)
		{
			throw new NoSuchElementException();
		}
		else if (cur.getName().equals(element))
		{
			return 0;
		}
		else
		{
			count = indexOf(element, cur.getNext())+1;
		}
		return count;
	}
   public int size()
	{
		int count = 0;
		count = sizeHelper(head);
		return count;
	}
	private int sizeHelper(RecursiveIONode cur)
	{
		int count = 0;
		if (cur instanceof RIOEmpty)
		{
			return 0;
		}
		else if (cur instanceof RIONode)
		{
			count = sizeHelper(cur.getNext())+1;
		}
		return count;
	}
   public StringList toLowerCase()
	{
		StringList list = toLowerCaseHelper(head);
		return list;
	}
   public StringList toUpperCase()
	{
		StringList list = toUpperCaseHelper(head);
		return list;
	}
   public StringList startsWith(String prefix)
	{
		StringList list = startsWithHelper(prefix, head);
		return list;
	}
   public StringList hasSubstring(String substring)
	{
		StringList list = hasSubstringHelper(substring, head);
		return list;
	}
	private StringList toLowerCaseHelper(RecursiveIONode cur)
	{
		StringList list;
		if (cur instanceof RIOEmpty)
		{
			return new RecursiveIOStringList();
		}
		list = toLowerCaseHelper(cur.getNext());
		((RecursiveIOStringList)list).addToFront(cur.getName().toLowerCase());
		return list;
	}
   private StringList toUpperCaseHelper(RecursiveIONode cur)
	{
		if (cur instanceof RIOEmpty)
		{
			return new RecursiveIOStringList();
		}
		StringList list = toUpperCaseHelper(cur.getNext());
		((RecursiveIOStringList)list).addToFront(cur.getName().toUpperCase());
		return list;
	}
   private StringList startsWithHelper(String prefix, RecursiveIONode cur)
	{
		StringList list;
		if (cur instanceof RIOEmpty)
		{
			return new RecursiveIOStringList();
		}
		list = startsWithHelper(prefix, cur.getNext());
		if (cur.getName().startsWith(prefix))
		{
			((RecursiveIOStringList)list).addToFront(cur.getName());
		}
		return list;
	}
   private StringList hasSubstringHelper(String substring, RecursiveIONode cur)
	{
		StringList list;
		if (cur instanceof RIOEmpty)
		{
			return new RecursiveIOStringList();
		}
		list = hasSubstringHelper(substring, cur.getNext());
		if (cur.getName().contains(substring))
		{
			((RecursiveIOStringList)list).addToFront(cur.getName());
		}
		return list;
	}
}