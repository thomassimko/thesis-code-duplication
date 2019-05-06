import java.util.NoSuchElementException;

public class ROOEmpty
   implements RecursiveOONode
{
   public RecursiveOONode addToEnd(String string)
   {
      ROONode n = new ROONode(string, this);
      return n;
   }
   
   public RecursiveOONode add(int index, String string)
   {
      if (index!=0) 
      {
            throw new IndexOutOfBoundsException();
      }
      RecursiveOONode n = new ROONode(string,this);
      return n;
   }
   
   public String remove(int index)
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
   
   public RecursiveOOStringList toLowerCase()
   {
	   return new RecursiveOOStringList();
   }
   public RecursiveOOStringList toUpperCase()
   {
	   return new RecursiveOOStringList();   
   }
   
   public RecursiveOOStringList startsWith(String prefix)
   {
	   return new RecursiveOOStringList();
   }
   
   public RecursiveOOStringList hasSubstring(String substring) 
   {
	   return new RecursiveOOStringList();
   }

   public RecursiveOONode getNext() 
   {
	   throw new UnsupportedOperationException();
   }

   public String getValue() 
   {
	   throw new UnsupportedOperationException();
   }

   public RecursiveOONode setNext(RecursiveOONode n) 
   {
	   throw new UnsupportedOperationException();
   }
}