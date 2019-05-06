public class ROONode 
   implements RecursiveOONode
{
   private String string;
   private RecursiveOONode next;
   
   public ROONode(String string, RecursiveOONode next)
   {
      this.string = string;
      this.next = next;
   }
   
   public ROONode addToEnd(String string)
   {
      RecursiveOONode n = next.addToEnd(string);
      next = n;
      return this;
   }
   
   public RecursiveOONode add(int index, String string)
   {
      if (index == 0) 
      {
         RecursiveOONode n = new ROONode(string, this);
         return n;
      }
      else 
      {
         next = next.add(index-1, string);
      }
      return this;
   }
   
   public String remove(int index)
   {
	   if(index == 1)
	   {
		   String tmp = this.next.getValue();
		   this.next = this.next.getNext();
		   return tmp;
	   }
	   else
	   {
		   return this.next.remove(index-1);
	   }
   }
   
   public String get(int index)
   {
	   if(index == 0)
	   {
		   return this.string;
	   }
	   else
	   {
		   return this.next.get(index-1);
	   }
   }


   public int indexOf(String element) 
   {
	   if(this.string.equals(element))
	   {
		   return 0;
	   }
	   return 1+this.next.indexOf(element);
   }


   public int size() 
   {
	   if(this == null)
	   {
		   return 0;
	   }
	   else
	   {
		   return 1 + this.next.size();
	   }
   }
   
   public RecursiveOOStringList toLowerCase() 
   {
	   RecursiveOOStringList newList =  this.next.toLowerCase();
	   newList.add(0,this.string.toLowerCase());
	   return newList;
   }


   public RecursiveOOStringList toUpperCase() 
   {
	   RecursiveOOStringList newList =  this.next.toUpperCase();
	   newList.add(0,this.string.toUpperCase());
	   return newList;
   }

   public RecursiveOOStringList startsWith(String prefix) 
   {
	   if(this.string.startsWith(prefix))
	   {
	       RecursiveOOStringList newList = this.next.startsWith(prefix);
	       newList.add(0,this.string);
	       return newList;
	   }
	   else
	   {
		   return this.next.startsWith(prefix);
	   }
   }

   @Override
   public RecursiveOOStringList hasSubstring(String substring) 
   {
	   if(this.string.contains(substring))
	   {
		   RecursiveOOStringList newList = this.next.hasSubstring(substring);
	       newList.add(0,this.string);
	       return newList;
	   }
	   else
	   {
		   return this.next.hasSubstring(substring);
	   }
   }

   public String getValue() 
   {
	   return this.string;
   }
   
   public RecursiveOONode getNext()
   {
	   return this.next;
   }
   
   public RecursiveOONode setNext(RecursiveOONode n) 
   {
	   this.next = n;
	   return n;
   }
}