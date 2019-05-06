import java.*;
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

   public RecursiveOONode getNext()
   {
      return this.next;
   }
 
   public String getString()
   {
      return this.element;
   }

   public RecursiveOONode addToEnd(String element)
   {
      next = next.addToEnd(element);
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
         RecursiveOONode n = new ROONode(element, this);
         return n;
      }
      else
      {
         next = next.add(index - 1, element);
         return this;
      }
   }

   public RecursiveOONode remove(int index)
   {
      int windex = index - 1;
      if(index < 0)
      {
         throw new IndexOutOfBoundsException();
      }
      if(index == 0)
      {
         return this.next;
      }
      else
      {
         next = next.remove(windex);
         return this;
      }
   }
      
   public RecursiveOONode get(int index)
   {
      if(index < 0)
      {
         throw new IndexOutOfBoundsException();
      }
      if(index == 0)
      {
         return this;
      }
      return next.get(index - 1);
   }

   public int indexOf(String element)
   {
      if(this.element.equals(element))
      {
         return 0;
      }
      return 1 + next.indexOf(element);
   }

   public int size()
   {
      return 1 + next.size();
   }
   
   public StringList toLowerCase()
   {
      StringList stringy = next.toLowerCase();
      stringy.add(0, this.element.toLowerCase());
      return stringy;
   }

   public StringList toUpperCase()
   { 
      StringList stringy = next.toUpperCase();
      stringy.add(0, this.element.toUpperCase());
      return stringy;
   }

   public StringList startsWith(String prefix)
   {
      StringList stringy = next.startsWith(prefix);
      if(this.element.startsWith(prefix))
      {
         stringy.add(0, this.element);
      }
      return stringy;
   }
  
   public StringList hasSubstring(String substring)
   {
      StringList stringy = next.hasSubstring(substring);
      if(this.element.contains(substring))
      {
         stringy.add(0, this.element);
      }
      return stringy;
   }
}
