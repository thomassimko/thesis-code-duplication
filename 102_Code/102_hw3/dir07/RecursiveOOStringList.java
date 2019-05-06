public class RecursiveOOStringList 
	implements StringList
{
	private RecursiveOONode head;

   public RecursiveOOStringList()
   {
	 	this.head = new ROOEmpty();
   }
	   
	@Override
	public void addToEnd(String element)
	{
		head = head.addToEnd(element);
	}

	@Override
	public void add(int index, String element)
	{
		head = head.add(index, element);
	}

	@Override
	public void remove(int index)
	{
		head = head.remove(index);
	}

	@Override
	public String get(int index)
	{
		return head.get(index).getString();
	}

	@Override
	public int indexOf(String element)
	{
		return head.indexOf(element);
	}

	@Override
	public int size()
	{
		return head.size();
	}

	@Override
	public StringList toLowerCase()
	{

		return head.toLowerCase();
	}

	@Override
	public StringList toUpperCase()
	{
		return head.toUpperCase();
	}

	@Override
	public StringList startsWith(String prefix)
	{
		return head.startsWith(prefix);
	}

	@Override
	public StringList hasSubstring(String substring)
	{
		return head.hasSubstring(substring);
	}

}
