public class IterativeNode
{
   private String word;
   private IterativeNode next;
   
   public IterativeNode(String word, IterativeNode next)
   {
      this.word = word;
      this.next = next;
   }
   
   public String getString()
   {
      return this.word;
   }
   
   public IterativeNode getNext()
   {
      return this.next;
   }
   
   public void setNext(IterativeNode x)
   {
      this.next = x;
   }
}