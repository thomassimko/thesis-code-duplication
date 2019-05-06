public class ROOEmpty
   implements RecursiveOONode
{
   public ROOEmpty()
   {
   }  
   public String getString()
   {
      throw new UnsupportedOperationException();
   }
   public RecursiveOONode getNext()
   {
      throw new UnsupportedOperationException();
   }   
   public RecursiveOONode addToEnd(String element)
   {
      RecursiveOONode newNode = new ROONode(element, this);
      return newNode;
   }
   public RecursiveOONode add(int index, String element)
   {
      if(index != 0)
      {
         throw new IndexOutOfBoundsException();
      }
      ROONode newNode = new ROONode(element, this);
      return newNode;
   }
   public RecursiveOONode remove(int index)
   {
      if(index != 0)
      {
         throw new IndexOutOfBoundsException();
      }
      else
      {
         return this;
      }
   }
   public String get(int index)
   {
      throw new UnsupportedOperationException();
   }
   public int indexOf(String element)
   {
      throw new IndexOutOfBoundsException();
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
