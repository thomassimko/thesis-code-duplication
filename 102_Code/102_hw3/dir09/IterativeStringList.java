import java.lang.*;
import java.util.*;

public class IterativeStringList
   implements StringList
{
   private IterativeNode head;
	private int size;

   public IterativeStringList()
   {
      head = null;
		size = 0;
   }

   public void addToEnd(String element)
   {
      IterativeNode n = new IterativeNode(element, null);

      if(head == null)
      {
         head = n;
			size++;
      }
      else
      {
         IterativeNode cursor = head;

         while(cursor.getNext() != null)
         {
            cursor = cursor.getNext();
         }
         cursor.setNext(n);
			size++;
      }
   }

   public void add(int index, String element)
   {
      if(size == 0)
      {
         if(index == 0) 
			{
			   head = new IterativeNode(element, null);
				size++;
			}
         else throw new IndexOutOfBoundsException();
      }
      else
      {
         if(index == 0)
			{
            head = new IterativeNode(element, head);
				size++;
			}
			else if(index < 0 || index > size) throw new IndexOutOfBoundsException();
			else
			{
			   IterativeNode cursor = head;
				
			   for(int i=1;i<index&&cursor!=null;i++)
				{
				   cursor = cursor.getNext();
			   }
				IterativeNode n = new IterativeNode(element, cursor.getNext());
			   cursor.setNext(n);
				size++;
			}
		}
	}
	
	public void remove(int index)
	{
	   if(index >= size || index < 0) throw new IndexOutOfBoundsException();
		else
		{
			if(index == 0) 
	    	{
			   IterativeNode node = head.getNext();
				head = node;
				size--;
				return;
			}
		   IterativeNode cursor = head;
				
			for(int i=1;i<index&&cursor!=null;i++)
			{
			   cursor = cursor.getNext();
			}
			IterativeNode n = cursor.getNext();
		   cursor.setNext(n.getNext());
			size--;
			return;
		}
	}
	
	public String get(int index)
	{
	   if(index >= size || index < 0) throw new IndexOutOfBoundsException();
		else
		{
		   IterativeNode cursor = head;
			
			for(int i=0;i<index&&cursor!=null;i++)
			{
			   cursor = cursor.getNext();
			}
			return cursor.getString();
		}
	}
	
	public int indexOf(String element)
	{
	   for(int i=0;i<size;i++)
		{
		   if(this.get(i).equals(element)) return i;
		}
	   throw new NoSuchElementException();
	}
	
	public int size()
	{
	   return size;
	}
	
	public StringList toLowerCase()
	{
	   IterativeNode cursor = head;
		IterativeStringList list = new IterativeStringList();
		
		while(cursor != null)
		{
		   String s = cursor.getString().toLowerCase();
			list.addToEnd(s);
			cursor = cursor.getNext();
		}
		return list;
	}
	
	public StringList toUpperCase()
	{
	   IterativeNode cursor = head;
		IterativeStringList list = new IterativeStringList();
		
		while(cursor != null)
		{
		   String s = cursor.getString().toUpperCase();
			list.addToEnd(s);
			cursor = cursor.getNext();
		}
		return list;
	}
	
	public StringList startsWith(String prefix)
	{
	   IterativeNode cursor = head;
		IterativeStringList list = new IterativeStringList();
		
		while(cursor != null)
		{
		   String s = cursor.getString();
			if(s.startsWith(prefix)) list.addToEnd(s);
			cursor = cursor.getNext();
		}
		return list;
	}
	
	public StringList hasSubstring(String substring)
	{
	   IterativeNode cursor = head;
		IterativeStringList list = new IterativeStringList();
		
		while(cursor != null)
		{
		   String s = cursor.getString();
			if(s.contains(substring)) list.addToEnd(s);
			cursor = cursor.getNext();
		}
		return list;
	}
}

