
public class IterativeNode {
	String str;
	IterativeNode next;
	
	public IterativeNode(String str, IterativeNode next) {
		this.str = str;
		this.next = next;
	}

	public IterativeNode getNext() {
		return next;
	}

	public void setNext(IterativeNode next) {
		this.next = next;
	}

	public String getString() {
		return str;
	}

}
