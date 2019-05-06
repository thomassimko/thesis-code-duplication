
public class ROONode 
implements RecursiveOONode
{
	private String v;
	private RecursiveOONode next;
	private int i;
	private RecursiveOOStringList s;
	public ROONode (String value, RecursiveOONode n)
	{
		v= value;
		next= n;
		i=0;
		s = null;
	}
	
	public RecursiveOONode addToEnd(String element)
	{
		RecursiveOONode n = next.addToEnd(element);
		next = n;
		return this;
	}

	public RecursiveOONode add(int index, String element)
	{
		if(index== 0)
		{
			RecursiveOONode n = new ROONode(element, this);
			return n;
		}
		else
		{
			next= next.add(index-1, element);
			return this;
		}
	}

	public RecursiveOONode remove(int index)
	{
		if(index > 0)
		{
			next = next.remove(index-1);
			return this;
		}
		if(index==0)
		{
			return next;
		}
		else
		{
			throw new IndexOutOfBoundsException("Index Out Of Bounds: " + index);
		}	
	}

	public String get(int index)
	{
		if(index > 0)
		{
			String n = next.get(index -1);
			return n;
		}
		if(index == 0)
		{
			return v;
		}
		else
		{
			throw new IndexOutOfBoundsException();
		}
	}
	
	public int indexOf(String element)
	{
		if(v.equals(element))
		{
			return 0;
		}
		else
		{
			return  1 + next.indexOf(element);
		}
	}

	public int size() {
		i = 1+ next.size();
		return i;
	}

	public RecursiveOONode toLowerCase()
	{
		RecursiveOONode t = next.toLowerCase();
		RecursiveOONode n = new ROONode(v.toLowerCase(), t);
		return n;
	}

	public RecursiveOONode toUpperCase()
	{
		RecursiveOONode t = next.toUpperCase();
		RecursiveOONode n = new ROONode(v.toUpperCase(), t);
		return n;
	}
	public RecursiveOONode startsWith(String prefix)
	{
		RecursiveOONode n;
		if(v.startsWith(prefix))
		{
			n = new ROONode(v, next.startsWith(prefix));
		}
		else
		{
			return next.startsWith(prefix);
		}
		return n;
	}

	public RecursiveOONode hasSubstring(String substring)
	{
		RecursiveOONode n;
		if(v.indexOf(substring) > 0)
		{
			n = new ROONode(v, next.hasSubstring(substring));
		}
		else
		{
			return next.hasSubstring(substring);
		}
		return n;
	}


}
