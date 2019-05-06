import java.lang.String;
import java.lang.IndexOutOfBoundsException;
import java.util.NoSuchElementException;

public class IterativeStringList
   implements StringList
{
   private IterativeNode node;

   public IterativeStringList()
   {
      this.node = null;
   }

   /**
      Adds the specified String to the end of the list.
      @param element String to add to list.
   */
   public void addToEnd(String element)
   {
      IterativeNode n = new IterativeNode(element, null);

      if (this.node == null)
      {
         this.node = n;
      }
      else
      {
         IterativeNode cur = this.node;

         while (cur.getNext() != null)
         {
            cur = cur.getNext();
         }

         cur.setNext(n);
      }
   }

   /**
      Adds the specified String at index position in the list.
      The element previously at that position is now after this new element.
      @param index Position at which to add the element.
      @param element String to add to list.
   */
   public void add(int index, String element)
   {
      if (this.node == null)
      {
         if (index == 0)
         {
            this.node = new IterativeNode(element, null);
         }
         else
         {
            throw new IndexOutOfBoundsException();
         }
      }
      else
      {
         if (index == 0)
         {
            this.node.setNext(new IterativeNode(element, this.node));
         }
         else if (index < 0)
         {
            throw new IndexOutOfBoundsException();
         }
         else
         {
            IterativeNode cur = this.node;
            int i;

            for (i = 1; i < index && cur != null; i++)
            {
               cur = cur.getNext();
            }

            if (cur == null && i != index)
            {
               throw new IndexOutOfBoundsException();
            }
            else
            {
               cur.setNext(new IterativeNode(element, cur.getNext()));
            }
         }
      }
   }

   /**
      Removes the element at position index. Returns the element that
      was removed.
      @param index Position of element to remove.
      @return String removed from list.
   */
   public void remove(int index)
   {
      if (this.node == null || index < 0)
      {
         throw new IndexOutOfBoundsException();
      }
      else if (index == 0)
      {
         String string = this.node.getString();
         this.node = this.node.getNext();
      }
      else
      {
         IterativeNode cur = this.node;

         for (int i = 1; i < index && cur != null; i++)
         {
            cur = cur.getNext();
         }

         if (cur == null || cur.getNext() == null)
         {
            throw new IndexOutOfBoundsException();
         }
         else
         {
            String string = cur.getNext().getString();
            cur.setNext(cur.getNext().getNext());
         }
      }
   }

   /**
      Returns the element at position index.
      @param index Position from which to retrieve String.
      @return String at index position in list.
   */
   public String get(int index)
   {
      int curIndex = 0;
      IterativeNode cur = this.node;

      if (this.node == null || index < 0)
      {
         throw new IndexOutOfBoundsException();
      }
      else
      {
         while (cur != null && curIndex < index)
         {
            cur = cur.getNext();
            curIndex++;
         }

         if (cur == null)
         {
            throw new IndexOutOfBoundsException();
         }
         else
         {
            return cur.getString();
         }
      }
   }

   /**
      Returns the index at which the element appears in the list.
      @param element Value to search for.
      @return Position of element.
   */
   public int indexOf(String element)
   {
      IterativeNode cur = this.node;
      int index = 0;

      if (cur == null)
      {
         throw new NoSuchElementException();
      }
      else
      {
         while (cur != null && !element.equals(cur.getString()))
         {
            cur = cur.getNext();
            index++;
         }
      }

      if (cur != null)
      {
         return index;
      }

      return -1;
   }

   /**
      Number of elements in the list.
      @return Number of elements in the list.
   */
   public int size()
   {
      IterativeNode cur = this.node;
      int count = 0;

      while (cur != null)
      {
         cur = cur.getNext();
         count++;
      }

      return count;
   }

   /**
      Returns a newly constructed list (in the same order) with the strings
      from the original list converted to lowercase. Does not modify original
      list.
      @return Lowercase copy of the list.
   */
   public StringList toLowerCase()
   {
      IterativeNode cur = this.node;
      StringList newList = new IterativeStringList();

      while (cur != null)
      {
         newList.addToEnd(cur.getString().toLowerCase());
         cur = cur.getNext();
      }

      return newList;
   }

   /**
      Returns a newly constructed list (in the same order) with the strings
      from the original list converted to uppercase. Does not modify original
      list.
      @return Uppercase copy of the list.
   */
   public StringList toUpperCase()
   {
      IterativeNode cur = this.node;
      StringList newList = new IterativeStringList();

      while (cur != null)
      {
         newList.addToEnd(cur.getString().toUpperCase());
         cur = cur.getNext();
      }

      return newList;
   }

   /**
      Returns a newly constructed list (in the same order) containing
      strings from the original list that begin with the specified
      prefix.  Does not modify original list.
      @return New list with strings containing prefix.
   */
   public StringList startsWith(String prefix)
   {
      IterativeNode cur = this.node;
      StringList newList = new IterativeStringList();

      while (cur != null)
      {
         if (cur.getString().startsWith(prefix))
         {
            newList.addToEnd(cur.getString().toUpperCase());
         }
         cur = cur.getNext();
      }

      return newList;
   }


   /**
      Returns a newly constructed list (in the same order) containing
      strings from the original list that contains the specified substring.
      Does not modify original list.
      @return New list with strings containing substring.
   */
   public StringList hasSubstring(String substring)
   {
      IterativeNode cur = this.node;
      StringList newList = new IterativeStringList();

      while (cur != null)
      {
         if (cur.getString().contains(substring))
         {
            newList.addToEnd(cur.getString());
         }

         cur = cur.getNext();
      }

      return newList;
   }

}
