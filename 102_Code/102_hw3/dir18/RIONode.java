public class RIONode
    implements RecursiveIONode
{
    private String str;
    private RecursiveIONode next;
    public RIONode(String str, RecursiveIONode next)
    {
	this.str = str;
	this.next = next;
    }
    public String getString()
    {
	return str;
    }
    public RecursiveIONode getNext()
    {
	return next;
    }
    public void setNext(RecursiveIONode next)
    {
	this.next = next;
    }

}