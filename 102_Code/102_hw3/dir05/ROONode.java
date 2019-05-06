public class ROONode implements RecursiveOONode
{
   private String element;
   private RecursiveOONode next;

   public ROONode(String element, RecursiveOONode next)
   {
      this.element = element;
      this.next = next;
   }
   public String getElement()
   {
      return this.element;
   }
   public RecursiveOONode getNext()
   {
      return this.next;
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
         next = next.add(index - 1, element);
         return this;
      }
   }
   public RecursiveOONode remove(int index)
   {
      if(index == 0)
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
      if(index == 0)
      {
         return this.element;
      }
      else
      {
         return next.get(index - 1);
      }
   }
   public int indexOf(String element)
   {
      if(this.element.equals(element))
      {
         return 0;
      }
      else
      {
         return next.indexOf(element) + 1;
      }
   }
   public int size()
   {
      int count = 0;
      count = next.size();
      return count + 1;
   }
   public StringList toLowerCase()
   {
      StringList list = new RecursiveOOStringList();
      list = next.toLowerCase();
      list.add(0, this.element.toLowerCase());
      return list;
   }
   public StringList toUpperCase()
   {
      StringList list = new RecursiveOOStringList();
      list = next.toUpperCase();
      list.add(0, this.element.toUpperCase());
      return list;
   }
   public StringList startsWith(String prefix)
   {
      StringList list = new RecursiveOOStringList();
      list = next.startsWith(prefix);
      if(this.element.startsWith(prefix))
      {
         list.add(0, this.element);
      }
      return list;
   }
   public StringList hasSubstring(String substring)
   {
      StringList list = new RecursiveOOStringList();
      list = next.hasSubstring(substring);
      if(this.element.contains(substring))
      {
         list.add(0, this.element);
      }
      return list;
   }
}