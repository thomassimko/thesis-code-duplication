public class ROONode
   implements RecursiveOONode
{
   private String str;
   private RecursiveOONode next;
   public ROONode(String str, RecursiveOONode next)
   {
      this.str = str;
      this.next = next;
   }
   public String getString()
   {
      return str;
   }
   public RecursiveOONode getNext()
   {
      return next;
   }
   public RecursiveOONode addToEnd(String element)
   {
      this.next = this.next.addToEnd(element);      
      return this;
   }
   public RecursiveOONode add(int index, String element)
   {
      if(index < 0)
      {
         throw new IndexOutOfBoundsException();
      }
      if(index == 0)
      {
         RecursiveOONode newNode = new ROONode(element, this);
         return(newNode);
      }
      else
      {
         return(this.next.add(index - 1, element));
      }
   }
   public RecursiveOONode remove (int index)
   {
      if(index < 0)
      {
         throw new IndexOutOfBoundsException();
      }
      if(index == 0)
      {
         return(this.next);
      }
      else
      {
         this.next = this.next.remove(index - 1);
      }
      return(this);
   }
   public String get(int index)
   {
      if(index < 0)
      {
         throw new IndexOutOfBoundsException();
      }
      if(index == 0)
      {
         return(this.getString());
      }
      else
      {
         return(this.next.get(index - 1));
      }
   }
   public int indexOf(String element)
   {
      if(this.getString().equals(element))
      {
         return(0);
      }
      else
      {
         return(1 + this.next.indexOf(element));
      }
   }
   public int size()
   {
      return(this.next.size() + 1);
   }
   public StringList toLowerCase()
   {
      String lower = this.getString().toLowerCase();
      StringList list = this.next.toLowerCase();      
      list.add(0, lower);
      return list;
   }
   public StringList toUpperCase()
   {
      String upper = this.getString().toUpperCase();
      StringList list = this.next.toUpperCase();
      list.add(0, upper);
      return list;
   }
   public StringList startsWith(String prefix)
   {
      String str = this.getString();
      StringList list = this.next.startsWith(prefix);
      if(str.startsWith(prefix))
      {
         list.add(0, str);
      }
      return list;
   }
   public StringList hasSubstring(String substring)
   {
      String str = this.getString();
      StringList list = this.next.hasSubstring(substring);
      if(str.indexOf(substring) != -1)
      {
         list.add(0, str);
      }
      return list;
   }
}
