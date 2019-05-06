
public class RIONode implements RecursiveIONode {
	
	private String element;
	private RecursiveIONode next;
	
	public RIONode(String element, RecursiveIONode next) {
		this.element = element;
		this.next = next;
}

	@Override
	public String getElement() {
		// TODO Auto-generated method stub
		return element;
	}

	@Override
	public RecursiveIONode getNode() {
		// TODO Auto-generated method stub
		return next;
	}

	@Override
	public void setNext(RecursiveIONode n) {
		// TODO Auto-generated method stub
		this.next = n;
	}
}