
public class RIONode implements RecursiveIONode {
	private String str;
	private RecursiveIONode next;
	
	public RIONode (String str, RecursiveIONode next) {
		this.str = str;
		this.next = next;
	}
	@Override
	public String getString() {
		return str;
	}

	@Override
	public RecursiveIONode getNext() {
		return next;
	}
	
	public void setNext(RecursiveIONode n){
		this.next = n;
	}
}
