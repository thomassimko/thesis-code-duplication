
public class RIOEmpty 
   implements RecursiveIONode 
{
   public RIOEmpty()
   {
   }

   public String getElement()
   {
      throw new UnsupportedOperationException();
   }

   public RecursiveIONode getNext()
   {
      throw new UnsupportedOperationException();
   }

   public void setNext(RecursiveIONode n)
   {
      throw new UnsupportedOperationException();
   }
}
