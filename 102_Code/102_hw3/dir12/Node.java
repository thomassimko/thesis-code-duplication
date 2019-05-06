public interface Node {

	String getString();
	
	Node getNext();
	
	void setNext(Node n);
	
	Node addToEnd(String element);

	void add(String element);

	String remove(int index);
		
	String get(int index);
	
	int indexOf(String element);

	int size();
	
	StringList toLowerCase();
	
	StringList toUpperCase();

	StringList startsWith(String prefix);

	StringList hasSubstring(String substring);
}
