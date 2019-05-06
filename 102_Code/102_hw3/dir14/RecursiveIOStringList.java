import java.util.NoSuchElementException;
public class RecursiveIOStringList 
   implements StringList 
{
   private RecursiveIONode head;
    
   public RecursiveIOStringList()
   {
      head = new RIOEmpty();
   }

   public void addToEnd(String element)
   {
      head = addToEndHelper(element, head);
   }

   private RecursiveIONode addToEndHelper(String element, RecursiveIONode cur)
   {
      if(cur instanceof RIOEmpty)
      {
         RecursiveIONode n = new RIONode(element, cur);
         return n;
      }
      else
      {
         RecursiveIONode n = addToEndHelper(element, ((RIONode)cur).getNext());
         ((RIONode)cur).setNext(n);
         return cur;
      }
   }

   public void add(int index, String element)
   {
      head = add(index, element, head);
   }

   private RecursiveIONode add(int index, String element, RecursiveIONode cur)
   {
      if(cur instanceof RIOEmpty && index == 0)
      {
         RecursiveIONode n = new RIONode(element, cur);
         return n;
      }
      else if(cur instanceof RIONode)
      {
         if(index == 0)
         {
            RecursiveIONode n = new RIONode(element, cur);
            return n;
         }
         else
         {
            RecursiveIONode n = add(index-1, element, ((RIONode)cur).getNext());
            ((RIONode)cur).setNext(n);
            return n;
         }
      }
      else
      {
         throw new IndexOutOfBoundsException();
      }
   }

   public void remove(int index)
   {
      head = remove(index, head);
   }
   
   private RecursiveIONode remove(int index, RecursiveIONode cur)
   {
      if(cur instanceof RIOEmpty && index == 0)
      {
         throw new IndexOutOfBoundsException();
      }
      else
      {
         if(index == 0)
         {
            return cur.getNext();
         }
         else
         {
            RecursiveIONode n = remove(index-1, ((RIONode)cur).getNext());
            ((RIONode)cur).setNext(n);
            return cur;
         }
      }
   }

   public String get(int index)
   {
      return get(index, head).getElement();
   }

   private RecursiveIONode get(int index, RecursiveIONode cur)
   {
      if(cur instanceof RIOEmpty && index == 0)
      {
         throw new IndexOutOfBoundsException();
      }
      else
      {
         if(index == 0)
         {
            return cur;
         }
         else
         {
            RecursiveIONode n = get(index-1, cur.getNext());
            return n;
         }
      }
   }

   public int indexOf(String element)
   {
       return indexOf(element, head);
   }

   public int indexOf(String element, RecursiveIONode cur)
   {
      if(cur instanceof RIOEmpty)
      {
         throw new NoSuchElementException();
      }
      else 
      {
         if(cur.getElement().equals(element))
         {
            return 0;
         }
         else
         {
            return 1 + indexOf(element, cur);
         }
      }
   }

   public int size()
   {
      return size(head);
   }

   public int size(RecursiveIONode cur)
   {
      if(cur instanceof RIOEmpty)
      {
         return 0;
      }
      else
      {
         return 1 + size(cur.getNext());
      }
   }

   public StringList toLowerCase()
   {
      return toLowerCase(head);
   }

   public StringList toLowerCase(RecursiveIONode cur)
   {
      if(cur instanceof RIOEmpty)
      {
         StringList list = new RecursiveIOStringList();
         return list;
      }
      else
      {
         StringList newList = toLowerCase(cur.getNext());
         newList.add(0, cur.getElement().toLowerCase());
         return newList;
      }
   }
 
   public StringList toUpperCase()
   {
      return toUpperCase(head);
   }

   public StringList toUpperCase(RecursiveIONode cur)
   {
      if(cur instanceof RIOEmpty)
      {
         StringList list = new RecursiveIOStringList();
         return list;
      }
      else
      {
         StringList newList = toUpperCase(cur.getNext());
         newList.add(0, cur.getElement().toUpperCase());
         return newList;
      }
   }

   public StringList startsWith(String prefix)
   {
      return startsWith(prefix, head);
   }

   public StringList startsWith(String prefix, RecursiveIONode cur)
   {
      if(cur instanceof RIOEmpty)
      {
         StringList list = new RecursiveIOStringList();
         return list;
      }
      else
      {
         StringList newList = startsWith(prefix, cur.getNext());
         if(cur.getElement().startsWith(prefix))
         {
            newList.add(0, cur.getElement());
         }
         return newList;
      }
   }
 
   public StringList hasSubstring(String substring)
   {
      return hasSubstring(substring, head);
   }
 
   public StringList hasSubstring(String substring, RecursiveIONode cur)
   {
      if(cur instanceof RIOEmpty)
      {
         StringList list = new RecursiveIOStringList();
         return list;
      }
      else
      {
         StringList newList = hasSubstring(substring, cur.getNext());
         if(cur.getElement().contains(substring))
         {
            newList.add(0, cur.getElement());
         }
         return newList;
      }
   }	
}
