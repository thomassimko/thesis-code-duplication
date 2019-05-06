public class ROONode
   implements RecursiveOONode
{
   private String string;
   private RecursiveOONode next;
   
   public ROONode(String element, Node node)
   {
      this.string = element;
      this.next = node;
   }
   
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
   
   public RecursiveOONode addToEnd(String element)
   {
      RecursiveOONode n = next.addToEnd(element);
      next = n;
      return this;
   }

   public RecursiveOONode add(int index, int count, String element)
   {
      if(index != count - 1)
      {
         next = next.add(count + 1, element);
      }
      next = new RecursiveNode(element, getNext());
   }

   public void remove(int index, int count)
   {
      if(index < 0)
      {
         throw new IndexOutOfBoundsException();
      }
      else if(index != count - 1)
      {
         next = next.remove(index, count + 1);
      }
      next = next.next;
   }

   public String get(int index, int count)
   {
      if(index != count)
      {
         next = next.get(index, count + 1);
      }
      return head.getString();
   }

   public int indexOf(String element, int index)
   {
      if(!getString().equals(element))
      {
         next.indexOf(element, index + 1);
      }
      return index;
   }

   public int size()
   {
      int s = 0;
      s = 1 + this.next.size();
      return s;
   }

   public StringList toLowerCase()
   {
      list.addToEnd().next.toLowerCase();
      return list;
   }

   public StringList toUpperCase()
   {
      list.addToEnd(next.toUpperCase());
      return list;
   }

   public StringList startsWith(String prefix)
   {
      if(getString().equals(prefix))
      {
         list.addToEnd(next.getString())
      }
      else
      {
         return list;
      }
      return list;
   }

   public StringList hasSubstring(String substring)
   {
      
   }
}
