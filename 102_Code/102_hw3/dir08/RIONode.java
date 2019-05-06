public class RIONode
   implements RecursiveIONode
{
   private String string;
   private RecursiveIONode next;

   public RIONode(String s, RecursiveIONode n)
   {
      this.string = s;
      this.next = n;
   }

   public String toString()
   {
      return this.string;
   }

   public RecursiveIONode next()
   {
      return this.next;
   }

   public void setNext(RecursiveIONode n)
   {
      this.next = n;
   } 
} 
