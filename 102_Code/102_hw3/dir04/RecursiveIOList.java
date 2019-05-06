
public class RecursiveIOList implements StringList {
	
	private RecursiveIONode head;
	
	public RecursiveIOList()
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
			RIONode n = new RIONode(element, cur);
			return n;
		}
		else //empty node
		{
			return addToEndHelper(element, cur.getNext());
		}
	}

	public void add(int index, String element) 
	{
		head = add(index, element, head);
	}
	
	private RecursiveIONode add(int ind, String v, RecursiveIONode cur)
	{
		if(cur instanceof RIOEmpty && ind ==0)
		{
			RecursiveIONode n = new RIONode(v, cur);
			return n;
		}
		else if(cur instanceof RIONode)
		{
			if(ind == 0)
			{
				RecursiveIONode n = new RIONode(v, cur);
				return n;
			}
			else
			{
				RecursiveIONode n = add(ind - 1, v, ((RIONode)cur).getNext());
				((RIONode)cur).setNext(n);
				return n;
			}		
		}
		else
		{
			throw new IndexOutOfBoundsException();
		}
	}

	public String remove(int index) 
	{
		RecursiveIONode cur = head;
		RecursiveIONode rmv;
		
		while(index - 1 != 1)
		{
			index--;
			remove(index);
		}
		
		rmv = cur.getNext();
		cur.setNext(cur.getNext().getNext());
		
		return rmv.getStr();
	}

	public String get(int index) 
	{

		return getHelper(head, index);
	}
	
	private String getHelper(RecursiveIONode cur, int index)
	{
		if(index == 0)
		{
			return cur.getStr();
		}
		
		return getHelper(cur.getNext(), index - 1);
		
	}

	public int indexOf(String element) 
	{
		RecursiveIONode cur = head;
		int ind = 1;
		
		while(cur.getStr() != element)
		{
			ind = 1 + indexOf(element);
		}
		ind++;
		
		return ind;
	}
	
	public int size() 
	{				
		return sizeHelp(head);
	}
	
	private int sizeHelp(RecursiveIONode cur)
	{
		if(cur instanceof RIOEmpty)
		{
			return 0;
		}
		else
		{
			return 1 + sizeHelp(cur.getNext());
		}
	}

	/* Sorry. =(
	  
	 public StringList toLowerCase() 
	{

		return head.toLowerCase();
	}

	public StringList toUpperCase() 
	{
		return head.toUpperCase();
	}

	public StringList startsWith(String prefix) 
	{
		return head.startsWith(prefix);
	}

	public StringList hasSubstring(String substring) 
	{
		return head.hasSubstring(substring);
	}*/


}
