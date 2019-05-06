public class RIONode
   implements RecursiveIONode
{
   private String string;
   private RecursiveIONode next;

   public String getString()
   {
      return this.string;
   }

   public RIONode(String string, RecursiveIONode next)
   {
      this.string = string;
      this.next = next;
   }

   public RecursiveIONode getNext()
   {
      return this.next;
   }

   public void setNext(RecursiveIONode n)
   {
      this.next = n;
   }
}
