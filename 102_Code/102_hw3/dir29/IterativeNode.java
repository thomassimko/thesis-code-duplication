public class IterativeNode {
	private String string;
    private IterativeNode next;
    
    public IterativeNode(String string, IterativeNode next){
         this.string = string;
         this.next = next;
    }

	public void setString(String string) {
		this.string = string;
	}

	public String getString() {
		return this.string;
	}

	public void setNext(IterativeNode next) {
		this.next = next;
		
	}

	public IterativeNode getNext() {
		return this.next;
	}
}
