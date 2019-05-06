public class ROOEmpty implements RecursiveOONode
{
   public String getElement()
   {
      throw new UnsupportedOperationException();
   }
   public RecursiveOONode getNext()
   {
      throw new UnsupportedOperationException();
   }
   public RecursiveOONode addToEnd(String element)
   {
      RecursiveOONode n = new ROONode(element, this);
      return n;
   }
   public RecursiveOONode add(int index, String element)
   {
      if(index != 0)
      {
         throw new IndexOutOfBoundsException();
      }
      RecursiveOONode n = new ROONode(element,this);
      return n;
   }
   public RecursiveOONode remove(int index)
   {
      throw new IndexOutOfBoundsException();
   }
   public String get(int index)
   {
      throw new IndexOutOfBoundsException();
   }
   public int indexOf(String element)
   {
      return -1;
   }
   public int size()
   {
      return 0;
   }
   public StringList toLowerCase()
   {
      StringList list = new RecursiveOOStringList();
      return list;
   }
   public StringList toUpperCase()
   {
      StringList list = new RecursiveOOStringList();
      return list;
   }
   public StringList startsWith(String prefix)
   {
      StringList list = new RecursiveOOStringList();
      return list;
   }
   public StringList hasSubstring(String substring)
   {
      StringList list = new RecursiveOOStringList();
      return list;
   }
}