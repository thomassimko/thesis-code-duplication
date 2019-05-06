public class RIONode
   implements RecursiveIONode
{
   private RecursiveIONode next;
   private String s;
   public RIONode(String s, RecursiveIONode next)
   {
      this.s=s;
      this.next=next;
   }
   public String getString()
   {
      return this.s;
   }
   public RecursiveIONode getNext()
   {
      return this.next;
   }
   public void setNext(RecursiveIONode next)
   {
      this.next=next;
   }
}