public class RecursiveIOStringList
   implements StringList
{
   private RecursiveIONode head;
   public RecursiveIOStringList()
   {
      this.head = new RIOEmpty();
   }
   public void addToEnd(String element)
   {
      head = addToEndHelper(element, head);
   } 
   private RecursiveIONode addToEndHelper(String str, RecursiveIONode node)
   {
      if(node instanceof RIOEmpty)
      {
         RecursiveIONode newNode = new RIONode(str, node);
         return newNode;
      }
      else
      {
         RecursiveIONode newNode = (addToEndHelper(str,((RIONode)node).getNext()));
         ((RIONode)node).next = newNode;
         return node;
      }
   }
   public void add(int index, String element)
   {
      head = addHelper(index, element, head);
   }
   private RecursiveIONode addHelper(int index, String str, RecursiveIONode node)
   {
      if(index == 0 && node instanceof RIOEmpty)
      {
         RecursiveIONode newNode = new RIONode(str, node);
         return newNode;
      }
      else if(node instanceof RIONode)
      {
         if(index == 0)
         {
            RecursiveIONode newNode = new RIONode(str, node);
            return newNode;
         }
         else
         {
            RecursiveIONode newNode= addHelper(index - 1, str, ((RIONode)node).getNext());
            ((RIONode)node).next = newNode;
            return newNode;
         }
      }
      else
      {
         throw new IndexOutOfBoundsException();
      }
   }
   public String remove(int index)
   {
      String returnString = this.get(index);
      this.head = removeHelper(index, head);      
      return(returnString);
   }
   private RecursiveIONode removeHelper(int index, RecursiveIONode node)
   {
      if(node instanceof RIOEmpty)
      {
         throw new IndexOutOfBoundsException();
      }
      else if(node instanceof RIONode)
      {
         if(index == 0)
         {
            return ((RIONode)node).getNext();
         }
         else
         {
            return removeHelper(index - 1, ((RIONode)node).getNext());
         }   
      }
      else
      {
         throw new IndexOutOfBoundsException();
      }
   }
   public String get(int index)
   {
      return ((RIONode)getHelper(index, head)).getString();  
   }
   private RecursiveIONode getHelper(int index, RecursiveIONode node)
   {
      if(node instanceof RIOEmpty)
      {
         throw new IndexOutOfBoundsException();
      }
      else if(node instanceof RIONode)
      {
         if(index == 0)
         {
            return node;
         }
         else
         {
            return getHelper(index - 1, ((RIONode)node).getNext());
         }
      }
      else
      {
         throw new IndexOutOfBoundsException();
      }
   }
   public int indexOf(String element)
   {
      return indexOfHelper(element, head);
   }
   private int indexOfHelper(String element, RecursiveIONode node)
   {
      int index = 0;
      if(node instanceof RIONode)
      {
         if(((RIONode)node).getString().equals(element))
         {
            return index;
         }
         else
         {
            return (indexOfHelper(element, ((RIONode)node).getNext()) + 1);
         }
      }
      else if(node instanceof RIOEmpty)
      {
         throw new IndexOutOfBoundsException();
      }
      else
      {
         throw new IndexOutOfBoundsException(); 
      }
   }
   public int size()
   {
      return sizeHelper(this.head);
   }
   private int sizeHelper(RecursiveIONode node)
   {
      int index = 0;
      if(node instanceof RIONode)
      {
         return (sizeHelper(((RIONode)node).getNext()) + 1);
      }
      else if(node instanceof RIOEmpty)
      {
         return index;
      }
      return(index);
   }
   public StringList toLowerCase()
   {
      return toLowerCaseHelper(this.head);
   }
   private StringList toLowerCaseHelper(RecursiveIONode node)
   {
      if(node instanceof RIONode)
      {
         String str = ((RIONode)node).getString().toLowerCase();   
         StringList list = toLowerCaseHelper(((RIONode)node).getNext());
         list.add(0, str);
         return list;
      }
      else
      {
         StringList newList = new RecursiveIOStringList();
         return newList;   
      }
   }
   public StringList toUpperCase()
   {
      return toUpperCaseHelper(this.head);
   }
   private StringList toUpperCaseHelper(RecursiveIONode node)
   {
      if(node instanceof RIONode)
      {
         String str = ((RIONode)node).getString().toUpperCase();
         StringList list = toUpperCaseHelper(((RIONode)node).getNext());
         list.add(0, str);
         return list;
      }
      else
      {
         StringList newList = new RecursiveIOStringList();
         return newList;
      }
   }
   public StringList startsWith(String prefix)
   {
      return startsWithHelper(prefix, this.head);
   }
   private StringList startsWithHelper(String prefix, RecursiveIONode node)
   {
      if(node instanceof RIONode)
      {
         String str = ((RIONode)node).getString();
         StringList list = startsWithHelper(prefix, ((RIONode)node).getNext());
         if(str.startsWith(prefix))
         {
            list.add(0, str);
         }
         return list;
      }
      else
      {
         StringList newList = new RecursiveIOStringList();
         return newList;
      }
   }
   public StringList hasSubstring(String substring)
   {
      return hasSubstringHelper(substring, this.head);
   }
   private StringList hasSubstringHelper(String substring, RecursiveIONode node)
   {
      if(node instanceof RIONode)
      {
         String str = ((RIONode)node).getString();
         StringList list = hasSubstringHelper(substring, ((RIONode)node).getNext());
         if(str.indexOf(substring) != -1)
         {
            list.add(0, str);
         }
         return list;
      }
      else
      {
         StringList newList = new RecursiveIOStringList();
         return newList;
      }
   }
}
