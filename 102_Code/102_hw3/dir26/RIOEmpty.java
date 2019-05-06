public class RIOEmpty implements RecursiveIONode {

	@Override
	public RecursiveIONode getNext() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setNext(RecursiveIONode next) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setValue(String value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getValue() {
		throw new UnsupportedOperationException();
	}
	
}
