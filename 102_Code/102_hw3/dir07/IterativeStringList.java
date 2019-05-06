import java.util.NoSuchElementException;


public class IterativeStringList 
	implements StringList
{
   private IterativeNode head;

   public IterativeStringList()
   {
   	this.head = null;
   }
   
	@Override
	public void addToEnd(String element)
	{
		IterativeNode n = new IterativeNode(element, null);
		if(head == null)
		{
			this.head = n;
		}
		else
		{
			IterativeNode cur = this.head;
			while(cur.getNext() != null)
			{
				cur = cur.getNext();
			}
				cur.setNext(n);
		}
	}

	@Override
	public void add(int index, String element)
	{
		if(this.head == null)
		{
			if(index == 0)
			{
				this.head = new IterativeNode(element, null);
			}
			else
			{
				throw new IndexOutOfBoundsException();
			}
		}
		else
		{
			if(index == 0)
			{
				this.head = new IterativeNode(element, this.head);
			}
			else 
			{
				if(index < 0)
				{
					throw new IndexOutOfBoundsException();
				}
				else
				{
					IterativeNode cur = this.head;
					for(int i=1; i<index && cur!=null; i++)
					{
						cur = cur.getNext();
					}
					if(cur == null)
					{
						throw new IndexOutOfBoundsException();
					}
					else
					{
						IterativeNode node = new IterativeNode(element, cur.getNext());
						cur.setNext(node);
					}
				}
			}
		}
	}

	@Override
	public void remove(int index)
	{
		if(index < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		if(index == 0)
		{
			head = head.getNext();
		}
		else
		{
			IterativeNode cur = this.head;
			for(int i=1; i<index && cur!=null; i++)
			{
				cur = cur.getNext();
			}
			if(cur == null)
			{
				throw new IndexOutOfBoundsException();
			}
			else
			{
				cur.setNext(cur.getNext().getNext());
			}		
		}
	}

	@Override
	public String get(int index)
	{
		if(index < 0 || head == null)
		{
			throw new IndexOutOfBoundsException();
		}
		if(index == 0)
		{
			return head.getString();
		}
		else
		{
			IterativeNode cur = this.head;
			for(int i=1; i<=index && cur!=null; i++)
			{
				cur = cur.getNext();
			}
			if(cur == null)
			{
				throw new IndexOutOfBoundsException();
			}
			else
			{
				return cur.getString();
			}		
		}
	}

	@Override
	public int indexOf(String element)
	{
		IterativeNode cur = head;
		
		for(int i=0; i<this.size(); i++)
		{
			if(cur.getString().equals(element))
			{
				return i;
			}
			cur = cur.getNext();
		}
		throw new NoSuchElementException();
	}

	@Override
	public int size()
	{
		IterativeNode cur = head;
		int count = 0;
		
		while(cur != null)
		{
			count++;
			cur = cur.getNext();
		}
		return count;
	}

	@Override
	public StringList toLowerCase()
	{
		StringList sl = new IterativeStringList();
		IterativeNode cur = head;
		while(cur != null)
		{
			sl.addToEnd(cur.getString().toLowerCase());
			cur = cur.getNext();
		}
		return sl;
	}

	@Override
	public StringList toUpperCase()
	{
		StringList sl = new IterativeStringList();
		IterativeNode cur = head;
		while(cur != null)
		{
			sl.addToEnd(cur.getString().toUpperCase());
			cur = cur.getNext();
		}
		return sl;
	}

	@Override
	public StringList startsWith(String prefix)
	{
		StringList sl = new IterativeStringList();
		IterativeNode cur = head;
		while(cur != null)
		{
			if(cur.getString().startsWith(prefix))
			{
				sl.addToEnd(cur.getString());
			}
			cur = cur.getNext();
		}
		return sl;
	}

	@Override
	public StringList hasSubstring(String substring)
	{
		StringList sl = new IterativeStringList();
		IterativeNode cur = head;
		while(cur != null)
		{
			if(cur.getString().contains(substring))
			{
				sl.addToEnd(cur.getString());
			}
			cur = cur.getNext();
		}
		return sl;
	}

}
