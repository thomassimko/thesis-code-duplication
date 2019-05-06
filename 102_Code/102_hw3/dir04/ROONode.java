
public class ROONode 
	implements RecursiveOONode 
{
	private String str;
	private RecursiveOONode next;

	public ROONode(String message, RecursiveOONode next)
	{
		this.str = message;
		this.next = next;
	}

	public String getStr() 
	{
		return str;
	}

	public RecursiveOONode getNext() 
	{
		return next;
	}

	public void setNext(RecursiveOONode n) 
	{
		this.next = n;
	}
	
	public void addToEnd(String element)
	{
		 RecursiveOONode cur = this;
			
		 while(cur.getNext() instanceof ROONode)
		 {
			 cur = cur.getNext();
		 }
		 RecursiveOONode add = new ROONode(element, cur.getNext());
		 
		 cur.setNext(add);
	}
	
	
	
	public void add(int index, String element) 
	{
		RecursiveOONode cur = this;
		int i = 1;
		
		while(i < index - 1)
		{
			cur = cur.getNext();
			i++;		
		}
		ROONode add = new ROONode(element, cur.getNext());
		
		cur.setNext(add);
	}

	public String remove(int index) 
	{
		RecursiveOONode cur = this;
		RecursiveOONode rmv;
		
		for (int i = 1; i < index - 1; i++)
		{
			cur = cur.getNext();
			if(cur instanceof ROOEmpty)
			{
				throw new IndexOutOfBoundsException();
			}
		}
		
		rmv = cur.getNext();
		cur.setNext(cur.getNext().getNext());
		
		return rmv.getStr();
	}

	public String get(int index) 
	{
		RecursiveOONode cur = this;
		
		for (int i = 1; i < index; i++)
		{
			cur = cur.getNext();
		}		
		
		return cur.getStr();	
	}

	public int indexOf(String element) 
	{
		RecursiveOONode cur = this;
		int ind = 1;
		
		while(cur.getStr() != element)
		{
			cur = cur.getNext();
			ind++;
		}
		
		return ind;
	}
	
	public int size() 
	{
		RecursiveOONode cur = this;
		int size = 1;
		
		while(cur.getNext() instanceof ROONode)
		{
			cur = cur.getNext();
			size++;
		}
		return size;
	}

	public StringList toLowerCase() 
	{
		RecursiveOONode cur = this;
		StringList LowerCase = new RecursiveOOStringList();//this);
		
		while(cur instanceof ROONode)
		{
			LowerCase.addToEnd(cur.getStr().toLowerCase());
			cur = cur.getNext();
		}
		return LowerCase;
	}

	public StringList toUpperCase() 
	{
		RecursiveOONode cur = this;
		StringList UpperCase = new RecursiveOOStringList();//this);
		
		while(cur instanceof ROONode)
		{
			UpperCase.addToEnd(cur.getStr().toUpperCase());
			cur = cur.getNext();
		}
		return UpperCase;
	}

	public StringList startsWith(String prefix) 
	{
		RecursiveOONode cur = this;
		StringList startsWith = new RecursiveOOStringList();//this);
		
		while(cur instanceof ROONode)
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
		RecursiveOONode cur = this;
		StringList hasSubstring = new RecursiveOOStringList();//this);
		
		while(cur instanceof ROONode)
		{
			if(cur.getStr().contains(substring))
			{
				hasSubstring.addToEnd(cur.getStr());
			}
			cur = cur.getNext();
		}
		
		return hasSubstring;
	}



}
