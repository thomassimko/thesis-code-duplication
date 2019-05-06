//Programmed by Michael Olivarez
public class IterativeNode
{
  private String wrd;
  private IterativeNode next;
  public IterativeNode(String word, IterativeNode next)
  {
    this.wrd = word;
    this.next = next;
  }
  public String getString()
  {
    return wrd;
  }
  public IterativeNode getNext()
  {
    return next;
  }
  public void setNext(IterativeNode n)
  {
    this.next = n;
  }
}
