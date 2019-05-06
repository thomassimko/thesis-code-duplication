public class IterativeNode
{
   private String element;
   private IterativeNode next;

   public IterativeNode(String element,IterativeNode next)
   {
      this.element = element;
      this.next = next;
   }

   public String getElement()
   {
      return element;
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
