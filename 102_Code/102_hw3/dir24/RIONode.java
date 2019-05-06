public class RIONode
   implements RecursiveIONode
{
   private String string;
   private RecursiveIONode next;
   
   public RIONode(String element, Node node)
   {
      this.string = element;
      this.next = node;
   }
   
   public String getString()
   {
      return this.string;
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
