
public class ROONode implements RecursiveOONode 
{

	private RecursiveOONode next;
	private String string;
	
	public ROONode(String string, RecursiveOONode next)
	{
		this.string = string;
		this.next = next;
	}

	public RecursiveOONode addToEnd(String element) 
	{
		RecursiveOONode n = next.addToEnd(element);
		next = n;
		return this;
	}

	
	public RecursiveOONode add(int index, String element) 
	{
		if (index == 0)
		{
			RecursiveOONode n = new ROONode(element, this);
			return n;
		}
		else 
		{
			next = next.add(index - 1, element);
			return this;
		}
	}
	

	public RecursiveOONode remove(int index) 
	{
		if (index == 0)
		{
			return next;
		}
		else 
		{
			next = next.remove(index - 1);
			return this;
		}
	}

	
	public String get(int index) 
	{
		if (index == 0)
		{
			return string;
		}
		else 
		{
			String getString = next.get(index - 1);
			return getString;
		}
	}

	
	public int indexOf(String element, int index) 
	{
		if (element.equals(string))
		{
			return index;
		}
		else
		{
			return next.indexOf(element, index + 1);
		}
	}

	
	public int size(int curSize) 
	{
		curSize ++;
		return next.size(curSize);
	}

	
	public StringList toLowerCase() 
	{
		StringList newList = next.toLowerCase();
		newList.add(0, string.toLowerCase());
		return newList;
	}

	
	public StringList toUpperCase() 
	{
		StringList newList = next.toUpperCase();
		newList.add(0, string.toUpperCase());
		return newList;
	}

	public StringList startsWith(String prefix) 
	{
		StringList newList = next.startsWith(prefix);
		if (string.startsWith(prefix))
		{
			newList.add(0, string);
		}
		return newList;
	}

	
	public StringList hasSubstring(String substring) 
	{
		StringList newList = next.hasSubstring(substring);
		if (string.indexOf(substring) >= 0)
		{
			newList.add(0, string);
		}
		return newList;
	}

}
