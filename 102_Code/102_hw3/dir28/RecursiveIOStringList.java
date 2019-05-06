import java.util.NoSuchElementException;

public class RecursiveIOStringList
   implements StringList
{
   private RecursiveIONode head;
   public RecursiveIOStringList()
   {
      this.head = new RIOEmpty();
   }
   public void add(int index, String element)
   {
      this.head = addHelper(index, element, this.head);
   }
   private RecursiveIONode addHelper(int index, String element, RecursiveIONode cur)
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
            RecursiveIONode n = addHelper(index-1, element, cur.getNext());
            cur.setNext(n);
            return cur;
         }
      }
      else
      {
         throw new IndexOutOfBoundsException();
      }
   }
   public void addToEnd(String element)
   {
      this.head = addToEndHelper(element, this.head);
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
         RecursiveIONode n = addToEndHelper(element, cur.getNext());
         cur.setNext(n);
         return cur;
      }
   }
   public String get(int index)
   {
      return getHelper(index, this.head);
   }
   private String getHelper(int index, RecursiveIONode cur)
   {
      if(cur instanceof RIOEmpty)
      {
         throw new NoSuchElementException();
      }
      else
      {
         if(index < 0)
         {
            throw new IndexOutOfBoundsException();
         }
         else if(index == 0)
         {
            return cur.getString();
         }
         else
         {
            return getHelper(index-1, cur.getNext());
         }
      }
      
   }
   public StringList hasSubstring(String substring)
   {
      return hasSubstringHelper(substring, this.head);
   }
   private StringList hasSubstringHelper(String substring, RecursiveIONode cur)
   {
      if(cur instanceof RIOEmpty)
      {
         StringList s = new RecursiveIOStringList();
         return s;
      }
      StringList l = hasSubstringHelper(substring, cur.getNext());
      if(cur.getString().contains(substring))
      {
         l.add(0, cur.getString());
      }
      return l;
   }
   public int indexOf(String element)
   {
      return indexOfHelper(element, this.head);
   }
   private int indexOfHelper(String element, RecursiveIONode cur)
   {
      if(cur instanceof RIOEmpty)
      {
         return 0;
      }
      else
      {
         if(element.equals(cur.getString()))
         {
            return 0;
         }
         else
         {
            return 1 + indexOfHelper(element, cur.getNext());
         }
      }
   }
   public void remove(int index)
   {
      this.head = removeHelper(index, this.head);
   }
   private RecursiveIONode removeHelper(int index, RecursiveIONode cur)
   {
      if(cur instanceof RIOEmpty && index == 0)
      {
         RecursiveIONode n = new RIOEmpty();
         return n;
      }
      else
      {
         if(index < 0)
         {
            throw new IndexOutOfBoundsException();
         }
         else if(index == 0)
         {
            return cur.getNext();
         }
         else
         {
            RecursiveIONode n = removeHelper(index-1, cur.getNext());
            cur.setNext(n);
            return cur;
         }
      }
   }
   public int size()
   {
      return sizeHelper(this.head);
   }
   private int sizeHelper(RecursiveIONode cur)
   {
      if(cur instanceof RIOEmpty)
      {
         return 0;
      }
      else
      {
         return 1 + sizeHelper(cur.getNext());
      }
   }
   public StringList startsWith(String prefix)
   {
      return startsWithHelper(prefix, this.head);
   }
   private StringList startsWithHelper(String prefix, RecursiveIONode cur)
   {
      if(cur instanceof RIOEmpty)
      {
         StringList s = new RecursiveIOStringList();
         return s;
      }
      StringList l = startsWithHelper(prefix, cur.getNext());
      if(cur.getString().startsWith(prefix))
      {
         l.add(0, cur.getString());
      }
      return l;
   }
   public StringList toLowerCase()
   {
      return toLowerCaseHelper(this.head);
   }
   private StringList toLowerCaseHelper(RecursiveIONode cur)
   {
      if(cur instanceof RIOEmpty)
      {
         StringList s = new RecursiveIOStringList();
         return s;
      }
      StringList l = toLowerCaseHelper(cur.getNext());
      l.add(0, cur.getString().toLowerCase());
      return l;
   }
   public StringList toUpperCase()
   {
      return toUpperCaseHelper(this.head);
   }
   private StringList toUpperCaseHelper(RecursiveIONode cur)
   {
      if(cur instanceof RIOEmpty)
      {
         StringList s = new RecursiveIOStringList();
         return s;
      }
      StringList l = toUpperCaseHelper(cur.getNext());
      l.add(0, cur.getString().toUpperCase());
      return l;
   }
}