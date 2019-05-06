
public class ROONode implements RecursiveOONode
{
	private String data;
	private RecursiveOONode next;
	
	public ROONode(String data, RecursiveOONode next)
	{
		this.data = data;
		this.next = next;
	}
	@Override
	public RecursiveOONode addToEnd(String element) 
	{
		this.next = this.next.addToEnd(element);
		return this;
	}

	@Override
	public RecursiveOONode add(int index, String element) 
	{
		if(index == 0)
		{
			RecursiveOONode n = new ROONode(element, this);
			return n;
		}
		else
		{
			this.next = this.next.add(index - 1, element);
			return this;
		}
	}

	@Override
	public RecursiveOONode remove(int index) 
	{
		if(index == 0)
		{
			return this.next;
		}
		else
		{
			this.next = this.next.remove(index - 1);
			return this;
		}
	}

	@Override
	public String get(int index) 
	{
		if(index == 0)
		{
			return this.getData();
		}
		else
		{
			return this.next.get(index - 1);
		}
	}

	@Override
	public int indexOf(String element) 
	{
		if(this.getData().equals(element))
		{
			return 1;
		}
		else
		{
			return 1 + this.next.indexOf(element);
		}
	}

	@Override
	public int size() 
	{
		return 1 + this.next.size();
	}

	@Override
	public RecursiveOONode toLowerCase() 
	{
		ROONode n = new ROONode(this.getData().toLowerCase(), this.getNext().toLowerCase());
		return n;
	}

	@Override
	public RecursiveOONode toUpperCase() 
	{
		ROONode n = new ROONode(this.getData().toUpperCase(), this.getNext().toUpperCase());
		return n;
	}

	@Override
	public RecursiveOONode startsWith(String prefix) 
	{
		if(this.getData().startsWith(prefix))
		{
			ROONode n = new ROONode(this.getData(), this.getNext().startsWith(prefix));
			return n;
		}
		else
		{
			return this.getNext().startsWith(prefix);
		}
	}

	@Override
	public RecursiveOONode hasSubstring(String substring) 
	{
		if(this.getData().contains(substring))
		{
			ROONode n = new ROONode(this.getData(), this.getNext().hasSubstring(substring));
			return n;
		}
		else
		{
			return this.getNext().hasSubstring(substring);
		}
	}

	@Override
	public RecursiveOONode getNext() 
	{
		return next;
	}

	@Override
	public String getData() 
	{
		return data;
	}

}
