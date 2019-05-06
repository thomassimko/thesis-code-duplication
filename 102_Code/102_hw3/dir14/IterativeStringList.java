import java.util.NoSuchElementException;

public class IterativeStringList 
   implements StringList
{
   private IterativeNode head;

   public IterativeStringList()
   {
      this.head = null;
   }

   public void addToEnd(String element)
   {
      IterativeNode n = new IterativeNode(element, null);
      if(head == null)
      {
         this.head = n;
      }
      else
      {
         IterativeNode cur = this.head;
         while(cur.getNext() != null)
         {
            cur = cur.getNext();
         }
         cur.setNext(n);
      }
   }

   public void add(int index, String element)
   {
      if(this.head == null)
      {
         if(index == 0)
         {
            this.head = new IterativeNode(element, null);
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
            this.head = new IterativeNode(element, this.head);
         }
         else if(index < 0)
         {
            throw new IndexOutOfBoundsException();
         }
         else if(index > 0)
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
               IterativeNode n = new IterativeNode(element, cur.getNext());
               cur.setNext(n);
            }
         }
      }
   }

   public void remove(int index)
   {
      IterativeNode cur = head;
      if(index == 0)
      {
         this.head = this.head.getNext();
      }
      else
      {
         for(int i = 1; i < index && cur != null; i++)
         {
            cur = cur.getNext();
         }
         cur.setNext(cur.getNext().getNext());
      }
   }

   public String get(int index)
   {
      IterativeNode cur = head;
      for(int i = 0; i < index && cur != null; i++)
      {
         cur = cur.getNext();
      }
      return cur.getElement();
   }

   public int indexOf(String element)
   {
      int i;
      IterativeNode cur = head;
      for(i = 0; cur != null && !cur.getElement().equals(element); i++)
      {
         cur = cur.getNext();
      }
      if(cur == null)
      {
         throw new NoSuchElementException();
      }
      else
      {
         return i;
      }
   }

   public int size()
   {
      int i;
      IterativeNode cur = head;
      for(i = 0; cur != null; i++)
      {
         cur = cur.getNext();
      }
      return i;
   }

   public StringList toLowerCase()
   {
      IterativeNode cur = head;
      StringList newList = new IterativeStringList();
      while(cur != null)
      {
         String s = cur.getElement();
         String newString = s.toLowerCase();
         newList.addToEnd(newString);
         cur = cur.getNext();
      }
      return newList;
   }

   public StringList toUpperCase()
   {
      IterativeNode cur = head;
      StringList newList = new IterativeStringList();
      while(cur != null)
      {
         String s = cur.getElement();
         String newString = s.toUpperCase();
         newList.addToEnd(newString);
         cur = cur.getNext();
      }
      return newList;
   }

   public StringList startsWith(String prefix)
   {
      IterativeNode cur = head;
      StringList newList = new IterativeStringList();
      while(cur != null)
      {
         String s = cur.getElement();
         if(s.startsWith(prefix))
         {
            String samePrefix = s;
            newList.addToEnd(samePrefix);
         }
         cur = cur.getNext();
      }
      return newList;
   }

   public StringList hasSubstring(String substring)
   {
      IterativeNode cur = head;
      StringList newList = new IterativeStringList();
      while(cur != null)
      {
         String s = cur.getElement();
         if(s.contains(substring))
         {
            String hasSubstring = s;
            newList.addToEnd(hasSubstring);
         }
         cur = cur.getNext();
      }
      return newList;
   }
}
