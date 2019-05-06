public class IterativeStringList implements StringList
{
   private IterativeNode head;
   private int size;
   
   public IterativeStringList()
   {
      this.head = null;
      this.size = 0;
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
      size++;
   }
   public void add(int index, String element)
   {
      if(this.head == null)
      {
         if(index == 0)
         {
            this.head = new IterativeNode(element, null);
            size++;
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
            size++;
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
               size++;
            }
            if(cur == null)
            {
               throw new IndexOutOfBoundsException();
            }
            else
            {
               IterativeNode n = new IterativeNode(element, cur.getNext());
               cur.setNext(n);
               size++;
            }
         }
      }
   }
   public void remove(int index)
   {
      IterativeNode cur = head;
      
      if(index < 0)
      {
         throw new IndexOutOfBoundsException();
      }
      else if(index == 0)
      {
         head = cur.getNext();
         size--;
      }
      else
      {
         for(int i = 0; i < index - 1 && cur != null; i++)
         {
            cur = cur.getNext();
         }
         cur.setNext(cur.getNext().getNext());
         size--;
      }
   }
   public String get(int index)
   {
      IterativeNode cur = head;
      if(index < 0)
      {
         throw new IndexOutOfBoundsException();
      }
      for(int i = 0; i < index && cur != null; i++)
      {
         cur = cur.getNext();
      }
      return cur.getElement();
   }
   public int indexOf(String element)
   {
      IterativeNode cur = head;
      int index = 0;
      for(int i = 0; i < size && cur != null; i++)
      {
         if(cur.getElement().equals(element))
         {
            index = i;
         }
         cur = cur.getNext();
      }
      return index;
   }
   public int size()
   {
      return size;
   }
   public StringList toLowerCase()
   {
      StringList sl = new IterativeStringList();
      IterativeNode cur = head;
      String [] list = new String[size];
      for(int i = 0; i < size && cur != null; i++)
      {
         list[i] = cur.getElement().toLowerCase();
         cur = cur.getNext();
         sl.addToEnd(list[i]);
      }
      return sl;
   }
   public StringList toUpperCase()
   {
      StringList sl = new IterativeStringList();
      IterativeNode cur = head;
      String [] list = new String[size];
      for(int i = 0; i < size && cur != null; i++)
      {
         list[i] = cur.getElement().toUpperCase();
         cur = cur.getNext();
         sl.addToEnd(list[i]);
      }
      return sl;
   }
   public StringList startsWith(String prefix)
   {
      StringList list = new IterativeStringList();
      IterativeNode cur = head;
      for(int i = 0; i < size && cur != null; i++);
      {
         if(cur.getElement().startsWith(prefix))
         {
            list.addToEnd(cur.getElement());
         }
         cur = cur.getNext();
      }
      return list;
   }
   public StringList hasSubstring(String substring)
   {
      StringList list = new IterativeStringList();
      IterativeNode cur = head;
      String match;
      for(int i = 0; i < size && cur != null; i++)
      {
         if(cur.getElement().contains(substring))
         {
            match = cur.getElement();
            list.addToEnd(match);
         }
         cur = cur.getNext();
      }
      return list;
   }
}