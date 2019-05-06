
public class RIONode implements RecursiveIONode{

	
	private String string;
	private RecursiveIONode next;
		
	public RIONode(String word, RecursiveIONode give){
		this.string = word;
		this.next = give;
	}
	
	public String getString() {
		return string;
	}

	public RecursiveIONode getNext() {
		return next;
	}
}
