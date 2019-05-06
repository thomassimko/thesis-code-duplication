
public class ROOEmpty implements RecursiveOONode {

	public ROOEmpty() {
		
	}

	public String getString() {
		throw new UnsupportedOperationException();
	}

	public void setNext(RecursiveOONode node) {
		throw new UnsupportedOperationException();
	}

	public RecursiveOONode getNext() {
		throw new UnsupportedOperationException();
	}

	public ROONode addToEnd(String element) {
		return new ROONode(element, this);
	}

	public void add(int index, String element) {
		throw new UnsupportedOperationException();
		
	}

	public RecursiveOONode remove(int index) {
		throw new UnsupportedOperationException();
	}

	public String get(int index) {
		throw new UnsupportedOperationException();
	}

	public int indexOf(String element) {
		return -1;
	}

	public int size() {
		return 0;
	}

	public RecursiveOONode nextToLowerCase() {
		return this;
	}

	public RecursiveOONode nextToUpperCase() {
		return this;
	}

	public RecursiveOONode nextStartsWith(String prefix) {
		return this;
	}

	public RecursiveOONode nextHasSubstring(String substring) {
		return this;
	}

}
