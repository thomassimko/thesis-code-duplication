import java.util.NoSuchElementException;

public class ROOEmpty 
   implements RecursiveOONode 
{
   public String getElement(int index)
   {
      throw new UnsupportedOperationException();
   }

   public RecursiveOONode getNext()
   {
      throw new UnsupportedOperationException();
   }
   
   public void setNext(RecursiveOONode node)
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
      else
      {
         RecursiveOONode n = new ROONode(element, this);
         return n;
      }
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
      throw new NoSuchElementException();
   }

   public int size()
   {
      return 0;
   }

   public StringList toLowerCase()
   {
      RecursiveOOStringList list = new RecursiveOOStringList();
      return list;
   }

   public StringList toUpperCase()
   {
      RecursiveOOStringList list = new RecursiveOOStringList();
      return list;
   }

   public StringList startsWith(String prefix)
   {
      RecursiveOOStringList list = new RecursiveOOStringList();
      return list;
   }

   public StringList hasSubstring(String substring)
   {
      RecursiveOOStringList list = new RecursiveOOStringList();
      return list;
   } 
}
