public class IterativeNode
{
   private String s;
   private IterativeNode next;
 
   public IterativeNode(String s, IterativeNode next)
   {
      this.s = s;
      this.next = next;
   }

   public String getString()
   {
      return s;
   }

   public IterativeNode getNext()
   {
      return next;
   }

   public void setNext(IterativeNode node)
   {
      this.next = node;
   }
   
}
