public class IterativeStringList implements StringList 
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
			else if(index < 0)
			{
				throw new IndexOutOfBoundsException();
			}
			else
			{
				IterativeNode cur = this.head;
				for(int i = 1; i < index && cur != null; i++)
				{
					cur = cur.getNext();
				}
				if(cur == null)
				{
					throw new IndexOutOfBoundsException();
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
	public void remove(int index) 
	{
		if(index == 0)
		{
			this.head = this.head.getNext();
		}
		else if(index < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		else
		{
			IterativeNode cur = this.head;
			for(int i = 1; i < index && cur != null; i++)
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
		IterativeNode cur = this.head;
		for(int i = 0; i < index && cur != null; i++)
		{
			cur = cur.getNext();
		}
		if(cur == null)
		{
			throw new IndexOutOfBoundsException();
		}
		else
		{
			return cur.getData();
		}
	}

	@Override
	public int indexOf(String element)
	{
		IterativeNode cur = this.head;
		for(int i = 0; cur != null; i++)
		{
			if(element.equals(cur.getData()))
			{
				return i;
			}
			else
			{
				cur = cur.getNext();
			}
		}
		
		return -1;
	}

	@Override
	public int size() 
	{
		int i;
		IterativeNode cur = this.head;
		for(i = 0; cur != null; i++)
		{
			cur = cur.getNext();
		}
		return i;
	}

	@Override
	public StringList toLowerCase() 
	{
		StringList n = new IterativeStringList();
		IterativeNode cur = this.head;
		
		while(cur != null)
		{
			n.addToEnd(cur.getData().toLowerCase());
			cur = cur.getNext();
		}
		return n;
	}

	@Override
	public StringList toUpperCase() 
	{
		StringList n = new IterativeStringList();
		IterativeNode cur = this.head;
		while(cur != null)
		{
			n.addToEnd(cur.getData().toUpperCase());
			cur = cur.getNext();
		}
		return n;
	}

	@Override
	public StringList startsWith(String prefix) 
	{
		StringList n = new IterativeStringList();
		IterativeNode cur = this.head;
		while(cur != null)
		{
			if(cur.getData().startsWith(prefix))
			{
				n.addToEnd(cur.getData());
			}
			cur = cur.getNext();
		}
		return n;
	}

	@Override
	public StringList hasSubstring(String substring) 
	{
		StringList n = new IterativeStringList();
		IterativeNode cur = this.head;
		while(cur != null)
		{
			if(cur.getData().contains(substring))
			{
				n.addToEnd(cur.getData());
			}
			cur = cur.getNext();
		}
		return n;
	}
}
