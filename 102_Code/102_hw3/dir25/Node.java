
public class Node {
	private String val;
	private Node next;
	public Node ( String val, Node next)
	{
		this.val = val;
		this.next = next;
	}
	
	public String getValue()
	{
		return val;
	}
	public Node getNext()
	{
		return next;
	}
	public void setNext(Node n)
	{
		this.next = n;
	}
}
