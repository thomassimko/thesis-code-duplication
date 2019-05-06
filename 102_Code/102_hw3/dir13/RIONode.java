
public class RIONode implements RecursiveIONode {
	private String str;
	private RecursiveIONode next;
	
	public RIONode(String str, RecursiveIONode node) {
		this.str = str;
		next = node;
	}

	public String getString() {
		return str;
	}

	public void setNext(RecursiveIONode node) {
		next = node;
	}

	public RecursiveIONode getNext() {
		return next;
	}

}
