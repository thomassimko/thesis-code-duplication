public class IterativeStringList
   implements StringList
{
   private IterativeNode head;

   void addToEnd(String element)
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

   void add(int index, String element)
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
            cur.setNext(new IterativeNode(element, cur.getNext()));
         }
      }
   }

   void remove(int index)
   {
      if(index == 0)
      {
         head = head.getNext();
      }
      else if(index < 0)
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
         cur.setNext(cur.getNext().getNext());
      }
   }

   String get(int index)
   {
      if(index < 0)
      {
         throw new IndexOutOfBoundsException();
      }
      else if(index == 0)
      {
         return head.getString();
      }
      else
      {
         IterativeNode cur = head;
         for(int i = 1; i == index && cur != null; i++)
         {
            cur = cur.getNext();
         }
         if(cur == null)
         {
            throw new IndexOutOfBoundsException();
         }
         return cur.getString();
      }
   }

   int indexOf(String element)
   {
      IterativeNode cur = head;
      int index = 0;
      while(!cur.getString().equals(element) && cur != null)
      {
         cur = cur.getNext();
         index++;
      }
      if(cur == null)
      {
         throw new IndexOutOfBoundsException();
      }
      return index;
   }

   int size()
   {
      IterativeNode cur = head;
      int size = 0;
      while(cur != null)
      {
         size++;
         cur = cur.getNext();
      }
      return size;
   }

   StringList toLowerCase()
   {
      Stringlist list = new Stringlist();
      IterativeNode cur = head;
      while(cur != null)
      {
         String element = cur.getString();
         list.toLowerCase().addToEnd(element);
         cur = cur.getNext();
      }
      cur = cur.getNext();
      return list;
   }

   StringList toUpperCase()
   {
      StringList list = new StringList();
      IterativeNode cur = head;
      while(cur != null)
      {
         String element = cur.getString();
         list.toUpperCase().addToEnd(element);
         cur = cur.getNext();
      }
      cur = cur.getNext();
      return list;
   }

   StringList startsWith(String prefix)
   {
      StringList list = new StringList();
      IterativeNode cur = head;
      while(cur != null)
      {
         if(cur.getString().equals(prefix))
         {
            String element = cur.getString();
            list.addToEnd(element);
            cur = cur.getNext();
         }
         else
         {
            cur = cur.getNext();
         }
      }
      cur = cur.getNext();
      return list;
   }

   StringList hasSubstring(String substring)
   {
      StringList list = new StringList();
      IterativeNode cur = head;
      while(cur != null)
      {
         if(cur.getString().startsWith() == true)
         {
            String element = cur.getString();
            list.addToEnd(element);
            cur = cur.getNext();
         }
         else
         {
            cur = cur.getNext();
         }
      }
      cur = cur.getNext();
      return list;
   }
}
