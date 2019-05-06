public class IterativeNode
{
  private IterativeNode next;
  private String str;

  public IterativeNode()
  {
    this.next = null;
    this.str = "";
  }

  public IterativeNode(String str, IterativeNode next)
  {
    this.next = next;
    this.str = str;
  }

  public IterativeNode getNext()
  {
    return this.next;
  }

  public String getString()
  {
    return this.str;
  }

  public void setNext(IterativeNode next)
  {
    this.next = next;
  }
}
