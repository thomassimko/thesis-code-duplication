public class RIONode implements RecursiveIONode
{
   private String element;
   private RecursiveIONode next;
   
   public RIONode(String element, RecursiveIONode next)
   {
      this.element = element;
      this.next = next;
   }
   public String getElement()
   {
      return this.element;
   }
   public RecursiveIONode getNext()
   {
      return this.next;
   }
   public void setNext(RecursiveIONode n)
   {
      this.next = n;
   }
}