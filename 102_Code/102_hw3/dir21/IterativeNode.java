public class IterativeNode{
	private String s;
	private IterativeNode next;
	
	public IterativeNode(String val){
		s=val;
	}
	public void linkNext(IterativeNode n){
		next=n;
	}
	public IterativeNode next(){
		return next;
	}
	public String getVal(){
		return s;
	}
	public void setVal(String str){
		s=str;
	}
}