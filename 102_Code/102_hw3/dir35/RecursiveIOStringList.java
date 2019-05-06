public class RecursiveIOStringList
   implements StringList
{
   private RecursiveIONode head;

   public RecursiveIOStringList()
   {
      head = new RIOEmpty();
   }

   private RecursiveIONode addToEnd(RecursiveIONode node, String element)
   {
      if (node instanceof RIOEmpty)
      {
         RIONode n = new RIONode(element, node);
         return n;
      }
      else
      {
         RecursiveIONode n = addToEnd(node.getNext(), element);
         node.setNext(n);
         return node;
      }
   }

   public void addToEnd(String element)
   {
      head = addToEnd(head, element);
   }

   private RecursiveIONode add(int index, String element, RecursiveIONode cur)
   {
      if (cur instanceof RIOEmpty)
      {
         if (index == 0)
         {
            return new RIONode(element, cur);
         }
         else
         {
            throw new UnsupportedOperationException();
         }
      }
      else if (cur instanceof RIONode)
      {
         if (index == 0)
         {
            return new RIONode(element, cur);
         }
         else if (index < 0)
         {
            throw new IndexOutOfBoundsException();
         }
         else
         {
            RecursiveIONode n = add(index-1, element, ((RIONode)cur).getNext());
            ((RIONode)cur).setNext(n);
            return cur;
         }
      }
      else
      {
         throw new IndexOutOfBoundsException();
      }
   }

   public void add(int index, String element)
   {
      head = add(index, element, head);
   }

   private RecursiveIONode remove(int index, RecursiveIONode cur)
   {
      if (index < 0)
      {
         throw new IndexOutOfBoundsException();
      }

      if (cur instanceof RIOEmpty)
      {
         if (index == 0)
         {
            return new RIOEmpty();
         }
         else
         {
            throw new UnsupportedOperationException();
         }
      }
      else
      {
         if (index == 0)
         {
            return head = head.getNext();
         }
         else if (index == 1)
         {
            cur.setNext(cur.getNext().getNext());
            return cur.getNext();
         }
         else
         {
            return remove(index-1, cur.getNext());
         }
      }
   }

   public void remove(int index)
   {
      remove(index, this.head);
   }

   public String get(int index)
   {
      return get(index, head);
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
            return cur.getString();
         }
         else
         {
            return get(index-1, cur.getNext());
         }
      }
      else
      {
         throw new IndexOutOfBoundsException();
      }
   }

   public int indexOf(String element)
   {
      return indexOf(element, this.head);
   }

   private int indexOf(String element, RecursiveIONode cur)
   {
      if (cur instanceof RIOEmpty)
      {
         throw new UnsupportedOperationException();
      }
      else
      {
         if (cur.getString().equals(element))
         {
            return 0;
         }
         else
         {
            return 1 + indexOf(element, cur.getNext());
         }
      }

   }

   private int size(RecursiveIONode head)
   {
      if (head instanceof RIOEmpty)
      {
         return 0;
      }
      else
      {
         return 1 + size(head.getNext());
      }
   }

   public int size()
   {
      return size(head);
   }

   private StringList toLowerCase(RecursiveIONode cur)
   {
      if (cur instanceof RIOEmpty)
      {
         return new RecursiveIOStringList();
      }
      else if (cur instanceof RIONode)
      {
         StringList newList = toLowerCase(cur.getNext());

         newList.add(0, cur.getString().toLowerCase());

         return newList;
      }
      else
      {
         throw new UnsupportedOperationException();
      }
   }

   public StringList toLowerCase()
   {
      return toLowerCase(this.head);
   }

   private StringList toUpperCase(RecursiveIONode cur)
   {
      if (cur instanceof RIOEmpty)
      {
         return new RecursiveIOStringList();
      }
      else if (cur instanceof RIONode)
      {
         StringList newList = toUpperCase(cur.getNext());

         newList.add(0, cur.getString().toUpperCase());

         return newList;
      }
      else
      {
         throw new UnsupportedOperationException();
      }
   }

   public StringList toUpperCase()
   {
      return toUpperCase(this.head);
   }

   private StringList startsWith(String prefix, RecursiveIONode cur)
   {
      if (cur instanceof RIOEmpty)
      {
         return new RecursiveIOStringList();
      }
      else if (cur instanceof RIONode)
      {
         StringList newList = startsWith(prefix, cur.getNext());

         if (cur.getString().startsWith(prefix))
         {
            newList.add(0, cur.getString());
         }

         return newList;
      }
      else
      {
         throw new UnsupportedOperationException();
      }
   }

   public StringList startsWith(String prefix)
   {
      return startsWith(prefix, this.head);
   }

   private StringList hasSubstring(String substring, RecursiveIONode cur)
   {
      if (cur instanceof RIOEmpty)
      {
         return new RecursiveIOStringList();
      }
      else
      {
         StringList newList = hasSubstring(substring, cur.getNext());

         if (cur.getString().contains(substring))
         {
            newList.add(0, cur.getString());
         }

         return newList;
      }
   }

   public StringList hasSubstring(String substring)
   {
      return hasSubstring(substring, this.head);
   }
}
