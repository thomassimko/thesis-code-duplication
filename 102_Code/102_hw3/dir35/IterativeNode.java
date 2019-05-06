public class IterativeNode
{
   private String string;
   private IterativeNode next;

   public IterativeNode(String string, IterativeNode next)
   {
      this.string = string;
      this.next = next;
   }

   public void setNext(IterativeNode n)
   {
      this.next = n;
   }

   public IterativeNode getNext()
   {
      return this.next;
   }

   public String getString()
   {
      return this.string;
   }
}
