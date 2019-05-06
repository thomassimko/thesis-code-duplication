
public class RIONode 
	implements RecursiveIONode
{
	private String value;
	private RecursiveIONode next;
	
	public RIONode(String value,RecursiveIONode next )
	{
		this.value = value;
		this.next = next;
	}


	
	public void setNext(RecursiveIONode n) 
	{
		next = n;
		
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public RecursiveIONode getNext() {
		// TODO Auto-generated method stub
		return next;
	}

	

}
