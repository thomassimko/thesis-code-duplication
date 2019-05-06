import java.lang.UnsupportedOperationException;
import java.lang.IndexOutOfBoundsException;

public class RecursiveIOStringList
{
	private RecursiveIONode head;
	
	public RecursiveIOStringList(RecursiveIONode head)
	{
		this.head = head;
	}

	public RecursiveIONode addToEnd(String element)
	{
		if (head instanceof RIOEmpty)
		{
			return new RIONode(element,head);
		}
		else
		{
			RecursiveIONode n = this.addToEnd(element);
			head.setNext(n);
			return n;
		}
	}

	public RecursiveIONode add(int index, String element)
	{
		if (head instanceof RIOEmpty)
		{
			return new RIONode(element,head);
		}
		else
		{
			RecursiveIONode n = this.add(index-1,element);
			return n;
		}
	}
	
	public RecursiveIONode remove(int index)
	{
		if (head instanceof RIOEmpty)
		{
			return head;
		}
		else
		{
			if (index == 0)
			{
				return head;
			}
			else if (this.size() > index)
			{
				head = this.remove(index-1);
				return head;
			}
			else
			{
				throw new IndexOutOfBoundsException();
			}
		}
	}

	public RecursiveIONode get(int index)
	{
		if (head instanceof RIOEmpty)
		{
			return head;
		}
		else
		{
			if (index == 0)
			{
				return head;
			}
			else if (this.size() > index)
			{
				head = this.get(index-1);
				return head;
			}
			else
			{
				throw new IndexOutOfBoundsException();
			}
		}
	}

	public int indexOf(String element)
	{
		if (head instanceof RIOEmpty)
		{
			return 0;
		}
		else
		{
			if (head.thisString().equals(element))
			{
				return 0;
			}
			else
			{
				return 1 + this.indexOf(element);
			}
		}
	}

	public int size()
	{
		if (head instanceof RIOEmpty)
		{
			return 0;
		}
		else
		{
			if (head == null)
			{
				return 0;
			}
			else
			{
				return 1 + this.size();
			}
		}
	}

	public StringList toLowerCase()
	{
		if (head instanceof RIOEmpty)
		{
			return (StringList)this;
		}
		else
		{
			if (head == null)
			{
				return (StringList)this;
			}
			else
			{
				StringList lowerList = this.toLowerCase();
				lowerList.addToEnd(head.thisString().toLowerCase());
				return lowerList;
			}
		}	
	}
	
	public StringList toUpperCase()
	{
		if (head instanceof RIOEmpty)
		{
			return (StringList)this;
		}
		else
		{
			if (head == null)
			{
				return (StringList)this;
			}
			else
			{
				StringList upperList = this.toUpperCase();
				upperList.addToEnd(head.thisString().toUpperCase());
				return upperList;
			}
		}	
	}
	
	public StringList startsWith(String prefix)
	{
		if (head instanceof RIOEmpty)
		{
			return (StringList)this;
		}
		else
		{
			if (head == null)
			{
				return (StringList)this;
			}
			else
			{
				StringList starts = this.startsWith(prefix);
				if (head.thisString().startsWith(prefix))
				{
					starts.addToEnd(head.thisString());
				}
				return starts;
			}
		}
	}
	
	public StringList hasSubstring(String substring)
	{
		if (head instanceof RIOEmpty)
		{
			return (StringList)this;
		}
		else
		{
			if (head == null)
			{
				return (StringList)this;
			}
			else
			{
				StringList subs = this.hasSubstring(substring);
				if (head.thisString().contains(substring))
				{
					subs.addToEnd(head.thisString());
				}
				return subs;
			}
		}
	}
}
