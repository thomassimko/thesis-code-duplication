import java.util.NoSuchElementException;


public class IterativeStringList implements StringList
{
	private IterativeNode head;
	private IterativeNode cur;

	public IterativeStringList()
	{
		this.head = null;
		this.cur = this.head;
	}
	
	@Override
	public void addToEnd(String element)
	{
		IterativeNode temp = new IterativeNode(element, null);
		
		this.cur = this.head;
		
		if(this.cur == null)
		{
			this.head = temp;
		}
		else
		{
			while(this.cur.getNext() != null)
			{
				this.cur = cur.getNext();
			}
			this.cur.setNext(temp);
			temp.setNext(null);
		}
	}

	@Override
	public void add(int index, String element)
	{
		IterativeNode temp = new IterativeNode(element, null);
		this.cur = this.head;
		
		for(int i = 0; i < index - 1; i++)
		{
			if(this.cur == null)
			{
				throw new IndexOutOfBoundsException();
			}
			else
			{
				this.cur = this.cur.getNext();
			}
		}
		temp.setNext(this.cur.getNext());
		this.cur.setNext(temp);
	}

	@Override
	public String remove(int index)
	{
		this.cur = this.head;
		IterativeNode temp;
		
		for(int i = 0; i < (index - 1); i++)
		{
			if(this.cur == null)
			{
				throw new IndexOutOfBoundsException();
			}
			else
			{
				this.cur = this.cur.getNext();
			}
		}
		
		temp = this.cur.getNext().getNext();
		this.cur.setNext(temp);
		return temp.getString();
	}

	@Override
	public String get(int index)
	{
		this.cur = this.head;
		
		for(int i = 0; i < index; i++)
		{
			if(this.cur == null)
			{
				throw new IndexOutOfBoundsException();
			}
			else
			{
				this.cur = this.cur.getNext();
			}
		}
		
		return cur.getString();
	}

	@Override
	public int indexOf(String element)
	{
		this.cur = this.head;
		int indexCount = 0;
		
		while(this.cur != null)
		{
			if(this.cur.getString().equals(element))
			{
				return indexCount;
			}
			else
			{
				this.cur = this.cur.getNext();
				indexCount++;
			}
		}
		throw new NoSuchElementException();
	}

	@Override
	public int size()
	{
		this.cur = this.head;
		int indexCount = 0;
		
		while(this.cur != null)
		{
				this.cur = this.cur.getNext();
				indexCount++;
		}
		return indexCount;
	}

	@Override
	public StringList toLowerCase()
	{
		this.cur = this.head;
		StringList newList = new IterativeStringList();
		
		while(this.cur != null)
		{
			newList.addToEnd(this.cur.getString().toLowerCase());
			this.cur = this.cur.getNext();
		}
		
		return newList;
	}

	@Override
	public StringList toUpperCase()
	{
		this.cur = this.head;
		StringList newList = new IterativeStringList();
		
		while(this.cur != null)
		{
			newList.addToEnd(this.cur.getString().toUpperCase());
			this.cur = this.cur.getNext();
		}

		
		return newList;
	}

	@Override
	public StringList startsWith(String prefix)
	{
		this.cur = this.head;
		StringList newList = new IterativeStringList();
		
		while(this.cur != null)
		{
			if(this.cur.getString().startsWith(prefix))
			{
				newList.addToEnd(this.cur.getString());
			}
			this.cur = this.cur.getNext();
		}
		
		return newList;
	}

	@Override
	public StringList hasSubstring(String substring)
	{
		this.cur = this.head;
		StringList newList = new IterativeStringList();
		
		while(this.cur != null)
		{
			if(this.cur.getString().contains(substring))
			{
				newList.addToEnd(this.cur.getString());
			}
			this.cur = this.cur.getNext();
		}
		
		return newList;
	}

}
