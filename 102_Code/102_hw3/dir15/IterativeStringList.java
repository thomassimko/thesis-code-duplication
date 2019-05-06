import java.util.NoSuchElementException;


public class IterativeStringList 
	implements StringList 
{
	private IterativeNode head;

	public IterativeStringList()
    {
        head = null;
    }
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
				IterativeNode node = new IterativeNode(element, null);
                head = node;
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
			else if(index < 0)
			{
				throw new IndexOutOfBoundsException();
			}
			else
			{
				IterativeNode cur = head;
				for(int i=1; i<index; i++)
				{
					cur = cur.getNext();
				}
				if(cur == null)
				{
					throw new NullPointerException();
				}
				else
				{
					IterativeNode n = new IterativeNode(element, cur.getNext());
					cur.setNext(n);
				}
			}
		}

	}

	@Override
	public String remove(int index) 
	{
		String tmp;
		if(index == 0)
		{
			tmp = this.head.getValue();
			this.head = null;
			return tmp;
		}
		else if(index<0)
		{
			throw new IndexOutOfBoundsException();
		}
		else
		{
			IterativeNode cur = this.head;
			for(int i = 1; i<index; i++)
			{
				cur = cur.getNext();
			}
			if(cur == null)
			{
				throw new NullPointerException();
			}
			tmp = cur.getValue();
			cur.setNext(cur.getNext().getNext());
		}
		return tmp;
	}

	@Override
	public String get(int index) 
	{
		if(index == 0)
		{
			return this.head.getValue();
		}
		else if(index<0)
		{
			throw new IndexOutOfBoundsException();
		}
		else
		{
			IterativeNode cur = this.head;
			for(int i=1; i<=index; i++)
			{
				cur = cur.getNext();
			}
			if(cur == null)
			{
				throw new NullPointerException();
			}
			return cur.getValue();
			
		}
	}

	@Override
	public int indexOf(String element) 
	{
		IterativeNode cur = this.head;
		int index = 0;
		while(cur.getNext()!=null)
		{
			if(cur.getValue().equals(element))
			{
				return index;
			}
			else
			{
				index++;
			}
		}
		throw new NoSuchElementException();
	}

	@Override
	public int size() 
	{
		IterativeNode cur = this.head;
		int index = 0;
		while(cur != null)
		{
			index++;
            cur = cur.getNext();
		}
		return index;
	}

	@Override
	public StringList toLowerCase() 
	{
		IterativeNode cur;
		IterativeStringList newList = new IterativeStringList();
		cur = this.head;
		while(cur != null)
		{
			String string = cur.getValue();
			String newstring = string.toLowerCase();
			newList.addToEnd(newstring);
			cur = cur.getNext();
		}
		return newList;
	}

	@Override
	public StringList toUpperCase() 
	{
		IterativeNode cur;
		IterativeStringList newList = new IterativeStringList();
		cur = this.head;
		while(cur != null)
		{
			String string = cur.getValue();
			String newstring = string.toUpperCase();
			newList.addToEnd(newstring);
			cur = cur.getNext();
		}
		return newList;
	}

	@Override
	public StringList startsWith(String prefix) 
	{
		IterativeNode cur;
		IterativeStringList newList = new IterativeStringList();
		cur = this.head;
		while(cur != null)
		{
			String string = cur.getValue();
			
			if(string.startsWith(prefix))
			{
				newList.addToEnd(string);
			}
			cur = cur.getNext();
		}
		return newList;
	}

	@Override
	public StringList hasSubstring(String substring) 
	{
		IterativeNode cur;
		IterativeStringList newList = new IterativeStringList();
		cur = this.head;
		while(cur != null)
		{
			String string = cur.getValue();
			
			if(string.contains(substring))
			{
				newList.addToEnd(string);
			}
			cur = cur.getNext();
		}
		return newList;
	}

}
