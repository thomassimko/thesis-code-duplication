import java.util.*;

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
      if (this.head == null)
      {
         this.head = n;
      }
      else
      {
         IterativeNode cur = this.head;
         while (cur.next() != null)
         {
            cur = cur.next();
         }
         cur.setNext(n);
      }
   }

   public void add(int index, String element)
   {
      if (this.head == null)
      {
         if (index == 0)
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
         if (index == 0)
         {
            this.head = new IterativeNode(element, this.head);
         }
         else if (index < 0)
         {
            throw new IndexOutOfBoundsException();
         }
         else
         {
            IterativeNode cur = this.head;
            for (int i = 1; i < index && cur != null; i++)
            {
               cur = cur.next();
            }
            if (cur == null)
            {
               throw new IndexOutOfBoundsException();
            }
            else
            {
               IterativeNode n = new IterativeNode(element, cur.next());
               cur.setNext(n);
            }
         }
      }
   }

   public String remove(int index)
   {
      if (this.head == null)
      {
         throw new IndexOutOfBoundsException();
      }
      else
      {
         if (index == 0)
         {
            String s = this.head.toString();
            this.head = this.head.next();
            return s;
         }
         else if (index < 0)
         {
            throw new IndexOutOfBoundsException();
         }
         else
         {
            IterativeNode cur = this.head;
            for (int i = 1; i < index && cur != null; i++)
            {
               cur = cur.next();
            }
            if (cur == null)
            {
               throw new IndexOutOfBoundsException();
            }
            else
            {
               String s = cur.next().toString();
               cur.setNext(cur.next().next());
               return s;
            }
         }
      }
   }

   public String get(int index)
   {
      if (this.head == null)
      {
         throw new IndexOutOfBoundsException();
      }
      else
      {
         if (index < 0)
         {
            throw new IndexOutOfBoundsException();
         }
         else
         {
            IterativeNode cur = this.head;
            for (int i = 0; i < index && cur != null; i++)
            {
               cur = cur.next();
            }
            if (cur == null)
            {
               throw new IndexOutOfBoundsException();
            }
            else
            {
               return cur.toString();
            }
         }
      }
   }

   public int indexOf(String element)
   {
      if (this.head == null)
      {
         throw new NoSuchElementException();
      }
      else
      {
         IterativeNode cur = this.head;
         int x = 0;
         while (cur != null)
         {
            if (element.equals(cur.toString()))
            {
               return x;
            }
            x++;
            cur = cur.next();
         }
         throw new NoSuchElementException();
      }
   }

   public int size()
   {
      if (this.head == null)
      {
         return 0;
      }
      else
      {
         int s = 0;
         IterativeNode cur = this.head;
         while (cur != null)
         {
            s++;
            cur = cur.next();
         }
         return s;
      }
   }

   public StringList toLowerCase()
   {
      if (this.head == null)
      {
         throw new NullPointerException();
      } 
      else
      {
         StringList newList = new IterativeStringList();
         IterativeNode cur = this.head;
         while (cur != null)
         {
            newList.addToEnd(cur.toString().toLowerCase());
            cur = cur.next();
         }
         return newList;  
      }
   }

   public StringList toUpperCase()
   {
      if (this.head == null)
      {
         throw new NullPointerException();
      } 
      else
      {
         StringList newList = new IterativeStringList();
         IterativeNode cur = this.head;
         while (cur != null)
         {
            newList.addToEnd(cur.toString().toUpperCase());
            cur = cur.next();
         }
         return newList;  
      }
   }

   public StringList startsWith(String prefix)
   {
      if (this.head == null)
      {
         throw new NullPointerException();
      }
      else
      {
         StringList newList = new IterativeStringList();
         IterativeNode cur = this.head;
         while (cur != null)
         {
            if (cur.toString().startsWith(prefix))
            {
               newList.addToEnd(cur.toString());
            }
            cur = cur.next();
         }
         return newList;
      }
   }

   public StringList hasSubstring(String substring)
   {
      if (this.head == null)
      {
         throw new NullPointerException();
      }
      else
      {
         StringList newList = new IterativeStringList();
         IterativeNode cur = this.head;
         while (cur != null)
         {
            if (cur.toString().contains(substring))
            {
               newList.addToEnd(cur.toString());
            }
            cur = cur.next();
         }
         return newList;
      }
   }
}
