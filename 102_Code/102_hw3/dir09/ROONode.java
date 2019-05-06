public class ROONode
   implements RecursiveOONode
{
   private String string;
   private RecursiveOONode next;

   public ROONode(String string, RecursiveOONode next)
   {
      this.string = string;
      this.next = next;
   }

   public String getString()
   {
      return string;
   }

   public RecursiveOONode getNext()
   {
      return next;
   }
	
	public RecursiveOONode addToEnd(String element)
	{
	   RecursiveOONode n = next.addToEnd(element);
		next = n;
		return this;
	}
	
	public RecursiveOONode add(int index, String element)
	{
	   if(index == 0)
		{
		   RecursiveOONode n = new ROONode(element, this);
			return n;
		}
		else
		{
		   next = next.add(index-1, element);
			return this;
		}
	}
	
	public RecursiveOONode remove(int index)
	{
	   if(index == 0) return this.next;
		else next = next.remove(index-1);
		return this;
	}
	
	public RecursiveOONode get(int index)
	{
	   if(index == 0) return this;
		else return next.get(index-1);
	}
	
	public int indexOf(String element)
	{
	   if(this.string.equals(element)) return 0;
	   else
	   {
	      return 1 + next.indexOf(element);
	   }
	}
	
	public int size()
	{
	   int count = 0;
	   return 1 + next.size();
	}
	
	public StringList toLowerCase(StringList list)
	{
	   list = next.toLowerCase(list);
		list.add(0, this.string.toLowerCase());
		return list;
	}
	
	public StringList toUpperCase(StringList list)
	{
	   list = next.toUpperCase(list);
		list.add(0, this.string.toUpperCase());
		return list;
	}
	
	public StringList startsWith(StringList list, String prefix)
	{
	   list = next.startsWith(list, prefix);
		if(this.string.startsWith(prefix)) list.add(0, this.string);
		return list;
	}
	
	public StringList hasSubstring(StringList list, String substring)
	{
	   list = next.hasSubstring(list, substring);
		if(this.string.contains(substring)) list.add(0, this.string);
		return list;
	}
}
