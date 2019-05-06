public class RIONode
   implements RecursiveIONode
{
   private String stringypoo;
   private RecursiveIONode next;

   public RecursiveIONode getNext()
   {
      return this.next();
   }   
   
   public String getString()
   {
      return this.string;
   }

   public void setNext(RecursionIONode node)
   {
      this.next = node;
   }
}
