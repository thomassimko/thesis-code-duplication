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
      head = head.add(index, element);
   }
	
   public void remove(int index)
   {
      head = head.remove(index);
   }
	
   public String get(int index)
   {
      return head.get(index).getString();
   }
	
   public int indexOf(String element)
   {
      return head.indexOf(element);
   }
	
   public int size()
   {
      return head.size();
   }
	
   public StringList toLowerCase()
   {
      return head.toLowerCase(new RecursiveOOStringList());
   }
	
   public StringList toUpperCase()
   {
      return head.toUpperCase(new RecursiveOOStringList());
   }
	
   public StringList startsWith(String prefix)
   {
      return head.startsWith(new RecursiveOOStringList(), prefix);
   }
	
   public StringList hasSubstring(String substring)
   {
      return head.hasSubstring(new RecursiveOOStringList(), substring);
   }
}
