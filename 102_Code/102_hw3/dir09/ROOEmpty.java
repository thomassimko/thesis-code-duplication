import java.lang.*;
import java.util.*;

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
	   RecursiveOONode n = new ROONode(element, this);
		return n;
	}
	
	public RecursiveOONode add(int index, String element)
	{
	   if(index != 0) throw new IndexOutOfBoundsException();
		RecursiveOONode n = new ROONode(element, this);
		return n;
	}
	
	public RecursiveOONode remove(int index)
	{
	   throw new IndexOutOfBoundsException();
	}
	
	public RecursiveOONode get(int index)
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
	
	public StringList toLowerCase(StringList list)
	{
	   return list;
	}
	
	public StringList toUpperCase(StringList list)
	{
	   return list;
	}
	
	public StringList startsWith(StringList list, String prefix)
	{
	   return list;
	}
	
	public StringList hasSubstring(StringList list, String substring)
	{
	   return list;
	}
}
