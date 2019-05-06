import java.util.ListIterator;
import java.util.NoSuchElementException;

public class IterativeStringList
implements StringList
{
	private Node head;
	private Node temp;
	private int counter;
	public IterativeStringList()
	{
		head = null;
		temp = null;
		counter = 0;
	}
	public void addToEnd(String element)
	{
		Node n = new Node(element, null);
		if (head == null)
		{
			head = n;
		}
		else
		{
			temp = head;
			while(temp.next != null)
			{ 
				temp = temp.next;
			}
			temp.setNext(n);
		}
		counter++;
	}

	public void add(int index, String element)
	{
		if(head == null)
		{
			if(index ==0)
			{
				head = new Node(element, null);
				counter++;
			}
			else
			{
				throw new IndexOutOfBoundsException("Index Out Of Bounds: " + index);
			}
		}
		else
		{
			if(index==0)
			{
				head= new Node(element, head);
				counter++;
			}
			else
			{
				if(index < 0)
				{
					throw new IndexOutOfBoundsException("Index Out Of Bounds: " + index);
				}
				else
				{
					temp =head;
					for(int i=1; i<index && temp != null; i++)
					{
						temp = temp.next();
					}
					if(temp == null)
					{
						throw new IndexOutOfBoundsException("Index Out Of Bounds: " + index);
					}
					else
					{
						Node n = new Node(element, temp.next());
						temp.setNext(n);
						counter++;
					}
				}
			}
		}
	}

	public String remove(int index)
	{
		if(head == null)
		{
			throw new IndexOutOfBoundsException("It's Empty.");
		}
		else{
			if(index>=0 && index < size())
			{
				temp = head;
				if(index == 0)
				{
					head = head.next;
					counter--;
					return temp.getValue();
				}
				else
				{
					if(index==size()-1)
					{
						for(int i=0; i<index; i++)
						{
							temp = temp.next;
						}
						temp.next = null;
						counter--;
						return temp.getValue();
					}
					else
					{
						for(int i=1; i<index; i++)
						{
							temp = temp.next;
						}
						Node temp2 = temp.next;
						temp.next = temp2.next;
						temp = temp.next;
						counter--;
						return temp2.getValue();
					}
				}
			}
			else
			{
				throw new IndexOutOfBoundsException("Index Out Of Bounds: " + index);
			}
		}
	}

	public String get(int index)
	{
		if(index>= 0 && index < size())
		{
			temp = head;
			for (int i=0; i<index; i++)
			{
				temp = temp.next();
			}
			return temp.getValue();
		}
		else
		{
			throw new IndexOutOfBoundsException("Index Out Of Bounds: " + index);
		}
	}

	public int indexOf(String element)
	{
		temp = head;
		for (int i=0; i< size(); i++)
		{
			if(temp.val.equals(element))
			{
				return i;
			}
			temp = temp.next();
		}
		throw new NoSuchElementException("No Such Element: " + element);
	}

	public int size()
	{
		return counter;
	}

	public StringList toLowerCase()
	{
		IterativeStringList s1 = new IterativeStringList();
		temp = head;
		
		for(int i=0; i< size(); i++)
		{
			String value = temp.getValue();
			String v = value.toLowerCase();
			s1.addToEnd(v);
			temp = temp.next;
			
		}
		return s1;
	}

	public StringList toUpperCase()
	{
		temp= head;
		IterativeStringList s1 = new IterativeStringList();
	
		for(int i=0; i< size(); i++)
		{
			String value = temp.getValue();
			String v = value.toUpperCase();
			s1.addToEnd(v);
			temp = temp.next;
			
		}
		return s1;
	}

	public StringList startsWith(String prefix)
	{
		temp= head;
		IterativeStringList s1 = new IterativeStringList();
		for(int i=0; i< size(); i++)
		{
			String value = temp.getValue();
			boolean b = value.startsWith(prefix);
			if(b)
			{
				s1.addToEnd(value);
			}
			temp = temp.next;
		}
		return s1;
	}

	public StringList hasSubstring(String substring) 
	{
		temp= head;
		IterativeStringList s1 = new IterativeStringList();
		for(int i=0; i< size(); i++)
		{
			String value = temp.getValue();
			if(value.indexOf(substring) > 0)
			{
				s1.addToEnd(value);
			}
			temp = temp.next;
		}
		return s1;
	}
}
