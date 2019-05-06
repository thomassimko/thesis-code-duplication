//Programmed by Michael Olivarez
public class RI0Node implements RecursiveI0Node
{
  private String str;
  private RecursiveI0Node next;
  public RI0Node(String element, RecursiveI0Node nod)
  {
    this.str = element;
    this.next = nod;
  }
  public String getString()
  {
    return this.str;
  }
  public RecursiveI0Node getNext()
  {
    return this.next;
  }
  public void setNext(RecursiveI0Node n)
  {
    this.next = n;
  }
}
