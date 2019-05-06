public class IterativeNode
{
   private String string;
   private IterativeNode next;

   public IterativeNode(String s, IterativeNode n)
   {
      this.string = s;
      this.next = n;
   }

   public String toString()
   {
      return this.string;
   }

   public IterativeNode next()
   {
      return this.next;
   }

   public void setNext(IterativeNode n)
   {
      this.next = n;
   }
}
