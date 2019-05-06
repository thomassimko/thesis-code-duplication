public class RecursiveIOStringList
   implements StringList
{
   private RecursiveIONode head;

   public RecursiveIOStringList()
   {
      this.head = new RIOEmpty();
   }

   public void addToFront(String element)
   {
      this.head = new RIONode(element, this.head);
   }

   public void addToEnd(String element)
   {
      this.head = addToEnd(element, this.head);
   }

   private RecursiveIONode addToEnd(String element, RecursiveIONode cur)
   {
      if (cur instanceof RIOEmpty)
      {
         RecursiveIONode n = new RIONode(element, cur);
         return n;
      }
      else if (cur instanceof RIONode)
      {
         RecursiveIONode n = addToEnd(element, cur.next());
         cur.setNext(n);
         return cur;
      }
      else
      {
         throw new NullPointerException();
      }
   }

   public void add(int index, String element)
   {
      this.head = add(index, element, this.head);
   }

   private RecursiveIONode add(int index, String element, RecursiveIONode cur)
   {
      if (cur instanceof RIOEmpty)
      {
         RecursiveIONode n = new RIONode(element, cur);
         return n;
      }
      else if (cur instanceof RIONode)
      {
         if (index == 0)
         {
            RecursiveIONode n = new RIONode(element, cur);
            return n;
         }
         else
         {
            RecursiveIONode n = add(index - 1, element, cur.next());
            cur.setNext(n);
            return cur;
         }
      }
      else
      {
         throw new IndexOutOfBoundsException();
      }
   }

   public String remove(int index)
   {
      StringObj string = new StringObj();
      this.head = remove(index, string, this.head);
      return string.toString();
   }

   private RecursiveIONode remove(int index, StringObj s, RecursiveIONode cur)
   {
      if (cur instanceof RIOEmpty)
      {
         throw new IndexOutOfBoundsException();
      }
      else if (cur instanceof RIONode)
      {
         if (index == 0)
         {
            s.setString(cur.toString());
            return cur.next();
         }
         else
         {
            RecursiveIONode n = remove(index - 1, s, cur.next());
            cur.setNext(n);
            return cur;
         }
      }
      else
      {
         throw new IndexOutOfBoundsException();
      }
   }

   public String get(int index)
   {
      return get(index, this.head);
   }

   private String get(int index, RecursiveIONode cur)
   {
      if (cur instanceof RIOEmpty)
      {
         throw new IndexOutOfBoundsException();
      }
      else if (cur instanceof RIONode)
      {
         if (index == 0)
         {
            return cur.toString();
         }
         else
         {
            return get(index - 1, cur.next()); 
         }
      }
      else
      {
         throw new IndexOutOfBoundsException();
      }
   }

   public int indexOf(String element)
   {
      return indexOf(0, element, this.head);
   }

   private int indexOf(int c, String element, RecursiveIONode cur)
   {
      if (cur instanceof RIOEmpty)
      {
         throw new IndexOutOfBoundsException();
      }
      else if (cur instanceof RIONode)
      {
         if (cur.toString().equals(element))
         {
            return c;
         }
         else
         {
            return indexOf(c + 1, element, cur.next());
         }
      }
      else
      {
         throw new IndexOutOfBoundsException();
      }
   }

   public int size()
   {
      return size(this.head);
   }

   private int size(RecursiveIONode cur)
   {
      if (cur instanceof RIOEmpty)
      {
         return 0;
      }
      else if (cur instanceof RIONode)
      {
         return 1 + size(cur.next());
      }
      else
      {
         throw new IndexOutOfBoundsException();
      }
   }

   public StringList toLowerCase()
   {
      return toLowerCase(this.head);
   }

   private StringList toLowerCase(RecursiveIONode cur)
   {
      if (cur instanceof RIOEmpty)
      {
         return new RecursiveIOStringList();
      }
      else if (cur instanceof RIONode)
      {
         StringList list = toLowerCase(cur.next());
         ((RecursiveIOStringList)list).addToFront(cur.toString().toLowerCase());
         return list;
      }
      else
      {
         throw new IndexOutOfBoundsException();
      }
   } 

   public StringList toUpperCase()
   {
      return toUpperCase(this.head);
   }

   private StringList toUpperCase(RecursiveIONode cur)
   {
      if (cur instanceof RIOEmpty)
      {
         return new RecursiveIOStringList();
      }
      else if (cur instanceof RIONode)
      {
         StringList list = toUpperCase(cur.next());
         ((RecursiveIOStringList)list).addToFront(cur.toString().toUpperCase());
         return list;
      }
      else
      {
         throw new IndexOutOfBoundsException();
      }
   }

   public StringList startsWith(String prefix)
   {
      return startsWith(prefix, this.head);
   }

   private StringList startsWith(String prefix, RecursiveIONode cur)
   {
      if (cur instanceof RIOEmpty)
      {
         return new RecursiveIOStringList();
      }
      else if (cur instanceof RIONode)
      {
         StringList list = startsWith(prefix, cur.next());
         if (cur.toString().startsWith(prefix))
         {
            ((RecursiveIOStringList)list).addToFront(cur.toString());
         }
         return list;
      }
      else
      {
         throw new IndexOutOfBoundsException();
      }
   }

   public StringList hasSubstring(String substring)
   {
      return hasSubstring(substring, this.head);
   }

   private StringList hasSubstring(String substring, RecursiveIONode cur)
   {
      if (cur instanceof RIOEmpty)
      {
         return new RecursiveIOStringList();
      }
      else if (cur instanceof RIONode)
      {
         StringList list = hasSubstring(substring, cur.next());
         if (cur.toString().contains(substring))
         {
            ((RecursiveIOStringList)list).addToFront(cur.toString());
         }
         return list;
      }
      else
      {
         throw new IndexOutOfBoundsException();
      }
   }
}
