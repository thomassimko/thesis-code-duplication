
public class RecursiveOOStringList implements StringList 
{

	private RecursiveOONode head;
	
	public RecursiveOOStringList()
	{
		head = new ROOEmpty();
		
	}
	
	public void addToEnd(String element) 
	{
		head = head.addToEnd(element);
	}

	
	public void add(int index, String element) 
	{
		head = head.add(index, element);
	}

	
	public void remove(int index) 
	{
		head = head.remove(index);
	}

	
	public String get(int index) 
	{
		return head.get(index);
	}


	public int indexOf(String element) 
	{
		return head.indexOf(element, 0);
	}

	public int size() 
	{
		return head.size(0);
	}

	public StringList toLowerCase() 
	{
		return head.toLowerCase();
	}

	
	public StringList toUpperCase() 
	{
		return head.toUpperCase();
	}


	public StringList startsWith(String prefix) 
	{
		return head.startsWith(prefix);
	}

	
	public StringList hasSubstring(String substring) 
	{
		return head.hasSubstring(substring);
	}

}
