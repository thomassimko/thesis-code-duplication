import java.*;

public class RecursiveIOStringList
   implements StringList
{
   private RecursiveIONode head;

   public RecursiveIOStringList()
   {
      this.head = new ROIEmpty();
   }

   public void add(int index, String element)
   {
      head = head.addHelper(index, element);
   }
 
   public void addHelper(int index, String element, RecursiveIONode cur)
   {
      if(cur instanceof RIONode)
      {
         head = head.add(index, element);
           
         //OO stuff
      }
      else
      {
         RecursiveOONode node = new ROONode(element, this);
         if(index != 0)
         {
            throw new IndexOutOfBoundsException();
         }
         
          //empty stuff
      }
   }
   
   public void addToEnd(String element)
   {
      head = head.addToEnd(element);
   }

   public void addToEndHelper(String element, RecursiveIONode cur)
   {
      if(cur instanceof RIONode)
      {
         head = head.addToEnd(element);
      }
      else
      {
         throw new UnsupportedOperationException();
      }
   }
      
   public void remove(int index)
   {
      head = head.remove(index);
   }

   public void removeHelper(int index)
   {
      if(cur instanceof RIONode)
      {
         head = head.remove();
      }
      else
      {
         throw new UnsupportedOperationException();
      }
   }

   public String get(int index)
   {
      return head.get(index).getString();
   }

   public String getHelper(int index)
   {
      if(cur instanceof RIONode)
      {
         head = head.get(index);
      }
      else
      {
         throw new UnsupportedOperationException();
      }
   }

   public RecursiveIONode getNext()
   {
      return head.getNext();
   }
   public int indexOf(String element)
   {
      return head.indexOf(element);
   }
   public int size()
   {
      return head.size();
   }
   public StringList toLowerCase()
   {
      return head.toLowerCase();
   }
   public StringList toUpperCase()
   {
      return head.toUpperCase();
   }
   public StringList startsWith(String prefix)
   {
      return head.startsWith(prefix);
   }
   public StringList hasSubstring(String substring)
   {
      return head.hasSubstring(substring);
   }
}
