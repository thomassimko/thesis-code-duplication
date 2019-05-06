import java.lang.IndexOutOfBoundsException;

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
          while( cur.getNext() != null)
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
            IterativeNode cur = head;
            for(int i = 1; i < index && cur!=null; i++)
            {
               cur = cur.getNext();
            }
            if (cur == null)
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

   public String remove(int index)
   {
      IterativeNode cur = this.head;
      String removed;
      
      if(index == 0)
      {
         if(this.head == null)
         {
            throw new IndexOutOfBoundsException();
         }
         else
         {
            removed = cur.getString();
            // Not sure if this is right ****** <-----Check!!!
            this.head = cur.getNext();
         }
      }
      else if (index < 0)
      {
         throw new IndexOutOfBoundsException();
      }
      else
      {
         for(int i = 1; i < index && cur != null; i++)
         {
            cur = cur.getNext();
         }
         if ( cur == null)
         {
            throw new IndexOutOfBoundsException();
         }
         else
         {
            removed = cur.getNext().getString();
            cur.setNext(cur.getNext().getNext());
         }
      }
   
      return removed;
   }

   public String get(int index)
   {
        IterativeNode cur = this.head;
        String retrieve;
      
      if(index == 0)
      {
         retrieve = this.head.getString();
      }
      else if (index < 0)
      {
         throw new IndexOutOfBoundsException();
      }
      else
      {
         for(int i = 1; i < index && cur != null; i++)
         {
            cur = cur.getNext();
         }
         if ( cur == null)
         {
            throw new IndexOutOfBoundsException();
         }
         else
         {
            retrieve = cur.getNext().getString();

         }
      }
   
      return retrieve;
   }

   public int indexOf(String element)
   {
       IterativeNode cur = this.head;
       int index = 0;
       
       if (cur.getString().equals(element))
       {
          return index;
       }
   
       while( cur != null)
       {
          if (cur.getString().equals(element))
          {
             return index;
          }
          index++;
          cur = cur.getNext();
       }
   
       return -1;
   }

   public int size()
   {
       IterativeNode cur = this.head;
       int size = 0;
       
       while( cur != null)
       {
          size++;
          cur = cur.getNext();
       }
       
       return size;
   }

   public StringList toLowerCase()
   {
      IterativeNode cur = this.head;
      StringList lowerCase = new IterativeStringList();
      
      while(cur != null)
      {
         String v = cur.getString();
         String newV = v.toLowerCase();
         lowerCase.addToEnd(newV);
         cur = cur.getNext();
      }
      
      return lowerCase;
   }

   public StringList toUpperCase()
   {
      IterativeNode cur = this.head;
      StringList upperCase = new IterativeStringList();
      
      while(cur != null)
      {
         String v = cur.getString();
         String newV = v.toUpperCase();
         upperCase.addToEnd(newV);
         cur = cur.getNext();
      }
      
      return upperCase;
   }

   public StringList startsWith(String prefix)
   {
      IterativeNode cur = this.head;
      StringList startW = new IterativeStringList();
      
      while(cur != null)
      {
         String v = cur.getString();
         if(v.startsWith(prefix))
         {
            startW.addToEnd(v);
         }
         cur = cur.getNext();
      }
      
      return startW;
   }

   public StringList hasSubstring(String substring)
   {
      IterativeNode cur = this.head;
      StringList hasSub = new IterativeStringList();
      
       while(cur != null)
      {
         String v = cur.getString();
         if(v.contains(substring))
         {
            hasSub.addToEnd(v);
         }
         cur = cur.getNext();
      }
      
      return hasSub;
   }
}
