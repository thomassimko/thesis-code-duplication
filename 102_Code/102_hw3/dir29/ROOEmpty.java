
public class ROOEmpty implements RecursiveOONode {
	@Override
	public void setString(String string) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getString() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setNext(RecursiveOONode next) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public RecursiveOONode getNext() {
		throw new UnsupportedOperationException();
	}

	@Override
	public RecursiveOONode addToEnd(String element) {
		return new ROONode(element,this);
	}

	@Override
	public void add(int index, String element) {
		throw new IndexOutOfBoundsException();
	}

	@Override
	public void remove(int index) {
		throw new IndexOutOfBoundsException();
	}

	@Override
	public String get(int index) {
		throw new IndexOutOfBoundsException();
	}

	@Override
	public int indexOf(String element) {
		return -1;
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public RecursiveOONode toLowerCase() {
		return new ROOEmpty();
	}

	@Override
	public RecursiveOONode toUpperCase() {
		return new ROOEmpty();
	}

	@Override
	public RecursiveOONode startsWith(String prefix) {
		return new ROOEmpty();
	}

	@Override
	public RecursiveOONode hasSubstring(String substring) {
		return new ROOEmpty();
	}
}
