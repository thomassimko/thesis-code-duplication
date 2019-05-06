
public class IterativeNode{
	
	private String word;
	private IterativeNode next;
	
	public IterativeNode(String word, IterativeNode n){
		this.word = word;
		this.next = n;
	}
	
	public String getString(){
		return word;
	}
	
	public IterativeNode getNext(){
		return next;
	}

	public void setNext(IterativeNode n) {
		this.next = n;
	}

	public void setString(String string){
		this.word = string;
	}
}

