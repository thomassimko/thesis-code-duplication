public class RIONode
  implements RecursiveIONode
{
  private String string;
  private RecursiveIONode next;

  public RIONode(RecursiveIONode next, String string)
  {
    this.string = string;
    this.next = next;
  }

  public RecursiveIONode getNext()
  {
    return next;
  }

  public String getString()
  {
    return string;
  }

  public void setNext(RecursiveIONode next)
  {
    this.next = next;
  }
}
