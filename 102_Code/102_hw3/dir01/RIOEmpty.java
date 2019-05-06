
public class RIOEmpty implements RecursiveIONode {

	@Override
	public String str() {throw new UnsupportedOperationException();}
	public RecursiveIONode next() {throw new IndexOutOfBoundsException();}
	public void setNext(RecursiveIONode n) {throw new UnsupportedOperationException();}

}
