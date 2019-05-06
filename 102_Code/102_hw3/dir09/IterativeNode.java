public class IterativeNode
{
   private String string;
   private IterativeNode next;

   public IterativeNode(String string, IterativeNode next)
   {
      this.string = string;
      this.next = next;
   }

   public String getString()
   {
      return string;
   }

   public IterativeNode getNext()
   {
      return next;
   }

   public void setNext(IterativeNode n)
   {
      this.next = n;
   }
}

