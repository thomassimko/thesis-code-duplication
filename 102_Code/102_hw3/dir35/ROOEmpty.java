import java.lang.UnsupportedOperationException;
import java.lang.IndexOutOfBoundsException;

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
      ROONode newNode = new ROONode(element, this);
      return newNode;
   }

   public ROONode add(int index, String element)
   {
      if (index == 0)
      {
         ROONode newNode = new ROONode(element, this);
         return newNode;
      }
      else
      {
         throw new IndexOutOfBoundsException();
      }
   }

   public ROONode remove(int index)
   {
      throw new UnsupportedOperationException();
   }

   public String get(int index)
   {
      throw new UnsupportedOperationException();
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
      return new RecursiveOOStringList();
   }

   public StringList toUpperCase()
   {
      return new RecursiveOOStringList();
   }

   public StringList startsWith(String prefix)
   {
      return new RecursiveOOStringList();
   }

   public StringList hasSubstring(String substring)
   {
      return new RecursiveOOStringList();
   }

}
