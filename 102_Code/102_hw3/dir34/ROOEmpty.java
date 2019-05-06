import java.*;
public class ROOEmpty
   implements RecursiveOONode
{
   
   public RecursiveOONode addToEnd(String element)
   {
      RecursiveOONode node = new ROONode(element, this);
      return node;
   }
   public RecursiveOONode add(int index, String element)
   {
      RecursiveOONode node = new ROONode(element, this);
      if(index != 0)
      {
         throw new IndexOutOfBoundsException();
      }
      return node;     
   }
   public RecursiveOONode remove(int index)
   {
      throw new UnsupportedOperationException();
   }
   public RecursiveOONode get(int index)
   {
      throw new UnsupportedOperationException();
   }
   public int indexOf(String element)
   {
      throw new UnsupportedOperationException();
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
   public String getString()
   {
      throw new UnsupportedOperationException();
   }
   public RecursiveOONode getNext()
   {
      throw new UnsupportedOperationException();
   }   
}
