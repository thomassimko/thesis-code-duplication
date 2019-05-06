
public class RecursiveIOStringList implements StringList {
	private RecursiveIONode node;
	
	public RecursiveIOStringList() {
		node = new RIOEmpty();
	}
	
	private RecursiveIOStringList(RecursiveIONode node) {
		this.node = node;
	}

	public void addToEnd(String element) {
		node = nextAddToEnd(node, element);
	}
	
	private static RecursiveIONode nextAddToEnd(RecursiveIONode node, String element) {
		if (node instanceof RIOEmpty) {
			node = new RIONode(element, node);
		} else {
			node.setNext(nextAddToEnd(node.getNext(), element));
		}
		return node;
	}

	public void add(int index, String element) {
		if (index > size() || index < 0)
			throw new IndexOutOfBoundsException();
		nextAdd(node, index, element);
	}
	
	private static RecursiveIONode nextAdd(RecursiveIONode node, int index, String element) {
		if (index == 0) {
			node = new RIONode(element, node);
		} else {
			node.setNext(nextAdd(node.getNext(), --index, element));
		}
		return node;
	}

	public String remove(int index) {
		String returnString;
		if (index > size() || index < 0)
			throw new IndexOutOfBoundsException();
		returnString = get(index);
		node = nextRemove(node, index);
		return returnString;
	}
	
	private RecursiveIONode nextRemove(RecursiveIONode node, int index) {
		if (index == 0) {
			node = node.getNext();
		} else {
			node.setNext(nextRemove(node.getNext(), --index));
		}
		return node;
	}

	public String get(int index) {
		if (index > size() || index < 0)
			throw new IndexOutOfBoundsException();
		if (index == 0) {
			return node.getString();
		} else {
			return (new RecursiveIOStringList(node.getNext())).get(--index);
		}
	}
	

	public int indexOf(String element) {
		if (node instanceof RIOEmpty)
			return -1;
		if (node.getString().equals(element)) {
			return 0;
		} else {
			int i = (new RecursiveIOStringList(node.getNext())).indexOf(element);
			return (i == -1) ? -1 : i + 1;
		}
	}

	public int size() {
		if (node instanceof RIOEmpty) {
			return 0;
		} else {
			return 1 + (new RecursiveIOStringList(node.getNext())).size();
		}
	}

	public StringList toLowerCase() {
		return new RecursiveIOStringList(NextLowerCase(node));
	}
	
	private RecursiveIONode NextLowerCase(RecursiveIONode node) {
		RecursiveIONode temp;
		if (node.getNext() instanceof RIONode) {
			 temp = new RIONode(node.getString().toLowerCase(), NextLowerCase(node.getNext()));
		} else {
			temp = new RIONode(node.getString().toLowerCase(), new RIOEmpty());
		}
		return temp;
	}

	public StringList toUpperCase() {
		return new RecursiveIOStringList(NextUpperCase(node));
	}
	
	private RecursiveIONode NextUpperCase(RecursiveIONode node) {
		RecursiveIONode temp;
		if (node.getNext() instanceof RIONode) {
			 temp = new RIONode(node.getString().toUpperCase(), NextUpperCase(node.getNext()));
		} else {
			temp = new RIONode(node.getString().toUpperCase(), new RIOEmpty());
		}
		return temp;
	}

	public StringList startsWith(String prefix) {
		return new RecursiveIOStringList(NextStartsWith(node, prefix));
	}
	
	private RecursiveIONode NextStartsWith(RecursiveIONode node, String prefix) {
		RecursiveIONode temp = new RIOEmpty();
		if (node.getString().startsWith(prefix) && node.getNext() instanceof RIONode) {
			temp = new RIONode(node.getString(), NextStartsWith(node.getNext(), prefix));
		} else if (node.getString().contains(prefix)) {
			temp = new RIONode(node.getString(), new RIOEmpty());
		} else {
			NextStartsWith(node.getNext(), prefix);
		}
		return temp;
	}

	public StringList hasSubstring(String substring) {
		return new RecursiveIOStringList(NextHasSubstring(node, substring));
	}
	
	private RecursiveIONode NextHasSubstring(RecursiveIONode node, String substring) {
		RecursiveIONode temp = new RIOEmpty();
		if (node instanceof RIONode && node.getNext() instanceof RIONode && node.getString().contains(substring)) {
				temp = new RIONode(node.getString(), NextHasSubstring(node.getNext(), substring));
		} else if (node instanceof RIONode && node.getString().contains(substring)) {
				temp = new RIONode(node.getString(), new RIOEmpty());
		} else if (node instanceof RIONode) {
			return NextHasSubstring(node.getNext(), substring);
		}
		return temp;
	}

}
