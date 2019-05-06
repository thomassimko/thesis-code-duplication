
public class ROONode
	implements RecursiveOONode
{
	private String val;
	private RecursiveOONode next;
	
	public ROONode(String val, RecursiveOONode next)
	{
		this.val = val;
		this.next = next;
	}
	
	public RecursiveOONode addToEnd(String element) 
	{
		RecursiveOONode n = next.addToEnd(element);
		next = n;
		return this;
	}

	
	public RecursiveOONode add(int index, String element, RecursiveOONode cur)
	{

			if(index ==0)
			{
				RecursiveOONode n = new ROONode(element, cur);
				return n;
			}
			else
			{
				RecursiveOONode n = add(index-1, element, cur.getNext());
				cur.setNext(n);
				return cur;
			}

		}

	public String get(int index) 
	{
		if(index == 0)
		{
			return this.getValue();
		}
		else
		{
			return this.next.get(index-1);
		}
	}
	

	public int indexOf(String element) {
		if(this.getValue().equals(element))
		{
			return 0;
		}
		return 1 + this.next.indexOf(element);
	}

	@Override
	public int size() 
	{
		return 1 + next.size();
	}

	
	public String getValue() 
	{
		return val;
	}


	public RecursiveOONode getNext()
	{
		return next;
	}

	@Override
	public void setNext(RecursiveOONode n) 
	{
		next = n;
		
	}

	@Override
	public RecursiveOONode remove(int index, RecursiveOONode cur) 
	{		RecursiveOONode temp = cur.getNext();
			if(index == 1)
			{
				cur.setNext(temp.getNext());
				return temp;
			}
			else
			{
				RecursiveOONode n = remove(index-1, temp);
				return n;
			}
	}

	
	public RecursiveOONode toLowerCase() 
	{
		RecursiveOONode n = new ROONode(this.getValue().toLowerCase(), this.next.toLowerCase() );
		return n;
	}



	@Override
	public RecursiveOONode toUpperCase() 
	{
		RecursiveOONode n = new ROONode(this.getValue().toUpperCase(), this.next.toUpperCase() );
		return n;
	}
	

	@Override
	public RecursiveOONode startsWith(String prefix) 
	{
		if(this.getValue().startsWith(prefix))
		{
			RecursiveOONode n = new ROONode(this.getValue(), this.next.startsWith(prefix) );
			return n;
		}
		return this.next.startsWith(prefix);
	}

	@Override
	public RecursiveOONode hasSubstring(String substring) 
	{
		if(this.getValue().contains(substring))
		{
			RecursiveOONode n = new ROONode(this.getValue(), this.next.hasSubstring(substring) );
			return n;
		}
		return this.next.hasSubstring(substring);
	}





}
