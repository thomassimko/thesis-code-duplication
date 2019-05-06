/* For Indexing, I counted the head index as 0 
 * and the first thing in the list as index 1*/


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
		IterativeNode end = new IterativeNode(element, null);

		if(head == null)
		{
			head = end;
		}
		else //head points to something
		{
			IterativeNode cur = this.head;
			while(cur.getNext() != null)
			{
				cur = cur.getNext();
			}

			cur.setNext(end);
		}
   }

   public void add(int index, String element)
   {   
	   /*IterativeNode end = new IterativeNode(element, null);
	   
	   if(head == null)
	   {
		   if(index < 0)
		   {
				throw new IndexOutOfBoundsException();
		   }
		   else
		   {
			   head = end;
		   }
	   }*/
	   
	   IterativeNode cur = head;
		int i = 1;

		while(i < index - 1)
		{
			cur = cur.getNext();
			i++;		
		}
		IterativeNode add = new IterativeNode(element, cur.getNext());
		
		cur.setNext(add);
   }

   public String remove(int index) 
   {
	   	/*if(index < 1 || index > this.size())
	   	{
	   		throw new IndexOutOfBoundsException();
	   	}*/
	  
	   	IterativeNode cur = head;
		IterativeNode rmv;
   
		for(int i = 1; i < index - 1; i++)
		{
			cur = cur.getNext();
		}

		rmv = cur.getNext();

		cur.setNext(cur.getNext().getNext());

		return rmv.getStr();
   }

   public String get(int index)
   {
	   /*if(index < 1 || index > this.size())
	   	{
	   		throw new IndexOutOfBoundsException();
	   	}*/
	   
	   IterativeNode cur = head;

		for(int i = 1; i < index ; i++)
		{
			cur = cur.getNext();
		}

		return cur.getStr();

   }

   public int indexOf(String element)
   {
		IterativeNode cur = head;
		int ind = 1;

		while(cur.getStr() != element)
		{
			cur = cur.getNext();
			ind++;
		}
		
		/*if(ind < 1 || ind > this.size())
	   	{
	   		throw new IndexOutOfBoundsException();
	   	}*/
		
	return ind;		
   }
 
   public int size()
   {
		IterativeNode cur = head;
		int size = 1;

		while(cur.getNext() != null)
		{
			cur = cur.getNext();
			size++;
		}

		return size;
   }

   public StringList toLowerCase()
   {
		IterativeNode cur = head;
		StringList LowerCase = new IterativeStringList();

		while(cur != null)
		{
			LowerCase.addToEnd(cur.getStr().toLowerCase());
			cur = cur.getNext();
		}
		return LowerCase;
  }

   public StringList toUpperCase()
   {
		IterativeNode cur = head;
		StringList UpperCase = new IterativeStringList();

		while(cur.getNext() != null)
		{
			UpperCase.addToEnd(cur.getStr().toUpperCase());
			cur = cur.getNext();
		}
		UpperCase.addToEnd(cur.getStr().toUpperCase());

		return UpperCase;
   }

   public StringList startsWith(String prefix)
   {
		IterativeNode cur = head;
		StringList startsWith = new IterativeStringList();

		while(cur.getNext() != null)
		{
			if(cur.getStr().startsWith(prefix))
			{
				startsWith.addToEnd(cur.getStr());
			}
			cur = cur.getNext();
		}

		return startsWith;
   }

   public StringList hasSubstring(String substring)
   {
	   	IterativeNode cur = head;
		StringList hasSub = new IterativeStringList();

		while(cur.getNext() != null)
		{
			if(cur.getStr().contains(substring))
			{
				hasSub.addToEnd(cur.getStr());
			}
			cur = cur.getNext();
		}

		return hasSub;

   }
}