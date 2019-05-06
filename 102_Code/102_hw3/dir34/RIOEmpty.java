import java.*;

public class RIOEmpty
   implements RecursiveIONode
{
   public RecursiveIONode getNext()
   {
      throw new IndexOutOfBoundsException();
   }

   public String getString()
   {
      throw new UnsupportedOperationException();
   }

   public void setNext(RecursiveIONode node)
   {
      throw new UnsupportedOperationException();
   }
}
