
public class RecursiveOOStringList 
	implements StringList
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
		head = head.add(index, element, head);
	}
	
	public String remove(int index)
	{
		if(index == 0)
		{
			String s = head.getValue();
			head = head.getNext();
			return s;
		}
		else
		{
			return head.remove(index, head).getValue();
		}
	}
	
	public String get(int index)
	{
		return head.get(index);
	}
	
	public int indexOf(String search)
	{
		return head.indexOf(search);
	}
	
	public int size()
	{
		return head.size();
	}
	

	@Override
	public StringList toLowerCase() 
	{
		RecursiveOOStringList list = new RecursiveOOStringList();
		  list.head = head.toLowerCase();
		  return list;
			 
	}

	@Override
	public StringList toUpperCase() {
		RecursiveOOStringList list = new RecursiveOOStringList();
		list.head = head.toUpperCase();
		return list;
	}

	@Override
	public StringList hasSubstring(String substring) {
		RecursiveOOStringList list = new RecursiveOOStringList();
		list.head =  head.hasSubstring(substring);
		return list;
	}

	@Override
	public StringList startsWith(String prefix) {
		RecursiveOOStringList list = new RecursiveOOStringList();
		list.head = head.startsWith(prefix);
		return list;
	}
	
	
	
}
