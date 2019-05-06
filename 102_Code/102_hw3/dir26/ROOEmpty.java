
public class ROOEmpty implements RecursiveOONode {

	@Override
	public String getValue() {
		throw new UnsupportedOperationException();
	}

	@Override
	public RecursiveOONode getNext() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setNext(RecursiveOONode next) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setValue(String value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public RecursiveOONode addToEnd(String element) {
		return new ROONode(element,this);
	}

	@Override
	public RecursiveOONode add(int index, String element) {
		if(index==0)
			return new ROONode(element,this);
		throw new IndexOutOfBoundsException();
	}

	@Override
	public RecursiveOONode remove(int index) {
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
		return this;
	}

	@Override
	public RecursiveOONode toUpperCase() {
		return this;
	}

	@Override
	public RecursiveOONode startsWith(String prefix) {
		return this;
	}

	@Override
	public RecursiveOONode hasSubstring(String substring) {
		return this;
	}

}
