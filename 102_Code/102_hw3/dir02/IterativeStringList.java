import java.util.NoSuchElementException;
public class IterativeStringList
   implements StringList
{
   private IterativeNode head;
   public IterativeStringList()
   {
      head = new IterativeNode(null, null);
   }
   public void addToEnd(String element)
   {
      IterativeNode cur = head;
      boolean flag = true;
      while(flag)
      {
         if(cur.getNext() == null)
         {
            flag = false;
         }
         else
         {
            cur = cur.getNext();
         } 
      }
      IterativeNode newNode = new IterativeNode(element, cur.getNext());
      cur.changeNext(newNode);
   }
   public void add(int index, String element)
   {
      if(index > this.size() || index < 0)
      {
         throw new IndexOutOfBoundsException();
      }
      IterativeNode cur = head;
      for(int i = 0; i < index; i++)
      {
         cur = cur.getNext();
      }   
      IterativeNode newNode = new IterativeNode(element, cur.getNext());
      cur.changeNext(newNode);
   }
   public String remove(int index)
   {
      if(index > this.size() || index < 0)
      {
         throw new IndexOutOfBoundsException();
      }
      IterativeNode cur = head;
      for(int i = 0; i < index; i++)
      {
         cur = cur.getNext();
      }
      String returnStr = cur.getString();
      cur.changeNext(cur.getNext().getNext());
      return returnStr;
   }
   public String get(int index)
   {
      if(index > this.size() || index < 0)
      {
         throw new IndexOutOfBoundsException();
      }
      IterativeNode cur = head;
      cur = cur.getNext();
      for(int i = 0; i < index; i++)
      {
         cur = cur.getNext();
      }
      return(cur.getString());
   }
   public int indexOf(String element)
   {
      IterativeNode cur = head;
      boolean flag = true;
      int counter = 0;
      while(flag)
      {
         cur = cur.getNext();
         if(cur == null)
         {
            throw new NoSuchElementException();
         }
         if(cur.getString().equals(element))
         {
            flag = false;
            counter--;
         }
         counter++;
      }
      return(counter);
   }
   public int size()
   {
      IterativeNode cur = head;
      boolean flag = true;
      int sizeCount = 0;
      while(flag)
      {
         cur = cur.getNext();
         if(cur == null)
         {
            flag = false;
            sizeCount--;
         }
         sizeCount++;
      }
      return sizeCount;
   }
   public StringList toLowerCase()
   {
      IterativeStringList newList = new IterativeStringList();
      for(int i = 0; i < this.size(); i++)
      {
         newList.add(i, this.get(i).toLowerCase());
      }
      return newList;
   }
   public StringList toUpperCase()
   {
      IterativeStringList newList = new IterativeStringList();
      for(int i = 0; i < this.size(); i++)
      {
         newList.add(i, this.get(i).toUpperCase());
      }
      return newList;
   }
   public StringList startsWith(String prefix)
   {
      IterativeStringList newList = new IterativeStringList();
      int index = 0;
      for(int i = 0; i < this.size(); i++)
      {    
         if(this.get(i).startsWith(prefix))
         {
            newList.add(index, this.get(i));
            index++;
         }
      }
      return newList;
   }
   public StringList hasSubstring(String substring)
   {
      IterativeStringList newList = new IterativeStringList();
      int index = 0;
      for(int i = 0; i < this.size(); i++)
      {
         if(this.get(i).indexOf(substring) != -1)
         {
            newList.add(index, this.get(i));
            index++;
         } 
      }
      return newList;
   }

}
