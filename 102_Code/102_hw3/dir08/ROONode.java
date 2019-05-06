public class ROONode
   implements RecursiveOONode
{
   private String string;
   private RecursiveOONode next;

   public ROONode(String s, RecursiveOONode n)
   {
      this.string = s;
      this.next = n;
   }

   public String toString()
   {
      return this.string;
   }

   public RecursiveOONode next()
   {
      return this.next;
   }

   public RecursiveOONode addToEnd(String element)
   {
      this.next = this.next.addToEnd(element);
      return this; 
   }

   public RecursiveOONode add(int index, String element)
   {
      if (index == 0)
      {
         ROONode n = new ROONode(element, this);
         return n;
      }
      else
      {
         this.next = this.next.add(index - 1, element);
         return this;
      }
   }

   public RecursiveOONode remove(int index, StringObj s)
   {
      if (index == 0)
      {
         s.setString(this.string);
         return this.next; 
      }
      else
      {
         this.next = this.next.remove(index - 1, s);
         return this;
      }
   }

   public String get(int index)
   {
      if (index == 0)
      {
         return this.toString();
      }
      else
      {
         return this.next.get(index - 1);
      }
   }

   public int indexOf(int c, String element)
   {
      if (this.string.equals(element))
      {
         return c;
      }
      else
      {
         return this.next.indexOf(c + 1, element);
      }
   }

   public int size()
   {
      return 1 + this.next.size();
   }

   public StringList toLowerCase()
   {
      StringList list = this.next.toLowerCase();
      ((RecursiveOOStringList)list).addToFront(this.string.toLowerCase());
      return list;
   }

   public StringList toUpperCase()
   {
      StringList list = this.next.toUpperCase();
      ((RecursiveOOStringList)list).addToFront(this.string.toUpperCase());
      return list;
   }

   public StringList startsWith(String prefix)
   {
      StringList list = this.next.startsWith(prefix);
      if (this.string.startsWith(prefix))
      {
         ((RecursiveOOStringList)list).addToFront(this.string);
      }
      return list;
   }

   public StringList hasSubstring(String substring)
   {
      StringList list = this.next.hasSubstring(substring);
      if (this.string.contains(substring))
      {
         ((RecursiveOOStringList)list).addToFront(this.string);
      }
      return list;
   }
}
