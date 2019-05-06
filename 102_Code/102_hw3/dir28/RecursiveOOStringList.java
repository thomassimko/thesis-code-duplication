public class RecursiveOOStringList
   implements StringList
{
   private RecursiveOONode head;
   public RecursiveOOStringList()
   {
      this.head = new ROOEmpty();
   }
   public void addToEnd(String element)
   {
      this.head = this.head.addToEnd(element);
   }
   public void add(int index, String element)
   {
      this.head = this.head.add(index, element);
   }
   public void remove(int index)
   {
      this.head = this.head.remove(index);
   }
   public String get(int index)
   {
      return this.head.get(index).getString();
   }
   public int indexOf(String element)
   {
      return this.head.indexOf(element);
   }
   public int size()
   {
      return this.head.size();
   }
   public StringList toLowerCase()
   {
      return this.head.toLowerCase();
   }
   public StringList toUpperCase()
   {
      return this.head.toUpperCase();
   }
   public StringList startsWith(String prefix)
   {
      return this.head.startsWith(prefix);
   }
   public StringList hasSubstring(String substring)
   {
      return this.head.hasSubstring(substring);
   }
}