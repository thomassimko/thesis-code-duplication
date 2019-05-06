
public class Node {
	public String val;
	public Node next;
	public Node (String value, Node nextNode)
	{
		val=value;
		next= nextNode;
	}
	public String getValue()
	{
		return val;
	}
	public Node next()
	{
		return next;
	}
	public void setNext(Node n)
	{
		next=n;
	}
}
