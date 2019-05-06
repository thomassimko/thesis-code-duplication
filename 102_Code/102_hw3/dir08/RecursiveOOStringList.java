public class RecursiveOOStringList
   implements StringList
{
   private RecursiveOONode head;

   public RecursiveOOStringList()
   {
      this.head = new ROOEmpty();
   }

   public void addToFront(String element)
   {
      this.head = new ROONode(element, this.head);
   }

   public void addToEnd(String element)
   {
      this.head = this.head.addToEnd(element);
   }

   public void add(int index, String element)
   {
      if ((index < 0) || (index > this.size()))
      {
         throw new IndexOutOfBoundsException();
      }
      else
      {
         this.head = this.head.add(index, element);
      }
   }

   public String remove(int index)
   {
      if ((index < 0) || (index >= this.size()))
      {
         throw new IndexOutOfBoundsException();
      }
      else
      {
         StringObj string = new StringObj();
         this.head = this.head.remove(index, string);
         return string.toString();
      }
   }

   public String get(int index)
   {
      if ((index < 0) || (index >= this.size()))
      {
         throw new IndexOutOfBoundsException();
      }
      else
      {
         return this.head.get(index);
      }
   }

   public int indexOf(String element)
   {
      return this.head.indexOf(0, element);
   }

   public int size()
   {
      return this.head.size();
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
