
public class IterativeNode {
	private String message;
	private IterativeNode next;

	public IterativeNode(String message, IterativeNode next)
	{
		this.message = message;
		this.next = next;
	}

	public String getStr()
	{
		return this.message;
	}

	public IterativeNode getNext()
	{
		return this.next;
	}

	public void setNext (IterativeNode n)
	{
		this.next = n;
	}
}
