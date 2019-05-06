public class ROOEmpty
   implements RecursiveOONode
{
   public String getString()
   {
      throw new UnsupportedOperationException();
   }
   
   public RecursiveOONode getNext()
   {
      throw new UnsupportedOperationException();
   }
   
   public ROONode addToEnd(String element)
   {
      ROONode n = new ROONode(element, this);
      return n;
   }

   public void add(int index, int count, String element)
   {
      if(index != count)
      {
         next = next.add(count + 1, element);
      }
   }

   public void remove(int index, int count)
   {
      if(index != count)
      {
         next = next.remove(count + 1, element);
      }
   }

   public String get(int index, int count)
   {
   
   }

   public int indexOf(String element)
   {
      if(index != count)
      {
         next = next.get(count + 1, element);
      }
   }

   int size()
   {
      return 0;
   }

   public StringList toLowerCase()
   {
      StringList list = new Stringlist();
      return list;
   }

   public StringList toUpperCase()
   {
   
   }

   public StringList startsWith(String prefix)
   {
   
   }

   public StringList hasSubstring(String substring)
   {
   
   }
}
