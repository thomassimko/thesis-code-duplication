
public class ROONode implements RecursiveOONode {
	private String string;
	private RecursiveOONode next;
	
	public ROONode(String element, RecursiveOONode node) {
		string = element;
		next = node;
	}

	public String getString() {
		return null;
	}

	public void setNext(RecursiveOONode node) {
		next = node;
	}

	public RecursiveOONode getNext() {
		return next;
	}

	public ROONode addToEnd(String element) {
			next = next.addToEnd(element);
			return this;
	}

	public void add(int index, String element) {
		if (index > size() || index < 0)
			throw new IndexOutOfBoundsException();
		else if (index == 1)
			next = new ROONode(element, next);
		else
			next.add(--index, element);
	}

	public RecursiveOONode remove(int index) {
		if (index > size() || index < 0)
			throw new IndexOutOfBoundsException();
		else if (index == 0)
			return next;
		else if (index == 1) {
			next = next.getNext();
			return this;
		}
		else {
			next = next.remove(--index);
			return this;
		}
	}

	public String get(int index) {
		if (index >= size() || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		else if (index == 0) {
			return string;
		}
		else
			return next.get(--index);
	}

	public int indexOf(String element) {
		if (string.equals(element))
			return 0;
		else {
			int i = next.indexOf(element);
			return (i == -1) ? -1 : i + 1;
		}
	}

	public int size() {
		return 1 + next.size();
	}
	
	public RecursiveOONode nextToLowerCase() {
		return new ROONode(string.toLowerCase(), next.nextToLowerCase());
	}
	
	public RecursiveOONode nextToUpperCase() {
		return new ROONode(string.toUpperCase(), next.nextToUpperCase());
	}
	
	public RecursiveOONode nextStartsWith(String prefix) {
		if (string.startsWith(prefix))
			return new ROONode(string, next.nextStartsWith(prefix));
		else
			return next.nextStartsWith(prefix);
	}
	
	public RecursiveOONode nextHasSubstring(String substring) {
		if (string.contains(substring))
			return new ROONode(string, next.nextHasSubstring(substring));
		else
			return next.nextHasSubstring(substring);
	}

}
