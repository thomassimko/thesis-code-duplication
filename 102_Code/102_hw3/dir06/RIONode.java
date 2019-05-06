
public class RIONode implements RecursiveIONode 
{

	String string;
	RecursiveIONode next;
	
	public RIONode(String string, RecursiveIONode next)
	{
		this.string = string;
		this.next = next;
	}
	
	public String getString()
	{
		return string;
	}

	
	public RecursiveIONode getNext() 
	{
		return next;
	}
	
	
	public void setString(String string) 
	{
		this.string = string;
	}

	
	public void setNext(RecursiveIONode next) 
	{
		this.next = next;
	}

}
