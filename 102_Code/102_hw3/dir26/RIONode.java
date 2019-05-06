public class RIONode implements RecursiveIONode {
	
	private String value;
	private RecursiveIONode next;
	
	public RIONode(String value){
		this.value=value;
		next=new RIOEmpty();
	}
	
	public RIONode(String value, RecursiveIONode next){
		this.value=value;
		this.next=next;
	}
	@Override
	public RecursiveIONode getNext() {
		return next;
	}

	@Override
	public void setNext(RecursiveIONode next) {
		this.next=next;
	}

	@Override
	public void setValue(String value) {
		this.value=value;
	}

	@Override
	public String getValue() {
		return value;
	}
	
}
