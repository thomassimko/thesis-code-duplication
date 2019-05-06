public class IterativeNode
{
   private String strName;
   private IterativeNode next;
   public IterativeNode(String strName, IterativeNode next)
   {
      this.strName = strName;
      this.next = next;
   }
   public String getString()
   {
      return strName;
   }
   public IterativeNode getNext()
   {
      return next;
   }
   public void changeNext(IterativeNode newNext)
   {
      this.next = newNext;
   }
}
