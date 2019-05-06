
public class ROONode implements RecursiveOONode {
	private String str;
	private RecursiveOONode next;
	
	public ROONode(String str, RecursiveOONode next){
		this.str = str;
		this.next = next;
	}
	
	@Override
	public String getString() {
		return str;
	}

	@Override
	public RecursiveOONode getNext() {
		return next;
	}
	
	
	@Override
	public RecursiveOONode addToEnd(String element) {
		RecursiveOONode n = next.addToEnd(element);
		next = n;
		return this;
	}

	@Override
	public RecursiveOONode add(int index, String element) {
		if (index == 0) {
			RecursiveOONode n = new ROONode(element, this);
			return n;
		}
		else {
			next = next.add(index - 1, element);
			return this;
		}
	}

	@Override
	public RecursiveOONode remove(int index) {
		if (index == 0) {
			return this.next;
		}
		else if (index < 0) {
			throw new IndexOutOfBoundsException();
		}
		else {
			next = next.remove(index - 1);
			return this;
		}
	}

	@Override
	public String get(int index) {
		if (index < 0) {
			throw new IndexOutOfBoundsException();
		}
		else if (index == 0) {
			return this.getString();
		}
		else {
			return next.get(index - 1);
		}
	}

	@Override
	public int indexOf(String element) {
		if (this.getString() == element) {
			return 0;
		}
		else {
			return  1 + next.indexOf(element);
		}
	}

	@Override
	public int size() {
		return 1 + next.size();
	}

	@Override
	public RecursiveOOStringList toLowerCase() {
		RecursiveOOStringList newList = next.toLowerCase();
		newList.add(0, this.getString().toLowerCase());
		return newList;
	}

	@Override
	public RecursiveOOStringList toUpperCase() {
		RecursiveOOStringList newList = next.toUpperCase();
		newList.add(0, this.getString().toUpperCase());
		return newList;
	}

	@Override
	public RecursiveOOStringList startsWith(String prefix) {
		RecursiveOOStringList newList = next.startsWith(prefix);
		if (this.getString().startsWith(prefix) == true) {
			newList.add(0, this.getString());
		}
		return newList;
	}

	@Override
	public RecursiveOOStringList hasSubstring(String substring) {
		RecursiveOOStringList newList = next.hasSubstring(substring);
		if (this.getString().indexOf(substring) > 0) {
			newList.add(0, this.getString());
		}
		return newList;
	}

}
