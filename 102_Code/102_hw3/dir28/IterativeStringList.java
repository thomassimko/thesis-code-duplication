import java.util.NoSuchElementException;

public class IterativeStringList
   implements StringList
{
   private IterativeNode head;
   public IterativeStringList()
   {
      this.head=null;
   }
   public void add(int index, String element)
   {
      if(this.head == null)
      {
         if(index == 0)
         {
            this.head = new IterativeNode(element, null);
         }
         else
         {
            throw new IndexOutOfBoundsException();
         }
      }
      else
      {
         if(index == 0)
         {
            this.head = new IterativeNode(element, this.head.getNext());
         }
         else if(index < 0)
         {
            throw new IndexOutOfBoundsException();
         }
         else
         {
            IterativeNode cur = this.head;
            for(int i = 0; i < index-1 && cur != null; i++)
            {
               cur = cur.getNext();
            }
            if(cur == null)
            {
               throw new IndexOutOfBoundsException();
            }
            else
            {
               IterativeNode n = new IterativeNode(element, cur.getNext());
               cur.setNext(n);
            }
         }
      }
   }
   public void addToEnd(String element)
   {
      IterativeNode n = new IterativeNode(element, null);
      if(this.head == null)
      {
         this.head = n;
      }
      else
      {
         IterativeNode cur = this.head;
         while(cur.getNext() != null)
         {
            cur = cur.getNext();
         }
         cur.setNext(n);
      }
   }
   public String get(int index)
   {
      IterativeNode cur = this.head;
      for(int i = 0; i < index; i++)
      {
         cur = cur.getNext();
      }
      if(cur == null)
      {
         throw new IndexOutOfBoundsException();
      }
      return cur.getString();
   }
   public StringList hasSubstring(String substring)
   {
      StringList substringList = new IterativeStringList();
      int size = this.size();
      for(int i = 0; i < size; i++)
      {
         if(this.get(i).contains(substring))
         {
            substringList.addToEnd(this.get(i));
         }
      }
      return substringList;
   }
   public int indexOf(String element)
   {
      IterativeNode cur = this.head;
      int index = -1;
      for(int i = 0; i < this.size(); i++)
      {
         if(element.equals(cur.getString()))
         {
            index = i;
         }
         cur = cur.getNext();
      }
      if(index == -1)
      {
         throw new NoSuchElementException();
      }
      return index;
   }
   public void remove(int index)
   {
      IterativeNode cur = this.head;
      if(index >= this.size())
      {
         throw new IndexOutOfBoundsException();
      }
      if(index == 0)
      {
         this.head = this.head.getNext();
      }
      for(int i = 0; i < index-1 && cur != null; i++)
      {
         cur=cur.getNext();
      }
      if(cur == null)
      {
         throw new IndexOutOfBoundsException();
      }
      cur.setNext(cur.getNext().getNext());
   }
   public int size()
   {
      int counter = 0;
      IterativeNode cur = this.head;
      while(cur != null)
      {
         cur = cur.getNext();
         counter=counter+1;
      }
      return counter;
   }
   public StringList startsWith(String prefix)
   {
      StringList startsWith = new IterativeStringList();
      int size = this.size();
      for(int i = 0; i < size; i++)
      {
         if(this.get(i).startsWith(prefix))
         {
            startsWith.addToEnd(this.get(i));
         }
      }
      return startsWith;
   }
   public StringList toLowerCase()
   {
      StringList lower = new IterativeStringList();
      String newString;
      int size = this.size();
      for(int i = 0; i < size; i++)
      {
         newString = this.get(i);
         newString = newString.toLowerCase();
         lower.addToEnd(newString);
      }
      return lower;
   }
   public StringList toUpperCase()
   {
      StringList upper = new IterativeStringList();
      String newString;
      int size = this.size();
      for(int i = 0; i < size; i++)
      {
         newString = this.get(i);
         newString = newString.toUpperCase();
         upper.addToEnd(newString);
      }
      return upper;
   }
}