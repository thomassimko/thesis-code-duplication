public class RIONode
   implements RecursiveIONode
{
   private String str;
   public RecursiveIONode next;
   public RIONode(String str, RecursiveIONode next)
   {
      this.str = str;
      this.next = next;
   }
   public String getString()
   {
      return this.str;
   }
   public RecursiveIONode getNext()
   {
      return this.next;
   }
}
