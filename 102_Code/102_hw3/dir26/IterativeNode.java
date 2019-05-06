
public class IterativeNode {
	
	private String node;
	private IterativeNode next;
	
	public IterativeNode(String node){
		this.node=node;
	}
	public IterativeNode(String node, IterativeNode next){
		this.node=node;
		this.next=next;
	}
	public IterativeNode getNext(){
		return next;
	}
	public String getNode(){
		return node;
	}
	public void setNext(IterativeNode next){
		this.next=next;
	}
}