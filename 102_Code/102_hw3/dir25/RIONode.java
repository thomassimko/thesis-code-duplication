
public class RIONode implements RIO {
	String value;
	RIO next;
	public RIONode(String value, RIO next)
	{
		this.value = value;
		this.next = next;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public RIO getNext() {
		// TODO Auto-generated method stub
		return next;
	}

	@Override
	public void setNext(RIO n) {
		// TODO Auto-generated method stub
		next = n;
	}

}
