
public class RIOEmpty implements RecursiveIONode {

	@Override
	public String getString() {
		throw new UnsupportedOperationException();
	}

	@Override
	public RecursiveIONode getNext() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setNext(RecursiveIONode n) {
		throw new UnsupportedOperationException();
	}

	
}
