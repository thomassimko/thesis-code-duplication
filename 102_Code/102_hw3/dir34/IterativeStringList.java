import java.*;
import java.util.NoSuchElementException;

public class IterativeStringList
   implements StringList
{
   private IterativeNode node;
   private IterativeNode head;
   private int size;
   private int index;
   
   public IterativeStringList()
   {
      this.head = null;
   }

   public void addToEnd(String value)
   {
      IterativeNode node = new IterativeNode(value, null);
      if(head == null)
      {
         this.head = node;
      }
      else
      {
         IterativeNode cur = this.head;
         while(cur.getNext() != null)
         {
            cur = cur.getNext();
         }
         cur.setNext(node);
      }
   }

   public void add(int index, String value)
   {
      if(this.head == null)
      {
         if(index == 0)
         {
            this.head = new IterativeNode(value, null);
         }
         else
         {
            throw new IndexOutOfBoundsException();
         }  
      }
      else
      {
         if(index == 0)
         {
            this.head = new IterativeNode(value, head);
         }
         if(index < 0)
         {
            throw new IndexOutOfBoundsException();
         }
         else
         {
            IterativeNode cur = head;
            for(int i = 1; i < index && cur != null; i++)
            {
               cur = cur.getNext();
            }
            if(cur == null)
            {
               throw new IndexOutOfBoundsException();
            }
            else
            {
               IterativeNode node = new IterativeNode(value, cur.getNext());
               cur.setNext(node);
            }
         }
      }
   }   

   public void remove(int index)
   {
      IterativeNode cur = head;

      if(this.head == null || index < 0)
      {
         throw new IndexOutOfBoundsException();
      }
      else if(index == 0)
      {
         this.head = head.getNext();
      }
      else
      {
         for(int i=1; i < index - 1 && cur != null; i++)
         {
            cur = cur.getNext();
         }
         if(cur == null)
         {
            throw new IndexOutOfBoundsException();
         }
         else
         {
            cur.setNext(cur.getNext().getNext());
         }
      }
   }

   public String get(int index)
   {
      IterativeNode cur = head;
     
      if(this.head == null || index < 0)
      {
         throw new IndexOutOfBoundsException();
      }
      for(int i=0; i < index && cur != null; i++)
      {
         cur = cur.getNext();
      }
      if(cur == null)
      {
         throw new IndexOutOfBoundsException();
      }
      else
      {
         return cur.getString();
      }
   }
      
   public int indexOf(String element)
   {
      IterativeNode cur = head;
   
      if(this.head == null)
      {
         throw new NoSuchElementException();
      }
      for(int i=0; cur != null; i++)
      {
         if(cur.getString() == element)
         {
            return i+1;
         }
         cur = cur.getNext();
      }
      throw new NoSuchElementException();
   }

   public int size()
   {
      IterativeNode cur = head;
      int i = 0;
      for(i=0; cur != null; i++)
      {     
         cur = cur.getNext();
      }
      return i;
   }

   public StringList toLowerCase()
   {
      IterativeNode cur = head;
      StringList list = new IterativeStringList();
      for(int i=0; cur != null; i++)
      {
         list.add(i, cur.getString().toLowerCase());
         cur = cur.getNext();
      }
      return list;
   }

   public StringList toUpperCase()
   {
      IterativeNode cur = head;
    
      StringList list = new IterativeStringList();
      for(int i=0; cur != null; i++)
      {
         list.add(i, cur.getString().toUpperCase());
         cur = cur.getNext();
      }
      return list;
   }

   public StringList startsWith(String prefix)
   {
      IterativeNode cur = head;
   
      StringList list = new IterativeStringList();
      for(int i=0; cur != null; i++)
      {
         if(cur.getString().startsWith(prefix))
         {
            list.add(i, cur.getString());
            cur = cur.getNext();
         }
      }
      return list;
   }

   public StringList hasSubstring(String substring)
   {
      IterativeNode cur = head;
   
      StringList list = new IterativeStringList();
      for(int i=0; cur != null; i++)
      {
         if(cur.getString().contains(substring))
         {
            list.add(i, cur.getString());
         }
         cur = cur.getNext();
      }
      return list;
   }
}
 
