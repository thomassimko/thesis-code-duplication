import java.util.*;

public class ROOEmpty
   implements RecursiveOONode
{
   public ROOEmpty()
   {}

   public String toString()
   {
      throw new UnsupportedOperationException();
   }

   public RecursiveOONode next()
   {
      throw new UnsupportedOperationException();
   }

   public RecursiveOONode addToEnd(String element)
   {
      ROONode n = new ROONode(element, this);
      return n;
   }

   public RecursiveOONode add(int index, String element)
   {
      if (index != 0)
      {
         throw new IndexOutOfBoundsException();
      }
      ROONode n = new ROONode(element, this);
      return n;
   }

   public RecursiveOONode remove(int index, StringObj s)
   {
      throw new IndexOutOfBoundsException();
   }

   public String get(int index)
   {
      throw new IndexOutOfBoundsException();
   }

   public int indexOf(int c, String element)
   {
      throw new NoSuchElementException();
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
