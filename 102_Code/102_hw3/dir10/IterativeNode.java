
public class IterativeNode {
	private String str;
	private IterativeNode next;
	
	public IterativeNode(String str, IterativeNode next){
		this.str = str;
		this.next = next;
	}
	public String getString(){
		return str;
	}
	public IterativeNode getNext(){
		return next;
	}
	public void setNext(IterativeNode n){
		this.next = n;
	}
}
