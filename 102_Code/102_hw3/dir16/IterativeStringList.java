import java.util.NoSuchElementException;

public class IterativeStringList
	implements StringList
{
	private IterativeNode head;
	
	public IterativeStringList()
	{
		this.head = null;
	}
	
	public void addToEnd(String element)
	{
		IterativeNode cur = this.head;
		IterativeNode newNode = new IterativeNode(element, null);
		
		if(cur == null)	// Empty List
		{
			this.head = newNode;
		}
		else
		{
			while(cur.getNext() != null)
			{
				cur = cur.getNext();
			}
			
			cur.setNext(newNode);
		}
	}
	
	public void add(int index, String element)
	{
		IterativeNode cur = this.head;

		if(index < 0)		// Check for index negative
		{
			throw new IndexOutOfBoundsException();
		}
		
		if(cur == null)	// Empty list
		{
			if(index != 0)	// Only index in an empty list is 0
			{
				throw new IndexOutOfBoundsException();
			}

			this.head = new IterativeNode(element, null);
		}
		else					// Non-empty list
		{
			if(index == 0)	// Add to front
			{
				this.head = new IterativeNode(element, this.head);
			}
			else
			{
				for(int i=0; i<index-1 && cur!=null; i++)	// Find node before index
				{
					cur = cur.getNext();
				}
				
				if(cur == null)	// Check for index too large
				{
					throw new IndexOutOfBoundsException();
				}
				
				cur.setNext(new IterativeNode(element, cur.getNext()));
			}
		}
	}
	
	public String remove(int index)
	{
		IterativeNode cur = this.head;
		String delete;

		if(index < 0)		// Check for index negative
		{
			throw new IndexOutOfBoundsException();
		}
		
		if(cur == null)	// Empty list
		{
			throw new IndexOutOfBoundsException();
		}

		if(index == 0)			// Special case for head
		{
			delete = cur.getString();
			this.head = this.head.getNext();
		}
		else
		{
			for(int i=1; i<index && cur!=null; i++)	// Find node before index
			{
				cur = cur.getNext();
			}
		
			if(cur == null)	// Check for index too large
			{
				throw new IndexOutOfBoundsException();
			}
			
			delete = cur.getNext().getString();
			cur.setNext(cur.getNext().getNext());
		}
		
		return delete;
	}
	
	public String get(int index)
	{
		IterativeNode cur = this.head;
			
		if(index < 0)	// Check for index negative
		{
			throw new IndexOutOfBoundsException();
		}
		
		for(int i=0; i<index && cur!=null; i++)
		{
			cur = cur.getNext();
		}
		
		if(cur == null)	// Check for index too large
		{
			throw new IndexOutOfBoundsException();
		}
		
		return cur.getString();
	}
	
	public int indexOf(String element)
	{
		IterativeNode cur = this.head;
		
		for(int i=0; cur!=null; i++)
		{
			if(cur.getString().equals(element))
			{
				return i;
			}

			cur = cur.getNext();
		}
		
		throw new NoSuchElementException();
	}
	
	public int size()
	{
		IterativeNode cur = this.head;
		int i;
		
		for(i=0; cur!=null; i++)
		{
			cur = cur.getNext();
		}
		
		return i;
	}
	
	public StringList toLowerCase()
	{
		IterativeNode cur = this.head;
		StringList newList = new IterativeStringList();
		
		while(cur != null)
		{
			newList.addToEnd(cur.getString().toLowerCase());
			cur = cur.getNext();
		}
		
		return newList;
	}
	
	public StringList toUpperCase()
	{
		IterativeNode cur = this.head;
		StringList newList = new IterativeStringList();
		
		while(cur != null)
		{
			newList.addToEnd(cur.getString().toUpperCase());
			cur = cur.getNext();
		}
		
		return newList;
	}
	
	public StringList startsWith(String prefix)
	{
		IterativeNode cur = this.head;
		StringList newList = new IterativeStringList();
		
		while(cur != null)
		{
			String checkString = cur.getString();
			if(checkString.startsWith(prefix))
			{
				newList.addToEnd(checkString);
			}
			cur = cur.getNext();
		}
		
		return newList;
	}
	
	public StringList hasSubstring(String substring)
	{
		IterativeNode cur = this.head;
		StringList newList = new IterativeStringList();
		
		while(cur != null)
		{
			String checkString = cur.getString();
			if(checkString.contains(substring))
			{
				newList.addToEnd(checkString);
			}
			cur = cur.getNext();
		}
		
		return newList;
	}
}
