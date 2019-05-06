
public class RecursiveOOStringList implements StringList {
	RecursiveOONode node;
	
	public RecursiveOOStringList() {
		node = new ROOEmpty();
	}
	
	private RecursiveOOStringList(RecursiveOONode node) {
		this.node = node;
	}

	public void addToEnd(String element) {
		node = node.addToEnd(element);
	}

	public void add(int index, String element) {
		node.add(index, element);
	}

	public String remove(int index) {
		String temp = node.get(index);
		node = node.remove(index);
		return temp;
	}

	public String get(int index) {
		return node.get(index);
	}

	public int indexOf(String element) {
		return node.indexOf(element);
	}

	public int size() {
		return node.size();
	}

	public StringList toLowerCase() {
		return new RecursiveOOStringList(node.nextToLowerCase());
	}

	public StringList toUpperCase() {
		return new RecursiveOOStringList(node.nextToUpperCase());
	}

	public StringList startsWith(String prefix) {
		return new RecursiveOOStringList(node.nextStartsWith(prefix));
	}

	public StringList hasSubstring(String substring) {
		return new RecursiveOOStringList(node.nextHasSubstring(substring));
	}

}
