public class RIONode implements RecursiveIONode{
	private String value;
	private RecursiveIONode nextLink;
	public RIONode(String val){
		value=val;
		nextLink=new RIOEmpty();
	}
	public void linkNext(RecursiveIONode r){
		nextLink=r;
	}
	public RecursiveIONode next(){
		return nextLink;
	}
	public String getVal(){
		return value;
	}
}