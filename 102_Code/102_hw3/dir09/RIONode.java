public class RIONode
   implements RecursiveIONode
{
   private String string;
   private RecursiveIONode next;

   public RIONode(String string, RecursiveIONode next)
   {
      this.string = string;
      this.next = next;
   }

   public String getString()
   {
      return string;
   }

   public RecursiveIONode getNext()
   {
      return next;
   }
	
	public void setNext(RecursiveIONode n)
	{
	   next = n;
	}
}

