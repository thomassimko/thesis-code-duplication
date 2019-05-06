public class IterativeNode
{
   private String s;
   private IterativeNode next;
   public IterativeNode(String s, IterativeNode next)
   {
      this.s=s;
      this.next=next;
   }
   public String getString()
   {
      return this.s;
   }
   public IterativeNode getNext()
   {
      return this.next;
   }
   public void setNext(IterativeNode next)
   {
      this.next=next;
   }
}