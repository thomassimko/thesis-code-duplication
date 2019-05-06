public class IterativeNode
{
   private String val;
   private IterativeNode next;
   
   public IterativeNode(String val, IterativeNode next)
   {
      this.val=val;
      this.next=next;
   }
   
   public int getValue()
   {
      return this.val;
   }
   
   public IterativeNode getNext()
   {
      return this.next;
   }
   
   public void setNext(IterativeNode n)
   {
      this.next=n;
   }
}
   
