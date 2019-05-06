import java.lang.String;
import java.util.NoSuchElementException;

public class ROONode
   implements RecursiveOONode
{
   private String string;
   private RecursiveOONode next;

   public String getString()
   {
      return this.string;
   }

   public RecursiveOONode getNext()
   {
      return this.next;
   }

   public void setNext(RecursiveOONode n)
   {
      this.next = n;
   }

   public ROONode(String string, RecursiveOONode next)
   {
      this.string = string;
      this.next = next;
   }

   public ROONode addToEnd(String element)
   {
      this.next = this.next.addToEnd(element);
      return this;
   }

   public ROONode add(int index, String element)
   {
      if (index != 0)
      {
         this.next = this.next.add(index-1, element);
         return this;
      }
      else
      {
         ROONode newNode = new ROONode(element, this);
         return newNode;
      }
   }

   public RecursiveOONode remove(int index)
   {
      if (index < 0)
      {
         throw new IndexOutOfBoundsException();
      }
      else if (index == 0)
      {
         return this.next;
      }
      else
      {
         this.next = this.next.remove(index-1);
         return this;
      }
   }

   public String get(int index)
   {
      if (index < 0)
      {
         throw new IndexOutOfBoundsException();
      }
      else if (index != 0)
      {
         return this.next.get(index-1);
      }
      else
      {
         return this.string;
      }
   }

   public int indexOf(String element)
   {
      if(this.getString().equals(element))
      {
         return 0;
      }
      else
      {
         if (this.next.indexOf(element) == -1)
         {
            throw new NoSuchElementException();
         }

         return 1 + this.next.indexOf(element);
      }
   }

   public int size()
   {
      return 1 + this.next.size();
   }

   public StringList toLowerCase()
   {
      StringList newList = this.next.toLowerCase();

      newList.add(0, this.string.toLowerCase());

      return newList;
   }

   public StringList toUpperCase()
   {
      StringList newList = this.next.toUpperCase();

      newList.add(0, this.string.toUpperCase());

      return newList;
   }

   public StringList startsWith(String prefix)
   {
      StringList newList = this.next.startsWith(prefix);

      if (this.string.startsWith(prefix))
      {
         newList.add(0, this.string);
      }

      return newList;
   }

   public StringList hasSubstring(String substring)
   {
      StringList newList = this.next.hasSubstring(substring);

      if (this.string.contains(substring))
      {
         newList.add(0, this.string);
      }

      return newList;
   }
}
