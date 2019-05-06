import java.util.NoSuchElementException;


public class IterativeStringList implements StringList 
{
	
	private IterativeNode head;

	public IterativeStringList()
	{
		this.head = null;
	}

	public void addToEnd(String element) 
	{
		if (head == null)
		{
			IterativeNode n = new IterativeNode(element, null);
			this.head = n;
		}
		else
		{
			IterativeNode cur = this.head;
			while (cur.getNext() != null)
			{
				cur =  cur.getNext();
			}
			IterativeNode n = new IterativeNode(element, null);
			cur.setNext(n);
		}

	}


	public void add(int index, String element) 
	{
		if (this.head == null)
		{
			if (index == 0)
			{
				this.head = new IterativeNode(element, null);
			}
			else throw new IndexOutOfBoundsException();
		}
		else
		{
			if (index == 0)
			{
				this.head = new IterativeNode(element, this.head);
			}
			else if (index < 0)
			{
				throw new IndexOutOfBoundsException();
			}
			else
			{
				IterativeNode cur = head;
				for (int i=1; i< index && cur != null; i++)
				{
					cur = cur.getNext();
				}
				if (cur == null)
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


	public void remove(int index) 
	{
		if (this.head != null)
		{
			if (index == 0)
			{
				head = head.getNext();
			}
			
			else if (index < 0)
			{
				throw new IndexOutOfBoundsException();
			}
			else 
			{
				IterativeNode cur = head;
				for (int i = 1; i<index && cur != null; i++)
				{
					cur = cur.getNext();
				}
				cur.setNext(cur.getNext().getNext());
			}
		}

	}

	public String get(int index) 
	{
		if (index < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		else if (index == 0)
		{
			if (head == null)
			{
				return null;
			}
			else return head.getString();
		}
		else
		{
			IterativeNode cur = head;
			for (int i=1; i<index && cur != null; i++)
			{
				cur = cur.getNext();
			}
			if (cur.getNext() == null)
			{
				throw new IndexOutOfBoundsException();
			}
			else return cur.getNext().getString();
		}
	}

	
	public int indexOf(String element) 
	{
		if (head == null)
		{
			throw new NoSuchElementException();
		}
		else 
		{
			IterativeNode cur = head;
			int i = 0;
			while (cur != null)
			{
				if (element.equals(cur.getString()))
				{
					return i;
				}
				cur = cur.getNext();
				i ++;
			}
			throw new NoSuchElementException();
		}
	}

	public int size() 
	{
		if (head == null)
		{
			return 0;
		}
		else 
		{
			IterativeNode cur = head;
			int counter = 0;
			while (cur != null)
			{
				cur = cur.getNext();
				counter ++;
			}
			return counter;
		}
	}

	public StringList toLowerCase() 
	{
		StringList newList = new IterativeStringList();
		IterativeNode cur = head;
		while (cur != null)
		{
			String startString = cur.getString();
			String newString = startString.toLowerCase();
			newList.addToEnd(newString);
			cur = cur.getNext();
		}
		return newList;
	}


	public StringList toUpperCase() 
	{
		StringList newList = new IterativeStringList();
		IterativeNode cur = head;
		while (cur != null)
		{
			String startString = cur.getString();
			String newString = startString.toUpperCase();
			newList.addToEnd(newString);
			cur = cur.getNext();
		}
		return newList;
	}

	
	public StringList startsWith(String prefix) 
	{
		StringList newList = new IterativeStringList();
		IterativeNode cur = head;
		while (cur != null)
		{
			String startString = cur.getString();
			if (startString.startsWith(prefix))
			{
				newList.addToEnd(startString);
			}
			cur = cur.getNext();
		}
		return newList;
	}

	
	public StringList hasSubstring(String substring) 
	{
		StringList newList = new IterativeStringList();
		IterativeNode cur = head;
		while (cur != null)
		{
			String startString = cur.getString();
			if (startString.indexOf(substring) >= 0)
			{
				newList.addToEnd(startString);
			}
			cur = cur.getNext();
		}
		return newList;
	}

}
