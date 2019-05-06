
public class ROONode 
   implements RecursiveOONode 
{
   private String element;
   private RecursiveOONode next;

   public ROONode(String element, RecursiveOONode next)
   {
      this.element = element;
      this.next = next;
   }

   public String getElement(int index)
   {
      return element;
   }

   public RecursiveOONode getNext()
   {
      return next;
   }
 
   public void setNext(RecursiveOONode node)
   {
      throw new UnsupportedOperationException();
   }

   public RecursiveOONode addToEnd(String element)
   {
      next = next.addToEnd(element);
      return this;
   }

   public RecursiveOONode add(int index, String element)
   {
      if(index == 0)
      {
         RecursiveOONode n = new ROONode(element, this);
         return n;
      }
      else
      {
         next = next.add(index-1, element);
         return this;
      }
   }
   
   public RecursiveOONode remove(int index)
   {
      if(index == 0)
      {
         return this.next;
      }
      else
      {
         RecursiveOONode n = next.remove(index-1);
         this.next = n;
         return this;
      }
   }

   public String get(int index)
   {
      if(index == 0)
      {
         return element;
      }
      else
      {
         return next.get(index-1);
      }
   }

   public int indexOf(String element)
   {
      if(this.element.equals(element))
      {
         return 0;
      }
      else
      {
         return 1 + next.indexOf(element);
      }
   }

   public int size()
   {
      return 1 + next.size();
   }
   
   public StringList toLowerCase()
   {
      StringList newList;
      newList = next.toLowerCase();
      newList.add(0, element.toLowerCase());
      return newList;
   }

   public StringList toUpperCase()
   {
      StringList newList;
      newList = next.toUpperCase();
      newList.add(0, element.toUpperCase());
      return newList;
   }

   public StringList startsWith(String prefix)
   {
      StringList newList;
      newList = next.startsWith(prefix);
      if(element.startsWith(prefix))
      {
         newList.add(0, element);
      }
      return newList;
   }

   public StringList hasSubstring(String substring)
   {
      StringList newList;
      newList = next.hasSubstring(substring);
      if(element.contains(substring))
      {
         newList.add(0, element);
      }
      return newList;
   }
}
