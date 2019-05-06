public class RecursiveIOStringList implements StringList
{
   RecursiveIONode head;
   
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
         RecursiveIONode n = addToEndHelper(element, cur.getNext());
         cur.setNext(n);
         return cur;
      }
   }
   public void add(int index, String element)
   {
      head = addHelper(index, element, head);
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
            cur.setNext(addHelper(index - 1, element, cur.getNext()));
            return cur;
         }
      }
      else
      {
         throw new IndexOutOfBoundsException();
      }
   }
   public void remove(int index)
   {
      head = removeHelper(index, head);
   }
   private RecursiveIONode removeHelper(int index, RecursiveIONode cur)
   {
      if(cur instanceof RIOEmpty)
      {
         throw new IndexOutOfBoundsException();
      }
      else
      {
         if(cur instanceof RIONode && index == 0)
         {
            cur.setNext(cur.getNext().getNext());
            return cur;
         }
         else if(cur instanceof RIONode && index > 0)
         {
            cur.setNext(removeHelper(index - 1, cur.getNext()));
            return cur;
         }
         else
         {
            throw new IndexOutOfBoundsException();
         }
      }
   }
   public String get(int index)
   {
      return getHelper(index, head);
   }
   private String getHelper(int index, RecursiveIONode cur)
   {
      if(cur instanceof RIOEmpty)
      {
         throw new UnsupportedOperationException();
      }
      else
      {
         if(cur instanceof RIONode && index == 0)
         {
            return (cur.getElement());
         }
         else
         {
            String s = getHelper(index - 1, cur.getNext());
            return s;
         }
      }
   }
   public int indexOf(String element)
   {
      return indexOfHelper(element, head);
   }
   private int indexOfHelper(String element, RecursiveIONode cur)
   {
      if(cur instanceof RIOEmpty)
      {
         throw new UnsupportedOperationException();
      }
      else
      {
         if(cur instanceof RIONode && cur.getElement().equals(element))
         {
            return 0;
         }
         else
         {
            int index = indexOfHelper(element, cur.getNext());
            index += 1;
            return index;
         }
      }
   }
   public int size()
   {
      return sizeHelper(head);
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
   public StringList toLowerCase()
   {
      StringList list = new RecursiveIOStringList();
      list = toLowerCaseHelper(head);
      return list;
   }
   private StringList toLowerCaseHelper(RecursiveIONode cur)
   {
      StringList list = new RecursiveIOStringList();
      if(cur instanceof RIOEmpty)
      {
         return new RecursiveIOStringList();
      }
      else
      {
         list = toLowerCaseHelper(cur.getNext());
         list.add(0, cur.getElement().toLowerCase());
         return list;
      }
   }  
   public StringList toUpperCase()
   {
      StringList list = new RecursiveIOStringList();
      list = toUpperCaseHelper(head);
      return list;
   }
   private StringList toUpperCaseHelper(RecursiveIONode cur)
   {
      if(cur instanceof RIOEmpty)
      {
         return new RecursiveIOStringList();
      }
      else
      {
         StringList list = new RecursiveIOStringList();
         list = toUpperCaseHelper(cur.getNext());
         list.add(0, cur.getElement().toUpperCase());
         return list;
      }
   }
   public StringList startsWith(String prefix)
   {
      StringList list = new RecursiveIOStringList();
      list = startsWithHelper(head, prefix);
      return list;
   }
   private StringList startsWithHelper(RecursiveIONode cur, String prefix)
   {
      if(cur instanceof RIOEmpty)
      {
         return new RecursiveIOStringList();
      }
      else
      {
         StringList list = new RecursiveIOStringList();
         list = startsWithHelper(cur.getNext(), prefix);
         if(cur.getElement().startsWith(prefix))
         {
            list.add(0, cur.getElement());
         }
         return list;
      }
   }
   public StringList hasSubstring(String substring)
   {
      StringList list = new RecursiveIOStringList();
      list = hasSubstringHelper(head, substring);
      return list;
   }
   private StringList hasSubstringHelper(RecursiveIONode cur, String substring)
   {
      if(cur instanceof RIOEmpty)
      {
         return new RecursiveIOStringList();
      }
      else
      {
         StringList list = new RecursiveIOStringList();
         list = hasSubstringHelper(cur.getNext(), substring);
         if(cur.getElement().contains(substring))
         {
            list.add(0, cur.getElement());
         }
         return list;
      }
   }
}