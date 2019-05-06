public class RecursiveOOStringList
   implements StringList
{
   private RecursiveOONode node;

   public RecursiveOOStringList()
   {
      node = new ROOEmpty();
   }

   public void addToEnd(String element)
   {
      node = node.addToEnd(element);
   }

   public void add(int index, String element)
   {
      node = node.add(index, element);
   }

   public void remove(int index)
   {
      this.node = this.node.remove(index);
   }

   public String get(int index)
   {
      return node.get(index);
   }

   public int indexOf(String element)
   {
      return node.indexOf(element);
   }

   public int size()
   {
      return node.size();
   }

   public StringList toLowerCase()
   {
      return node.toLowerCase();
   }

   public StringList toUpperCase()
   {
      return node.toUpperCase();
   }

   public StringList startsWith(String prefix)
   {
      return node.startsWith(prefix);
   }

   public StringList hasSubstring(String substring)
   {
      return node.hasSubstring(substring);
   }

}
