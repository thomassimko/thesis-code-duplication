
public interface RecursiveOONode{
	String getString();
	void setNext(RecursiveOONode node);
	RecursiveOONode getNext();
	ROONode addToEnd(String element);
	void add(int index, String element);
	RecursiveOONode nextToLowerCase();
	RecursiveOONode nextToUpperCase();
	RecursiveOONode nextStartsWith(String prefix);
	RecursiveOONode nextHasSubstring(String substring);
	RecursiveOONode remove(int i);
	String get(int i);
	int indexOf(String element);
	int size();
}
