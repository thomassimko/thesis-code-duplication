public class RIOEmpty implements RecursiveIONode{

	private String string;
	private RecursiveIONode next;
	
	public RIOEmpty(){
		this.string = null;
		this.next = null;
	}
	
	public String getString() {
		return string;
	}

	public RecursiveIONode getNext() {
		return next;
	}

}