import java.lang.UnsupportedOperationException;

public class RIOEmpty
   implements RecursiveIONode
{
   public String getString()
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
