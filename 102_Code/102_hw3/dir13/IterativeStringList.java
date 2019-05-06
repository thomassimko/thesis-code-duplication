
public class IterativeStringList implements StringList {
	private IterativeNode node;
	
	public IterativeStringList() {
		node = null;
	}
	
	private IterativeStringList(IterativeNode node) {
		this.node = node;
	}

	public void addToEnd(String element) {
		IterativeNode temp = node;
		if (node == null) {
			node = new IterativeNode(element, null);
		} else {
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(new IterativeNode(element, null));
		}
	}

	public void add(int index, String element) {
		IterativeNode temp1 = node;
		IterativeNode temp2 = node.getNext();
		if (index >= size()|| index < 0) {
			throw new IndexOutOfBoundsException();
		} else if (index == 0) {
			node = new IterativeNode(element, node);
		} else {
			int i = 1;
			while (i < index-1) {
				temp1 = temp1.getNext();
				temp2 = temp2.getNext();
				i++;
			}
			temp2 = new IterativeNode(element, new IterativeNode(temp2.getString(),temp2.getNext()));
			temp1.setNext(temp2);
		}
		
	}

	public String remove(int index) {
		IterativeNode temp1 = node;
		IterativeNode temp2 = node.getNext();
		String returnString;
		if (index >= size()|| index < 0) {
			throw new IndexOutOfBoundsException();
		} else if (index == 0) {
			returnString = node.getString();
			node = node.getNext();
			return returnString;
		} else {
			int i = 0;
			while (i < index-1) {
				temp1 = temp1.getNext();
				temp2 = temp2.getNext();
				i++;
			}
			returnString = temp2.getString();
			temp1.setNext(temp2.getNext());
			return returnString;
		}
	}

	public String get(int index) {
		IterativeNode temp = node;
		if (index >= size()|| index < 0) {
			throw new IndexOutOfBoundsException();
		} else if (index == 0) {
			return node.getString();
		} else {
			int i = 0;
			while (i < index) {
				temp = temp.getNext();
				i++;
			}
			return temp.getString();
		}
	}

	public int indexOf(String element) {
		IterativeNode temp = node;
		if (node.getString().equals(element)) {
			return 0;
		} else {
			int i = 0;
			while (i < size() && !temp.getString().equals(element)) {
				temp = temp.getNext();
				i++;
			}
			return (i == size()) ? -1 : i;
		}
	}

	public int size() {
		int i = 1;
		IterativeNode temp = node;
		if (node == null) {
			return 0;
		} else {
			while (temp.getNext() != null) {
				temp = temp.getNext();
				i++;
			}
			return i;
		}
	}

	public StringList toLowerCase() {
		IterativeNode returnNode = null;
		IterativeNode returnNodeTemp = returnNode;
		IterativeNode temp = node;
		if (node == null) {
			return new IterativeStringList();
		} else {
			int i = 0;
			while (i < size()) {
				if (returnNode == null) {
					returnNode = new IterativeNode(temp.getString().toLowerCase(), null);
					returnNodeTemp = returnNode;
				} else {
					returnNodeTemp.setNext(new IterativeNode(temp.getString().toLowerCase(), null));
					returnNodeTemp = returnNodeTemp.getNext();
				}
				temp = temp.getNext();
				i++;
			}
			return new IterativeStringList(returnNode);
		}
	}

	public StringList toUpperCase() {
		IterativeNode returnNode = null;
		IterativeNode returnNodeTemp = returnNode;
		IterativeNode temp = node;
		if (node == null) {
			return new IterativeStringList();
		} else {
			int i = 0;
			while (i < size()) {
				if (returnNode == null) {
					returnNode = new IterativeNode(temp.getString().toUpperCase(), null);
					returnNodeTemp = returnNode;
				} else {
					returnNodeTemp.setNext(new IterativeNode(temp.getString().toUpperCase(), null));
					returnNodeTemp = returnNodeTemp.getNext();
				}
				temp = temp.getNext();
				i++;
			}
			return new IterativeStringList(returnNode);
		}
	}

	public StringList startsWith(String prefix) {
		IterativeNode returnNode = null;
		IterativeNode returnNodeTemp = returnNode;
		IterativeNode temp = node;
		if (node == null) {
			return new IterativeStringList();
		} else {
			int i = 0;
			while (i < size()) {
				if (temp.getString().startsWith(prefix))
					if (returnNode == null) {
						returnNode = new IterativeNode(temp.getString(), null);
						returnNodeTemp = returnNode;
					} else {
						returnNodeTemp.setNext(new IterativeNode(temp.getString(), null));
						returnNodeTemp = returnNodeTemp.getNext();
					}
				temp = temp.getNext();
				i++;
			}
			return new IterativeStringList(returnNode);
		}
	}

	public StringList hasSubstring(String substring) {
		IterativeNode returnNode = null;
		IterativeNode returnNodeTemp = returnNode;
		IterativeNode temp = node;
		if (node == null) {
			return new IterativeStringList();
		} else {
			int i = 0;
			while (i < size()) {
				if (temp.getString().contains(substring))
					if (returnNode == null) {
						returnNode = new IterativeNode(temp.getString(), null);
						returnNodeTemp = returnNode;
					} else {
						returnNodeTemp.setNext(new IterativeNode(temp.getString(), null));
						returnNodeTemp = returnNodeTemp.getNext();
					}
				temp = temp.getNext();
				i++;
			}
			return new IterativeStringList(returnNode);
		}
	}

}
