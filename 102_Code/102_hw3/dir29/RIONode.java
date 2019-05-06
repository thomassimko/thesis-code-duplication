
public class RIONode implements RecursiveIONode {
	private String string;
    private RecursiveIONode next;
    
    public RIONode(String string, RecursiveIONode next){
         this.string = string;
         this.next = next;
    }

    @Override
	public void setString(String string) {
		this.string = string;
	}

	@Override
	public String getString() {
		return this.string;
	}

	@Override
	public void setNext(RecursiveIONode next) {
		this.next = next;
	}

	@Override
	public RecursiveIONode getNext() {
		return this.next;
	}


}
