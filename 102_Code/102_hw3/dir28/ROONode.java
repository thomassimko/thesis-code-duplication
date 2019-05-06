public class ROONode
   implements RecursiveOONode
{
   private String s;
   private RecursiveOONode next;
   public ROONode(String s, RecursiveOONode next)
   {
      this.s=s;
      this.next=next;
   }
   public String getString()
   {
      return this.s;
   }
   public RecursiveOONode getNext()
   {
      return this.next;
   }
   public void setNext(RecursiveOONode next)
   {
      this.next=next;
   }
   public RecursiveOONode addToEnd(String element)
   {
      this.next=this.next.addToEnd(element);
      return this;
   }
   public RecursiveOONode add(int index, String element)
   {
      if(index == 0)
      {
         RecursiveOONode n = new ROONode(element, this);
         return n;
      }
      this.next=this.next.add(index-1, element);
      return this;
   }
   public RecursiveOONode remove(int index)
   {
      if(index < 0)
      {
         throw new IndexOutOfBoundsException();
      }
      else if(index == 0)
      {
         return this.next;
      }
      else
      {
         this.next = this.next.remove(index-1);
         return this;
      }
   }
   public RecursiveOONode get(int index)
   {
      if(index < 0)
      {
         throw new IndexOutOfBoundsException();
      }
      else if(index == 0)
      {
         return this;
      }
      else
      {
         return this.next.get(index-1);
      }
   }
   public int indexOf(String element)
   {
      if(this.s.equals(element))
      {
         return 0;
      }
      return 1 + this.next.indexOf(element);
   }
   public int size()
   {
      return 1 + this.next.size();
   }
   public StringList toLowerCase()
   {
      StringList l = next.toLowerCase();
      l.add(0, this.s.toLowerCase());
      return l;
   }
   public StringList toUpperCase()
   {
      StringList l = next.toUpperCase();
      l.add(0, this.s.toUpperCase());
      return l;
   }
   public StringList startsWith(String prefix)
   {
      StringList l = this.next.startsWith(prefix);
      if(this.s.startsWith(prefix))
      {
         l.add(0, this.s);
      }
      return l;
   }
   public StringList hasSubstring(String substring)
   {
      StringList l = this.next.hasSubstring(substring);
      if(this.s.contains(substring))
      {
         l.add(0, this.s);
      }
      return l;
   }
}