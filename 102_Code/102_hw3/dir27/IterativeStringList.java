import java.util.NoSuchElementException;

public class IterativeStringList
	implements StringList
{
	private IterativeNode head;
	public IterativeStringList()
	{
		this.head = null;
	}
   /**
      Adds the specified String to the end of the list.
      @param element String to add to list.
   */
   public void addToEnd(String element)
	{
		IterativeNode n = new IterativeNode(element, null);
		if (this.head==null)
		{
			this.head = n;
		}
		else
		{
			IterativeNode cur = this.head;
			while (cur.getNext()!=null)
			{
				cur = cur.getNext();
			}
			cur.setNext(n);
		}
	}

   /**
      Adds the specified String at index position in the list.
      The element previously at that position is now after this new element.
      @param index Position at which to add the element.
      @param element String to add to list.
   */
   public void add(int index, String element)
	{
		if (this.head == null && index == 0)
		{
			this.head = new IterativeNode(element, null);
		}
		else if (index < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		else if (index == 0)
		{
			this.head = new IterativeNode(element, this.head);
		}
		else if (index > 0)
		{
			IterativeNode cur = this.head;
			for (int i=1; cur.getNext()!=null && i<index; i++)
			{
				cur = cur.getNext();
			}
			if (cur == null)
			{
				throw new IndexOutOfBoundsException();
			}
			IterativeNode n = new IterativeNode(element, cur.getNext());
			cur.setNext(n);
		}
	}

   /**
      Removes the element at position index. Returns the element that
      was removed.
      @param index Position of element to remove.
      @return String removed from list.
   */
   public String remove(int index)
	{
		if (this.head == null)
		{
			throw new IndexOutOfBoundsException();
		}
		else if (index == 0)
		{
			IterativeNode temp = this.head;
			this.head = this.head.getNext();
			return temp.getString();
		}
		else if (index > 0)
		{
			IterativeNode cur = this.head;
			for (int i=0; i<index-1 && cur.getNext()!=null; i++)
			{
				cur = cur.getNext();
			}
			IterativeNode temp = cur.getNext();
			cur.setNext(cur.getNext().getNext());
			return temp.getString();
		}
		throw new IndexOutOfBoundsException();
	}
		
				

   /**
      Returns the element at position index.
      @param index Position from which to retrieve String.
      @return String at index position in list.
   */
   public String get(int index)
	{
		IterativeNode cur = this.head;
		if (cur==null && index==0)
		{
			throw new NoSuchElementException();
		}
		for (int i=0; i<index; i++)
		{
			if (cur==null)
			{
				throw new IndexOutOfBoundsException();
			}
			cur = cur.getNext();
		}
		return cur.getString();
	}
   /**
      Returns the index at which the element appears in the list.
      @param element Value to search for.
      @return Position of element.
   */
   public int indexOf(String element)
	{
		IterativeNode cur = this.head;
		for (int i=0; cur!=null; i++)
		{
			if (cur.getString().equals(element))
			{
				return i;
			}
			cur = cur.getNext();
		}
		throw new NoSuchElementException();
	}

   /**
      Number of elements in the list.
      @return Number of elements in the list.
   */
   public int size()
	{
		int count = 0;
		IterativeNode cur = this.head;
		for (int i=0; cur!=null; i++)
		{
			 count++;
		}
		return count;
	}

   /**
      Returns a newly constructed list (in the same order) with the strings
      from the original list converted to lowercase. Does not modify original
      list.
      @return Lowercase copy of the list.
   */
   public StringList toLowerCase()
	{
		IterativeStringList newList = new IterativeStringList();
		IterativeNode cur = this.head;
		while (cur!=null)
		{
			newList.addToEnd(cur.getString().toLowerCase());
			cur = cur.getNext();
		}
		return newList;
	}

   /**
      Returns a newly constructed list (in the same order) with the strings
      from the original list converted to uppercase. Does not modify original
      list.
      @return Uppercase copy of the list.
   */
   public StringList toUpperCase()
	{
		StringList newList = new IterativeStringList();
		IterativeNode cur = this.head;
		while (cur!=null)
		{
			newList.addToEnd(cur.getString().toUpperCase());
			cur = cur.getNext();
		}
		return newList;
	}
   /**
      Returns a newly constructed list (in the same order) containing
      strings from the original list that begin with the specified
      prefix.  Does not modify original list.
      @return New list with strings containing prefix.
   */
   public StringList startsWith(String prefix)
	{
		StringList newList = new IterativeStringList();
		IterativeNode cur = this.head;
		while (cur!=null)
		{
			if (cur.getString().startsWith(prefix))
			{
				newList.addToEnd(cur.getString().toUpperCase());
			}
			cur = cur.getNext();
		}
		return newList;
	}

   /**
      Returns a newly constructed list (in the same order) containing
      strings from the original list that contains the specified substring.
      Does not modify original list.
      @return New list with strings containing substring.
   */
   public StringList hasSubstring(String substring)
	{
		StringList newList = new IterativeStringList();
		IterativeNode cur = this.head;
		while (cur!=null)
		{
			if (cur.getString().contains(substring))
			{
				newList.addToEnd(cur.getString());
			}
			cur = cur.getNext();
		}
		return newList;
	}
}