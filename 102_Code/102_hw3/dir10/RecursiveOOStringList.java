
public class RecursiveOOStringList implements StringList {
	private RecursiveOONode head;
	
	public RecursiveOOStringList() {
		head = new ROOEmpty();
	}
	
	public void addToEnd (String element) {
		head = head.addToEnd(element);
	}
	public void add (int index, String element) {
		if (index < 0) {
			throw new IndexOutOfBoundsException();
		}
		else {
		head = head.add(index, element);
		}
	}
	public String remove (int index) {
		String str = get(index);
		head = head.remove(index);
		return str;
	}
	public String get(int index) {
		return head.get(index);
	}
	public int size () {
		return head.size();
	}

	@Override
	public int indexOf(String element) {
		return head.indexOf(element);
	}

	@Override
	public RecursiveOOStringList toLowerCase() {
		return head.toLowerCase();
	}

	@Override
	public RecursiveOOStringList toUpperCase() {
		return head.toUpperCase();
	}

	@Override
	public RecursiveOOStringList startsWith(String prefix) {
		return head.startsWith(prefix);
	}

	@Override
	public RecursiveOOStringList hasSubstring(String substring) {
		return head.hasSubstring(substring);
	}
}
